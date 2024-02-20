package com.example.practica4pcfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.practica4pcfactory.databinding.ActivityMainBinding
import com.example.practica4pcfactory.databinding.PeliculaBinding


class MainActivity : AppCompatActivity() {
    var adapter: PeliculaAdapter? = null
    var peliculas = ArrayList<Pelicula>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras

        if(bundle!=null)
        {
            var movieSelected = bundle.getInt("movieSelected");
            peliculas.get(movieSelected).seats.add(Cliente("Default","Default", 1
            ));
        }else{
            cargarPeliculas()
        }

        adapter = PeliculaAdapter(this,peliculas)
        binding.gridview.adapter = adapter
    }

    fun cargarPeliculas(){
        peliculas.add(Pelicula("Toy Story",R.drawable.toystory,R.drawable.toystoryheader,"Descripción de ejemplo", arrayListOf<Cliente>()))
        peliculas.add(Pelicula("Big Hero 6",R.drawable.bighero6,R.drawable.headerbighero6,"Descripción de ejemplo", arrayListOf<Cliente>()))
        peliculas.add(Pelicula("Bones",R.drawable.bones,R.drawable.bonesheader,"Descripción de ejemplo", arrayListOf<Cliente>()))
        peliculas.add(Pelicula("Dr. House",R.drawable.drhouse,R.drawable.househeader,"Descripción de ejemplo", arrayListOf<Cliente>()))
        peliculas.add(Pelicula("Dr. Who",R.drawable.drwho,R.drawable.drwhoheader,"Descripción de ejemplo", arrayListOf<Cliente>()))
        peliculas.add(Pelicula("Friends",R.drawable.friends,R.drawable.friendsheader,"Descripción de ejemplo", arrayListOf<Cliente>()))
        peliculas.add(Pelicula("Inception",R.drawable.inception,R.drawable.inceptionheader,"Descripción de ejemplo", arrayListOf<Cliente>()))
        peliculas.add(Pelicula("Leap Year",R.drawable.leapyear,R.drawable.leapyearheader,"", arrayListOf<Cliente>()))
        peliculas.add(Pelicula("Smallville",R.drawable.smallville,R.drawable.smallvilleheader,"Descripción de ejemplo", arrayListOf<Cliente>()))

    }
}
class PeliculaAdapter: BaseAdapter{
    var peliculas = ArrayList<Pelicula>()
    var context: Context? = null
    constructor(context: Context,peliculas: ArrayList<Pelicula>){
        this.context = context
        this.peliculas=  peliculas
    }

    override fun getCount(): Int {
        return peliculas.size
    }

    override fun getItem(position: Int): Any {
        return peliculas[position]
    }

    override fun getItemId(position: Int): Long {
      return position.toLong()
    }

    override fun getView(p0: Int, convertView: View?, parent: ViewGroup?): View {
        var pelicula = peliculas[p0]
        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val binding: PeliculaBinding
        binding = PeliculaBinding.inflate(inflator, parent, false)

        binding.ivPelicula.setImageResource(pelicula.image)

        binding.ivTituloPelicula.setText(pelicula.titulo)

        binding.ivPelicula.setOnClickListener(){
            val intent = Intent(context,DetallePelicula::class.java).apply {
                putExtra("pos",p0)
                putExtra("titulo",pelicula.titulo)
                putExtra("image", pelicula.image)
                putExtra("header", pelicula.header)
                putExtra("sinopsis", pelicula.sinopsis)
                putExtra("numberSeats",20-pelicula.seats.size)

        }
            context!!.startActivity(intent) }
        return binding.root
    }
}