package com.tesji.appsegurodeautos;

public class CalcularSeguroAutosModel {
    public double calculateInsuranceCost(String tipoPoliza, String bebeAlcohol, String usaLentes, String padeceEnfermedad, String mayor40Anios) {
        double cuotaBase = (tipoPoliza.equals("Cobertura Amplia")) ? 1200.0 : 950.0;
        double costoFinal = cuotaBase;

        if (bebeAlcohol.equals("Si")) {
            costoFinal += cuotaBase * 0.10;
        }

        if (usaLentes.equals("Si")) {
            costoFinal += cuotaBase * 0.05;
        }

        if (!padeceEnfermedad.equals("No Padezco")) {
            costoFinal += cuotaBase * 0.05;
        }

        if (mayor40Anios.equals("Si")) {
            costoFinal += cuotaBase * 0.20;
        } else {
            costoFinal += cuotaBase * 0.10;
        }

        return costoFinal;
    }

    public boolean validateInputs(String tipoPoliza, String bebeAlcohol, String usaLentes, String padeceEnfermedad, String mayor40Anios) {
        return !tipoPoliza.equals("-Seleccione-") && !bebeAlcohol.equals("-Seleccione-") && !usaLentes.equals("-Seleccione-") &&
                !padeceEnfermedad.equals("-Seleccione-") && !mayor40Anios.equals("-Seleccione-");
    }
}
