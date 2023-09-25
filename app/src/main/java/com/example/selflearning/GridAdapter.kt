package com.example.selflearning

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.selflearning.model.ListUserModel
import com.squareup.picasso.Picasso

class GridAdapter(var context: Context) : BaseAdapter(){

    private var items : ListUserModel? = null

    fun setItems(items: ListUserModel) {
        this.items = items
        Log.e("on item Clicked", "grid check 1")
        notifyDataSetChanged()
    }


    override fun getCount(): Int {
        return items?.data?.size ?:0
    }

    override fun getItem(position: Int): Any {
        return items?.data?.get(position) ?: 0
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view =  convertView ?: LayoutInflater.from(context).inflate(R.layout.item_grid, parent, false)
        val item = items?.data?.get(position)

        val imageView: ImageView = view.findViewById(R.id.imageViewGrid)
        val textView: TextView = view.findViewById(R.id.textViewGrid)

        Picasso.get().load(item?.avatar).into(imageView)
        textView.text = item?.first_name

        return view
    }
}