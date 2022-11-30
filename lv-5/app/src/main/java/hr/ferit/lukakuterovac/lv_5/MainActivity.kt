package hr.ferit.lukakuterovac.lv_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameView = findViewById<TextView>(R.id.textViewName)
        val detailsView = findViewById<TextView>(R.id.textViewDetails)
        val nameEditView = findViewById<EditText>(R.id.editTextTextName)
        val detailsEditView = findViewById<EditText>(R.id.editTextTextDetails)

        val inputButton = findViewById<Button>(R.id.buttonInput)
        inputButton.setOnClickListener {
            val newName = nameEditView.text
            val newDetails = detailsEditView.text

            nameView.text = newName
            detailsView.text = newDetails
        }

        val calculateButton = findViewById<Button>(R.id.buttonCalculate)
        calculateButton.setOnClickListener {
            val heightEditView = findViewById<EditText>(R.id.editTextNumberHeight)
            val weightEditView = findViewById<EditText>(R.id.editTextNumberWeight)

            val height = heightEditView.text.toString().toDouble()
            val weight = weightEditView.text.toString().toDouble()
            val bmi = calculateBMI(height, weight)

            Toast.makeText(this, "${R.string.bmi_text}: $bmi", Toast.LENGTH_LONG).show()
        }
    }

    private fun calculateBMI(height: Double, weight: Double): Double {
        if (height > 10) {
            return weight / (height / 100).pow(2.0)
        }
        return weight / height.pow(2.0)
    }
}