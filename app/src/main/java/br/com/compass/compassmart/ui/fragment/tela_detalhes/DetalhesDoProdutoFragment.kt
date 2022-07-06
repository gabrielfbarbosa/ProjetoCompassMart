package br.com.compass.compassmart.ui.fragment.tela_detalhes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import br.com.compass.compassmart.R
import br.com.compass.compassmart.databinding.FragmentDetalhesDoProdutoBinding
import com.bumptech.glide.Glide
import java.text.NumberFormat

class DetalhesDoProdutoFragment : Fragment() {

    private val produtoArgs by navArgs<DetalhesDoProdutoFragmentArgs>()
    private var _binding: FragmentDetalhesDoProdutoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetalhesDoProdutoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        //Recebe a imagem
//        Glide.with(view.context)
//            .load(produtoArgs.produto.pic)
//            .fitCenter()
//            .placeholder(R.drawable.img_indisponivel)
//            .into(binding.imagemProduto)
//
//        binding.ProdutoModelo.text = produtoArgs.produto.name
//        //Preço à vista
//        val preco = NumberFormat.getCurrencyInstance().format(produtoArgs.produto.price)
//        binding.precoDoProduto.text = "${preco} à vista"
//
//        //Dividindo preço em 12x
//        val precoEmDoze = produtoArgs.produto.price/12;
//        val precoFinalEmDoze = NumberFormat.getCurrencyInstance().format(precoEmDoze)
//        binding.complementoDoProduto.text = "Em até 12x de ${precoFinalEmDoze} sem juros"

        binding.btnComprarAgora.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_detalhesDoProdutoFragment_to_loginFragment)
        }
    }
}
