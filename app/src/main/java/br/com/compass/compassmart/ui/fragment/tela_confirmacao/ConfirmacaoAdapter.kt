package br.com.compass.compassmart.ui.fragment.tela_confirmacao

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import br.com.compass.compassmart.databinding.ItemConfirmacaoBinding
import br.com.compass.compassmart.ui.Produto

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
            binding.descricao.text = produto.modelo
            binding.numQuantidade.text = produto.quantidade
            binding.preco.text = produto.preco
            binding.imagem.setImageResource(produto.drawableId)
        }
    }
}