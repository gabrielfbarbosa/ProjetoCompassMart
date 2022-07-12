package br.com.compass.compassmart.ui.fragment.tela_produtos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import br.com.compass.compassmart.databinding.FragmentProdutosBinding
import br.com.compass.compassmart.api.ProdutoResponse
import br.com.compass.compassmart.ui.fragment.util.SharedPreference

class ProdutosFragment : Fragment() {

    private val viewModel: ProdutosViewModel by viewModels()
    private var _binding: FragmentProdutosBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentProdutosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Parar splash e onboarding aparecer uma vez apenas
        SharedPreference(requireContext()).insereAcesso(true)

        viewModel.getProduto()

        binding.fragmentProdutosRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        viewModel.produtos.observe(viewLifecycleOwner) { produtos ->

            binding.btnCarrinho.setOnClickListener {
                if (SharedPreference(requireContext()).pegarToken().isNullOrBlank()){
                    findNavController().navigate(ProdutosFragmentDirections.actionProdutosFragmentToLoginFragment())
                }else{
                    findNavController().navigate(ProdutosFragmentDirections.actionProdutosFragmentToCarrinhoComprasFragment())
                }
            }

            binding.fragmentProdutosRecyclerView.adapter = ProdutosAdapter(produtos,
                object : ProdutosAdapter.MeuOnClickListener {
                    override fun onClick(produto: ProdutoResponse) {
                        findNavController().navigate(ProdutosFragmentDirections.actionProdutosFragmentToDetalhesDoProdutoFragment(
                            produto)
                        )
                    }
                }
            )
        }
    }
}

