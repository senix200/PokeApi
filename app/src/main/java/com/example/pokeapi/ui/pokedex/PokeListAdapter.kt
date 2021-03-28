package com.example.pokeapi.ui.pokedex

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokeapi.R
import com.example.pokeapi.databinding.CardPokemonSearchBinding
import com.example.pokeapi.model.PokeResult
import com.example.pokeapi.model.Pokemon
import com.example.pokeapi.ui.pokeinfo.PokeInfoActivity


class PokeListAdapter(val context: Context, var pokemonList: List<PokeResult>?): RecyclerView.Adapter<PokeListAdapter.ViewHolder>(), View.OnClickListener {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeListAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.card_pokemon_search,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return pokemonList!!.size
    }

    override fun onBindViewHolder(holder: PokeListAdapter.ViewHolder, position: Int) {
        holder.bindItems(pokemonList!![position])

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = CardPokemonSearchBinding.bind(itemView)
        var view = binding.root

        fun bindItems(pokemon: PokeResult) {
            binding.pokemonText.text = pokemon.name.capitalize()
            binding.pokemonNum.text = "#${position+1}"
            var link = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${position+1}.png"

            Glide.with(view.context).load(link).into(binding.imageView2)
            binding.consPoke.setOnClickListener {
                val intent: Intent = Intent(view.context, PokeInfoActivity::class.java)
                intent.putExtra("id", position + 1)
                ContextCompat.startActivity(view.context, intent, null)
            }
        }
    }

    override fun onClick(p0: View?) {
        Toast.makeText(p0!!.context, "", Toast.LENGTH_LONG).show()
    }





}