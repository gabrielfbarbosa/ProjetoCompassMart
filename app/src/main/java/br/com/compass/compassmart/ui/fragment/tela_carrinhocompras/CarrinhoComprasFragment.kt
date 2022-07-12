package br.com.compass.compassmart.ui.fragment.tela_carrinhocompras

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
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
        visibilidadeRecycler(produtos.isEmpty())

        binding.fragmentCarrinhoComprasRecyclerview.adapter = CarrinhoCompraAdapter(produtos.toMutableList()) { listaVazia ->
            visibilidadeRecycler(listaVazia)
        }
        binding.fragmentCarrinhoComprasBtnContinuar.setOnClickListener {
            findNavController().navigate(CarrinhoComprasFragmentDirections.actionCarrinhoComprasFragmentToEnderecoFragment())
        }
        binding.fragmentCarrinhoComprasBtnAddMaisProduto.setOnClickListener{
            findNavController().navigate(CarrinhoComprasFragmentDirections.actionCarrinhoComprasFragmentToProdutosFragment())
        }
    }

    fun visibilidadeRecycler(listaVazia: Boolean){
        binding.txtCarrinhoVazio.isVisible = listaVazia
        binding.fragmentCarrinhoComprasRecyclerview.isVisible = !listaVazia
        if (listaVazia){

            binding.fragmentCarrinhoComprasBtnContinuar.isClickable = false
            binding.fragmentCarrinhoComprasBtnContinuar.setBackgroundResource(androidx.appcompat.R.color.material_grey_600)
            binding.fragmentCarrinhoComprasBtnContinuar.setImageResource(com.google.android.material.R.drawable.ic_m3_chip_close)
        }
    }
}
