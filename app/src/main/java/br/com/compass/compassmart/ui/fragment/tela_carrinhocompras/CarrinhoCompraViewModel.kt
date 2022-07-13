package br.com.compass.compassmart.ui.fragment.tela_carrinhocompras

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.compass.compassmart.data.DbProvider
import br.com.compass.compassmart.data.Produto
import kotlinx.coroutines.launch

class CarrinhoCompraViewModel : ViewModel() {

    val produtos: MutableLiveData<List<Produto>> = MutableLiveData()
    val alterado: MutableLiveData<Boolean> = MutableLiveData()

    fun getProdutos() {
        viewModelScope.launch {
            produtos.value = DbProvider.getCartDao().getAll()
        }
    }

    fun atualizaQtd(produto: Produto) {
        viewModelScope.launch {
            alterado.value = false
            if (produto.amount < 1) {
                DbProvider.getCartDao().deletaProduto(produto)
            } else {
                DbProvider.getCartDao().updateProduto(produto)
            }
            alterado.value = true
        }
    }

    fun deleteProduto(produto: Produto){
        viewModelScope.launch {
            DbProvider.getCartDao().deletaProduto(produto)
        }
    }
}