class: inverse, center, middle

# Bájtok beolvasása fájlból és kiírása fájlba

---

## Bájtok beolvasása fájlból

```java
Path file = Path.of("data.dat");
try {
    byte[] bytes = Files.readAllBytes(file);
    System.out.println(Arrays.toString(bytes));
}
catch (IOException ioe) {
    throw new IllegalStateException("Can not read file", ioe);
}
```

---

## Bájtok kiírása fájlba

```java
Path file = Path.of("data.dat");
try {
    Files.write(file, new byte[]{97, 98, 99, 100, 101});
}
catch (IOException ioe) {
    throw new IllegalStateException("Can not write file", ioe);
}
```
