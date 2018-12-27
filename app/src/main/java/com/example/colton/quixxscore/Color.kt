package com.example.colton.quixxscore

import android.app.Activity
import android.graphics.Color
import android.util.Log
import android.widget.Button

class Color(val activity: Activity, val color: Int) {
    private var cap: Int = 1
        set(value) {
            if(value in 2..13 && value > cap) {
                field = value
            }
        }

    private var count = 0
    private var pressed: LinkedList<Int> = LinkedList()

    fun pressed(number: Int): Int {
        if(number == 12 && cap < 5) {
            return cap
        }

        if(number > cap) {
            pressed.addLast(number)
            count++
            if(number == 12) {
                count++
            }
        }
        cap = number
        when(color) {
            0 -> {
                for (i in 0 until number - 1) {
                    var button = activity.findViewById<Button>(MainActivity.redArray[i])
                    button.setBackgroundColor(Color.BLACK)
                    button.setTextColor(Color.RED)
                }
                if(number == 12) {
                    activity.findViewById<Button>(R.id.redLock).setBackgroundColor(Color.BLACK)
                }
            }

            1 -> {
                for (i in 0 until number - 1) {
                    var button = activity.findViewById<Button>(MainActivity.yellowArray[i])
                    button.setBackgroundColor(Color.BLACK)
                    button.setTextColor(Color.YELLOW)
                }
                if(number == 12) {
                    activity.findViewById<Button>(R.id.yellowLock).setBackgroundColor(Color.BLACK)
                }
            }

            2 -> {
                for (i in 0 until number - 1) {
                    var button = activity.findViewById<Button>(MainActivity.greenArray[i])
                    button.setBackgroundColor(Color.BLACK)
                    button.setTextColor(Color.GREEN)
                }
                if(number == 12) {
                    activity.findViewById<Button>(R.id.greenLock).setBackgroundColor(Color.BLACK)
                }
            }

            3 -> {
                for (i in 0 until number - 1) {
                    var button = activity.findViewById<Button>(MainActivity.blueArray[i])
                    button.setBackgroundColor(Color.BLACK)
                    button.setTextColor(Color.BLUE)
                }
                if(number == 12) {
                    activity.findViewById<Button>(R.id.blueLock).setBackgroundColor(Color.BLACK)
                }
            }
        }
        return cap
    }

    fun lock() {
        when(color) {
            0 ->{
                for (i in MainActivity.redArray) {
                    var button = activity.findViewById<Button>(i)
                    button.setBackgroundColor(Color.BLACK)
                    button.setTextColor(Color.RED)
                    Log.i("MAIN_TEST", button.id.toString())
                }
                activity.findViewById<Button>(R.id.redLock).setBackgroundColor(Color.BLACK)
            }

            1 -> {
                for (i in MainActivity.yellowArray) {
                    var button = activity.findViewById<Button>(i)
                    button.setBackgroundColor(Color.BLACK)
                    button.setTextColor(Color.YELLOW)
                    Log.i("MAIN_TEST", button.id.toString())
                }
                activity.findViewById<Button>(R.id.yellowLock).setBackgroundColor(Color.BLACK)
            }

            2 -> {
                for (i in MainActivity.greenArray) {
                    var button = activity.findViewById<Button>(i)
                    button.setBackgroundColor(Color.BLACK)
                    button.setTextColor(Color.GREEN)
                }
                activity.findViewById<Button>(R.id.greenLock).setBackgroundColor(Color.BLACK)
            }

            3 -> {
                for (i in MainActivity.blueArray) {
                    var button = activity.findViewById<Button>(i)
                    button.setBackgroundColor(Color.BLACK)
                    button.setTextColor(Color.BLUE)
                }
                activity.findViewById<Button>(R.id.blueLock).setBackgroundColor(Color.BLACK)
            }
        }
        cap = 13
    }

    fun score(): Int {
        var score = 0
        if(count == 0) return 0
        for(i in 0 until count) {
            score += i + 1
        }
        return score
    }
}