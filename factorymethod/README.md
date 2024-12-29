# Factory Method Design Pattern

## About the Pattern
The **Factory Method** design pattern defines a common interface for object creation, allowing subclasses to determine the specific type to instantiate. It's particularly useful when there are multiple variations of objects, allowing flexibility in the creation process.

- **Type:** Creational

---

## Project Structure
```
factory/
├── src/
│   ├── App.java    # Main application logic
│   ├── model/      # Models for different report types
│   └── relatory/   # Factories for creating report objects
└── README.md       # Project documentation
```

---

## Solution
This project demonstrates the Factory design pattern by creating different types of report objects (e.g., CSV, Excel, PDF) through specialized factory classes.

### Abstract Base Class: Relatory
The `Relatory` interface defines the common behavior that all reports must implement.

**Code Example:**
```java
public interface Relatory {
    void generateRelatory();
}
```

### Concrete Implementations
Examples of classes implementing the Relatory interface:

**RelatoryCsv:**
```java
public class RelatoryCsv implements Relatory {
    @Override
    public void generateRelatory() {
        System.out.println("Generating CSV relatory...");
    }
}
```
**RelatoryPdf:**
```java
public class RelatoryPdf implements Relatory {
    @Override
    public void generateRelatory() {
        System.out.println("Generating PDF report...");
    }
}
```

### Factory Classes
#### Abstract Factory Interface
The `RelatoryFactory` interface declares the factory method `createRelatory`, which returns a `Relatory` object.

```java
public interface RelatoryFactory {
    Relatory createRelatory();
}
```
### Concrete Factory Implementations
Each concrete factory implements the `createRelatory` method to return a specific type of report object.
**RelatoryCsvFactory:**
```java
public class RelatoryCsvFactory implements RelatoryFactory {
    @Override
    public Relatory createRelatory() {
        RelatoryCsv relatoryCsv = new RelatoryCsv();
        relatoryCsv.generateRelatory();
        return relatoryCsv;
    }
}
```
**RelatoryPdfFactory:**
```java
public class RelatoryPdfFactory implements RelatoryFactory {
    @Override
    public Relatory createRelatory() {
        RelatoryPdf relatoryPdf = new RelatoryPdf();
        relatoryPdf.generateRelatory();
        return relatoryPdf;
    }
}
```

### Main Application
The `App` class demonstrates how to use the Factory design pattern. It initializes specific factory classes to create and manipulate reports dynamically.

**Code Example:**
```java
public class App {
    public static void main(String[] args) {
        RelatoryFactory factory;

        factory = new RelatoryPdfFactory();
        Relatory pdfReport = factory.createRelatory();

        factory = new RelatoryCsvFactory();
        Relatory csvReport = factory.createRelatory();
    }
}
```

---

## References
- [Refactoring Guru - Factory Pattern](https://refactoring.guru/design-patterns/factory-method)
- *Design Patterns: Elements of Reusable Object-Oriented Software*