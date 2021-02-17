package util;

public class Validadores {
    /**
     * Valida formato do campo data brasileira exemplo 'DD/MM/YYYY'
     *
     * @param data - informar valor tipo data
     */
    public static boolean validarFormatoData(String data){
        return data.matches("^(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/([12][0-9]{3})$");
    }

    /**
     * Valida formato do campo valor em reais brasileiro exemplo 'R$99,99'
     *
     * @param valor - informar valor tipo reais
     */
    public static boolean validarFormatoMonetario(String valor){
        return valor.matches("R\\$\\d{1,},\\d{2}");
    }

    /**
     * Valida formato do campo hora exemplo '14:00'
     *
     * @param hora - informar HH:mm
     */
    public static boolean validarFormatoHora(String hora){
        return hora.matches("^([0-1][0-9]|[2][0-3]):[0-5][0-9]$");
    }
}