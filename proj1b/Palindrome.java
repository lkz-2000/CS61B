public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> deque=new ArrayDeque<>();
        for(int i=0;i<word.length();i++){
            deque.addLast(word.charAt(i));
        }
        return deque;
    }
    public boolean isPalindrome(String word){
        Deque a=new ArrayDeque();
        a=wordToDeque(word);
        while(a.size()>1){
            if(a.removeFirst()!=a.removeLast()){
                return false;
            }
        }
        return true;
    }
    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque a=new ArrayDeque();
        a=wordToDeque(word);
        while(a.size()>1){
            if(!cc.equalChars((Character) a.removeFirst(),(Character)a.removeLast())){
                return false;
            }
        }
        return true;
    }
}
