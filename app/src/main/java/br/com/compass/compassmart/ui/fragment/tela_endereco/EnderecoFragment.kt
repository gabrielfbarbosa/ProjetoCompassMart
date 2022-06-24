package br.com.compass.compassmart.ui.fragment.tela_endereco

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import br.com.compass.compassmart.R
import br.com.compass.compassmart.databinding.FragmentEnderecoBinding

class EnderecoFragment : Fragment() {

    private var _binding: FragmentEnderecoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentEnderecoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fragmentEnderecoEdtxtLogradouro.requestFocus()

        binding.fragmentEnderecoBtnContinuar.setOnClickListener {

            if (binding.fragmentEnderecoEdtxtLogradouro.editText?.text.toString().isEmpty() ||
                binding.fragmentEnderecoEdtxtCep.editText?.text.toString().isEmpty() ||
                binding.fragmentEnderecoEdtxtNumero.editText?.text.toString().isEmpty() ||
                binding.fragmentEnderecoEdtxtBairro.editText?.text.toString().isEmpty() ||
                binding.fragmentEnderecoEdtxtCidade.editText?.text.toString().isEmpty() ||
                binding.fragmentEnderecoEdtxtUf.editText?.text.toString().isEmpty()
            ) {
                Toast.makeText(requireActivity(), "Preencha todos os campos!", Toast.LENGTH_SHORT)
                    .show()
            } else {
                NavHostFragment.findNavController(this@EnderecoFragment)
                    .navigate(R.id.action_enderecoFragment_to_meioPagamento)
            }
        }
    }
}
