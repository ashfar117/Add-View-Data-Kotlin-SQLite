package com.example.ashfa.studentdbmcassign

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonAdd.setOnClickListener{

if(studentId.text.isNotEmpty() && studentName.text.isNotEmpty() && studentActivity.text.isNotEmpty() && studentCost.text.isNotEmpty()){
    var insert_db = UserModel(studentId.text.toString(), studentName.text.toString(), studentActivity.text.toString(), studentCost.text.toString())
    var db = DatabaseHandler(this)
    db.insertData(insert_db)
    Toast.makeText(this, "Data successfully entered", Toast.LENGTH_LONG).show()

}

        }

        buttonShow.setOnClickListener{
        startActivity(Intent(this, com.example.ashfa.studentdbmcassign.View::class.java ))

        }


    }

}

