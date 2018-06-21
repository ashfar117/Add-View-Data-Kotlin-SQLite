package com.example.ashfa.studentdbmcassign

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteConstraintException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

import java.util.ArrayList

val DATABASE_NAME = "studentdb"
val TABLE_NAME = "student"
val COL_ID="studentId"
val COL_NAME = "studentName"
val COL_ACTIVITY = "studentActivity"
val COL_COST = "studentCost"


class DatabaseHandler(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME,null,1){
    override fun onCreate(db: SQLiteDatabase?) {

        val createTable = "CREATE TABLE "+ TABLE_NAME +"("+ COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                COL_NAME+" VARCHAR(256),"+
                COL_ACTIVITY +" VARCHAR(256), "+
                COL_COST +" VARCHAR(256))"
        db?.execSQL(createTable)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val createTable = "CREATE TABLE "+ TABLE_NAME +"("+ COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                COL_NAME+" VARCHAR(256),"+
                COL_ACTIVITY +" VARCHAR(256), "+
                COL_COST +" VARCHAR(256))"
        db?.execSQL(createTable)
    }

    fun insertData(insert_db: UserModel){
        val db = this.writableDatabase
        var cv = ContentValues()//need contentValues to insert data
        cv.put(COL_ID,insert_db.studentId)
        cv.put(COL_NAME,insert_db.studentName)
        cv.put(COL_ACTIVITY,insert_db.studentActivity)
        cv.put(COL_COST,insert_db.studentCost)

        var result = db.insert(TABLE_NAME,null,cv)

        if(result == (-1).toLong()){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
        }

    }

    fun readData() : MutableList<UserModel>{
        var list : MutableList<UserModel> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from " + TABLE_NAME
        val result = db.rawQuery(query,null)
        if (result.moveToFirst()){
            do{
                var data = UserModel()

                data.studentId = result.getString(result.getColumnIndex(COL_ID))
                data.studentName = result.getString(result.getColumnIndex(COL_NAME))
                data.studentActivity = result.getString(result.getColumnIndex(COL_ACTIVITY))
                data.studentCost = result.getString(result.getColumnIndex(COL_COST))

                list.add(data)

            }while(result.moveToNext())
        }
        result.close()
        db.close()
        return list
    }

}
