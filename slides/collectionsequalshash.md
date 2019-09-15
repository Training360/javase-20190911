class: inverse, center, middle



# equals() és hashCode() metódusok

---

# `equals()` metódus

* A `==` operátor csak a referencia egyenlőséget vizsgálja osztály típusú változó esetén
* Az `equals()` metódus az állapotának egyenlőségét vizsgálja
* Öröklődés az `Object`-ből, implementációja `==` operátorral
* Pl. `String`, primitív burkoló, `ArrayList`, stb. osztályokban implementált metódus
* Hasznos attribútumok alapján (pl. azonosító)
* `Objects.equals(Object a, Object b)`

---

# Szabályok az `equals()` írásakor - 1

* Reflexív - minden `x` nem `null` értékű változóra `x.equals(x)` `true` értéket adjon vissza
* Szimmetrikus - minden `x`, `y` nem `null` értékű változóra ha `x.equals(y)` `true` értéket
  ad vissza akkor, és csak akkor, ha `y.equals(x)`
* Tranzitív - minden `x`, `y`, `z` nem `null` értékű változóra ha `x.equals(y)` és `y.equals(z)`
  `true` értéket ad vissza, <br /> akkor `x.equals(z)` is `true` értéket ad vissza

---

# Szabályok az `equals()` írásakor - 2

* Konzisztens - minden `x`, `y` nem `null` értékű változóra `x.equals(y)` `true` vagy `false` értéket
  ad vissza, akkor ha az objektumok állapota nem változik, új híváskor is ugyanazt a `true` vagy `false`
  értéket kell visszaadnia
* minden `x` nem `null` értékű változóra `x.equals(null)` kifejezésnek `false` értéket kell visszaadnia

---

# hash függvény

* Kriptográfiai algoritmusok
* Kollekcióknál használatos, gyorsítja a keresést
* Az elemeket kisebb kupacokba rendezi, először a kupacot keresi meg, majd abban az elemet
* Hash függvény bármilyen hosszúságú adatot egy adott hosszúságra képez le
  * Ugyanazon adatra mindig ugyanazt a hash
  * Eltérő adatra is adhatja ugyanazt a hash-t, <br /> hiszen általában kisebb az értékkészlete, <br /> cél az, hogy ez kis valószínűséggel következzen be

---

# `hashCode()` metódus

* `Object` osztályból öröklődik
* `int` értéket ad vissza
* `Object.toString()` metódus ezt írja ki

---

# `hashCode()` szabályok

* Ha nem változik az objektum állapota, a `hashCode()` metódusnak is ugyanazt kell visszaadnia
* Ha két nem `null` értékű változóra `equals` metódust hívva az eredmény `true`, hashkódjuknak meg kell egyezniük
* Ha két nem `null` értékű változóra `equals` metódust hívva az eredmény `false`, 
nagy valószínűséggel el kell térniük

---

# `hashCode()` metódus implementálása

* Érdemes ugyanazon attribútumokra támaszkodni, mint az `equals()` metódus
* IDE-k képesek `equals` és `hashCode` metódusokat generálni (akár különböző library-k felhasználásával)
* `Objects.equals()` metódus
* `Objects` osztályban `hash(Object... values)` segédmetódus

---

# Klasszikus implementációk

```java
public class Trainer {

    private String id;

    private String name;

    // Konstruktorok és getterek

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainer trainer = (Trainer) o;
        return Objects.equals(id, trainer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
```
