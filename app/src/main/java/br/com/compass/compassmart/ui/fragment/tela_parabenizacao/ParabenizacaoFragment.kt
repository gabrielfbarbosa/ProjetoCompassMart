package br.com.compass.compassmart.ui.fragment.tela_parabenizacao

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import br.com.compass.compassmart.R
import br.com.compass.compassmart.databinding.FragmentParabenizacaoBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class ParabenizacaoFragment : Fragment() {

    private val produtoArgs by navArgs<ParabenizacaoFragmentArgs>()
    private var _binding: FragmentParabenizacaoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentParabenizacaoBinding.inflate(inflater, container, false)
        val view = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_nav)
        view.visibility = View.GONE
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.chavePix.text = "Chave Pix:\n ${produtoArgs.pix}"
        binding.fragmentParabenizacaoBtnInicio.setOnClickListener{
            findNavController().navigate(ParabenizacaoFragmentDirections.actionParabenizacaoFragmentToProdutosFragment())
        }
    }
}