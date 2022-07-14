package br.com.compass.compassmart.ui.fragment.tela_meiopagamento

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.compass.compassmart.api.ApiProvider
import br.com.compass.compassmart.api.PixPayload
import br.com.compass.compassmart.data.DbProvider
import br.com.compass.compassmart.data.Produto
import kotlinx.coroutines.launch

class MeioPagamentoViewModel: ViewModel() {

    val vaiParaParabenizacao: MutableLiveData<String> = MutableLiveData()

    fun retornaCodigoPix(token: String){
        val produtos: List<Produto> = DbProvider.getCartDao().getAll()
        val produtosPayload: List<PixPayload> = produtos.map { PixPayload(it.id, it.amount) }

        viewModelScope.launch {
            val response = ApiProvider.getApiService().getPix(token, produtosPayload)
            vaiParaParabenizacao.postValue(response.pix)
        }
    }
}