package br.com.compass.compassmart.ui.fragment.tela_onboarding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.compass.compassmart.databinding.ItemOnboardingBinding
import br.com.compass.compassmart.ui.fragment.tela_onboarding.model.InformacoesModel

class OnboardingAdapter(
    private val data: List<InformacoesModel>,
) : RecyclerView.Adapter<OnboardingAdapter.PaginasViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): PaginasViewHolder {
        val view = ItemOnboardingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PaginasViewHolder(view.root)
    }

    override fun onBindViewHolder(holder: PaginasViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class PaginasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding: ItemOnboardingBinding = ItemOnboardingBinding.bind(itemView)

        fun bind(informacoesModel: InformacoesModel) {
            binding.informacaoInicialTitulo.text = informacoesModel.tiulo
            binding.informacaoInicialDescricao.text = informacoesModel.descricao
            binding.informacaoInicialImagem.setImageResource(informacoesModel.drawableId)
        }
    }
}
