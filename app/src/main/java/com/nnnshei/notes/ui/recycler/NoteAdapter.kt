package com.nnnshei.notes.ui.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nnnshei.notes.R
import com.nnnshei.notes.model.Note
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_note.view.*

class NoteAdapter(
    private val clickListener: (Note) -> Unit
) : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    private val values = mutableListOf<Note>()

    fun bindData(note: List<Note>) {
        values.clear()
        values.addAll(note)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return ViewHolder(itemView, clickListener)
    }

    override fun getItemCount() = values.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = values[position]
        holder.bind(data)
    }

    class ViewHolder(
        override val containerView: View,
        private val clickListener: (Note) -> Unit
    ) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bind(note: Note) {
            containerView.setOnClickListener {
                clickListener(note)
            }
            containerView.textItemNote.text = note.text
        }
    }
}