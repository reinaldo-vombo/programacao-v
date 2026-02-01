suspend fun uploadPdf(
    uri: Uri,
    context: Context
): ValidacaoResponse? {
    return try {
        val inputStream = context.contentResolver.openInputStream(uri)
        val bytes = inputStream?.readBytes() ?: return null

        val requestBody = bytes.toRequestBody("application/pdf".toMediaTypeOrNull())

        val part = MultipartBody.Part.createFormData(
            name = "file",
            filename = "recibo.pdf",
            body = requestBody
        )

        RetrofitInstance.api.uploadPdf(part)

    } catch (e: Exception) {
        null
    }
}
