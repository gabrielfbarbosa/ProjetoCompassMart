package br.com.compass.compassmart.data

import androidx.room.*

@Dao
interface CartDao {
    @Query("SELECT * FROM produto")
    fun getAll(): List<Produto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduto (produto: Produto)

    @Delete
    fun deletaProduto(produto: Produto)

    @Query("SELECT id FROM produto")
    fun existeProduto () : String

}