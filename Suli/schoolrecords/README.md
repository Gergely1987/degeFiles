
# Elektronikus osztálynapló

## Projektfeladat

Elektronikus osztálynaplót (Enapló) kell megvalósítani. Az alkalmazásban a `ClassRecords` osztály magát a naplót reprezentálja, 
ahol felvehetők a diákok (`Student`). A `Student` osztályban "tároljuk" a diákok jegyeit `Mark`.
A főbb funkciók a következők:
A diákok osztályozhatók, (jegyeket kapnak), a jegyeik alapján általános és tantárgyak szerinti átlag számítható, két tizedesjegy 
pontossággal. A jegyeik ki is listázhatók a tesztesetekben megadott formában.

![UML osztálydiagram](images/schoolrecords.png =600x489)

### Hibakezelés

Törekedjünk az átfogó hibakezelésre! A teszteseteknél látható módon `NullPointerException`-t várunk, 
ha a megfelelő metódust `null` értékkel hívták meg,
ha a String paraméter `isEmpty()` (lásd a tippeknél) akkor a megfelelő szöveggel `IllegalArgumentException`-t várunk.
Az osztály szintű átlagszámítások során `ArithmeticException`-t várunk a megfelelő szöveggel, 
ha valamiért nem lehet a számítást elvégezni (nincs jegy, nincs diák felvéve az osztályba, stb.). 

### Megvalósítási javaslatok

`Subject` osztály:
Egy attribútuma van, a tantárgy nevének tárolására. Ennek alapján azonosítható a tantárgy.

`Tutor` osztály:
Két attribútuma van, a tanár neve és a tanított tantárgyak listája, mindkettő konstruktorból tölthető fel.

publikus metódusok:
```java
public boolean tutorTeachingSubject(Subject subject)
```

`MarkType` enum:
`A(5, "excellent")`, `B(4, "very good")`, `C(3, "improvement needed")`, `D(2, "close fail")`, `F(1, "fail")`
értékeket vehet fel, a klasszikus osztályzatot reprezentálja.

`Mark` osztály:
A diák számára adott jegyeket reprezentálja, az osztályzat "értékét" az attribútumai között egy `MarkType` enum adja.
További attribútumai a következők: `Subject` a tantárgy, amiből kapta a jegyet, `Tutor` a tanár, aki adja a jegyet, 
`Date` a dátum, amikor szerezte a jegyet. Ez utóbbit a konstruktor állítja be a rendszeridő alapján.
A jegy attribútumai nem állíthatók, ezért csak getter metódusai vannak. Több konstruktorral is létrehozható az objektum.

publikus konstruktorok:
```java
public Mark(MarkType markType, Subject subject, Tutor tutor)
public Mark(String markType, Subject subject, Tutor tutor)
```

publikus metódusok:
```java
public String toString()
```

`StudyResultByName` osztály:
Speciális osztály, funkciója a diák és tantárgyi átlagának listázásához 
adatszerkezetet biztosítani.
Attribútumai a diák neve és az össztantárgyi átlaga, konstruktorból 
feltöltve (csak getter metódusok!).

`Student` osztály:
A diák adatait - jelen esetben csak a nevét (konstruktorból feltöltve, csak getter metódus) - és a jegyeit tárolja, 
metódusai ezeken dolgoznak. 
A diák azonosítása a nevén keresztül történik. A `toString()` metódus a teszteseteknél látható módon 
a diák nevét és a jegyeit listázza ki szöveges formában.

publikus metódusok:
```java
public void grading(Mark mark)
public double calculateAverage()
public double calculateSubjectAverage(Subject subject)
public String toString()
```

`ClassRecords` osztály, a régi papíralapú napló egyes funkcióit reprezentálja.
Attribútuma az osztály neve, egy `Random` objektum (konstruktorból beállítva), 
valamint a diákok listája.
Diákot adhatunk hozzá és el is távolíthatjuk, előbbi esetben már létező nevű 
diákot nem adhatunk hozzá, és eltávolítani 
csak olyat lehet, aki már ott van a listában (ismét név alapján).
Osztályátlagot tud számolni általánosan és tantárgy alapján, 
véletlenszerűen ki tud választani egy diákot felelésre, meg tud keresni egy diákot név alapján, 
és ki tudja listázni a diákok neveit és átlagát a `StudyResultByName` osztály 
objektumainak listájaként.

publikus metódusok:
```java
public boolean addStudent(Student student)
public boolean removeStudent(Student student)
public double calculateClassAverage()
public double calculateClassAverageBySubject(Subject subject)
public Student findStudentByName(String name)
public Student repetition()
public List<StudyResultByName> listStudyResults()
public String listStudentNames()
```

### Tippek

A listák mindig privát attribútumok, nem lehet kiadni ezeket getterrel, csak műveleteket végzünk rajtuk!
A `Random` objektumot a `ClassRecords` osztály konstruktorban vegye át, a tesztelhetőség miatt.
A String paraméterek nem lehetnek üresek, vagy `null` értékűek. Ezt a vizsgálatot célszerűen egy külön, 
privát metódus végezze, amit minden olyan osztályban létre kell hozni, ahol használatra kerül:

```java
private boolean isEmpty(String str)
```





