package com.example.selflearning

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.selflearning.model.ListUserModel

class RVAdaptor : RecyclerView.Adapter<RVAdaptor.ViewHolder>(){

    private  var items: ListUserModel? = null
    private var itemClickListener: ItemClickListener? = null

    fun setItems(items: ListUserModel) {
        this.items = items
        Log.e("on item Clicked", "check 1")
        notifyDataSetChanged()
    }

    interface ItemClickListener {
        fun onItemClick(itemId: String)
    }

    fun setItemClickListener(listener: ItemClickListener) {
        Log.e("on item Clicked", "check 2")
        this.itemClickListener = listener
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        //use TextView view
        val textViewName : TextView = itemView.findViewById(R.id.universityName)
        val textViewState : TextView = itemView.findViewById(R.id.universityState)
        val textViewCountry : TextView = itemView.findViewById(R.id.universityCountry)


        init {
            itemView.setOnClickListener {
                Log.e("on item Clicked", "check 3")
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val clickedItem = items?.data?.get(position)
                    Log.e("${clickedItem?.id}", "id passed or not")
                    clickedItem?.id?.let { itemClickListener?.onItemClick(it.toString()) }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //creates a viewHolder every times it needed
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false)
        Log.e("on item Clicked", "check 4")
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //bind data with the ViewHolder
        //we need an array of string
        Log.e("on item Clicked", "check 5")
        holder.textViewName.text = items?.data?.get(position)?.first_name
        holder.textViewState.text = items?.data?.get(position)?.last_name
        holder.textViewCountry.text = items?.data?.get(position)?.id.toString()
    }

    override fun getItemCount(): Int {
        Log.e("on item Clicked", "check 6")
        return items?.data?.size ?: 0
    }

}