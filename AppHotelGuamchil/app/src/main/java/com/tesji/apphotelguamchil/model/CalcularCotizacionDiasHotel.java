package com.tesji.apphotelguamchil.model;

public class CalcularCotizacionDiasHotel {

    private int numeroDias;
    private double precioHabitacionDia;


    public int getNumeroDias() {
        return numeroDias;
    }

    public void setNumeroDias(int numeroDias) {
        this.numeroDias = numeroDias;
    }

    public double getPrecioHabitacionDia() {
        return precioHabitacionDia;
    }

    public void setPrecioHabitacionDia(double precioHabitacionDia) {
        this.precioHabitacionDia = precioHabitacionDia;
    }


    public String CalcularCotizacionDiasHotel() {
        /*
        En el hotel Guamúchil se hace un descuento del 10%
        si el cliente se hospeda más de 5 días, del 15% si
        se hospeda más de 10 días y del 20% si se hospeda más
        de 15 días. Elaborar un algoritmo que lea el número de
        días y el precio diario de la habitación e imprima el
        subtotal a pagar, el descuento y el total a pagar.
        */

        double pagoPorDias, aplicandoDescuento, pagoAplicandoDescuento;
        String mensajeErrorDiasInvalidos = "Ingrese días válidos";
        String mensajeErrorPagoInvalido = "Ingrese un pago válido";
        String mensajeErrorPagoYDiasInv = "Ingrese un pago y días válidos";
        if (numeroDias >= 1 && precioHabitacionDia > 0) {
            pagoPorDias = precioHabitacionDia * numeroDias;

            if (numeroDias <= 5) {
                aplicandoDescuento = 0; // No hay descuento
            } else if (numeroDias <= 10) {
                aplicandoDescuento = pagoPorDias * 0.10; // Descuento del 10%
            } else if (numeroDias <= 15) {
                aplicandoDescuento = pagoPorDias * 0.15; // Descuento del 15%
            } else {
                aplicandoDescuento = pagoPorDias * 0.20; // Descuento del 20%
            }

            pagoAplicandoDescuento = pagoPorDias - aplicandoDescuento;

            return "No. Días: " + numeroDias
                    + "\nPrecio Habitación: " + precioHabitacionDia
                    + "\nSubtotal: " + pagoPorDias
                    + "\nDescuento: " + aplicandoDescuento
                    + "\nTotal: " + pagoAplicandoDescuento;

        } else if (precioHabitacionDia == 0 && numeroDias == 0) {
            return "Error: " + mensajeErrorPagoYDiasInv;
        } else if(precioHabitacionDia == 0){
            return "Error: " + mensajeErrorPagoInvalido;
        } else if (numeroDias == 0) {
            return "Error: " + mensajeErrorDiasInvalidos;
        }else{
            return "Error";
        }
    }
}
