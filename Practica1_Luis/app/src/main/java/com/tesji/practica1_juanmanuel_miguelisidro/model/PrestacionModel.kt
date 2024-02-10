package com.tesji.practica1_juanmanuel_miguelisidro.model

class PrestacionModel {

    // Entrada de datos en el modelo
    var ano = 0
    var nombre: String? = null
    var salario = 0.0
    //meses
    var enero = 0
    var febrero = 0
    var marzo = 0
    var abril = 0
    var mayo = 0
    var junio = 0
    var julio = 0
    var agosto = 0
    var septiembre = 0
    var octubre = 0
    var noviembre = 0
    var diciembre = 0

    fun calcularPrestaciones(): String {

        //Variables para generar
        var sumaToriaMes:Int
        var mesesDias:Int
        var calcularAguinaldo:Double
        var calcularGratificacion:Double
        var primaVacacional:Double
        var totalPrestaciones:Double
        var total:Double

        if(ano % 4 == 0){

            var eneroModel = 31 - enero
            var febreroModel = 29 - febrero
            var marzoModel = 31 - marzo
            var abrilModel = 30 - abril
            var mayoModel = 31 - mayo
            var junioModel = 30 - junio
            var julioModel = 31 - julio
            var agostoModel = 31 - agosto
            var septiembreModel = 30 - septiembre
            var octubreModel = 31 - octubre
            var nomviebreModel = 30 - noviembre
            var diciembreModel = 31 - diciembre

            sumaToriaMes = eneroModel + febreroModel + marzoModel + abrilModel + mayoModel + junioModel
            + julioModel + agostoModel + septiembreModel + octubreModel + nomviebreModel + diciembreModel


            if (sumaToriaMes >= 366){

                mesesDias = sumaToriaMes/30
                calcularAguinaldo = ((salario*mesesDias)/366)*45
                calcularGratificacion= (salario*mesesDias)*0.073
                primaVacacional = (salario*mesesDias)*0.058
                totalPrestaciones = calcularAguinaldo + calcularGratificacion + primaVacacional
                total = salario + totalPrestaciones

            }else{

                mesesDias = sumaToriaMes/30
                calcularAguinaldo = ((salario*mesesDias)/365)*45
                calcularGratificacion= (salario*mesesDias)*0.073
                primaVacacional = (salario*mesesDias)*0.058
                totalPrestaciones = calcularAguinaldo + calcularGratificacion + primaVacacional
                total = salario + totalPrestaciones

            }

        }else{

            var eneroModel = 31 - enero
            var febreroModel = 28 - febrero
            var marzoModel = 31 - marzo
            var abrilModel = 30 - abril
            var mayoModel = 31 - mayo
            var junioModel = 30 - junio
            var julioModel = 31 - julio
            var agostoModel = 31 - agosto
            var septiembreModel = 30 - septiembre
            var octubreModel = 31 - octubre
            var nomviebreModel = 30 - noviembre
            var diciembreModel = 31 - diciembre

            sumaToriaMes = eneroModel + febreroModel + marzoModel + abrilModel + mayoModel + junioModel
            + julioModel + agostoModel + septiembreModel + octubreModel + nomviebreModel + diciembreModel

            if (sumaToriaMes >= 365){

                mesesDias = sumaToriaMes/30
                calcularAguinaldo = ((salario*mesesDias)/365)*45
                calcularGratificacion= (salario*mesesDias)*0.073
                primaVacacional = (salario*mesesDias)*0.058
                totalPrestaciones = calcularAguinaldo + calcularGratificacion + primaVacacional
                total = salario + totalPrestaciones


            }else{

                mesesDias = sumaToriaMes/30
                calcularAguinaldo = ((salario*mesesDias)/365)*45
                calcularGratificacion= (salario*mesesDias)*0.073
                primaVacacional = (salario*mesesDias)*0.058
                totalPrestaciones = calcularAguinaldo + calcularGratificacion + primaVacacional
                total = salario + totalPrestaciones

            }

        }

        return """
            Nombre : $nombre
            El Aguinaldo : ${"$"}$calcularAguinaldo
            La Gratificacion : ${"$"}$calcularGratificacion
            Prima Vacacional : ${"$"}$primaVacacional
            Total de Prestaciones: ${"$"}$totalPrestaciones 
            Pago Total: ${"$"}$total
               """.trimIndent()

    }
}