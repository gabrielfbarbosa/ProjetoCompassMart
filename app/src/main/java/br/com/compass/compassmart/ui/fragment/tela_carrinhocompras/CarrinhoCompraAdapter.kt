package br.com.compass.compassmart.ui.fragment.tela_carrinhocompras

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import br.com.compass.compassmart.R
import br.com.compass.compassmart.data.Produto
import br.com.compass.compassmart.databinding.ItemCarrinhoCompraBinding
import com.bumptech.glide.Glide
import java.text.NumberFormat

class CarrinhoCompraAdapter(
    private val dataProduto: MutableList<Produto>,
    private val itemRemovido: (produto: Produto) -> Unit,
    private val alteraQtd: (quantidade: Int, produto: Produto) -> Unit,
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
        holder.bind(
            produto = dataProduto[position],
            onDeleteItem = {
                itemRemovido(dataProduto[position])
            },
            alteraQtd = { quantidade ->
                alteraQtd(quantidade, dataProduto[position])
            }
        )
    }

    fun addAll(data: List<Produto>) {
        dataProduto.clear()
        dataProduto.addAll(data)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = dataProduto.size

    class CarrinhoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding: ItemCarrinhoCompraBinding = ItemCarrinhoCompraBinding.bind(itemView)

        fun bind(produto: Produto, onDeleteItem: () -> Unit, alteraQtd: (quantidade: Int) -> Unit) {
            binding.itemCarrinhoCompraDescricao.text = produto.name
            binding.itemCarrinhoCompraNumeroQuantidade.text = produto.amount.toString()
            binding.itemCarrinhoCompraPreco.text =
                NumberFormat.getCurrencyInstance().format(produto.price)
            Glide.with(itemView.context)
                .load(produto.pic)
                .centerInside()
                .placeholder(R.drawable.img_indisponivel)
                .into(binding.itemCarrinhoCompraImagem)
            //Delete item
            binding.itemCarrinhoCompraExcluir.setOnClickListener {
                AlertDialog.Builder(itemView.context)
                    .setTitle("Remover item do carrinho?")
                    .setPositiveButton("Sim") { _, _ ->
                        onDeleteItem()
                    }
                    .setNegativeButton("Não", null)
                    .create()
                    .show()
            }
            //Change amount
            binding.maisProduto.setOnClickListener {
                alteraQtd(produto.amount + 1)
            }
            binding.menosProduto.setOnClickListener {
                alteraQtd(produto.amount - 1)
            }
        }
    }
}
