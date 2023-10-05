package com.example.sesshokuapplication.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.sesshokuapplication.R
import androidx.activity.viewModels

class RoomActivity : AppCompatActivity() {

    private val contactViewModel: ContactViewModel by viewModels {
        ContactViewModelFactory((application as ContactApplication).repository)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        val editdate=findViewById<EditText>(R.id.edit_date)
        val edittime=findViewById<EditText>(R.id.edit_time)
        val editname=findViewById<EditText>(R.id.edit_name)

        val adddata=findViewById<Button>(R.id.add_database)
        adddata.setOnClickListener {
            val contact = Contact(editdate.text.toString(),edittime.text.toString(),editname.text.toString())
            contactViewModel.insert(contact)
        }
    }
}