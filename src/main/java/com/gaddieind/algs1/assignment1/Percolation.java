package com.gaddieind.algs1.assignment1;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Created by Alex on 1/13/2017.
 */
public class Percolation {

    private final WeightedQuickUnionUF weightedUnion;
    private final int size;

    // create n-by-n grid, with all sites blocked
    public Percolation(int n){
        size = n;
        weightedUnion = new WeightedQuickUnionUF((n * n) + 2);
    }

    // open site (row, col) if it is not open already
    public void open(int row, int col){
        weightedUnion.union(row, col);
    }

    public boolean isOpen(int row, int col){

        return false;
    }

    public boolean isFull(int row, int col){

        return false;
    }

    public int numberOfOpenSites(){

        return 0;
    }

    public boolean percolates(){

        return false;
    }
}
