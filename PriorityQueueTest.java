import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class PriorityQueueTest {

    PriorityQueue<Integer> expected = new PriorityQueue<>();
    int[] test = new int[4];

    public PriorityQueueTest(int a, int b, int c, int d, int e, int f, int g, int h){
        this.expected.add(e);
        this.expected.add(f);
        this.expected.add(g);
        this.expected.add(h);
        this.test[0] = a;
        this.test[1] = b;
        this.test[2] = c;
        this.test[3] = d;
    }

    @Parameters
    public static Collection getTestParameters(){
        return Arrays.asList(new Integer[][] {
                {4,5,6,8,5,4,8,6},
                {1,2,3,9,2,1,3,9},
                {0,1,5,8,5,0,8,1},
                {10,20,30,40,40,20,30,10},
                {1,100,1000,10000, 100, 10000, 1000, 1}
        });
    }

    @Test
    public void equal() {
        int i = 0;
        for(;i < 4;){
            assertEquals(test[i++], expected.poll().intValue());
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void testnoelement() throws NoSuchElementException {
        PriorityQueue<Integer> exception = new PriorityQueue<>();
        exception.remove();
    }

    @Test(expected = NullPointerException.class)
    public void testnull() throws NullPointerException {
        PriorityQueue<Integer> exception = new PriorityQueue<>();
        exception.add(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testillegal() throws IllegalArgumentException {
        PriorityQueue<Integer> exception = new PriorityQueue<>(0);
    }
}
