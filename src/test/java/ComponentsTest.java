import ch.supsi.kevin.algos.brute.BruteForce;
import org.junit.Ignore;
import org.junit.Test;


public class ComponentsTest {

    @Test
    public void testFileConverter(){

    }

    @Test
    public void testBruteForcePermutations5(){
        String[] args1 = {"5"};
        BruteForce.main(args1);
    }

    @Test @Ignore
    public void testBruteForcePermutations12(){
        String[] args1 = {"12"};
        BruteForce.main(args1);
    }


    @Test @Ignore
    public void testBruteForcePermutations13(){
        String[] args1 = {"13"};
        BruteForce.main(args1);
    }

}
