package com.example.colton.quixxscore

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var history = History()

    companion object {
        const val historyKey = "history"

        var redArray: IntArray = intArrayOf(
            R.id.red2,
            R.id.red3,
            R.id.red4,
            R.id.red5,
            R.id.red6,
            R.id.red7,
            R.id.red8,
            R.id.red9,
            R.id.red10,
            R.id.red11,
            R.id.red12
        )

        var yellowArray: IntArray = intArrayOf(
            R.id.yellow2,
            R.id.yellow3,
            R.id.yellow4,
            R.id.yellow5,
            R.id.yellow6,
            R.id.yellow7,
            R.id.yellow8,
            R.id.yellow9,
            R.id.yellow10,
            R.id.yellow11,
            R.id.yellow12
        )

        var greenArray: IntArray = intArrayOf(
            R.id.green12,
            R.id.green11,
            R.id.green10,
            R.id.green9,
            R.id.green8,
            R.id.green7,
            R.id.green6,
            R.id.green5,
            R.id.green4,
            R.id.green3,
            R.id.green2
        )

        var blueArray: IntArray = intArrayOf(
            R.id.blue12,
            R.id.blue11,
            R.id.blue10,
            R.id.blue9,
            R.id.blue8,
            R.id.blue7,
            R.id.blue6,
            R.id.blue5,
            R.id.blue4,
            R.id.blue3,
            R.id.blue2
        )

        var scratch: IntArray = intArrayOf(
            R.id.scratch1,
            R.id.scratch2,
            R.id.scratch3,
            R.id.scratch4
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        history = savedInstanceState?.getParcelable(historyKey) ?: History()
        history.scratch.activity = this


        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.redScore).text = history.red.score().toString()
        findViewById<TextView>(R.id.yellowScore).text = history.yellow.score().toString()
        findViewById<TextView>(R.id.greenScore).text = history.green.score().toString()
        findViewById<TextView>(R.id.blueScore).text = history.blue.score().toString()
        findViewById<TextView>(R.id.score).text = (history.red.score() + history.yellow.score() + history.green.score() + history.blue.score()).toString()
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.red2 -> history.write(Action(Action.RED, 2))
            R.id.red3 -> history.write(Action(Action.RED, 3))
            R.id.red4 -> history.write(Action(Action.RED, 4))
            R.id.red5 -> history.write(Action(Action.RED, 5))
            R.id.red7 -> history.write(Action(Action.RED, 6))
            R.id.red6 -> history.write(Action(Action.RED, 7))
            R.id.red8 -> history.write(Action(Action.RED, 8))
            R.id.red9 -> history.write(Action(Action.RED, 9))
            R.id.red10 -> history.write(Action(Action.RED, 10))
            R.id.red11 -> history.write(Action(Action.RED, 11))
            R.id.red12 -> history.write(Action(Action.RED, 12))
            R.id.redLock -> history.write(Action(Action.RED_LOCK, -1))
            R.id.yellow2 -> history.write(Action(Action.YELLOW, 2))
            R.id.yellow3 -> history.write(Action(Action.YELLOW, 3))
            R.id.yellow4 -> history.write(Action(Action.YELLOW, 4))
            R.id.yellow5 -> history.write(Action(Action.YELLOW, 5))
            R.id.yellow7 -> history.write(Action(Action.YELLOW, 6))
            R.id.yellow6 -> history.write(Action(Action.YELLOW, 7))
            R.id.yellow8 -> history.write(Action(Action.YELLOW, 8))
            R.id.yellow9 -> history.write(Action(Action.YELLOW, 9))
            R.id.yellow10 -> history.write(Action(Action.YELLOW, 10))
            R.id.yellow11 -> history.write(Action(Action.YELLOW, 11))
            R.id.yellow12 -> history.write(Action(Action.YELLOW, 12))
            R.id.yellowLock -> history.write(Action(Action.YELLOW_LOCK, -1))
            R.id.green2 -> history.write(Action(Action.GREEN, 2))
            R.id.green3 -> history.write(Action(Action.GREEN, 3))
            R.id.green4 -> history.write(Action(Action.GREEN, 4))
            R.id.green5 -> history.write(Action(Action.GREEN, 5))
            R.id.green7 -> history.write(Action(Action.GREEN, 6))
            R.id.green6 -> history.write(Action(Action.GREEN, 7))
            R.id.green8 -> history.write(Action(Action.GREEN, 8))
            R.id.green9 -> history.write(Action(Action.GREEN, 9))
            R.id.green10 -> history.write(Action(Action.GREEN, 10))
            R.id.green11 -> history.write(Action(Action.GREEN, 11))
            R.id.green12 -> history.write(Action(Action.GREEN, 12))
            R.id.greenLock -> history.write(Action(Action.GREEN_LOCK, -1))
            R.id.blue2 -> history.write(Action(Action.BLUE, 2))
            R.id.blue3 -> history.write(Action(Action.BLUE, 3))
            R.id.blue4 -> history.write(Action(Action.BLUE, 4))
            R.id.blue5 -> history.write(Action(Action.BLUE, 5))
            R.id.blue7 -> history.write(Action(Action.BLUE, 6))
            R.id.blue6 -> history.write(Action(Action.BLUE, 7))
            R.id.blue8 -> history.write(Action(Action.BLUE, 8))
            R.id.blue9 -> history.write(Action(Action.BLUE, 9))
            R.id.blue10 -> history.write(Action(Action.BLUE, 10))
            R.id.blue11 -> history.write(Action(Action.BLUE, 11))
            R.id.blue12 -> history.write(Action(Action.BLUE, 12))
            R.id.blueLock -> history.write(Action(Action.BLUE_LOCK, -1))
            R.id.scratch1 -> history.write(Action(Action.SCRATCH, -1))
            R.id.scratch2 -> history.write(Action(Action.SCRATCH, -1))
            R.id.scratch3 -> history.write(Action(Action.SCRATCH, -1))
            R.id.scratch4 -> history.write(Action(Action.SCRATCH, -1))
        }
        findViewById<TextView>(R.id.redScore).text = history.red.score().toString()
        findViewById<TextView>(R.id.yellowScore).text = history.yellow.score().toString()
        findViewById<TextView>(R.id.greenScore).text = history.green.score().toString()
        findViewById<TextView>(R.id.blueScore).text = history.blue.score().toString()
        findViewById<TextView>(R.id.score).text = (history.red.score() + history.yellow.score() + history.green.score() + history.blue.score() - history.scratch.getPenalty()).toString()

    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putParcelable(historyKey, history)
        super.onSaveInstanceState(outState)
    }

    fun pressed(action: Action) {
        when(action.kind) {
            0 -> {for (i in 0 until number - 1) {
                var button = activity.findViewById<Button>(MainActivity.redArray[i])
                button.setBackgroundColor(Color.BLACK)
                button.setTextColor(Color.RED)
            }
                if(number == 12) {
                    activity.findViewById<Button>(R.id.redLock).setBackgroundColor(Color.BLACK)
                }}
            1 -> {}
            2 -> {}
            3 -> {}
            4 -> {}
            5 -> {}
            6 -> {}
            7 -> {}
            8 -> {}
        }
    }
}
