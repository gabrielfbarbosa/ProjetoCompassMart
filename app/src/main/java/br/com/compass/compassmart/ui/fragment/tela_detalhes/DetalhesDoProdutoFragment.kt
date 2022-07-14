package br.com.compass.compassmart.ui.fragment.tela_detalhes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import br.com.compass.compassmart.R
import br.com.compass.compassmart.data.DbProvider
import br.com.compass.compassmart.data.Produto
import br.com.compass.compassmart.databinding.FragmentDetalhesDoProdutoBinding
import com.bumptech.glide.Glide
import java.text.NumberFormat

class DetalhesDoProdutoFragment : Fragment() {

    private val produtoArgs by navArgs<DetalhesDoProdutoFragmentArgs>()
    private val viewModel: DetalhesDoProdutoViewModel by viewModels()
    private var _binding: FragmentDetalhesDoProdutoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentDetalhesDoProdutoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DbProvider.getCartDao().getAll()
        val idProduto = produtoArgs.produto.id

        val nome = produtoArgs.produto.name
        binding.ProdutoModelo.text = nome

        //Preço à vista
        val preco = produtoArgs.produto.price
        binding.precoDoProduto.text = "${NumberFormat.getCurrencyInstance().format(preco)} à vista"

        //Dividindo preço em 12x
        val precoEmDoze = produtoArgs.produto.price / 12;
        val precoFinalEmDoze = NumberFormat.getCurrencyInstance().format(precoEmDoze)
        binding.complementoDoProduto.text = "Em até 12x de ${precoFinalEmDoze} sem juros"

        //Recebe a imagem
        val img = Glide.with(view.context)
            .load(produtoArgs.produto.pic)
            .fitCenter()
            .placeholder(R.drawable.img_indisponivel)
            .into(binding.imagemProduto)

        val produtoEscolhido = Produto(
            idProduto,
            nome,
            preco,
            produtoArgs.produto.pic!!,
            1
        )

        binding.btnComprarAgora.setOnClickListener {
            viewModel.addProdutoCarrinho(produtoEscolhido)
            Navigation.findNavController(view)
                .navigate(R.id.action_detalhesDoProdutoFragment_to_loginFragment)
        }
        binding.fabVoltar.setOnClickListener{
            findNavController().navigate(DetalhesDoProdutoFragmentDirections.actionDetalhesDoProdutoFragmentToProdutosFragment())
        }
    }
}
