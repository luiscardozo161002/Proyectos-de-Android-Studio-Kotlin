package com.tesji.prestaciones_luis.model

class CalcularPrestaciones {
    var nombre: String? = null
    var anosident = 0
    var pagoHora = 0.0
    var mesenero = 0
    var mesfebrero = 0
    var mesmarzo = 0
    var mesabril = 0
    var mesmayo = 0
    var mesjunio = 0
    var mesjulio = 0
    var mesagosto = 0
    var meseptiembre = 0
    var mesoctubre = 0
    var mesnoviembre = 0
    var mesdiciembre = 0

    fun calcularVenta(): String {
        // años calendario
        var en = 31
        var feb = 28
        var mar = 31
        var abr = 30
        var may = 31
        var jun = 30
        var jul =31
        var ago = 31
        var sep = 30
        var oct = 31
        var nov = 30
        var dic = 31
        var diasd = 365

        if ((anosident % 4 == 0 && anosident % 100 != 0) || anosident % 400 == 0){
            feb = 29
            diasd = 366
        }
        var totalds = diasd-(mesenero+mesfebrero+mesmarzo+mesabril+mesmayo+mesjunio+mesjulio+mesagosto+meseptiembre+mesoctubre+mesnoviembre+mesdiciembre)

        //pago por el aguinaldo
        var aguinaldo = 0.0
        aguinaldo=((totalds * 4.5*10) / diasd)*pagoHora
        var gratificacion = 0.0
        if (mesenero == 0){
            gratificacion = gratificacion + ((5.8 / 100) * (en * pagoHora) + (en * pagoHora));
        }
        if (mesfebrero == 0){
            gratificacion = gratificacion + ((5.8 / 100) * (feb * pagoHora) + (feb * pagoHora));
        }
        if (mesmarzo == 0){
            gratificacion = gratificacion + ((5.8 / 100) * (mar * pagoHora) + (mar * pagoHora));
        }
        if (mesabril == 0){
            gratificacion = gratificacion + ((5.8 / 100) * (abr * pagoHora) + (abr * pagoHora));
        }
        if (mesmayo == 0){
            gratificacion = gratificacion + ((5.8 / 100) * (may * pagoHora) + (may * pagoHora));
        }
        if (mesjunio == 0){
            gratificacion = gratificacion + ((5.8 / 100) * (jun * pagoHora) + (jun * pagoHora));
        }
        if (mesjulio == 0){
            gratificacion = gratificacion + ((5.8 / 100) * (jul * pagoHora) + (jul * pagoHora));
        }
        if (mesagosto == 0){
            gratificacion = gratificacion + ((5.8 / 100) * (ago * pagoHora) + (ago * pagoHora));
        }
        if (meseptiembre == 0){
            gratificacion = gratificacion + ((5.8 / 100) * (sep * pagoHora) + (sep * pagoHora));
        }
        if (mesoctubre == 0){
            gratificacion = gratificacion + ((5.8 / 100) * (oct * pagoHora) + (oct * pagoHora));
        }
        if (mesnoviembre == 0){
            gratificacion = gratificacion + ((5.8 / 100) * (nov * pagoHora) + (nov * pagoHora));
        }
        if (mesdiciembre == 0){
            gratificacion = gratificacion + ((5.8 / 100) * (dic * pagoHora) + (dic * pagoHora));
        }

        var primavacacional = 0.0
        if (mesenero == 0){
            primavacacional = primavacacional + ((7.3 / 100) * (en * pagoHora) + (en * pagoHora));
        }
        if (mesfebrero == 0){
            primavacacional = primavacacional + ((7.3 / 100) * (feb * pagoHora) + (feb * pagoHora));
        }
        if (mesmarzo == 0){
            primavacacional = primavacacional + ((7.3 / 100) * (mar * pagoHora) + (mar * pagoHora));
        }
        if (mesabril == 0){
            primavacacional = primavacacional + ((7.3 / 100) * (abr * pagoHora) + (abr * pagoHora));
        }
        if (mesmayo == 0){
            primavacacional = primavacacional + ((7.3 / 100) * (may * pagoHora) + (may * pagoHora));
        }
        if (mesjunio == 0){
            primavacacional = primavacacional + ((7.3 / 100) * (jun * pagoHora) + (jun * pagoHora));
        }
        if (mesjulio == 0){
            primavacacional = primavacacional + ((7.3 / 100) * (jul * pagoHora) + (jul * pagoHora));
        }
        if (mesagosto == 0){
            primavacacional = primavacacional + ((7.3 / 100) * (ago * pagoHora) + (ago * pagoHora));
        }
        if (meseptiembre == 0){
            primavacacional = primavacacional + ((7.3 / 100) * (sep * pagoHora) + (sep * pagoHora));
        }
        if (mesoctubre == 0){
            primavacacional = primavacacional + ((7.3 / 100) * (oct * pagoHora) + (oct * pagoHora));
        }
        if (mesnoviembre == 0){
            primavacacional = primavacacional + ((7.3 / 100) * (nov * pagoHora) + (nov * pagoHora));
        }
        if (mesdiciembre == 0){
            primavacacional = primavacacional + ((7.3 / 100) * (dic * pagoHora) + (dic * pagoHora));
        }

        var sumtotal =  aguinaldo+gratificacion+primavacacional
        return """
        Cliente: $nombre 
        Días Trabajados: $totalds
        Aguinaldo: ${"$"}$aguinaldo
        Prima vacacional: ${"$"}$gratificacion
        Gratificación: ${"$"}$primavacacional
        Total Prestaciones: ${"$"}$sumtotal
        Año Bisiesto: ${if ((anosident % 4 == 0 && anosident % 100 != 0) || anosident % 400 == 0) "Sí" else "No"}
        """.trimIndent()


    }
}