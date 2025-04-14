package de.qaware.qacampus.rookiecamp.testing;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import java.net.URL;
import java.util.Objects;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.plantuml.rules.PlantUmlArchCondition.Configuration.consideringOnlyDependenciesInDiagram;
import static com.tngtech.archunit.library.plantuml.rules.PlantUmlArchCondition.adhereToPlantUmlDiagram;

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
        final ArchRule rule = classes()
            .should(adhereToPlantUmlDiagram(
                Objects.requireNonNull(pumlDiagram),
                consideringOnlyDependenciesInDiagram()
            ));

        rule.check(javaClasses);
    }
}