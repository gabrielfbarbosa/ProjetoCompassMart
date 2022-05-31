package br.com.compass.compassmart.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import br.com.compass.compassmart.R

class OnboardingMain : Fragment() {

    // Busca as "bolinhas" de progresso
    private lateinit var progresso1: ImageView
    private lateinit var progresso2: ImageView
    private lateinit var progresso3: ImageView

    // Busca intens de visualização
    private lateinit var viewPager2: ViewPager2
    private var tituloList = mutableListOf<String>()
    private var descricaoList = mutableListOf<String>()
    private var imagemList = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_onboarding_main, container, false)

        viewPager2 = view.findViewById(R.id.onboarding_main_view_pager)
        progresso1 = view.findViewById(R.id.onboarding_main_progresso_esquerda)
        progresso2 = view.findViewById(R.id.onboarding_main_progresso_centro)
        progresso3 = view.findViewById(R.id.onboarding_main_progresso_direita)

        conteudo()
        viewPager2.adapter = OnboardingAdpter(tituloList, descricaoList, imagemList)

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

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
        return view
    }


    // Adiciona os conteudos dos cards
    fun adicionaNaLista(titulo : String, descricao : String, imagem: Int){
        tituloList.add(titulo)
        descricaoList.add(descricao)
        imagemList.add(imagem)
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
        when (viewPager2.currentItem) {
            0 -> {
                progresso1.setBackgroundResource(R.color.orange_700)
                progresso2.setBackgroundResource(R.color.orange_200)
                progresso3.setBackgroundResource(R.color.orange_200)
            }
            1 -> {
                progresso1.setBackgroundResource(R.color.orange_200)
                progresso2.setBackgroundResource(R.color.orange_700)
                progresso3.setBackgroundResource(R.color.orange_200)
            }
            2 -> {
                progresso1.setBackgroundResource(R.color.orange_200)
                progresso2.setBackgroundResource(R.color.orange_200)
                progresso3.setBackgroundResource(R.color.orange_700)
            }
        }
    }


}