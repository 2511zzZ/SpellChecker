package edit_distance;


import bayes.SaveModel;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class EditDistanceTest {
    private EditDistance ed = new EditDistance();
    private SaveModel sm = new SaveModel();
    private Map<String, Integer> model = sm.getModel();
    @Test
    public void getSimilarWords(){
        Assert.assertEquals(10, ed.getSimilarWords("whatever", model).size());
    }

}