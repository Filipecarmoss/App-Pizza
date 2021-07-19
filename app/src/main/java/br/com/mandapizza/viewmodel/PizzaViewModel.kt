package br.com.mandapizza.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.mandapizza.model.Pizza
import br.com.mandapizza.repository.RepositoryPizza
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.net.UnknownHostException

class PizzaViewModel : ViewModel() {

    val listaPizzas = MutableLiveData<List<Pizza>>()
    val errorMessage = MutableLiveData<String>()
    val progress by lazy { MutableLiveData<Boolean>() }

    private val repository = RepositoryPizza()

    init {
        getPizzas()
    }

    fun getPizzas() = CoroutineScope(Dispatchers.IO).launch {
        try {
            progress.postValue(true)
            val retornoRepository = repository.getPizzas()
            Log.i("TAG", "Quantidade de pizzas: ${retornoRepository.size}")
            listaPizzas.postValue(retornoRepository)
        }
        catch (error: Throwable) {
            safeApi(error, errorMessage)
        }finally {
            progress.postValue(false)
        }
    }

}

fun safeApi(error: Throwable, errorMessage: MutableLiveData<String>) {
    when (error) {
        is HttpException -> errorMessage.postValue("Erro de conexão código: ${error.code()}")
        is UnknownHostException -> errorMessage.postValue("Verifique sua conexão")
    }
}