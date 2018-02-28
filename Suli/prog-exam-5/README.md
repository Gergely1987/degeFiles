# Vizsgafeladat

A feladatok megoldásához csak az IDEA fejlesztőeszközt és
a [Java API-t](https://docs.oracle.com/javase/8/docs/api/)
használhatod. Bármely régebbi saját projektet megnyithatsz, de csak azt!

Teszt esetek, ha futnak, az ér egy pontot. Ha a program struktúrálisan
is hibátlan, és megfelel a kiírásnak, akkor két pont. A feladatok elkészítésének sorrendje tetszőleges.

Figyelem! A **Kódolás** és a **CSV feldolgozás** faladatok közül csak az egyiket kötelező megoldani, 
szabadon választható, hogy melyiket!

## Trigonometria

Írj egy `Trigonometry` osztályt, benne két metódust, mely
egy derékszögű háromszög a és b oldalát számolja ki a c
oldalának, és az alfa szögének ismeretében, ha adottak az alábbi
egyenlőségek:

* sin(alfa) = a / c
* cos(alfa) = b / c

A metódusok az alfa szöget fokban várják, de vigyázz, hogy
a `Math` osztály metódusai viszont radiánban. Kell egy átváltás,
a következő egyelőség alapján:

* szög radiánban = szög fokban * Pi / 180.

A Math osztályban definiált Pi-t használd. A 180-at emeld ki konstansba.
Az átváltás fok és radián között egy privát metódus legyen.

Ha az alfa kisebb, vagy egyenlő, mint 0, vagy nagyobb, vagy egyenlő,
mint 90, kivételt kell dobnia.

## Fotókollekció

Írj egy `Photo` osztályt, melynek van egy neve és egy minősítése. Létre lehet hozni
csak névvel, vagy névvel és minősítéssel. A minősítés egy `Quality` enum, hogy a felhasználó
hány csillagot adott rá, lehet ez `Quality.NO_STAR`, `Quality.ONE_STAR` és `Quality.TWO_STAR`.
A `Photo` osztály implementálja a `Qualified` interfészt, melynek definiált a `Quality getQuality()` 
és a `void setQuality(Quality)` metódusa.

Írj egy `PhotoCollection` osztályt, mely a fotók egy listáját tartalmazza. Fotókat lehet hozzáadni
névvel, ekkor még nem kapnak csillagot. Az `addPhoto()` metódus varargs-os!

Írj egy `starPhoto()` metódust, mely kikeresi a megfelelő nevű fotót, és beállítja rajta a paraméterként
átadott minősítést. Ha nem talál a megadott névvel fotót, `PhotoNotFoundException` kivételt dob. Ez
egy saját kivétel, terjessze ki a `RuntimeException` osztályt.

Írj egy `numberOfStars()` metódust, mely visszaadja, hogy a képeken összesen mennyi csillag van.
Ha nincs minősítése, akkor 0 csillag. Ha a minősítése `Quality.ONE_STAR`, akkor egy csillaggal kell
 számolni. Ha a minősítése `Quality.TWO_STAR`, akkor két csillaggal kell számolni.

Tartsd be az elnevezési konvenciókat. A megoldásban csak foreach-eket használj!


## Kódolás

Írj egy `StringCoder` osztályt, benne egy `String encode(String s)` metódust, mely végigmegy a karaktereken,
és nem írja ki mindegyiket, ha többször szerepel egymás utána, hanem csak azt, hogy hányszor szerepel. Tehát a
következő bemenetekre a következő kimeneteket adja:

```
a -> 1a
aa -> 2a
aaa -> 3a
aabb -> 2a2b
```

Figyelj a performanciára, és ne használj feleslegesen sok String konkatenációt.

## CSV feldolgozás

Írj egy `TrackPoint` osztályt, mely konstruktora egy Stringet kap, mely vesszővel elválasztva
tartalmazza az attribútumainak értékét (dátum, idő, szélesség, hosszúság, magasság, megjegyzés - nem tartalmaz vesszőt). 
Bontsd fel és értelmezd a Stringet.

Pl.: `2017-01-01,14:00,3.56,3.68,400,Hello World!`


## Fájlkezelés

A data mappában találsz egy `otos.csv` fájlt (ez egyébként a https://bet.szerencsejatek.hu/jatekok/otoslotto/sorsolasok
címről tölthető le), és olvasd be. Tárold el, hogy melyik számot hányszor húzták ki. A fájl pontosvesszővel (`;`) elválasztva tárolja
a mezőket. A 12 - 16. mező (nullával indexelve 11 - 15) tárolja a kihúzott számokat.

Írj egy `LottoReader` osztályt. Használj egy 90 elemű tömb attribútumot. Vigyázz, a 90-es szám a tömb 89. eleme.

Konstruktorban töltsd be a fájlt. Mivel a fájl folytonosan frissül a megadott webhelyen 
és így a tesztesetek konkrét várt értékei is változhatnak, a mellékelt fájl alapján dolgozz (data mappa)!