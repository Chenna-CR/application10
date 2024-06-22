package com.cr7.application10

import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.cr7.application10.R


class MainActivity : AppCompatActivity() {

    private lateinit var numberEditText: EditText
    private lateinit var showDialogButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberEditText = findViewById(R.id.numberEditText)
        showDialogButton = findViewById(R.id.showDialogButton)

        showDialogButton.setOnClickListener { showAlertDialog() }
    }

    private fun showAlertDialog() {
        val originalNumber = numberEditText.text.toString().toIntOrNull() ?: 0

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Number Operations")

        val inputEditText = EditText(this)
        inputEditText.inputType = InputType.TYPE_CLASS_NUMBER
        inputEditText.setText(originalNumber.toString())
        builder.setView(inputEditText)

        builder.setPositiveButton("Add") { _, _ ->
            val newNumber = inputEditText.text.toString().toIntOrNull() ?: 0
            numberEditText.setText((originalNumber + newNumber).toString())
        }

        builder.setNegativeButton("Subtract") { _, _ ->
            val newNumber = inputEditText.text.toString().toIntOrNull() ?: 0
            numberEditText.setText((originalNumber - newNumber).toString())
        }

        builder.setNeutralButton("Reset") { _, _ ->
            numberEditText.setText("0")
        }

        builder.show()
    }
}
