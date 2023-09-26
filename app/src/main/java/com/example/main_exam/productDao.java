package com.example.main_exam;

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface productDao {

    @Insert
    fun addproduct(productmodel: productmodel)

    @Query("SELECT * FROM produt")
    fun getproduct():List<productmodel>

    @Delete
    fun deleteproduct(product : productmodel)

    @Update
    fun updateproduct(product :  productmodel)


}