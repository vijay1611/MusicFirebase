package com.vijay.musicfirebase.models

data class CategoryModel(
    val name:String,
    val CoverUrl:String,
    val Songs : List<String>
){
    constructor(): this("","", listOf())
}
