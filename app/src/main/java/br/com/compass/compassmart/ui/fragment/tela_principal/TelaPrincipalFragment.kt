package br.com.compass.compassmart.ui.fragment.tela_principal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import br.com.compass.compassmart.R
import br.com.compass.compassmart.databinding.FragmentTelaPrincipalBinding
import br.com.compass.compassmart.ui.Produto

class TelaPrincipalFragment : Fragment() {
    private var _binding: FragmentTelaPrincipalBinding? = null
    private val binding get() = _binding!!
    private val produtos = mutableListOf<Produto>(
        Produto(
            "Galaxy A52 5G",
            "",
            "R$ 1779,00",
            R.drawable.produto_galaxy_a52
        ), Produto(
            "Galaxy A52 5G",
            "",
            "R$ 1779,00",
            R.drawable.produto_galaxy_a52
        ), Produto(
            "Galaxy A52 5G",
            "",
            "R$ 1779,00",
            R.drawable.produto_galaxy_a52
        ), Produto(
            "Galaxy A52 5G",
            "",
            "R$ 1779,00",
            R.drawable.produto_galaxy_a52
        ), Produto(
            "Galaxy A52 5G",
            "",
            "R$ 1779,00",
            R.drawable.produto_galaxy_a52
        ), Produto(
            "Galaxy A52 5G",
            "",
            "R$ 1779,00",
            R.drawable.produto_galaxy_a52
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentTelaPrincipalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fragmentTelaPrincipalRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.fragmentTelaPrincipalRecyclerView.adapter = TelaPrincipalAdapter(produtos,
            object : TelaPrincipalAdapter.MeuOnClickListener {
                override fun onClick(produto: Produto) {
                    findNavController().navigate(TelaPrincipalFragmentDirections.actionProdutosFragmentToDetalhesDoProdutoFragment(
                        produto))
                }
            }
        )
    }
}