import org.junit.Assert;
import org.junit.Test;


public class HashMapTest {
    @Test
    public void putTest(){
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>(1);
        myHashMap.put("Ka", 2);
        Assert.assertTrue(myHashMap.containsKey("Ka"));
    }

    @Test
    public void sizeTest(){
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>(1);
        myHashMap.put("Ka", 2);
        Assert.assertEquals(1, myHashMap.size());
        myHashMap.put("KaK", 3);
        Assert.assertEquals(2, myHashMap.size());
    }

    @Test
    public void getTest(){
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>(1);
        myHashMap.put("Ka", 2);
        Integer answer = 2;
        Assert.assertEquals(answer, myHashMap.get("Ka"));
        Assert.assertNull(myHashMap.get("Ka1"));
    }

    @Test
    public void removeTest(){
        MyHashMap<String, Integer> myHashMapFirst = new MyHashMap<>(1);
        myHashMapFirst.put("Ka", 2);
        myHashMapFirst.put("Kak", 3);
        Integer answer = 3;
        Assert.assertEquals(answer, myHashMapFirst.remove("Kak"));
        Assert.assertNull(myHashMapFirst.remove("Kak1"));
    }

    @Test
    public void containsKeyTest(){
        MyHashMap<String, Integer> myHashMapFirst = new MyHashMap<>(1);
        myHashMapFirst.put("Kak", 3);
        Assert.assertTrue(myHashMapFirst.containsKey("Kak"));
        Assert.assertFalse(myHashMapFirst.containsKey("Kak1"));
    }
}
