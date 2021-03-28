package com.example.pokeapi.ui.pokeinfo

import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.pokeapi.R
import com.example.pokeapi.databinding.ActivityPokeinfoBinding
import com.example.pokeapi.model.Pokemon
import com.example.pokeapi.utils.PokemonColorType
import kotlinx.android.synthetic.main.activity_pokeinfo.*

class PokeInfoActivity : AppCompatActivity() {

    lateinit var viewModel: PokeInfoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lateinit var binding: ActivityPokeinfoBinding
        binding = ActivityPokeinfoBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(PokeInfoViewModel::class.java)
        val view = binding.root
        initUI(binding)
        setContentView(view)
    }

    private fun initUI(binding: ActivityPokeinfoBinding){
        val id = intent.extras?.get("id") as Int

        viewModel.getPokemonInfo(id)

        var l1 : LinearLayout = binding.LLF1
        var l2 : LinearLayout = binding.LLF2
        var l3 : LinearLayout = binding.LLF3
        var l4 : LinearLayout = binding.LLF4

        // En el observe bindeamos todos los ID a mostrar en los detalles de nuestro pokemon.
        viewModel.pokemonInfo.observe(this, Observer { pokemon ->
            var link1 = pokemon!!.sprites.frontDefault
            var link2 = pokemon!!.sprites.frontFemale
            var link3 = pokemon!!.sprites.frontShiny
            var link4 = pokemon!!.sprites.frontShinyFemale


            binding.labelNum.text = "#${pokemon.id}"
            binding.labelName.text = pokemon.name.capitalize()
            Glide.with(this).load(link1).into(binding.imgFront)
            binding.speed.text = pokemon.stats[0].baseStat.toString()
            binding.defenseSpecial.text = pokemon.stats[1].baseStat.toString()
            binding.attackSpecial.text = pokemon.stats[2].baseStat.toString()
            binding.defenseNormal.text = pokemon.stats[3].baseStat.toString()
            binding.attack.text = pokemon.stats[4].baseStat.toString()
            binding.hp.text = pokemon.stats[5].baseStat.toString()
            binding.heightText.text = "${pokemon.height/10.0}m"
            binding.weightText.text = "${pokemon.weight/10.0}"
            pokemon.type?.getOrNull(0).let { firstType ->
                PokemonColorType(this).getPokemonColor(pokemon!!.type[0].types?.names, binding.pokemonType1)
                binding.pokemonType1.text = "${firstType?.types?.names?.capitalize()}"
                binding.pokemonType1.isVisible = firstType != null
            }

            pokemon.type?.getOrNull(1).let { secondType ->
                for (cont in 1..pokemon!!.type.size){
                    if (cont==2){
                        PokemonColorType(this).getPokemonColor(pokemon!!.type[1].types?.names, binding.pokemonType2)
                        binding.pokemonType2.text = "${secondType?.types?.names?.capitalize()}"
                        binding.pokemonType2.isVisible = secondType != null
                    }else{
                        binding.pokemonType2.visibility = View.GONE
                    }
                }
            }

            pokemon.abilities?.getOrNull(0).let { firstAbility ->
                binding.pokemonAbility1.text = "${firstAbility?.ability?.names?.capitalize()}"
                binding.pokemonAbility1.isVisible = firstAbility != null
            }

            pokemon.abilities?.getOrNull(1).let { secondAbility ->
                binding.pokemonAbility2.text = "${secondAbility?.ability?.names?.capitalize()}"
                binding.pokemonAbility2.isVisible = secondAbility != null
            }


            if (link1.equals(null)){
                l1.visibility = View.GONE
            }else{
                Glide.with(this).load(link1).into(binding.imgMale)
                PokemonColorType(this).backgroundLine(l1,R.color.water)
            }
            if (link2.equals(null)){
                l2.visibility = View.GONE
            }else{
                Glide.with(this).load(link2).into(binding.imgFemale)
                PokemonColorType(this).backgroundLine(l2,R.color.fairy)
            }
            if (link3.equals(null)){
                l3.visibility = View.GONE
            }else{
                Glide.with(this).load(link3).into(binding.imgShiny)
                PokemonColorType(this).backgroundLine(l3,R.color.electric)
            }
            if (link4.equals(null)){
                l4.visibility = View.GONE
            }else{
                Glide.with(this).load(link4).into(binding.imgShinyFemale)
                PokemonColorType(this).backgroundLine(l4,R.color.psychic)
            }
        })
    }
}