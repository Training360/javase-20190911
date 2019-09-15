class: inverse, center, middle

# String olvasása classpath-ról

---

## Classpath

* Ha a fájl, amit be akarunk olvasni, az alkalmazás részét képzi
* Fájlrendszerből való beolvasás (`Path`) nem működőképes, mert az
alkalmazást jar (tömörített) állományba csomagolva a beolvasandó fájl nem jelenik meg külön a fájlrendszerben
    * Fájl nem található
* A JVM gondoskodik az állomány beolvasásáról annak helyétől függetlenül (fájlrendszer vagy jar)

---

## Fájl helye

* Maven esetén az `src/main/resources` könyvtárba kell elhelyezni
* Ekkor a `jar` főkönyvtárába kerül
* Alkönyvtárak létrehozhatóak

---

## Beolvasás példa

![](images/io-readerclasspath01.png)

```java
try (BufferedReader reader = new BufferedReader(new InputStreamReader(
        EmployeeService.class.getResourceAsStream("/employees.txt")))) {
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

## Elhelyezkedés

* A kezdő perjel (`/`) jelzi, hogy a classpath gyökeréből kell olvasni
    * jar fájl esetén annak gyökere
    * Maven az `src/main/resources` könyvtárból másolja ide
* Perjel hiánya esetén az osztály csomagjából megegyező könyvtárból próbálja betölteni

```java
BufferedReader reader = new BufferedReader(new InputStreamReader(
    EmployeeReader.class.getResourceAsStream("/employees.txt")))
```

Pl. `ioreaderclasspath.EmployeeReader` <br /> esetén a `ioreaderclasspath` könyvtárból