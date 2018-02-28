
# String fontosabb metódusai

## Ellenőrző kérdések
* A `length()` metódus mit ad vissza a következő string esetében: " a p p l e" ?
* A `charAt()` metódus mit ad vissza: `index.charAt(2)` hívás esetén?
* Az `indexOf()` metódus mit ad vissza `index.indexOf('x')` hívás esetén?
* A `substring()` metódus hogyan értelmezi a paraméterként átadott indexeket? 
* Az `equals()` és `equalsIgnoreCase()` metódusoknak mi a jelentősége? 
* A `contains()` metódusnak mi a visszatérési értéke?
* A `replace()` metódus char vagy CharSequence paramétereket fogad. Mit jelent a CharSequence?
* A `trim()` metódus mit eredményez a következő string esetében: "\t an apple" ?

## Gyakorlati feladat

Készítsünk egy `FileNameManipulator` osztályt, amely fájlnevek ellenőrzésére, illetve ehhez kapcsolódó
String műveletekre alkalmas metódusokat tartalmaz.

### Hibakezelés
Az egyes funkcióknál a feldolgozhatatlan paraméterek és 
paraméter kombinációk esetén dobjon `IllegalArgumentException`-t

### Megvalósítási javaslatok

publikus metódusok:
```java
public char findLastCharacter(String str)
public String findFileExtension(String fileName)
public boolean identifyFilesByExtension(String ext, String fileName) 
public boolean compareFilesByName(String searchedFileName, String actualFileName)
public String changeExtensionToLowerCase(String fileName)
public String replaceStringPart(String fileName, String present, String target) 
```

### Tippek

Vezessünk be egy `isEmpty(String)` metódust, amelynek visszatérési értéke `true` 
ha a paraméter String `null` vagy üres String!
Ha igény van rá, alkalmazzuk a metódusok láncolását!
Figyeljünk a vezető és követő `whitespace` karakterekre!






