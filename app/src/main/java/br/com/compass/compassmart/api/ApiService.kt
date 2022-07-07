package br.com.compass.compassmart.api

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("login")
    suspend fun getLogin(@Body loginPayload: LoginPayload): LoginResponse

    @GET("compassmart/products")
    suspend fun getProduto(): List<ProdutoResponse>
}
