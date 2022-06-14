package br.com.compass.compassmart.ui.fragment.carrinhocompras

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.compass.compassmart.R
import br.com.compass.compassmart.databinding.FragmentCarrinhoComprasBinding
import br.com.compass.compassmart.ui.Produto

class CarrinhoComprasFragment : Fragment() {

    private var _binding: FragmentCarrinhoComprasBinding? = null
    private val binding get() = _binding!!
    private val produto = mutableListOf<Produto>(
        Produto(
            "Smartphone Samsung Galaxy A52 5G",
            "1",
            "R$ 1.799,00",
            R.drawable.produto_galaxy_a52
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCarrinhoComprasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fragmentCarrinhoComprasRecyclerview.adapter = CarrinhoCompraAdapter(produto)
    }
}
