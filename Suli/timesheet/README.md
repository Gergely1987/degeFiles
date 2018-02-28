# Timesheet projekt

A feladatban egy cég munkaidő nyilvántartását kell megvalósítani. A cégen belül
vannak alkalmazottak illetve projektek. A cél, hogy az egyes alkalmazottak, egyes projekteken
végzett munkaidejét egy fájlba kiírjuk. (Minta kimenetek)

## Részletes leírás

A projekteket és alkalmazottak neveit egy-egy fájlból kell beolvasni, (alkalmazottnál vezeték-, keresztnevet külön-külön) és ezeket el kell
a cégnek tárolnia, továbbá van egy nyilvántartása arról, hogy ki, melyik projekten dolgozott, 
mettől-meddig.
Fontos, hogy itt az időpontok mindig egy napra essenek, valamint a mikortól korábbi időpont legyen
mint a meddig, ezeket ellenőrizzük is. Ilyen elemeket bármikor hozzáadhatunk a nyilvántartáshoz.
Ahhoz, hogy kiszámoljuk azt, hogy egy napon mennyi idő telt el a két időpont között érdemes használni
a `Duration` osztályt.

A kimeneti fájlnak a mintának megfeleően kell kinéznie, amiben a név, az év, a hónap és az összóraszám
paraméterezhető és nem csak magyarul, hanem igény szerint angolul is ki kell írni, természetesen figyelve arra,
hogy nyelvtanilag értelmes mondatokat kapjunk. Ehhez segítségedre lehet a `MessageFormat` osztály, illetve a `printf` metódus használata.
Mint a mintában látszik, a projektek felsorolásánál, csak azokat írjuk ki amin valóban dolgozott.
Fontos, hogy csak olyan alkalmazott adatait engedjük kiírni, aki valóban a cégnél dolgozik.

A megfelelő projekt-óra párok kialakításához segítségedre lehet egy segéd osztály és ezeket az elemeket
tárolhatod egy listában. Ezt a listát érdemes először kiszámítani, ahol a megfelelő projekt ideje folyamatosan
növelhető. 

