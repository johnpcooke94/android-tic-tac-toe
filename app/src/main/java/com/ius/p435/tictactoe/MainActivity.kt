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
        val topMidButton = findViewById<Button>(R.id.top_mid)
        val topRightButton = findViewById<Button>(R.id.top_right)

        topLeftButton.setOnClickListener { onButtonClick(topLeftButton) }
        topMidButton.setOnClickListener { onButtonClick(topMidButton) }
        topRightButton.setOnClickListener { onButtonClick(topRightButton) }

        val midLeftButton = findViewById<Button>(R.id.mid_left)
        val midMidButton = findViewById<Button>(R.id.mid_mid)
        val midRightButton = findViewById<Button>(R.id.mid_right)

        midLeftButton.setOnClickListener { onButtonClick(midLeftButton) }
        midMidButton.setOnClickListener { onButtonClick(midMidButton) }
        midRightButton.setOnClickListener { onButtonClick(midRightButton) }

        val botLeftButton = findViewById<Button>(R.id.bot_left)
        val botMidButton = findViewById<Button>(R.id.bot_mid)
        val botRightButton = findViewById<Button>(R.id.bot_right)

        botLeftButton.setOnClickListener { onButtonClick(botLeftButton) }
        botMidButton.setOnClickListener { onButtonClick(botMidButton) }
        botRightButton.setOnClickListener { onButtonClick(botRightButton) }

    }

    private fun onButtonClick(button: Button) {
        if (button.text == "") {

            if (turnTracker.getCurrentTurn().lowercase() == "x") {
                button.text = "X"
            }
            else {
                button.text = "O"
            }

            turnTracker.iterateTurn()

        }
        else {
            Toast.makeText(this@MainActivity, "That square has already been used!",
                Toast.LENGTH_LONG).show()
        }
    }
}