package com.areeb.notes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList

class RecyclerAdapter(val context: Context, val listener: MainActivity):RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    val allNotes=ArrayList<Notes>()
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {


        val text_items=itemView.findViewById<TextView>(R.id.text_item)
        val delete_btn = itemView.findViewById<ImageView>(R.id.delete_btn)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val  viewHolder = ViewHolder(LayoutInflater.from(context).inflate(R.layout.itemview,parent,false))
        viewHolder.delete_btn.setOnClickListener{
            listener.onItemClicked(allNotes[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentNote =allNotes[position]
        holder.text_items.text=currentNote.text
    }

    override fun getItemCount(): Int {
        return  allNotes.size
    }

    fun updateList(newsList: List<Notes>){
        allNotes.clear()
        allNotes.addAll(newsList)
        notifyDataSetChanged()
    }


}

interface InotesRVAdapter{
    fun onItemClicked(notes: Notes)
}