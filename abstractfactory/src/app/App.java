package app;
import factory.GUIFactory;
import component.button.Button;
import component.checkbox.CheckBox;
import component.textfield.TextField;

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

    public GUIFactory getFactory() {
        return factory;
    }

    public void setFactory(GUIFactory factory) {
        this.factory = factory;
    }
}