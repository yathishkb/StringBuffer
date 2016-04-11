import junit.framework.TestCase;

public class StringBufferImplTest extends TestCase {
	String globalString;
	public void setUp(){
		StringBufferImpl sbImpl = new StringBufferImpl("HELLO-");		
		sbImpl.append("WORLD");
		globalString=sbImpl.toString();
		//System.out.println("globalString: "+globalString);
	}
	
	public void testAdd() {
		//System.out.println(": "+globalString);
		assertTrue("HELLO-WORLD".equalsIgnoreCase(globalString));
	}

}
