package com.snp.testcase.module.prototype;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.snp.testcase.corefunction.AddUserTest;
import com.snp.testcase.corefunction.UpdateTest;

/**
 * Some simple tests.
 *
 */
public class SimpleTest extends TestCase {
	protected int fValue1;
	protected int fValue2;

	@Override
	protected void setUp() {
		fValue1= 3;
		fValue2= 3;
	}
	public static Test suite() {
		TestSuite suite= new TestSuite("整体测试");
		suite.addTestSuite(UpdateTest.class);
		suite.addTestSuite(AddUserTest.class);
		/*如果是添加某一个方法*/
		suite.addTest(
			new UpdateTest() {
				 protected void runTest() { test_print_version(); }
			}
		);
		
        

		return suite;
	
	}
	public void testAdd() {
		double result= fValue1 + fValue2;
		// forced failure result == 5
		assertTrue(result == 6);
	}

	public static void main (String[] args) {
		junit.textui.TestRunner.run(suite());
	}
}