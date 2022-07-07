package br.com.compass.compassmart.ui.fragment.tela_principal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.compass.compassmart.databinding.ItemProdutoBinding
import br.com.compass.compassmart.databinding.ItemTelaPrincipalBinding
import br.com.compass.compassmart.ui.Produto

class TelaPrincipalAdapter(
    private val data: List<Produto>,
    private val listener: MeuOnClickListener,
) : RecyclerView.Adapter<TelaPrincipalAdapter.ProdutosViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): TelaPrincipalAdapter.ProdutosViewHolder {
        val view =
            ItemProdutoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProdutosViewHolder(view.root)
    }

    override fun onBindViewHolder(holder: TelaPrincipalAdapter.ProdutosViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ProdutosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding: ItemTelaPrincipalBinding = ItemTelaPrincipalBinding.bind(itemView)

        //Corrigir as referencias
        fun bind(produto: Produto) {
//                binding.itemProdutoModelo.text = produto.modelo
//                binding.itemProdutoPreco.text = produto.preco
//                binding.itemProdutoImagem.setImageResource(produto.drawableId)
//                binding.root.setOnClickListener {
//                    listener.onClick(produto)
//                }
        }
    }

    interface MeuOnClickListener {
        fun onClick(produto: Produto)
    }
}