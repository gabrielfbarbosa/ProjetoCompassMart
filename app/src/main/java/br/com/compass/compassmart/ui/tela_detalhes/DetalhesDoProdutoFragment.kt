package br.com.compass.compassmart.ui.tela_detalhes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.compass.compassmart.R
import br.com.compass.compassmart.databinding.FragmentCarrinhoComprasBinding
import br.com.compass.compassmart.databinding.FragmentDetalhesDoProdutoBinding
import br.com.compass.compassmart.ui.carrinhocompras.CarrinhoCompraAdapter
import br.com.compass.compassmart.ui.carrinhocompras.model.Produtos

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