package com.tesji.miprimeraappenkotlin.model

class TerrenoModel {
    var nombre: String? = null
    var medidaAncho = 0.0
    var medidaLargo = 0.0
    var precioMetro = 0.0
    fun calcularVenta(): String {
        val total: Double
        total = medidaLargo * medidaAncho * precioMetro
        return """
               Cliente: $nombre
               Precio del Terreno: $total
               """.trimIndent()
    }
}