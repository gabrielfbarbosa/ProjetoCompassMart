package br.com.compass.compassmart.ui.tela_produtos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.compass.compassmart.R
import br.com.compass.compassmart.databinding.FragmentProdutosBinding

class ProdutosFragment : Fragment() {

    private var _binding: FragmentProdutosBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProdutosBinding.inflate(inflater, container, false)
        return binding.root
    }

}