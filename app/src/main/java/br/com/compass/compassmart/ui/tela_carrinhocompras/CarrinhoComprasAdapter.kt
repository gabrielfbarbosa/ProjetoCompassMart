package br.com.compass.compassmart.ui.tela_carrinhocompras

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.compass.compassmart.databinding.ItemCarrinhoCompraBinding
import br.com.compass.compassmart.ui.tela_carrinhocompras.model.Produtos

class CarrinhoComprasAdapter (
    private val dataProduto: List<Produtos>
) : RecyclerView.Adapter<CarrinhoComprasAdapter.CarrinhoViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CarrinhoViewHolder {
        val view = ItemCarrinhoCompraBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CarrinhoViewHolder(view.root)
    }

    override fun onBindViewHolder(holder: CarrinhoViewHolder, position: Int) {
        holder.bindProdutos(dataProduto[position])
    }

    override fun getItemCount(): Int = dataProduto.size

    class CarrinhoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding: ItemCarrinhoCompraBinding = ItemCarrinhoCompraBinding.bind(itemView)

        fun bindProdutos(produtos: Produtos) {
            binding.itemCarrinhoCompraDescricao.text = produtos.descricao
            binding.itemCarrinhoCompraNumeroQuantidade.text = produtos.quantidade
            binding.itemCarrinhoCompraPreco.text = produtos.preco
            binding.itemCarrinhoCompraImagem.setImageResource(produtos.drawableId)
        }
    }
}