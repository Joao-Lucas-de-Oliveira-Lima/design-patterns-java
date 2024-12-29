package factory;

import component.button.Button;
import component.button.WinButton;
import component.checkbox.CheckBox;
import component.checkbox.WinCheckBox;
import component.textfield.TextField;
import component.textfield.WinTextField;

public class WindowsGUIFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WinButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WinCheckBox();
    }

    @Override
    public TextField createTextField() {
        return new WinTextField();
    }
}