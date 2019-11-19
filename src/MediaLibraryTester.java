import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

class MediaLibraryTester {
	private static MediaLibrary ml;
	
	
	@BeforeClass
	public static void oneTimeSetup() {
		assertNull(ml);
		// instantiate the MediaLibrary instance
		ml = MediaLibrary.getInstance();
		// run again to check that only one instance is ever made
		ml = MediaLibrary.getInstance();
	}
	
	@AfterClass
	public static void oneTimeTearDown() {
		
	}
	
	@Before
	public static void setup() {

	}
	
	@After
	public static void tearDown() {
		
	}
	
	@Test
	public void testAddNewMedia() {
		
	}
	
}
