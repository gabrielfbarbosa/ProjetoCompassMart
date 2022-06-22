package br.com.compass.compassmart.ui.fragment.tela_cadastro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import br.com.compass.compassmart.R
import br.com.compass.compassmart.databinding.FragmentCadastroBinding

class CadastroFragment : Fragment() {
    private var _binding: FragmentCadastroBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCadastroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fragmentCadastroTxtInputNome.requestFocus()

        binding.fragmentCadastroBtnCadastrar.setOnClickListener{
            NavHostFragment.findNavController(this@CadastroFragment)
                .navigate(R.id.action_CadastroFragment_to_CarrinhoComprasFragment)
        }

        binding.fragmentCadastroTxtLogin.setOnClickListener{
            NavHostFragment.findNavController(this@CadastroFragment)
                .navigate(R.id.action_CadastroFragment_to_LoginFragment)
        }
    }
}