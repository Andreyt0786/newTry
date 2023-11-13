package ru.aston.recycleview.dto

import java.io.Serializable

data class TelePhoneBook(
    val id:Int,
    val name:String,
    val surName:String,
    val number:String,
    val isChecked:Boolean = false,
):Serializable
