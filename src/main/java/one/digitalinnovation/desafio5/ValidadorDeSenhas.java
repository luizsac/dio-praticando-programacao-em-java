package one.digitalinnovation.desafio5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidadorDeSenhas {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String senha;
        var contemNumero = false;
        var contemMaiuscula = false;
        var contemMinuscula = false;

        while ((senha = br.readLine()) != null) {

            if (senha.length() >= 6 && senha.length() <= 32 && senha.matches("^[A-z0-9]+$")) {
                // encontra letras maiúsculas
                Pattern pattern = Pattern.compile("[A-Z]");
                Matcher matcher = pattern.matcher(senha);
                contemMaiuscula = matcher.find();

                // encontra letras minúsculas
                pattern = Pattern.compile("[a-z]");
                matcher = pattern.matcher(senha);
                contemMinuscula = matcher.find();

                // encontra números
                pattern = Pattern.compile("[0-9]");
                matcher = pattern.matcher(senha);
                contemNumero = matcher.find();

                if (contemMaiuscula && contemMinuscula && contemNumero) {
                    System.out.println("Senha valida.");
                } else {
                    System.out.println("Senha invalida.");
                }
            } else {
                System.out.println("Senha invalida.");
            }
        }
    }
}