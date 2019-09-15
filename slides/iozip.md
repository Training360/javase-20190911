class: inverse, center, middle

# Bájtok írása tömörítéssel

---

## ZipOutputStream

* Zip tartalmaz könyvtárakat és fájlokat
* Ezeket létrehozni a `ZipEntry` osztály használatával lehetséges
* Utána ugyanúgy lehet beleírni, mint bármilyen `OutputStream`-be

---

## ZipOutputStream példa

![](images/io-zip01.png)


```java
Path file = Path.of("data.zip");
try (ZipOutputStream outputStream = new ZipOutputStream(
        new BufferedOutputStream(Files.newOutputStream(file)))) {
    outputStream.putNextEntry(new ZipEntry("data.dat"));
    for (int i = 0; i < 1100; i++) {
        outputStream.write("abcde".getBytes());
    }
}
catch (IOException ioe) {
    throw new IllegalStateException("Can not write file", ioe);
}
```
