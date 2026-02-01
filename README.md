# 📱 Validador de Recibos – BAI Directo & Multicaixa Express

## 📌 Sobre o Aplicativo

O **Validador de Recibos** é um aplicativo Android desenvolvido em **Kotlin com Jetpack Compose** cujo objetivo principal é validar comprovativos/recibos de transações bancárias gerados pelo **BAI Directo** e **Multicaixa Express** utilizando a api **https://comprovativos.sudomakes.com/**.

O utilizador apenas precisa de:

1. Abrir o aplicativo
2. Selecionar um ficheiro PDF (recibo)
3. Enviar para validação

O app faz o upload do PDF para a API:

A API processa o recibo e retorna um JSON com os detalhes da transação.  
Caso o recibo seja **válido**, o aplicativo apresenta uma mensagem de confirmação e/ou uma tela de resultado com os dados principais do recibo.

**Resposta do servidor**

`{
  "APLICATIVO": "MULTICAIXA EXPRESS",
  "STATUS": 200,
  "LOG": "MULTICAIXA EXPRESS",
  "B_IBAN": "...",
  "B_NOME": "...",
  "MONTANTE": "52.000,00"
}
`

---

## ✅ Funcionalidades Principais

- Tela Splash (inicial)
- Login (simulado/mock, apenas para teste)
- Home com seleção de ficheiro PDF
- Envio do PDF para API via Retrofit
- Tratamento da resposta JSON
- Exibição do resultado da validação
- Logout para voltar à tela de login

---

## 📂 Estrutura do Projeto e Explicação dos Ficheiros

Abaixo está a explicação do papel de cada ficheiro principal que criámos:

### **1. MainActivity.kt**

Responsável por:

- Iniciar o aplicativo
- Definir a navegação entre telas (Splash → Login → Home)
- Controlar o estado de autenticação do utilizador

Basicamente, é o ponto de entrada do app.

---

### **2. SplashScreen.kt**

Tela inicial do aplicativo.

Faz:

- Exibe o logo/nome do app
- Aguarda alguns segundos
- Redireciona automaticamente para a tela de Login

Serve para dar uma experiência mais profissional ao app.

---

### **3. LoginScreen.kt**

Tela de login (mock/simulação).

Faz:

- Permite inserir email e senha (apenas visualmente)
- Possui um botão “Entrar” que leva para a Home
- (Não conecta com backend real, apenas para teste)

Mais tarde, podes integrar um login real se quiseres.

---

### **4. HomeScreen.kt**

Tela principal do aplicativo.

Aqui o utilizador pode:

- Selecionar um ficheiro PDF
- Ver se o ficheiro foi selecionado
- Clicar em “Enviar para validação”
- Ver o status da validação (Enviando…, Sucesso, Erro, etc.)
- Fazer logout e voltar ao Login

Também é aqui que chamamos a função `uploadPdf()`.

---

### **5. ApiService.kt**

Interface Retrofit que define a comunicação com a API.

Contém algo como:

```kotlin
@Multipart
@POST("validar/")
suspend fun validarRecibo(
    @Part file: MultipartBody.Part
): Response<ReciboResponse>
```
