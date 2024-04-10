package com.example.testing

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testing.ui.theme.TestingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column() {
                        MyProgressBar()
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestingTheme {
        MyProgressBar()
    }
}

@Composable
fun MyProgressBar() {
    Column(
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(color = Color.Blue, strokeWidth = 5.dp)
        LinearProgressIndicator(
            modifier = Modifier.padding(top = 50.dp), color = Color.Blue
        )
    }
}

// ---------------------------------------------------------------------------- \\

@Composable
fun MyIcon() {
    Icon(
        imageVector = Icons.Rounded.Star,
        contentDescription = "Icono",
        tint = Color.Red
    )
}

// ---------------------------------------------------------------------------- \\

@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Ejemplo",
        alpha = 0.7f,
        modifier = Modifier
            .clip(RoundedCornerShape(25f))
            .border(2.dp, Color.Red, CircleShape)
    )
}

// .clip(CircleShape)
// modifier = Modifier.clip(CircleShape)

// ---------------------------------------------------------------------------- \\

@Composable
fun MyButtonExample() {
    var enabled by rememberSaveable { mutableStateOf(true) }

    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Button(
            onClick = { enabled = false },
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.White
            ),
            border = BorderStroke(5.dp, Color.Green)
        ) {
            Text(text = "Botón")
        }
    }
}

// ---------------------------------------------------------------------------- \\


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldOutlined() {
    var myText by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = myText,
        onValueChange = {
            myText =
                it
        }, modifier = Modifier.padding(24.dp),
        label = { Text(text = "Escribe tu nombre") },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Blue,
            unfocusedBorderColor = Color.Black,
        )
    )
}

@Composable
fun MyTextField() {
    var myText by remember {
        mutableStateOf("")
    }
    TextField(
        value = myText,
        onValueChange = {
            myText =
                if (it.contains("a")) {
                    it.replace("a", "")
                } else {
                    it
                }
        },
        label = { Text(text = "Introduce tu nombre") })
}


// ---------------------------------------------------------------------------- \\

@Composable
fun MyText() {
    Column(Modifier.fillMaxSize()) {
        Text(text = "Esto es un ejemplo 1")
        Text(text = "Esto es un ejemplo 2", color = Color.Blue)
        Text(text = "Esto es un ejemplo 3", fontWeight = FontWeight.ExtraBold)
        Text(text = "Esto es un ejemplo 4", fontWeight = FontWeight.ExtraLight)
        Text(text = "Esto es un ejemplo 5", fontFamily = FontFamily.Cursive)
        Text(
            text = "Esto es un ejemplo 6",
            textDecoration = TextDecoration.LineThrough
        )
        Text(
            text = "Esto es un ejemplo 7",
            textDecoration = TextDecoration.LineThrough
        )
        Text(
            text = "Esto es un ejemplo 8",
            textDecoration = TextDecoration.Underline
        )
        Text(
            text = "Esto es un ejemplo 9", style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(TextDecoration.Underline, TextDecoration.LineThrough)
                )
            )
        )
        Text(text = "Esto es un ejemplo 10", fontSize = 30.sp)
    }
}


// ---------------------------------------------------------------------------- \\

@Composable
fun MyStateExample() {
    var contador by rememberSaveable { mutableStateOf(0) }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { contador += 1 }) {
            Text(text = "Pulsar")
        }
        Text(text = "He sido pulsado ${contador} veces")
    }
}
