package one.digitalinnovation.desafio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MinhaPrimeiraClasse {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        while (0 != (n = Integer.parseInt(br.readLine()))) {
            List<String> conjunto = new ArrayList<>();
            // ler todo o conjunto antes de testar, caso contrário, atrapalhará leitura dos próximos
            for (int i = 0; i < n; i++) {
                conjunto.add(br.readLine());
            }
            boolean ruim = false;
            for (int i = 0; i < conjunto.size(); i++) {
                var conjuntoTeste = new ArrayList<>(conjunto);
                var palavra = conjuntoTeste.remove(i);
                //conjuntoTeste.remove(i);
                if (conjuntoTeste
                        .stream().anyMatch(busca -> busca.startsWith(palavra))) {
                    ruim = true;
                    break;
                }
            }
            if (ruim) {System.out.println("Conjunto Ruim");}
            else {System.out.println("Conjunto Bom");}

        }
    }

}