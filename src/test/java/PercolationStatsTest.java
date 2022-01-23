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
	  ps200_100 = new PercolationStats(200, 1);
	  ps2_10000 = new PercolationStats(2, 1);  
  }

  @Test
  public void testmean() {
    assertEquals(.59, ps200_100.mean(), 0.01);
    assertEquals(.67, ps2_10000.mean(), 0.01);
      }
    }
