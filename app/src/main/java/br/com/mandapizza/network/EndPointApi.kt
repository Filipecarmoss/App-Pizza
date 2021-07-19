package br.com.mandapizza.network

import br.com.mandapizza.model.Pizza
import br.com.mandapizza.model.PizzasServidor
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface EndPointApi {

    @GET("pizza")
    suspend fun getPizzas() : PizzasServidor

    @POST("signin")
    suspend fun getLogin() : PizzasServidor

}