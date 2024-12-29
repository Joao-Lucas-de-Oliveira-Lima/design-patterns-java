package factory;

import component.button.Button;
import component.button.MacButton;
import component.checkbox.CheckBox;
import component.checkbox.MacCheckBox;
import component.textfield.MacTextField;
import component.textfield.TextField;

public class MacGUIFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacCheckBox();
    }

    @Override
    public TextField createTextField() {
        return new MacTextField();
    }
}