package de.qaware.qacampus.rookiecamp.testing;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

@AnalyzeClasses(
    packages = "de.qaware.qacampus.rookiecamp.testing",
    importOptions = {
        ImportOption.DoNotIncludeTests.class,
        ImportOption.DoNotIncludeJars.class
    }
)
final class CycleTest {

    @ArchTest
    void utilSlicesShouldBeFreeOfCycles(JavaClasses javaClasses) {
        /*
         JavaClasses are put into different slices by matching the supplied package identifier.
         The slicing is done according to capturing groups (thus if none are contained in the identifier, no more
         than a single slice will be the result).
         Package identifier syntax is similar to AspectJ. In particular '*' stands for any sequence of characters
         but not the dot '.', while '..' stands for any sequence of packages, including zero packages.
         Furthermore, the use of capturing groups is supported. In this case '(*)' matches any sequence of characters,
         but not the dot '.', while '(**)' matches any sequence including the dot.
        */
        final ArchRule rule = slices().matching("..util.(*)")
            .should().beFreeOfCycles();

        rule.check(javaClasses);
    }
}