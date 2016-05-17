/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viveiro;

/**
 *
 * @author Walas Jhony
 */
public class Verifica {

    private Verifica() { }

    public static boolean validaSenha(char[] s1, char[] s2) {
        for (int i = 0; i < s1.length; i++) {
            if (s1[i] != s2[i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean verificaPadrao(int[] cpf) {
        String c = "";
        for (int i = 0; i < cpf.length; i++) {
            c += "" + cpf[i];
        }
        if (c.equals("00000000000")
                || c.equals("11111111111")
                || c.equals("22222222222")
                || c.equals("33333333333")
                || c.equals("44444444444")
                || c.equals("55555555555")
                || c.equals("66666666666")
                || c.equals("77777777777")
                || c.equals("88888888888")
                || c.equals("99999999999")) {
            return false;
        }
        return true;
    }

    private static boolean validar(int[] cpf) {

        if (!verificaPadrao(cpf)) {
            return false;
        }
        int soma = 0, resto, j = 0, i;

        for (i = 0; i < 9; i++) {
            soma += ((10 - i) * cpf[i]); //Acumula o somatorio para o calculo do primeiro digito verificador
        }

        resto = 11 - (soma % 11); //Calcula o primeiro digito verificador
        //System.out.println(resto);
        if ((resto == 11 || resto == 10)) { //Corrige o primeiro digito verificador
            resto = 0; //Corrige o primeiro digito verificador
        }

        if (resto != cpf[9]) {
            return false;
        }

        soma = 0;
        for (i = 0; i < 10; i++) {
            soma += ((11 - i) * cpf[i]); //Calcula o segundo digito verificador
        }

        resto = 11 - (soma % 11); //Calcula o segundo digito verificador
        //System.out.println(resto);
        if (resto == 11 || resto == 10) {
            resto = 0; //Corrige o segundo digito verificador
        }

        if (resto != cpf[10]) {
            return false;
        }

        return true;
    }

    /**
     *
     * @param cpf Vetor de caracteres do tipo '000.000.000-00'.
     * @return
     */
    public static boolean validaCPF(char[] cpf) {

        int i, j = 0;
        int[] dg = new int[11];
        for (i = 0; i < 14; i++) { //Coloca os digitos do vetor de carater em um vetor de inteiro
            if ((i != 3) && (i != 7) && (i != 11)) { //Tira os carateres "." e "-";
                dg[j] = Integer.parseInt(String.valueOf(cpf[i])); //Converte um char para inteiro
                j++;
            }
        }

        return validar(dg);
    }

    /**
     *
     * @param cpf - String do tipo '000.000.000-00'
     * @return
     */
    public static boolean validaCPF(String cpf) {

        int i, j = 0;
        int[] dg = new int[11];
        for (i = 0; i < 14; i++) { //Coloca os digitos do vetor de carater em um vetor de inteiro
            if ((i != 3) && (i != 7) && (i != 11)) { //Tira os carateres "." e "-";
                dg[j] = Integer.parseInt(cpf.substring(i, i + 1)); //Converte um char para inteiro
                j++;
            }
        }

        return validar(dg);
    }
}