package com.example.ashfa.studentdbmcassign

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_view.*

class View : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)


        var db = DatabaseHandler(this)
        var data = db.readData()
        val studid: ArrayList<String> = ArrayList()
        val studname: ArrayList<String> = ArrayList()
        val studactivity: ArrayList<String> = ArrayList()
        val studcost: ArrayList<String> = ArrayList()
        var size = data.size
        for(i in 0..(size-1)){
            studid.add(data.get(i).studentId)
            studname.add(data.get(i).studentName)
            studactivity.add(data.get(i).studentActivity)
            studcost.add(data.get(i).studentCost)

            val data: String
            data = "Student ID : S"+studid[i]+"\n"+"Student Name : "+studname[i]+"\n"+"Student Activity : "+studactivity[i]+"\n"+"Student Cost : $"+studcost[i]


            viewdata.text=viewdata.text.toString()+"\n"+data+"\n"





        }

    }
}


