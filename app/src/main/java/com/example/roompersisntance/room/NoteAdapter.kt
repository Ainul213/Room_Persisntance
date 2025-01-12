package com.example.roompersisntance.room

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roompersisntance.R

class NoteAdapter(private var notes: List<Note>) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_itm, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.bind(note)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    // ViewHolder class to bind data to views
    class NoteViewHolder(private val view: android.view.View) : RecyclerView.ViewHolder(view) {
        fun bind(note: Note) {
            // Find views by their IDs and set the text accordingly
            val titleTextView = view.findViewById<TextView>(R.id.textViewTitle)
            val contentTextView = view.findViewById<TextView>(R.id.textViewContent)
            val timestampTextView = view.findViewById<TextView>(R.id.textViewTimestamp)

            titleTextView.text = note.title
            contentTextView.text = note.content
            timestampTextView.text = note.timestamp
        }
    }
}
