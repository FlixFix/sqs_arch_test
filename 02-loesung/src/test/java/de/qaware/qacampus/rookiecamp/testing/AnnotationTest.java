package de.qaware.qacampus.rookiecamp.testing;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import de.qaware.qacampus.rookiecamp.testing.annotations.Service;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(
    packages = "de.qaware.qacampus.rookiecamp.testing",
    importOptions = {
        ImportOption.DoNotIncludeTests.class,
        ImportOption.DoNotIncludeJars.class
    }
)
final class AnnotationTest {

    @ArchTest
    void classesThatAreAnnotatedWithServiceShouldEndWithService(JavaClasses javaClasses) {
        final ArchRule rule = classes().that().areAnnotatedWith(Service.class)
            .should().haveSimpleNameEndingWith("Service");

        rule.check(javaClasses);
    }
}