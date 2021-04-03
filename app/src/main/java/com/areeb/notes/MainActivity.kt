package com.areeb.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.itemview.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)







        recyler_notes.layoutManager = LinearLayoutManager(this)
        val adapter = RecyclerAdapter(this, this)
        recyler_notes.adapter = adapter

        viewModel = ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(ViewModel::class.java)
        viewModel.allNotes.observe(this, Observer { list ->
            list?.let {
                adapter.updateList(it)


            }


        })

    }

    private fun submitData(view: View) {
        val add_text = input.text.toString()
        if (add_text.isNotEmpty()) {

            viewModel.insertNote(Notes(add_text))

        }

    }

    fun onItemClicked(note: Notes) {
        viewModel.deleteNote(note)

    }


}
