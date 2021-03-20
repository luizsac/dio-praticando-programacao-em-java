package one.digitalinnovation.desafio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        String str1, str2, max, min; // primeira string, segunda string, maior string, menor string
        while ((str1 = in.readLine()) != null) {
               str2 = in.readLine();
            if (str1.length() > str2.length()) { // testa qual das strings é a maior
                max = str1;
                min = str2;
            } else {
                max = str2;
                min = str1;
            }
            int minLength = min.length(); // tamanho da menor string
            int maxS = minLength; // tamanho máximo da substring é o tamanho da menor string
            boolean f = true; // sinaliza quando substring é encontrada

            while (maxS > 0 && f) {
                int diff = minLength - maxS;
                for (int i = 0; i <= diff; i++) { // roda quando a diferença entre a menor string
                                                // e o tamanho máximo da substring é maior que zero
                    if (max.contains(min.substring(i, i + maxS))) { // testa se substring existe na maior string
                        f = false;
                        maxS++;
                        break;
                    }
                }
                maxS--;
            }
            System.out.println(maxS);
        }
        out.close();
    }

}