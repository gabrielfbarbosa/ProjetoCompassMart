package br.com.compass.compassmart.ui.fragment.tela_principal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import br.com.compass.compassmart.R
import br.com.compass.compassmart.api.ProdutoResponse
import br.com.compass.compassmart.databinding.FragmentProdutosBinding
import br.com.compass.compassmart.databinding.FragmentTelaPrincipalBinding
import br.com.compass.compassmart.ui.Produto
import br.com.compass.compassmart.ui.fragment.tela_produtos.ProdutosAdapter
import br.com.compass.compassmart.ui.fragment.tela_produtos.ProdutosFragmentDirections
import br.com.compass.compassmart.ui.fragment.tela_produtos.ProdutosViewModel

class TelaPrincipalFragment : Fragment() {
    private val viewModel: TelaPrincipalViewModel by viewModels()
    private var _binding: FragmentTelaPrincipalBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentTelaPrincipalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getMainProduto()

        binding.fragmentTelaPrincipalRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        viewModel.mainProdutos.observe(viewLifecycleOwner) { produtos ->

            binding.fragmentTelaPrincipalRecyclerView.adapter = ProdutosAdapter(produtos,
                object : ProdutosAdapter.MeuOnClickListener {
                    override fun onClick(produto: ProdutoResponse) {
                        findNavController().navigate(
                            ProdutosFragmentDirections.actionProdutosFragmentToDetalhesDoProdutoFragment(
                            produto)
                        )
                    }
                }
            )
        }
    }
}