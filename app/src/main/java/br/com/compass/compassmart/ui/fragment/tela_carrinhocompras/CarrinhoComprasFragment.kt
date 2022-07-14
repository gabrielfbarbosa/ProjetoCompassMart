package br.com.compass.compassmart.ui.fragment.tela_carrinhocompras

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import br.com.compass.compassmart.data.DbProvider
import br.com.compass.compassmart.data.Produto
import br.com.compass.compassmart.databinding.FragmentCarrinhoComprasBinding
import br.com.compass.compassmart.ui.fragment.tela_detalhes.DetalhesDoProdutoViewModel

class CarrinhoComprasFragment : Fragment() {

    private val viewModel: CarrinhoCompraViewModel by viewModels()
    private var _binding: FragmentCarrinhoComprasBinding? = null
    private val binding get() = _binding!!
    private val adapter = CarrinhoCompraAdapter(
        dataProduto = mutableListOf(),
        itemRemovido = { produto ->
            viewModel.deleteProduto(produto, requireContext())
        },
        alteraQtd = { quantidade: Int, produto: Produto ->
            viewModel.atualizaQtd(produto.copy(amount = quantidade),requireContext())
        }
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentCarrinhoComprasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        escutaLiveData()
        viewModel.getProdutos()
        binding.fragmentCarrinhoComprasRecyclerview.adapter = adapter
        binding.fragmentCarrinhoComprasBtnContinuar.setOnClickListener {
            findNavController().navigate(CarrinhoComprasFragmentDirections.actionCarrinhoComprasFragmentToEnderecoFragment())
        }
        binding.fragmentCarrinhoComprasBtnAddMaisProduto.setOnClickListener {
            findNavController().navigate(CarrinhoComprasFragmentDirections.actionCarrinhoComprasFragmentToProdutosFragment())
        }
    }

    private fun escutaLiveData() {
        viewModel.alterado.observe(viewLifecycleOwner) { foiAlterado ->
            if (foiAlterado) {
                viewModel.getProdutos()
            }
        }

        viewModel.produtos.observe(viewLifecycleOwner) { produtos ->
            adapter.addAll(produtos)
            visibilidadeRecycler(produtos.isEmpty())
        }
    }

     private fun visibilidadeRecycler(listaVazia: Boolean): Boolean {
        binding.txtCarrinhoVazio.isVisible = listaVazia
        binding.fragmentCarrinhoComprasRecyclerview.isVisible = !listaVazia
        if (listaVazia) {
            binding.fragmentCarrinhoComprasBtnContinuar.isEnabled = false
            binding.fragmentCarrinhoComprasBtnContinuar.setBackgroundResource(androidx.appcompat.R.color.material_grey_600)
            binding.fragmentCarrinhoComprasBtnContinuar.setImageResource(com.google.android.material.R.drawable.ic_m3_chip_close)
        }
        return listaVazia
    }
}
