import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import java.lang.Math;
/******************************************************************************
 *  Name:    Kevin Wayne
 *  Login:   wayne
 *  Precept: P01
 *
 *  Partner Name:    N/A
 *  Partner Login:   N/A
 *  Partner Precept: N/A
 * 
 *  Compilation:  javac-algs4 Percolation.java
 *  Execution:    java-algs4 Percolation
 *  Dependencies: StdIn.java StdRandom.java WeightedQuickUnionUF.java
 *
 *  Description:  Modeling Percolation like a boss. woot. woot.
 ******************************************************************************/

public class PercolationStats {
	
	private double[] Trials;
	private Percolation perc;
   public PercolationStats(int n, int trials) {
	   if(n<=0 || trials <=0) throw new IllegalArgumentException("both the size and the number of trials must be positive.");
	   Trials = new double[trials];
	   for(int i=0;i<trials;i++) {
		   perc = new Percolation(n);
		   int[] indexs = StdRandom.permutation(n*n);
		   int j = 0;
		   while(!perc.percolates()) {
			   perc.open((indexs[j])/n+1, indexs[j]%n+1);
			   j++;
		   }
		   Trials[i] = (double) perc.numberOfOpenSites()/(n*n);
	   }
   }
   public double mean() {
     return StdStats.mean(Trials);
   }
   public double stddev() {
     return StdStats.stddev(Trials);
   }
   public double confidenceLo() {
     // TODO: return low  endpoint of 95% confidence interval
     return mean()-(1.96*stddev()/Math.sqrt(Trials.length));
   }
   public double confidenceHi() {
     // TODO: return high endpoint of 95% confidence interval
     return mean()+(1.96*stddev()/Math.sqrt(Trials.length));
   }

   public static void main(String[] args) {
     // test client (described at http://coursera.cs.princeton.edu/algs4/assignments/percolation.html)
	 PercolationStats p = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
	 System.out.println("Mean = " + p.mean());
	 System.out.println("Stddev = " + p.stddev());
	 System.out.println("95% Confidence Interval = [" + p.confidenceLo() + ", " + p.confidenceHi() + "]");
   }
}