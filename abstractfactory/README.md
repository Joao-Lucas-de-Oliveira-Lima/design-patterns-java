# Abstract Factory Design Pattern

## About the Pattern
The **Abstract Factory** design pattern provides an interface for creating families of related or dependent objects without specifying their concrete classes. Its main goal is to allow a system to work with various groups of related objects while keeping the client code decoupled from specific implementations.

- **Type:** Creational

---

## Project Structure
```
abstractfactory/
├── src/
│   ├── app/                # Application logic
│   ├── component/          # GUI components
│   │   ├── button/         # Button interfaces and implementations
│   │   ├── checkbox/       # CheckBox interfaces and implementations
│   │   └── textfield/      # TextField interfaces and implementations
│   ├── factory/            # Abstract Factory and Concrete Factories
│   └── Main.java           # Main application entry point
└── README.md               # Project documentation
```

---

## Solution
This project demonstrates the Abstract Factory pattern in the context of GUI components for a user interface (UI). 

### Component Interfaces
Define the structure and methods for components.

**Code Example:**
```java
public interface Button {
    void render();
    void onClick();
}
```

```java
public interface CheckBox {
    void render();
    boolean isChecked();
    void toggle();
}
```

```java
public interface TextField {
    void render();
    void setText(String text);
    String getText();
}
```

### Concrete Components
Provide specific implementations of the component interfaces. For instance, `LinuxButton` contains logic (e.g., a `System.out.println` statement) to indicate it is a Linux-specific button.

**Code Example:**
```java
public class LinuxButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a Linux button.");
    }

    @Override
    public void onClick() {
        System.out.println("Linux button clicked.");
    }
}
```

### Abstract Factory Interface
Declares methods for creating related objects, such as `Button`, `CheckBox`, and `TextField`.

**Code Example:**
```java
public interface GUIFactory {
    Button createButton();
    CheckBox createCheckBox();
    TextField createTextField();
}
```

### Concrete Factories
Implement the abstract factory interface to produce components tailored to specific platforms. For example, the `LinuxGUIFactory` creates `LinuxButton`, `LinuxCheckBox`, and `LinuxTextField`.

**Code Example:**
```java
public class LinuxGUIFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new LinuxButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new LinuxCheckBox();
    }

    @Override
    public TextField createTextField() {
        return new LinuxTextField();
    }
}
```

### Application Logic
The `App` class holds a `GUIFactory` attribute and uses it to render the UI by calling methods on the factory. Based on the type of factory passed to the constructor (e.g., `LinuxGUIFactory`, `WindowsGUIFactory`), the application displays components for the corresponding platform.

**Code Example:**
```java
public class App {
    private GUIFactory factory;

    public App(GUIFactory factory) {
        this.factory = factory;
    }

    public void renderUI() {
        Button button = factory.createButton();
        CheckBox checkBox = factory.createCheckBox();
        TextField textField = factory.createTextField();

        button.render();
        button.onClick();

        checkBox.render();
        System.out.println("Checkbox state: " + (checkBox.isChecked() ? "Checked" : "Unchecked"));
        checkBox.toggle();

        textField.render();
        textField.setText("Sample text");
        System.out.println("Text field content: " + textField.getText());
    }
}
```

### Main class
The `Main` class creates an instance of the `App` class, passing different types of factories to demonstrate the flexibility of the pattern in action.

**Code Example:**
```java
public class Main {
    public static void main(String[] args) {
        App app = new App(new LinuxGUIFactory());

        app.renderUI();
        System.out.print(System.lineSeparator());
                
        app.setFactory(new MacGUIFactory());

        app.renderUI();
        System.out.print(System.lineSeparator());

        app.setFactory(new WindowsGUIFactory());

        app.renderUI();
        System.out.print(System.lineSeparator());
    }
}
```

---

## References
- [Refactoring Guru - Abstract Factory Pattern](https://refactoring.guru/design-patterns/abstract-factory)
- *Design Patterns: Elements of Reusable Object-Oriented Software*