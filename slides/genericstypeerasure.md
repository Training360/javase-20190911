class: inverse, center, middle

# Generics - Type erasure

---

# Type erasure

* A fordító háttérben a típus paramétert `Object` típusra cseréli
* Elhelyezi a megfelelő típuskényszerítéseket
* Ugyanaz a kód fut minden paraméter típus esetén

---

# Type erasure

* _Reifiable type_: futásidőben rendelkezésre áll a típus információ
* _Non-reifiable types_: nem áll rendelkezésre
  * pl. `List<String>` és `List<Number>` között nincs különbség
  * Nem lehet használni pl. `instanceof` operátornál, vagy tömb elemeinek deklarálásakor
* _Heap polution_: ha futásidőben egy paraméteres típussal deklarált változó a nem neki megfelelő típusú objektumra tart referenciát
  * Compile warning
  * Következménye `ClassCastException`

---

# Heap polution raw type-ról konvertálással

```java
List<String> l = new ArrayList<>();
List l2 = l;
List<Integer> l3 = l2; // Unchecked assignment
l3.add(1);
System.out.println(l.get(0));
```

* Típus paraméter elvesztése tömb inicializációkor

```java
List<String>[] ss = new List[5]; // Unchecked assignment
```

`ClassCastException`

---

# Possible heap pollution

* Együtt használunk varargs metódust paraméterezett típussal

```java
static void m(List<String>... stringLists) {
    Object[] array = stringLists;
    List<Integer> tmpList = Arrays.asList(42);
    array[0] = tmpList;
    String s = stringLists[0].get(0);
}
```

* `Possible heap pollution from parameterized vararg type java.util.List<java.lang.String>`
* `@SafeVarargs` annotáció használata
  * Csak varargs metódusnál
  * `static` vagy `final` metódusnál
  * Használt pl. `Arrays.asList` metódusnál

---

# Bridge method alapprobléma

```java
public class Node<T> {

    public T data;

    public void setData(T data) {
        System.out.println("Node.setData");
        this.data = data;
    }
}
```

```java
public class MyNode extends Node<Integer> {

	@Override
    public void setData(Integer data) {
        System.out.println("MyNode.setData");
        super.setData(data);
    }
}
```

---

# Problémaleírás

* Ős osztályban `setData(Object)` metódussá fordul
* Leszármazottban `setData(Integer)` metódus van
	* Ez klasszikus értelemben overload, mégis `@Override` annotációval van ellátva
	* Nem teljesülne a dinamikus kötés őssé castoláskor
	
```java
MyNode mn = new MyNode();
Node n = mn; // WARNING
n.setData("Hello"); // Leszármazottban lévő metódusnak kellene meghívásra kerülnie
```

---

# Bridge metódus

* Szintetikus metódus
* Magunk nem implementálhatjuk, fordítási hiba

```java
class MyNode extends Node {

    // Generálát szintetikus metódus
    public void setData(Object data) {
        setData((Integer) data);
    }
	
    public void setData(Integer data) {
        System.out.println("MyNode.setData");
        super.setData(data);
    }
}
```

