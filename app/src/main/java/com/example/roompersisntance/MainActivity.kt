package com.example.roompersisntance

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.roompersisntance.R.id.buttonAddNote
import com.example.roompersisntance.room.MainViewModel
import com.example.roompersisntance.room.NoteAdapter
import com.example.roompersisntance.ui.AddNoteActivity

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var noteAdapter: NoteAdapter
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        recyclerView = findViewById(R.id.recyclerViewNotes)
        recyclerView.layoutManager = LinearLayoutManager(this)

        mainViewModel = ViewModelProvider(this).get(mainViewModel::class.java)

        mainViewModel.allNotes.observe(this, Observer { notes ->
            noteAdapter = NoteAdapter(notes)
            recyclerView.adapter = noteAdapter
        })

        val buttonAddNote: Button = findViewById(buttonAddNote)
        buttonAddNote.setOnClickListener {
            val intent = Intent(this, AddNoteActivity::class.java)
            startActivity(intent)
        }
    }
}