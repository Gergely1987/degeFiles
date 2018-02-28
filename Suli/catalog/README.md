# Katalógus projekt

A feladat, egy online könyvtár katalógus rendszerének a szimulációja. A könyvtárban vannak
könyvek, albumok és hangoskönyvek. A könyvek tulajdonságai között szerepel a címe, szerzője és
az oldalak száma. Az albumok tulajdonságai között szerepel a címe, előadója, szerzője és hossza.
A hangoskönyv mindkét tulajdonsághalmazzal rendelkezik.

![UML osztálydiagram](images/catalog.png =600x545)

A feladat reprezentációjához a következő elemeket kell megvalósítani:

* `Feature` interface:
   Két metódussal rendelkező interface. A `getContributors()` mely egy String listával tér vissza 
   ami a katalógus elem közreműködőit (szerző, előadó) tartalmazza, valamint egy `getTitle()` metódus
   ami az elem címét adja vissza.
   
* `AudioFeatures` osztály:
   Ez az osztály implementálja a `Feature` interface-t. Minden zenei elemnek van címe, hossza, előadói,
   illetve szerzői. A szerzők megadása nem kötelező (két konstruktor szükséges, overload).
   A `getContributors()` metódus a szerzők és előadók közös listájával tér vissza.
   
* `PrintedFeatures` osztály:
   Szintén a `Feature`-t implementálja. A nyomtatott jellemzők a cím, az oldalszám, illetve a szerzők.
   A `getContributors()` itt a szerzőket adja vissza listaként.
   
* `CatalogItem` osztály:
   Minden katalógus elemnek van egy jellemzők listája melyek lehetnek akár nyomtatottak vagy audio-k.
   Továbbá minden katalógus elemnek van ára és egy regisztrációs száma.
   
* `Catalog` osztály:
   A katalógus tartalmazza a katalógus elemek listáját és ebben az osztályban lehet különböző lekérdezéseket végrehajtani.
   Le lehet kérdezni:
   * Az audio illetve nyomtatott jellemzőkkel rendelkező elemeket.
   * Az összoldalszámot a nyomtatottaknál
   * Az összhosszt az audio típusúaknál
   * Az átlag oldalszámot egy bizonyos oldalszám felett
   * Keresni lehet egy `SearchCriteria` alapján (lásd lejjebb)
   
* `SearchCriteria` osztály:
   Egy immutable osztály melynek attribútumai egy cím és egy szerző. Az osztályt úgy kell megvalósítnai, hogy
   akár cím, akár szerző alapján, sőt mindkettő alapján lehessen keresni a katalógusban (statikus metódusokkal lehet
   létrehozni).

* `Validators` osztály:
   Létre kell hozni egy `isBlank()` és `isEmpty()` statikus metódust, az egyik egy Stringről vizsgálja
   meg, null vagy üres-e, a másik egy listáról dönti el, hogy null vagy üres-e. Ezeket a metódusokat
   használhaztjuk a metódusok paramétereinek ellenőrzésekor.
