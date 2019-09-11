class: inverse, center, middle



# Set interfész és implementációi

---

# `Set` interfész és implementációi

* Halmaz
* Elemeket tartalmaz, nem enged meg duplikációt, csak egyedi elemek rakhatók bele
* `equals(Object o)` szerepe
* Gyakrabban használt implementációk: `HashSet`, `TreeSet`, `LinkedHashSet`
* `HashSet`
  * Hash-t használ a objektumok gyors <br /> megtalálására, majd `equals`
  * Sorrend elveszik

---

# `TreeSet` implementáció

* Keresőfával, sorrend definiált
* Implementálja a `NavigableSet extends SortedSet` interfészt is

---

# `LinkedHashSet` implementáció

* Az elemeket egy kétirányban láncolt listában is felfűzi
* Bejárás sorrendje a tárolás sorrendje