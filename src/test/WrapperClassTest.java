package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class WrapperClassTest {

	@Test
	public void Integer_비교_127이하() {
		Integer i1 = 127;
		Integer i2 = 127;
		assertTrue(i1==i2);
	}
	
	@Test
	public void Integer_비교_128이상_1() {
		Integer i1 = 128;
		Integer i2 = 128;
		assertTrue(i1==i2);
	}
	
	@Test
	public void Integer_비교_128이상_2() {
		Integer i1 = 128;
		Integer i2 = 128;
		assertTrue(i1.equals(i2));
	}
	
	@Test
	public void Integer_비교_128이상_3() {
		Integer i1 = 128;
		Integer i2 = 128;
		assertTrue(i1.intValue()==i2.intValue());
	}

}
