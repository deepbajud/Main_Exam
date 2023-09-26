package com.example.main_exam

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "produt")
class productmodel(

    @ColumnInfo(name = "name") var name:String,
    @ColumnInfo(name = "price") var price: Int,
    @ColumnInfo(name = "details") var details:String,
    @ColumnInfo(name = "rating") var rating: Float
) {

    @PrimaryKey(autoGenerate = true)@ColumnInfo(name = "id")var id:Int=0

}