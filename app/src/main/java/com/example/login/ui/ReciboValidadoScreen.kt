package com.example.login.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.login.data.model.ValidacaoResponse

@Composable
fun ReciboValidadoScreen(
    recibo: ValidacaoResponse,
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text(
            text = "✅ Recibo Validado",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(Modifier.height(16.dp))

        Text("Aplicativo: ${recibo.APLICATIVO}")
        Text("Tipo: ${recibo.TIPO}")
        Text("Transação: ${recibo.TRANSACAO}")
        Text("Montante: ${recibo.MONTANTE}")
        Text("Beneficiário: ${recibo.B_NOME}")
        Text("IBAN Beneficiário: ${recibo.B_IBAN}")
        Text("Banco Beneficiário: ${recibo.B_BANCO}")
        Text("Ordenante: ${recibo.O_NOME}")
        Text("IBAN Ordenante: ${recibo.O_IBAN}")
        Text("Banco Ordenante: ${recibo.O_BANCO}")
        Text("Data: ${recibo.DATA.dataHora}")

        Spacer(Modifier.height(24.dp))

        Button(onClick = onBack) {
            Text("Voltar")
        }
    }
}
