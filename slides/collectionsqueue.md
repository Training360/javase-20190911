class: inverse, center, middle



# Queue interfész és implementációi

---

# `Queue` interfész és implementációi

* Elemek hozzáadása és eltávolítása meghatározott sorrendben kell történjen
* Elemek duplikáltan is szerepelhetnek
* FIFO műveletek hozzáférhetőek ezen interfészen keresztül (végére beszúrás, elejéről kivétel)
* Definiált a sor eleje, vagy vége, más néven fej és farok
* `Deque extends Queue` interfész - kétvégű sor
	* Sor elejéhez és végéhez is hozzá lehet férni
	* LIFO (stack) működési modell

---

# `Queue` implementációk

* `LinkedList`
  * Láncolt lista
* `ArrayDeque`
  * Tömb alapú implementáció
* `PriorityQueue`
  * Rendezi a berakott objektumokat

---

# `Queue` metódusok

* Kivételt dob, ha nem sikerül
  * `add(e)` - hozzáadás a végére
  * `remove()` - eltávolítás az elejéről
  * `element()` - első elem lekérése
* Visszatérési értéke speciális, ha nem sikerül
  * `offer(e)` - hozzáadás a végére
  * `poll()` - eltávolítás az elejéről
  * `peek()` - első elem lekérése

---

# `Deque`  metódusok

* `push(e)` - hozzáadás az elejére
* `pop()` - eltávolítás az elejéről
