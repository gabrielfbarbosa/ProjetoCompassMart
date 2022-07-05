package br.com.compass.compassmart.ui.fragment.tela_login

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import br.com.compass.compassmart.R
import br.com.compass.compassmart.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val preferenceLoginKey = "chaveLogin"
    private val preferenceTokenKey = "token"
    private val viewModel : LoginViewModel by viewModels()

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
            viewModel.validaLogin(binding.fragmentLoginEdtxtEmail.text.toString(), binding.fragmentLoginEdtxtSenha.text.toString())
        }

        viewModel.erroEmail.observe(viewLifecycleOwner) {
            binding.fragmentLoginTextinputlayoutEmail.error = it
        }

        viewModel.erroSenha.observe(viewLifecycleOwner) {
            binding.fragmentLoginTextinputlayoutSenha.error = it
        }

        viewModel.navegueParaCarrinhoCompras.observe(viewLifecycleOwner) {
            val sharedPreferences = requireActivity().getSharedPreferences(preferenceLoginKey, MODE_PRIVATE)
            val editor : SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString(preferenceTokenKey, it)
            editor.apply()

            NavHostFragment.findNavController(this@LoginFragment)
                .navigate(R.id.action_loginFragment_to_carrinhoComprasFragment)
        }
    }
}