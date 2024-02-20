package com.example.practica4pcfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practica4pcfactory.databinding.ActivityDetallePeliculaBinding
import android.content.Intent

class DetallePelicula : AppCompatActivity() {
    private lateinit var binding: ActivityDetallePeliculaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetallePeliculaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle = intent.extras
        var ns = 0
        var id = -1
        var title = ""
        if (bundle != null) {
            ns = bundle.getInt("numberSeats")
            title = bundle.getString("titulo")!!
            binding.ivPeliculaImagen.setImageResource(bundle.getInt("header"))
            binding.tvNombrePelicula.setText(title)
            binding.tvPeliculaDesc.setText(bundle.getString("sinopsis"))
            binding.seatLeft.setText("$ns seats avaible")
            id = bundle.getInt("pos")
        }
        if (ns == 0) {
            binding.buyTickets.isEnabled = false
        } else {
            binding.buyTickets.isEnabled = true
            binding.buyTickets.setOnClickListener {
                val intent = Intent(this, SeatSelection::class.java).apply {
                    putExtra("id", id)
                    putExtra("name", title)
                }
                this!!.startActivity(intent)
            }
        }

    }
}
