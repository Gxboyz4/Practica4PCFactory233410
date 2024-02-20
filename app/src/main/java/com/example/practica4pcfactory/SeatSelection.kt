package com.example.practica4pcfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.practica4pcfactory.databinding.ActivitySeatSelectionBinding
import android.content.Intent


class SeatSelection : AppCompatActivity() {
    private lateinit var binding: ActivitySeatSelectionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeatSelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var posMovie = -1
        val bundle = intent.extras

        if(bundle!=null)
        {
            binding.tittleSeats.setText(bundle.getString("name"))
            posMovie = bundle.getInt("id")
        }else{
            binding.tittleSeats.setText("Texto")
            posMovie = 1
        }

        binding.confirm.setOnClickListener{
            Toast.makeText(this,"Disfruta la película! :D",Toast.LENGTH_LONG).show()
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("movieSelected", posMovie)
            }
            this!!.startActivity(intent)
        }


        binding.row1.setOnCheckedChangeListener{
            group, checkedId ->
            if(checkedId > -1)
            {
                binding.row2.clearCheck()
                binding.row3.clearCheck()
                binding.row4.clearCheck()
                binding.row1.check(checkedId)
            }
        }
        binding.row2.setOnCheckedChangeListener{
                group, checkedId ->
            if(checkedId > -1)
            {
                binding.row1.clearCheck()
                binding.row3.clearCheck()
                binding.row4.clearCheck()
                binding.row2.check(checkedId)
            }
        }
        binding.row3.setOnCheckedChangeListener{
                group, checkedId ->
            if(checkedId > -1)
            {
                binding.row2.clearCheck()
                binding.row1.clearCheck()
                binding.row4.clearCheck()
                binding.row3.check(checkedId)
            }
        }
        binding.row4.setOnCheckedChangeListener{
                group, checkedId ->
            if(checkedId > -1)
            {
                binding.row2.clearCheck()
                binding.row3.clearCheck()
                binding.row1.clearCheck()
                binding.row4.check(checkedId)
            }
        }


    }
}