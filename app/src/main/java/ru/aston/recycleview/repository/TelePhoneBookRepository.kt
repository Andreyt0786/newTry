package ru.aston.recycleview.repository

import androidx.lifecycle.LiveData
import ru.aston.recycleview.dto.Country
import ru.aston.recycleview.dto.TelePhoneBook

interface TelePhoneBookRepository {
    fun getAll(): LiveData<List<TelePhoneBook>>
    fun save(telePhoneBook: TelePhoneBook)
    fun removeById(id: Int)

    fun check(id:Int)
}