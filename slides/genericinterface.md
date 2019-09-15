class: inverse, center, middle



# Generic interface

---

# Generic interface

* Elsősorban API fejlesztés során kerül elő, alkalmazás fejlesztésnél ritkán indokolt
* Tipikus példa a `Comparable<T>` interfész

---

# Saját generic interface

```java
public interface Pair<K, V> {
    public K getKey();
    public V getValue();
}

public class OrderedPair<K, V> implements Pair<K, V> {

    private K key;
    private V value;

    public OrderedPair(K key, V value) {
		this.key = key;
		this.value = value;
    }

    public K getKey()	{ return key; }
    public V getValue() { return value; }
}
```

```java
Pair<String, Integer> p1 = new OrderedPair<>("Even", 8);
Pair<String, String>  p2 = new OrderedPair<>("hello", "world");
```
