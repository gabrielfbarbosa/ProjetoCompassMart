package br.com.compass.compassmart.ui.fragment.tela_login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.compass.compassmart.api.ApiProvider.getApiService
import br.com.compass.compassmart.api.LoginPayload
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    val erroEmail: MutableLiveData<String> = MutableLiveData()
    val erroSenha: MutableLiveData<String> = MutableLiveData()
    val navegueParaCarrinhoCompras: MutableLiveData<String> = MutableLiveData()

    fun validaLogin(email: String?, senha: String?) {
        if (email.isNullOrBlank()) {
            erroEmail.postValue("Digite seu email")
        } else if (senha.isNullOrBlank()) {
            erroEmail.postValue("")
            erroSenha.postValue("Digite uma senha")
        } else {
            viewModelScope.launch {
                val response = getApiService().getLogin(LoginPayload(email, senha))
                navegueParaCarrinhoCompras.postValue(response.token)
            }
        }
    }
}