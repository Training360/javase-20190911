class: inverse, center, middle

# String kiírása szöveges állományba

---

## String írása

```java
Path file = Path.of("employees.txt");
try {
    Files.writeString(file, "John Doe\nJane Doe\n");
}
catch (IOException ioe) {
    throw new IllegalStateException("Can not write file", ioe);
}
```

---

## Karakterkódolás

```java
Files.writeString(file, "John Doe\nJane Doe\n", Charset.forName("ISO-8859-2"));
```

---

## Hozzáfűzés létező fájlhoz

* `OpenOption` interfész `StandardOpenOption` implementációja

```java
Files.writeString(file, "John Doe\nJane Doe", StandardOpenOption.APPEND);
```

---

## Sorok listájának kiírása

```java
List<String> employees = List.of("John Doe", "Jane Doe");
Files.write(file, employees);
```
