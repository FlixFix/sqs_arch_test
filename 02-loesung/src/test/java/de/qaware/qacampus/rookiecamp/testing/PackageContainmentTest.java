package de.qaware.qacampus.rookiecamp.testing;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(
    packages = "de.qaware.qacampus.rookiecamp.testing",
    importOptions = {
        ImportOption.DoNotIncludeTests.class,
        ImportOption.DoNotIncludeJars.class
    }
)
class PackageContainmentTest {

    @ArchTest
    void serviceClassesShouldResideInPackageService(JavaClasses javaClasses) {
        final ArchRule rule = classes().that()
            .areNotAnnotations()
            .and().haveSimpleNameEndingWith("Service")
            .should().resideInAPackage("..service");

        rule.check(javaClasses);
    }

}