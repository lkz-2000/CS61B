import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestOffByN {
    static CharacterComparator offBy2 = new OffByN(2);
    static CharacterComparator offBy1 = new OffByN(1);
    static CharacterComparator offBy0 = new OffByN(0);

    @Test
    public void testEqualChars(){
        assertTrue(offBy2.equalChars('a','c'));
        assertFalse(offBy2.equalChars('r','q'));
        assertFalse(offBy1.equalChars('a','e'));
        assertFalse(offBy1.equalChars('z','a'));
        assertTrue(offBy0.equalChars('a','a'));
        assertFalse(offBy0.equalChars('A', 'b'));
        assertTrue(offBy1.equalChars('&', '%'));
    }
}
