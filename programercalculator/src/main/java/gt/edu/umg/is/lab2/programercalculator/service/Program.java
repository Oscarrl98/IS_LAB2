package gt.edu.umg.is.lab2.programercalculator.service;

import gt.edu.umg.is.lab2.programercalculator.model.OperationModel;
import org.springframework.stereotype.Service;

@Service
public class Program {
    public boolean isbinary(OperationModel model){
        boolean esBinario = true;
        int aux = model.getA();
        int digito;
        while (aux != 0) {
            digito = aux % 10;
            if (digito != 0 && digito != 1) {
                esBinario = false;
            }
            aux = aux / 10;
        }
        return esBinario;
    }
    public static boolean validarHexadecimal(String hexadecimal) {
        String caracteresHexadecimales = "0123456789ABCDEF";
        for (int i = 0; i < hexadecimal.length(); i++) {
            char caracter = hexadecimal.charAt(i);
            if (caracteresHexadecimales.indexOf(caracter) == -1) {
                return false;
            }
        }
        return true;
    }

    public static boolean validarOctal(int octal) {
        String octalComoCadena = String.valueOf(octal);
        String caracteresOctales = "01234567";
        for (int i = 0; i < octalComoCadena.length(); i++) {
            char caracter = octalComoCadena.charAt(i);
            if (caracteresOctales.indexOf(caracter) == -1) {
                return false;
            }
        }
        return true;
    }
    public int binaryToDecimal(OperationModel model){
        int digito, decimal, numero = model.getA();
        int exponente;
        exponente = 0;
         decimal = 0;
        while (numero != 0) {
            digito = numero % 10;
            decimal = decimal + digito * (int) Math.pow(2, exponente);
            exponente++;
            numero = numero / 10;
        }
        return decimal;
    }

    public String binaryToOctal(OperationModel model){
        OperationModel mod = new OperationModel();
        mod.setB(binaryToDecimal(model));
        String octal = decimalToOct(mod);
        return octal;
    }

    public String binaryToHex(OperationModel model){
        OperationModel mod = new OperationModel();
        mod.setB(binaryToDecimal(model));
        String octal = decimalToHex(mod);
        return octal;
    }


    public String decimalToBin(OperationModel model){
        int decimal = model.getB();
        String binario = "";
        while (decimal > 0) {
            binario = decimal % 2 + binario;
            decimal = decimal / 2;
        }
        return binario;
    }

    public String decimalToOct(OperationModel model){
        int decimal = model.getB();
        int residuo;
        String octal = "";
        char[] caracteresOctales = {'0', '1', '2', '3', '4', '5', '6', '7'};
        while (decimal > 0) {
            residuo = decimal % 8;
            char caracter = caracteresOctales[residuo];
            octal = caracter + octal;
            decimal = decimal / 8;
        }
        return octal;
    }

    public String decimalToHex(OperationModel model){
        int decimal = model.getB();
        int residuo;
        String hexadecimal = "";
        char[] caracteresHexadecimales = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        while (decimal > 0) {
            residuo = decimal % 16;
            char caracterHexadecimal = caracteresHexadecimales[residuo];
            hexadecimal = caracterHexadecimal + hexadecimal;
            decimal = decimal / 16;
        }
        return hexadecimal;
    }

    public int octalToDecimal(OperationModel model){
        int octal = model.getC();
        int decimal = 0;
        int potencia = 0;
        // Ciclo infinito que se rompe cuando octal es 0
        while (true) {
            if (octal == 0) {
                break;
            } else {
                int temp = octal % 10;
                decimal += temp * Math.pow(8, potencia);
                octal = octal / 10;
                potencia++;
            }
        }
        return decimal;
    }

    public String octalToBinary(OperationModel model){
        OperationModel mod = new OperationModel();
        mod.setB(octalToDecimal(model));
        String binary = decimalToBin(mod);
        return binary;
    }

    public String octalToHex(OperationModel model){
        OperationModel mod = new OperationModel();
        mod.setB(octalToDecimal(model));
        String hex = decimalToHex(mod);
        return hex;
    }


    public String hexToBinary(OperationModel model){
        OperationModel mod = new OperationModel();
        mod.setB(hexToDecimal(model));
        String bin = decimalToBin(mod);
        return bin;
    }

    public String hexToOctal(OperationModel model){
        OperationModel mod = new OperationModel();
        mod.setB(hexToDecimal(model));
        String oct = decimalToOct(mod);
        return oct;
    }

    public int hexToDecimal(OperationModel model){
        System.out.println(model.getB());
        System.out.println(model.getA());
        System.out.println(model.getC());
        System.out.println(model.getH());
        String hexadecimal = model.getH();
        String caracteresHexadecimales = "0123456789ABCDEF";
        hexadecimal = hexadecimal.toUpperCase();
        int decimal = 0;
        for (int i = 0; i < hexadecimal.length(); i++) {
            char caracter = hexadecimal.charAt(i);
            int posicionEnCaracteres = caracteresHexadecimales.indexOf(caracter);
            decimal = 16 * decimal + posicionEnCaracteres;
        }
        return decimal;
    }
}
