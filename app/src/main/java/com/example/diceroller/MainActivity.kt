//https://developer.android.com/codelabs/kotlin-android-training-app-anatomy?hl=es-419#6

//Challenge: Add a second button to the app labeled "Count Up" that appears just below
// the Roll button.
// When tapped, the Count Up button should get the current value of the result text view,
// add 1 to it, and update the text view. Make sure you handle these edge cases:
//
//If the result text view does not yet contain a number
// (that is, if the text view still has the default "Hello World" string),

// set the result text to 1.

//If the number is already 6, do nothing.

//Tip: The string in TextView views is an instance of class CharSequence. To test its value, you need to convert it to a string:
//
//resultText.text.toString()


package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val countButton: Button = findViewById(R.id.count_button)
        countButton.setOnClickListener { countDice() }


    }

    private fun rollDice() {
//        Toast.makeText(this, "button clicked",
//            Toast.LENGTH_SHORT).show()
        val randomInt = (1..6).random()
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = randomInt.toString()
//        val resultText: TextView = findViewById(R.id.result_text)
//        resultText.text = "Dice Rolled!"
    }

    private fun countDice() {
        val resultText: TextView = findViewById(R.id.result_text)
        if (resultText.text == "Hello World!") {
            resultText.text = "1"
        } else {
            // Otherwise, increment the number up to 6.
            // The text value in resultText.text is an instance of the CharSequence class;
            // it needs to be converted to a String object before it can be converted to
            // an int.
            var resultInt = resultText.text.toString().toInt()

            if (resultInt < 6) {
                resultInt++
                resultText.text = resultInt.toString()
            }
        }

    }


}