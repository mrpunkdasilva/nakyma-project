package org.group4.ui;

import org.group4.base.Algorithm;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SortingGUI extends JPanel {
    private int[] array;
    private Color[] colors;
    private Algorithm algorithm;
    private int delay; // Velocidade de execução (em milissegundos)

    /**
     * Constructor for the SortingGUI class.
     *
     * @param inputList The list of values to be sorted.
     * @param delay     The delay between steps (in milliseconds).
     */
    public SortingGUI(List<String> inputList, int delay) {
        this.delay = delay;
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.WHITE);

        // Converte a lista de strings para um array de inteiros
        this.array = inputList.stream().mapToInt(Integer::parseInt).toArray();
        this.colors = new Color[array.length];
        for (int i = 0; i < colors.length; i++) {
            colors[i] = Color.BLUE; // Cor inicial das barras
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        int barWidth = width / array.length;

        // Encontra o valor máximo no array
        int maxValue = 0;
        for (int value : array) {
            if (value > maxValue) {
                maxValue = value;
            }
        }

        // Define uma altura mínima para as barras (por exemplo, 10 pixels)
        int minBarHeight = 10;

        for (int i = 0; i < array.length; i++) {
            // Calcula a altura da barra como uma proporção do valor máximo
            int barHeight = (int) (((double) array[i] / maxValue) * (height - minBarHeight)) + minBarHeight;
            g.setColor(colors[i]);
            g.fillRect(i * barWidth, height - barHeight, barWidth - 2, barHeight);
        }
    }

    public void startSorting() {
        new Thread(() -> {
//            algorithm.sort(this); // Passa o array e a referência para o SortingGUI
            repaint();
        }).start();
    }

    public void updateArray(int[] newArray, int index1, int index2) {
        array = newArray.clone();
        colors[index1] = Color.RED; // Destaca o primeiro elemento
        colors[index2] = Color.RED; // Destaca o segundo elemento
        repaint();

        try {
            Thread.sleep(delay); // Adiciona um atraso para visualização
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        colors[index1] = Color.BLUE; // Restaura a cor do primeiro elemento
        colors[index2] = Color.BLUE; // Restaura a cor do segundo elemento
        repaint();
    }

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }
}