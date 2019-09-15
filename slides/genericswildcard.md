class: inverse, center, middle

# Generics - Wildcards

---

# Wildcard használata

```java
public String elements(List<Object> elements, String separator) {
  StringBuilder sb = new StringBuilder();
  for (Object e: elements) {
    sb.append(e.toString()).append(separator);
  }
  return sb.toString();
}
```

```java
List<Object> objects = new ArrayList<>();
elements(objects); // Lefordul

List<String> strings = new ArrayList<>()
elements(strings); // NEM FORDUL LE
```

* A `List<String>` nem leszármazottja a <br /> `List<Object>` paraméterezett osztálynak

---

# Unbounded wildcard, nem ismert típus

```java
public String elements(List<?> elements, String separator) {
  // ...
}
```

* Kizárólag az `Object` metódusai használhatóak

```java
List<?> commands = new ArrayList<Object>();
List<?> names = new ArrayList<String>();
```

---

# Leszármazási viszony

![Öröklődés UML](images/hierarchy.png)

---

# Upper-bounded wildcard 1

```java
public String names(List<? extends Human> humans) {
  // ...
  StringBuilder sb = new StringBuilder();
  for (Human h: humans) {
    sb.append(h.getName()).append(", ");
  }
  return sb.toString();
}
```
Milyen listával hívható?

---

# Upper-bounded wildcard 2

```java
List<? extends Human> l = new ArrayList<Human>(); // Lefordul
List<? extends Human> l = new ArrayList<Trainer>(); // Lefordul
List<? extends Human> l = new ArrayList<Object>(); // NEM FORDUL LE!
```

* `Human` metódusok elérhetőek
* Felső korlát, hierarchiában legmagasabban lévő típus, mely átadható, a `Human`

---

# Upper-bounded wildcard UML

![Upper-bounded wildcard UML](images/wc_upperbound.png)

---

# Upper-bounded wildcard limitációk

```java
public void add(List<? extends Human> humans) {
  humans.add(new Human()); // Nem fordul le, hiszen kaphat List<Trainer> listát
  humans.add(new Trainer()); // Nem fordul le, hiszen kaphat List<Student> listát
}
```

* Az így átadott kollekciók logikailag módosíthatatlanok

---

# Lower-bounded wildcard

```java
public void add(List<? super Human> humans) {
  humans.add(new Human());
  humans.add(new Trainer());
}
```

```java
List<? super Human> l = new ArrayList<Object>(); // Lefordul
List<? super Human> l = new ArrayList<Human>(); // Lefordul
List<? super Human> l = new ArrayList<Trainer>(); // NEM FORDUL LE!
```

* Alsó korlát, hierarchiában legalacsonyabban lévő típus, mely átadható, a `Human`
* Csak az `Object` metódusok elérhetőek, a `Human` metódusok nem

---

# Lower-bounded wildcard UML

![Lower-bounded wildcard UML](images/wc_lowerbound.png)