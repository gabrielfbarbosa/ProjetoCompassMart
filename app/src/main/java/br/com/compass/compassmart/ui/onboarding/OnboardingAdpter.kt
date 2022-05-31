package br.com.compass.compassmart.ui.onboarding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.compass.compassmart.R

class OnboardingAdpter(private val titulo: List<String>, private val descricao: List<String>, private val imagem: List<Int>) : RecyclerView.Adapter<OnboardingAdpter.PaginasViewHolder>() {

    class PaginasViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val itemTitulo : TextView = itemView.findViewById(R.id.informacao_inicial_titulo)
        val itemDescricao : TextView = itemView.findViewById(R.id.informacao_inicial_descricao)
        val itemImagem : ImageView = itemView.findViewById(R.id.informacao_inicial_imagem)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OnboardingAdpter.PaginasViewHolder {
        return PaginasViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.informacao_inicial, parent, false))
    }

    override fun getItemCount(): Int {
        return titulo.size
    }

    override fun onBindViewHolder(holder: OnboardingAdpter.PaginasViewHolder, position: Int) {
        holder.itemTitulo.text = titulo[position]
        holder.itemDescricao.text = descricao[position]
        holder.itemImagem.setImageResource(imagem[position])

    }
}
