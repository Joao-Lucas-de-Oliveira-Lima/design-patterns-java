package factory;
import component.button.Button;
import component.button.LinuxButton;
import component.checkbox.CheckBox;
import component.checkbox.LinuxCheckBox;
import component.textfield.TextField;
import component.textfield.LinuxTextField;

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