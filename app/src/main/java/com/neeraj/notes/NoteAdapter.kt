package com.neeraj.notes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(private val context : Context, private val listener : INoteListener) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    private val mNoteList = ArrayList<NoteEntity>()

    fun getNotes(notesList : List<NoteEntity>) {
        mNoteList.clear()
        mNoteList.addAll(notesList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.note_list_item, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.textView.text = mNoteList.get(position).noteMessage
        holder.imgView.setOnClickListener {
            listener.onDeleteNote(mNoteList.get(position))
        }
    }

    override fun getItemCount(): Int {
        return mNoteList.size
    }

    inner class NoteViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.txv_note_list_item)
        val imgView = itemView.findViewById<ImageView>(R.id.img_note_list_item_delete)

    }

    interface INoteListener {
        fun onDeleteNote(note : NoteEntity)
    }

}


