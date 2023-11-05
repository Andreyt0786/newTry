package ru.aston.recycleview.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import ru.aston.recycleview.dto.TelePhoneBook
import ru.aston.recycleview.repository.TelePhoneBookRepository
import ru.aston.recycleview.repository.TelePhoneRepositoryImpl

private val empty = TelePhoneBook(
    id=0,
    name = "",
    surName = "",
    number = ""
)
class TelePhoneBookViewModel(application: Application):AndroidViewModel(application) {
    private val repository: TelePhoneBookRepository = TelePhoneRepositoryImpl()
    val data = repository.getAll()
    val edited = MutableLiveData(empty)


    fun check(id:Int){
        repository.check(id)
    }
    fun save() {
        edited.value?.let {
            repository.save(it)
        }
        edited.value = empty
    }

    fun edit(telePhoneBook: TelePhoneBook) {
        edited.value = telePhoneBook
    }

    fun change(name: String, surname:String, number:String) {
        val textName = name.trim()
        val textSurName = surname.trim()
        if (edited.value?.name == textName && edited.value?.name == textSurName) {
            return
        }
        edited.value = edited.value?.copy(name = textName, surName = textSurName, number = number)
    }


    fun removeById(id: Int) = repository.removeById(id)
}