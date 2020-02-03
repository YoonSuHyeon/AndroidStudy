package com.example.shoppingexample3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class RecyclerAdapter (private  val items: ArrayList<ShoppingItem>):
        RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){
    class ViewHolder(v:View):RecyclerView.ViewHolder(v){
        private  var view:View =v
        fun bind(listener:View.OnClickListener,item:ShoppingItem){
            view.thumbnail.setImageDrawable(item.image)
            view.title.text=item.title
            view.setOnClickListener(listener)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val inflatedView =LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return RecyclerAdapter.ViewHolder(inflatedView)
    }

    override fun getItemCount()=items.size


    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        val item= items[position]
        val listener = View.OnClickListener {
            Toast.makeText(it.context,"Clicked:${item.title}",Toast.LENGTH_SHORT).show()
        }
        holder.apply {
            bind(listener,item)
            itemView.tag=item
        }
    }


}