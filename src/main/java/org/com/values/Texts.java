package org.com.values;

import org.com.config.AppConfigs;

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
    TITLE_APP("Sorting Algorithm Visualizer"),
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
    ERR_SORT_ALGO("\tInforme um tipo de algoritmo válido: \n\t- Bubble Sort (B) \n\t- Quick Sort (Q) \n\t- Selection Sort (S)\n"),
    ERR_QUANTI_MIN_ARGS("Quantidade minima de argumentos incorretos!"),
    ERR_TYPE_LIST("Informe um tipo de lista válido: \nNuméricos (N) \nCaracteres (C)!"),
    ERR_ORDER("Informe uma ordem de ordenação válida: \n- Crescente (ZA) \n- Decrescente (AZ)!"),
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
    ERR_ITERATION_TIME("Tempo de pausa inválido! Informe um tempo entre 100 e 1000 milissegundos."),
    ERR_RANDOM_LENGTH_LIST("O tamanho da lista randómica é obrigatório e deve ser um número inteiro entre 1 e 40"),
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
    HEADER("""
+---------------------------------------------------+
| Application Settings                               
+-------------------+-------------------------------+
| Parameter         | Value                         
+-------------------+-------------------------------+
    """)

    ;


    private final String text;

    Texts(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static String tableHeader(AppConfigs configs) {
        String typeList = String.format("| %-17s | %-29s ", "List Type", configs.getTypeListName());
        String alg = String.format("| %-17s | %-29s  ", "Algorithm", configs.getAlgorithmName());
        String inputList = String.format("| %-17s | %-29s ", "Input List", configs.inputList());
        String speed = String.format("| %-17s | %-29s ", "Speed", configs.s() + "ms");
        String footer = "+-------------------+-------------------------------+";

        return Texts.HEADER.getText() + typeList + "\n" + alg + "\n"+ inputList + "\n" + speed + "\n" + footer;
    }

}
