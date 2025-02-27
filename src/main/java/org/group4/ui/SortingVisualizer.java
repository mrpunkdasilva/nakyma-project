package org.group4.ui;

import org.group4.values.Texts;

import javax.swing.*;
import java.awt.*;
import java.util.Random;


// TODO: DOCUMENTAR A CLASSE
public class SortingVisualizer<T extends Comparable<T>> extends JPanel{
    private T[] array; // Array genérico
    private Color[] colors;
    public int DELAY = 500; // Delay em milissegundos (0.5s)

    // Construtor que recebe um array genérico
    public SortingVisualizer(T[] array, int delay) {
        this.DELAY = delay;
        this.array = array;
        this.colors = new Color[array.length];
        setPreferredSize(new Dimension(600, 400)); // Tamanho da janela
        generateRandomColors();
    }


    private void generateRandomColors() {
        Random random = new Random();
        for (int i = 0; i < colors.length; i++) {
            colors[i] = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        int barSpacing = 5; // Espaçamento entre as barras
        int barWidth = (width - (barSpacing * (array.length - 1))) / array.length; // Largura das barras

        // Encontra o valor máximo no array para normalização
        T maxValue = findMaxValue(array);

        for (int i = 0; i < array.length; i++) {
            // Converte o valor genérico para uma altura proporcional
            int barHeight = convertToHeight(array[i], maxValue, height);
            g.setColor(colors[i]);
            // Desenha a barra com o espaçamento
            g.fillRect(i * (barWidth + barSpacing), height - barHeight, barWidth, barHeight);
        }
    }

    // Método para encontrar o valor máximo no array
    private T findMaxValue(T[] array) {
        T max = array[0];
        for (T value : array) {
            if (value.compareTo(max) > 0) {
                max = value;
            }
        }
        return max;
    }

    // Método para converter o valor genérico em uma altura proporcional
    private int convertToHeight(T value, T maxValue, int maxHeight) {
        if (value instanceof Integer) {
            return (int) (((Integer) value / (double) (Integer) maxValue) * maxHeight);
        } else if (value instanceof Character) {
            return (int) (((Character) value / (double) (Character) maxValue) * maxHeight);
        }
        // Adicione outros tipos conforme necessário
        return 0;
    }

    public void draw() {
        JFrame frame = new JFrame(Texts.TITLE_APP.getText());
        frame.add(this);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Executa a ordenação em uma thread separada
//        new Thread(() -> {
//            new BubbleSort<T>().sort(array, this);
//        }).start();
    }

    // Método para atualizar o array e repintar a tela
    public void updateArray(T[] newArray) {
        this.array = newArray;
        repaint(); // Atualiza a interface gráfica
        try {
            Thread.sleep(DELAY); // Adiciona um delay para visualização
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}