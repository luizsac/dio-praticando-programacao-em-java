package one.digitalinnovation.desafio4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EntrevistaEmbaracosa {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String palavra;

        while ((palavra = br.readLine()) != null) {
            var existeRepeticao = false;
            for (int i = 0; i < palavra.length(); i++) {
                if (palavra.substring(0, i).endsWith(palavra.substring(i))) {
                    System.out.println(palavra.substring(0, i));
                    existeRepeticao = true;
                }
            }
            if (!existeRepeticao) {
                System.out.println(palavra);
            }
        }
    }
}
