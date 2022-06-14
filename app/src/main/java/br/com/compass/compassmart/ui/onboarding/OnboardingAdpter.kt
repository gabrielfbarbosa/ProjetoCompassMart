package br.com.compass.compassmart.ui.onboarding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.compass.compassmart.databinding.ItemOnboardingBinding
import br.com.compass.compassmart.ui.onboarding.model.InformacoesModel

class OnboardingAdpter(
    private val data: List<InformacoesModel>
) : RecyclerView.Adapter<OnboardingAdpter.PaginasViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OnboardingAdpter.PaginasViewHolder {
        val view = ItemOnboardingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PaginasViewHolder(view.root)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: OnboardingAdpter.PaginasViewHolder, position: Int) {
       holder.bind(data[position])
    }

    class PaginasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding: ItemOnboardingBinding = ItemOnboardingBinding.bind(itemView)

        fun bind( informacoesModel: InformacoesModel) {
            binding.informacaoInicialTitulo.text = informacoesModel.tiulo
            binding.informacaoInicialDescricao.text = informacoesModel.descricao
            binding.informacaoInicialImagem.setImageResource(informacoesModel.drawableId)
        }
    }
}
