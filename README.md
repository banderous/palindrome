# Palindrome finder

## Dependencies

A Java 1.8 runtime

## Build & test

The project is built with the Gradle wrapper,
gradlew or gradlew.bat on Windows.

```
gradlew test
```

## Run

```
gradlew run -Pinput=sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop
```


```
Alexs-MBP:palindrome alex$ ./gradlew run -Pinput=sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop
:compileJava UP-TO-DATE
:compileGroovy NO-SOURCE
:processResources NO-SOURCE
:classes UP-TO-DATE
:run
Text: hijkllkjih, Index: 23, Length: 10
Text: defggfed, Index: 13, Length: 8
Text: abccba, Index: 5, Length: 6

BUILD SUCCESSFUL

Total time: 1.12 secs
```
