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
data class PokeApiResponse(
    @Expose @SerializedName("count") val count: Int,
    @Expose @SerializedName("next") val next: String,
    @Expose @SerializedName("previous") val previous: String,
    @Expose @SerializedName("results") val results: List<PokeResult>
)

data class PokeResult(
    @PrimaryKey
    @NonNull
    @Expose @SerializedName("id") var id: Int,
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("url") val url: String
)
