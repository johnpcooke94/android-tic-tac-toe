package com.ius.p435.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class TurnTracker {

    private val turns: Array<String> = arrayOf("x", "o")
    private var currentTurn: Int = 0

    fun getCurrentTurn(): String {
        return turns[currentTurn]
    }

    fun iterateTurn() {
        if (currentTurn == 1) {
            currentTurn = 0
        }
        else {
            currentTurn++
        }
    }

}

class MainActivity : AppCompatActivity() {

    private val turnTracker = TurnTracker()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val topLeftButton = findViewById<Button>(R.id.top_left)
        topLeftButton.setOnClickListener {onButtonClick(topLeftButton)}
    }

    private fun onButtonClick(button: Button) {
        if (button.text == "") {

            if (turnTracker.getCurrentTurn().lowercase() == "x") {
                button.text = "X"
            }
            else {
                button.text = "Y"
            }

            turnTracker.iterateTurn()

        }
        else {
            Toast.makeText(this@MainActivity, "That square has already been used!",
                Toast.LENGTH_LONG).show()
        }
    }
}