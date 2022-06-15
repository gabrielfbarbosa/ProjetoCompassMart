package br.com.compass.compassmart.ui.fragment.tela_produtos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import br.com.compass.compassmart.databinding.ItemProdutoBinding
import br.com.compass.compassmart.ui.Produto

class ProdutosAdapter(
    private val data: List<Produto>,
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

        fun bind(produto: Produto) {
            binding.itemProdutoModelo.text = produto.modelo
            binding.itemProdutoPreco.text = produto.preco
            binding.itemProdutoImagem.setImageResource(produto.drawableId)
            binding.root.setOnClickListener{
                listener.onClick(produto)
            }
        }
    }
    interface MeuOnClickListener{
        fun onClick(produto: Produto)
    }
}
