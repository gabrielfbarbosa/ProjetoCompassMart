package br.com.compass.compassmart.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {

    @POST("login")
    suspend fun getLogin(@Body loginPayload: LoginPayload): Response<LoginResponse>

    @GET("compassmart/products")
    suspend fun getProduto(): List<ProdutoResponse>

    @POST("compassmart/buy")
    suspend fun getPix(
        @Header("token") token: String,
        @Body pixPayload: List<PixPayload>
    ): PixResponse
}
