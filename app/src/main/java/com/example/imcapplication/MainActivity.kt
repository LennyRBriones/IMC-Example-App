package com.example.imcapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private var isMaleSelected:Boolean = true
    private var isFemaleSelected:Boolean = false
    private var currentweight: Int = 60
    private var currentage: Int = 25

    private lateinit var viewMale:CardView
    private lateinit var viewFemale:CardView
    private lateinit var txvheight:TextView
    private lateinit var rsheight:RangeSlider
    private lateinit var btnsubstractweight:FloatingActionButton
    private lateinit var btnplusweight:FloatingActionButton
    private lateinit var tvweight:TextView
    private lateinit var btnsubstractage:FloatingActionButton
    private lateinit var btnplusage:FloatingActionButton
    private lateinit var tvage:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        initListeners()
        initUI()
    }

    private fun initComponents(){
        viewFemale = findViewById(R.id.viewfemale)
        viewMale = findViewById(R.id.viewmale)
        txvheight = findViewById(R.id.txvheight)
        rsheight = findViewById(R.id.rsheight)
        btnplusweight = findViewById(R.id.btnplusweight)
        btnsubstractweight = findViewById(R.id.btnsubstractweight)
        tvweight = findViewById(R.id.tvweight)
        btnplusage = findViewById(R.id.btnplusage)
        btnsubstractage = findViewById(R.id.btnsubstractage)
        tvage = findViewById(R.id.tvage)
    }

    private fun initListeners(){
        viewMale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        viewFemale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        rsheight.addOnChangeListener{_, value, _ ->
            val df = DecimalFormat("#.##")
            val result =df.format(value)
            txvheight.text = "$result cm"
        }
        btnplusweight.setOnClickListener{
            currentweight += 1
            setweight()
        }
        btnsubstractweight.setOnClickListener{
            currentweight -= 1
            setweight()
        }

        btnplusage.setOnClickListener{
            currentage += 1
            setage()
        }

        btnsubstractage.setOnClickListener{
            currentage -= 1
            setage()
        }
    }

    private fun setweight(){
        tvweight.text = currentweight.toString()
    }

    private fun setage(){
        tvage.text = currentage.toString()
    }

    private fun changeGender(){
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }

    private fun setGenderColor(){
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setBackgroundColor(getBackgroundColor(isFemaleSelected))

    }

    private fun getBackgroundColor(isSelectedComponent:Boolean):Int{

        val colorReference = if(isSelectedComponent){
            R.color.background_component_selected
        } else{
            R.color.background_component
        }

        return ContextCompat.getColor(this, colorReference)
    }
    private fun initUI(){
        setGenderColor()
        setweight()
        setage()
    }
}