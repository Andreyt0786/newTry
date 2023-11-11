package ru.aston.recycleview.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.aston.recycleview.dto.TelePhoneBook

@Suppress("UNUSED_CHANGED_VALUE")
class TelePhoneRepositoryImpl() : TelePhoneBookRepository {


    private var telePhoneBooks = listOf(
        TelePhoneBook(
            id = 1,
            name = "Катя",
            surName = "Иванова",
            number = "78889992255"

        ),
        TelePhoneBook(
            id = 2,
            name = "Петя",
            surName = "Швецов",
            number = "78889992233"

        ),
        TelePhoneBook(
            id = 3,
            name = "Оля",
            surName = "Петрова",
            number = "78889997799"
        ),
        TelePhoneBook(
            id = 4,
            name = "Сергей",
            surName = "Полунин",
            number = "78889997766"
        ),
        TelePhoneBook(
            id = 5,
            name = "Маша",
            surName = "Ким",
            number = "78889997711"
        ),

        )

    var nextId = telePhoneBooks.size + 1
    private val data = MutableLiveData(telePhoneBooks)
    override fun getAll(): LiveData<List<TelePhoneBook>> = data

    override fun save(telePhoneBook: TelePhoneBook) {

        if (telePhoneBook.id == 0) {

            telePhoneBooks = listOf(
                telePhoneBook.copy(
                    id = nextId++,
                    name = telePhoneBook.name,
                    surName = telePhoneBook.surName,
                    number = telePhoneBook.number,
                )
            ) + telePhoneBooks
            data.value = telePhoneBooks
            return
        }
        telePhoneBooks = telePhoneBooks.map {
            if (it.id != telePhoneBook.id) it else it.copy(
                name = telePhoneBook.name,
                surName = telePhoneBook.surName,
                number = telePhoneBook.number,
            )
        }
        data.value = telePhoneBooks

    }

    override fun removeById(id: Int) {
        telePhoneBooks = telePhoneBooks.filter { it.id != id }
        data.value = telePhoneBooks
    }

    override fun check(id: Int) {
        telePhoneBooks = telePhoneBooks.map {
            if (it.id != id) it else it.copy(
                isChecked = !it.isChecked
            )
        }
        data.value = telePhoneBooks
    }
}