package com.example.pokeapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.pokeapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lateinit var binding: ActivityMainBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.navView.setItemIconTintList(null)
        val navController = findNavController(R.id.nav_host_fragment)
        binding.navView.setupWithNavController(navController)
    }
}