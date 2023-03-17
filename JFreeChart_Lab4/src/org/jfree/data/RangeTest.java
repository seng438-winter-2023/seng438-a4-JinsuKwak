package org.jfree.data;

import static org.junit.Assert.*; 
import org.jfree.data.Range; 
import org.junit.*;
import java.security.InvalidParameterException;

public class RangeTest {
    private Range exampleRange;			// Given Example from LAB Document
    private Range rangeNomial;
    private Range rangePositive;
    private Range rangePositiveUB;		// Assume Upper Bound is 1000
    private Range rangeNegative;
    private Range rangeNegativeLB;		// Assume Lower Bound is -1000
    private Range rangeLarge;
    private Range intersectRange;
    private Range exampleRange2;
    private Range testRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { 
    	exampleRange = new Range(-1, 1);
    	rangeNomial = new Range(-10,10);
        rangePositive = new Range(1, 100);
        rangePositiveUB = new Range(1, 1000); 
        rangeNegative = new Range(-100, -1);
        rangeNegativeLB = new Range(-1000, 1); 
        intersectRange = new Range(5,15);
    }

	// -----------------------------------------------------------------------------------------
	// Given Example Test Code from LAB Document
	// -----------------------------------------------------------------------------------------
    @Test
    public void centralValueShouldBeZero() {
        assertEquals("The central value of -1 and 1 should be 0",
        0, exampleRange.getCentralValue(), .000000001d);
    }
    
    // -----------------------------------------------------------------------------------------
    // Start of Test Code
    // -----------------------------------------------------------------------------------------
	
    // -----------------------------------------------------------------------------------------
    // Start of Test Code LAB2
    // -----------------------------------------------------------------------------------------
    	
    // ------- Test for combine(Range range1, Range range2) -------
    
    /*
     *  This test will simulate when both parameters are not NULL
     *  Expected result: new range should be created from two input ranges
     */
	@Test(timeout = 1000) // timeout: 1000
	public void testCombineNoNullParametersLowerBound() {
		// combine two ranges  : (-1, 11), (-10, -9)
		Range tempRange = Range.combine(new Range(-1, 11), new Range(-10, -9));													
		double actualLowerBound = tempRange.getLowerBound();
		double expectedLowerBound = -10.0;
		assertEquals("Checking combinded lower bound when both parameters are non null value", expectedLowerBound, actualLowerBound, .000000001d);
	}
	
    /*
   *  This test will simulate when both parameters are not NULL
     *  Expected result: new range should be created from two input ranges
     */
	@Test(timeout = 1000) // timeout: 1000
	public void testCombineNoNullParametersUpperBound() {
		// combine two ranges  : (-1, 11), (-10, -9)
		Range tempRange = Range.combine(new Range(-1, 11), new Range(-10, -9));													
		double actualUpperBound = tempRange.getUpperBound();
		double expectedUpperBound = 11.0;
		assertEquals("Checking combinded upper bound when both parameters are non null value", expectedUpperBound, actualUpperBound, .000000001d);
	}
	
    /*
     *  This test will simulate when the first parameter is NULL
     *  Expected result: returns second parameter's lower bound
     */
	@Test(timeout = 1000) // timeout: 1000
	public void testCombineFirstParameterNullLowerBound() {
		// combine two ranges  : null, (-5, 6)
		Range tempRange = Range.combine(null, new Range(-5, 6));
		double actualLowerBound = tempRange.getLowerBound();
		double expectedLowerBound = -5.0;
		assertEquals("Checking combinded lower bound when first parameter is null", expectedLowerBound, actualLowerBound, .000000001d);
	}
	
    /*
     *  This test will simulate when the first parameter is NULL
     *  Expected result: returns second parameter's upper bound
     */
	@Test(timeout = 1000) // timeout: 1000
	public void testCombineFirstParameterNullUpperBound() {
		// combine two ranges  : null, (-5, 6)
		Range tempRange = Range.combine(null, new Range(-5, 6));
		double actualUpperBound = tempRange.getUpperBound();
		double expectedUpperBound = 6.0;
		assertEquals("Checking combinded upper bound when first parameter is null", expectedUpperBound, actualUpperBound, .000000001d);
	}
	
    /*
     *  This test will simulate when the second parameter is NULL
     *  Expected result: returns first parameter's lower bound
     */
	@Test(timeout = 1000) // timeout: 1000
	public void testCombineSecondParameterNullLowerBound() {
		// combine two ranges  : (-3,7), null
		Range tempRange = Range.combine(new Range(-3, 7), null);
		double actualLowerBound = tempRange.getLowerBound();
		double expectedLowerBound = -3.0;
		assertEquals("Checking combinded lower bound when second parameter is null", expectedLowerBound, actualLowerBound, .000000001d);
	}
	
    /*
     *  This test will simulate when the second parameter is NULL
     *  Expected result: returns first parameter's upper bound
     */
	@Test(timeout = 1000) // timeout: 1000
	public void testCombineSecondParameterNullUpperBound() {
		// combine two ranges  : (-3,7), null
		Range tempRange = Range.combine(new Range(-3, 7), null);
		double actualUpperBound = tempRange.getUpperBound();
		double expectedUpperBound = 7.0;
		assertEquals("Checking combinded upper bound when second parameter is null", expectedUpperBound, actualUpperBound, .000000001d);
	}
	
    /*
     *  This test will simulate when both parameters are NULL
     *  Expected result: returns null, should not create Range object
     */
	@Test(expected = NullPointerException.class)
	public void testCombineBothNullParametersLowerBound() {
		Range tempRange = Range.combine(null, null);
		double actualLowerBound = tempRange.getLowerBound(); 
		assertNull("Checking combinded lower bound when both parameter are null", actualLowerBound);
	}
	
    /*
     *  This test will simulate when both parameters are NULL
     *  Expected result: returns null, should not create Range object
     */
	@Test(expected = NullPointerException.class)
	public void testCombineBothNullParametersUpperBound() {
		Range tempRange = Range.combine(null, null);
		double actualUpperBound = tempRange.getUpperBound(); 
		assertNull("Checking combinded upper bound when both parameter are null", actualUpperBound);
	}
	
    // ------- Test for getLowerBound() -------
	// Assumed UpperBound = 1000, LowerBound = -1000;
	
	
    /*
     *  This test will simulate when input parameter is nominal range
     *  Expected result: lower bound of input parameter
     */
	@Test(timeout = 1000) // timeout: 1000
	public void testGetLowerBoundNominal() {
		double actualLowerBound = rangeNomial.getLowerBound();
		double expectedLowerBound = -10.0;
		assertEquals("Lower bound was differ when input was nomial range", expectedLowerBound, actualLowerBound, .000000001d);
	}
	
    /*
     *  This test will simulate when input parameter is positive range
     *  Expected result: lower bound of input parameter
     */
	@Test(timeout = 1000) // timeout: 1000
	public void testGetLowerBoundPositive() {
		double actualLowerBound = rangePositive.getLowerBound();
		double expectedLowerBound = 1.0;
		assertEquals("Lower bound was differ when input was positive range", expectedLowerBound, actualLowerBound, .000000001d);
	}
	
