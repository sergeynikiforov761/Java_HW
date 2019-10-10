import java.util.Arrays;

public class MyHashMap<K, V> {

    private int size;
    private V[] values;
    private K[] keys;
    private boolean[] deleted;
    private int currentSize = 0;

    MyHashMap(int size){
        if(size < 0){
            throw new IllegalArgumentException("initial size must be greater than 0: " + size);
        }
        this.size = size;
        values = (V[]) new Object[this.size];
        keys = (K[]) new Object[this.size];
        deleted =  new boolean[this.size];
        Arrays.fill(values, null);
        Arrays.fill(keys, null);
    }

    int size(){
        return size;
    }

    private void resize() {
        int new_size = size * 2;
        V[] new_values = (V[]) new Object[new_size];
        K[] new_keys = (K[]) new Object[new_size];
        boolean[] new_deleted = new boolean[new_size];

        for (K key: keys) {
            int current_index = index(hash(key));
            new_keys[current_index] = key;
            new_values[current_index] = get(key);
            new_deleted[current_index] = deleted[current_index];
        }

        this.size = new_size;
        this.keys = new_keys;
        this.values = new_values;
        this.deleted = new_deleted;
    }

    void put(K key, V value) {
        if(currentSize == size){
            resize();
        }
        for(int i = index(hash(key)) ; ; i++) {
            if (i == size){
                i = 0;
            }
            if (keys[i] == null){ // FIXME (NEED TO FILL WITH VALUES) AND RESIZE
                keys[i] = key;
            }
            if (keys[i] == key) {
                values[i] = value;
                deleted[i] = false;
                currentSize++;
                return;
            }
        }
    }

    public boolean containsKey(K key){
        for(int i = index(hash(key));;i++){
            if (i == this.size){
                i = 0;
            }
            if (deleted[i]){
                return false;
            }
            if(this.keys[i] == null){ //FIXME
                return false;
            }
            if(this.keys[i].equals(key)){
                return true;
            }
        }
    }

    private void setDeleted(int index){
        deleted[index] = true; // FIXME Add check for out of range ??
        keys[index] = null;
        values[index] = null;
    }

    public V get(K key) {
        for(int i = index(hash(key)) ; ; i++){
            if (i == size) {
                i = 0;
            }
            if (deleted[i]){
                return null;
            }
            if (keys[i] == null) { //FIXME AND CHECK FOR DELETED CELLS
                return null;
            }
            if (keys[i].equals(key)){
                return values[i];
            }
        }
    }

    public V remove(K key){
        if(currentSize == 0){
            return null;         // FIXME ADD LOGIC
        }
        for(int i = index(hash(key)) ; ; i++){
            if (i == size) {
                i = 0;
            }
            if (deleted[i]){
                return null;
            }
            if (keys[i] == null) { //FIXME AND CHECK FOR DELETED CELLS
                return null;
            }
            if (keys[i].equals(key)){
                V deletedValue = values[i];
                this.setDeleted(i);
                currentSize--;
                return deletedValue;
            }
        }

    }

    private int hash(K key) {
        return key.hashCode(); // FIXME
    }

    /* возвращает отсуп для данного значения хэш-функции */
    private int index(int hash) {  // FIXME
        return Math.abs(hash) % size;
    }
}