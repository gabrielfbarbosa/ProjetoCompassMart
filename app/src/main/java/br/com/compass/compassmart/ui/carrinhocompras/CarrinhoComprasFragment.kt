package br.com.compass.compassmart.ui.carrinhocompras

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.compass.compassmart.R
import br.com.compass.compassmart.databinding.FragmentCarrinhoComprasBinding
import br.com.compass.compassmart.databinding.FragmentOnboardingBinding

class CarrinhoComprasFragment : Fragment() {

    private var _binding: FragmentCarrinhoComprasBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCarrinhoComprasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
    }

}