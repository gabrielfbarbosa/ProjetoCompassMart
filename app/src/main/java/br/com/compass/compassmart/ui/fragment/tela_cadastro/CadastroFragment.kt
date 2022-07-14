package br.com.compass.compassmart.ui.fragment.tela_cadastro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import br.com.compass.compassmart.R
import br.com.compass.compassmart.databinding.FragmentCadastroBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class CadastroFragment : Fragment() {
    private var _binding: FragmentCadastroBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentCadastroBinding.inflate(inflater, container, false)
        val view = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_nav)
        view.visibility = View.GONE
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fragmentCadastroTxtInputNome.requestFocus()

        binding.fragmentCadastroBtnCadastrar.setOnClickListener {
            if (binding.fragmentCadastroTxtInputNome.editText?.text.toString().isEmpty() ||
                binding.fragmentCadastroTxtInputEmail.editText?.text.toString().isEmpty() ||
                binding.fragmentCadastroTxtInputSenha.editText?.text.toString().isEmpty() ||
                binding.fragmentCadastroTxtInputConfirmaSenha.editText?.text.toString().isEmpty()
            ) {
                Toast.makeText(requireActivity(), "Preencha todos os campos!", Toast.LENGTH_SHORT)
                    .show()

            } else {
                if (binding.fragmentCadastroTxtInputSenha.editText?.text.toString() ==
                    binding.fragmentCadastroTxtInputConfirmaSenha.editText?.text.toString()
                ) {
                    // TODO: Cadastra usuário
                    Toast.makeText(requireActivity(), "Cadastrado com sucesso.", Toast.LENGTH_SHORT)
                        .show()
                    NavHostFragment.findNavController(this@CadastroFragment)
                        .navigate(R.id.action_cadastroFragment_to_loginFragment)
                } else {
                    // TODO: Ambos os TextInput ficam vermelho e mostra mensagem de erro embaixo dele
                    Toast.makeText(requireActivity(),
                        "As senhas não são iguais",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.fragmentCadastroTxtLogin.setOnClickListener {
            NavHostFragment.findNavController(this@CadastroFragment)
                .navigate(R.id.action_cadastroFragment_to_loginFragment)
        }
    }
}