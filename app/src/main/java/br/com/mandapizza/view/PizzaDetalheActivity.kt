package br.com.mandapizza.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import br.com.mandapizza.R
import br.com.mandapizza.model.Pizza
import com.google.gson.Gson
import com.squareup.picasso.Picasso

class PizzaDetalheActivity : AppCompatActivity() {

    //COMPONENTES
    val ivPizza by lazy { findViewById<ImageView>(R.id.piz_det_ivPizza) }
    val tvTitulo by lazy { findViewById<TextView>(R.id.piz_det_tvTitulo) }
    val tvValor by lazy { findViewById<TextView>(R.id.piz_det_tvValor) }
    val bComprar by lazy { findViewById<TextView>(R.id.piz_det_bComprar) }

    //OBJETOS

    //VARIÁVEIS COMUNS


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pizza_detalhe)

        //settings
        recebeDadosDaIntent()
        configuraListeners()
    }


    //INICIO
    private fun configuraTela(pizza: Pizza){
        tvTitulo.setText(pizza.name)
        tvValor.setText(""+pizza.priceG)
        Picasso.get().load(pizza.imageUrl).into(ivPizza)
    }
    private fun recebeDadosDaIntent(){

        var pizzaString : String = intent.getStringExtra("pizza").toString();

        var pizza: Pizza = Gson().fromJson(pizzaString, Pizza::class.java)

        if(pizza != null){
            configuraTela(pizza)
            return;
        }

        Toast.makeText(this, "Não foi possível obter a pizza clicada!", Toast.LENGTH_SHORT).show()
    }
    private fun configuraListeners(){
        bComprar.setOnClickListener {
            abreCheckout()
        }
    }


    //AUXILIARES
    private fun abreCheckout(){
        startActivity(
            Intent(this, CheckoutActivity::class.java)
        )
    }


    //SOBRESCRITAS


}