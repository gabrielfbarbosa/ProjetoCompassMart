package br.com.compass.compassmart.ui.fragment.tela_confirmacao

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.compass.compassmart.data.DbProvider
import br.com.compass.compassmart.data.Produto
import br.com.compass.compassmart.databinding.FragmentConfirmacaoBinding
import java.text.NumberFormat

class ConfirmacaoFragment : Fragment() {

    private var _binding: FragmentConfirmacaoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentConfirmacaoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val produtos: List<Produto> = DbProvider.getCartDao().getAll()
        var valorTotal: Double = 0.0
        var valorQtd: Double = 0.0

        binding.recyclerView.adapter = ConfirmacaoAdapter(produtos)
        for (i in produtos.indices) {
            valorQtd = produtos[i].price * produtos[i].amount
            valorTotal += valorQtd
        }
        binding.precoTotal.text = NumberFormat.getCurrencyInstance().format(valorTotal)

        binding.btnConfirmar.setOnClickListener {
            findNavController().navigate(ConfirmacaoFragmentDirections.actionConfirmacaoFragmentToMeioPagamento())
        }
        binding.btnCancelar.setOnClickListener {
            findNavController().navigate(ConfirmacaoFragmentDirections.actionConfirmacaoFragmentToProdutosFragment())
        }
    }
}