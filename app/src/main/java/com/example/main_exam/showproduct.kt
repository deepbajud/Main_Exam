package com.example.main_exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.main_exam.databinding.ActivityShowproductBinding

class showproduct : AppCompatActivity() {
    lateinit var binding: ActivityShowproductBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityShowproductBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        db= product.getinstane(this)
        var list = db.().getproduct()

        adepetr= Productadepter(list)
        binding.recycledata.layoutManager= GridLayoutManager(this,2)
        binding.recycledata.adapter = adepetr



    }
    companion object{
        lateinit var db:product
        lateinit var adepetr:Productadepter
        lateinit var binding:ActivityShowproductBinding

        fun update(){
            var list = db.product().getproduct()
            adepetr=Productadepter(list)
            binding.recycledata.adapter = adepetr
        }
    }
}