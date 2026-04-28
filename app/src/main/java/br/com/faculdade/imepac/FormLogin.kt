package br.com.faculdade.imepac

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class FormLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_login)

        // Comando para esconder o Toolbar (Barra superior roxa)
        supportActionBar?.hide()
    }
}