    /*
     *  This test will simulate when input parameter is positive range, and have upper bound
     *  Expected result: lower bound of input parameter
     */
	@Test(timeout = 1000) // timeout: 1000
	public void testGetLowerBoundPositiveUB() {
		double actualLowerBound = rangePositiveUB.getLowerBound();
		double expectedLowerBound = 1;
		assertEquals("Lower bound was differ when input was positive range, and have upper bound", expectedLowerBound, actualLowerBound, .000000001d);
	}
	
    /*
     *  This test will simulate when input parameter is positive range, and have above upper bound
     *  Expected result: lower bound of input parameter
     *  
     */
	@Test(timeout = 1000) // timeout: 1000
	public void testGetLowerBoundPositiveAUB() {
		Range rangePositiveAUB = new Range (1, 1001); 	// Assumed Upper bound is 1000
		double actualLowerBound = rangePositiveAUB.getLowerBound();
		double expectedLowerBound = 1;
		assertEquals("Lower bound was differ when input was positive range, and have above upper bound", expectedLowerBound, actualLowerBound, .000000001d);
	}
	
    /*
     *  This test will simulate when input parameter is Negative range
     *  Expected result: lower bound of input parameter
     */
	@Test(timeout = 1000) // timeout: 1000
	public void testGetLowerBoundNegative() {
		double actualLowerBound = rangeNegative.getLowerBound();
		double expectedLowerBound = -100;
		assertEquals("Lower bound was differ when input was Nagative range", expectedLowerBound, actualLowerBound, .000000001d);
	}
	
    /*
     *  This test will simulate when input parameter is Negative range, and have lower bound
     *  Expected result: lower bound of input parameter
     */
	@Test(timeout = 1000) // timeout: 1000
	public void testGetLowerBoundNegativeLB() {
		double actualLowerBound = rangeNegativeLB.getLowerBound();
		double expectedLowerBound = -1000;
		assertEquals("Lower bound was differ when input was Nagative range, and have lower bound", expectedLowerBound, actualLowerBound, .000000001d);
	}
	
    /*
     *  This test will simulate when input parameter is Negative range, and have below lower bound
     *  Expected result: lower bound of input parameter
     */
	@Test(timeout = 1000) // timeout: 1000
	public void testGetLowerBoundNegativeBLB() {
		Range rangeNegativeBLB = new Range (-1001, -1); 	// Assumed lower bound is -1000
		double actualLowerBound = rangeNegativeBLB.getLowerBound();
		double expectedLowerBound = -1001;
		assertEquals("Lower bound was differ when input was Nagative range, and have below lower bound", expectedLowerBound, actualLowerBound, .000000001d);
	}
    // ------- Test for intersects(double, double) -------
	// The assumed Range lower = 5, upper = 15;
	
	/*
	 * This will test the case when two doubles are used as the parameters for intersects.
	 * The doubles will both be within the range and will satisfy the conditions that lower <= upper
	 * The expected value that will be asserted is TRUE, as the ranges should intersect.
	 */
	
	@Test(timeout = 1000) // timeout: 1000
	public void testIntersectsDoublesWithinRange() {
		boolean result = intersectRange.intersects(10.5,14.5);
		assertTrue("The expected value is TRUE but returned: "+ result,result);
	}
	
	/*
	 * This will test the case when two doubles are used as the parameters for intersects.
	 * the lower and upper limit will have the same value
	 * The values will exist on the boundary of the test range
	 * The expected value that will be asserted is TRUE, as the ranges should intersect.
	 */
	
	@Test(timeout = 1000) // timeout: 1000
	public void testIntersectsWithinRangeToRightLowerEqualsUpper() {
		boolean result = intersectRange.intersects(15,15);
		assertTrue("The expected value is TRUE but returned: "+ result,result);
	}
	
	/*
	 * This will test the case when two doubles are used as the parameters for intersects.
	 * the lower and upper limit will have the same value
	 * The values will exist outside the boundaries of the test range 
	 * The expected value that will be asserted is TRUE, as the ranges should intersect.
	 */
	
	@Test(timeout = 1000) // timeout: 1000
	public void testIntersectsOutsideRangeToLeftLowerEqualsUpper() {
		boolean result = intersectRange.intersects(-5,-5);
		assertFalse("The expected value is FALSE but returned: "+ result,result);
	}
	
	/*
	 * This will test the case when two doubles are used as the parameters for intersects.
	 * The doubles will both be within the range and will not satisfy the conditions that lower <= upper
	 * The expected value that will be asserted is FALSE, as the input is invalid.
	 */
	
	@Test(timeout = 1000) // timeout: 1000
	public void testIntersectsDoublesWithinRangeLowerGreaterThanUpper() {
		boolean result = intersectRange.intersects(14.5,10.5);
		assertFalse("The expected value is FALSE but returned: "+ result,result);
	}	
	
	/*
	 * This will test the case when two doubles are used as the parameters for intersects.
	 * the double for lower will be outside the test range on the right side
	 * The double for upper will be within the test range
	 * and will not satisfy the conditions that lower <= upper
	 * The expected value that will be asserted is FALSE, as the input is invalid.
	 */
	
	@Test(timeout = 1000) // timeout: 1000
	public void testIntersectsDoublesOnRightLowerGreaterThanUpper() {
		boolean result = intersectRange.intersects(20,10.5);
		assertFalse("The expected value is FALSE but returned: "+ result,result);
	}	
	
	/*
	 * This will test the case when two doubles are used as the parameters for intersects.
	 * the double for lower will be outside the test range on the right side
	 * The double for upper will be within the test range
	 * and will not satisfy the conditions that lower <= upper
	 * The expected value that will be asserted is FALSE, as the input is invalid.
	 */
	
	@Test(timeout = 1000) // timeout: 1000
	public void testIntersectsDoublesOnLeftLowerGreaterThanUpper() {
		boolean result = intersectRange.intersects(5.5,-5.5);
		assertFalse("The expected value is FALSE but returned: "+ result,result);
	}	
	
	
	
	
	/*
	 * This will test the case when two doubles are used as the parameters for intersects.
	 * One double will be within the range on the right side and the doubles will satisfy the conditions that lower <= upper 
	 * The expected value that will be asserted is TRUE, as the ranges should intersect.
	 */
	
	@Test(timeout = 1000) // timeout: 1000
	public void testIntersectsWithinRangeToRight() {
		boolean result = intersectRange.intersects(14.5,20);
		assertTrue("The expected value is TRUE but returned: "+ result,result);
	}
	
	
	
	/*
	 * This will test the case when two doubles are used as the parameters for intersects.
	 * One double will be within the range on the left side and the doubles will satisfy the conditions that lower <= upper
	 * The expected value that will be asserted is TRUE, as the ranges should intersect.
	 */
	
	@Test(timeout = 1000) // timeout: 1000
	public void testIntersectsWithinRangeToLeft() {
		boolean result = intersectRange.intersects(-5.2,5.2);
		assertTrue("The expected value is TRUE but returned: "+ result,result);
	}
	
	/*
	 * This will test the case when two doubles are used as the parameters for intersects.
	 * the upper value will be equal to the bound of the range on the left side and 
	 * the doubles will satisfy the conditions that lower <= upper 
	 * The expected value that will be asserted is TRUE, as the ranges should intersect.
	 */
	
	@Test(timeout = 1000) // timeout: 1000
	public void testIntersectsEqualRangeToLeft() {
		boolean result = intersectRange.intersects(-5.2,5);
		assertTrue("The expected value is TRUE but returned: "+ result,result);
	}
	
