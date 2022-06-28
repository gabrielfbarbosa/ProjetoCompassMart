package br.com.compass.compassmart.ui.fragment.tela_login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {

    val erroEmail: MutableLiveData<String> = MutableLiveData()

    fun login(email: String?, senha: String?) {

        if(email.isNullOrBlank()) {
            erroEmail.postValue("Digite seu email")
        } else if(senha.isNullOrBlank()) {
            erroEmail.postValue("")
//            erroSenha.postValue("Preencha uma senha")
        } else {
//            navegueParaHome.postValue(Unit)
        }
    }
}
