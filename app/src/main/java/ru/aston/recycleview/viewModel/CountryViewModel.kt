package ru.aston.recycleview.viewModel

import androidx.lifecycle.ViewModel
import ru.aston.recycleview.repository.CountryRepositoryImpl
import ru.aston.recycleview.repository.Repository

class CountryViewModel:ViewModel (){
    private val repository: Repository = CountryRepositoryImpl()
    val data = repository.getAll()
}