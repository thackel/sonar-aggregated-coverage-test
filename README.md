# Sonarqube coverage is different to Jacoco aggregated coverage

## Problem

Sonar does not show the same coverage as Jacoco.

The sub2 project calls a method in the sub1 project which has not been covered by tests of sub1 so far.

In the Jacoco HTML report and in the 
aggregated [Jacoco XML file](build/reports/jacoco/testCodeCoverageReport/testCodeCoverageReport.xml)
the coverage is as expected 100% but sonar shows only 80%.
Additionally, the **lines to cover** do not match with the already covered ones, it shows all possible 10 lines.

The sonar tasks debug log show that the source file is read multiple times:
```shell
[DEBUG] [org.sonarqube.gradle.SonarTask] Reading report '<projectdir>/build/reports/jacoco/testCodeCoverageReport/testCodeCoverageReport.xml'
```

## Procedure to reproduce

1. Build and run the tests
    ```shell
    ./gradlew test
    ```
2. Check Jacoco aggregated coverage is **100%**
    ```shell
    firefox build/reports/jacoco/testCodeCoverageReport/html/index.html 
    ```
   or check the XML file
    ```shell
    xmllint --format build/reports/jacoco/testCodeCoverageReport/testCodeCoverageReport.xml|less
    ```
3. Call the sonar task
    ```shell
    ./gradlew sonar -Dsonar.host.url=http://<PATH_TO_SONAR> -Dsonar.token=<YOUR_TOKEN>
    ```
4. Check in your sonar instance to see the coverage is only **80%**
