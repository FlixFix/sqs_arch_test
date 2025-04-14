package de.qaware.qacampus.rookiecamp.testing;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(
    packages = "de.qaware.qacampus.rookiecamp.testing",
    importOptions = {
        ImportOption.DoNotIncludeTests.class,
        ImportOption.DoNotIncludeJars.class
    }
)
public class LayeredArchitectureTest {

    @ArchTest
    void classDependenciesShouldConformToLayerArchitecture(JavaClasses javaClasses) {
        final ArchRule rule = layeredArchitecture()
            .consideringOnlyDependenciesInLayers()
            .layer("UI").definedBy("de.qaware.qacampus.rookiecamp.testing.ui..")
            .layer("Services").definedBy("de.qaware.qacampus.rookiecamp.testing.service..")
            .layer("Persistence").definedBy("de.qaware.qacampus.rookiecamp.testing.persistence..")
            .layer("Utils").definedBy("de.qaware.qacampus.rookiecamp.testing.util..")

            .whereLayer("UI").mayNotBeAccessedByAnyLayer()
            .whereLayer("Services").mayOnlyBeAccessedByLayers("UI")
            .whereLayer("Persistence").mayOnlyBeAccessedByLayers("Services");

        rule.check(javaClasses);
    }
}