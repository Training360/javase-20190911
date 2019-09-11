## Gyakorlati feladat - Napló állomány elemzése

Gyűjtsd ki az ugyanahhoz az IP-címhez tartozó napló bejegyzéseket egy szöveges naplóból.
A napló sorokban tárolja az adatokat, egy sor egy `Entry` objektumnak felel meg,
IP cím, dátum és login mezőkből áll.
Írj egy log feldolgozást implementáló osztályt, `LogParser` néven, amely  elvégzi a dátum `String` konvertálását,
a sor feldolgozását, és `Map`-be szortírozását.
A fő tevékenységet a (`parseLog(String log)`) metódus végzi, amely egy (`Map<String, List<Entry>>`) értéket ad vissza.


### Hibakezelés

Ha a dátum String nem dolgozható fel, a metódus dobjon egy `IllegalArgumentException` kivételt.

Ha a `parseLog(String log)` metódus bemenete olyan `String`, amely nem dolgozható fel, mint `Entry` objektum,
szintén `IllegalArgumentException` kivételt dobjon.

### Megvalósítás

A sorfeldolgozáshoz szükséges adatok - elemek száma, pozíciója, mező szeparátor, dátum String formátuma -
statikus `final` változóként kerüljenek be a `LogParser` osztályba.

### Tippek

Ha a sor nem dolgozható fel, vagy a dátum nem konvertálható,
az egész feldolgozást töröljük és kivételt dobunk a probléma megjelölésével.
