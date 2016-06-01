package first_java;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestTestAssert {


	@Test
	public void testsqrt() {
		TestAssert a= new TestAssert();
		assertEquals(a.sqrt(100), 10);
		
	}

}
