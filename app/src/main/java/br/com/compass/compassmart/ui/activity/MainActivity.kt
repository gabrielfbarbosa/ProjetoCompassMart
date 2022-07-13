package br.com.compass.compassmart.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import br.com.compass.compassmart.R
import br.com.compass.compassmart.data.DbProvider
import br.com.compass.compassmart.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DbProvider.applicationContext = applicationContext
        setContentView(R.layout.activity_main)

//        val launchIntent: Intent? =
//            packageManager.getLaunchIntentForPackage("bank.com.br.compassbank")
//        try {
//            startActivity(launchIntent)
//        } catch (e: Exception) {
//            // Define what your app should do if no activity can handle the intent.
//            e.printStackTrace()
//        }

    }
}
