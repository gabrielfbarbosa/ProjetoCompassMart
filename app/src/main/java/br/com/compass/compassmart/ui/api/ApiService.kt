package br.com.compass.compassmart.ui.api

import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {

    @GET("compassmart/products")
    suspend fun getProduto() : List<ProdutoResponse>
}