# Abstract Factory

## About the Pattern
The **Abstract Factory** design pattern provides an interface for creating families of related or dependent objects without specifying their concrete classes.

## Implementation

### Creating Component Families
Three main families of components are created: **Button**, **CheckBox**, and **TextField**. Each has its own interface and is associated with a specific operating system.

- **Buttons**
```java
public interface Button {
    void render();
    void onClick();
}

public class LinuxButton implements Button {
    // Overridden methods
}

public class MacButton implements Button {
    // Overridden methods
}

public class WinButton implements Button {
    // Overridden methods
}
```

- **CheckBox**
```java
public interface CheckBox {
    void render();
    boolean isChecked();
    void toggle();
}

public class LinuxCheckBox implements CheckBox {
    private boolean checked = false;
    // Overridden methods
}

public class MacCheckBox implements CheckBox {
    private boolean checked = false;
    // Overridden methods
}

public class WinCheckBox implements CheckBox {
    private boolean checked = false;
    // Overridden methods
}
```

- **TextField**
```java
public interface TextField {
    void render();
    void setText(String text);
    String getText();
}

public class LinuxTextField implements TextField {
    // Overridden methods
}

public class MacTextField implements TextField {
    // Overridden methods
}

public class WindowsTextField implements TextField {
    // Overridden methods
}
```

### Creating Factories
An interface **GUIFactory** is created to represent the factories. Each factory method returns an object of a specific interface type, and each concrete factory returns objects that match the corresponding OS interface.

```java
public interface GUIFactory {
    Button createButton();
    CheckBox createCheckBox();
    TextField createTextField();
}

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

public class MacGUIFactory implements GUIFactory {
    // Similar to LinuxGUIFactory
}

public class WindowsGUIFactory implements GUIFactory {
    // Similar to LinuxGUIFactory
}
```

### Centralizing the Component Logic in a Factory
The **App** class contains a **GUIFactory** and, in the `renderUI` method, it calls all output methods of its components.

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

    // Other methods such as setters and getters
}
```

### Usage
Since each factory implements **GUIFactory**, it is possible to assign new factories dynamically using `setFactory`. Each factory provides its own distinct set of components while following the same contract.

```java
App app = new App(new LinuxGUIFactory());
app.renderUI();
System.out.print(System.lineSeparator());

app.setFactory(new MacGUIFactory());
app.renderUI();
System.out.print(System.lineSeparator());

app.setFactory(new WindowsGUIFactory());
app.renderUI();
System.out.print(System.lineSeparator());
```