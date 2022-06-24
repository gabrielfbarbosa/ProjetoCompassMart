package br.com.compass.compassmart.ui.fragment.tela_login

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import br.com.compass.compassmart.R
import br.com.compass.compassmart.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val preferenceLoginKey = "chaveLogin"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fragmentLoginEdtxtEmail.requestFocus()

        binding.fragmentLoginBtnLogin.setOnClickListener{

            if (binding.fragmentLoginEdtxtEmail.editText?.text.toString().isEmpty() ||
                binding.fragmentLoginEdtxtSenha.editText?.text.toString().isEmpty()) {
                Toast.makeText(requireActivity(), "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            }
            else {
                val sharedPreferences = requireActivity().getSharedPreferences(preferenceLoginKey, MODE_PRIVATE)
                val editor : SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString(preferenceLoginKey, binding.fragmentLoginEdtxtEmail.editText?.text.toString())
                editor.putString(preferenceLoginKey, binding.fragmentLoginEdtxtSenha.editText?.text.toString())
                editor.apply()
                NavHostFragment.findNavController(this@LoginFragment)
                    .navigate(R.id.action_loginFragment_to_carrinhoComprasFragment)
            }
        }

       binding.fragmentLoginTxtCadastro.setOnClickListener{
             NavHostFragment.findNavController(this@LoginFragment)
                 .navigate(R.id.action_LoginFragment_to_CadastroFragment)
       }
    }
}
