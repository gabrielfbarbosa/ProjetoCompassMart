package br.com.compass.compassmart.ui.fragment.tela_carrinhocompras

import android.content.Context
import androidx.appcompat.app.AlertDialog
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

    fun atualizaQtd(produto: Produto, context: Context) {
        viewModelScope.launch {
            alterado.value = false
        if (produto.amount < 1) {
                AlertDialog.Builder(context)
                    .setTitle("Remover item do carrinho?")
                    .setPositiveButton("Sim") { _, _ ->
                        DbProvider.getCartDao().deletaProduto(produto)
                        getProdutos()
                    }
                    .setNegativeButton("Não", null)
                    .create()
                    .show()
            } else {
                DbProvider.getCartDao().updateProduto(produto)
            }
            alterado.value = true
        }
    }

    fun deleteProduto(produto: Produto, context: Context){
        viewModelScope.launch {
            alterado.value = false
            DbProvider.getCartDao().deletaProduto(produto)
            alterado.value = true
        }
    }
}