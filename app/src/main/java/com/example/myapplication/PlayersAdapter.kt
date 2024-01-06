package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.squareup.picasso.Picasso


class PlayersAdapter(var players :ArrayList<Players>,var listenner:playerItemitection):RecyclerView.Adapter<PlayersAdapter.PlayerViewHolder> (){

        interface playerItemitection{
            fun onPlayerclicked(players: Players)
        }
        class PlayerViewHolder(itemView: View,listenner: playerItemitection):ViewHolder(itemView){
            lateinit var player: Players
            var nampo :TextView
            var club : TextView
            var imgbig : ImageView
            var imgsmall : ImageView

            init {
                nampo=itemView.findViewById(R.id.name_post)
                club=itemView.findViewById(R.id.tv_club)
                imgbig=itemView.findViewById(R.id.big_img)
                imgsmall=itemView.findViewById(R.id.freee)

                itemView.setOnLongClickListener(object :View.OnLongClickListener{
                    override fun onLongClick(v: View?): Boolean {
                        listenner.onPlayerclicked(player)

                        return true
                    }

                })

            }

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.players_item,parent,false)
        return PlayerViewHolder(v,listenner)
    }

    override fun getItemCount(): Int {
        return players.size



    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val player = players.get(position)

        holder.player=player
        Picasso.get().load(player.image).resize(200,200).into(holder.imgbig)

        holder.nampo.text="${player.name} ${player.post}"
        holder.club.text="${player.club}"
        if (player.isFree){
            holder.imgsmall.setImageResource(R.drawable.baseline_done_24)
        }else{
            holder.imgsmall.setImageResource(R.drawable.baseline_do_disturb_on_24)
        }
    }


}