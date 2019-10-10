import com.sberbank.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CollectionUtilsTest {

    @Test
    public void removeAllTest() {
        List<Integer> intArrayList = new ArrayList<>();
        List<Object> objectIntArrayList = new ArrayList<>();

        intArrayList.add(1);
        intArrayList.add(2);
        intArrayList.add(3);

        objectIntArrayList.add(4);
        objectIntArrayList.add(5);
        objectIntArrayList.add(2);

        List<Object> resultObjectIntArrayList = new ArrayList<>();
        resultObjectIntArrayList.add(4);
        resultObjectIntArrayList.add(5);


        CollectionUtils.removeAll(objectIntArrayList, intArrayList);
        Assert.assertEquals(resultObjectIntArrayList, objectIntArrayList);
    }

    @Test
    public void containsAllTest() {
        List<Integer> intArrayList = new ArrayList<>();
        List<Object> objectIntArrayListFirst = new ArrayList<>();
        List<Object> objectIntArrayListSecond = new ArrayList<>();

        intArrayList.add(1);
        intArrayList.add(2);
        intArrayList.add(3);

        objectIntArrayListFirst.add(4);
        objectIntArrayListFirst.add(5);
        objectIntArrayListFirst.add(2);

        objectIntArrayListSecond.add(1);
        objectIntArrayListSecond.add(2);
        objectIntArrayListSecond.add(3);
        objectIntArrayListSecond.add(4);

        Assert.assertEquals(false, CollectionUtils.containsAll(objectIntArrayListFirst, intArrayList));
        Assert.assertEquals(true, CollectionUtils.containsAll(objectIntArrayListSecond, intArrayList));
    }

    @Test
    public void containsAnyTest() {
        List<Integer> intArrayList = new ArrayList<>();
        List<Object> objectIntArrayListFirst = new ArrayList<>();
        List<Object> objectIntArrayListSecond = new ArrayList<>();

        intArrayList.add(1);
        intArrayList.add(2);
        intArrayList.add(3);

        objectIntArrayListFirst.add(4);
        objectIntArrayListFirst.add(5);
        objectIntArrayListFirst.add(6);

        objectIntArrayListSecond.add(1);
        objectIntArrayListSecond.add(5);
        objectIntArrayListSecond.add(6);
        objectIntArrayListSecond.add(7);

        Assert.assertEquals(false, CollectionUtils.containsAny(objectIntArrayListFirst, intArrayList));
        Assert.assertEquals(true, CollectionUtils.containsAny(objectIntArrayListSecond, intArrayList));
    }

    @Test
    public void indexOfTest() {
        List<Object> intArrayList = new ArrayList<>();
        intArrayList.add(1);
        intArrayList.add(2);
        intArrayList.add(3);
        Integer one = 1;

        Assert.assertEquals(0, CollectionUtils.indexOf(intArrayList, one));
    }

    @Test
    public void addTest() {
        List<Object> intArrayList = new ArrayList<>();
        List<Object> intArrayListResult = new ArrayList<>();
        intArrayListResult.add(1);
        Number one = 1;
        CollectionUtils.add(intArrayList, 1);
        Assert.assertEquals(intArrayListResult, intArrayList);
    }

    @Test
    public void limitTest() {
        List<Object> intArrayList = new ArrayList<>();
        intArrayList.add(1);
        intArrayList.add(2);
        intArrayList.add(3);

        List<Object> resultArrayList = new ArrayList<>();
        resultArrayList.add(1);
        resultArrayList.add(2);

        Assert.assertEquals(resultArrayList, CollectionUtils.limit(intArrayList, 2));


    }

    @Test
    public void newArrayListTest() {
        Assert.assertEquals(new ArrayList<String>(), CollectionUtils.newArrayList());
    }

    @Test
    public void addAllTest() {
        List<Integer> firstArrayList = new ArrayList<>();
        firstArrayList.add(1);
        firstArrayList.add(2);
        firstArrayList.add(3);

        List<Object> secondArrayList = new ArrayList<>();
        secondArrayList.add(4);
        secondArrayList.add(5);

        CollectionUtils.addAll(firstArrayList, secondArrayList);

        List<Object> resultArrayList = new ArrayList<>();
        resultArrayList.add(4);
        resultArrayList.add(5);
        resultArrayList.add(1);
        resultArrayList.add(2);
        resultArrayList.add(3);

        Assert.assertEquals(resultArrayList, secondArrayList);

    }

    @Test
    public void rangeTest() {
        List<Integer> intArrayList = new ArrayList<>();
        intArrayList.add(1);
        intArrayList.add(2);
        intArrayList.add(3);
        intArrayList.add(4);
        intArrayList.add(5);
        intArrayList.add(6);

        Integer minValue = 3;
        Integer maxValue = 5;

        List<Integer> realArrayList = new ArrayList<>();
        realArrayList.add(3);
        realArrayList.add(4);
        realArrayList.add(5);

        List<Integer> resultFirstList = CollectionUtils.range(intArrayList, minValue, maxValue);
        Assert.assertEquals(realArrayList, resultFirstList);

        List<Integer> resultSecondList = CollectionUtils.range(intArrayList, minValue, maxValue,Integer::compareTo);
        Assert.assertEquals(realArrayList, resultSecondList);
    }
}
