package br.com.compass.compassmart.ui.fragment.tela_confirmacao

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import br.com.compass.compassmart.R
import br.com.compass.compassmart.databinding.FragmentConfirmacaoBinding
import br.com.compass.compassmart.ui.Produto
import br.com.compass.compassmart.ui.fragment.tela_carrinhocompras.CarrinhoComprasFragmentDirections

class ConfirmacaoFragment : Fragment() {

    private var _binding: FragmentConfirmacaoBinding? = null
    private val binding get() = _binding!!
    private val produto = mutableListOf<Produto>(
        Produto(
            "Smartphone Samsung Galaxy A52 5G",
            "1",
            "R$ 1.799,00",
            R.drawable.produto_galaxy_a52
        ),
        Produto(
            "Smartphone Samsung Galaxy A52 5G",
            "1",
            "R$ 1.799,00",
            R.drawable.produto_galaxy_a52
        ),
        Produto(
            "Smartphone Samsung Galaxy A52 5G",
            "1",
            "R$ 1.799,00",
            R.drawable.produto_galaxy_a52
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentConfirmacaoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = ConfirmacaoAdapter(produto)

        binding.btnConfirmar.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_confirmacaoFragment_to_meioPagamento)
        }
        binding.btnCancelar.setOnClickListener{
            findNavController().navigate(ConfirmacaoFragmentDirections.actionConfirmacaoFragmentToProdutosFragment())
        }
    }
}