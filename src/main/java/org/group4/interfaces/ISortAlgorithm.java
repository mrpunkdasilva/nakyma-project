package org.group4.interfaces;

import org.group4.ui.SortingVisualizer;

public interface ISortAlgorithm<T extends Comparable<T>>{
    void sort(T[] array, SortingVisualizer sortVisualizer);
}
