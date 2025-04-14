# Lösung Übung 1: Class and Package Containment

Siehe [PackageContainmentTest.java](src/test/java/de/qaware/qacampus/rookiecamp/testing/PackageContainmentTest.java).

Fix: `AuthorsService` von `persistence` nach `service` schieben.

# Lösung Übung 2: Annotation Check

Siehe [AnnotationTest.java](src/test/java/de/qaware/qacampus/rookiecamp/testing/AnnotationTest.java).

Fix: `RentalServic` in `RentalService` umbenennen.

# Lösung Übung 3a: Layered Architecture Check und 3b Plant UML Check

Siehe [LayeredArchitectureTest.java](src/test/java/de/qaware/qacampus/rookiecamp/testing/LayeredArchitectureTest.java) bzw.
[PumlArchitectureTest.java](src/test/java/de/qaware/qacampus/rookiecamp/testing/PumlArchitectureTest.java).

Fixes jeweils:

- In `BookstoreUi` den Zugriff auf `AuthorDao` über `AuthorsService` lösen.
- `CollectionUtils` in Package `util` schieben.

# Lösung Übung 4: Cycle Checks

Siehe [CycleTest.java](src/test/java/de/qaware/qacampus/rookiecamp/testing/CycleTest.java).

Fix:

- `IntegerUtils` und `LongUtils` in ein gemeinsames Package `numbers` schieben.