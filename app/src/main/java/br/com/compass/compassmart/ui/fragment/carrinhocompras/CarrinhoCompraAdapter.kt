package br.com.compass.compassmart.ui.fragment.carrinhocompras

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.compass.compassmart.databinding.ItemCarrinhoCompraBinding
import br.com.compass.compassmart.ui.Produto

class CarrinhoCompraAdapter(
    private val dataProduto: List<Produto>
) : RecyclerView.Adapter<CarrinhoCompraAdapter.CarrinhoViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CarrinhoCompraAdapter.CarrinhoViewHolder {
        val view = ItemCarrinhoCompraBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CarrinhoViewHolder(view.root)
    }

    override fun onBindViewHolder(holder: CarrinhoCompraAdapter.CarrinhoViewHolder, position: Int) {
        holder.bind(dataProduto[position])
    }

    override fun getItemCount(): Int = dataProduto.size

    class CarrinhoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding: ItemCarrinhoCompraBinding = ItemCarrinhoCompraBinding.bind(itemView)

        fun bind(produto: Produto) {
            binding.itemCarrinhoCompraDescricao.text = produto.modelo
            binding.itemCarrinhoCompraNumeroQuantidade.text = produto.quantidade
            binding.itemCarrinhoCompraPreco.text = produto.preco
            binding.itemCarrinhoCompraImagem.setImageResource(produto.drawableId)
        }
    }
}