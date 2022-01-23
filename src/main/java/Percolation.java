import edu.princeton.cs.algs4.WeightedQuickUnionUF;
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
public class Percolation {
	
	//System of sets which percolate
	
	private final WeightedQuickUnionUF systems;
	private final WeightedQuickUnionUF noBackwash;
	
	//list of elements which are open
	
	private boolean[][] grid;
	private int openSites;
	
	
    // creates n-by-n grid, with all sites initially blocked
	
	/**
	 * instantiates a Quick union find and a 2D array of size n*n to corrospond with each union find element index 1:n^2.
	 * NOTE -- index 0 is connected to indexs 1:n, index n^2+1 is connected to indexs n^2:n^2-n+1 
	 * @param n number of rows and columns
	 */
    public Percolation(int n) {
    	
    	//if n is 0 or negative throw expection
    	
    	if (n <= 0) throw new IllegalArgumentException("n must be a positive integer.");
    	
    	//elements 0(n)+1 : (1)(n) are the first row, (1)n+1 : (2)(n) the second row, and so on until the last row (n-1)(n)+1 : (n)(n)
    	
    	systems = new WeightedQuickUnionUF(n*n+2);
    	noBackwash = new WeightedQuickUnionUF(n*n+2);
    	grid = new boolean[n][n];
    	openSites = 0;
	    for (int i = 0; i < n; i++) {
	    	systems.union(0, i+1);
	    	noBackwash.union(0, i+1);
	    	systems.union(n*n+1, n*n-i);
	    	}
    }

    // opens the site (row, col) if it is not open already
    /**
     * Opens up a site and unions adjacent sites. 
     * @param row row index
     * @param col column index
     */
    public void open(int row, int col) {
    	//if row or col is out of range throw exception
    	if (row > grid.length || row < 1 || col > grid.length || col < 1) throw new IllegalArgumentException("row and col must be within range.");
    	grid[row-1][col-1] = true; 
    	if (row != 1 && grid[row-2][col-1] == true) {
    		systems.union(grid[0].length*(row-1)+col, grid[0].length*(row-2)+col);
    		noBackwash.union(grid[0].length*(row-1)+col, grid[0].length*(row-2)+col);
    	}
    	if (row != grid.length && grid[row][col-1] == true) {
    		systems.union(grid[0].length*(row-1)+col, grid[0].length*(row)+col);
    		noBackwash.union(grid[0].length*(row-1)+col, grid[0].length*(row)+col);
    	}
    	if (col != grid.length && grid[row-1][col] == true) {
    		systems.union(grid[0].length*(row-1)+col, grid[0].length*(row-1)+col+1);
    		noBackwash.union(grid[0].length*(row-1)+col, grid[0].length*(row-1)+col+1);
    		
    	}
    	if (col != 1 && grid[row-1][col-2] == true) {
    		systems.union(grid[0].length*(row-1)+col, grid[0].length*(row-1)+col-1);
    		noBackwash.union(grid[0].length*(row-1)+col, grid[0].length*(row-1)+col-1);
    	}
    	openSites++;
    	
    }

    // is the site (row, col) open?
    /**
     * Returns whether the specified element is open 
     * @param row the row of the element 
     * @param col the column of the element
     * @return the element value
     */
    public boolean isOpen(int row, int col) {
    	//if row or col is out of range throw exception
    	if (row > grid.length || row < 1 || col > grid[0].length || col < 1) throw new IllegalArgumentException("row and col must be within range.");
    	return grid[row-1][col-1];
    }

    // is the site (row, col) full?
    /**
     * Returns whether the system percolates through the given element
     * @param row row of element
     * @param col column of element
     * @return does the system percolate through the element
     */
    public boolean isFull(int row, int col) {
    	//if row or col is out of range throw exception
    	if (row > grid.length || row < 1 || col > grid[0].length || col < 1) throw new IllegalArgumentException("row and col must be within range.");
    	return isOpen(row, col) && noBackwash.find(0) == noBackwash.find((row-1)*grid.length+col);
    }

    // returns the number of open sites
    /**
     * Returns openSites, the number of sites that have been opened
     * @return openSites
     */
    public int numberOfOpenSites() {
    	return openSites;
    }

    // does the system percolate?
    /**
     * Returns whether the system percolates
     * @return true if system percolates
     */
    public boolean percolates() {
    	if (grid.length == 1 && grid[0][0] == false) return false;
    	return systems.find(0) == systems.find(grid.length*grid.length+1);
    }
}