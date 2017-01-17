package com.gaddieind.algs1.assignment1;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * Created by Alex on 1/13/2017.
 */
public class PercolationStats {

    private int trials;
    private double mean;
    private double stddev;

    // perform trials independent experiments on an n-by-n grid
    public PercolationStats(int n, int trials){
        if(n <= 0 || trials <= 0) throw new IllegalArgumentException("n and trials must be positive.");
        double[] openSiteCount = new double[trials];
        this.trials = trials;
        double size = n * n;

        for(int i = 0; i < trials; i++) {
            Percolation percolation = new Percolation(n);

            while(!percolation.percolates()){
                int row = StdRandom.uniform(1, n+1);
                int col = StdRandom.uniform(1, n+1);
                percolation.open(row, col);
            }

            openSiteCount[i] = (percolation.numberOfOpenSites() / size);
        }

        mean = StdStats.mean(openSiteCount);
        stddev = StdStats.stddev(openSiteCount);
    }

    // sample mean of percolation threshold
    public double mean(){
        return mean;
    }

    // sample standard deviation of percolation threshold
    public double stddev(){
        return stddev;
    }

    // low  endpoint of 95% confidence interval
    public double confidenceLo(){
        return mean() - ((1.96) * stddev() / Math.sqrt(trials));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi(){
        return  mean() + ((1.96) * stddev() / Math.sqrt(trials));
    }

    public static void main(String[] args){
        PercolationStats stats = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        System.out.println("mean =\t" + stats.mean());
        System.out.println("stddev =\t" + stats.stddev());
        System.out.println("95% confidence interval =\t" + stats.confidenceLo() + ", " + stats.confidenceHi());
    }
}
