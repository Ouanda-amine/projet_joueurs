package com.example.myapplication

class Players(var name:String,var post:String,var club:String,var isFree :Boolean,var image:String) {
    override fun toString(): String {
        return "Players(name='$name', post='$post', club='$club', isFree=$isFree, image='$image')"
    }
}