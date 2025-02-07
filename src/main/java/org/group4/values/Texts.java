package org.group4.values;

import java.util.ArrayList;

public enum Texts {

    NAKYMA_LOGO(
            """
                    ██    ██    ███    ██    ██ ██    ██ ██     ██    ███   \s
                    ███   ██   ██ ██   ██   ██   ██  ██  ███   ███   ██ ██  \s
                    ████  ██  ██   ██  ██  ██     ████   ████ ████  ██   ██ \s
                    ██ ██ ██ ██     ██ █████       ██    ██ ███ ██ ██     ██\s
                    ██  ████ █████████ ██  ██      ██    ██     ██ █████████\s
                    ██   ███ ██     ██ ██   ██     ██    ██     ██ ██     ██\s
                    ██    ██ ██     ██ ██    ██    ██    ██     ██ ██     ██\s
            """
    ),
    LOADING("""
  _                     _ _                   
 | |                   | (_)                  
 | |     ___   __ _  __| |_ _ __   __ _       
 | |    / _ \\ / _` |/ _` | | '_ \\ / _` |      
 | |____ (_) | (_| | (_| | | | | | (_| |_ _ _ 
 |______\\___/ \\__,_|\\__,_|_|_| |_|\\__, (_)_)_)
                                   __/ |      
                                  |___/  
     """),
    WELCOME(
            """
                    \t\t\t\t\t✨ Bem-vindo ao Nakyma! ✨ \n
                    A solução definitiva para visualizar e compreender algoritmos de forma intuitiva e interativa.
                    \s
                    Com o Nakyma, aprender e explorar ficou muito mais fácil."""
    ),
    PRESS_ENTER("\t\t\t\t\tPress <enter> to start ᓚᘏᗢ"),
    EQUALS("="),
    ERR_SORT_ALGO("Informe um tipo de algoritmo válido: \nBubble Sort (B) \nMerge Sort (M) \nQuick Sort (Q)!"),
    ERR_QUANTI_MIN_ARGS("Quantidade minima de argumentos incorretos!"),
    ERR_TYPE_LIST("Informe um tipo de lista válido: \nNuméricos (N) \nCaracteres (C)!"),
    ERR_ORDER("Informe uma ordem de ordenação válida: \nCrescente (ZA) \nDecrescente (AZ)!"),
    ERR_RANGE_NUMERIC("Números entre -1000 e 1000."),
    ERR_RANGE_CHARACTERS("Caracteres entre 'a' e 'z'."),
    ERR_INPUT_USER_LIST("Valores inválidos para a LISTA FORNECIDA! Você só pode informar esses valores SEPARADOS POR VIRGULA:\n" +
            "- " + ERR_RANGE_NUMERIC.getText() + "\n" +
            "- " + ERR_RANGE_CHARACTERS.getText() + """ 
            \n
            Exemplo de uso do argumento LISTA FORNECIDA (v):
            - Caso seja caractere: v=“b,B,a,Z”
            - Caso seja número: v=“10,6,3,4,5”
            """),
    ERR_LENGTH_LIST("Os valores para a lista aleatória é de 1-40."),
    ERR_SOURCE_LIST("Fonte de valor inválido! Deve ser passado: \n- (R) para valores aleatorios \n- (M) para valores que você deseja fornecer."),
    ERR_DUPLICATES("Não é possível ordenar uma lista com valores duplicados!"),
    ERR_ITERATION_TIME("Tempo de pausa inválido! Informe um tempo entre 100 e 1000 milissegundos."),
    ERROR_ICON("""      
          
     ⢰⠲⢄⡀⠀⠀⠀⠀⠀⡏⠒⠤⡀⠀⠀⠀⠀
    ⠀⠘⡄⣀⠙⣦⠀⠀⣀⣰⡣⢸⠢⡈⠢⡀⠀⠀⠀
    ⠀⠀⠸⡰⡰⠈⠉⠉⠀⠀⠀⠈⠑⠰⡀⠘⡄⠀⠀
    ⠀⠀⢸⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⡀⠀⠀
    ⠀⠀⡎⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢣⠀⠀
    ⢀⣾⡀⢳⢤⣀⠤⠀⠀⠀⢠⣀⣀⡀⠔⠀⠀⣸⠀⠀
    ⠘⢦⡀⡎⠀⡼⠁⠀⢻⠃⠀⠸⡄⠀⡅⠀⠈⢽⠀⠀
    ⠀⠀⠙⠤⣰⠃⠀⠀⠁⡖⠒⢼⡀⠐⣄⠤⠋⠁⠀⠀
    ⠀⠀⠀⠀⢀⡝⠒⡆⠀⠘⡄⠀⠻⣫⡀⠀⠀⠀⠀⠀
    ⠀⠀⠀⢠⠊⣀⡼⠀⠀⠀⠈⠢⢀⡠⠃⠀⠀⡰⠊⢱
    ⠀⠀⠀⠀⠉⠀⡇⠀⠀⠀⠀⠀⠀⡇⠀⡠⠊⣠⠔⠁
    ⠀⠀⠀⠀⠀⢸⠀⢤⠤⠤⠤⢤⠄⡯⠓⠋⠉⠀⠀⠀
    ⠀⠀⠀⠀⠀⠸⡠⠇⠀⠀⠀⠈⢆⠇⠀⠀⠀⠀⠀⠀
    """),
    PATH_RESOURCES("src/main/resources/"),

    ;

    public ArrayList<String> HEADER_ARGS() {
        return new ArrayList<String>(){

        };
    }

    private final String text;

    Texts(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
