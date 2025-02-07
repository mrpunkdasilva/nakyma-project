import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SortingVisualizer extends JPanel {
    private int[] array = {50, 30, 70, 10, 90, 20, 60, 40, 80, 100}; // Array inicial
    private Color[] colors = new Color[array.length];
    private static final int DELAY = 500; // Delay em milissegundos (0.5s)

    public SortingVisualizer() {
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
        int barWidth = width / array.length;

        for (int i = 0; i < array.length; i++) {
            int barHeight = array[i] * (height / 100); // Escala proporcional
            g.setColor(colors[i]);
            g.fillRect(i * barWidth, height - barHeight, barWidth - 2, barHeight);
        }
    }

    // Algoritmo Bubble Sort com animação
    public void bubbleSort() {
        try {
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = 0; j < array.length - i - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        // Troca de elementos
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;

                        repaint(); // Atualiza a interface
                        Thread.sleep(DELAY); // Pausa para visualização
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Algoritmo Insertion Sort com animação
    public void insertionSort() {
        try {
            int n = array.length;
            for (int i = 1; i < n; i++) {
                int key = array[i];
                int j = i - 1;

                while (j >= 0 && array[j] > key) {
                    array[j + 1] = array[j];
                    j--;

                    repaint(); // Atualiza a interface
                    Thread.sleep(DELAY); // Pausa para visualização
                }
                array[j + 1] = key;

                repaint(); // Atualiza após a inserção
                Thread.sleep(DELAY);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sorting Algorithm Visualizer");
        SortingVisualizer visualizer = new SortingVisualizer();
        frame.add(visualizer);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Escolher o algoritmo a ser visualizado
        new Thread(visualizer::insertionSort).start();
    }
}


