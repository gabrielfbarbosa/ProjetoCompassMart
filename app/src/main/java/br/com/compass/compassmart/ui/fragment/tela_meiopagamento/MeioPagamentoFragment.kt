package br.com.compass.compassmart.ui.fragment.tela_meiopagamento

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import br.com.compass.compassmart.R
import br.com.compass.compassmart.data.DbProvider
import br.com.compass.compassmart.data.Produto
import br.com.compass.compassmart.databinding.FragmentMeioPagamentoBinding
import java.text.FieldPosition

class MeioPagamentoFragment : Fragment(), View.OnClickListener {

    private val viewModel: MeioPagamentoViewModel by viewModels()
    private var _binding: FragmentMeioPagamentoBinding? = null
    private val binding get() = _binding!!
    private val preferenceLoginKey = "chaveLogin"
    private val preferenceTokenKey = "token"

//    private var escolha: Int? = null //Para saber qual metodo de pagamento foi selecionado

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentMeioPagamentoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cardCompassPay.setOnClickListener(this)
        binding.cardPix.setOnClickListener(this)

        binding.btnContinuar.setOnClickListener {
            pegarToken()?.let {
                viewModel.retornaCodigoPix(it)
            }
        }

        viewModel.vaiParaParabenizacao.observe(viewLifecycleOwner) {
            findNavController().navigate(MeioPagamentoFragmentDirections.actionMeioPagamentoToParabenizacaoFragment())
            Toast.makeText(requireContext(), "Pix: $it", Toast.LENGTH_LONG).show()
        }
    }

    private fun pegarToken():String? {
        val sharedPreferences =
            requireActivity().getSharedPreferences(preferenceLoginKey, Context.MODE_PRIVATE)
        return sharedPreferences.getString(preferenceTokenKey, null)
    }

    override fun onClick(v: View) {

        if (v.id == binding.cardCompassPay.id) {
            binding.constraintLayoutCompassPay.setBackgroundResource(R.color.orange_500)
            binding.constraintLayoutPix.setBackgroundResource(R.color.white)
//            escolha = 0
        }
        if (v.id == binding.cardPix.id) {
            binding.constraintLayoutCompassPay.setBackgroundResource(R.color.white)
            binding.constraintLayoutPix.setBackgroundResource(R.color.orange_500)
//            escolha = 1
        }
    }
}
