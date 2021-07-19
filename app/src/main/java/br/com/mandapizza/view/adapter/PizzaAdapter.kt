package br.com.mandapizza.view.adapter

import android.content.Intent
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.mandapizza.R
import br.com.mandapizza.model.Pizza
import br.com.mandapizza.view.PizzaDetalheActivity
import com.google.gson.Gson
import com.squareup.picasso.Picasso

class PizzaAdapter : RecyclerView.Adapter<ViewHolderPizza>() {

    val lista = mutableListOf<Pizza>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPizza {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_lista_pizzas, parent, false)
        return ViewHolderPizza(view)
    }

    override fun onBindViewHolder(holder: ViewHolderPizza, position: Int) {
        val pizza = lista[position]

        Picasso.get().load(pizza.imageUrl).into(holder.imagem)
        holder.titulo.text = pizza.name
        holder.valor.text = pizza.priceP.toString()

        holder.itemView.setOnClickListener {
            holder.itemView.context.startActivity(
                Intent(holder.itemView.context, PizzaDetalheActivity::class.java)
                    .putExtra("pizza", Gson().toJson(pizza))
            )
        }
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    fun addPizzas(movies: List<Pizza>){
        lista.addAll(movies)
        notifyDataSetChanged()
    }

    fun abrePizzaDetalhe(pizzaClicada: Pizza){

    }
}

class ViewHolderPizza(itemView: View) : RecyclerView.ViewHolder(itemView){
    val imagem: ImageView = itemView.findViewById(R.id.layout_lista_piz_ivPizza)
    val titulo: TextView = itemView.findViewById(R.id.layout_lista_piz_tvTitulo)
    val valor: TextView = itemView.findViewById(R.id.layout_lista_piz_tvValor)
}