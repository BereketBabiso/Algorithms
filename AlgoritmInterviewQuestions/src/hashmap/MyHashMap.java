package hashmap;

import java.util.Arrays;
import java.util.Objects;

/**
 * Implementation of custom hashmap with bucket size of 16. 
 * Note that no concept of load-factor used here and also this
 * simple implementation considers a single entry per slot. Hence,
 * the code is open for extension to accommodate the aforementioned 
 * implementation.
 * @author bereket.
 *
 * @param <K>
 * @param <V>
 */
public class MyHashMap<K, V> implements Map<K, V> {

  // use defualt hashmap slots of 16.
  Entry<K, V>[] bucket = new Entry[16];

  public boolean put(K key, V value) {
    int hashvalue = Objects.hashCode(key);
    int bucketIndex = hashvalue % 16;
    Entry<K, V> newEntry = new Entry<K, V>(key, value);
    bucket[bucketIndex] = newEntry;
    return true;
  }

  public V remove(K key) {
    return removeEntryForKey(key);
  }

  private V removeEntryForKey(K key) {
    int hashValue = Objects.hashCode(key);
    int bucketIndex = hashValue % 16;
    Entry<K, V> e = bucket[bucketIndex];
    if (null == e) return null;
    V value = e.getValue();
    bucket[bucketIndex] = null;
    return value;

  }

  public Entry<K, V>[] getBucket() {
    return bucket;
  }

  public static class Entry<K, V> {
    private K key;
    private V value;

    public Entry(K k, V v) {
      this.key = k;
      this.value = v;
    }

    public V getValue() {
      return value;
    }

    @Override
    public String toString() {
      return "{key : " + key + ", value : " + value + "}";
    }
  }

  public static void main(String[] args) {
    MyHashMap<String, String> map = new MyHashMap<>();
    map.put("name", "bereket");
    map.put("age", "31");
    map.remove("name");
    Arrays.asList(map.getBucket()).parallelStream().filter(entry -> entry != null)
        .forEach(System.out::println);
  }
}