package com.example.jetpackcomposetutorial

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.runtime.remember
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //MiBotonComponente()
            ButtonText()
        }
    }
}

@Preview(showBackground = true, widthDp = 200, heightDp = 100)
@Composable
fun ButtonText() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            // text = stringResource(id = R.string.nombre)
            // maxLines = 1
            // overflow = TextOverflow.Ellipsis

            text = "Hello World",
            modifier = Modifier
                .clickable { /*TODO*/ }
                .background(Color.Cyan)
                .border(width = 2.dp, color = Color.Blue)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            style = MaterialTheme.typography.bodyLarge.copy(
            shadow = Shadow(
                offset = Offset(7f, 7f),
                blurRadius = 5f,
                color = Color.Black.copy(alpha = 0.5f)

                )
            )
        )
    }
}

/*@Preview(
    showBackground = true,
    name = "Android Preview",
    widthDp = 200,
    heightDp = 200
)*/
@Composable
fun PreviewMiBotonComponente() {
    MiBotonComponente()
}

@Composable
fun MiBotonComponente() {
    val miArray = remember { Array(5) { 0 } }
    val contador = remember { mutableIntStateOf(0) }
    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = {
            if (contador.value < 5) {
                miArray[contador.value] = contador.value + 1
                contador.value += 1
                Toast.makeText(context, "Has presionado el botón: ${contador.value} veces.", Toast.LENGTH_SHORT).show()
            } else {
                val contenidoArray = miArray.joinToString(", ")
                Toast.makeText(
                    context,
                    "Máximo número alcanzado. Contenido del array: $contenidoArray",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }) {
            Text(text = "Contador")
        }
    }
}
