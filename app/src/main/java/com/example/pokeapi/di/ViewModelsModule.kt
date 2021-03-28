package com.example.pokeapi.di

import com.example.pokeapi.ui.pokedex.PokeListViewModel
import com.example.pokeapi.ui.pokeinfo.PokeInfoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { PokeListViewModel() }
    viewModel { PokeInfoViewModel() }

}