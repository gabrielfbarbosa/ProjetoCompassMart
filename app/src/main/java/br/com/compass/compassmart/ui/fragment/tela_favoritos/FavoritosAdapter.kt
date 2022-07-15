package br.com.compass.compassmart.ui.fragment.tela_favoritos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.compass.compassmart.databinding.ItemFavoritoBinding
import br.com.compass.compassmart.databinding.ItemProdutoBinding
import br.com.compass.compassmart.ui.Produto

class FavoritosAdapter(
    private val data: List<Produto>,
    private val listener: MeuOnClickListener
) : RecyclerView.Adapter<FavoritosAdapter.FavoritosViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavoritosAdapter.FavoritosViewHolder {
        val view = ItemProdutoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoritosViewHolder(view.root)
    }

    override fun onBindViewHolder(holder: FavoritosAdapter.FavoritosViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class FavoritosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding: ItemFavoritoBinding = ItemFavoritoBinding.bind(itemView)

        fun bind(produto: Produto) {
            binding.itemFavoritoModelo.text = produto.modelo
            binding.itemFavoritoPreco.text = produto.preco
            binding.itemFavoritoImagem.setImageResource(produto.drawableId)
            binding.root.setOnClickListener{
                listener.onClick(produto)
            }
        }
    }
    interface MeuOnClickListener{
        fun onClick(produto: Produto)
    }
}
