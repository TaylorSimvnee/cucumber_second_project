# Welcome to the Framework 😉

This is a **BDD** framework, which means it was written with clear behaviors first, then followed by code implementation. This framework is utilizing the following. **CUCUMBER**: It has 3 major features. **PAGES**, which are following a Page Object Model design. **FEATURE FILE**, that contains scenarios that are annotated for Smoke and Regression suites. Each scenario is written in Gherkin language, that is simple enough for anyone to understand.  **RUNNER CLASS**, which allows the feature file and its corresponding step implementations to be linked, and allows suites to be ran separately. **MAVEN** : As a build tool, taking advantage of its easy-to-follow folder structure. Maven provides the **POM.XML** file where this framework centralizes all dependencies and plugins. Lastly, Maven provided a target folder, which stores all generated reports. **HOOKS** class: Is configured to take screenshots of failures for generated reports if necessary, and will always execute a proper tearDown after each test is finished with its browser window.
Lastly utilizing a **UTILITIES** folder to create cleaner code, and reusable methods.

## Execution of Smoke and Regression suites
This framework supports separate suite execution via the **RUNNER** class by updating tags to equal @Smoke or regression `or` the following **MVN** commands to be ran in terminal:

`mvn test -Dcucumber.options="--tags @Regression"`
`mvn test -Dcucumber.options=”--tags @Smoke"`
