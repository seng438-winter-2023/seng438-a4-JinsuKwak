package org.jfree.data;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.junit.*;
import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jfree.data.KeyedValues;
import org.jmock.Expectations;
import org.jmock.Mockery;

public class DataUtilitiesTest {
	
	 // -----------------------------------------------------------------------------------------
	 // Given Example Test Code from LAB Document
	 // -----------------------------------------------------------------------------------------

	 @Test
	 public void calculateColumnTotalForTwoValues() {
	     // setup
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(2));
	             
	             one(values).getValue(0, 0);
	             will(returnValue(7.5));
	             one(values).getValue(1, 0);
	             will(returnValue(2.5));
	         }
	     });
	     double result = DataUtilities.calculateColumnTotal(values, 0);
	     // verify
	     assertEquals(result, 10.0, .000000001d);
	     // tear-down: NONE in this test method
	 }
	 
      // -----------------------------------------------------------------------------------------
      // Start of Test Code
      // -----------------------------------------------------------------------------------------
     
     // -----------------------------------------------------------------------------------------
     // Start of Test Code LAB2
     // -----------------------------------------------------------------------------------------
    	
     // ------- Test for calculateColumnTotal(Values2D data, int column) -------
	 
	 /*
	 *  This test will simulate when all the data contains five values
	 *  Expected result: total sum of columns
	 */	 
	 @Test(timeout = 1000) // timeout: 1000
	 public void testCalculateColumnTotalFiveValues() {
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(5));
	             
	             one(values).getValue(0, 1);
	             will(returnValue(7.5));
	             
	             one(values).getValue(1, 1);
	             will(returnValue(2.5));
	             
	             one(values).getValue(2, 1);
	             will(returnValue(4));
	             
	             one(values).getValue(3, 1);
	             will(returnValue(-4));
	             
	             one(values).getValue(4, 1);
	             will(returnValue(5));

	         }
	     });
	    
	     int columnNumber = 1;
	     double actualResult = DataUtilities.calculateColumnTotal(values, columnNumber);
	     double expectedResult = 15.0;
	     assertEquals("Checking fucntion returns correct column sum",expectedResult, actualResult, .000000001d);
	 }
	 
	 /*
	 *  This test will simulate when all the data is negative number
	 *  Expected result: total sum of columns
	 */	 
	 @Test(timeout = 1000) // timeout: 1000
	 public void testCalculateColumnTotalNegative() {
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(4));
	             
	             one(values).getValue(0, 1);
	             will(returnValue(-7.5));
	             
	             one(values).getValue(1, 1);
	             will(returnValue(-2.5));
	             
	             one(values).getValue(2, 1);
	             will(returnValue(-6));
	             
	             one(values).getValue(3, 1);
	             will(returnValue(-4));

	         }
	     });
	    
	     int columnNumber = 1;
	     double actualResult = DataUtilities.calculateColumnTotal(values, columnNumber);
	     double expectedResult = -20.0;
	     assertEquals("Checking fucntion returns correct column sum when all Negative",expectedResult, actualResult, .000000001d);
	 }
	 
	 /*
	 *  This test will simulate when empty data is passed in
	 *  Expected result: 0
	 */	 
	 @Test(timeout = 1000) // timeout: 1000
	 public void testCalculateColumnTotalEmpty() {
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
				one(values).getRowCount();
				will(returnValue(0));
	         }
	     });
	     int columnNumber = 0;
	     double actualResult = DataUtilities.calculateColumnTotal(values, columnNumber);
	     double expectedResult = 0;
	     assertEquals("The colum total dose not adding up to 0 when data is empty",expectedResult, actualResult, .000000001d);
	 }
	 
	 /*
	 *  This test will simulate when invalid column number (negative) passed in
	 *  Expected result: total of zero
	 */	 
	 @Test(timeout = 1000) // timeout: 1000
	 public void testCalculateColumnTotalNegativeColumnIndex() {
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(3));
	             
	             one(values).getValue(0, -1);
	             will(returnValue(7.5));
	             
	             one(values).getValue(1, -1);
	             will(returnValue(2.5));
	             
	             one(values).getValue(2, -1);
	             will(returnValue(4));
	         }
	     });
	     int columnNumber = -1;
	     double actualResult = DataUtilities.calculateColumnTotal(values, columnNumber);
	     double expectedResult = 0;	// 0 since invalid input
	     assertEquals("calcuateColumTotal() did not return 0 when there was invalid input (negative index)",expectedResult, actualResult, .000000001d);
	 }
	 
	 /*
     *  This test will simulate when invalid data object passed in
     *  Expected result: throws InvalidParameterException
	 */
	 @Test(timeout = 1000) // timeout: 1000
	 public void testCalculateColumnNullValue(){
		 final Values2D values = null; 				  // invalid data object (null)
		 try {
			 DataUtilities.calculateColumnTotal(values, 0);// line that exception will occurs
		 }catch(Exception e) {
			 assertEquals("InvalidParameterException was thrown",InvalidParameterException.class, 
					 e.getClass());
		 }
	 }
	 
	 /*
	   *  This test will simulate when the input argument data holds a null value
	   *  Expected result: returns accurate column total
	   */
	  @Test(timeout = 1000) // timeout: 1000
		 public void testCalculateColumnTotalNullValueInputData() {
		     Mockery mockingContext = new Mockery();
		     final Values2D values = mockingContext.mock(Values2D.class);
		     mockingContext.checking(new Expectations() {
		         {
		             one(values).getRowCount();
		             will(returnValue(5));

		             one(values).getValue(0, 0);
		             will(returnValue(3.0));

		             one(values).getValue(1, 0);
		             will(returnValue(null));

		             one(values).getValue(2, 0);
		             will(returnValue(1.0));

		             one(values).getValue(3, 0);
		             will(returnValue(10.0));

		             one(values).getValue(4, 0);
		             will(returnValue(2.0));

		         }
		     });
		     double actualResult = DataUtilities.calculateColumnTotal(values, 0);
		     double expectedResult = 16.0;
		     assertEquals("Checking function returns correct column sum",expectedResult, actualResult, .000000001d);
		 }

	 
	 // ------- Test for createNumberArray(double[] data) -------
	 
	 /**
	  * This will test the case when an array of doubles is passed to createNumberArray
	  * the doubles will have standard values with a mix of negatives and positives
	  */
	 @Test
	 public void createNumberArrayStandard() {
		 // expected Number array
		 Number[] expected = {19.2,-2.6,40.9,-3.5};
		 // double array to be passed to createNumberArray 
		 double [] passArray = {19.2,-2.6,40.9,-3.5};
		 // calling function to create array
		 Number[] testArray = DataUtilities.createNumberArray(passArray);
		 
		 assertArrayEquals("The expected array should contain the values : [19.2, -2.6, 40.9, -3.5]",
				 expected, testArray);
	 }
	 
	 /**
	  * This will test the case when a null double array is passed to createNumberArray
	  * It should throw an InvalidParameterException.
	  */
	 @Test
	 public void createNumberArrayNull() {
		 // Try/catch block to catch exceptions
		 try {
			 // create a null double array to pass
			 double [] passArray = null;
			 DataUtilities.createNumberArray(passArray);
			 

		 }catch(Exception e) {
			 assertEquals("InvalidParameterException was thrown",InvalidParameterException.class, 
					 e.getClass());
		 }

	 }
	 
	 /**
	  * This will test the case when an array of doubles is passed to createNumberArray
	  * the doubles will have standard values, all being positives
	  */
	 @Test
	 public void createNumberArrayPositives() {
		 // expected Number array
		 Number[] expected = {1.2,2.3,3.4,4.5};
		 // double array to be passed to createNumberArray 
		 double [] passArray = {1.2,2.3,3.4,4.5};
		 // calling function to create array
		 Number[] testArray = DataUtilities.createNumberArray(passArray);
		 
		 assertArrayEquals("The expected array should contain the values : [1.2, 2.3, 3.4, 4.5]",
				 expected, testArray);
	 }
	 
	 /**
	  * This will test the case when an array of doubles is passed to createNumberArray
	  * the doubles will have standard values, all being negatives
	  */
	 @Test
	 public void createNumberArrayNegatives() {
		 // expected Number array
		 Number[] expected = {-1.2,-2.3,-3.4,-4.5};
		 // double array to be passed to createNumberArray 
		 double [] passArray = {-1.2,-2.3,-3.4,-4.5};
		 // calling function to create array
		 Number[] testArray = DataUtilities.createNumberArray(passArray);
		 
		 assertArrayEquals("The expected array should contain the values : [-1.2, -2.3, -3.4, -4.5]",
				 expected, testArray);
	 }
	 
	 /**
	  * This will test the case when an empty array of doubles is passed to createNumberArray
	  */
	 @Test
	 public void createNumberArrayEmpty() {
		 // expected Number array
		 Number[] expected = {};
		 // double array to be passed to createNumberArray 
		 double [] passArray = {};
		 // calling function to create array
		 Number[] testArray = DataUtilities.createNumberArray(passArray);
		 
		 assertArrayEquals("The expected array should be empty: []",
				 expected, testArray);
	 }
	 
	 /**
	  * This will test the case when an array of doubles is passed to createNumberArray
	  * There will only be one element in the array
	  */
	 @Test
	 public void createNumberArrayOneElement() {
		 // expected Number array
		 Number[] expected = {0};
		 // double array to be passed to createNumberArray 
		 double [] passArray = {0};
		 // calling function to create array
		 Number[] testArray = DataUtilities.createNumberArray(passArray);
		 
		 assertArrayEquals("The expected array should contain the values: [0]",
				 expected, testArray);
	 }

	 /**
	  * This will test the case when an array of doubles is passed to createNumberArray
	  * There will be 10 elements in the array
	  */
	 @Test
	 public void createNumberArrayTenElements() {
		 // expected Number array
		 Number[] expected = {0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0};
		 // double array to be passed to createNumberArray 
		 double [] passArray = {0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0};
		 // calling function to create array
		 Number[] testArray = DataUtilities.createNumberArray(passArray);
		 
		 assertArrayEquals("The expected array should contain the values: [0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0]",
				 expected, testArray);
	 }
	// ------- End of Test for createNumberArray(double[] data) -------

	// ------- Test for createNumberArray2D(double[][] data) -------
	 /**
	  * This will test the case when an 2D array of doubles is passed to createNumberArray2D
	  * the doubles will have standard values with a mix of negatives and positives
	  */
	 @Test
	 public void createNumberArray2DStandard() {
		 // expected 2D Number array
		 Number[][] expected = {{1.0,-2.0,3.0},{-1.0,2.0,-3.0}};
		 // 2D double array to be passed to createNumberArray2D 
		 double [][] passArray = {{1.0,-2.0,3.0},{-1.0,2.0,-3.0}};
		 // calling function to create 2D array
		 Number[][] testArray = DataUtilities.createNumberArray2D(passArray);
		 
		 assertArrayEquals("The expected array should contain the values : [1.0,-2.0,3.0][-1.0,2.0,-3.0]",
				 expected, testArray);
	 }
	 
	 /**
	  * This will test the case when a null 2D double array is passed to createNumberArray2D
	  * It should throw an InvalidParameterException.
	  */
	 @Test
	 public void createNumberArray2DNull() {
		 // Try/catch block to catch exceptions
		 try {
			 // create a null double array to pass
			 double [][] passArray = null;
			 DataUtilities.createNumberArray2D(passArray);
			 

		 }catch(Exception e) {
			 assertEquals("InvalidParameterException was thrown",InvalidParameterException.class, 
					 e.getClass());
		 }

	 }
	 
	 /**
	  * This will test the case when a 2D array of doubles is passed to createNumberArray2D
	  * the doubles will have standard values, all being positives
	  */
	 @Test
	 public void createNumberArray2DPositives() {
		 // expected Number array
		 Number[][] expected = {{1.5,10.0,20.4,30.5,45.2},{2.0,5.2,6.3,15.4,22.5}};
		 // 2D double array to be passed to createNumberArray2D 
		 double [][] passArray = {{1.5,10.0,20.4,30.5,45.2},{2.0,5.2,6.3,15.4,22.5}};
		 // calling function to create 2D array
		 Number[][] testArray = DataUtilities.createNumberArray2D(passArray);
		 
		 assertArrayEquals("The expected array should contain the values : [1.5,10.0,20.4,30.5,45.2],[2.0,5.2,6.3,15.4,22.5]",
				 expected, testArray);
	 }
	 
	 /**
	  * This will test the case when a 2D array of doubles is passed to createNumberArray2D
	  * the doubles will have standard values, all being negatives
	  */
	 @Test
	 public void createNumberArray2DNegatives() {
		 // expected 2D Number array
		 Number[][] expected = {{-1.5,-10.0,-20.4,-30.5,-45.2},{-2.0,-5.2,-6.3,-15.4,-22.5}};
		 // 2D double array to be passed to createNumberArray2D 
		 double [][] passArray = {{-1.5,-10.0,-20.4,-30.5,-45.2},{-2.0,-5.2,-6.3,-15.4,-22.5}};
		 // calling function to create 2D array
		 Number[][] testArray = DataUtilities.createNumberArray2D(passArray);
		 
		 assertArrayEquals("The expected 2D array should contain the values : [-1.5,-10.0,-20.4,-30.5,-45.2], [-2.0,-5.2,-6.3,-15.4,-22.5]",
				 expected, testArray);
	 }
	 
	 /**
	  * This will test the case when an empty 2D array of doubles is passed to createNumberArray2D
	  * Both arrays will be empty
	  */
	 @Test
	 public void createNumberArray2DBothEmpty() {
		 // expected 2D Number array
		 Number[][] expected = {{},{}};
		 // 2D double array to be passed to createNumberArray2D 
		 double [][] passArray = {{},{}};
		 // calling function to create 2D array
		 Number[][] testArray = DataUtilities.createNumberArray2D(passArray);
		 
		 assertArrayEquals("The expected 2D array should be empty",
				 expected, testArray);
	 }
	 
	 /**
	  * This will test the case when a 2D array of doubles is passed to createNumberArray2D
	  * One of the arrays will contain doubles, while the other will be empty
	  */
	 @Test
	 public void createNumberArray2DOneEmpty() {
		 // expected 2D Number array
		 Number[][] expected = {{1.0,-2.0,3.0},{}};
		 // 2D double array to be passed to createNumberArray2D 
		 double [][] passArray = {{1.0,-2.0,3.0},{}};
		 // calling function to create 2D array
		 Number[][] testArray = DataUtilities.createNumberArray2D(passArray);
		 
		 assertArrayEquals("The expected 2D array should contain the values [1.0,-2.0,3.0] and be empty"
		 		+ " in the other.",
				 expected, testArray);
	 }
	 
	 /**
	  * This will test the case when a 2D array of doubles is passed to createNumberArray2D
	  * There will only be one element in both of the arrays
	  */
	 @Test
	 public void createNumberArray2DOneElements() {
		 // expected 2D Number array
		 Number[][] expected = {{0.0},{0.0}};
		 // 2D double array to be passed to createNumberArray2D 
		 double [][] passArray = {{0.0},{0.0}};
		 // calling function to create 2D array
		 Number[][] testArray = DataUtilities.createNumberArray2D(passArray);
		 
		 assertArrayEquals("The expected 2D array should contain the values: [0] and [0]",
				 expected, testArray);
	 }

	 /**
	  * This will test the case when a 2D array of doubles is passed to createNumberArray2D
	  * There will be 10 elements in both the arrays
	  */
	 @Test
	 public void createNumberArray2DTenElements() {
		 // expected 2D Number array
		 Number[][] expected = {{0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0},{0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0}};
		 // 2D double array to be passed to createNumberArray 
		 double [][] passArray = {{0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0},{0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0}};
		 // calling function to create 2D array
		 Number[][] testArray = DataUtilities.createNumberArray2D(passArray);
		 
		 assertArrayEquals("The expected 2D array should contain the values: [0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0],"
		 		+ "[0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0]",
				 expected, testArray);
	 }
	// ------- End of Test for createNumberArray2D(double[][] data) -------
		 
	 
	// ------- Test for calculateRowTotal(Values2D, int) -------
	 
	 /**
	  * This test calculates the total row amount in the row with one column
	  * 
	  */
	 @Test
	 public void testCalculateRowTotalForOneColumn() {
	     // setup
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(1));
	             
	             one(values).getColumnCount();
	             will(returnValue(1));
	             
	             one(values).getValue(0, 0);
	             will(returnValue(3));
	         }
	     });
	     double result = DataUtilities.calculateRowTotal(values, 0);
	     // verify
	     assertEquals(result, 3.0, .000000001d);
	     // tear-down: NONE in this test method
	 }
	 
	 /**
	  * This test calculates the total row amount in the row with three column with a positive value
	  * 
	  */
	 @Test
	 public void testCalculateRowTotalForThreeColumnPositiveValue() {
	     // setup
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(1));
	             
	             one(values).getColumnCount();
	             will(returnValue(3));
	             
	             one(values).getValue(0, 0); //index row1 = 0, with column1 = 0
	             will(returnValue(3));
	             
	             one(values).getValue(0, 1); //index row1 = 0, with column2 = 1
	             will(returnValue(3));
	             
	             one(values).getValue(0, 2); //index row1 = 0, with column3 = 2
	             will(returnValue(3));
	             
	         }
	     });
	     double result = DataUtilities.calculateRowTotal(values, 0);
	     // verify
	     assertEquals(result, 9.0, .000000001d);
	     // tear-down: NONE in this test method
	 }
	
	 
	 
	 /**
	  * This test calculates the total row amount with having 1 row and 3 columns all having values of zero
	  */
	 @Test
	 public void testCalculateRowTotalForThreeColumnWithAllZeroes() {
	     // setup
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(1));
	             
	             one(values).getColumnCount();
	             will(returnValue(3));
	             
	             one(values).getValue(0, 0); //index row1 = 0, with column1 = 0
	             will(returnValue(0));
	             
	             one(values).getValue(0, 1); //index row1 = 0, with column2 = 1
	             will(returnValue(0));
	             
	             one(values).getValue(0, 2); //index row1 = 0, with column1 = 0
	             will(returnValue(0));
	             
	         }
	     });
	     double result = DataUtilities.calculateRowTotal(values, 0);
	     // verify
	     assertEquals(result, 0.0, .000000001d);
	     // tear-down: NONE in this test method
	 }
	 
	 /**
	  * This test calculates the total row amount with having 1 row and 4 columns all having values that add up to zero, so 3, -3, 4, -4
	  */
	 @Test
	 public void testCalculateRowTotalForFourColumnWithAddingUpToZero() {
	     // setup
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(1));
	             
	             one(values).getColumnCount();
	             will(returnValue(4));
	             
	             one(values).getValue(0, 0); //index row1 = 0, with column1 = 0
	             will(returnValue(3));
	             
	             one(values).getValue(0, 1); //index row1 = 0, with column2 = 1
	             will(returnValue(-3));
	             
	             one(values).getValue(0, 2); //index row1 = 0, with column1 = 0
	             will(returnValue(-4));
	             
	             one(values).getValue(0, 3); //index row1 = 0, with column1 = 0
	             will(returnValue(4));
	             
	         }
	     });
	     double result = DataUtilities.calculateRowTotal(values, 0);
	     // verify
	     assertEquals(result, 0.0, .000000001d);
	     // tear-down: NONE in this test method
	 }
	 
	 /**
	  * This test calculates the total row amount with having 1 row and 3columns that have a total row count as a negative value
	  */
	 @Test
	 public void testCalculateRowTotalForThreeColumnNegativeValue() {
	     // setup
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(1));
	             
	             one(values).getColumnCount();
	             will(returnValue(3));
	             
	             one(values).getValue(0, 0); //index row1 = 0, with column1 = 0
	             will(returnValue(-3));
	             
	             one(values).getValue(0, 1); //index row1 = 0, with column2 = 1
	             will(returnValue(-3));
	             
	             one(values).getValue(0, 2); //index row1 = 0, with column1 = 0
	             will(returnValue(-6));
	         }
	     });
	     double result = DataUtilities.calculateRowTotal(values, 0);
	     // verify
	     assertEquals(result, -12.0, .000000001d);
	     // tear-down: NONE in this test method
	 }
	 
	 /*
	     *  This test will simulate when invalid data object passed in so when Values2d is NULL
	     *  Expected result: throws InvalidParameterException
	*/
		 @Test
		 public void testCalculateRowIllegalArgumment(){
		     final Values2D values = null;
		     try {
				 DataUtilities.calculateRowTotal(values, 0);// line that exception will occurs
			 }catch(Exception e) {
				 assertEquals("InvalidParameterException was thrown",IllegalArgumentException.class, 
						 e.getClass());
			 }
		 }
	 
	// ------- End of Test for calculateRowTotal(Values2D, int) -------
	
	
	// ------- Start of Test for getCumulativePercentages(KeyedValues): KeyedValues -------
	/*
	*  This test will simulate when the input is null
	*  Expected result: InvalidParameterException is thrown
	*/	 
	 @Test(expected = IllegalArgumentException.class) // expecting an exception
	 public void testGetCumulativePercentagesNull(){
		 final KeyedValues values = null; 				  // invalid data object (null)
		 DataUtilities.getCumulativePercentages(values);// line that exception will occur
	 }
	
	
	/*
	 *  This test will simulate when the input is an empty KeyedValues object (no data)
	 *  Expected result: A valid KeyedValues object is returned
	 */	
	 @Test(timeout = 1000) // timeout: 1000
	 public void testGetCumulativePercentagesEmpty() {
	     Mockery mockingContext = new Mockery();
	     final KeyedValues values = mockingContext.mock(KeyedValues.class);
	     mockingContext.checking(new Expectations() {
	         {
	             allowing(values).getItemCount();
	             will(returnValue(1));
	             
	             allowing(values).getValue(0);
	             will(returnValue(0));
	             
	             allowing(values).getKey(0);
	             will(returnValue(0));
	             
	         }
	     });
	    
	     KeyedValues actualResult = DataUtilities.getCumulativePercentages(values);
	     assertEquals("Checking function returns correct cumulative percentages",0.0/0.0, actualResult.getValue(0));
	 }
	 
	 /*
	  *  This test will simulate when the input is a KeyedValues object with one value (positive)
	  *  Expected result: A valid KeyedValues object is returned
	  */	 
	  @Test(timeout = 1000) // timeout: 1000
	  public void testGetCumulativePercentagesOneValue() {
	      Mockery mockingContext = new Mockery();
	      final KeyedValues values = mockingContext.mock(KeyedValues.class);
	      mockingContext.checking(new Expectations() {
		  {
			allowing(values).getItemCount();
		        will(returnValue(1));
		             
		        allowing(values).getValue(0);
		        will(returnValue(10));
		             
		        allowing(values).getKey(0);
		        will(returnValue(0));

		  }
	       });
		    
	       KeyedValues actualResult = DataUtilities.getCumulativePercentages(values);
	       assertEquals("Checking function returns correct cumulative percentages",10.0/10.0, actualResult.getValue(0));
	   }
		 
	
	/*
	 *  This test will simulate when the input is a KeyedValues object with five values (positive)
	 *  Expected result: A valid KeyedValues object is returned
	 */	
	 @Test(timeout = 1000) // timeout: 1000
	 public void testGetCumulativePercentagesFiveValues() {
	     Mockery mockingContext = new Mockery();
	     final KeyedValues values = mockingContext.mock(KeyedValues.class);
	     mockingContext.checking(new Expectations() {
	         {
	        	 allowing(values).getItemCount();
	             will(returnValue(5));
	             
	             allowing(values).getValue(0);
	             will(returnValue(10));
	             
	             allowing(values).getValue(1);
	             will(returnValue(20));
	             
	             allowing(values).getValue(2);
	             will(returnValue(18));
	             
	             allowing(values).getValue(3);
	             will(returnValue(3));
	             
	             allowing(values).getValue(4);
	             will(returnValue(5));
	             
	             allowing(values).getKey(0);
	             will(returnValue(0));
	             
	             allowing(values).getKey(1);
	             will(returnValue(1));
	             
	             allowing(values).getKey(2);
	             will(returnValue(2));
	             
	             allowing(values).getKey(3);
	             will(returnValue(3));
	             
	             allowing(values).getKey(4);
	             will(returnValue(4));   
	         }
	     });
	    
	     KeyedValues actualResult = DataUtilities.getCumulativePercentages(values);
	     assertEquals("Checking function returns correct cumulative percentages",10.0/56.0, actualResult.getValue(0));
	     assertEquals("Checking function returns correct cumulative percentages",30.0/56.0, actualResult.getValue(1));
	     assertEquals("Checking function returns correct cumulative percentages",48.0/56.0, actualResult.getValue(2));
	     assertEquals("Checking function returns correct cumulative percentages",51.0/56.0, actualResult.getValue(3));
	     assertEquals("Checking function returns correct cumulative percentages",56.0/56.0, actualResult.getValue(4));
	 }
	

	/*
	 *  This test will simulate when the input is a KeyedValues object with both positive and negative values
	 *  Expected result: A valid KeyedValues object is returned
	 */	 
	 @Test(timeout = 1000) // timeout: 1000
	 public void testGetCumulativePercentagesPositiveAndNegative() {
	     Mockery mockingContext = new Mockery();
	     final KeyedValues values = mockingContext.mock(KeyedValues.class);
	     mockingContext.checking(new Expectations() {
	         {
	        	 allowing(values).getItemCount();
	             will(returnValue(5));
	             
	             allowing(values).getValue(0);
	             will(returnValue(30));
	             
	             allowing(values).getValue(1);
	             will(returnValue(-20));
	             
	             allowing(values).getValue(2);
	             will(returnValue(1));
	             
	             allowing(values).getValue(3);
	             will(returnValue(-3));
	             
	             allowing(values).getValue(4);
	             will(returnValue(5));
	             
	             allowing(values).getKey(0);
	             will(returnValue(0));
	             
	             allowing(values).getKey(1);
	             will(returnValue(1));
	             
	             allowing(values).getKey(2);
	             will(returnValue(2));
	             
	             allowing(values).getKey(3);
	             will(returnValue(3));
	             
	             allowing(values).getKey(4);
	             will(returnValue(4));   
	         }
	     });
	     KeyedValues actualResult = DataUtilities.getCumulativePercentages(values);
	     assertEquals("Checking function returns correct cumulative percentages",30.0/13.0, actualResult.getValue(0));
	     assertEquals("Checking function returns correct cumulative percentages",10.0/13.0, actualResult.getValue(1));
	     assertEquals("Checking function returns correct cumulative percentages",11.0/13.0, actualResult.getValue(2));
	     assertEquals("Checking function returns correct cumulative percentages",8.0/13.0, actualResult.getValue(3));
	     assertEquals("Checking function returns correct cumulative percentages",13.0/13.0, actualResult.getValue(4));
	 }

	
	
	/*
	 *  This test will simulate when the input is a KeyedValues object with all zero values
	 *  Expected result: A valid KeyedValues object is returned
	 */	 
	 @Test(timeout = 1000) // timeout: 1000
	 public void testGetCumulativePercentagesAllZero() {
	     Mockery mockingContext = new Mockery();
	     final KeyedValues values = mockingContext.mock(KeyedValues.class);
	     mockingContext.checking(new Expectations() {
	         {
	        	 allowing(values).getItemCount();
	             will(returnValue(5));
	             
	             allowing(values).getValue(0);
	             will(returnValue(0));
	             
	             allowing(values).getValue(1);
	             will(returnValue(0));
	             
	             allowing(values).getValue(2);
	             will(returnValue(0));
	             
	             allowing(values).getValue(3);
	             will(returnValue(0));
	             
	             allowing(values).getValue(4);
	             will(returnValue(0));
	             
	             allowing(values).getKey(0);
	             will(returnValue(0));
	             
	             allowing(values).getKey(1);
	             will(returnValue(1));
	             
	             allowing(values).getKey(2);
	             will(returnValue(2));
	             
	             allowing(values).getKey(3);
	             will(returnValue(3));
	             
	             allowing(values).getKey(4);
	             will(returnValue(4));   
	         }
	     });
	    
	     KeyedValues actualResult = DataUtilities.getCumulativePercentages(values);
	     assertEquals("Checking function returns correct cumulative percentages",0.0/0.0, actualResult.getValue(0));
	     assertEquals("Checking function returns correct cumulative percentages",0.0/0.0, actualResult.getValue(1));
	     assertEquals("Checking function returns correct cumulative percentages",0.0/0.0, actualResult.getValue(2));
	     assertEquals("Checking function returns correct cumulative percentages",0.0/0.0, actualResult.getValue(3));
	     assertEquals("Checking function returns correct cumulative percentages",0.0/0.0, actualResult.getValue(4));
	 }
	
	 /*
	  *  This test will simulate when the input is a KeyedValues object where first value is zero
	  *  Expected result: A valid KeyedValues object is returned
	  */
	 @Test(timeout = 1000) // timeout: 1000
	 public void testGetCumulativePercentagesFirstValueZero() {
	     Mockery mockingContext = new Mockery();
	     final KeyedValues values = mockingContext.mock(KeyedValues.class);
	     mockingContext.checking(new Expectations() {
	         {
	        	 allowing(values).getItemCount();
	             will(returnValue(5));
	             
	             allowing(values).getValue(0);
	             will(returnValue(0));
	             
	             allowing(values).getValue(1);
	             will(returnValue(1));
	             
	             allowing(values).getValue(2);
	             will(returnValue(2));
	             
	             allowing(values).getValue(3);
	             will(returnValue(3));
	             
	             allowing(values).getValue(4);
	             will(returnValue(4));
	             
	             allowing(values).getKey(0);
	             will(returnValue(0));
	             
	             allowing(values).getKey(1);
	             will(returnValue(1));
	             
	             allowing(values).getKey(2);
	             will(returnValue(2));
	             
	             allowing(values).getKey(3);
	             will(returnValue(3));
	             
	             allowing(values).getKey(4);
	             will(returnValue(4));   
	         }
	     });
	    
	     KeyedValues actualResult = DataUtilities.getCumulativePercentages(values);
	     assertEquals("Checking function returns correct cumulative percentages",0.0/10.0, actualResult.getValue(0));
	     assertEquals("Checking function returns correct cumulative percentages",1.0/10.0, actualResult.getValue(1));
	     assertEquals("Checking function returns correct cumulative percentages",3.0/10.0, actualResult.getValue(2));
	     assertEquals("Checking function returns correct cumulative percentages",6.0/10.0, actualResult.getValue(3));
	     assertEquals("Checking function returns correct cumulative percentages",10.0/10.0, actualResult.getValue(4));
	 }
	 
	 /*
	  *  This test will simulate when the input is a KeyedValues object where last value is zero
	  *  Expected result: A valid KeyedValues object is returned
	  */
	 @Test(timeout = 1000) // timeout: 1000
	 public void testGetCumulativePercentagesLastValueZero() {
	     Mockery mockingContext = new Mockery();
	     final KeyedValues values = mockingContext.mock(KeyedValues.class);
	     mockingContext.checking(new Expectations() {
	         {
	        	 allowing(values).getItemCount();
	             will(returnValue(5));
	             
	             allowing(values).getValue(0);
	             will(returnValue(10));
	             
	             allowing(values).getValue(1);
	             will(returnValue(1));
	             
	             allowing(values).getValue(2);
	             will(returnValue(2));
	             
	             allowing(values).getValue(3);
	             will(returnValue(3));
	             
	             allowing(values).getValue(4);
	             will(returnValue(0));
	             
	             allowing(values).getKey(0);
	             will(returnValue(0));
	             
	             allowing(values).getKey(1);
	             will(returnValue(1));
	             
	             allowing(values).getKey(2);
	             will(returnValue(2));
	             
	             allowing(values).getKey(3);
	             will(returnValue(3));
	             
	             allowing(values).getKey(4);
	             will(returnValue(4));   
	         }
	     });
	    
	     KeyedValues actualResult = DataUtilities.getCumulativePercentages(values);
	     assertEquals("Checking function returns correct cumulative percentages",10.0/16.0, actualResult.getValue(0));
	     assertEquals("Checking function returns correct cumulative percentages",11.0/16.0, actualResult.getValue(1));
	     assertEquals("Checking function returns correct cumulative percentages",13.0/16.0, actualResult.getValue(2));
	     assertEquals("Checking function returns correct cumulative percentages",16.0/16.0, actualResult.getValue(3));
	     assertEquals("Checking function returns correct cumulative percentages",16.0/16.0, actualResult.getValue(4));
	 }
	 
	 /*
	  *  This test will simulate when the input is a KeyedValues object with mix of int and double values
	  *  Expected result: A valid KeyedValues object is returned
	  */
	 @Test(timeout = 1000) // timeout: 1000
	 public void testGetCumulativePercentagesIntAndDouble() {
	     Mockery mockingContext = new Mockery();
	     final KeyedValues values = mockingContext.mock(KeyedValues.class);
	     mockingContext.checking(new Expectations() {
	         {
	        	 allowing(values).getItemCount();
	             will(returnValue(5));
	             
	             allowing(values).getValue(0);
	             will(returnValue(1));
	             
	             allowing(values).getValue(1);
	             will(returnValue(2.4));
	             
	             allowing(values).getValue(2);
	             will(returnValue(3.7));
	             
	             allowing(values).getValue(3);
	             will(returnValue(3));
	             
	             allowing(values).getValue(4);
	             will(returnValue(4));
	             
	             allowing(values).getKey(0);
	             will(returnValue(0));
	             
	             allowing(values).getKey(1);
	             will(returnValue(1));
	             
	             allowing(values).getKey(2);
	             will(returnValue(2));
	             
	             allowing(values).getKey(3);
	             will(returnValue(3));
	             
	             allowing(values).getKey(4);
	             will(returnValue(4));   
	         }
	     });
	    
	     KeyedValues actualResult = DataUtilities.getCumulativePercentages(values);
	     assertEquals("Checking function returns correct cumulative percentages",1.0/14.1, actualResult.getValue(0));
	     assertEquals("Checking function returns correct cumulative percentages",3.4/14.1, actualResult.getValue(1));
	     assertEquals("Checking function returns correct cumulative percentages",7.1/14.1, actualResult.getValue(2));
	     assertEquals("Checking function returns correct cumulative percentages",10.1/14.1, actualResult.getValue(3));
	     assertEquals("Checking function returns correct cumulative percentages",14.1/14.1, actualResult.getValue(4));
	 }
	
	// ------- End of Test for getCumulativePercentages(KeyedValues): KeyedValues -------
	
     // -----------------------------------------------------------------------------------------
     // End of Test Code LAB2
    // -----------------------------------------------------------------------------------------
	
	
     // -----------------------------------------------------------------------------------------
     // Start of Test Code LAB3
    // -----------------------------------------------------------------------------------------
	
	// ------- Test for equal(double[][]a, double[][]b): boolean -------

	 /*
	  *  This test will simulate when input argument a is null and b is null
	  *  Expected result: returns true
	  */
	 @Test
	 public void testEqualNullInputs() {		 
		 boolean actualResult = DataUtilities.equal(null,  null);
		 assertEquals("Checking equality between null inputs", true, actualResult);
	 }
	 
	 /*
	  *  This test will simulate when only the second input is null
	  *  Expected result: returns false
	  */
	 @Test
	 public void testEqualSecondInputNull() {
		 double [][] array = {{1.0,-2.0,3.0},{-1.0,2.0,-3.0}};
		 boolean actualResult = DataUtilities.equal(array,  null);
		 assertEquals("Checking equality when second input is null", false, actualResult);
	 }
	 
	 /*
	  *  This test will simulate when the two 2D array inputs have different lengths (rows)
	  *  Expected result: returns false
	  */
	 @Test
	 public void testEqualDifferentLength2DArrays() {
		 double [][] firstArray = {{1.0,2.1,3.4},{-1.2,0.0,10.0},{-1.3,1.0,10.0}};
		 double [][] secondArray = {{1.0,2.1,3.4},{-1.2,0.0,10.0}};

		 boolean actualResult = DataUtilities.equal(firstArray, secondArray);
		 assertEquals("Checking equality when 2D Array inputs are different lengths", false, actualResult);
	 }
	 
	 /*
	  *  This test will simulate when the two 2D array inputs are valid but not equal
	  *  Expected result: returns false
	  */
	 @Test
	 public void testEqualValidNonEqualInputs() {
		 double [][] firstArray = {{1.0,7.0,3.0},{-1.0,0.0,20.0}};
		 double [][] secondArray = {{1.0,2.0,3.0},{-1.0,0.0,10.0}};
		 
		 boolean actualResult = DataUtilities.equal(firstArray, secondArray);
		 assertEquals("Checking equality when 2D Array inputs are valid but not equal", false, actualResult);
	 }
	 
	 /*
	  *  This test will simulate when the two 2D array inputs are valid and equal
	  *  Expected result: returns true
	  */
	 @Test
	 public void testEqualValidEqualInputs() {
		 double [][] firstArray = {{1.0,2.1,3.4},{-1.2,0.0,10.0}};
		 double [][] secondArray = {{1.0,2.1,3.4},{-1.2,0.0,10.0}};
		 
		 boolean actualResult = DataUtilities.equal(firstArray, secondArray);
		 assertEquals("Checking equality when 2D Array inputs are valid and equal", true, actualResult);
	 }
	 
	// ------- End of tests for equal(double[][]a, double[][]b): boolean -------	
	 
	// ------- Test for clone(double[][]source): double[][] -------
	   	
	 /*
	  *  This test will simulate when input is null
	  *  Expected result: Exception thrown
	  */
	  @Test(expected = IllegalArgumentException.class) // expecting an exception
	  public void testCloneNullInput() {
		  double[][] actualResult = DataUtilities.clone(null);
	  }
	  
	  /*
	   *  This test will simulate when there is a null value in the input
	   *  Expected result: returns valid double[][] that is a clone
	   */
	  @Test
	  public void testCloneNullValueInInput() {
		 double[][] source = new double[2][3];
		 source[0][0] = 3.0;
		 source[0][1] = 5.0;
		 source[1][0] = 8.0;
		 source[1][1] = 19.0;
		 source[1][2] = 4.0;
		 
   	     double[][] actualResult = DataUtilities.clone(source);
		 assertEquals("Checking clone when there is null value in input", 3.0, actualResult[0][0], .000000001d);
		 assertEquals("Checking clone when there is null value in input", 5.0, actualResult[0][1], .000000001d);
		 assertEquals("Checking clone when there is null value in input", null, actualResult[0][2]);
		 assertEquals("Checking clone when there is null value in input", 8.0, actualResult[1][0], .000000001d);
		 assertEquals("Checking clone when there is null value in input", 19.4, actualResult[1][1], .000000001d);
		 assertEquals("Checking clone when there is null value in input", 4.0, actualResult[1][2], .000000001d);
	  }
	  
	  /*
	   *  This test will simulate when the input is all valid values
	   *  Expected result: returns valid double[][] that is a clone
	   */
	  @Test
	  public void testCloneValidInput() {
		 double[][] source = {{8.0, 14.0, 17.0},{25.0,89.0,103.0}};
		 
   	     double[][] actualResult = DataUtilities.clone(source);
		 assertEquals("Checking clone when input is valid", 8.0, actualResult[0][0], .000000001d);
		 assertEquals("Checking clone when input is valid", 14.0, actualResult[0][1], .000000001d);
		 assertEquals("Checking clone when input is valid", 17.0, actualResult[0][2], .000000001d);
		 assertEquals("Checking clone when input is valid", 25.0, actualResult[1][0], .000000001d);
		 assertEquals("Checking clone when input is valid", 89.0, actualResult[1][1], .000000001d);
		 assertEquals("Checking clone when input is valid", 103.0, actualResult[1][2], .000000001d);
	  }
	  
	 
	// ------- End of tests for clone(double[][]source): double[][] -------	
	 
	// ------- Test for calculateColumnTotal(Values2D data, int column, int[] validRows): double-------
	  /*
	   *  This test will simulate when the input argument data is null
	   *  Expected result: throws an Exception
	   */
	  @Test(expected = IllegalArgumentException.class) // expecting an exception
	  public void testCalculateColumnTotalNullDataInput() {
		  int[] validRows = {0};
		  double actualResult = DataUtilities.calculateColumnTotal(null, 0, validRows);
	  } 
	  
	  /*
	   *  This test will simulate when the input argument data holds a null value
	   *  Expected result: returns accurate column total
	   */
	  @Test(timeout = 1000) // timeout: 1000
		 public void testCalculateColumnTotalNullValueInInputData() {
		     Mockery mockingContext = new Mockery();
		     final Values2D values = mockingContext.mock(Values2D.class);
		     mockingContext.checking(new Expectations() {
		         {
		             one(values).getRowCount();
		             will(returnValue(5));
		             
		             one(values).getValue(0, 0);
		             will(returnValue(3.0));
		             
		             one(values).getValue(1, 0);
		             will(returnValue(null));
		             
		             one(values).getValue(2, 0);
		             will(returnValue(1.0));
		             
		             one(values).getValue(3, 0);
		             will(returnValue(10.0));
		             
		             one(values).getValue(4, 0);
		             will(returnValue(2.0));

		         }
		     });
		     int[] validRows = {0, 1, 2};
		     double actualResult = DataUtilities.calculateColumnTotal(values, 0, validRows);
		     double expectedResult = 4.0;
		     assertEquals("Checking function returns correct column sum",expectedResult, actualResult, .000000001d);
		 }
	  
	  /*
	   *  This test will simulate when the input argument data is all positive
	   *  Expected result: returns accurate column total
	   */
	  @Test(timeout = 1000) // timeout: 1000
		 public void testCalculateColumnTotalValidInput() {
		     Mockery mockingContext = new Mockery();
		     final Values2D values = mockingContext.mock(Values2D.class);
		     mockingContext.checking(new Expectations() {
		         {
		             one(values).getRowCount();
		             will(returnValue(5));
		             
		             one(values).getValue(0, 0);
		             will(returnValue(3.0));
		             
		             one(values).getValue(1, 0);
		             will(returnValue(8.0));
		             
		             one(values).getValue(2, 0);
		             will(returnValue(1.0));
		             
		             one(values).getValue(3, 0);
		             will(returnValue(10.0));
		             
		             one(values).getValue(4, 0);
		             will(returnValue(2.0));

		         }
		     });
		     int[] validRows = {0, 2, 3};
		     double actualResult = DataUtilities.calculateColumnTotal(values, 0, validRows);
		     double expectedResult = 14.0;
		     assertEquals("Checking function returns correct column sum",expectedResult, actualResult, .000000001d);
		 }
	  
	  
	
	  
	// ------- End of tests for calculateColumnTotal(Values2D data, int column, int[] validRows): double -------	
	
	
	//test for CalculateRowTotal(Values2D data, int row, int[] validCols)
			 
			 /*
			  * test the total amount in row with row = 0 and column = 4
			  * test if it adds correctly with the validCols
			  * 
			  */
			 @Test(timeout = 1000) // timeout: 1000
			 public void testCalculateRowTotalNoRow() {
			
			     Mockery mockingContext = new Mockery();
			     final Values2D values = mockingContext.mock(Values2D.class);
			     mockingContext.checking(new Expectations() {
			         {
			             one(values).getColumnCount();
			             will(returnValue(4));
			             
			             one(values).getValue(0, 0);
			             will(returnValue(3));
			             
			             one(values).getValue(0, 1); 
			             will(returnValue(4));
			             
			             one(values).getValue(0, 2);
			             will(returnValue(2));
			             
			             one(values).getValue(0, 3); 
			             will(returnValue(3));
			             
			         }
			     });
			     int[] validCols = {0, 1, 2};
			     double result = DataUtilities.calculateRowTotal(values, 0, validCols);
			     // verify
			     assertEquals(result, 9.0, .000000001d);
			     // tear-down: NONE in this test method
			 }
			 
			 /*
			  * test the total amount in row with row = 0 and column = 0
			  * test if it adds correctly with the validCols
			  * 
			  */
			 @Test(timeout = 1000) // timeout: 1000
			 public void testCalculateRowTotalNoRowNoColumn() {
			
			     Mockery mockingContext = new Mockery();
			     final Values2D values = mockingContext.mock(Values2D.class);
			     mockingContext.checking(new Expectations() {
			         {
			        	 one(values).getColumnCount();
			             will(returnValue(0));
			             
			             one(values).getValue(0, 0);
			             will(returnValue(3));
			  
			             
			         }
			     });
			     int[] validCols = {0};
			     double result = DataUtilities.calculateRowTotal(values, 0, validCols);
			     // verify
			     assertEquals(result, 0.0, .000000001d);
			 }
			 
	
			 
			 /*
			  * test the total amount in row with row = 0 and a null value
			  * test if it adds correctly with the validCols
			  * 
			  */
			 @Test(timeout = 1000) // timeout: 1000
			 public void testCalculateRowTotalNullValue() {
			
			     Mockery mockingContext = new Mockery();
			     final Values2D values = mockingContext.mock(Values2D.class);
			     mockingContext.checking(new Expectations() {
			         {
			        	 one(values).getColumnCount();
			             will(returnValue(4));
			             
			             one(values).getValue(0, 0);
			             will(returnValue(3));
			             
			             one(values).getValue(0, 1);
			             will(returnValue(null));
			             
			             one(values).getValue(0, 2);
			             will(returnValue(-1));
			             
			             one(values).getValue(0, 3);
			             will(returnValue(-2));
			  
			             
			         }
			     });
			     int[] validCols = {0, 1, 2};
			     double result = DataUtilities.calculateRowTotal(values, 0, validCols);
			     // verify
			     assertEquals(result, 2.0, .000000001d);
			 }
			 
			 /*
			  * test the total amount in row with row = 0 and a null value
			  * test if it adds correctly with the validCols
			  * 
			  */
			 @Test(timeout = 1000) // timeout: 1000
			 public void testCalculateRowTotalInvalidNumCols() {
			
			     Mockery mockingContext = new Mockery();
			     final Values2D values = mockingContext.mock(Values2D.class);
			     mockingContext.checking(new Expectations() {
			         {
			        	 one(values).getColumnCount();
			             will(returnValue(4));
			             
			             one(values).getValue(0, 0);
			             will(returnValue(4));
			             
			             one(values).getValue(0, 1);
			             will(returnValue(null));
			             
			             one(values).getValue(0, 2);
			             will(returnValue(-6));
			             
			             one(values).getValue(0, 3);
			             will(returnValue(2));
			  
			             
			         }
			     });
			     int[] validCols = {5};
			     double result = DataUtilities.calculateRowTotal(values, 0, validCols);
			     // verify
			     assertEquals(result, 0, .000000001d);
			 }
			 
			 /*
			  * Testing this method with negative column
			  * 
			  */
			 @Test(timeout = 1000) // timeout: 1000
			 public void testCalculateRowTotalNegativeColumn() {
			
			     Mockery mockingContext = new Mockery();
			     final Values2D values = mockingContext.mock(Values2D.class);
			     mockingContext.checking(new Expectations() {
			         {
			        	 one(values).getColumnCount();
			             will(returnValue(-1));
			             
//			             one(values).getValue(0, 0);
//			             will(returnValue(4));
//			             
//			             one(values).getValue(0, 1);
//			             will(returnValue(null));
//			             
//			             one(values).getValue(0, 2);
//			             will(returnValue(-6));
//			             
//			             one(values).getValue(0, 3);
//			             will(returnValue(2));
//			  
			             
			         }
			     });
			     int[] validCols = {5};
			     double result = DataUtilities.calculateRowTotal(values, 0, validCols);
			     // verify
			     assertEquals(result, 0, .000000001d);
			 }
					
			 
	// ------- End of Test for CalculateRowTotal(Values2D data, int row, int[] validCols) double -------
			

	
     // -----------------------------------------------------------------------------------------
     // End of Test Code
     // -----------------------------------------------------------------------------------------
    
	 @After
	 public void tearDown() throws Exception {
	 }

	 @AfterClass
	 public static void tearDownAfterClass() throws Exception {
	 }
}
