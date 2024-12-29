package factory;
import component.button.Button;
import component.checkbox.CheckBox;
import component.textfield.TextField;

public interface GUIFactory {
    Button createButton();
    CheckBox createCheckBox();
    TextField createTextField();
}
