package algorithms;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RecursiveMathTest {

	private RecursiveMath impl;

	@Before
	public void setup() {
		impl = new RecursiveMath();
		if (impl == null)
			fail("Could not allocate a RecursiveMath object.");
	}

	@Test(timeout = 5000)
	public void testIsEven() {
		assertTrue(impl.isEven(4));
		assertFalse(impl.isEven(1));
		assertTrue(impl.isEven(12));
		assertTrue(impl.isEven(-42));
		assertFalse(impl.isEven(-13));
	}

	@Test(timeout = 5000)
	public void testIsOdd() {
		assertFalse(impl.isOdd(4));
		assertTrue(impl.isOdd(1));
		assertFalse(impl.isOdd(12));
		assertFalse(impl.isOdd(-42));
		assertTrue(impl.isOdd(-13));
	}

	@Test(timeout = 5000)
	public void testSumN() {
		assertEquals(impl.sumN(0), 0);
		assertEquals(impl.sumN(1), 1);
		assertEquals(impl.sumN(2), 3);
		assertEquals(impl.sumN(3), 6);
		assertEquals(impl.sumN(4), 10);
		assertEquals(impl.sumN(5), 15);
		assertEquals(impl.sumN(6), 21);
		assertEquals(impl.sumN(100), 5050);
	}

	@Test(timeout = 5000, expected = IllegalArgumentException.class)
	public void testSumNException() {
		impl.sumN(-1);
	}

	@Test(timeout = 5000)
	public void testFactorial() {
		assertEquals(impl.factorial(1), 1);
		assertEquals(impl.factorial(2), 2);
		assertEquals(impl.factorial(3), 6);
		assertEquals(impl.factorial(4), 24);
		assertEquals(impl.factorial(10), 3628800);
	}

	@Test(timeout = 5000, expected = IllegalArgumentException.class)
	public void testFactorialException() {
		impl.factorial(-1);
	}

	@Test(timeout = 5000)
	public void testBiPower() {
		assertEquals(impl.biPower(0), 1);
		assertEquals(impl.biPower(1), 2);
		assertEquals(impl.biPower(2), 4);
		// TODO Figure out what that crazy thing in there is.
		assertEquals(impl.biPower(20), 0x1 << 20);
	}

	@Test(timeout = 5000, expected = IllegalArgumentException.class)
	public void testBiPowerException() {
		impl.biPower(-5);
	}

}
