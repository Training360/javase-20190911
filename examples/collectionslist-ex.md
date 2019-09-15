## Gyakorlati feladat 1 - Lottó

Implementálj egy lottó gépet, ahol megadható a lottó típusa (ötös, hatos, stb.)
és az is, hogy hány számból válasszon (golyók száma).
Írj egy osztályt, amely létrehozza a golyókat (`List<Integer>` értékek), összekeveri, majd megcsinálja a "húzást",
azaz kiválaszt a lottó típusának megfelelő számú golyót, majd a kihúzott számokat növekvő sorba rendezi és úgy adja vissza.  
A húzást a `selectWinningNumbers(int lotteryType, int ballCount)` metódus végzi,
amely egy (`List<Integer>`) értéket ad vissza.

### Hibakezelés

Ha a `selectWinningNumbers(int lotteryType, int ballCount)` metódust rossz paraméterekkel hívták meg
 (több vagy ugyanannyi számot kellene kihúzni, mint amennyit generál), a metódus dobjon egy `IllegalArgumentException` kivételt.

### Megvalósítás

Maximálisan használjuk ki a megfelelő kollekció nyújtotta lehetőségeket!
A visszaadott számok pozitív egész számok, és nem lehetnek nagyobbak, mint amennyi golyó van.
A golyók számozása egytől kezdődik. Ugyanaz a szám nem szerepelhet kétszer.

publikus metódusok:
```java
public List<Integer> selectWinningNumbers(int lotteryType, int ballCount)
```

### Tippek

Nézz utána, hogyan lehet `List` típusok esetén az elemeket rendezni (mi ennek a feltétele?), a rendezettséget megszüntetni.
