package br.com.compass.compassmart.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.compass.compassmart.R
import br.com.compass.compassmart.data.DbProvider

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DbProvider.applicationContext = applicationContext
        setContentView(R.layout.activity_main)
    }
}
