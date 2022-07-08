package br.com.compass.compassmart.ui.fragment.tela_principal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.compass.compassmart.databinding.ItemProdutoBinding
import br.com.compass.compassmart.databinding.ItemTelaPrincipalBinding
import br.com.compass.compassmart.R
import br.com.compass.compassmart.api.ProdutoResponse
import com.bumptech.glide.Glide
import java.text.NumberFormat

class TelaPrincipalAdapter(
    private val data: List<ProdutoResponse>,
    private val listener: MeuOnClickListener,
) : RecyclerView.Adapter<TelaPrincipalAdapter.TelaPrincipalViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): TelaPrincipalAdapter.TelaPrincipalViewHolder {
        val view =
            ItemProdutoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TelaPrincipalViewHolder(view.root)
    }

    override fun onBindViewHolder(holder: TelaPrincipalAdapter.TelaPrincipalViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class TelaPrincipalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding: ItemProdutoBinding = ItemProdutoBinding.bind(itemView)

        fun bind(produto: ProdutoResponse) {
            binding.itemProdutoModelo.text = produto.name
            binding.itemProdutoPreco.text = NumberFormat.getCurrencyInstance().format(produto.price)
            Glide.with(itemView.context)
                .load(produto.pic)
                .fitCenter()
                .placeholder(R.drawable.img_indisponivel)
                .into(binding.itemProdutoImagem)

            binding.root.setOnClickListener {
                listener.onClick(produto)
            }
        }
    }

    interface MeuOnClickListener {
        fun onClick(produto: ProdutoResponse)
    }
}