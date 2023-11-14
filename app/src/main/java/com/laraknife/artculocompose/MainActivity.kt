package com.laraknife.artculocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.laraknife.artculocompose.ui.theme.ArtículoComposeTheme

class MainActivity : ComponentActivity() {

    /*
    Hecho por Brayan Josue Hernández Lara (LaraKnife)
    Domingo 19 de Noviembre de 2023
    Número de control: 192T0220
    Materia: Desarrollo de aplicaciones móviles
    Ingeniería en Sistemas Computacionales
    Noveno Semestre
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtículoComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LlenarArticulo()
                }
            }
        }
    }
}

@Composable
private fun LlenarArticulo () {
    Articulo(
        titulo = stringResource(R.string.titulo),
        descripcion = stringResource(R.string.descripcion),
        parrafo = stringResource(R.string.parrafo),
        imagen = painterResource(R.drawable.bg_compose_background)
    )
}

@Composable
private fun Articulo(modifier: Modifier = Modifier, imagen: Painter, titulo: String, descripcion: String, parrafo: String){
    Column(modifier = modifier) {
        Image(
            painter = imagen,
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        Text(
            text = titulo,
            modifier = Modifier.padding(16.dp),
            fontSize = 24.sp
        )
        Text(
            text = descripcion,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = parrafo,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun ArticuloPreview() {
    ArtículoComposeTheme {
        LlenarArticulo()
    }
}