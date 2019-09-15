class: inverse, center, middle



# Reader és writer osztályok

---

# Szöveges állomány olvasása

* Platform default encoding

```java
try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
  String s;
  while((s = reader.readLine()) != null) {
    // s a sor
  }
}
```

* Karakterkódolás megadása: `new FileReader(source, StandardCharsets.UTF_8)`

---

# Szöveges állomány írása

```java
try (BufferedWriter writer = new BufferedWriter(
  new FileWriter(destination))) {
    writer.write(s); // s egy String
}
```

* Karakterkódolás megadása: `new FileWriter(destination, StandardCharsets.UTF_8)`

---

# `PrintStream` és `PrintWriter`

* Különböző típusok szöveges reprezentációjának kiírására (primitív típusok, Object `toString`)
* `print()` és `println()` metódusok túlterhelve
* `printf()` és `format()` metódusok túlterhelve
* `PrintWriter` karakterkódolás megadásával

```java
try (PrintWriter out = new PrintWriter(
  new BufferedWriter(new FileWriter(source)), StandardCharsets.UTF_8)) {
    out.println("árvíztűrő tükörfúrógép");
    out.print(1/3.0);
    out.print(new Trainer());
    out.format(" Result is %d ", 10);
}
```
