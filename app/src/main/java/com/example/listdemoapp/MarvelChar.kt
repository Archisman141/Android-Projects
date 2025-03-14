package com.example.listdemoapp

data class MarvelChar(
    var charName:String,
    var name:String,
    var imageRes:Int
)


fun getAllMarvelChar():List<MarvelChar>{
    return listOf<MarvelChar>(
        MarvelChar("Spiderman","Peter Parker",R.drawable.spidy),
        MarvelChar("Captain America","Steve Rogers",R.drawable.captain),
        MarvelChar("Iron Man","Tony Stark", R.drawable.iron_man),
        MarvelChar("Thor","Thor Odinson",R.drawable.thor),
        MarvelChar("Black Panther","T'Challa",R.drawable.black_panther),
        MarvelChar("Hulk","Bruce Banner", R.drawable.hulk),
        MarvelChar("Doctor Strange","Stephen Strange",R.drawable.doctor_strange),
    )
}
