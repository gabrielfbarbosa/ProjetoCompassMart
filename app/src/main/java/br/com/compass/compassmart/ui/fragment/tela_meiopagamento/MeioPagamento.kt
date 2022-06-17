package br.com.compass.compassmart.ui.fragment.tela_meiopagamento

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import br.com.compass.compassmart.R
import br.com.compass.compassmart.databinding.FragmentMeioPagamentoBinding
import br.com.compass.compassmart.databinding.FragmentOnboardingBinding

class MeioPagamento : Fragment() {


    private var _binding: FragmentMeioPagamentoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentMeioPagamentoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}