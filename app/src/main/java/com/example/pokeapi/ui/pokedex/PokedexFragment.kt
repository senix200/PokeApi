package com.example.pokeapi.ui.pokedex

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapi.R
import com.example.pokeapi.model.PokeResult
import kotlinx.android.synthetic.main.activity_pokelist.*

class PokedexFragment : Fragment() {

    private lateinit var viewModel: PokeListViewModel
    private var aptoParaCargar = false
    private var limit = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {return inflater.inflate(R.layout.activity_pokelist, container, false)}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(PokeListViewModel::class.java)

        val pokelistRecyclerView = pokelistRecyclerView
        val layoutManager = GridLayoutManager(context, 3)
        pokelistRecyclerView.layoutManager = layoutManager

        // Añadimos al list los siguientes 40 pokemones
        pokelistRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0) {
                    val visibleItemCount = layoutManager.childCount
                    val totalItemCount = layoutManager.itemCount
                    val pastVisibleItems = layoutManager.findFirstVisibleItemPosition()
                    if (aptoParaCargar) {
                        if (visibleItemCount + pastVisibleItems >= totalItemCount) {
                            limit += 100
                            viewModel.getPokemonList(limit)
                        }
                    }
                }
            }
        })
        aptoParaCargar = true;
        limit = 40;
        viewModel.getPokemonList(limit)

        // Observamos mandandole una lista de pokeresult al adapter
        viewModel.pokemonList.observe(viewLifecycleOwner, Observer {
            val pokemons: List<PokeResult> = it
            pokelistRecyclerView.adapter = PokeListAdapter(view.context, pokemons)
        })

    }


}