package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    val dBplayers = DBplayers(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnnego.setOnClickListener({

            val isfree=binding.swi.isChecked
            val name=binding.name.text.toString()
            val post =binding.post.text.toString()
            val club=binding.club.text.toString()
            val image=binding.image.text.toString()

            val players =Players(name,post,club,isfree,image)
            val res=dBplayers.ajouterplayer(players).toInt()
            
            if (res != -1){
                Toast.makeText(baseContext, "we will start conversation with this player", Toast.LENGTH_SHORT).show()
                startActivity(Intent(MainActivity@this ,Players_List::class.java) )
            } else{
                Toast.makeText(baseContext, "player not availble", Toast.LENGTH_SHORT).show()
            }

        })
    }
}