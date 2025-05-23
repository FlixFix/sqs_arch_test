package de.qaware.qacampus.rookiecamp.testing;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchIgnore;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import java.net.URL;

@AnalyzeClasses(
    packages = "de.qaware.qacampus.rookiecamp.testing",
    importOptions = {
        ImportOption.DoNotIncludeTests.class,
        ImportOption.DoNotIncludeJars.class
    }
)
public class PumlArchitectureTest {

    private static final URL pumlDiagram =
        PumlArchitectureTest.class.getClassLoader().getResource("BookstoreArchitecture.puml");

    /**
     * Validate our source against the puml defined architecture
     */
    @ArchTest
    public static void classDependenciesShouldConformToPumlDiagram(JavaClasses javaClasses) {
        // TODO
        final ArchRule rule = null;

        rule.check(javaClasses);
    }
}