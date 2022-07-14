package br.com.compass.compassmart.ui.fragment.tela_detalhes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.compass.compassmart.data.DbProvider
import br.com.compass.compassmart.data.Produto

class DetalhesDoProdutoViewModel : ViewModel() {

    val produto: MutableLiveData<List<Produto>> = MutableLiveData()

    fun addProdutoCarrinho(produto: Produto) {
        DbProvider.getCartDao().insertProduto(produto)
    }
}