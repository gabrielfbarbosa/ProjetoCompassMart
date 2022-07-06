package br.com.compass.compassmart.ui.fragment.tela_produtos

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.compass.compassmart.ui.api.ApiProvider
import br.com.compass.compassmart.ui.api.ProdutoResponse
import kotlinx.coroutines.launch

class ProdutosViewModel: ViewModel() {

    val produtos: MutableLiveData<List<ProdutoResponse>> = MutableLiveData()

    fun getProduto(){
        viewModelScope.launch {
            produtos.value = ApiProvider.getApiService().getProduto()
//            println(produtos)
        }
    }


}