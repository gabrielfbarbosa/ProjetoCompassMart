package br.com.compass.compassmart.ui.fragment.tela_detalhesproduto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.compass.compassmart.databinding.FragmentDetalhesDoProdutoBinding

class DetalhesDoProdutoFragment : Fragment() {

    private var _binding: FragmentDetalhesDoProdutoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetalhesDoProdutoBinding.inflate(inflater, container, false)
        return binding.root
    }

}