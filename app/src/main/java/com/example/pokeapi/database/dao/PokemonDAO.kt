package com.example.pokeapi.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pokeapi.model.PokeResult
import com.example.pokeapi.model.Pokemon

@Dao
interface PokemonDAO {

    @Query("SELECT * FROM pokemon.Pokedex WHERE id = :id")
    fun getById(id: Int?): LiveData<PokeResult>

    @Query("SELECT * FROM pokemon.pokedex")
    fun all(): LiveData<List<PokeResult>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(pokemon: List<PokeResult>)

    @Query("DELETE FROM pokemon.pokedex")
    fun deleteAll()

    @Delete
    fun delete(model: Pokemon)
}