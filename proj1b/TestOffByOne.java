import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();


    @Test// Your tests go here.
    public void testEqualChars(){
        assertTrue(offByOne.equalChars('a','b'));
        assertTrue(offByOne.equalChars('r','q'));
        assertFalse(offByOne.equalChars('a','e'));
        assertFalse(offByOne.equalChars('z','a'));
        assertFalse(offByOne.equalChars('a','a'));
        assertFalse(offByOne.equalChars('A', 'b'));
        assertTrue(offByOne.equalChars('&', '%'));
    }
}
