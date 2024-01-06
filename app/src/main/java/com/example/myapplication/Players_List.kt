package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityPlayersListBinding

class Players_List : AppCompatActivity() {

    lateinit var binding: ActivityPlayersListBinding

    lateinit var dBplayers: DBplayers

    lateinit var playersList: ArrayList<Players>


    lateinit var playersAdapter: PlayersAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_players_list)


        binding=ActivityPlayersListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dBplayers = DBplayers(this)
        playersList=dBplayers.getAllPlayers()
        playersAdapter= PlayersAdapter(playersList,object :PlayersAdapter.playerItemitection{
            override fun onPlayerclicked(players: Players) {

            }
        })
        for (i in playersList){
            Log.d("ouanda", i.toString())
        }

        binding.playersLiist.adapter=playersAdapter
        binding.playersLiist.layoutManager=LinearLayoutManager(this)
        binding.playersLiist.hasFixedSize()



    }

}