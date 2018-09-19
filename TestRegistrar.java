
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pedro
 */
public class TestRegistrar {
    
   @Test
	public void testCanRegister_1() {

		Registrar R = new Registrar();
		boolean actual = R.canRegister(16, 2.99);
		boolean expected = false;
		
		assertEquals(expected, actual);
	}

	@Test
	public void testCanRegister_2() {

		Registrar R = new Registrar();
		boolean actual = R.canRegister(16, 3.0);
		boolean expected = true;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCanRegister_3() {
		// New rule: student with gpa < 2.0 cannot register
		// without advisor override.
		Registrar R = new Registrar();
		boolean actual = R.canRegister(1, 1.99);
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCanRegister_4() {
		// New rule: student with gpa < 2.0 cannot register
		// with advisor override.
		Registrar R = new Registrar();
		R.setOverride(true);
		boolean actual = R.canRegister(1, 1.99);
		boolean expected = true;
		
		assertEquals(expected, actual);
	}
	
	//All test cases from above are directly from the video
	
	@Test
	public void testCanRegisterLastFrame_1() {
		// Case 1 from last frame chart
		Registrar R = new Registrar();
		R.setOverride(true);
		boolean actual = R.canRegister(10, 4.0);
		boolean expected = true;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCanRegisterLastFrame_2() {
		// Case 2 from last frame chart
		Registrar R = new Registrar();
		R.setOverride(false);
		boolean actual = R.canRegister(10, 1.5);
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCanRegisterLastFrame_3() {
		// Case 3 from last frame chart
		Registrar R = new Registrar();
		R.setOverride(false);
		boolean actual = R.canRegister(10, 2.5);
		boolean expected = true;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCanRegisterLastFrame_4() {
		// Case 4 from last frame chart
		Registrar R = new Registrar();
		R.setOverride(false);
		boolean actual = R.canRegister(10, 3.5);
		boolean expected = true;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCanRegisterLastFrame_5() {
		// Case 5 from last frame chart
		Registrar R = new Registrar();
		R.setOverride(false);
		boolean actual = R.canRegister(20, 2.5);
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	// These test cases below are the 4 extra
	@Test
	public void testCanRegister_6() {
		// This method will test to see if the override can not be used for a student who has a gpa below 1.0
		// with advisor override.
		Registrar R = new Registrar();
		R.setOverride(true);
		boolean actual = R.canRegister(18, .99);
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCreditCost_1() {
		/*
		This method will designate if the the student has to pay a per credit premium while seeking an undergraduate degree.
		This method also has an override so that an advisor can waive the additional fee if needed.
		If boolean value of true is returned the student will have to pay a per credit cost times 2, if it is false than no premium will be applied.
		Test 1 is testing the advisor override.
		 */
		Registrar R = new Registrar();
		R.setOverride(true);
		boolean actual = R.creditCost(125);
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCreditCost_2() {
		/*
		This method will designate if the the student has to pay a per credit premium while seeking an undergraduate degree.
		This method also has an override so that an advisor can waive the additional fee if needed.
		If boolean value of true is returned the student will have to pay a per credit cost times 2, if it is false than no premium will be applied.
		Test 2 is testing the method with the override set to false.
		 */
		Registrar R = new Registrar();
		R.setOverride(false);
		boolean actual = R.creditCost(125);
		boolean expected = true;// the student will have to pay the premium since no override has been set and they have over 120 total credits 
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCourseRegistration_1() {
		/*
		 * This method will test if a student can register for a course. If the student has taken the course more than three times
		 * they can no longer take the course unless they get an override
		 */
		Registrar R = new Registrar();
		R.setOverride(true);
		boolean actual = R.courseRegistration(5);
		boolean expected = true;
		
		assertEquals(expected, actual);
	}	
}
