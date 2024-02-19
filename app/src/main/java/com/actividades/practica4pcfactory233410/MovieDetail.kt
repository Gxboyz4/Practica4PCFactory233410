package com.actividades.practica4pcfactory233410

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.actividades.practica4pcfactory233410.databinding.ActivityMovieDetailBinding


class MovieDetail : AppCompatActivity() {
    private lateinit var binding: ActivityMovieDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle=intent.extras
        if(bundle!=null){
        binding.ivPeliculaImagen.setImageResource(bundle.getInt("header"))
        binding.tvNombrePelicula.setText(bundle.getString("nombre"))
        binding.tvPeliculaDesc.setText(bundle.getString("sinopsis"))
        }
    }
}