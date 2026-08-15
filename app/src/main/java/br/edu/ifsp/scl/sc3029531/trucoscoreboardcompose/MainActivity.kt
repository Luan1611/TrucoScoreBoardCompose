package br.edu.ifsp.scl.sc3029531.trucoscoreboardcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import br.edu.ifsp.scl.sc3029531.trucoscoreboardcompose.ui.theme.TrucoScoreBoardComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TrucoScoreBoardComposeTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    TrucoScoreBoardScreen(
                        modifierParametro = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun TrucoScoreBoardScreen(modifierParametro: Modifier = Modifier) {
    Column(modifier = modifierParametro.fillMaxSize(),) {
        Row(
            modifier = modifierParametro.fillMaxSize().weight(5f),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(modifier = Modifier
                .fillMaxHeight()
                .weight(1f)) {
                Text(text = "Equipe A", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
                Text(text = "0", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 48.sp)
                Text(text = "Pontos", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
                Button(
                    onClick = { },
                    modifier = Modifier.fillMaxWidth(),
//                enabled = TODO(),
//                shape = TODO(),
//                colors = TODO(),
//                elevation = TODO(),
//                border = TODO(),
//                contentPadding = TODO(),
//                interactionSource = TODO()
                ) {
                    Text(text = "+ 1 ponto")
                }
                Button(
                    onClick = { },
                    modifier = Modifier.fillMaxWidth()
//                enabled = TODO(),
//                shape = TODO(),
//                colors = TODO(),
//                elevation = TODO(),
//                border = TODO(),
//                contentPadding = TODO(),
//                interactionSource = TODO()
                ) {
                    Text(text = "+ 3 pontos")
                }
            }
            Column(modifier = Modifier
                .fillMaxHeight()
                .weight(1f)) {
                Text(text = "Equipe B", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
                Text(text = "0", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 48.sp)
                Text(text = "Pontos", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
                Button(
                    onClick = { },
                    modifier = Modifier.fillMaxWidth(),
//                enabled = TODO(),
//                shape = TODO(),
//                colors = TODO(),
//                elevation = TODO(),
//                border = TODO(),
//                contentPadding = TODO(),
//                interactionSource = TODO()
                ) {
                    Text(text = "+ 1 ponto")
                }
                Button(
                    onClick = { },
                    modifier = Modifier.fillMaxWidth()
//                enabled = TODO(),
//                shape = TODO(),
//                colors = TODO(),
//                elevation = TODO(),
//                border = TODO(),
//                contentPadding = TODO(),
//                interactionSource = TODO()) { }
                ) {
                    Text(text = "+ 3 pontos")
                }
            }
        }

        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth().weight(1f)
//                enabled = TODO(),
//                shape = TODO(),
//                colors = TODO(),
//                elevation = TODO(),
//                border = TODO(),
//                contentPadding = TODO(),
//                interactionSource = TODO()
        ) {
            Text(text = "Zerar placar")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun TrucoScoreBoardScreenPreview() {
    TrucoScoreBoardComposeTheme {
        TrucoScoreBoardScreen(modifierParametro = Modifier.fillMaxSize())
    }
}