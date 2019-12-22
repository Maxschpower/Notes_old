package com.nnnshei.notes.ui.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.nnnshei.notes.R

class NoteApdapter(
    private val values: List<String>
) : RecyclerView.Adapter<NoteApdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent?.context).inflate(R.layout.item_note, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = values.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.textView?.text = values[position]
    }


    class ViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView!!) {
        var textView: TextView? = null
        init{
            textView = itemView?.findViewById(R.id.textItemNote)
        }
    }
}