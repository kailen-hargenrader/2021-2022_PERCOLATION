import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class PercolationStatsTest extends TestCase {
	private PercolationStatsTest ps200_100;
	
	@Before
	public void setup() {
		ps200_100 = new PercolationStatsTest(200, 100);
		
	}
	@Test
	public void testmean200_100() {
		assertEquals(.59, ps200_100.mean(), 0.01);
	}
}
