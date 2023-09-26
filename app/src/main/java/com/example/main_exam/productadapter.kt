package com.example.main_exam

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Productadepter(list: List<productmodel>) :
    RecyclerView.Adapter<Productadepter.productholder>() {
    lateinit var context: Context
    var list=list
    var db = product.getinstane(context)

    class productholder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var id  = itemView.findViewById<TextView>(R.id.txtid)
        var name = itemView.findViewById<TextView>(R.id.txtname)
        var datils= itemView.findViewById<TextView>(R.id.txtdetails)
        var price=itemView.findViewById<TextView>(R.id.txtprice)
        var rating=itemView.findViewById<RatingBar>(R.id.rtproduct)
        var delete=itemView.findViewById<Button>(R.id.ivDelete)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): productholder {
        context = parent.context
        return  productholder(LayoutInflater.from(parent.context).inflate(R.layout.item_product,parent,false))

    }

    override fun getItemCount(): Int {
        return  list.size
    }

    override fun onBindViewHolder(holder: productholder, position: Int) {
        holder.id.text=list[position].id.toString()
        holder.name.text=list[position].name
        holder.datils.text=list[position].details
        holder.price.text=list[position].price.toString()
        holder.rating.rating=list[position].rating

        holder.itemView.setOnClickListener {
            var dialog = Dialog(context)
            dialog.setContentView(R.layout.activity_main)

            var edtname=dialog.findViewById<EditText>(R.id.edit_text1)
            var edtdetils=dialog.findViewById<EditText>(R.id.edit_text2)
            var edtprice=dialog.findViewById<EditText>(R.id.edit_text3)
            var rating = dialog.findViewById<RatingBar>(R.id.rtproduct)
            var update = dialog.findViewById<Button>(R.id.update)

            edtname.setText(list.get(position).name)
            edtdetils.setText(list.get(position).details)
            edtprice.setText(list.get(position).price)
            rating.rating=(list.get(position).rating)

            update.setOnClickListener {
                var data= productmodel(edtname.text.toString(),edtprice.text.toString().toInt(),edtdetils.text.toString(),rating.rating)
                data.id=list[position].id

                db.product().updateproduct(data)
                dialog.dismiss()
                showproduct.update()

            }
        }
        holder.delete.setOnClickListener {
            db.product().deleteproduct(list.get(position))
            showproduct.update()
        }

    }
}