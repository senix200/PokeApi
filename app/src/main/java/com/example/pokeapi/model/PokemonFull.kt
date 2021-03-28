package com.example.pokeapi.model

class PokemonFull(var id: Int, var order:Int, var name: String,var abilities : ArrayList<Abilities>, var sprites:Sprites, var types: ArrayList<PokemonType>, var stats: ArrayList<Stats>)