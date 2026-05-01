package br.com.faculdade.imepac

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FormLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_login)

        // Esconde a barra superior
        supportActionBar?.hide()

        // Cria uma variável e encontra o texto de cadastro pelo ID [cite: 1705, 1723]
        val linkFormCadastro = findViewById<TextView>(R.id.text_tela_cadastro)

        // Cria a ação de clique no texto [cite: 1705, 1724]
        linkFormCadastro.setOnClickListener {
            // Prepara a navegação para a FormCadastro usando Intent [cite: 1720, 1725]
            val telaCadastro = Intent(this, FormCadastro::class.java)
            // Inicia a nova tela
            startActivity(telaCadastro)
        }
    }
}