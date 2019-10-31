import com.sberbank.CountMap;
import com.sberbank.CountMapRealization;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CountMapTests {

    @Test
    public void addTest() {
        CountMap<String> countMap = new CountMapRealization<>();
        countMap.add("123");
        countMap.add("123");
        Map<String, Integer> resultMap = new HashMap<>();
        Integer result = 2;
        resultMap.put("123", result);
        Assert.assertEquals(resultMap, countMap.asMap());
    }

    @Test
    public void countTest() {
        CountMap<String> countMap = new CountMapRealization<>();
        countMap.add("123");
        countMap.add("123");
        Assert.assertEquals(2, countMap.count("123"));
    }

    @Test
    public void removeTest() {
        CountMap<String> countMap = new CountMapRealization<>();
        countMap.add("123");
        countMap.add("123");
        countMap.add("321");
        Assert.assertEquals(1, countMap.remove("321"));
        Assert.assertEquals(2, countMap.remove("123"));
    }

    @Test
    public void sizeTest() {
        CountMap<String> countMap = new CountMapRealization<>();
        countMap.add("123");
        countMap.add("123");
        countMap.add("321");
        Assert.assertEquals(2, countMap.size());

    }

    @Test
    public void asMapTest() {
        CountMap<String> countMap = new CountMapRealization<>();
        countMap.add("123");
        countMap.add("123");
        Map<String, Integer> resultMap = new HashMap<>();
        Integer result = 2;
        resultMap.put("123", result);
        Assert.assertEquals(resultMap, countMap.asMap());

    }

    @Test
    public void copyToTest() {
        CountMap<String> countMap = new CountMapRealization<>();
        countMap.add("123");
        countMap.add("123");
        Map<Object, Integer> firstMap = new HashMap<>();
        countMap.copyTo(firstMap);
        Map<Object, Integer> resultMap = new HashMap<>();
        Integer result = 2;
        resultMap.put("123", result);
        Assert.assertEquals(resultMap, firstMap);
    }

    @Test
    public void addAll() {
        CountMap<Object> countMap = new CountMapRealization<>();
        CountMap<String> resultMap = new CountMapRealization<>();
        resultMap.add("123");
        resultMap.add("234");
        countMap.addAll(resultMap);
        Assert.assertEquals(countMap.asMap(), resultMap.asMap());
    }

}
