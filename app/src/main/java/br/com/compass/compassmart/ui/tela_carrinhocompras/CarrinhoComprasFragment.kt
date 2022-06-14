package br.com.compass.compassmart.ui.tela_carrinhocompras

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.compass.compassmart.R
import br.com.compass.compassmart.databinding.FragmentCarrinhoComprasBinding
import br.com.compass.compassmart.ui.tela_carrinhocompras.model.Produtos

class CarrinhoComprasFragment : Fragment() {

    private var _binding: FragmentCarrinhoComprasBinding? = null
    private val binding get() = _binding!!
    private var dataProduto = mutableListOf<Produtos>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCarrinhoComprasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val produto1 = Produtos(
            "Smartphone Samsung Galaxy A52 5G",
            "1",
            "R$ 1.799,00",
            R.drawable.produto_galaxy_a52)

        while (dataProduto.size <= 3 ) {
            dataProduto.add(produto1)
        }

        binding.fragmentCarrinhoComprasRecyclerview.adapter = CarrinhoCompraAdapter(dataProduto)
        super.onViewCreated(view, savedInstanceState)
    }
}