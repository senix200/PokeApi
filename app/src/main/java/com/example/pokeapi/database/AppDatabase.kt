package com.example.pokeapi.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pokeapi.database.dao.PokemonDAO
import com.example.pokeapi.model.Pokemon

@Database(entities = [Pokemon::class], version = 5, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun pokemonDAO(): PokemonDAO
}