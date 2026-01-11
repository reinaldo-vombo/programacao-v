val scope = rememberCoroutineScope()

Button(onClick = {
    scope.launch {
        try {
            val response = RetrofitInstance.api.register(
                RegisterRequest(email, password)
            )

            if (response.token != null) {
                message = "Cadastro realizado com sucesso"
                onRegisterSuccess()
            } else {
                message = "Erro no cadastro"
            }

        } catch (e: Exception) {
            message = "Erro ao conectar com a API"
        }
    }
}) {
    Text("Cadastrar")
}
