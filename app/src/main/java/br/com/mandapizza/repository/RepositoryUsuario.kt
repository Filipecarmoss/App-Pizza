package br.com.mandapizza.repository

import br.com.mandapizza.model.Usuario
import br.com.mandapizza.network.EndPointApi
import br.com.mandapizza.network.RetrofitInit
import com.google.gson.Gson
import okhttp3.Credentials
import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.URL

class RepositoryUsuario {

    private var url = "https://p3teufi0k9.execute-api.us-east-1.amazonaws.com/v1/"

    private val service = RetrofitInit(url).create(EndPointApi::class)

    suspend fun getLogin() = service.getLogin()

}