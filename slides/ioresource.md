class: inverse, center, middle



# Fájl betöltése classpath-ról

---

# Fájl betöltése classpath-ról

* Classpath környezeti változó, honnan kell betölteni az osztályokat
* Jar fájlból történő beolvasásra
* `Class.getResourceAsStream(String)` abszolút és relatív megadás
* Elválasztó karakter a perjel
* Maven `src/main/resources` és `src/test/resources` könyvtárak
* `ClassLoader` <br /> `getResourceAsStream(String)` metódusa
* Visszatérési értéke `InputStream` típusú
