package br.com.compass.compassmart.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import br.com.compass.compassmart.R
import br.com.compass.compassmart.databinding.FragmentOnboardingMainBinding
import br.com.compass.compassmart.ui.onboarding.model.InformacoesModel

class OnboardingMain : Fragment() {

    //Para chamar apenas os ids do Layout que estou trabalhando
    private val binding: FragmentOnboardingMainBinding by lazy {
        FragmentOnboardingMainBinding.inflate(layoutInflater)
    }
    private var data = mutableListOf<InformacoesModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        conteudo()
        binding.onboardingMainViewPager.adapter = OnboardingAdpter(data)

            binding.onboardingMainViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                mudarCorBolinhaProgresso()
            }
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }
            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                mudarCorBolinhaProgresso()
            }
        })
        return binding.root
    }
    // Adiciona os conteudos dos cards
    fun adicionaNaLista(titulo : String, descricao : String, imagem: Int){
        data.add(InformacoesModel(titulo, descricao, imagem))
    }
    // Conteudo de cada cards
    fun conteudo() {
        adicionaNaLista("O melhor da tecnologia\n" + "na palma da sua mão!",
            "Smartphones, Capas, powebanks, \n" + "películas e muito mais!",
            R.drawable.img_onboarding1)

        adicionaNaLista("Rápido, fácil\n" + "e prático!",
            "Escolha os melhores produtos\n" + "e a melhor forma de pagamento\n" + "sem nenhuma dificuldade!",
            R.drawable.img_onboarding2)

        adicionaNaLista("Tenha o poder que \n" + "você merece!",
            "Comece a comprar agora mesmo\n" + "para mudar a sua vida!",
            R.drawable.img_onboarding3)
    }
    // Faz a mudança da cor das bolinhas de progresso
    private fun mudarCorBolinhaProgresso() {
        when (binding.onboardingMainViewPager.currentItem) {
            0 -> {
                binding.onboardingMainProgressoEsquerda.setBackgroundResource(R.color.orange_700)
                binding.onboardingMainProgressoCentro.setBackgroundResource(R.color.orange_200)
                binding.onboardingMainProgressoDireita.setBackgroundResource(R.color.orange_200)
            }
            1 -> {
                binding.onboardingMainProgressoEsquerda.setBackgroundResource(R.color.orange_200)
                binding.onboardingMainProgressoCentro.setBackgroundResource(R.color.orange_700)
                binding.onboardingMainProgressoDireita.setBackgroundResource(R.color.orange_200)
            }
            2 -> {
                binding.onboardingMainProgressoEsquerda.setBackgroundResource(R.color.orange_200)
                binding.onboardingMainProgressoCentro.setBackgroundResource(R.color.orange_200)
                binding.onboardingMainProgressoDireita.setBackgroundResource(R.color.orange_700)
            }
        }
    }
}