	/*
	 * This will test the case when two doubles are used as the parameters for intersects.
	 * The doubles will be outside the test range, and the doubles will satisfy the conditions that lower <= upper
	 * The expected value that will be asserted is FALSE, as the ranges should not intersect.
	 */
	
	@Test(timeout = 1000) // timeout: 1000
	public void testIntersectsOutsideRangeToLeft() {
		boolean result = intersectRange.intersects(-15.5,-5);
		assertFalse("The expected value is FALSE but returned: "+ result,result);
	}
	// ------- End of tests for intersects(double, double) -------		
	
	
		//	 ------- Test for getLength() -------
	/*
	 * This will test the getLength function by inputting two inputs as positive numbers
	 * 
	 */
	@Test(timeout = 1000) // timeout: 1000
	public void testGetLengthPosPosNum() {
		exampleRange2 = new Range(1, 100);
	    assertEquals("The length of the range is:",
	    99, exampleRange2.getLength(), .000000001d); //expected output: 100-1=99
	}
	
	/*
	 * This will test the getLength function by inputting first number as negative and second number as postive
	 * 
	 */
	@Test(timeout = 1000) // timeout: 1000
	public void testGetLengthNegPosNum() {
		exampleRange2 = new Range(-10, 5);
	    assertEquals("The length of the range is:",
	    15, exampleRange2.getLength(), .000000001d); 
	}
	
	/*
	 * This will test the getLength function by inputting two inputs as negative numbers
	 * 
	 */
	@Test(timeout = 1000) // timeout: 1000
	public void testGetLengthNegNegNum() {
		exampleRange2 = new Range(-6, -5);
	    assertEquals("The length of the range is:",
	    1, exampleRange2.getLength(), .000000001d); 
	}
	
	/*
	 * This will test the getLength function by inputting two inputs as zeros
	 * 
	 */
	@Test(timeout = 1000) // timeout: 1000
	public void testGetLengthZeroZeroNum() {
		exampleRange2 = new Range(0, 0);
	    assertEquals("The length of the range is:",
	    0, exampleRange2.getLength(), .000000001d); 
	}
	
	/*
	 * This will test the getLength function by inputting first number as zero and second number as positive number
	 * 
	 */
	@Test(timeout = 1000) // timeout: 1000
	public void testGetLengthZeroPosoNum() {
		exampleRange2 = new Range(0, 5);
	    assertEquals("The length of the range is:",
	    5, exampleRange2.getLength(), .000000001d); 
	}
	
	/*
	 * This will test the getLength function by inputting first number as negative number and second number as zero
	 * 
	 */
	@Test(timeout = 1000) // timeout: 1000
	public void testGetLengthNegZeroNum() {
		exampleRange2 = new Range(-8, 0);
	    assertEquals("The length of the range is:",
	    8, exampleRange2.getLength(), .000000001d); 
	}
	
	// ------- End of tests for getLength() -------	
	
	// ------- Test for contains(double):boolean-------
	// The assumed Range lower = -10, upper = 10; 
	
	/*
    	 *  This test will simulate when input is above upper boundary 
     	 *  Expected result: Returns false
     	 */
    	@Test(timeout = 1000) // timeout: 1000
	public void testContainsAboveUpperBoundaryOfRange() {
		boolean actualResult = rangeNomial.contains(11);
		boolean expectedResult = false;
		assertEquals("Checking when input is above upper boundary", expectedResult, actualResult);
	}
    
    	/*
     	*  This test will simulate when input is at upper boundary 
     	*  Expected result: Returns true 
     	*/
    	@Test(timeout = 1000) // timeout: 1000
	public void testContainsAtUpperBoundaryOfRange() {
		boolean actualResult = rangeNomial.contains(10);
		boolean expectedResult = true;
		assertEquals("Checking when input is at upper boundary", expectedResult, actualResult);
	}
   
   	/*
   	 *  This test will simulate when input is at just below upper boundary
 	 *  Expected result: Returns true 
	 */
   	 @Test(timeout = 1000) // timeout: 1000
	public void testContainsBelowUpperBoundaryOfRange() {
		boolean actualResult = rangeNomial.contains(9);
		boolean expectedResult = true;
		assertEquals("Checking when input is below upper boundary", expectedResult, actualResult);
	}
   
	/*
	 *  This test will simulate when input is in the middle of range
	 *  Expected result: Returns true 
	 */
	@Test(timeout = 1000) // timeout: 1000
	public void testContainsMiddleOfRange() {
		boolean actualResult = rangeNomial.contains(0);
		boolean expectedResult = true;
		assertEquals("Checking when input is in the middle of range", expectedResult, actualResult);
	}
   
   	/*
    	*  This test will simulate when input is at just above lower boundary 
    	*  Expected result: Returns true 
   	*/
    	@Test(timeout = 1000) // timeout: 1000
	public void testContainsAboveLowerBoundaryOfRange() {
		boolean actualResult = rangeNomial.contains(-9);
		boolean expectedResult = true;
		assertEquals("Checking when input is above lower boundary ", expectedResult, actualResult);
	}
   
   	/*
    	*  This test will simulate when input is at lower boundary 
    	*  Expected result: Returns true 
   	*/
    	@Test(timeout = 1000) // timeout: 1000
	public void testContainsAtLowerBoundaryOfRange() {
		boolean actualResult = rangeNomial.contains(-10);
		boolean expectedResult = true;
		assertEquals("Checking when input is at lower boundary", expectedResult, actualResult);
	}
    
    	/*
     	*  This test will simulate when input is below lower boundary
     	*  Expected result: Returns false
     	*/
   	@Test(timeout = 1000) // timeout: 1000
	public void testContainsBelowLowerBoundaryOfRange() {
		boolean actualResult = rangeNomial.contains(-11);
		boolean expectedResult = false;
		assertEquals("Checking when input is below lower boundary", expectedResult, actualResult);
	}
	
	// ------- End of tests for contains(double):boolean -------	
	
	// -----------------------------------------------------------------------------------------
	// End of Test Code LAB2
	// -----------------------------------------------------------------------------------------
   		
   	
	// -----------------------------------------------------------------------------------------
	// Start of Test Code LAB3
	// -----------------------------------------------------------------------------------------
   		
	// ------- Test for shiftWithNoZeroCrossing(double, double): double -------
   	// *** duplicated with shift(Range base, double delta): Range ***
   	
   	// Statement Coverage	: 100%
   	// Branch Coverage		: 100%
   	
    /*
   	 *  This test will simulate when input Range of (lower bound + delta < 0) where lower bound > 0
 	 *  Expected result: Range(0, UpperBound + delta)
     */
 
   	@Test(timeout = 1000)
   	public void testShiftWithNoZeroCrossingValueGreaterThanZeroUpperBound() {
   		testRange = new Range(5, 10);												
   		Range shiftedRange = Range.shift(testRange, -6);		// 5 + (-6), 10 + (-6)
   		assertEquals("The shifted upperbound value should be ", 4, shiftedRange.getUpperBound(), .000000001d);
   	}
   	
   	@Test(timeout = 1000)
   	public void testShiftWithNoZeroCrossingValueGreaterThanZeroLowerBound() {
   		testRange = new Range(5, 10);
   		Range shiftedRange = Range.shift(testRange, -6);		// 5 + (-6), 10 + (-6)
   		assertEquals("The shifted lowerbound value should be ", 0, shiftedRange.getLowerBound(), .000000001d);
   	}
   	
