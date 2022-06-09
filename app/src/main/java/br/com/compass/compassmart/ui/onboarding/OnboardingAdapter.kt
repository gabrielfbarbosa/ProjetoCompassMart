package br.com.compass.compassmart.ui.onboarding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.compass.compassmart.databinding.ItemOnboardingBinding
import br.com.compass.compassmart.ui.onboarding.model.InformacoesModel

class OnboardingAdapter(
    private val data: List<InformacoesModel>
) : RecyclerView.Adapter<OnboardingAdapter.PaginasViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OnboardingAdapter.PaginasViewHolder {
        val view = ItemOnboardingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PaginasViewHolder(view.root)
    }

    override fun onBindViewHolder(holder: OnboardingAdapter.PaginasViewHolder, position: Int) {
       holder.bindInformacoes(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class PaginasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding: ItemOnboardingBinding = ItemOnboardingBinding.bind(itemView)

        fun bindInformacoes(informacoesModel: InformacoesModel) {
            binding.informacaoInicialTitulo.text = informacoesModel.tiulo
            binding.informacaoInicialDescricao.text = informacoesModel.descricao
            binding.informacaoInicialImagem.setImageResource(informacoesModel.drawableId)
        }
    }
}
