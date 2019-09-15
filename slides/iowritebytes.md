class: inverse, center, middle

# Bájtok írása OutputStreammel

---

## Írás

![](images/io-writebytes01.png)

```java
Path file = Path.of("data.dat");
try (OutputStream outputStream = new BufferedOutputStream(Files.newOutputStream(file))) {
    for (int i = 0; i < 1100; i++) {
        outputStream.write("abcde".getBytes());
    }
}
catch (IOException ioe) {
    throw new IllegalStateException("Can not read file", ioe);
}
```

---

## Régi módszer

![](images/io-writebytes01.png)

```java
OutputStream outputStream = new BufferedOutputStream(new FileOutputStream("data.dat"))
```

```java
OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(new File("data.dat")))
```
