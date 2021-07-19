package br.com.mandapizza.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import br.com.mandapizza.R
import br.com.mandapizza.model.Usuario
import br.com.mandapizza.repository.RepositoryUsuario
import org.jetbrains.anko.doAsync

class LoginActivity : AppCompatActivity(){

//    //COMPONENTES
    val etUsuario by lazy { findViewById<EditText>(R.id.log_etUsuario) }
    val etSenha by lazy { findViewById<EditText>(R.id.log_etSenha) }
    val bEntrar by lazy { findViewById<Button>(R.id.log_bEntrar) }

    //OBJETOS

    //VARIAVEIS COMUNS

//
    companion object {
        val TAG = "RegisterActivity"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


//        //settings
        bEntrar.setOnClickListener {
            submitForm()
            RepositoryUsuario()

        }


    }




    //INICIO

    private fun login(email: String, passowrod: String) {

        startActivity(
            Intent(this, PizzaActivity::class.java)
        )
    }


    //FORM
    private fun exibeToast(mensagem: String){
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
    }
    private fun verificaUsuario():Boolean{
        if(etUsuario.text.toString().trim().equals("")){
            exibeToast("O campo Usuário tem preenchimento obrigatório!")
            return false;
        }
        return true;
    }
    private fun verificaSenha():Boolean{
        if(etSenha.text.toString().trim().equals("")){
            exibeToast("O campo Senha tem preenchimento obrigatório!")
            return false;
        }
        return true;
    }
    private fun submitForm(){

        if(!verificaUsuario()){
            return;
        }
        if(!verificaSenha()){
            return;
        }

        login(etUsuario.text.toString().trim(), etUsuario.text.toString().trim());
    }


    //AUXILIARES


    //SOBRESCRITAS

}