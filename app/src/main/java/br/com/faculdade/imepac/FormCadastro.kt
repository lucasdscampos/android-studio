package br.com.faculdade.imepac

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class FormCadastro : AppCompatActivity() {

    // 1. Criando as variáveis para receber os IDs (lateinit significa que inicializaremos depois)
    private lateinit var edit_nome: EditText
    private lateinit var edit_email: EditText
    private lateinit var edit_senha: EditText
    private lateinit var btnCadastrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_cadastro)

        // Esconde a barra superior
        supportActionBar?.hide()

        // 2. Conectando as variáveis com os IDs da tela visual
        edit_nome = findViewById(R.id.edit_nome)
        edit_email = findViewById(R.id.edit_email)
        edit_senha = findViewById(R.id.edit_senha)
        btnCadastrar = findViewById(R.id.bt_cadastrar)

        // 3. Ação feita pelo botão cadastrar
        btnCadastrar.setOnClickListener { view ->
            // Pegando o texto digitado e removendo espaços em branco com trim()
            val nome = edit_nome.text.toString().trim()
            val email = edit_email.text.toString().trim()
            val senha = edit_senha.text.toString().trim()

            // Verificando se tem algum campo vazio
            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                val mensagemErro = "Campos não preenchidos, tente novamente"
                val snackbar = Snackbar.make(view, mensagemErro, Snackbar.LENGTH_LONG)
                snackbar.show()
            } else {
                // Se tudo estiver preenchido, chama a função de salvar no banco
                cadastrarUsuario(view)
            }
        }
    }

    // 4. Função que comunica com o Firebase para salvar o usuário
    private fun cadastrarUsuario(view: View) {
        val email = edit_email.text.toString().trim()
        val senha = edit_senha.text.toString().trim()

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val mensagemOk = "Cadastro realizado com sucesso"
                    val snackbar = Snackbar.make(view, mensagemOk, Snackbar.LENGTH_LONG)
                    snackbar.show()
                } else {
                    val mensagemErro = "Erro ao cadastrar usuário"
                    val snackbar = Snackbar.make(view, mensagemErro, Snackbar.LENGTH_LONG)
                    snackbar.show()
                }
            }
    }
}