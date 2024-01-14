
package com.model;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class MyBigTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}


	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}


	@Test
	void testSum() {
	       System.out.println("sum");

	        String stn1case1 = "99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999";
	        String stn2case1 = "1";
	        String expResultcase1 = "100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
	        String resultcase1 = MyBigNumber.sum(stn1case1, stn2case1);
	        assertEquals(expResultcase1, resultcase1);

	        String stn1case2 = "572389472380470329759023";
	        String stn2case2 = "218479000000000000000000000091";
	        String expResultcase2 = "218479572389472380470329759114";
	        String resultcase2 = MyBigNumber.sum(stn1case2, stn2case2);
	        assertEquals(expResultcase2, resultcase2);

	        String stn1case3 = "218479000000000000000000000001";
	        String stn2case3 = "572389472380470329759023";
	        String expResultcase3 = "218479572389472380470329759024";
	        String resultcase3 = MyBigNumber.sum(stn1case3, stn2case3);
	        assertEquals(expResultcase3, resultcase3);

	        String stn1case4 = "99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999";
	        String stn2case4 = "-1";
	        String expResultcase4 = "99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999998";
	        String resultcase4 = MyBigNumber.sum(stn1case4, stn2case4);
	        assertEquals(expResultcase4, resultcase4);

	        String stn1case5 = "-99999999999999999999999999999999999999999999999999999999999998";
	        String stn2case5 = "-1";
	        String expResultcase5 = "-99999999999999999999999999999999999999999999999999999999999999";
	        String resultcase5 = MyBigNumber.sum(stn1case5, stn2case5);
	        assertEquals(expResultcase5, resultcase5);

	        String stn1case6 = "-99999999999999999999999999999999999999999999999999999999999999";
	        String stn2case6 = "99999999999999999999999999999999999999999999999999999999999999";
	        String expResultcase6 = "0";
	        String resultcase6 = MyBigNumber.sum(stn1case6, stn2case6);
	        assertEquals(expResultcase6, resultcase6);
	        
	        String stn1case7 = "";
	        String stn2case7 = "";
	        String expResultcase7 = "0";
	        String resultcase7 = MyBigNumber.sum(stn1case7, stn2case7);
	        assertEquals(expResultcase7, resultcase7);
	}

}
