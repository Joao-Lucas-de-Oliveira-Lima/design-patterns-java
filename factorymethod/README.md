# Factory Method Design Pattern  

## About the Pattern  

The **Factory Method** design pattern defines a common interface for object creation, allowing subclasses to determine which specific type to instantiate. 
## Implementation  

### Interface `Relatory` and Concrete Classes  

A `Relatory` interface is created along with three concrete classes that implement it. Each type of `Relatory` will have its own corresponding factory method.  

```java
public interface Relatory {
    void generateRelatory();
}

public class RelatoryCsv implements Relatory {
    @Override
    public void generateRelatory() {
        System.out.println("Generating CSV report...");
    }
}

public class RelatoryExcel implements Relatory {
    @Override
    public void generateRelatory() {
        System.out.println("Generating Excel report...");
    }
}

public class RelatoryPdf implements Relatory {
    @Override
    public void generateRelatory() {
        System.out.println("Generating PDF report...");
    }
}
```

### Factory Methods  

A `RelatoryFactory` interface is created, containing a method `createRelatory`, which returns a `Relatory` object. Each concrete factory class implements this interface and returns the corresponding type of `Relatory`.  

```java
public interface RelatoryFactory {
    Relatory createRelatory();
}

public class RelatoryCsvFactory implements RelatoryFactory {
    @Override
    public Relatory createRelatory() {
        RelatoryCsv relatoryCsv = new RelatoryCsv();
        relatoryCsv.generateRelatory();
        return relatoryCsv;
    }
}

public class RelatoryExcelFactory implements RelatoryFactory {
    @Override
    public Relatory createRelatory() {
        RelatoryExcel relatoryExcel = new RelatoryExcel();
        relatoryExcel.generateRelatory();
        return relatoryExcel;
    }
}

public class RelatoryPdfFactory implements RelatoryFactory {
    @Override
    public Relatory createRelatory() {
        RelatoryPdf relatoryPdf = new RelatoryPdf();
        relatoryPdf.generateRelatory();
        return relatoryPdf;
    }
}
```

### Usage  

Since `RelatoryFactory` returns a `Relatory`, it can instantiate objects of any class that implements this interface. Additionally, because `RelatoryFactory` itself is an interface, it can be assigned to any of its concrete implementations.  

This approach enables the creation of new `RelatoryFactory` classes and new types of reports without modifying existing components, ensuring compatibility through well-defined contracts.  

```java
RelatoryFactory factory;

factory = new RelatoryPdfFactory();
Relatory pdfReport = factory.createRelatory();

factory = new RelatoryCsvFactory();
Relatory csvReport = factory.createRelatory();

factory = new RelatoryExcelFactory();
Relatory excelReport = factory.createRelatory();
```