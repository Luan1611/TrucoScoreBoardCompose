package br.edu.ifsp.scl.sc3029531.trucoscoreboardcompose

import android.content.Context
import android.os.Bundle
import android.widget.Toast
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
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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

    val context = LocalContext.current
    var pontuacaoEquipeA by remember { mutableIntStateOf(0) }
    var pontuacaoEquipeB by remember { mutableIntStateOf(0)}

    BuildToastElevenHand(context = context, pontuacaoEquipe = pontuacaoEquipeA, nomeEquipe = "A")
    BuildToastElevenHand(context = context, pontuacaoEquipe = pontuacaoEquipeB, nomeEquipe = "B")

    if (pontuacaoEquipeA > 11) {
        BuildWinnerScreenAlert("A") {
            pontuacaoEquipeA = 0
            pontuacaoEquipeB = 0
        }
    }

    if (pontuacaoEquipeB > 11) {
        BuildWinnerScreenAlert("B") {
            pontuacaoEquipeA = 0
            pontuacaoEquipeB = 0
        }
    }

    Column(modifier = modifierParametro.fillMaxSize(),) {
        Row(
            modifier = modifierParametro.fillMaxSize().weight(5f),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(modifier = Modifier
                .fillMaxHeight()
                .weight(1f)) {

                BuildMainContentDesign("Equipe A", pontuacaoEquipeA, fun() {
                    pontuacaoEquipeA++}, fun() {pontuacaoEquipeA+=3} )
            }
            Column(modifier = Modifier
                .fillMaxHeight()
                .weight(1f)) {

                BuildMainContentDesign("Equipe B", pontuacaoEquipeB, fun() {
                pontuacaoEquipeB++}, fun() {pontuacaoEquipeB+=3} )
            }
        }

        Button(
            onClick = {
                pontuacaoEquipeA = 0
                pontuacaoEquipeB = 0
          },
            modifier = Modifier.fillMaxWidth().weight(1f)
        ) {
            Text(text = "Zerar placar")
        }
    }

}

@Composable
fun BuildToastElevenHand(context: Context, pontuacaoEquipe: Int, nomeEquipe: String) {
    LaunchedEffect(pontuacaoEquipe) {
        if (pontuacaoEquipe == 11) {
            Toast.makeText(
                context,
                "Equipe ${nomeEquipe} entrou na Mão de 11",
                Toast.LENGTH_LONG).show()
        }
    }

}

@Composable
fun BuildWinnerScreenAlert(nomeEquipe: String, onGameRestart: () -> Unit) {
    AlertDialog(
        onDismissRequest = {
            onGameRestart()
        },
        title = {Text("A Equipe ${nomeEquipe} Ganhou!")},
        text = {Text("Parabéns")},
        confirmButton = {
            Button(onClick = {
                onGameRestart()
            })
            {
                Text("Reiniciar partida")
            }
        }
    )

}

@Composable
fun BuildMainContentDesign(equipe: String, pontuacao: Int, onClickPlusOne: () -> Unit, onClickPlusThree: () -> Unit) {
    Text(
        text = equipe,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )
    Text(
        text = pontuacao.toString(),
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontSize = 48.sp
    )

    Text(text = "Pontos",
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )
    Button(
        onClick = { onClickPlusOne() },
        modifier = Modifier.fillMaxWidth(),
    ) {
        Text(text = "+ 1 ponto")

    }
    Button(
        onClick = { onClickPlusThree() },
        enabled = pontuacao < 11,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "+ 3 pontos")
    }
}

@Preview(showBackground = true)
@Composable
fun TrucoScoreBoardScreenPreview() {
    TrucoScoreBoardComposeTheme {
        TrucoScoreBoardScreen(modifierParametro = Modifier.fillMaxSize())
    }
}