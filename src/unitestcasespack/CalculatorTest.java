package unitestcasespack;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

	@AfterEach
	public void bfore () {
		System.out.println("Test case run");
			
	}
		
	@Test
	public void addtest () {
		
		  NewFile test = new NewFile();
		  int g = test.add(500, 500);
		  Assertions.assertEquals(1000, g);
	}
	
	@Disabled ("Until practicing")
	@Test
	
	public void multiplytest() {
		  
		NewFile test = new NewFile();
		int n = test.multiply(4, 3);
		Assertions.assertEquals(10, n);
			  
	}
	
	
}
