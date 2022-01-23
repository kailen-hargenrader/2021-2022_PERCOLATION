import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import edu.princeton.cs.algs4.In;

public class PercolationStatsTest {

	private PercolationStats ps200_100;
	private PercolationStats ps2_10000;
	
  @Before
  public void setup() {
	  ps200_100 = new PercolationStats(200, 100);
	  ps2_10000 = new PercolationStats(2, 10000);  
  }

  @Test (timeout = 5000)
  public void testMean200_100() {
    assertEquals("Should be close to .59", .59, ps200_100.mean(), 0.01);
    }
  
  @Test (timeout = 5000)
  public void testMean2_10000() {
    assertEquals("Should be close to .67", .67, ps2_10000.mean(), 0.01);
    }

  @Test (timeout = 5000)
  public void testStddev200_100() {
	  assertEquals("Should be close to .009", .009, ps200_100.stddev(), 0.01);
  }
  
  @Test (timeout = 5000)
  public void testStddev2_10000() {
	  assertEquals("Should be close to .117", .117, ps2_10000.stddev(), 0.01);
  }
  
  @Test (timeout = 5000)
  public void testConfidenceHi200_100() {
	  assertEquals("Should be close to .595", .595, ps200_100.confidenceHi(), 0.01);
  }
  
  @Test (timeout = 5000)
  public void testConfidenceHi2_10000() {
	  assertEquals("Should be close to .668", .668, ps2_10000.confidenceHi(), 0.01);
  }
  
  @Test (timeout = 5000)
  public void testConfidenceLo200_100() {
	  assertEquals("Should be close to .591", .591, ps200_100.confidenceLo(), 0.01);
  }
  
  @Test (timeout = 5000)
  public void testConfidenceLo2_10000() {
	  assertEquals("Should be close to .591", .591, ps200_100.confidenceLo(), 0.01);
  }
}
