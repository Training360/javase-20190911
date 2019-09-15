class: inverse, center, middle

# String írása Writerrel

---

## Writer haszna

* Folyamatos írást tesz lehetővé

---

## Írás Writerrel

![](images/io-writer01.png)

```java
List<String> employees = List.of("John Doe", "Jane Doe", "Jack Doe");
Path file = Path.of("employees.txt");
try (BufferedWriter writer = Files.newBufferedWriter(file)) {
    for (String employee: employees) {
        writer.write(employee + "\n");
    }
}
catch (IOException ioe) {
    throw new IllegalStateException("Can not write file", ioe);
}
```

---

## BufferedWriter

* Zárni kell, try-with-resources szerkezet
* Sor írása `write()` metódussal, a sortörést is ki kell írni
* Alapértelmezetten UTF-8

---

## Régi módszer

![](images/io-writer02.png)

```java
BufferedWriter writer = new BufferedWriter(new FileWriter("employees.txt"));
```
