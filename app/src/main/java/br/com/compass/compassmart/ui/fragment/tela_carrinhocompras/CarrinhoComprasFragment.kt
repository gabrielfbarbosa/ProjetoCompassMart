package br.com.compass.compassmart.ui.fragment.tela_carrinhocompras

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.compass.compassmart.R
import br.com.compass.compassmart.databinding.FragmentCarrinhoComprasBinding
import br.com.compass.compassmart.ui.fragment.tela_carrinhocompras.model.Produtos

class CarrinhoComprasFragment : Fragment() {

    private var _binding: FragmentCarrinhoComprasBinding? = null
    private val binding get() = _binding!!
    private var dataProduto = mutableListOf<Produtos>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCarrinhoComprasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //Não sei o motivo, mas faltava essa linha para carregar a tela
        binding.fragmentCarrinhoComprasRecyclerview.layoutManager = LinearLayoutManager(this.context)

        val produto1 = Produtos(
            "Smartphone Samsung Galaxy A52 5G",
            "1",
            "R$ 1.799,00",
            R.drawable.produto_galaxy_a52)

        dataProduto.add(produto1)

        binding.fragmentCarrinhoComprasRecyclerview.adapter = CarrinhoCompraAdapter(dataProduto)
        super.onViewCreated(view, savedInstanceState)
    }


}