package com.example.binary_converter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import  androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.KeyboardType

import java.math.BigDecimal

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.LightGray
            ) {
                BinaryConverterApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun BinaryConverterApp() {
    var inputText by remember { mutableStateOf("") }
    var binaryResult by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = inputText,
            onValueChange = { inputText = it },
            label = { Text("Enter a Number") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Validate and convert the input when the button is clicked
                val inputNumber = inputText.toBigDecimal()
                if (inputNumber != null) {
                    binaryResult = convertToBinary(inputNumber)
                } else {
                    binaryResult = "Invalid input"
                }
            }
        ) {
            Text("Convert to Binary")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Binary Result: $binaryResult")
    }
}
fun convertToBinary(number: BigDecimal): String {
    return number.toBigInteger().toString(2)
}
