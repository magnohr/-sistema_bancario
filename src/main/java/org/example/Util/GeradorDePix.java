package org.example.Util;

import java.util.Random;

public class GeradorDePix {

    private static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    // Gera um código PIX aleatório (ex: 25 caracteres alfanuméricos)
    public static String gerarCodigoPix() {
        Random random = new Random();
        StringBuilder codigo = new StringBuilder();

        for (int i = 0; i < 25; i++) {
            codigo.append(CHARS.charAt(random.nextInt(CHARS.length())));
        }
        return codigo.toString();
    }

    // Valida se o código PIX tem tamanho e caracteres válidos
    public static boolean validarCodigoPix(String codigo) {
        if (codigo == null || codigo.length() != 25) {
            return false;
        }
        return codigo.matches("[A-Z0-9]{25}");
    }

    // Exemplo de uso
    public static void main(String[] args) {
        String pix = gerarCodigoPix();
        System.out.println("Código PIX gerado: " + pix);
        System.out.println("Código válido? " + validarCodigoPix(pix));
    }
}
