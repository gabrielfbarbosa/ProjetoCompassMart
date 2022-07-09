package br.com.compass.compassmart.ui.fragment.util

import android.content.Context
import android.content.SharedPreferences
import br.com.compass.compassmart.ui.activity.MainActivity

class SharedPreference(val context: Context) {

    private val preferenceLoginKey = "chaveLogin"
    private val preferenceTokenKey = "token"
    private val prefs = context.getSharedPreferences(preferenceLoginKey, Context.MODE_PRIVATE)

    fun salvaToken(token: String) {
        with(prefs.edit()) {
            putString(preferenceTokenKey, token)
            apply()
        }
    }

    fun pegarToken(): String? {
        return prefs.getString(preferenceTokenKey, null)
    }

    fun pegaAcesso(key: String) : Boolean {
        return prefs.getBoolean(key, false)
    }

    fun insereAcesso(key: String, valor: Boolean) {
        prefs.edit().putBoolean(key, valor).apply()
    }

}


