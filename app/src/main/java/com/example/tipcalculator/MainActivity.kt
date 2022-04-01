package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tipcalculator.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var bind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.calculateButton.setOnClickListener {
            calculateTip()
        }

    }

    private fun calculateTip() {
        val costOfServiceText = bind.text1.text.toString()
        if(costOfServiceText != "") {
            val costOfService = costOfServiceText.toDouble()

            val idOfSelection = bind.tipOptions.checkedRadioButtonId

            val percentage = when(idOfSelection){
                bind.option1.id -> 0.185
                bind.option2.id -> 0.135
                else -> 0.085
            }
            var tipAmount = percentage*costOfService
            val round = bind.roundSwitch.isChecked

            if(round)
                tipAmount = kotlin.math.ceil(tipAmount)

            NumberFormat.getCurrencyInstance()
            val formattedTip=NumberFormat.getCurrencyInstance().format(tipAmount)
            bind.tipAmount.setText("Tip amount : " + formattedTip)
        }

    }

}