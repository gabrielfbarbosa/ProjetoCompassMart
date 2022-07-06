package br.com.compass.compassmart.ui.fragment.tela_produtos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import br.com.compass.compassmart.R
import br.com.compass.compassmart.databinding.ItemProdutoBinding
import br.com.compass.compassmart.ui.Produto
import br.com.compass.compassmart.ui.api.ProdutoResponse
import com.bumptech.glide.Glide
import java.text.NumberFormat

class ProdutosAdapter(
    private val data: List<ProdutoResponse>,
    private val listener: MeuOnClickListener
) : RecyclerView.Adapter<ProdutosAdapter.ProdutosViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProdutosAdapter.ProdutosViewHolder {
        val view = ItemProdutoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProdutosViewHolder(view.root)
    }

    override fun onBindViewHolder(holder: ProdutosAdapter.ProdutosViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ProdutosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding: ItemProdutoBinding = ItemProdutoBinding.bind(itemView)

        fun bind(produto: ProdutoResponse) {
            binding.itemProdutoModelo.text = produto.name
            binding.itemProdutoPreco.text = NumberFormat.getCurrencyInstance().format(produto.price)
            Glide.with(itemView.context)
                .load(produto.pic)
                .centerInside()
                .placeholder(R.drawable.img_indisponivel)
                .into(binding.itemProdutoImagem)

            binding.root.setOnClickListener{
                listener.onClick(produto)
            }
        }
    }
    interface MeuOnClickListener{
        fun onClick(produto: ProdutoResponse)
    }
}
