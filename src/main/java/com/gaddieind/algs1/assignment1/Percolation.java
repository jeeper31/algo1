package com.gaddieind.algs1.assignment1;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Created by Alex on 1/13/2017.
 */
public class Percolation {

    private final WeightedQuickUnionUF weightedUnion;
    private final int n;
    private final int size;
    private final boolean[] openings;
    private int openSites = 0;

    // create n-by-n grid, with all sites blocked
    public Percolation(int n){
        this.n = n;
        this.size = (n * n) + 2;
        weightedUnion = new WeightedQuickUnionUF(size);
        openings = new boolean[size];
    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) {
        int index = getIndex(row, col);
        openings[index] = true;
        openSites++;

        //connect up the virtual nodes if we are on the top or bottom rows
        if (row - 1 == 0) weightedUnion.union(0, index);

        //This causes percolation from the bottom up
       // if (row - 1 == n - 1) weightedUnion.union(size - 1, index);

        int above = index - n;
        int below = index + n;
        int left = index - 1;
        int right = index + 1;
        if (above > 0 && openings[above]) weightedUnion.union(above, index);
        if (row < n && openings[below]) weightedUnion.union(below, index);
        if (col > 1 && openings[left]) weightedUnion.union(left, index);
        if (col < n && openings[right]) weightedUnion.union(right, index);
    }

    public boolean isOpen(int row, int col){
        int index = getIndex(row, col);
        return openings[index];
    }

    private int getIndex(int row, int col) {
        return (n * (row - 1)) + (col - 1) + 1;
    }

    public boolean isFull(int row, int col){
        int index = getIndex(row, col);
        return weightedUnion.connected(0, index);
    }

    public int numberOfOpenSites(){
        return openSites;
    }

    public boolean percolates(){
        //return weightedUnion.connected(0, size - 1);
        int startingIndex = n * n - n;
        for(int i = startingIndex; i <= n * n; i++){
            if(weightedUnion.connected(0, i)) return true;
        }

        return false;
    }
}
