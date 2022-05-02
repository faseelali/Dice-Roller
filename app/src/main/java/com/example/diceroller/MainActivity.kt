package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 *
 *
 * This activity allows the user to roll a
 * Dice and view the result on the screen
 */
class MainActivity : AppCompatActivity() {
    /**
     * This method is called when the activity
     * is created
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Find the button in the layout
        val rollButton: Button = findViewById(R.id.button)

        //Set a click listener to roll the dice the Dice when Roll Button is clicked
        rollButton.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        //Create a new Dice object with 6 sides and roll it
        val dice1 = Dice(6)
        val dice2 = Dice(6)

        val dice1Roll = dice1.roll()
        val dice2Roll = dice2.roll()

        //Update the screen with the dice roll
        val resultTextView1: TextView = findViewById(R.id.textView)
        resultTextView1.text = dice1Roll.toString()

        val resultTextView2: TextView = findViewById(R.id.textView2)
        resultTextView2.text = dice2Roll.toString()
    }
}

//Dice with a Fixed number of Sides
class Dice(private val numSides: Int) {

    //Function to get a random number which is returned
    fun roll(): Int {
        return (1..numSides).random()
    }
}
