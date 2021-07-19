package br.com.mandapizza.repository

import br.com.mandapizza.network.EndPointApi
import br.com.mandapizza.network.RetrofitInit

class RepositoryPizza {

    private var url = "https://p3teufi0k9.execute-api.us-east-1.amazonaws.com/v1/"

    private val service = RetrofitInit(url).create(EndPointApi::class)

    suspend fun getPizzas() = service.getPizzas()



}