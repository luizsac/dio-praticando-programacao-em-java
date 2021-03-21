package one.digitalinnovation.desafio4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Essa solução falha nos últimos três dos sete testes do desafio
 */

public class MinhaClasse {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String palavra;

        // \w define o tipo de caracteres a ser encontrado
        // + define que o caracter deve aparecer uma ou mais vezes
        // () cria um grupo lógico e captura seu conteúdo para uso posterior
        // referência: https://www.vogella.com/tutorials/JavaRegularExpressions/article.html
        // \1 é uma backreference. Faz referência a um conjunto de caracteres que já foi encontrado uma vez
        // sem \1, a expressão encontra todo o texto como resultado, não só as partes que se repetem
        // referência: https://www.regular-expressions.info/backref.html
        // app que testa expressões:
        // https://play.google.com/store/apps/details?id=com.kalpeshkundanani.easy_regex&hl=pt_BR&gl=US
        Pattern patternTD = Pattern.compile("(\\w+)\\1");

        while ((palavra = br.readLine()) != null) {
            Matcher matcherTD = patternTD.matcher(palavra);
            while (matcherTD.find()) {
                // $1 faz referência ao primeiro grupo lógico da expressão
                palavra = palavra.replaceAll("(\\w+)\\1", "$1");
            }
            System.out.println(palavra);
        }
    }
}