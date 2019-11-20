import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

class MediaLibraryTester {
	private static MediaLibrary ml;
	private static boolean setupDone = false;
	
	
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
	  ml = MediaLibrary.getInstance();
	}
	
	@After
	public static void tearDown() {
	  ml.clearLibrary();
	}
	
	@Test
	public void testAddNewMedia() {
	  setup();
	  assertTrue(ml.searchMedia("Fear").isEmpty());
	  Media m = new Book("book","Fear and Loathing in Las Vegas","1980",4.95,"good",
	      false,"Fiction","Hunter S. Thompson","1234-5678","Some Books");
	  ml.addNewMedia(m);
	  assertFalse(ml.searchMedia("Fear").isEmpty());
	  tearDown();
	}
	
	@Test
	public void testAddCopy() {
	  setup();
      assertTrue(ml.searchMedia("Fear").isEmpty());
      Media m = new Book("book","Fear and Loathing in Las Vegas","1980",4.95,"good",
          false,"Fiction","Hunter S. Thompson","1234-5678","Some Books");
      ml.addNewMedia(m);
      assertTrue(ml.searchMedia("Fear").get(0).getNumCopies() == 1);
	  assertTrue(ml.addCopy("book", "Fear and Loathing in Las Vegas"));
	  assertTrue(ml.searchMedia("Fear").get(0).getNumCopies() == 2);
	  tearDown();
	}
	
	@Test
    public void testAddCopyFail() {
      setup();
      assertTrue(ml.searchMedia("Fear").isEmpty());
      Media m = new Book("book","Fear and Loathing in Las Vegas","1980",4.95,"good",
          false,"Fiction","Hunter S. Thompson","1234-5678","Some Books");
      ml.addNewMedia(m);
      assertTrue(ml.searchMedia("Fear").get(0).getNumCopies() == 1);
      assertFalse(ml.addCopy("dvd", "Fear and Loathing in Las Vegas"));
      assertTrue(ml.searchMedia("Fear").get(0).getNumCopies() == 1);
      tearDown();
    }
	
	@Test
    public void testRemoveCopy() {
      setup();
      assertTrue(ml.searchMedia("Fear").isEmpty());
      Media m = new Book("book","Fear and Loathing in Las Vegas","1980",4.95,"good",
          false,"Fiction","Hunter S. Thompson","1234-5678","Some Books");
      ml.addNewMedia(m);
      assertTrue(ml.searchMedia("Fear").get(0).getNumCopies() == 1);
      assertTrue(ml.removeCopy("book","Fear and Loathing in Las Vegas"));
      assertTrue(ml.searchMedia("Fear").get(0).getNumCopies() == 0);
      tearDown();
    }
	
	@Test
    public void testRemoveCopyFail() {
      setup();
      assertTrue(ml.searchMedia("Fear").isEmpty());
      Media m = new Book("book","Fear and Loathing in Las Vegas","1980",4.95,"good",
          false,"Fiction","Hunter S. Thompson","1234-5678","Some Books");
      ml.addNewMedia(m);
      assertTrue(ml.searchMedia("Fear").get(0).getNumCopies() == 1);
      assertTrue(ml.removeCopy("book","Fear and Loathing in Las Vegas"));
      assertTrue(ml.searchMedia("Fear").get(0).getNumCopies() == 0);
      assertFalse(ml.removeCopy("book","Fear and Loathing in Las Vegas"));
      assertTrue(ml.searchMedia("Fear").get(0).getNumCopies() == 0);
      tearDown();
    }
	
	@Test
    public void testCheckWaitListAvail() {
      setup();
      assertTrue(ml.searchMedia("Fear").isEmpty());
      Media m = new Book("book","Fear and Loathing in Las Vegas","1980",4.95,"good",
          false,"Fiction","Hunter S. Thompson","1234-5678","Some Books");
      ml.addNewMedia(m);
      assertTrue(ml.searchMedia("Fear").get(0).getNumCopies() == 1);
      assertTrue(ml.removeCopy("book","Fear and Loathing in Las Vegas"));
      assertTrue(ml.searchMedia("Fear").get(0).checkoutMedia());
      ml.searchMedia("Fear").get(0).addToWaitList("Bob");
      assertTrue(ml.checkWaitListAvail("Bob").isEmpty());
      assertTrue(ml.addCopy("book", "Fear and Loathing in Las Vegas"));
      assertFalse(ml.checkWaitListAvail("Bob").isEmpty());
      tearDown();
    }
	
	@Test
    public void testMediaLoader() {
      setup();
      assertTrue(ml.isEmpty());
      MediaLoader.loadMedia();
      assertFalse(ml.isEmpty());
      tearDown();
    }
	
	@Test
	public void testSomething() {
	  setup();
	  
	  tearDown();
	}
	
}
