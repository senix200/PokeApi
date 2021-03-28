package com.example.pokeapi.ui.pokedex


import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokeapi.model.PokeApiResponse
import com.example.pokeapi.model.PokeResult
import com.example.pokeapi.model.Pokemon
import com.example.pokeapi.repository.PokeApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class PokeListViewModel() : ViewModel() {

    private val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private val service: PokeApiService = retrofit.create(PokeApiService::class.java)

    val pokemonList = MutableLiveData<List<PokeResult>>()
    fun getPokemonList(limit: Int){

        val call = service.getPokemonList(limit, 0)

        call.enqueue(object : Callback<PokeApiResponse> {
            override fun onResponse(
                call: Call<PokeApiResponse>,
                response: Response<PokeApiResponse>
            ) {

                response.body()?.results?.let { ArrayList ->
                    pokemonList.postValue(ArrayList)

                }

            }

            override fun onFailure(call: Call<PokeApiResponse>, t: Throwable) {
                call.cancel()
            }

        })
    }
}