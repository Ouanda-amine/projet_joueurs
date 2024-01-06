package com.example.myapplication

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Parcel
import android.os.Parcelable
import java.util.jar.Attributes.Name


class DBplayers (val ctx:Context):SQLiteOpenHelper(ctx,DBplayers.DB_Name,null,1) {



    companion object{
        const val DB_Name ="players_db"
        const val Table_NAME="players_table"
        const val Name="name"
        const val POST="post"
        const val CLUB="club"
        const val ISFREE="isfree"
        const val IMAGE="image"
    }


    override fun onCreate(p0: SQLiteDatabase?) {
        val sqlQuery = "CREATE TABLE $Table_NAME (" +
                "$Name TEXT," +
                "$POST TEXT," +
                "$CLUB INTEGER," +
                "$ISFREE INTEGER," +
                "$IMAGE TEXT" +
                ") "

        p0?.execSQL(sqlQuery)
    }





    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }


    fun ajouterplayer(players: Players):Int{
        val isfree =if (players.isFree)1 else 0
        val db= writableDatabase


        val values = ContentValues()

        values.put(Name,players.name)
        values.put(POST,players.post)
        values.put(CLUB,players.club)
        values.put(ISFREE,isfree)
        values.put(IMAGE,players.image)

         val res= db.insert(Table_NAME,null,values)

        return res.toInt()
    }
    fun getAllPlayers() :ArrayList<Players>{

        val AllPlaters=ArrayList<Players>()

        val db = writableDatabase
        val sqlQuery = "SELECT * FROM $Table_NAME"
        val cursor = db.rawQuery(sqlQuery,null)

        if (cursor.moveToFirst()) {
            do {
                var isfree =false
                val name=cursor.getString(0)
                val post=cursor.getString(1)
                val club=cursor.getString(2)
                val isfreeCursor=cursor.getInt(3)
                val image=cursor.getString(4)

                if (isfreeCursor==1){
                    isfree=true
                }
                val play=Players(name,post,club,isfree,image)

                AllPlaters.add(play)


            }while (cursor.moveToNext())
        }


        return AllPlaters
    }





}