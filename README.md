## Run test script of PlayWright
mvn compile exec:java -D exec.mainClass="org.example.App"
## Run test script of TestNG
mvn clean test -DSuiteXmlFile="testng.xml"
## Run Allure Report
allure serve .\allure-results\