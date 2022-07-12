package br.com.compass.compassmart.ui.fragment.tela_parabenizacao

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.compass.compassmart.databinding.FragmentParabenizacaoBinding
import br.com.compass.compassmart.ui.fragment.tela_carrinhocompras.CarrinhoComprasFragmentDirections

class ParabenizacaoFragment : Fragment() {
    private var _binding: FragmentParabenizacaoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentParabenizacaoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fragmentParabenizacaoBtnInicio.setOnClickListener{
            findNavController().navigate(ParabenizacaoFragmentDirections.actionParabenizacaoFragmentToProdutosFragment())
        }
    }
}