    /*
   	 *  This test will simulate when input Range of upper bound + delta > 0 when upper bound < 0
 	 *  Expected result: Range(LowerBound + delta, 0)
     */

   	@Test(timeout = 1000)
   	public void testShiftWithNoZeroCrossingValueLessThanZeroUpperBound() {
   		testRange = new Range(-10, -5);
   		Range shiftedRange = Range.shift(testRange, 6);			// -10 + (+6), -5 + (+6)
   		assertEquals("The shifted upperbound value should be ", 0, shiftedRange.getUpperBound(), .000000001d);
   	}
   	
   	@Test(timeout = 1000)
   	public void testShiftWithNoZeroCrossingValueLessThanZeroLowerBound() {
   		testRange = new Range(-10, -5);
   		Range shiftedRange = Range.shift(testRange, 6);			// -10 + (+6), -5 + (+6)
   		assertEquals("The shifted lowerbound value should be ", -4, shiftedRange.getLowerBound(), .000000001d);
   	}
   	
    /*
   	 *  This test will simulate when input Range at (0,0)
 	 *  Expected result: Range(LowerBound + delta, UpperBound + delta)
     */
   	
   	@Test(timeout = 1000)
   	public void testShiftWithNoZeroCrossingValueEqualZeroUpperBound() {
   		testRange = new Range(0, 0);
   		Range shiftedRange = Range.shift(testRange, 6);			// 0 + (+6), 0 + (+6)
   		assertEquals("The shifted upperbound value should be ", 6, shiftedRange.getUpperBound(), .000000001d);
   	}
   	
   	@Test(timeout = 1000)
   	public void testShiftWithNoZeroCrossingValueEqualZeroLowerBound() {
   		testRange = new Range(0, 0);
   		Range shiftedRange = Range.shift(testRange, 6);			// 0 + (+6), 0 + (+6)
   		assertEquals("The shifted lowerbound value should be ", 6, shiftedRange.getLowerBound(), .000000001d);
   	}
   	
	// ------- Test for hashCode(): int -------
   	
   	// Statement Coverage	: 100%
   	// Branch Coverage		: 100% (no branch)
   	
   	@Test(timeout = 1000)
   	public void testHashCode() {
   		testRange = new Range(-1, 1);
   		Integer hash = Integer.valueOf(testRange.hashCode());
   		assertTrue("Hash does not generated", hash instanceof Integer);
   	}
   	
	// ------- Test for combineIgnoringNaN(Range range1, Range range2): Range -------
   	
   	// Statement Coverage	: 100%
   	// Branch Coverage		: 92.9%
   	
    /*
   	 *  This test will simulate when input Range 1 is Null, Range 2 is not Null but NaN
 	 *  Expected result: null
     */
   	@Test(timeout = 1000)
   	public void testCombineIgnoringNaN_R1Null_R2NotNullNaN() {
   		double zero = 0;
   		double NaN = zero/zero;									// creating not a number
   		Range r1 = null;										// range 1 will be null range
   		Range r2 = new Range (NaN, NaN);						// range 2 will be NaN range
   		Range actualRange = Range.combineIgnoringNaN(r1, r2);	// combine null range with not null and NaN range
   		assertNull("The expected object should be Null", actualRange);
   	}
   	
    /*
   	 *  This test will simulate when input Range 1 is Null, Range 2 is Null
 	 *  Expected result: null
     */
   	@Test(timeout = 1000)
   	public void testCombineIgnoringNaN_R1Null_R2Null() {
   		Range r1 = null;										// range 1 will be null range
   		Range r2 = null;										// range 2 will be null range
   		Range actualRange = Range.combineIgnoringNaN(r1, r2);	// combine null range with not null and null range
   		assertNull("The expected object should be Null", actualRange);
   	}
   	
    /*
   	 *  This test will simulate when input Range 1 is Null, Range 2 is Normal
 	 *  Expected result: Range 2
     */
   	@Test(timeout = 1000)
   	public void testCombineIgnoringNaN_R1Null_R2Normal() {
   		Range r1 = null;										// range 1 will be null range
   		Range r2 = new Range (-1,1);							// range 2 will be normal range
   		Range actualRange = Range.combineIgnoringNaN(r1, r2);	// combine null range with not null and normal range
   		Range expectedRange = new Range (-1,1);
   		assertEquals("The returned object should be Range(-1,1)", expectedRange, actualRange );
   	}
   	
    /*
   	 *  This test will simulate when input Range 1 is notNull but NaN, Range 2 is null
 	 *  Expected result: null
     */
   	@Test(timeout = 1000)
   	public void testCombineIgnoringNaN_R1NotNullNaN_R2Null() {
   		double zero = 0;
   		double NaN = zero/zero;									// creating not a number
   		Range r1 = new Range (NaN, NaN);						// range 1 will be NaN range
   		Range r2 = null;										// range 2 will be null range
   		Range actualRange = Range.combineIgnoringNaN(r1, r2);	// combine  not null and NaN range null range
   		assertNull("The expected object should be Null", actualRange);
   	}
   	
    /*
   	 *  This test will simulate when input Range 1 is Normal, Range 2 is Null
 	 *  Expected result: Range 1
     */
   	@Test(timeout = 1000)
   	public void testCombineIgnoringNaN_R1Normal_R2Null() {
   		Range r1 = new Range (-1,1);							// range 1 will be normal range
   		Range r2 = null;										// range 2 will be null range
   		Range actualRange = Range.combineIgnoringNaN(r1, r2);	// combine normal range with null range;
   		Range expectedRange = new Range (-1,1);
   		assertEquals("The returned object should be Range(-1,1)", expectedRange, actualRange );
   	}
   	
    /*
   	 *  This test will simulate when input Range 1 is Null, Range 2 is Null
 	 *  Expected result: null
     */
   	@Test(timeout = 1000)
   	public void testCombineIgnoringNaN_BothNaN() {
   		double zero = 0;
   		double NaN = zero/zero;									// creating not a number
   		Range r1 = new Range (NaN, NaN);						// range 1 will be NaN range
   		Range r2 = new Range (NaN, NaN);						// range 2 will be NaN range
   		Range actualRange = Range.combineIgnoringNaN(r1, r2);	// combine NaN range with NaN range;
   		assertNull("The expected object should be Null", actualRange);
   	}
   	
    /*
   	 *  This test will simulate when input Range 1 is Normal, Range 2 is Normal
 	 *  Expected result: Combined Range
     */
   	@Test(timeout = 1000)
   	public void testCombineIgnoringNaN_BothNormal() {
   		Range r1 = new Range(-2 , 1);							// range 1 will be normal range
   		Range r2 = new Range(-1 , 2);							// range 2 will be normal range
   		Range actualRange = Range.combineIgnoringNaN(r1, r2);	// combine null range with null range;
   		Range expectedRange = new Range(-2,2);
   		assertEquals("The returned object should be Range(-2,2)", expectedRange, actualRange );
   	}
 
   	
   	
	// ------- min(double d1, double d2): double -------
   	
   	// Statement Coverage	: 100%
   	// Branch Coverage		: 100% 
   	
    /*
   	 *  This test will simulate when input d1 is Normal, Range d2 is Normal
   	 *  Also, this test will use combineIgnoreingNaN function to test Range.min(double d1, double d2)
 	 *  Expected result: min value should be set as new range
     */
   	
