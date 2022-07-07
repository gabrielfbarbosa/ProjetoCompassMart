package br.com.compass.compassmart.ui.fragment.tela_detalhes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.compass.compassmart.data.DbProvider
import br.com.compass.compassmart.data.Produto
import kotlinx.coroutines.launch

class DetalhesDoProdutoViewModel: ViewModel() {

    val produto: MutableLiveData<List<Produto>> = MutableLiveData()


    fun addProdutoCarrinho(produto: Produto) {
        viewModelScope.launch {
//            if(DbProvider.getCartDao().existeProduto(produto.id)){
                DbProvider.getCartDao().insertProduto(produto)
//            }
        }
    }

}