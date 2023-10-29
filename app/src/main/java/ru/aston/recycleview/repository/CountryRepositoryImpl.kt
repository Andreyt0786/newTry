package ru.aston.recycleview.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.aston.recycleview.dto.Country

class CountryRepositoryImpl : Repository {
    private var nextId = 1
    private var countries = listOf(
        Country(
            id = nextId++,
            name = "Российская Федерация",
            url = "https://cdn1.ozone.ru/s3/multimedia-g/6371416336.jpg"

        ),
        Country(
            id = nextId++,
            name = "Республика Казахстан",
            url = "https://avatars.mds.yandex.net/get-mpic/4577446/img_id2250029061686435501.png/orig"
        ),
        Country(
            id = nextId++,
            name = "Китайская Народная Республика",
            url = "https://pixy.org/src/38/thumbs350/380343.jpg"
        ),
        Country(
            id = nextId++,
            name = "Египет",
            url = "https://wiki-cdn.lesta.ru/images/1/12/Флаг_египта.png"
        ),
        Country(
            id = nextId++,
            name = "Турецкая Республика",
            url = "https://www.digiseller.ru/preview/994291/p1_3536877_c70ab707.jpg"
        ),
        Country(
            id = nextId++,
            name = "Вьетнам",
            url = "https://i.ytimg.com/vi/Jxlq4NPYJWc/maxresdefault.jpg"
        ),
        Country(
            id = nextId++,
            name = "Тайланд",
            url = "https://i.artfile.ru/1920x1080_718164_[www.ArtFile.ru].jpg"
        ),
        Country(
            id = nextId++,
            name = "Германия",
            url = "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7e/Flag_of_Germany_%28unoff%29.svg/1600px-Flag_of_Germany_%28unoff%29.svg.png"
        ),
        Country(
            id = nextId++,
            name = "Киргизия",
            url = "https://kuhchici.kletsk-asveta.gov.by/files/00899/obj/110/39313/img/2.jpg"
        ),
        Country(
            id = nextId++,
            name = "Куба",
            url = "https://w7.pngwing.com/pngs/678/925/png-transparent-white-red-and-blue-striped-and-one-star-flag-flag-of-cuba-united-states-flag-of-puerto-rico-cuba-blue-flag-united-states.png"
        ),
        Country(
            id = nextId++,
            name = "Мексика",
            url = "https://cdn1.ozone.ru/s3/multimedia-u/6066568638.jpg"
        ),
        Country(
            id = nextId++,
            name = "Испания",
            url = "https://flagof.ru/wp-content/uploads/2018/10/Spain-Flag.png"
        ),
        Country(
            id = nextId++,
            name = "Нидерланды",
            url = "https://regnum.ru/uploads/pictures/news/2017/03/12/regnum_picture_1489319637393560_normal.jpg"
        ),
        Country(
            id = nextId++,
            name = "Гондурас",
            url = "https://i3.guns.ru/forums/icons/forum_pictures/030306/30306421_12000.jpg"
        ),
        Country(
            id = nextId++,
            name = "Колумбия",
            url = "https://www.pngjoy.com/pngm/214/4183028_colombia-flag-flag-transparent-png.png"
        ),
        Country(
            id = nextId++,
            name = "Чили",
            url = "https://i.ytimg.com/vi/7D1vZAXk1xI/maxresdefault.jpg"
        ),
        Country(
            id = nextId++,
            name = "Австралия",
            url = "https://cryptomic.ru/wp-content/uploads/2018/01/Australia-Flag-5.jpg"
        ),
        Country(
            id = nextId++,
            name = "Канада",
            url = "https://w.forfun.com/fetch/ec/ecd4712216ae489a6ef21eff199d246b.jpeg?w=1470&r=0.5625"
        ),
    )

    private val data = MutableLiveData(countries)

    override fun getAll(): LiveData<List<Country>> = data
}