class: inverse, center, middle



# Streamek

---

# Stream adatok

* Adatok folyama
* Használható fájlból olvasásba/fájlba írásra vagy hálózatról olvasásra/hálózatra írásra, stb.
* Blokkokban, szeletekben történik az olvasás, írás
* Bár írható magasabb szintű adattípusok, legalul mindig bájtok írása van
* Már használt `System.out` is stream

---

# Byte vagy karakter streamek

* Bájtok írására/olvasására streamek (`InputStream`, `OutputStream` absztrakt ősosztályok)
* Karakterek írására/olvasására reader/writer (`Reader`, `Writer` absztrakt ősosztályok)
* Karaktereknél fontos szerepe van a karakterkódolásnak

---

# Alacsony és magasszintű streamek

* Alacsony szint: közvetlen hozzáférés az erőforráshoz, pl. fájl, hálózat, stb.
* Magas szint: más streamet burkol be (wrap), dekorálás, plusz funkcionalitással vagy metódusokkal bővíti
  * Pl. tömörítés
  * Performancia
  * Akár saját implementáció, pl. filterelés

```java
try (
  BufferedReader bufferedReader = new BufferedReader(
    new FileReader("foo.txt"))) {
      System.out.println(bufferedReader.readLine());
    }
```

---

# Gyakori műveletek

* Stream zárása, try-with-resources
* Flush
  * Close zár
* Könyvjelzőzés (mark, reset)
  * Nem mindegyik támogatja

---

# Fájl bináris olvasása

* Nem használjuk közvetlenül az `FileInputStream`-et, csak csomagolva a `BufferedInputStream`-mel

```java
try (
  InputStream in = new BufferedInputStream(new FileInputStream(source))) {
    byte[] buffer = new byte[1024];
    int lengthRead;
    while ((lengthRead = in.read(buffer)) > 0) {
      // lengthRead - nem feltétlenül telik meg a tömb
      // buffer - bájttömb
    }
}
```

---

# Fájl bináris írása

```java
try (OutputStream out = new BufferedOutputStream(new FileOutputStream(destination))) {
  out.write(bytes, 0, bytes.length); // Ahol a bytes egy bájttömb
}
```

---

# Memóriából olvasás vagy memóriába írás

* Különösen hasznos teszteléskor
* `ByteArrayInputStream`, példányosítás `ByteArrayInputStream(byte[])` konstruktorral
* `ByteArrayOutputStream`, bájttömb kinyerése `toByteArray()` metódussal

---

# További megvalósítások

* `DataOutputStream` `short`, `int`, `long`, `float`, `double` típusok bájtreprezentációjának írására
* `ZipOutputStream`, `JarOutputStream`
