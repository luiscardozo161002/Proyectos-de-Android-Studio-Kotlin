package com.kube.practica1_alexandermartinez.model

class CalcularPrestaciones {
    var nombre: String? = null
    var sueldo = 0.0
    var anio = 0
    var meses = 0.0
    var dias = 0.0
    var anio2 = 0
    fun calcularPrestacion(): String {
        var diaspres: Double
        var pres: Double
        var porgrati: Double
        var porvac: Double
        var grati: Double
        var vac: Double
        val total: Double

        var respuesta: String

        dias = anio2 - dias
        diaspres = (dias * 45) / anio2
        pres = diaspres * sueldo
        porgrati = pres * 0.073
        porvac = pres * 0.058
        grati = porgrati * meses
        vac = porvac * meses
        total =  grati +  vac + pres

        if (anio2 == 366){
            respuesta = """
               Cliente: $nombre
               Año actual: $anio
               El Año Es visiesto
               Dias de prestacion: $diaspres
               Gratificacion: ${"$"}$grati
               vacaciones: ${"$"}$vac
               Prestaciones: ${"$"}$total
               """
        }else {
            respuesta = """
               Cliente: $nombre
               Año actual: $anio
               El Año no es visiesto
               Dias de prestacion: $diaspres
               Gratificacion: ${"$"}$grati
               vacaciones: ${"$"}$vac
               Prestaciones: ${"$"}$total
               """
        }
        return respuesta
    }
}