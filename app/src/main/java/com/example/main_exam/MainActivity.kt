package com.example.main_exam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.main_exam.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var db =product.getinstane(this)
        binding.addbtn.setOnClickListener {
            var data= productmodel(binding.editText1.text.toString(),
                binding.editText2.text.toString().toInt(),
                binding.editText3.text.toString(),
                binding.edtRate.rating


            )
            db.product().addproduct(data)
        }

        binding.show.setOnClickListener {
            startActivity(Intent(this,Showproduct::class.java))
        }


    }
}