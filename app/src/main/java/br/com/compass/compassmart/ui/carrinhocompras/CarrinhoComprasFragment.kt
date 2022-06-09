package br.com.compass.compassmart.ui.carrinhocompras

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.compass.compassmart.R
import br.com.compass.compassmart.databinding.FragmentCarrinhoComprasBinding
import br.com.compass.compassmart.databinding.FragmentOnboardingBinding
import br.com.compass.compassmart.databinding.ItemCarrinhoCompraBinding
import br.com.compass.compassmart.ui.onboarding.OnboardingAdapter
import br.com.compass.compassmart.ui.onboarding.model.InformacoesModel

class CarrinhoComprasFragment : Fragment() {

    private var _binding: FragmentCarrinhoComprasBinding? = null
    private val binding get() = _binding!!
    private var _bindingItem: ItemCarrinhoCompraBinding? = null
    private val bindingItem get() = _binding!!
    private var dataProduto = mutableListOf<InformacoesModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCarrinhoComprasBinding.inflate(inflater, container, false)



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _bindingItem?.itemCarrinhoCompraDescricao?.text = "Teste Carrinho"

        super.onViewCreated(view, savedInstanceState)
    }

//    private fun adicionaNaListaProduto(titulo: String, descricao: String, imagem: Int) {
//        dataProduto.add(InformacoesModel(titulo, descricao, imagem))
//    }
//
//    // Conteudo do carrinho
//    private fun conteudoProduto() {
//
////        val onboardingText = resources.getStringArray((R.array.onboarding))
//
//        adicionaNaListaProduto(
//            "Teste",
//            "teste",
//            R.drawable.img_onboarding1
//        )
//
//    }

}