package com.coalbell.qwixxscore

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.colton.quixxscore.R

class MainActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val HISTORY_KEY = "history"
        /*
        const val RED_CAP = "redCap"
        const val YELLOW_CAP = "yellowCap"
        const val GREEN_CAP = "greenCap"
        const val BLUE_CAP = "blueCap"
        const val RED_COUNT = "redCount"
        const val YELLOW_COUNT = "yellowCount"
        const val GREEN_COUNT = "greenCount"
        const val BLUE_COUNT = "blueCount"
        const val SCRATCH_COUNT = "scratchCount"
        const val RED_QBUTTON_ARRAY = "redQButtonArray"
        const val YELLOW_QBUTTON_ARRAY = "yellowQButtonArray"
        const val GREEN_QBUTTON_ARRAY = "greenQButtonArray"
        const val BLUE_QBUTTON_ARRAY = "blueQButtonArray"
        const val SCRATCH_QBUTTON_ARRAY = "scratchQButtonArray"
        const val LOCK_QBUTTON_ARRAY = "lockQButtonArray"
        */
    }

    private lateinit var history: HistoryStack
    private var scratchCount: Int = 0

    /*
    [0] = red
    [1] = yellow
    [2] = green
    [3] = blue
     */
    private lateinit var count: Array<Int>

    /*
    [0] = red
    [1] = yellow
    [2] = green
    [3] = blue
     */
    private lateinit var cap: Array<Int>
    private lateinit var redArray: Array<QButton>
    private lateinit var yellowArray: Array<QButton>
    private lateinit var greenArray: Array<QButton>
    private lateinit var blueArray: Array<QButton>
    private lateinit var colorArray: Array<Array<QButton>>
    private lateinit var scratchArray: Array<QButton>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        history = savedInstanceState?.getParcelable(HISTORY_KEY) ?: HistoryStack()
        cap = Array(4) { 1 }
        count = Array(4) { 0 }
        redArray = arrayOf(
            QButton(
                R.id.red2,
                2,
                QButton.RED,
                false
            ),
            QButton(
                R.id.red3,
                3,
                QButton.RED,
                false
            ),
            QButton(
                R.id.red4,
                4,
                QButton.RED,
                false
            ),
            QButton(
                R.id.red5,
                5,
                QButton.RED,
                false
            ),
            QButton(
                R.id.red6,
                6,
                QButton.RED,
                false
            ),
            QButton(
                R.id.red7,
                7,
                QButton.RED,
                false
            ),
            QButton(
                R.id.red8,
                8,
                QButton.RED,
                false
            ),
            QButton(
                R.id.red9,
                9,
                QButton.RED,
                false
            ),
            QButton(
                R.id.red10,
                10,
                QButton.RED,
                false
            ),
            QButton(
                R.id.red11,
                11,
                QButton.RED,
                false
            ),
            QButton(
                R.id.red12,
                12,
                QButton.RED,
                false
            ),
            QButton(
                R.id.redLock,
                13,
                QButton.RED_LOCK,
                false
            )
        )
        yellowArray = arrayOf(
            QButton(
                R.id.yellow2,
                2,
                QButton.YELLOW,
                false
            ),
            QButton(
                R.id.yellow3,
                3,
                QButton.YELLOW,
                false
            ),
            QButton(
                R.id.yellow4,
                4,
                QButton.YELLOW,
                false
            ),
            QButton(
                R.id.yellow5,
                5,
                QButton.YELLOW,
                false
            ),
            QButton(
                R.id.yellow6,
                6,
                QButton.YELLOW,
                false
            ),
            QButton(
                R.id.yellow7,
                7,
                QButton.YELLOW,
                false
            ),
            QButton(
                R.id.yellow8,
                8,
                QButton.YELLOW,
                false
            ),
            QButton(
                R.id.yellow9,
                9,
                QButton.YELLOW,
                false
            ),
            QButton(
                R.id.yellow10,
                10,
                QButton.YELLOW,
                false
            ),
            QButton(
                R.id.yellow11,
                11,
                QButton.YELLOW,
                false
            ),
            QButton(
                R.id.yellow12,
                12,
                QButton.YELLOW,
                false
            ),
            QButton(
                R.id.yellowLock,
                13,
                QButton.YELLOW_LOCK,
                false
            )
        )
        greenArray = arrayOf(
            QButton(
                R.id.green12,
                2,
                QButton.GREEN,
                false
            ),
            QButton(
                R.id.green11,
                3,
                QButton.GREEN,
                false
            ),
            QButton(
                R.id.green10,
                4,
                QButton.GREEN,
                false
            ),
            QButton(
                R.id.green9,
                5,
                QButton.GREEN,
                false
            ),
            QButton(
                R.id.green8,
                6,
                QButton.GREEN,
                false
            ),
            QButton(
                R.id.green7,
                7,
                QButton.GREEN,
                false
            ),
            QButton(
                R.id.green6,
                8,
                QButton.GREEN,
                false
            ),
            QButton(
                R.id.green5,
                9,
                QButton.GREEN,
                false
            ),
            QButton(
                R.id.green4,
                10,
                QButton.GREEN,
                false
            ),
            QButton(
                R.id.green3,
                11,
                QButton.GREEN,
                false
            ),
            QButton(
                R.id.green2,
                12,
                QButton.GREEN,
                false
            ),
            QButton(
                R.id.greenLock,
                13,
                QButton.GREEN_LOCK,
                false
            )
        )
        blueArray = arrayOf(
            QButton(
                R.id.blue12,
                2,
                QButton.BLUE,
                false
            ),
            QButton(
                R.id.blue11,
                3,
                QButton.BLUE,
                false
            ),
            QButton(
                R.id.blue10,
                4,
                QButton.BLUE,
                false
            ),
            QButton(
                R.id.blue9,
                5,
                QButton.BLUE,
                false
            ),
            QButton(
                R.id.blue8,
                6,
                QButton.BLUE,
                false
            ),
            QButton(
                R.id.blue7,
                7,
                QButton.BLUE,
                false
            ),
            QButton(
                R.id.blue6,
                8,
                QButton.BLUE,
                false
            ),
            QButton(
                R.id.blue5,
                9,
                QButton.BLUE,
                false
            ),
            QButton(
                R.id.blue4,
                10,
                QButton.BLUE,
                false
            ),
            QButton(
                R.id.blue3,
                11,
                QButton.BLUE,
                false
            ),
            QButton(
                R.id.blue2,
                12,
                QButton.BLUE,
                false
            ),
            QButton(
                R.id.blueLock,
                13,
                QButton.BLUE_LOCK,
                false
            )
        )
        colorArray = arrayOf(
            redArray,
            yellowArray,
            greenArray,
            blueArray
        )
        scratchArray = arrayOf(
            QButton(
                R.id.scratch1,
                -1,
                QButton.SCRATCH,
                false
            ),
            QButton(
                R.id.scratch2,
                -1,
                QButton.SCRATCH,
                false
            ),
            QButton(
                R.id.scratch3,
                -1,
                QButton.SCRATCH,
                false
            ),
            QButton(
                R.id.scratch4,
                -1,
                QButton.SCRATCH,
                false
            )
        )


        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<Button>(R.id.undo).setOnLongClickListener {
            while(undoHandler());
            true
        }

        this.readIn()

        findViewById<TextView>(R.id.redScore).text = score(0).toString()
        findViewById<TextView>(R.id.yellowScore).text = score(1).toString()
        findViewById<TextView>(R.id.greenScore).text = score(2).toString()
        findViewById<TextView>(R.id.blueScore).text = score(3).toString()
        findViewById<TextView>(R.id.score).text = (score(0) + score(1) + score(2) + score(3) - penalty()).toString()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putParcelable(HISTORY_KEY, history)
        /*
        outState?.putInt(RED_CAP, cap[0])
        outState?.putInt(YELLOW_CAP, cap[1])
        outState?.putInt(GREEN_CAP, cap[2])
        outState?.putInt(BLUE_CAP, cap[3])
        outState?.putInt(RED_COUNT, count[0])
        outState?.putInt(YELLOW_COUNT, count[1])
        outState?.putInt(GREEN_COUNT, count[2])
        outState?.putInt(BLUE_COUNT, count[3])
        outState?.putInt(SCRATCH_COUNT, scratchCount)
        outState?.putParcelableArray(RED_QBUTTON_ARRAY, redArray)
        outState?.putParcelableArray(YELLOW_QBUTTON_ARRAY, yellowArray)
        outState?.putParcelableArray(GREEN_QBUTTON_ARRAY, greenArray)
        outState?.putParcelableArray(BLUE_QBUTTON_ARRAY, blueArray)
        outState?.putParcelableArray(SCRATCH_QBUTTON_ARRAY, scratchArray)
        outState?.putParcelableArray(LOCK_QBUTTON_ARRAY, lockArray)
        */
        super.onSaveInstanceState(outState)
    }

    override fun onClick(v: View?) {
        onClick(v?.id, true)
    }

    fun onClick(id: Int?, write: Boolean) {
        for (i in redArray) {
            if (i.id == id) {
                clickHandler(i, write)
                return
            }
        }

        for (i in yellowArray) {
            if (i.id == id) {
                clickHandler(i, write)
                return
            }
        }

        for (i in greenArray) {
            if (i.id == id) {
                clickHandler(i, write)
                return
            }
        }

        for (i in blueArray) {
            if (i.id == id) {
                clickHandler(i, write)
                return
            }
        }

        for (i in scratchArray) {
            if (i.id == id) {
                clickHandler(i, write)
                return
            }
        }

        if (R.id.undo == id) undoHandler()
    }

    private fun clickHandler(qBtn: QButton, write: Boolean) {
        val color = when (qBtn.kind) {
            0, 1 -> 0
            2, 3 -> 1
            4, 5 -> 2
            6, 7 -> 3
            else -> -1
        }

        when (qBtn.kind) {
            //if number or lock button
            0, 1, 2, 3, 4, 5, 6, 7 -> {
                if ((cap[color] < qBtn.number) && ((qBtn.number != 12) || (count[color] > 4))) {
                    qBtn.pressed = true
                    cap[color] = qBtn.number
                    count[color] = when {
                        cap[color] == 12 -> count[color] + 2
                        cap[color] == 13 -> count[color]
                        else -> count[color] + 1
                    }
                    if(write) history.push(qBtn)
                    for (i in colorArray[color]) {
                        when {
                            i.pressed -> btnPressed(i)
                            i.number == 13 && colorArray[color][10].pressed -> btnUnavail(i)
                            i.number > cap[color] -> btnAvail(i)
                            else -> btnUnavail(i)
                        }
                    }
                }
            }
            //if scratch button
            8 -> {
                if (scratchCount < 4) {
                    scratchCount++
                    qBtn.pressed = true
                    if(write) history.push(qBtn)
                    for (i in 0 until scratchCount) {
                        findViewById<Button>(scratchArray[i].id).setBackgroundResource(R.drawable.scratch_line)
                    }
                }
            }
        }

        findViewById<TextView>(R.id.redScore).text = score(0).toString()
        findViewById<TextView>(R.id.yellowScore).text = score(1).toString()
        findViewById<TextView>(R.id.greenScore).text = score(2).toString()
        findViewById<TextView>(R.id.blueScore).text = score(3).toString()
        findViewById<TextView>(R.id.score).text = (score(0) + score(1) + score(2) + score(3) - penalty()).toString()
    }

    private fun undoHandler(): Boolean {
        var qBtn = history.pop() ?: return false
        val id = qBtn.id

        for (i in redArray) {
            if (i.id == id) {
                qBtn = i
            }
        }

        for (i in yellowArray) {
            if (i.id == id) {
                qBtn = i
            }
        }

        for (i in greenArray) {
            if (i.id == id) {
                qBtn = i
            }
        }

        for (i in blueArray) {
            if (i.id == id) {
                qBtn = i
            }
        }

        for (i in scratchArray) {
            if (i.id == id) {
                qBtn = i
            }
        }

        val color = when (qBtn.kind) {
            0, 1 -> 0
            2, 3 -> 1
            4, 5 -> 2
            6, 7 -> 3
            else -> -1
        }

        when (qBtn.kind) {
            //if number or lock button
            //undo needs fixed here
            0, 1, 2, 3, 4, 5, 6, 7 -> {
                qBtn.pressed = false

                count[color] = when {
                    cap[color] == 12 -> count[color] - 2
                    cap[color] == 13 -> count[color]
                    else -> count[color] - 1
                }

                loop@ for (i in cap[color] downTo 2) {
                    when {
                        colorArray[color][i - 2].pressed -> {
                            cap[color] = colorArray[color][i - 2].number
                            break@loop
                        }
                        i == 2 -> cap[color] = 1
                    }
                }

                for (i in colorArray[color]) {
                    when {
                        i.pressed -> btnPressed(i)
                        i.number > cap[color] -> btnAvail(i)
                        else -> btnUnavail(i)
                    }
                }

            }
            //if scratch button
            8 -> {
                if (scratchCount > 0) {
                    scratchCount--
                    qBtn.pressed = false
                    for (i in scratchCount until 4) {
                        findViewById<Button>(scratchArray[i].id).setBackgroundResource(R.drawable.scratch)
                    }
                }
            }
        }

        findViewById<TextView>(R.id.redScore).text = score(0).toString()
        findViewById<TextView>(R.id.yellowScore).text = score(1).toString()
        findViewById<TextView>(R.id.greenScore).text = score(2).toString()
        findViewById<TextView>(R.id.blueScore).text = score(3).toString()
        findViewById<TextView>(R.id.score).text = (score(0) + score(1) + score(2) + score(3) - penalty()).toString()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.quixx_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean = when(item?.itemId) {
        R.id.menu_reset -> {
            while(undoHandler());
            true
        }
        R.id.menu_feedBack -> {
            startActivity(Intent(this, Feedback::class.java))
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    private fun btnAvail(qBtn: QButton) {
        val color = when (qBtn.kind) {
            0, 1 -> R.color.red
            2, 3 -> R.color.yellow
            4, 5 -> R.color.green
            6, 7 -> R.color.blue
            else -> -1
        }
        if (color == -1) return

        findViewById<Button>(qBtn.id).apply {
            setTextColor(Color.BLACK)
            backgroundTintList = ColorStateList.valueOf(getColor(color))
        }
    }

    private fun btnUnavail(qBtn: QButton) {
        val color = when (qBtn.kind) {
            0, 1 -> R.color.redDim
            2, 3 -> R.color.yellowDim
            4, 5 -> R.color.greenDim
            6, 7 -> R.color.blueDim
            else -> -1
        }
        if (color == -1) return

        findViewById<Button>(qBtn.id).apply {
            setTextColor(Color.BLACK)
            backgroundTintList = ColorStateList.valueOf(getColor(color))
        }
    }

    private fun btnPressed(qBtn: QButton) {
        findViewById<Button>(qBtn.id).apply {
            setTextColor(Color.BLACK)
            var typedValue = TypedValue()
            theme.resolveAttribute(R.attr.colorPrimary, typedValue, true)
            backgroundTintList = ColorStateList.valueOf(typedValue.data)
        }
    }

    private fun readIn() {
        var read = history.deQueue()
        while (read != null) {
            if(read.pressed) {
                onClick(read.id, false)
            }
            read = history.deQueue()
        }
        history.resetQueue()
    }

    private fun score(color: Int): Int {
        var score = 0
        if (count[color] == 0) return 0
        for (i in 0 until count[color]) {
            score += i + 1
        }
        return score
    }

    private fun penalty() = scratchCount * 5
}
