class: inverse, center, middle

# String beolvasása szöveges állományból

---

## `Path` interfész

* Elérési út
* Könyvtár vagy fájl elérésének reprezentálására
* Java 7-ben jelent meg, a `File` leváltására
* Java 11-től `Path.of()` statikus metódussal lehet létrehozni
* Abszolút vagy relatív elérési útvonal

```java
Path fileInRootDirectory = Path.of("C:\\employees.txt");

Path fileInActualDirectory = Path.of("employees.txt");
```

---

## Elválasztó karakter

* Operációs rendszerenként eltérő
* Separator karakter `FileSystems.getDefault().getSeparator()`

```java
Path path = Path.of("employees", "john-doe.txt")

Path file = Path.of("employees").resolve("a.dat");
```

---

## Szöveges állomány beolvasása

* `Files` osztály tartalmaz az állományok kezelésével kapcsolatos metódusokat

```java
Path file = Path.of("employees.txt");
try {
    String employees = Files.readString(file);
    System.out.println(employees);
}
catch (IOException ioe) {
    throw new IllegalStateException("Can not read file", ioe);
}
```

---

## Karakterkódolás

* Alapértelmezett karakterkódolás UTF-8
* Paraméterként felülírható
* `Charset` absztrakt osztály, ` forName()` statikus metódussal hozható létre
    * `StandardCharsets.UTF_8`

```java
String employees = Files.readString(file, Charset.forName("ISO-8859-2"));
```


---

## Szöveges állomány beolvasása sorokra bontva

```java
try {
    List<String> employees = Files.readAllLines(file);
    for (String employee: employees) {
        System.out.println(employee);
    }
}
catch (IOException ioe) {
    throw new IllegalStateException("Can not read file", ioe);
}
```
