package br.com.compass.compassmart.ui.fragment.tela_login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import br.com.compass.compassmart.R
import br.com.compass.compassmart.databinding.FragmentLoginBinding
import br.com.compass.compassmart.ui.fragment.util.SharedPreference

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fragmentLoginEdtxtEmail.requestFocus()

        if (SharedPreference(requireContext()).pegarToken().isNullOrBlank()){
            binding.fragmentLoginBtnLogin.setOnClickListener {
                viewModel.validaLogin(binding.fragmentLoginEdtxtEmail.text.toString(),
                    binding.fragmentLoginEdtxtSenha.text.toString())
            }

            viewModel.erroEmail.observe(viewLifecycleOwner) {
                binding.fragmentLoginTextinputlayoutEmail.error = it
            }

            viewModel.erroSenha.observe(viewLifecycleOwner) {
                binding.fragmentLoginTextinputlayoutSenha.error = it
            }

            viewModel.navegueParaCarrinhoCompras.observe(viewLifecycleOwner) {
                SharedPreference(requireContext()).salvaToken(it)
                NavHostFragment.findNavController(this@LoginFragment)
                    .navigate(R.id.action_loginFragment_to_carrinhoComprasFragment)
            }

            viewModel.erroLoginInvalido.observe(viewLifecycleOwner){
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }

            binding.fragmentLoginTxtCadastro.setOnClickListener {
                NavHostFragment.findNavController(this@LoginFragment)
                    .navigate(R.id.action_loginFragment_to_cadastroFragment)
            }
        }else{
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToCarrinhoComprasFragment())
        }
    }
}