package com.neeraj.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.neeraj.notes.NoteAdapter.INoteListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), INoteListener, OnClickListener {

    private lateinit var mViewModel: NoteViewModel
    private lateinit var mAdapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recycler_act_main.layoutManager = layoutManager
        mAdapter = NoteAdapter(this, this)
        recycler_act_main.adapter = mAdapter

        mViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        mViewModel.allNotes.observe(this, Observer {

            mAdapter.getNotes(it)

        })

        btn_act_main.setOnClickListener(this)

    }

    override fun onDeleteNote(note: NoteEntity) {
        mViewModel.deleteNote(note)
        Toast.makeText(this@MainActivity, "${note.noteMessage} deleted", Toast.LENGTH_LONG).show()
    }

    override fun onClick(view: View?) {
        val id = view?.id
        if (id == R.id.btn_act_main) {
            if (edt_act_main.editableText.toString().isNotEmpty()) {
                mViewModel.insertNote(NoteEntity(edt_act_main.editableText.toString()))
                Toast.makeText(this@MainActivity, "${edt_act_main.editableText.toString()} inserted", Toast.LENGTH_LONG).show()
                edt_act_main.text.clear()
            }
        }
    }
}