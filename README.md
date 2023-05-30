# Java Design Patterns

[![Gradle CI](https://github.com/gazbert/java-design-patterns/actions/workflows/gradle.yml/badge.svg?branch=master)](https://github.com/gazbert/java-design-patterns/actions/workflows/gradle.yml) 
[![Maven CI](https://github.com/gazbert/java-design-patterns/actions/workflows/maven.yml/badge.svg?branch=master)](https://github.com/gazbert/java-design-patterns/actions/workflows/maven.yml)

A cookbook of commonly used Java design patterns based on examples from: 

* "Design Patterns: Elements of Reusable Object-Oriented Software" - Gamma et al
* "Head First Design Patterns" - Freeman et al
* "Java Design Pattern Essentials" - Tony Brevis

Each pattern is contained in its own package. The Javadoc will provide more details and the unit tests 
will demonstrate how to use it.

Any comments/bugs/better ways of doing things, send 'em my way.

## Design Patterns

### Behavioural

1. State
1. Chain of Responsibility
1. Strategy
1. Observer
1. Command
1. Template Method
1. Visitor

### Creational

1. Builder
1. Factory Method
1. Static Factory Method / Simple Factory Method
1. Abstract Factory
1. Singleton

### Structural

1. Adapter
1. Decorator
1. Facade

## Build Guide
You'll need JDK 17+ installed on your dev box.

### Gradle
You can use the included Gradle wrapper to build the project and pull down the dependencies:

```bash
./gradlew build
```

The Javadoc can be found in the `<project-root>/build/docs/javadoc` folder after you execute the build.

### Maven
You can use the included Maven wrapper to build the project and pull down the dependencies:

```bash
./mvnw clean install
```

The Javadoc can be found in the `<project-root>/target/apidocs` folder after you execute the build.

## Contributing
Issues and new features are managed using the project [Issue Tracker](https://github.com/gazbert/java-design-patterns/issues) -
submit bugs here.

You are welcome to take on new features or fix bugs! See [here](CONTRIBUTING.md) for how to get involved.
