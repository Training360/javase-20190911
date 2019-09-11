class: inverse, center, middle



# Map interfész és implementációi

---

# `Map` interfész

* Kulcs – érték párokat tárol
* Két generikus típus, kulcs és érték
* `Map.Entry` interfész

---

# `Map` implementációk

* `HashMap`
  * `hashCode()` metódust használja
  * bucket (tömbbe szervezve)
  * `equals()` metódus
  * Bejárás sorrendje nem definit
* `LinkedHashMap`
  * A bucketek tömbje mellett egy kétirányban láncolt listát is karbantart
  * Bejárás sorrendje a tárolás sorrendje
* `TreeMap`
  * Keresőfa alapú megvalósítás (piros-fekete fa, mely egy önkiegyensúlyozó bináris keresőfa)

---

# `Map` interfész metódusai 1

* `boolean isEmpty()`
* `int size()`
* `void clear()`
* `V get(Object key)`
* `V put(K key, V value)`
* `V remove(Object key)`

---

# `Map` interfész metódusai 2

* `boolean containsKey(Object key)`
* `boolean containsValue(Object)`
* `Set<Map.Entry<K,V>> entrySet()`
* `Set<K> keySet()`
* `Collection<V> values()`
