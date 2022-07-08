package br.com.compass.compassmart.ui.fragment.tela_principal

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.compass.compassmart.api.ApiProvider
import br.com.compass.compassmart.api.ProdutoResponse
import kotlinx.coroutines.launch

class TelaPrincipalViewModel : ViewModel() {

    val mainProdutos: MutableLiveData<List<ProdutoResponse>> = MutableLiveData()

    fun getMainProduto() {
        viewModelScope.launch {
            mainProdutos.value = ApiProvider.getApiService().getProduto()
        }
    }
}