   	@Test(timeout = 1000)
   	public void testMin_BothNormal() {
   		double d1 = -20;
   		double d2 = 10;
   		Range r1 = new Range(-10,10);							// created to call combineIgnoreingNaN method
   		Range actualRange = Range.combineIgnoringNaN(r1, new Range(d1,d2));	
   		Range expectedRange = new Range(-20,10);
   		assertEquals("The returned object should be Range(-20,10)", expectedRange, actualRange );
   	}
   	
    /*
   	 *  This test will simulate when input d1 is Normal, Range d2 is NaN
   	 *  Also, this test will use combineIgnoreingNaN function to test Range.min(double d1, double d2)
 	 *  Expected result: min value should be set as new range
     */
   	
   	@Test(timeout = 1000)
   	public void testMin_d1NaN_d2Normal() {
   		double zero = 0;
   		double NaN = zero/zero;									// creating not a number
   		double d2 = 10;
   		Range r1 = new Range(-10,10);							// created to call combineIgnoreingNaN method
   		Range actualRange = Range.combineIgnoringNaN(r1, new Range(NaN,d2));	
   		Range expectedRange = new Range(-10,10);
   		assertEquals("The returned object should be Range(-10,10)", expectedRange, actualRange );
   	}
   	
    /*
   	 *  This test will simulate when input d1 is NaN, Range d2 is Normal
   	 *  Also, this test will use combineIgnoreingNaN function to test Range.min(double d1, double d2)
 	 *  Expected result: Range 1
     */
   	
   	@Test(timeout = 1000)
   	public void testMin_d1NaN_d2NaN() {
   		double zero = 0;
   		double NaN = zero/zero;									// creating not a number
   		Range r1 = new Range(-10,10);							// created to call combineIgnoreingNaN method
   		Range actualRange = Range.combineIgnoringNaN(r1, new Range(NaN,NaN));	
   		Range expectedRange = new Range(-10,10);
   		assertEquals("The returned object should be Range(-10,10)", expectedRange, actualRange );
   	}
   	
   	
	// ------- isNaNRange(): boolean -------
   	
   	// Statement Coverage	: 100%
   	// Branch Coverage		: 100% 
   	
    /*
   	 *  This test will simulate when input ranges lower bound is normal, upper bound is Normal
 	 *  Expected result: False
     */
   	
   	@Test(timeout = 1000)
   	public void testIsNaNRange_bothNormal() {
   		testRange = new Range(-1,1);
   		boolean result = testRange.isNaNRange();
   		assertFalse("false should be returned with non-NaN range", result);
   	}
   	
    /*
   	 *  This test will simulate when input ranges lower bound is NaN, upper bound is Normal
 	 *  Expected result: False
     */
   	
   	@Test(timeout = 1000)
   	public void testIsNaNRange_lbNaN_ubNormal() {
   		double zero = 0;
   		double NaN = zero/zero;									// creating not a number
   		testRange = new Range(NaN,1);							// lb is NaN, but still non-NaN range
   		boolean result = testRange.isNaNRange();
   		assertFalse("false should be returned with non-NaN range", result);
   	}
   	
    /*
   	 *  This test will simulate when input ranges lower bound is Normal, upper bound is NaN
 	 *  Expected result: False
     */
   	
   	@Test(timeout = 1000)
   	public void testIsNaNRange_lbNormal_ubNaN() {
   		double zero = 0;
   		double NaN = zero/zero;									// creating not a number
   		testRange = new Range(-1,NaN);							// ub is NaN, but still non-NaN range
   		boolean result = testRange.isNaNRange();
   		assertFalse("false should be returned with non-NaN range", result);
   	}
   	
    /*
   	 *  This test will simulate when input ranges lower bound is NaN, upper bound is NaN
 	 *  Expected result: True
     */
 
   	@Test(timeout = 1000)
   	public void testIsNaNRange_lbNaN_ubNaN() {
   		double zero = 0;
   		double NaN = zero/zero;									// creating not a number
   		testRange = new Range(NaN,NaN);							// ub and lb are NaN,NaN range
   		boolean result = testRange.isNaNRange();
   		assertTrue("True should be returned with NaN range", result);
   	}
   	
   	// ------- Additional Tests for combine(Range range1, Range range2): Range from LAB2 -------
   	// Statement Coverage	: 100% --> 100%
   	// Branch Coverage		: 100% --> 100%
   	



   	// ------- Additional Tests for getLowerBound(): double from LAB2 -------
   	// *** unable to reach uncovered parts due to code structures ***
   	// Statement Coverage	: 40% --> ??%
   	// Branch Coverage		: 50% --> ??%
   	
    /*
   	 *  This test will simulate when input Range is invalid when (upper < lower)
 	 *  Expected result: IllegalArgumentException
     */
   	
	@Test(expected = IllegalArgumentException.class) 
	public void testGetLowerBoundwithIllegalRange() {
		Range tempRange = new Range(-100,10); // ERROR THROWN HERE
		double actualLowerBound = tempRange.getLowerBound();
		assertNotNull("method did not throw IllegalArgumentException when input Range is Illegal (upper < lower)", actualLowerBound);
	}
	
	
	// ------- Tests for getUpperBound(): double -------
   	
   	/*
     *  This test will simulate when input range's lower bound is lower than range's upper bound
     *  Expected result: upper bound of input range
     */
   	@Test(timeout = 1000) // timeout: 1000
	public void testGetUpperBoundNominal() {
		double actualUpperBound = rangeNomial.getUpperBound();
		double expectedUpperBound = 10.0;
		assertEquals("Upper bound was different when input was nomial range", expectedUpperBound, actualUpperBound, .000000001d);
	}
   	
   	// ------- End of tests for getUpperBound(): double -------	
   	
   	// ------- Test for scale(Range base, double factor): Range -------
   	
   	/*
     *  This test will simulate when input base Range is null
     *  Expected result: Exception thrown
     */
   	@Test(expected = IllegalArgumentException.class) // expecting an exception
	public void testScaleRangeNull() {
		Range.scale(null,  1.0);
	}
   	
   	/*
     *  This test will simulate when input argument factor is negative
     *  Expected result: Exception thrown
     */
   	@Test(expected = IllegalArgumentException.class) // expecting an exception
	public void testScaleNegativeFactor() {
		Range.scale(rangeNomial,  -3.0);
	}
   	
   	/*
     *  This test will simulate when input argument base Range is nomial and factor is positive
     *  Expected result: new valid Range returned
     */
   	@Test(timeout = 1000) // timeout: 1000
	public void testScaleNomialRangePositiveFactor() {
		Range actualRange = Range.scale(rangeNomial, 2.0);
		double expectedUpperBound = 20.0;
		double actualUpperBound = actualRange.getUpperBound();
		double expectedLowerBound = -20.0;
		double actualLowerBound = actualRange.getLowerBound();
		
		assertEquals("Upper Bound was different when input base range was nomial and factor was positive", expectedUpperBound, actualUpperBound, .000000001d);
		assertEquals("Lower Bound was different when input base range was nomial and factor was positive", expectedLowerBound, actualLowerBound, .000000001d);
	}
   	
   	// ------- End of tests for scale(Range base, double factor): Range -------	
   	
	  	
	 // ------- Test for constrain(double):double-------
	   	
	   	/* This test will test input that is near the upper range */
	   	@Test
	   	public void testConstrainInputThree() {
	   		assertEquals("The value of 3.0 should be closest to range 1.0", 1.0, exampleRange.constrain(3.0), .000000001d);
	   	}
	   	
