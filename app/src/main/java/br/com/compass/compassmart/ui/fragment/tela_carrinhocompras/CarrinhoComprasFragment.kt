package br.com.compass.compassmart.ui.fragment.tela_carrinhocompras

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import br.com.compass.compassmart.R
import br.com.compass.compassmart.data.DbProvider
import br.com.compass.compassmart.data.Produto
import br.com.compass.compassmart.databinding.FragmentCarrinhoComprasBinding

class CarrinhoComprasFragment : Fragment() {

    private var _binding: FragmentCarrinhoComprasBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentCarrinhoComprasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val produtos: List<Produto> = DbProvider.getCartDao().getAll()

        binding.fragmentCarrinhoComprasRecyclerview.adapter = CarrinhoCompraAdapter(produtos.toMutableList())
        binding.fragmentCarrinhoComprasBtnContinuar.setOnClickListener {
            findNavController().navigate(CarrinhoComprasFragmentDirections.actionCarrinhoComprasFragmentToEnderecoFragment())
        }
        binding.fragmentCarrinhoComprasBtnAddMaisProduto.setOnClickListener{
            findNavController().navigate(CarrinhoComprasFragmentDirections.actionCarrinhoComprasFragmentToProdutosFragment())
        }
    }
}
