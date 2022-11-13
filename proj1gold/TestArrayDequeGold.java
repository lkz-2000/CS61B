import static org.junit.Assert.*;
import org.junit.Test;
public class TestArrayDequeGold {
    @Test
    public void randomtest(){
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> sad2=new ArrayDequeSolution<>();
        StringBuilder msg = new StringBuilder();

        for (Integer i = 0; i < 500; i += 1) {
            int n=0;
            double numberBetweenZeroAndOne = StdRandom.uniform();
            if(i%5==0){
                msg.append("size()\n");
                assertEquals(msg.toString(),sad1.size(),sad2.size());
            }
            if (numberBetweenZeroAndOne < 0.25) {
                sad1.addLast(i);
                sad2.addLast(i);
                n++;
                msg.append("addLast("+i+")\n");
                assertEquals(msg.toString(),sad1.get(n-1),sad2.get(n-1));
            }
            else if (numberBetweenZeroAndOne < 0.5){
                sad1.addFirst(i);
                sad2.addFirst(i);
                n++;
                msg.append("addFirst("+i+")\n");
                assertEquals(msg.toString(),sad1.get(0),sad2.get(0));
            }
            else if (numberBetweenZeroAndOne < 0.75&&!sad1.isEmpty()&&!sad2.isEmpty()){
                Integer x= sad1.removeFirst();
                Integer y=sad2.removeFirst();
                n--;
                msg.append("removeFirst()\n");
                assertEquals(msg.toString(),x,y);
            }
            else if(!sad1.isEmpty()&&!sad2.isEmpty()){
                Integer x=sad1.removeLast();
                Integer y=sad2.removeLast();
                n--;
                msg.append("removeLast()\n");
                assertEquals(msg.toString(),x,y);
            }
        }

    }
}
