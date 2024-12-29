package component.checkbox;
public class MacCheckBox implements CheckBox {
    private boolean checked = false;

    @Override
    public void render() {
        System.out.println("Rendering a Mac checkbox.");
    }

    @Override
    public boolean isChecked() {
        return checked;
    }

    @Override
    public void toggle() {
        checked = !checked;
        System.out.println("Mac checkbox toggled to: " + (checked ? "Checked" : "Unchecked"));
    }
}