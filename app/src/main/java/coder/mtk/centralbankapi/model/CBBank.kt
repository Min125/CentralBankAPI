package coder.mtk.centralbankapi.model

data class CBBank(
    val description: String,
    val info: String,
    val rates: Rates,
    val timestamp: Int
)