class: inverse, center, middle

# Bájtok olvasása InputStreammel

---

## Bájtok olvasása InputStreammel

![](images/io-readbytes01.png)

```java
Path file = Path.of("data.dat");
try (InputStream inputStream = Files.newInputStream(file)) {
    byte[] bytes = inputStream.readAllBytes();
    System.out.println(bytes.length);
}
catch (IOException ioe) {
    throw new IllegalStateException("Can not read file", ioe);
}
```

---

## Pufferelés

![](images/io-readbytes02.png)

Hatékonyság miatt itt is pufferelve:

```java
InputStream inputStream = new BufferedInputStream(Files.newInputStream(file))
```

---

## Beolvasás darabokban

```java
Path file = Path.of("data.dat");
try (InputStream inputStream = new BufferedInputStream(Files.newInputStream(file))) {
    byte[] bytes = new byte[1000];
    int size;
    while ((size = inputStream.read(bytes)) > 0) {
        System.out.println(size);
    }
}
catch (IOException ioe) {
    throw new IllegalStateException("Can not read file", ioe);
}
```

```
Kimenet 5500 byte méretű fájl esetén: 1000, 1000, 1000, 1000, 1000, 500
```

---

## Régi módszer

![](images/io-readbytes02.png)

```java
InputStream inputStream = new BufferedInputStream(new FileInputStream(file))
```

```java
InputStream inputStream = new BufferedInputStream(new FileInputStream(new File(file)))
```
