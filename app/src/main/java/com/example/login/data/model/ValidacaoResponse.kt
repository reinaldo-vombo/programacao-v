package com.example.login.data.model

data class ValidacaoResponse(
    val APLICATIVO: String,
    val STATUS: Int,
    val LOG: String,
    val B_IBAN: String,
    val B_NOME: String,
    val O_IBAN: String,
    val O_NOME: String,
    val B_BANCO: String,
    val O_BANCO: String,
    val MONTANTE: String,
    val DINHEIRO: Double,
    val TRANSACAO: String,
    val TIPO: String,
    val DATA: DataRecibo
)

data class DataRecibo(
    val data: String,
    val tempo: String,
    val dataHora: String,
    val dia: Int,
    val mes: Int,
    val ano: Int,
    val hora: Int,
    val minuto: Int,
    val segundo: Int
)
