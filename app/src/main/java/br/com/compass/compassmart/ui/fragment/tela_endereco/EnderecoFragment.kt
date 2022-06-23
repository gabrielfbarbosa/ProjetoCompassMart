package br.com.compass.compassmart.ui.fragment.tela_endereco

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.compass.compassmart.R
import br.com.compass.compassmart.databinding.FragmentEnderecoBinding
import br.com.compass.compassmart.databinding.FragmentProdutosBinding

class EnderecoFragment : Fragment() {

    private var _binding: FragmentProdutosBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentEnderecoBinding.inflate(inflater, container, false)
        return binding.root
    }
}