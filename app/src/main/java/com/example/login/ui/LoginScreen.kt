val scope = rememberCoroutineScope()

Button(
    onClick = {
        scope.launch {
            try {
                val response = RetrofitInstance.api.login(
                    LoginRequest(email, password)
                )

                if (response.token != null) {
                    onLoginSuccess()
                } else {
                    error = "Login inválido"
                }

            } catch (e: Exception) {
                error = "Erro ao conectar com a API"
            }
        }
    },
    modifier = Modifier.fillMaxWidth()
) {
    Text("Entrar")
}
