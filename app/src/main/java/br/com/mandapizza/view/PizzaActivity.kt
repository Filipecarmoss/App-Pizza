package br.com.mandapizza.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.mandapizza.R
import br.com.mandapizza.view.adapter.PizzaAdapter
import br.com.mandapizza.viewmodel.PizzaViewModel

class PizzaActivity : AppCompatActivity() {

    //COMPONENTES
    private val mProgress by lazy { findViewById<ProgressBar>(R.id.layout_pro_pad_pbProgress) }

    //OBJETOS
    lateinit var mAdapter: PizzaAdapter
    private val mViewModel by lazy { ViewModelProviders.of(this).get(PizzaViewModel::class.java) }

    //VARIÁVEIS COMUNS

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pizza)

        val recycler = findViewById<RecyclerView>(R.id.mai_rvPizzas)

        //config recycler
        mAdapter = PizzaAdapter()
        recycler.adapter = mAdapter
        val layoutManager = LinearLayoutManager(this)
        recycler.layoutManager = layoutManager

        //recycler.addOnScrollListener(recyclerScrollListener)

        mViewModel.listaPizzas.observe(this) {pizzas ->
            //enableRecyclerScrollPaging()

            Log.i("TAG", "Essa é a quantidade de pizzas: ${pizzas.size}");

            mAdapter.addPizzas(pizzas)
        }

        mViewModel.progress.observe(this) {
            if (it) {
                mProgress.visibility = View.VISIBLE
            }
            else {
                mProgress.visibility = View.GONE
            }
        }

        mViewModel.errorMessage.observe(this, Observer {
            it?.let {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            }
        })

    }


    //INICIO


    //AUXILIARES

    //SOBRESCRITAS

}