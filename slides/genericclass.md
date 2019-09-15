class: inverse, center, middle

# Generics használata saját osztályban és a bound fogalma

---

# Generic osztály

```java
public class Group<T> {

  // Attribútum típusa
  private T leader;

  // Visszatérési típus
  public T getLeader() {
    return leader;
  }
  
  // Paraméter típus
  public T setLeaderGetPrevious(T leader) {
	// Lokális változó
	T oldValue = this.leader;
	this.leader = leader;
	return oldValue;
  }
}
```

---

# Generic osztály használata

```java
Group<Trainer> trainers = new Group<>();
trainers.setLeader(new Trainer("John Doe"));
Trainer leader = trainers.getLeader();

Group<Student> students = new Group<>();
```

---

# Típus paraméter típus paraméterként

```java
public class ComplexGroup<T> {

    private List<T> leaders;
}
```

* Konvenciók a típus paraméterek jelölésében (`E`, `K`, `V`, `N`, `T` stb.)

---

# Egymásba ágyazhatóság

```java
List<Group<Trainer>> list = new ArrayList<>();
```

---

# Upper bound használata osztály típus paraméterénél

* A típus paraméterek használatával csak az `Object` metódusait érjük el
* Upper bounded típus paraméter megadása `extends` kulcsszóval
* Csak az adott osztálytól leszármazott, vagy interfészt implementáló típus adható meg paraméterként
* Meg lehet hívni a megfelelő metódusait

---

# Upper bound osztály típus paraméterénél

```java
public interface HasName {
    String getName();
}
```

```java
public class Group<T extends HasName> {

    private T leader;

    // ...

    public String getLeaderName() {
        return leader.getName();
    }
}
```

---

# Upper bound UML

![Upper bound](images/upperbound.png)

---

# Több bound (intersection types)

```java
class Group<T extends HasName, CanTeach>
```

* Ebből maximum egy osztály, a többi interfész
* Osztályt első helyen kell szerepeltetni

---

# Type inference

* A fordító meghatározza a típusparaméter konkrét típusát
* Paraméterektől, valamint az elvárt visszatérési típusból
    * Értékadásnál a változó típusa
    * `return` esetén a metódus visszatérési értékének típusa
* A legspecifikusabbat keresi meg
* Ide vezethető vissza a diamond operátor használata

```java
Map<String, String> m = new HashMap<>();
```

---

# Target types

```java
public void m(List<Object> l) {
	// ...
}

List<String> s = Arrays.asList("foo", "bar");
m(s); // NEM FORDUL

m(Arrays.asList("foo", "bar")); // LEFORDUL

// Java 8 előtt
m(Arrays.<Object>asList("foo", "bar")); // LEFORDUL
```