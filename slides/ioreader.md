class: inverse, center, middle

# String olvasása Readerrel

---

## Reader haszna

* Képes a fájlt folyamatosan olvasni anélkül, hogy a teljes fájlt beolvasná
  a memóriába
    * Beolvasás akár meg is szakítható
* Gyorsan cserélhető, hogy pl. ne fájlból, hanem hálózatról olvasson
* `Reader` absztrakt osztály, annak különböző megvalósításai

---

## Szöveges fájl beolvasása

![](images/io-reader01.png)

```java
Path file = Path.of("employees.txt");
try (BufferedReader reader = Files.newBufferedReader(file)) {
    String line;
    while((line = reader.readLine()) != null) {
        System.out.println(line);
    }
}
catch (IOException ioe) {
    throw new IllegalStateException("Can not read file", ioe);
}
```

---

## BufferedReader

* `Files.newBufferedReader` metódus, paraméterekkel
* Zárni kell, try-with-resources szerkezet
* Sor beolvasása `readLine()` metódussal
    * `null` értéket ad vissza, ha nincs több sor


---

## Karakterkódolás

* Alapértelmezetten UTF-8

```java
BufferedReader reader = Files.newBufferedReader(file, Charset.forName("ISO-8859-2"))
```

---

## Régi módszer


* Először egy `FileReader` elkészítése, mely karakterenként olvas
    * Alacsonyszintű, hozzáférés előforráshoz, pl. fájlhoz
* Majd egy `BufferedReader` objektumba burkolás, hogy hatékony legyen
    * Magas szintű, már létező `Reader`-re épül

```java
BufferedReader reader = 
    new BufferedReader(new FileReader("employees.txt"))

BufferedReader reader = 
    new BufferedReader(new FileReader(new File("employees.txt")))
```

![](images/io-reader02.png)

---

## BufferedReader

* Miért nincs rá külön osztály? `BufferedReader` forrástól függetlenül tud pufferelni.

---

## Karakterkódolás

* Platform alapértelmezett karakterkódolásával

Karakterkódolással:

```java
BufferedReader reader = new BufferedReader(new FileReader("employees.txt", StandardCharsets.UTF_8))
```
