package br.com.compass.compassmart.ui.fragment.tela_carrinhocompras

import android.content.DialogInterface
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import br.com.compass.compassmart.R
import br.com.compass.compassmart.data.DbProvider
import br.com.compass.compassmart.databinding.ItemCarrinhoCompraBinding
import br.com.compass.compassmart.data.Produto
import br.com.compass.compassmart.ui.activity.MainActivity
import com.bumptech.glide.Glide
import java.text.NumberFormat

class CarrinhoCompraAdapter(
    private val dataProduto: MutableList<Produto>,
    private val itemRemovido: (listaVazia: Boolean) -> Unit
) : RecyclerView.Adapter<CarrinhoCompraAdapter.CarrinhoViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): CarrinhoViewHolder {
        val view =
            ItemCarrinhoCompraBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CarrinhoViewHolder(view.root)
    }

    override fun onBindViewHolder(holder: CarrinhoViewHolder, position: Int) {
        holder.bind(dataProduto[position])
        holder.onDeleteItem(dataProduto[position]) {
            removerItem(position)
        }
    }

    private fun removerItem(position: Int) {
        dataProduto.removeAt(position)
        notifyDataSetChanged()
        notifyItemRemoved(position)
        itemRemovido(dataProduto.isEmpty())
    }

    override fun getItemCount(): Int = dataProduto.size

    class CarrinhoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding: ItemCarrinhoCompraBinding = ItemCarrinhoCompraBinding.bind(itemView)

        fun bind(produto: Produto) {
            binding.itemCarrinhoCompraDescricao.text = produto.name
            binding.itemCarrinhoCompraNumeroQuantidade.text = "1"
            binding.itemCarrinhoCompraPreco.text = NumberFormat.getCurrencyInstance().format(produto.price)
            Glide.with(itemView.context)
                .load(produto.pic)
                .centerInside()
                .placeholder(R.drawable.img_indisponivel)
                .into(binding.itemCarrinhoCompraImagem)
        }

        fun onDeleteItem(produto: Produto, onClick : () -> Unit) {
            binding.itemCarrinhoCompraExcluir.setOnClickListener{
                AlertDialog.Builder(itemView.context)
                    .setTitle("Remover item do carrinho?")
                    .setPositiveButton("Sim") { _, _ ->
                        DbProvider.getCartDao().deletaProduto(produto)
                        onClick()
                    }
                    .setNegativeButton("Não", null)
                    .create()
                    .show()
            }
        }

    }
}
