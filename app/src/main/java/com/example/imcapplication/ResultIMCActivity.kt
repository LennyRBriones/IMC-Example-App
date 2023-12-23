package com.example.imcapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat

class ResultIMCActivity : AppCompatActivity() {

    private lateinit var tvresult:TextView
    private lateinit var tvimc:TextView
    private lateinit var tvdescripcion:TextView
    private lateinit var btnrecalculate:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)

        val result:Double = intent.extras?.getDouble("IMC_RESULT")?: -1.0
        initcomponents()
        initUI(result)
        initlisteners()

    }

    private fun initlisteners() {
        btnrecalculate.setOnClickListener { onBackPressed() }
    }

    private fun initUI(result: Double) {
        tvimc.text = result.toString()
        when(result){
            in 0.00..18.50 ->{ //Bajo Peso
                tvresult.text = getString(R.string.titleunderwight)
                tvresult.setTextColor(ContextCompat.getColor(this, R.color.underweight))
                tvdescripcion.text = getString(R.string.descriptionunderwight)
            }
            in 18.51..24.99 ->{ //Peso Normal
                tvresult.text = getString(R.string.titlnormal)
                tvresult.setTextColor(ContextCompat.getColor(this, R.color.normalweight))
                tvdescripcion.text = getString(R.string.descriptionnormal)
            }
            in 25.00..29.99 ->{ // Peso Alto
                tvresult.text = getString(R.string.titleoverwight)
                tvresult.setTextColor(ContextCompat.getColor(this, R.color.overweight))
                tvdescripcion.text = getString(R.string.descriptionoverwight)
            }
            in 30.00..99.99 ->{ // Obesidad
                tvresult.text = getString(R.string.titleobesity)
                tvresult.setTextColor(ContextCompat.getColor(this, R.color.obesity))
                tvdescripcion.text = getString(R.string.descriptionobesity)
            }
            else -> {//error
                tvimc.text = getString(R.string.error)
                tvresult.text = getString(R.string.error)
                tvdescripcion.text = getString(R.string.error)
            }
        }
    }

    private fun initcomponents(){
        tvimc = findViewById(R.id.tvimc)
        tvresult = findViewById(R.id.tvresult)
        tvdescripcion = findViewById(R.id.tvdescription)
        btnrecalculate = findViewById(R.id.btnrecalculate)
    }
}