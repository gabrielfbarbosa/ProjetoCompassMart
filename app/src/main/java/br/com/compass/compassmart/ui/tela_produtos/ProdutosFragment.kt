package br.com.compass.compassmart.ui.tela_produtos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.compass.compassmart.R
import br.com.compass.compassmart.databinding.FragmentProdutosBinding
import br.com.compass.compassmart.ui.carrinhocompras.CarrinhoCompraAdapter
import br.com.compass.compassmart.ui.carrinhocompras.model.Produtos

class ProdutosFragment : Fragment() {

    private var _binding: FragmentProdutosBinding? = null
    private val binding get() = _binding!!
    private var dataProduto = mutableListOf<Produto>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProdutosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.fragmentProdutosRecyclerView.layoutManager = LinearLayoutManager(this.context)

        val produto1 = Produto(
            "Galaxy A52 5G",
            "R$ 1779,00",
            R.drawable.produto_galaxy_a52
        )

        dataProduto.add(produto1)

        binding.fragmentProdutosRecyclerView.adapter = ProdutosAdapter(dataProduto)
        super.onViewCreated(view, savedInstanceState)
    }

}