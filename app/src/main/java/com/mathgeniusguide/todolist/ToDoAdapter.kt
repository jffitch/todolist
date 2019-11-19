package com.mathgeniusguide.todolist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_item.view.*

class ToDoAdapter (private val items: ArrayList<ToDoItem>, val context: Context) : RecyclerView.Adapter<ToDoAdapter.ViewHolder> () {
    private var rowListener: ItemRowListener = context as ItemRowListener
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val i = items[position]
        // change "i.itemText" to desired text
        holder.itemText.text = i.itemText
        holder.itemDone.isChecked = i.done ?: false
        holder.itemDone.setOnClickListener {
            rowListener.modifyItemState(i.objectId!!, !i.done!!)
        }
        holder.itemDelete.setOnClickListener {
            rowListener.onItemDelete(i.objectId!!)
        }
    }

    class ViewHolder (view : View) : RecyclerView.ViewHolder(view) {
        val itemDone = view.itemDone
        val itemText = view.itemText
        val itemDelete = view.itemDelete
        val parent = view
    }
}