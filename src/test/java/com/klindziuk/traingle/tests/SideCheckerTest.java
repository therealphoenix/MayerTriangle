package com.klindziuk.traingle.tests;

import static org.junit.Assert.*;
import org.junit.Test;
import com.klindziuk.traingle.SideChecker;

public class SideCheckerTest {

	@Test
	public void CheckSides_2_3_4_test() {

		assertEquals(true, SideChecker.CheckSides(2, 3, 4));
	}

	@Test
	public void CheckSides_0_3_4_test() {

		assertEquals(false, SideChecker.CheckSides(0, 3, 4));
	}

	@Test
	public void CheckSides_minus1_3_4_test() {

		assertEquals(false, SideChecker.CheckSides(-1, 3, 4));
	}
	
	@Test
    public void CheckSides_222_222_222_test() {
        
    	assertEquals(true, SideChecker.CheckSides(222, 222, 222));
    }
	
	@Test
    public void CheckSumOfSides_33_33_44_test() {
        
    	assertEquals(true, SideChecker.checkSumOfSides(33, 33, 44));
    }
	
	@Test
    public void CheckSumOfSides_1_1_2_test() {
        
    	assertEquals(false, SideChecker.checkSumOfSides(1, 1, 2));
    }
	
	@Test
    public void CheckSumOfSides_9_9_100_test() {
        
    	assertEquals(false, SideChecker.checkSumOfSides(9, 9, 100));
    }
	@Test
    public void CheckSumOfSides_0_0_0_test() {
        
    	assertEquals(false, SideChecker.checkSumOfSides(0, 0, 0));
    }
	
	@Test
    public void CheckSumOfSides_MAX_MAX_MAX() {
        
    	assertEquals(false, SideChecker.checkSumOfSides(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE));
    }

}