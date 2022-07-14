package br.com.compass.compassmart.ui.fragment.tela_meiopagamento

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import br.com.compass.compassmart.R
import br.com.compass.compassmart.databinding.FragmentMeioPagamentoBinding
import br.com.compass.compassmart.ui.fragment.util.SharedPreference
import com.google.android.material.bottomnavigation.BottomNavigationView

class MeioPagamentoFragment : Fragment(), View.OnClickListener {

    private val viewModel: MeioPagamentoViewModel by viewModels()
    private var _binding: FragmentMeioPagamentoBinding? = null
    private val binding get() = _binding!!
    private var escolha: Int = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentMeioPagamentoBinding.inflate(inflater, container, false)
        val view = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_nav)
        view.visibility = View.GONE
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnContinuar.setOnClickListener {
            Toast.makeText(requireContext(), "Selecione um método de pagamento", Toast.LENGTH_SHORT)
                .show()
        }

        binding.cardCompassPay.setOnClickListener(this)

        binding.cardPix.setOnClickListener(this)
    }

    override fun onClick(v: View) {

        when (v.id) {
            binding.cardCompassPay.id -> {
                binding.constraintLayoutCompassPay.setBackgroundResource(R.color.orange_500)
                binding.constraintLayoutPix.setBackgroundResource(R.color.white)
                escolha = 1
            }
            binding.cardPix.id -> {
                binding.constraintLayoutCompassPay.setBackgroundResource(R.color.white)
                binding.constraintLayoutPix.setBackgroundResource(R.color.orange_500)
                escolha = 2
            }
        }
        if (escolha != 1 && escolha != 2){
            Toast.makeText(requireContext(), "Selecione um método de pagamento", Toast.LENGTH_SHORT).show()
        }
        if (escolha == 1) {
            binding.btnContinuar.setOnClickListener {
                binding.constraintLayoutCompassPay.setBackgroundResource(R.color.orange_500)
                binding.constraintLayoutPix.setBackgroundResource(R.color.white)
                val launchIntent: Intent? =
                    requireActivity().packageManager.getLaunchIntentForPackage("bank.com.br.compassbank")
                try {
                    startActivity(launchIntent)
                } catch (e: Exception) {
                    // Define what your app should do if no activity can handle the intent.
                    e.printStackTrace()
                }
            }
        }
        if (escolha == 2) {
            binding.btnContinuar.setOnClickListener {
                SharedPreference(requireContext()).pegarToken()?.let {
                    viewModel.retornaCodigoPix(it)
                }

                viewModel.vaiParaParabenizacao.observe(viewLifecycleOwner) {
                    view?.let { view ->
                        Navigation.findNavController(view)
                            .navigate(MeioPagamentoFragmentDirections.actionMeioPagamentoToParabenizacaoFragment(it))
                    }
                }
            }
        }
    }
}

//Abrir CompassPay
//    private fun vaiParaCompassPay() {
//        binding.cardCompassPay.setOnClickListener {
//            val launchIntent: Intent? =
//                requireActivity().packageManager.getLaunchIntentForPackage("bank.com.br.compassbank")
//            try {
//                startActivity(launchIntent)
//            } catch (e: Exception) {
//                // Define what your app should do if no activity can handle the intent.
//                e.printStackTrace()
//            }
//        }
//    }

