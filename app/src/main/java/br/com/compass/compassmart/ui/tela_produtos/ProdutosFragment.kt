package br.com.compass.compassmart.ui.tela_produtos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import br.com.compass.compassmart.R
import br.com.compass.compassmart.databinding.FragmentProdutosBinding

class ProdutosFragment : Fragment() {

    private var _binding: FragmentProdutosBinding? = null
    private val binding get() = _binding!!
    private var dataProduto = mutableListOf<Produto>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProdutosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fragmentProdutosRecyclerView.layoutManager = GridLayoutManager(activity, 2)
        binding.fragmentProdutosRecyclerView.adapter = ProdutosAdapter(dataProduto)

        val produto1 = Produto(
            "Galaxy A52 5G",
            "R$ 1779,00",
            R.drawable.produto_galaxy_a52
        )

        val produto2 = Produto(
            "Galaxy A52 5G",
            "R$ 1779,00",
            R.drawable.produto_galaxy_a52
        )

        val produto3 = Produto(
            "Galaxy A52 5G",
            "R$ 1779,00",
            R.drawable.produto_galaxy_a52
        )

        val produto4 = Produto(
            "Galaxy A52 5G",
            "R$ 1779,00",
            R.drawable.produto_galaxy_a52
        )

        val produto5 = Produto(
            "Galaxy A52 5G",
            "R$ 1779,00",
            R.drawable.produto_galaxy_a52
        )

        val produto6 = Produto(
            "Galaxy A52 5G",
            "R$ 1779,00",
            R.drawable.produto_galaxy_a52
        )

        dataProduto.add(produto1)
        dataProduto.add(produto2)
        dataProduto.add(produto3)
        dataProduto.add(produto4)
        dataProduto.add(produto5)
        dataProduto.add(produto6)
    }
}