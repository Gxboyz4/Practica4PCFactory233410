package com.actividades.practica4pcfactory233410

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

import com.actividades.practica4pcfactory233410.databinding.ActivityMainBinding
import com.actividades.practica4pcfactory233410.databinding.ActivityMovieDetailBinding
import com.actividades.practica4pcfactory233410.databinding.PeliculaBinding


class MainActivity : AppCompatActivity() {
    var adapter: PeliculaAdapter?=null
    var peliculas = ArrayList<Pelicula>()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        cargarPeliculas()
        adapter = PeliculaAdapter(this,peliculas)
        binding.gridview.adapter=adapter
    }
    fun cargarPeliculas(){
    peliculas.add(Pelicula("ToyStory",R.drawable.toystory,R.drawable.toystoryheader,"Pelicula ejemplo"))
    peliculas.add(Pelicula("HarryPotter",R.drawable.harrypotter,R.drawable.harrypotterheader,"Pelicula ejemplo"))
    }

    }

    class PeliculaAdapter: BaseAdapter {
    var peliculas = ArrayList<Pelicula>()
    var context: Context? = null
    private lateinit var binding: ActivityMainBinding


        constructor(context: Context, peliculas:ArrayList<Pelicula>){
        this.context=context
        this.peliculas=peliculas

    }

        override fun getCount(): Int {
            return peliculas.size
        }

        override fun getItem(position: Int): Any {
            return peliculas[position]        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val pelicula = peliculas[position]
            val inflater = LayoutInflater.from(context)
            val binding: PeliculaBinding

            if (convertView == null) {
                binding = PeliculaBinding.inflate(inflater, parent, false)
                binding.root.tag = binding
            } else {
                binding = convertView.tag as PeliculaBinding
            }

            // Manejar el clic en la imagen de la película
            binding.ivPelicula.setOnClickListener {
                val intent = Intent(context, MovieDetail::class.java).apply {
                    putExtra("nombre", pelicula.titulo)
                    putExtra("header", pelicula.header)
                    putExtra("sinopsis", pelicula.sinopsis)
                }
                context?.startActivity(intent)
            }

            return binding.root
        }

    }