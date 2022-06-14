package br.com.compass.compassmart.ui.fragment.tela_onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import br.com.compass.compassmart.R
import br.com.compass.compassmart.databinding.FragmentOnboardingBinding
import br.com.compass.compassmart.ui.fragment.tela_onboarding.OnboardingAdapter
import br.com.compass.compassmart.ui.fragment.tela_onboarding.model.InformacoesModel

class OnboardingFragment : Fragment() {

    private var _binding: FragmentOnboardingBinding? = null
    private val binding get() = _binding!!
    private var data = mutableListOf<InformacoesModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        conteudo()
        setupViewPager()
    }

    private fun setupViewPager() {
        binding.fragmentOnboardingViewPager.adapter = OnboardingAdapter(data)
        binding.fragmentOnboardingViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {

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
    }

    // Adiciona os conteudos dos cards
    private fun adicionaNaLista(titulo: String, descricao: String, imagem: Int) {
        data.add(InformacoesModel(titulo, descricao, imagem))
    }

    // Conteudo de cada card
    private fun conteudo() {

        val onboardingText = resources.getStringArray((R.array.onboarding))

        adicionaNaLista(
            onboardingText[0],
            onboardingText[1],
            R.drawable.img_onboarding1
        )

        adicionaNaLista(
            onboardingText[2],
            onboardingText[3],
            R.drawable.img_onboarding2
        )

        adicionaNaLista(
            onboardingText[4],
            onboardingText[5],
            R.drawable.img_onboarding3
        )
    }

    // Faz a mudança da cor das bolinhas de progresso
    private fun mudarCorBolinhaProgresso() {
        when (binding.fragmentOnboardingViewPager.currentItem) {
            0 -> {
                binding.fragmentOnboardingProgressoEsquerda.setBackgroundResource(R.color.orange_700)
                binding.fragmentOnboardingProgressoCentro.setBackgroundResource(R.color.orange_200)
                binding.fragmentOnboardingProgressoDireita.setBackgroundResource(R.color.orange_200)
            }
            1 -> {
                binding.fragmentOnboardingProgressoEsquerda.setBackgroundResource(R.color.orange_200)
                binding.fragmentOnboardingProgressoCentro.setBackgroundResource(R.color.orange_700)
                binding.fragmentOnboardingProgressoDireita.setBackgroundResource(R.color.orange_200)
            }
            2 -> {
                binding.fragmentOnboardingProgressoEsquerda.setBackgroundResource(R.color.orange_200)
                binding.fragmentOnboardingProgressoCentro.setBackgroundResource(R.color.orange_200)
                binding.fragmentOnboardingProgressoDireita.setBackgroundResource(R.color.orange_700)
            }
        }
    }
}