	   	/* This test will test input that is the upper range */
	   	@Test
	   	public void testConstrainInputOne() {
	   		assertEquals("The value of 1.0 should be closest to range 1.0", 1.0, exampleRange.constrain(1.0), .000000001d);
	   	}
	   	
	   	/* This test will test input that is the lower range */
	   	@Test
	   	public void testConstrainInputNegativeOne() {
	   		assertEquals("The value of -1.0 should be closest to range -1.0", -1.0, exampleRange.constrain(-1.0), .000000001d);
	   	}
	   	
	   	/* This test will test input of zero */
	   	@Test
	   	public void testConstrainInputZero() {
	   		assertEquals("The value of 0.0 should return 0.0", 0.0, exampleRange.constrain(0.0), .000000001d);
	   	}
	   	
	   	/* This test will test input -5.0 which is near lower range */
	   	@Test
	   	public void testConstrainInputNegativeFive() {
	   		assertEquals("The value of -5.0 be closest to range -1.0", -1.0, exampleRange.constrain(-5.0), .000000001d);
	   	}
	   	
	   	/* This test will test input -5.0 which is near lower range */
	   	@Test
	   	public void testConstrainInputNaN() {
	   		assertEquals("The value of NaN should return NaN", Double.NaN, exampleRange.constrain(Double.NaN), .000000001d);
	   	}
	   	
		 // ------- End of Test for constrain(double):double-------
	   	
	   	
	 // ------- Test for toString():String-------
	   	
		/* This test will test example range of [-1,1] to be converted to a string */
	   	@Test
	   	public void testToStringNormalRange() {
	   		assertEquals("For range [-1,1], it should be converted as Range[-1,1]", "Range[-1.0,1.0]", exampleRange.toString());
	   	}
	   	
	   	/* This test will test example range of [-1,1] to be converted to a string */
	   	@Test
	   	public void testToStringNaNRange() {
	   		exampleRange2 = new Range(Double.NaN, Double.NaN);
	   		assertEquals("For range [NaN,NaN], it should be converted as Range[NaN,NaN]", "Range[NaN,NaN]", exampleRange2.toString());
	   	}
	   	
	    // ------- End of Test for toString(): String-------
	   	
	 // ------- Test for equals(Object): boolean-------
	   	
	   	//this test sends the same range and see if both are equal or not
	   	@Test
	   	public void testEqualsSameRangeObject() {
	   		assertTrue("The range of [-1, 1] should equal to [-1, 1] ", exampleRange.equals(exampleRange));
	   	}
	   	
	   	//this test sends an object that is not of type of range
	   	@Test
	   	public void testEqualsNotObject() {
	   		
	   		assertFalse("A double is not a range object ", rangeNomial.equals((Double) 1.5d));
	   	}
	   	
	  //this test sees if the lower bound of sent range matches the lower bound of the object range
	   	@Test
	   	public void testEqualsLowerBoundNotSame() {
	   		
	   		assertFalse("The lower bound of range does not match with sent range ", exampleRange.equals(new Range(-5, 1)));
	   	}
	   	
	  //this test sees if the upper bound of sent range matches the upper bound of the object range
	   	@Test
	   	public void testEqualsUpperBoundNotSame() {
	   		
	   		assertFalse("The upper bound of range does not match with sent range ", exampleRange.equals(new Range(-1, 5)));
	   	}
	   	
	  //this test sees equals method can recognize NaN as a range and say it is equal
	   	@Test
	   	public void testEqualsNaNObject() {
	   		exampleRange2 = new Range(Double.NaN, Double.NaN);
	   		assertTrue("The range of NaN sent matches with the NaN range object ", exampleRange2.equals(exampleRange2));
	   	}
	   	
	  //this test will test two completely different ranges for equality
	   	@Test
	   	public void testEqualsDiffObject() {
	   		assertFalse("The ranges do not match ", exampleRange.equals(rangeNomial));
	   	}
	   	
	 // ------- End of Test for equals(Object): boolean-------  	
	   	
	   	
	// ------- Test for max(double d1, double d2): double-------

		
	   	//testing the max function by sending two positive ranges
	   	@Test
	   	public void testMaxBothNumsPos() {
	   		//exampleRange2 = exampleRange2.combineIgnoringNaN(new Range(4,5), new Range(2,4));
	   		
//	   		Range outputRange = Range.combineIgnoringNaN(new Range(4,5), new Range(2,4));
//	   		assertEquals("The max of 5 and 4 is 5 ", "5.0", outputRange.getUpperBound());
	   		
	   		// created to call combineIgnoreingNaN method
	   		Range actualRange = Range.combineIgnoringNaN(new Range(-5,4), new Range(-5,2));	
	   		Range expectedRange = new Range(-5,4);
	   		assertEquals("The returned object should be Range(-5,4)", expectedRange, actualRange );
	   		
	   	}
	   	
	   	//testing the max function by sending a NaN argument
	   	@Test
	   	public void testMaxOneNumNaN() {
	   		//exampleRange2 = exampleRange2.combineIgnoringNaN(new Range(4,5), new Range(2,4));
//	   		Range outputRange = Range.combineIgnoringNaN(new Range(4,Double.NaN), new Range(2,4));
//	   		assertEquals("The max of NaN and 4 is 4 ", "4.0", outputRange.getUpperBound());
	   		
	   		// created to call combineIgnoreingNaN method
	   		Range actualRange = Range.combineIgnoringNaN(new Range(-5,4), new Range(Double.NaN,2));	
	   		Range expectedRange = new Range(-5,4);
	   		assertEquals("The returned object should be Range(-5,4)", expectedRange, actualRange );
	   	}
	   	
	  //testing the max function by sending a both as NaN
	   	@Test
	   	public void testMaxBothNumNaN() {
	   		//exampleRange2 = exampleRange2.combineIgnoringNaN(new Range(4,5), new Range(2,4));
//	   		Range outputRange = Range.combineIgnoringNaN(new Range(4,6), new Range(2,Double.NaN));
//	   		assertEquals("The max of 6 and NaN is 6 ", "6.0", outputRange.getUpperBound());
			
	   		// created to call combineIgnoreingNaN method
	   		Range actualRange = Range.combineIgnoringNaN(new Range(-5,4), new Range(Double.NaN,Double.NaN));	
	   		Range expectedRange = new Range(-5,4);
	   		assertEquals("The returned object should be Range(-5,4)", expectedRange, actualRange );
	   		
	   	} 	
	   	
	// ------- End of Test for max(double d1, double d2): double-------  	
	
	   	// ------- Test for expand(Range, double, double)-------
 	
