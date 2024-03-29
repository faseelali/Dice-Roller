package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
//import android.widget.TextView
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

        //Set a click listener to roll the dice when Roll Button is clicked
        rollButton.setOnClickListener { rollDice() }

        rollDice()
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll the dice
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
    }

    //Dice with a Fixed number of Sides
    class Dice(private val numSides: Int) {

        //Function to get a random number which is returned
        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}