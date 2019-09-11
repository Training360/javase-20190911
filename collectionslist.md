class: inverse, center, middle



# List interfész és implementációi

---

# The Java Collections Framework

* Több objektum tartalmazásáért felelős osztályok
* `List` interfész - elemeket sorrendben tartalmazza, index szerint hozzáférhetőek, duplikációt megenged
* `Set` interfész - nem enged meg duplikációt
* `Queue` interfész - megadott sorrendben feldolgozandó elemek tárolására használjuk, pl. FIFO
* `Map` interfész - kulcsokhoz értékeket rendel
	* Egy kulcs csak egyszer szerepelhet 
	* Elemei kulcs/érték párok

---

# The Java Collections Framework tulajdonságok

* Különböző implementációi lehetségesek (performancia, plusz működés)
* `List`, `Set` és `Queue` `Collection` leszármazott
* `toString` metódusok megfelelően implementálva
---

# `Collection` interfész metódusai

* `add()`
* `remove()`
* `isEmpty()` és `size()`
* `clear()`
* `contains()`

---

# `List` interfész és implementációi

* Elemek tárolására, sorrendben, duplikációt megenged
* Főbb implementációi `ArrayList`, `LinkedList`
* `ArrayList`
  * "rugalmas" tömb
  * Kapacitás és telítettség fogalma
  * Beszúrás, törlés másolással

---

# `LinkedList` implementáció

* Kétirányban láncolt lista
* Beszúrás, törlés referenciák állításával
* `Queue` interfészt is implementálja

---

# További metódusok

* `add(int index, E element)`
* `E get(int index)`
* `int indexOf(Object o)`
* `int lastIndexOf(Object o)`
* `void remove(int index)`
* `E set(int index, E e)`
