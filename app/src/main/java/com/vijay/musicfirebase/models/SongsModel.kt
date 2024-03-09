package com.vijay.musicfirebase.models

data class SongsModel(
    val id:String,
    val title:String,
    val subTitle:String,
    val url:String,
    val coverUrl :String
){
    constructor() : this("","","","","")
}
