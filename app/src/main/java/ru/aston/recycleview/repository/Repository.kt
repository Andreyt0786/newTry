package ru.aston.recycleview.repository

import androidx.lifecycle.LiveData
import ru.aston.recycleview.dto.Country

interface Repository {
    fun getAll(): LiveData<List<Country>>
}