 	/*
 	 *  This test will simulate when the input is standard 
     *  Expected result: returns the expected range
     */
    @Test(timeout = 1000) // timeout: 1000
 	public void testExpandBase() {
     	Range RangeExpand = new Range(1,2);
     	Range expanded = Range.expand(RangeExpand, 2, 0.5);
 		assertEquals("The expected lower bound is -1", -1, expanded.getLowerBound(),.000000001d);
 		assertEquals("The expected upper bound is 2.5", 2.5, expanded.getUpperBound(),.000000001d);
 	}
     	
    
 	/*
 	 *  This test will simulate when the input is null 
  	 *  Expected result: Throws InvalidParameterException
  	 */
 	@Test
	public void testExpandNullRange() {
 		try {
 		 	Range RangeExpand = null;
 		 	Range expanded = Range.expand(RangeExpand, 2, 0.5);
 		}catch(Exception e) {
 		 	assertEquals("InvalidParameterException was thrown", InvalidParameterException.class, e.getClass());
 		}
	}
 	/*
 	 *  This test will simulate when the input is standard, but negative
     *  Expected result: returns the expected range
     */
    @Test(timeout = 1000) // timeout: 1000
 	public void testExpandBaseNegative() {
     	Range RangeExpand = new Range(1,2);
     	Range expanded = Range.expand(RangeExpand, -0.5, -0.5);
 		assertEquals("The expected lower bound is 1.5", 1.5, expanded.getLowerBound(),.000000001d);
 		assertEquals("The expected upper bound is 1.5", 1.5, expanded.getUpperBound(),.000000001d);
 	}
    
 	/*
 	 *  This test will simulate when the upperMargin is smaller than the lowerMargin
     *  Expected result: returns the expected range
     */
    @Test(timeout = 1000) // timeout: 1000
 	public void testExpandBaseUpperSmallerThanLower() {
     	Range RangeExpand = new Range(1,2);
     	Range expanded = Range.expand(RangeExpand, 5, 2);
 		assertEquals("The expected lower bound is -4", -4, expanded.getLowerBound(),.000000001d);
 		assertEquals("The expected upper bound is 4", 4, expanded.getUpperBound(),.000000001d);
 	}
    
 	/*
 	 *  This test will simulate when the upperMargin is smaller than the lowerMargin
 	 *  
     *  Expected result: returns the expected range
     */
    @Test(timeout = 1000) // timeout: 1000
 	public void testExpandBaseResultLowerGreaterThanUpper() {
     	Range RangeExpand = new Range(1,2);
     	Range expanded = Range.expand(RangeExpand, -2, 0.5);
 		assertEquals("The expected lower bound is 2.25", 2.25, expanded.getLowerBound(),.000000001d);
 		assertEquals("The expected upper bound is 3", 3, expanded.getUpperBound(),.000000001d);
 	}
     	
     	
     // ------- End of tests for expand(Range, double, double) -------
   	
   	// ------- Test for expandToInclude(Range, double)-------   	
 	/*
 	 *  This test will simulate when the input is standard and on the right side of the range
     *  Expected result: returns the upper and lower bounds
     */
    @Test(timeout = 1000) // timeout: 1000
 	public void testExpandToIncludeUpper() {
     	Range RangeExpand = new Range(1,2);
     	Range expanded = Range.expandToInclude(RangeExpand, 5);
 		assertEquals("The expected lower bound is 1", 1, expanded.getLowerBound(),.000000001d);
 		assertEquals("The expected upper bound is 5", 5, expanded.getUpperBound(),.000000001d);
 	}
    
 	/*
 	 *  This test will simulate when the input is standard and on the left side of the range 
     *  Expected result: returns the expected upper and lower bounds
     */
    @Test(timeout = 1000) // timeout: 1000
 	public void testExpandToIncludeLower() {
     	Range RangeExpand = new Range(1,2);
     	Range expanded = Range.expandToInclude(RangeExpand, 0);
 		assertEquals("The expected lower bound is 0", 0, expanded.getLowerBound(),.000000001d);
 		assertEquals("The expected upper bound is 2", 2, expanded.getUpperBound(),.000000001d);
 	}
    
 	/*
 	 *  This test will simulate when the input is negative and on the left side of the range 
     *  Expected result: returns the expected upper and lower bounds
     */
    @Test(timeout = 1000) // timeout: 1000
 	public void testExpandToIncludeNegative() {
     	Range RangeExpand = new Range(1,2);
     	Range expanded = Range.expandToInclude(RangeExpand, -5);
 		assertEquals("The expected lower bound is -5", -5, expanded.getLowerBound(),.000000001d);
 		assertEquals("The expected upper bound is 2", 2, expanded.getUpperBound(),.000000001d);
 	}
    
 	/*
 	 *  This test will simulate when the input is positive and the range is null
     *  Expected result: returns the expected upper and lower bounds
     */
    @Test(timeout = 1000) // timeout: 1000
 	public void testExpandToIncludeNull() {
     	Range RangeExpand = null;
     	Range expanded = Range.expandToInclude(RangeExpand, 5);
 		assertEquals("The expected lower bound is 5", 5, expanded.getLowerBound(),.000000001d);
 		assertEquals("The expected upper bound is 5", 5, expanded.getUpperBound(),.000000001d);
 	}
     	
 	/*
 	 *  This test will simulate when the input is within the Range
     *  Expected result: returns the expected upper and lower bounds
     */
    @Test(timeout = 1000) // timeout: 1000
 	public void testExpandToIncludeValueWithin() {
     	Range RangeExpand = new Range(1,5);
     	Range expanded = Range.expandToInclude(RangeExpand, 3);
 		assertEquals("The expected lower bound is 1", 1, expanded.getLowerBound(),.000000001d);
 		assertEquals("The expected upper bound is 5", 5, expanded.getUpperBound(),.000000001d);
 	}
    // ------- End of tests for expandToInclude(Range, double) -------
    // ------- Test for shift(Range, double):Range-------   
 	/*
 	 *  This test will simulate when delta is positive 
     *  Expected result: returns the expected upper and lower bounds
     */
    @Test(timeout = 1000) // timeout: 1000
 	public void testShiftPositiveRangePositive() {
     	Range RangeShift = new Range(1,2);
     	Range shifted = Range.shift(RangeShift, 5);
 		assertEquals("The expected lower bound is 6", 6, shifted.getLowerBound(),.000000001d);
 		assertEquals("The expected upper bound is 7", 7, shifted.getUpperBound(),.000000001d);
 	}
    
 	/*
 	 *  This test will simulate when delta is negative 
     *  Expected result: returns the expected upper and lower bounds
     */
    @Test(timeout = 1000) // timeout: 1000
 	public void testShiftPositiveRangeNegative() {
     	Range RangeShift = new Range(1,2);
     	Range shifted = Range.shift(RangeShift, -5);
 		assertEquals("The expected lower bound is 0", 0, shifted.getLowerBound(),.000000001d);
 		assertEquals("The expected upper bound is 0", 0, shifted.getUpperBound(),.000000001d);
 	}
    
 	/*
 	 *  This test will simulate when delta is positive in a negative range
     *  Expected result: returns the expected upper and lower bounds
     */
    @Test(timeout = 1000) // timeout: 1000
 	public void testShiftNegativeRangePositive() {
     	Range RangeShift = new Range(-2,-1);
     	Range shifted = Range.shift(RangeShift, 5);
 		assertEquals("The expected lower bound is 0", 0, shifted.getLowerBound(),.000000001d);
 		assertEquals("The expected upper bound is 0", 0, shifted.getUpperBound(),.000000001d);
 	}
    
 	/*
 	 *  This test will simulate when delta is negative in a negative range
     *  Expected result: returns the expected upper and lower bounds
     */
    @Test(timeout = 1000) // timeout: 1000
 	public void testShiftNegativeRangeNegative() {
     	Range RangeShift = new Range(-2,-1);
     	Range shifted = Range.shift(RangeShift, -5);
 		assertEquals("The expected lower bound is -7", -7, shifted.getLowerBound(),.000000001d);
 		assertEquals("The expected upper bound is -6", -6, shifted.getUpperBound(),.000000001d);
 	}
    
