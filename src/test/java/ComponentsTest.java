import ch.supsi.kevin.Main;
import ch.supsi.kevin.algos.brute.BruteForce;
import ch.supsi.kevin.algos.constructive.MultiFragment;
import ch.supsi.kevin.algos.constructive.NN;
import ch.supsi.kevin.algos.local_search.OneShift;
import ch.supsi.kevin.datastructure.City;
import ch.supsi.kevin.datastructure.TspData;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;
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
            List<City> list = NN.solve(map.get(title));
            System.out.println(OneShift.computeLength(list));
        }
    }


    @Test
    public void testMF(){
        Map<String, TspData> map = TspData.getDataFromFolder(Main.FOLDER_PATH);
        for(String title : map.keySet()){
            List<City> list = MultiFragment.solve(map.get(title));
            System.out.println(OneShift.computeLength(list));
        }
    }

    @Test @Ignore
    public void testMFfake(){
        Map<String, TspData> map = TspData.getDataFromFolder(Main.FOLDER_PATH);
        List<City> list = MultiFragment.solve(map.get("fake.tsp"));
        System.out.println(OneShift.computeLength(list));
    }

    @Test @Ignore
    public void testNNfake(){
        Map<String, TspData> map = TspData.getDataFromFolder(Main.FOLDER_PATH);
        List<City> list = NN.solve(map.get("fake.tsp"));
        System.out.println(OneShift.computeLength(list));
    }


    @Test @Ignore
    public void testBruteForcePermutations13(){
        String[] args1 = {"13"};
        BruteForce.main(args1);
    }

}
