package br.com.compass.compassmart.ui.fragment.tela_confirmacao

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.compass.compassmart.R
import br.com.compass.compassmart.data.Produto
import br.com.compass.compassmart.databinding.ItemConfirmacaoBinding
import com.bumptech.glide.Glide
import java.text.NumberFormat

class ConfirmacaoAdapter(private val data: List<Produto>) :
    RecyclerView.Adapter<ConfirmacaoAdapter.ConfirmacaoViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ConfirmacaoAdapter.ConfirmacaoViewHolder {
        val view =
            ItemConfirmacaoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ConfirmacaoViewHolder(view.root)
    }

    override fun onBindViewHolder(holder: ConfirmacaoAdapter.ConfirmacaoViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    class ConfirmacaoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding: ItemConfirmacaoBinding = ItemConfirmacaoBinding.bind(itemView)

        fun bind(produto: Produto) {
            binding.descricao.text = produto.name
            binding.numQuantidade.text = produto.amount.toString()
            binding.preco.text = NumberFormat.getCurrencyInstance().format(produto.price)
            Glide.with(itemView.context)
                .load(produto.pic)
                .placeholder(R.drawable.img_indisponivel)
                .into(binding.imagem)
        }
    }
}