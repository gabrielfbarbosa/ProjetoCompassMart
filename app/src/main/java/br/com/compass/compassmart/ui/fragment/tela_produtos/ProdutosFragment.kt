package br.com.compass.compassmart.ui.fragment.tela_produtos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import br.com.compass.compassmart.R
import br.com.compass.compassmart.databinding.FragmentProdutosBinding
import br.com.compass.compassmart.ui.Produto
import br.com.compass.compassmart.ui.api.ProdutoResponse

class ProdutosFragment : Fragment() {

    private val viewModel: ProdutosViewModel by viewModels()
    private var _binding: FragmentProdutosBinding? = null
    private val binding get() = _binding!!
//    private val produtos = mutableListOf<Produto>(
//        Produto(
//            "Galaxy A52 5G",
//            "",
//            "R$ 1779,00",
//            R.drawable.produto_galaxy_a52
//        ), Produto(
//            "Galaxy A52 5G",
//            "",
//            "R$ 1779,00",
//            R.drawable.produto_galaxy_a52
//        ), Produto(
//            "Galaxy A52 5G",
//            "",
//            "R$ 1779,00",
//            R.drawable.produto_galaxy_a52
//        ), Produto(
//            "Galaxy A52 5G",
//            "",
//            "R$ 1779,00",
//            R.drawable.produto_galaxy_a52
//        ), Produto(
//            "Galaxy A52 5G",
//            "",
//            "R$ 1779,00",
//            R.drawable.produto_galaxy_a52
//        ), Produto(
//            "Galaxy A52 5G",
//            "",
//            "R$ 1779,00",
//            R.drawable.produto_galaxy_a52
//        )
//    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentProdutosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getProduto()

        binding.fragmentProdutosRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        viewModel.produtos.observe(viewLifecycleOwner) { produtos ->

            binding.fragmentProdutosRecyclerView.adapter = ProdutosAdapter(produtos,
                object : ProdutosAdapter.MeuOnClickListener {
                    override fun onClick(produto: ProdutoResponse) {
                        findNavController().navigate(ProdutosFragmentDirections.actionProdutosFragmentToDetalhesDoProdutoFragment(
                            produto.id))
                    }
                }
            )
        }

    }
}

