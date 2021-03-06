package com.sdesign.snoopy.my_first_calculator


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.sdesign.snoopy.my_first_calculator.R.id
import com.sdesign.snoopy.my_first_calculator.R.layout


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        updateUI("")
    }


    val operationList: MutableList<String> = arrayListOf()
    val numCache: MutableList<String> = arrayListOf()

    private fun extractString (items: List<String>, connect: String = ""): String {
        if (items.isEmpty()) return ""
        return items.reduce { acc, s ->  acc + connect + s}
    }

    private fun updateUI (mainUIString: String) {
        val calculationString = extractString(operationList, " ")
        val calculationTxtView = findViewById<View>(id.displayText) as TextView
        calculationTxtView.text = calculationString

        val ans = findViewById<View>(id.displayResult) as TextView
        ans.text = mainUIString
    }

    fun numberSmash (view: View) {
        val button = view as Button
        val numString = button.text

        numCache.add (numString.toString())
        val text = extractString(numCache)
        updateUI(text)
    }

    fun operatorSmash (view: View) {
        val button = view as Button
        if (numCache.isEmpty()) return

        operationList.add(extractString(numCache))
        numCache.clear()
        operationList.add(button.text.toString())
        updateUI(button.text.toString())
    }

    private fun clearCache () {
        operationList.clear()
        numCache.clear()
    }

    fun allClear(view: View) {
        clearCache()
        updateUI("")
    }

    fun equalSmash(view: View) {
        operationList.add (extractString(numCache))
        numCache.clear()

        val calculator = StringCalculator()
        val answer = calculator.calculate(operationList)

        updateUI(mainUIString = "= " + answer.toString())
        clearCache()

    }

}
