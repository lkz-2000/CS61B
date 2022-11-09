import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
    static CharacterComparator cc = new OffByOne();
    @Test
    public void testisPalindrome(){
        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("horse"));
        assertFalse(palindrome.isPalindrome("aaaaab"));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("A"));
        assertTrue(palindrome.isPalindrome(" "));
        assertTrue(palindrome.isPalindrome(" ",cc));
        assertTrue(palindrome.isPalindrome("ab",cc));
        assertFalse(palindrome.isPalindrome("ac",cc));
        assertTrue(palindrome.isPalindrome("a",cc));
    }
}
