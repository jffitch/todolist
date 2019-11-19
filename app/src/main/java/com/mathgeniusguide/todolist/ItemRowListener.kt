package com.mathgeniusguide.todolist

interface ItemRowListener {
    fun modifyItemState(itemObjectId: String, isDone: Boolean)
    fun onItemDelete(itemObjectId: String)
}
