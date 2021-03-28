package com.example.pokeapi.utils

import android.content.Context
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat
import com.example.pokeapi.R

class PokemonColorType (var context: Context){

    // Funcion para colorear el fondo del tipo de pokemon
    fun getPokemonColor(n: String?, texto : TextView){
        when(n){
            "normal" -> backgroundColor(texto, R.color.normal)
            "fighting" -> backgroundColor(texto, R.color.fighting)
            "flying" -> backgroundColor(texto, R.color.flying)
            "poison" -> backgroundColor(texto, R.color.posion)
            "ground" -> backgroundColor(texto, R.color.ground)
            "rock" -> backgroundColor(texto, R.color.rock)
            "bug" ->  backgroundColor(texto, R.color.bug)
            "ghost" -> backgroundColor(texto, R.color.ghost)
            "steel" -> backgroundColor(texto, R.color.steel)
            "fire" ->  backgroundColor(texto, R.color.fire)
            "water" ->  backgroundColor(texto, R.color.water)
            "grass" ->  backgroundColor(texto, R.color.grass)
            "electric" ->  backgroundColor(texto, R.color.electric)
            "psychic" ->  backgroundColor(texto, R.color.psychic)
            "ice" ->  backgroundColor(texto, R.color.ice)
            "fairy" ->  backgroundColor(texto, R.color.fairy)
            "dark" ->  backgroundColor(texto, R.color.dark)
            "shadow" ->  backgroundColor(texto, R.color.dark)
            "unknown" ->  backgroundColor(texto, R.color.normal)
            else -> backgroundColor(texto, R.color.normal)
        }
    }

    fun backgroundColor(texto : TextView, id: Int){
        texto.setBackgroundColor(ContextCompat.getColor(context,id))
    }

    // Esta funcion la uso para colorear Macho, Hembra, Shiny y ShinyFemale
    fun backgroundLine(li : LinearLayout, id: Int){
        li.setBackgroundColor(ContextCompat.getColor(context,id))
    }
}