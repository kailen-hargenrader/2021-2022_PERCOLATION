import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import edu.princeton.cs.algs4.In;

public class PercolationStatsTest {

	PercolationStats ps200_100;
	PercolationStats ps2_10000;
	
  @Before
  public void setup() {
	  ps200_100 = new PercolationStats(200, 100);
	  ps2_10000 = new PercolationStats(2, 10000);  
  }

  @Test (timeout = 5000)
  public void testMean() {
    assertEquals(.59, ps200_100.mean(), 0.01);
    assertEquals(.67, ps2_10000.mean(), 0.01);
    }

  @Test (timeout = 5000)
  public void testStddev() {
	  assertEquals(.009, ps200_100.stddev(), 0.01);
	  assertEquals(.117, ps2_10000.stddev(), 0.01);
  }
  
  @Test (timeout = 5000)
  public void testConfidenceHi() {
	  assertEquals(.595, ps200_100.confidenceHi(), 0.01);
	  assertEquals(.668, ps2_10000.confidenceHi(), 0.01);
  }
  @Test (timeout = 5000)
  public void testConfidenceLo() {
	  assertEquals(.591, ps200_100.confidenceLo(), 0.01);
	  assertEquals(.665, ps2_10000.confidenceLo(), 0.01);
  }
}
