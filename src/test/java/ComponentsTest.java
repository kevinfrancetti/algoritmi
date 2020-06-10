import ch.supsi.kevin.Main;
import ch.supsi.kevin.algos.brute.BruteForce;
import ch.supsi.kevin.algos.constructive.MultiFragment;
import ch.supsi.kevin.algos.constructive.NN;
import ch.supsi.kevin.datastructure.TspData;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;


public class ComponentsTest {

    @Test @Ignore
    public void testFileConverter(){

    }

    @Test @Ignore
    public void testBruteForcePermutations5(){
        String[] args1 = {"5"};
        BruteForce.main(args1);
    }

    @Test
    public void testNN(){
        Map<String, TspData> map = TspData.getDataFromFolder(Main.FOLDER_PATH);
        for(String title : map.keySet()){
            NN.solve(map.get(title));
        }
    }


    @Test
    public void testMF(){
        Map<String, TspData> map = TspData.getDataFromFolder(Main.FOLDER_PATH);
        for(String title : map.keySet()){
            MultiFragment.solve(map.get(title));
        }
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
