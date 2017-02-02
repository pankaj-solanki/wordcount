Hello Pankaj Solanki Whatsup
# Word Count Assignment

### Steps to build
(1) Checkout source.
```sh
    git clone https://github.com/pankaj-solanki/wordcount.git
```
(2) Go into wordcount dir and build using following maven command:
```sh
    mvn clean install
```
(3) Copy target/wordcount.war into tomcat's webapp directory.

(4) Pass following as JAVA_OPTS. This can be done by setting JAVA_OPTS in setclasspath.sh
```sh
    -Dspring.profiles.active=dev
```
(5) Hit url from browser
```sh
    http://localhost:8080/wordcount/search?query=thread
```

##Input text files
Under src/main/resources/ check "input.files" property in application-dev.properties file.
This property specifies input text files.
