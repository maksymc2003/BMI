package com.example.bmi

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bmi.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        binding.textViewWynik.text = ""

        setContentView(binding.root)

        binding.button.setOnClickListener {

            val weightStr = binding.textInputLayout.editText?.text.toString()
            val heightStr = binding.textInputLayout2.editText?.text.toString()

            try {
                val weightNum = weightStr.toFloat()
                val heightNum = heightStr.toFloat()

                val BMI = weightNum/heightNum.pow(2)

                binding.textViewWynik.text = "BMI: " + String.format("%.1f", BMI)

                if (BMI < 18.5)
                {
                    binding.textViewWynik.setTextColor(Color.parseColor("#00d0ff"))
                    Toast.makeText(applicationContext, "BMI wskazuje na niedowagę", Toast.LENGTH_SHORT).show()
                }
                else if(BMI < 25)
                {
                    binding.textViewWynik.setTextColor(Color.parseColor("#00db49"))
                    Toast.makeText(applicationContext, "BMI jest prawidłowe", Toast.LENGTH_SHORT).show()
                }
                else if(BMI < 30)
                {
                    binding.textViewWynik.setTextColor(Color.parseColor("#db8b00"))
                    Toast.makeText(applicationContext, "BMI wskazuje na nadwagę", Toast.LENGTH_SHORT).show()
                }
                else
                {
                    binding.textViewWynik.setTextColor(Color.parseColor("#ff0000"))
                    Toast.makeText(applicationContext, "BMI wskazuje na znaczną nadwagę", Toast.LENGTH_SHORT).show()
                }


            }
            catch (e: Exception) {
                Toast.makeText(applicationContext, "Błąd danych wejściowych!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}