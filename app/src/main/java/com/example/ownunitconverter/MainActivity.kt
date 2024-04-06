package com.example.ownunitconverter

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ownunitconverter.ui.theme.OwnUnitConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OwnUnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter()
                }
            }
        }
    }
}

@Composable
fun UnitConverter(){
    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("Meters") }
    var outputUnit  by remember { mutableStateOf("Meters") }
    var iExpended by remember { mutableStateOf(false) }
    var oExpended by remember { mutableStateOf(false) }
    val iConversionFactor = remember { mutableStateOf(1.0) }
    val oConversionFactor = remember { mutableStateOf(1.0) }

    fun Convert(){
        val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0
        val result= (inputValueDouble*iConversionFactor.value*100/oConversionFactor.value)/100
        outputValue = ("%.4f".format(result))

    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text(text = "Unit Converter")
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(value = inputValue,
            onValueChange ={
                inputValue=it
                Convert()

            },
            label = {
                Text(text = "Enter Value")
            }

        )
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            Box {
                Button(onClick = { iExpended=true }) {
                    Text(inputUnit)
                    Icon(Icons.Default.ArrowDropDown,contentDescription = null)
                }
                DropdownMenu(expanded = iExpended, onDismissRequest = { iExpended=false }) {
                    DropdownMenuItem(
                        text = { Text(text = "Millimeters") },
                        onClick = {
                            iExpended=false
                            inputUnit="Millimeters"
                            iConversionFactor.value=0.001
                            Convert()

                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Centimeters") },
                        onClick = {
                            iExpended=false
                            inputUnit="Centimeters"
                            iConversionFactor.value=0.01
                            Convert()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Meters") },
                        onClick = {
                            iExpended=false
                            inputUnit="Meters"
                            iConversionFactor.value=1.0
                            Convert()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Kilometers") },
                        onClick = {
                            iExpended=false
                            inputUnit="Kilometers"
                            iConversionFactor.value=1000.0
                            Convert()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Inches") },
                        onClick = {
                            iExpended=false
                            inputUnit="Inches"
                            iConversionFactor.value=0.0254
                            Convert()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Feet") },
                        onClick = {
                            iExpended=false
                            inputUnit="Feet"
                            iConversionFactor.value=0.3048
                            Convert()
                        }
                    )
                    
                }
            

            }
            Spacer(modifier = Modifier.width(15.dp))
            Box {
                Button(onClick = {oExpended=true}) {
                    Text(outputUnit)
                    Icon(Icons.Default.ArrowDropDown,contentDescription = null)
                }
                DropdownMenu(expanded = oExpended, onDismissRequest = {oExpended=false}) {
                    DropdownMenuItem(
                        text = { Text(text = "Millimeters") },
                        onClick = {
                            oExpended=false
                            outputUnit="Millimeters"
                            oConversionFactor.value=0.001
                            Convert()

                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Centimeters") },
                        onClick = {
                            oExpended=false
                            outputUnit="Centimeters"
                            oConversionFactor.value=0.01
                            Convert()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Meters") },
                        onClick = {
                            oExpended=false
                            outputUnit="Meters"
                            oConversionFactor.value=1.0
                            Convert()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Kilometers") },
                        onClick = {
                            oExpended=false
                            outputUnit="Kilometers"
                            oConversionFactor.value=1000.0
                            Convert()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Inches") },
                        onClick = {
                            oExpended=false
                            outputUnit="Inches"
                            oConversionFactor.value=0.0254
                            Convert()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Feet") },
                        onClick = {
                            oExpended=false
                            outputUnit="Feet"
                            oConversionFactor.value=0.3048
                            Convert()
                        }
                    )

                }

            }
        } 
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "${inputValue} ${inputUnit} is ${outputValue} ${outputUnit}")
    }
    

}
@Preview (showBackground = true)
@Composable
fun UnitConverterPreview(){
    UnitConverter()
}





