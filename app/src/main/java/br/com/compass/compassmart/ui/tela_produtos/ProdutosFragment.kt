package br.com.compass.compassmart.ui.tela_produtos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.compass.compassmart.R
import br.com.compass.compassmart.databinding.FragmentProdutosBinding

class ProdutosFragment : Fragment() {

    private var _binding: FragmentProdutosBinding? = null
    private val binding get() = _binding!!
    private var data = mutableListOf<Produto>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProdutosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        conteudo()
    }

    private fun adicionaNaLista(modelo: String, preco: String, imagem: Int) {
        data.add(Produto(modelo, preco, imagem))
    }

    private fun conteudo() {
        val produtoModelo = resources.getStringArray(R.array.produtos_modelos)
        val produtoPreco = resources.getStringArray(R.array.produtos_precos)

        adicionaNaLista(
            produtoModelo[0],
            produtoPreco[0],
            R.drawable.produto_galaxy_a52
        )

        adicionaNaLista(
            produtoModelo[1],
            produtoPreco[1],
            R.drawable.produto_galaxy_s22
        )

        adicionaNaLista(
            produtoModelo[2],
            produtoPreco[2],
            R.drawable.produto_iphone_12
        )

        adicionaNaLista(
            produtoModelo[3],
            produtoPreco[3],
            R.drawable.produto_pixel_5
        )

        adicionaNaLista(
            produtoModelo[4],
            produtoPreco[4],
            R.drawable.produto_poco_f3
        )

        adicionaNaLista(
            produtoModelo[5],
            produtoPreco[5],
            R.drawable.produto_xiaomi_mi11
        )
    }

}