package one.digitalinnovation.desafio1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class MinhaPrimeiraClasse {

    private static List<String> palavrasSelecionadas = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String linha = br.readLine();
            if (linha.equals(".")) {
                break;
            }
            var palavrasElegiveis = Arrays.stream(linha.split(" "))
                    .filter(palavra -> palavra.length() > 2)
                    .collect(Collectors.toList());

            selecionarPalavras(palavrasElegiveis);
            System.out.println(abreviarPalavras(linha));
            System.out.println(palavrasSelecionadas.size());
            palavrasSelecionadas.sort(Comparator.naturalOrder());
            palavrasSelecionadas.forEach(palavra -> System.out.println(palavra.charAt(0) + ". = " + palavra));
            palavrasSelecionadas.clear();
        }
    }

    private static void selecionarPalavras(List<String> palavrasElegiveis) {
        var iniciais = obterIniciais(palavrasElegiveis);

        for (char inicial : iniciais) {
            List<String> iniciadasCom = obterIniciadasCom(inicial, palavrasElegiveis);
            var ocorrencias = new HashMap<String, Integer>();
            iniciadasCom.stream()
                    .forEach(palavra -> ocorrencias
                            .put(palavra, ocorrencias
                                    .containsKey(palavra) ? ocorrencias.get(palavra) + 1 : 1));

            palavrasSelecionadas.add(obterMelhorEscolha(ocorrencias));
        }
    }

    private static List<Character> obterIniciais(List<String> palavras) {
        return palavras.stream()
                .map(palavra -> palavra.charAt(0))
                .distinct()
                .collect(Collectors.toList());
    }

    private static List<String> obterIniciadasCom(char inicial, List<String> palavrasElegiveis) {
        return palavrasElegiveis.stream()
                .filter(palavra -> palavra.startsWith(String.valueOf(inicial)))
                .collect(Collectors.toList());
    }

    private static String obterMelhorEscolha(HashMap<String, Integer> ocorrencias) {
        String melhorEscolha = "";
        int maisEconomica = 0;
        for (var chave : ocorrencias.keySet()) {
            int caracteresEconomizados = (chave.length() - 2) * ocorrencias.get(chave);
            if (caracteresEconomizados > maisEconomica) {
                maisEconomica = caracteresEconomizados;
                melhorEscolha = chave;
            }
        }
        return melhorEscolha;
    }

    private static String abreviarPalavras(String linha) {
        for(String palavra: palavrasSelecionadas) {
            // sem a adição do back-space character (\\b), replaceAll não substitui algumas palavras corretamente
            linha = linha.replaceAll("\\b" + palavra + "\\b", palavra.charAt(0) + ".");
        }
        return linha;
    }
}