package org.example.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PermutationGenerator<T> implements Iterator<List<T>> {
    private final List<T> items;
    private final int[] indices;
    private boolean hasNext;

    public PermutationGenerator(Set<T> items) {
        this.items = new ArrayList<>(items);
        this.indices = new int[this.items.size()];
        for (int i = 0; i < this.indices.length; i++) {
            this.indices[i] = i;
        }
        this.hasNext = true;
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }

    @Override
    public List<T> next() {
        if (!hasNext) {
            throw new IllegalStateException("No more permutations");
        }

        List<T> result = new ArrayList<>();
        for (int index : indices) {
            result.add(items.get(index));
        }

        hasNext = generateNextPermutation();
        return result;
    }

    private boolean generateNextPermutation() {
        int i = indices.length - 1;
        while (i > 0 && indices[i - 1] >= indices[i]) {
            i--;
        }

        if (i <= 0) {
            return false;
        }

        int j = indices.length - 1;
        while (indices[j] <= indices[i - 1]) {
            j--;
        }

        int temp = indices[i - 1];
        indices[i - 1] = indices[j];
        indices[j] = temp;

        j = indices.length - 1;
        while (i < j) {
            temp = indices[i];
            indices[i] = indices[j];
            indices[j] = temp;
            i++;
            j--;
        }

        return true;
    }
}
