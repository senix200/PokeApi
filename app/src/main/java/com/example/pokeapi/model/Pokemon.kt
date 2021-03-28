package com.example.pokeapi.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.pokeapi.utils.ListStringConverter
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Pokedex")
@TypeConverters(ListStringConverter::class)
data class Pokemon (
    @PrimaryKey
    @NonNull
    @Expose @SerializedName("id") val id: Int?,
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("weight") val weight: Int,
    @Expose @SerializedName("height") val height: Int,
    @Expose @SerializedName("sprites") val sprites: Sprites,
    @Expose @SerializedName("types") val type: List<PokemonType>,
    @Expose @SerializedName("abilities") val abilities: List<Abilities>,
    @Expose @SerializedName("stats") val stats: List<Stats>
)

data class Sprites (
    @Expose @SerializedName("front_default") val frontDefault: String?,
    @Expose @SerializedName("front_female") val frontFemale: String?,
    @Expose @SerializedName("front_shiny") val frontShiny: String?,
    @Expose @SerializedName("front_shiny_female") val frontShinyFemale: String?
)

data class PokemonType (
    @Expose @SerializedName("slot") val slot: Int,
    @Expose @SerializedName("type") val types: NameType?
)

data class NameType (
    @Expose @SerializedName("name") val names: String?,
    @Expose @SerializedName("url") val urls: String
)


data class Abilities (
    @Expose @SerializedName("ability") val ability: Ability?
)

data class Ability (
    @Expose @SerializedName("name") val names: String?,
    @Expose @SerializedName("url") val urls: String
)


data class Stats (
    @Expose @SerializedName("base_stat") val baseStat: Int?
)