 	/*
 	 *  This test will simulate when the Range is null 
     *  Expected result: IllegalParameterException is thrown
     */
    @Test(timeout = 1000) // timeout: 1000
 	public void testShiftNullRange() {
    	try {
    		Range RangeShift = null;
         	Range shifted = Range.shift(RangeShift, 5);	
    	}
    	catch(Exception e){
    	 	assertEquals("InvalidParameterException was thrown", InvalidParameterException.class, e.getClass());
    	}
  
 	}
    
 	/*
 	 *  This test will simulate when delta is large
     *  Expected result: returns the expected upper and lower bounds
     */
    @Test(timeout = 1000) // timeout: 1000
 	public void testShiftLargeDelta() {
     	Range RangeShift = new Range(1,2);
     	Range shifted = Range.shift(RangeShift, 500);
 		assertEquals("The expected lower bound is 501", 501, shifted.getLowerBound(),.000000001d);
 		assertEquals("The expected upper bound is 502", 502, shifted.getUpperBound(),.000000001d);
 	}
    
 	/*
 	 *  This test will simulate when delta is small
     *  Expected result: returns the expected upper and lower bounds
     */
    @Test(timeout = 1000) // timeout: 1000
 	public void testShiftSmallDelta() {
     	Range RangeShift = new Range(1,2);
     	Range shifted = Range.shift(RangeShift, 0.01);
 		assertEquals("The expected lower bound is 1.01", 1.01, shifted.getLowerBound(),.000000001d);
 		assertEquals("The expected upper bound is 2.01", 2.01, shifted.getUpperBound(),.000000001d);
 	}
     	
     	
    // ------- End of tests for shift(Range, double):Range -------
    
    // ------- Test for shift(Range, double, boolean):Range-------   
 	/*
 	 *  This test will simulate when delta is positive and ZeroCrossing is allowed
     *  Expected result: returns the expected upper and lower bounds
     */
    @Test(timeout = 1000) // timeout: 1000
 	public void testShift2PositiveRangePositive() {
     	Range RangeShift = new Range(1,2);
     	Range shifted = Range.shift(RangeShift, 5, true);
 		assertEquals("The expected lower bound is 6", 6, shifted.getLowerBound(),.000000001d);
 		assertEquals("The expected upper bound is 7", 7, shifted.getUpperBound(),.000000001d);
 	}
    
 	/*
 	 *  This test will simulate when delta is negative and ZeroCrossing is allowed
     *  Expected result: returns the expected upper and lower bounds
     */
    @Test(timeout = 1000) // timeout: 1000
 	public void testShift2PositiveRangeNegative() {
     	Range RangeShift = new Range(1,2);
     	Range shifted = Range.shift(RangeShift, -5, true);
 		assertEquals("The expected lower bound is -4", -4, shifted.getLowerBound(),.000000001d);
 		assertEquals("The expected upper bound is -3", -3, shifted.getUpperBound(),.000000001d);
 	}
    
 	/*
 	 *  This test will simulate when delta is Positive and ZeroCrossing is allowed and the Range is Negative
     *  Expected result: returns the expected upper and lower bounds
     */
    @Test(timeout = 1000) // timeout: 1000
 	public void testShift2NegativeRangePositive() {
     	Range RangeShift = new Range(-10,-2);
     	Range shifted = Range.shift(RangeShift, 5, true);
 		assertEquals("The expected lower bound is -5", -5, shifted.getLowerBound(),.000000001d);
 		assertEquals("The expected upper bound is 3", 3, shifted.getUpperBound(),.000000001d);
 	}
    
 	/*
 	 *  This test will simulate when delta is Positive and ZeroCrossing is allowed and the Range is null
     *  Expected result: IllegalParameterException is thrown
     */
    @Test(timeout = 1000) // timeout: 1000
 	public void testShift2NullRange() {
    	try {
         	Range RangeShift = null;
         	Range shifted = Range.shift(RangeShift, 5, true);	
    	}
    	catch(Exception e) {
    		assertEquals("InvalidParameterException was thrown", InvalidParameterException.class, e.getClass());
    	}
 	}
    
    // ------- End of tests for shift(Range, double, boolean):Range -------
    // ------- Test for intersects(Range, Range):Boolean-------   
	// The assumed Range lower = 5, upper = 15;
	
	/*
	 * This will test the case when a Range that is within the intersectRange is used
	 * The expected value that will be asserted is TRUE, as the ranges should intersect.
	 */
	
	@Test(timeout = 1000) // timeout: 1000
	public void testIntersects2RangeWithinRange() {
		Range testRange= new Range(10.5,14.5);
		boolean result = intersectRange.intersects(testRange);
		assertTrue("The expected value is TRUE but returned: "+ result,result);
	}
	
	
	/*
	 * The values of the Range exist outside the boundaries of the test range  to the left
	 * The expected value that will be asserted is FALSE, as the ranges do not intersect.
	 */
	
	@Test(timeout = 1000) // timeout: 1000
	public void testIntersects2OutsideRangeToLeft() {
		Range testRange= new Range(-5.2,4);
		boolean result = intersectRange.intersects(testRange);
		assertFalse("The expected value is FALSE but returned: "+ result,result);
	}
	

	/*
	 * This will test the case when the test Range is partially in the intersectRange on the Right side
	 * The expected value that will be asserted is TRUE, as the ranges should intersect.
	 */
	
	@Test(timeout = 1000) // timeout: 1000
	public void testIntersects2WithinRangeToRight() {
		Range testRange= new Range(14.5,20);
		boolean result = intersectRange.intersects(testRange);
		assertTrue("The expected value is TRUE but returned: "+ result,result);
	}
	
	
	
	/*
	 * This will test the case when the test Range is partially in the Range on the left side of the Range
	 * The expected value that will be asserted is TRUE, as the ranges should intersect.
	 */
	
	@Test(timeout = 1000) // timeout: 1000
	public void testIntersects2WithinRangeToLeft() {
		Range testRange= new Range(-5.2,5.2);
		boolean result = intersectRange.intersects(testRange);
		assertTrue("The expected value is TRUE but returned: "+ result,result);
	}
	
	
	/*
	 * This will test the case when a Range outside to the right is used
	 * The expected value that will be asserted is FALSE, as the ranges should not intersect.
	 */
	
	@Test(timeout = 1000) // timeout: 1000
	public void testIntersects2OutsideRangeToRight() {
		Range testRange= new Range(20,25);
		boolean result = intersectRange.intersects(testRange);
		assertFalse("The expected value is FALSE but returned: "+ result,result);
	}
    
	/*
	 * This will test the case when a null test range is used.
	 * The expected value that is expected is that an IllegalParameterException is thrown
	 */
	
	@Test(timeout = 1000) // timeout: 1000
	public void testIntersects2NullRange() {
		try {
			Range testRange= null;
			boolean result = intersectRange.intersects(testRange);	
		}
		catch(Exception e) {
    		assertEquals("InvalidParameterException was thrown", InvalidParameterException.class, e.getClass());
		}

	}

    // ------- End of tests for intersects(Range, Range):Boolean -------
	// -----------------------------------------------------------------------------------------
	// End of Test Code LAB3
	// -----------------------------------------------------------------------------------------
    @After
    public void tearDown() throws Exception {
    	testRange = null;
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
