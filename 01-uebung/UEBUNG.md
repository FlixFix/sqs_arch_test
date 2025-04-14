[TOC]: # "Übung ArchUnit"

# Übung ArchUnit
- [Einleitung](#einleitung)
- [Übung 1: Class and Package Containment](#Übung-1-class-and-package-containment)
- [Übung 2: Annotation Check](#Übung-2-annotation-check)
- [Übung 3a: Layered Architecture Check](#Übung-3a-layered-architecture-check)
- [Übung 3b: Plant UML Check](#Übung-3b-plant-uml-check)
- [Übung 4: Cycle Checks](#Übung-4-cycle-checks)

## Einleitung

In dieser Übung wird eine vereinfachte Version des Bookstores auf
Architektur-Verletzungen geprüft.

Für jede der nachfolgenden Übungsaufgaben hat sich mindestens eine
Architekturverletzung eingeschlichen.

Tipps:
- [ArchUnit: Writing tests](https://www.archunit.org/userguide/html/000_Index.html#_writing_tests)
- [ArchUnit: What to check?](https://www.archunit.org/userguide/html/000_Index.html#_what_to_check)
- Package Matching Syntax (`slices().matching("com.myapp.(*)..")`) siehe
  Doku von `com.tngtech.archunit.core.domain.PackageMatcher`
- [LOESUNG](../02-loesung/LOESUNG.md)

## Übung 1: Class and Package Containment

Rule: Alle Klassen, deren Name auf `Service` endet, sollen im Package
`de.qaware.qacampus.rookiecamp.testing.service` liegen.

- Schreibe einen ArchUnit Test, der die Architektur-Verletzung findet.
  Siehe TODOs in
  [PackageContainmentTest.java](src/test/java/de/qaware/qacampus/rookiecamp/testing/PackageContainmentTest.java).
- Passe den Code an, sodass die Architektur-Verletzung behoben wird und
  der Test erfolgreich ist

## Übung 2: Annotation Check

Alle Klassen, die mit `@Service` annotiert sind, sollen einen Namen
haben, der auf `Service` endet.

- Schreibe einen ArchUnit Test, der die Architektur-Verletzung findet.
  Siehe TODOs in
  [AnnotationTest.java](src/test/java/de/qaware/qacampus/rookiecamp/testing/AnnotationTest.java).
- Passe den Code an, sodass die Architektur-Verletzung behoben wird und
  der Test erfolgreich ist

## Übung 3a: Layered Architecture Check

:information_source: Falls du 3b schon gelöst hast, mache die
entsprechenden Änderungen im Produktivcode vor der Bearbeitung dieser
Aufgabe rückgängig, damit die Architekturverletzung gefunden werden kann.

Der Bookstore folgt einer einfachen Schichten-Architektur. Die Schichten
werden durch bestimmte Packages unterhalb
`de.qaware.qacampus.rookiecamp.testing` repräsentiert:

- `ui`
- `service`
- `persistence`

Zugriff ist, der Auflistung folgend, nur "von oben nach unten" auf die
direkt nachfolgende Schicht gestattet.

Das heißt z.B.

- eine Klasse in `ui` darf auf eine Klasse in `service` zugreifen, nicht
  aber auf eine Klasse in `persistence`.
- eine Klasse in `service` oder `persistence` darf nicht auf eine Klasse
  in `ui` zugreifen

Daneben existiert die Pakete `util` und `annotations`, auf die alle
Klassen zugreifen dürfen.

- Schreibe einen ArchUnit
  [Layer Check](https://www.archunit.org/userguide/html/000_Index.html#_layer_checks),
  der diese Regeln forciert. Passe dafür
  [LayeredArchitectureTest.java](src/test/java/de/qaware/qacampus/rookiecamp/testing/LayeredArchitectureTest.java)
- Passe den Code an, sodass die Architektur-Verletzung behoben wird und
  der Test erfolgreich ist

## Übung 3b: Plant UML Check

:information_source: Falls du 3a schon gelöst hast, mache die
entsprechenden Änderungen im Produktivcode vor der Bearbeitung dieser
Aufgabe rückgängig, damit die Architekturverletzung gefunden werden kann.

In der Datei `src/test/resources/BookstoreArchitecture.puml` ist die
gewünschte Architektur des Bookstores (siehe Bescheibung in
[Übung 3a: Layered Architecture Check](#Übung-3a-layered-architecture-check))
mit Plant UML beschrieben. Schreibt einen Arch Unit-Test, der seine
Regeln aus der Plant UML Datei bezieht.

- Schreibe einen ArchUnit Test, der die Architektur-Verletzung findet.
  Siehe TODOs in
  [PumlArchitectureTest.java](src/test/java/de/qaware/qacampus/rookiecamp/testing/PumlArchitectureTest.java)
- Passe den Code an, sodass die Architektur-Verletzung behoben wird und
  der Test erfolgreich ist

## Übung 4: Cycle Checks

Die Pakete unterhalb von `de.qaware.qacampus.rookiecamp.testing.util`
sollen frei von Zyklen sein.

- Schreibe einen ArchUnit Test, der die Architektur-Verletzung findet.
  Siehe TODOs in
  [CycleTest.java](src/test/java/de/qaware/qacampus/rookiecamp/testing/CycleTest.java)
- Passe den Code an, sodass die Architektur-Verletzung behoben wird und
  der Test erfolgreich ist