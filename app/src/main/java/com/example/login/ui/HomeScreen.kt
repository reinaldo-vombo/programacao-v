package com.example.login.ui

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import com.example.login.data.api.RetrofitInstance
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.MediaType.Companion.toMediaTypeOrNull

@Composable
fun HomeScreen(onLogout: () -> Unit) {
    onLogout: () -> Unit,
    onReciboValidado: (ValidacaoResponse) -> Unit

    var selectedFile by remember { mutableStateOf<Uri?>(null) }
    var message by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        selectedFile = uri
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text("Validador de Recibos", style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(24.dp))

        Button(onClick = { launcher.launch("application/pdf") }) {
            Text("Selecionar PDF")
        }

        if (selectedFile != null) {
            Spacer(Modifier.height(8.dp))
            Text("PDF selecionado ✔")
        }

        Spacer(Modifier.height(16.dp))

        Button(
            enabled = selectedFile != null,
            onClick = {
                message = "Enviando..."
                val resposta = uploadPdf(selectedFile!!, context)

                if (resposta != null && resposta.STATUS == 200) {
                onReciboValidado(resposta)
            } else {
                message = "Recibo inválido ou erro no servidor"
            }
            }
        ) {
            Text("Enviar para validação")
        }

        if (message.isNotEmpty()) {
            Spacer(Modifier.height(16.dp))
            Text(message)
        }

        Spacer(Modifier.height(32.dp))

        TextButton(onClick = onLogout) {
            Text("Sair")
        }
    }
}
