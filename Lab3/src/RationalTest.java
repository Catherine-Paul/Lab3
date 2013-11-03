import static org.junit.Assert.*;

import org.junit.Test;



import junit.framework.TestCase;

public class RationalTest extends TestCase {

    protected Rational HALF;

    protected void setUp() {
      HALF = new Rational( 1, 2 );
    }

    // Create new test
    public RationalTest (String name) {
        super(name);
    }

    public void testEquality() {
        assertEquals(new Rational(1,3), new Rational(1,3));
        assertEquals(new Rational(1,3), new Rational(2,6));
        assertEquals(new Rational(3,3), new Rational(1,1));
    }

    // Test for nonequality
    public void testNonEquality() {
        assertFalse(new Rational(2,3).equals(
            new Rational(1,3)));
    }

    public void testAccessors() {
    	assertEquals(new Rational(2,3).numerator(), 2);
    	assertEquals(new Rational(2,3).denominator(), 3);
    }

    public void testRoot() {
        Rational s = new Rational( 1, 4 );
        Rational sRoot = null;
        try {
            sRoot = s.root();
        } catch (IllegalArgumentToSquareRootException e) {
            e.printStackTrace();
        }
        assertTrue( sRoot.isLessThan( HALF.plus( Rational.getTolerance() ) ) 
                        && HALF.minus( Rational.getTolerance() ).isLessThan( sRoot ) );
    }
    
    //Additional Test cases
    
    public void testplus() {
        assertEquals((new Rational(3,1).plus(new Rational(3,1))),new Rational(6,1));
        assertEquals((new Rational(3,4).plus(new Rational(5,12))),new Rational(7,6));
        assertEquals((new Rational(-3,4).plus(new Rational(5,12))),new Rational(-1,3));
    }

    public void testTimes() {
    	assertEquals((new Rational(5, 3)).times(new Rational(9, 2)), new Rational(15, 2));
            }
    
    public void testMinus() {
    	assertEquals((new Rational(2, 3)).minus(new Rational(3, 2)), new Rational(-5, 6));
            }
    
    public void testisLessThan()
    {
    	 assertTrue(new Rational(1,3).isLessThan(new Rational(2,3)));
    	 assertTrue(new Rational(-2,3).isLessThan(new Rational(-1,3)));
    }
    
    public void testDivides() {
    	Rational a = new Rational(4, 3);
    	Rational b = new Rational(5, 6);
    	Rational c = new Rational(8, 5);
    	assertEquals(a.divides(b), c);
    	
        Rational a1 = new Rational(-4, 3);
    	Rational b1 = new Rational(5, 6);
    	Rational c1 = new Rational(-8, 5);
    	assertEquals(a.divides(b), c);
            }
    
    public void testDivideByZero() {
    	boolean testflag = false;
    	try {
    		Rational a = new Rational(4, 0);
        	}     	
    	catch (Exception e) {
        	//divide by zero should cause exception
            testflag = true;
        }
        assertTrue( testflag);
    	    }
    
    public void testoString() {
    	Rational a = new Rational(7, 1);
    	String b = "7";
    	//assertEquals(a.toString(), b);
        System.out.println("\n Conversion of rational numbers toString : " + a.toString()+"\n");
    } 
    public void testabs() {
    	Rational a = new Rational(-4, -3);
    	Rational b = new Rational(4, 3);  	
    	assertEquals(a.abs(), b);
            }
    
    public void testgcd() {
        Rational myRational = new Rational(10, 5);
        
        try {
    	    java.lang.reflect.Method gcd_method = 
            Rational.class.getDeclaredMethod("gcd", int.class, int.class); 
    	    gcd_method.setAccessible(true);
    	    Object result = gcd_method.invoke(myRational,10 , 5 ); 
    	    assertEquals(5, result);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void testlcm() {
        Rational myRational = new Rational(6, 8);
        
        try {
            java.lang.reflect.Method lcm_method 
            = Rational.class.getDeclaredMethod("lcm", int.class, int.class); 
            lcm_method.setAccessible(true);
            Object result = lcm_method.invoke(myRational,6 , 8 ); 
            assertEquals(24, result);
            } catch (Exception e) {
           e.printStackTrace();
        }
    }
    
    public void testSqRoot() {
        Rational s = new Rational( 1, 4 );
        Rational sRoot = null;
        try {
            sRoot = s.root();
        } catch (IllegalArgumentToSquareRootException e) {
            e.printStackTrace();
        }
        assertEquals(sRoot, new Rational( 1, 2 ));
    }
    
    public void testRootforhigh() {
        Rational s = new Rational( 46342, 1);
        Rational sRoot = null;
        try {
            sRoot = s.root();
        } catch (IllegalArgumentToSquareRootException e) {
            assertEquals(sRoot, null);
        }
       
    }
    
    public void testRootforlow() {
        Rational s = new Rational( -1, 3);
        Rational sRoot = null;
        try {
            sRoot = s.root();
        } catch (IllegalArgumentToSquareRootException e) {
            assertEquals(sRoot, null);
        }
        
    }
    
    
   
    
    public static void main(String args[]) {
        String[] testCaseName = 
            { RationalTest.class.getName() };
        // junit.swingui.TestRunner.main(testCaseName);
        junit.textui.TestRunner.main(testCaseName);
    }
}