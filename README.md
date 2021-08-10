# TestAllLinks

---
Before using, please make sure that your machine has already
installed chrome-web-driver, if not, for macOS, you can use

    brew install --cask chromedriver
to install it.

---

To compile use command:

    mvn package assembly:single

Then we have a target folder, and a "TestAllLinks-1.0-jar-
with-dependencies.jar" file in that folder, we are going to
run it by the command as following:

    java -jar ./target/TestAllLinks-1.0-jar-with-dependencies.jar

In above way, the default page https://www.google.com will
be tested. You can also append another url to test, for example:

    java -jar ./target/TestAllLinks-1.0-jar-with-dependencies.jar http://www.baidu.com

