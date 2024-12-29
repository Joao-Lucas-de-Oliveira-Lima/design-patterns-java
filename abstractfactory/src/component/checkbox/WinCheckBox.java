package component.checkbox;

public class WinCheckBox implements CheckBox {
    private boolean checked = false;

    @Override
    public void render() {
        System.out.println("Rendering a Windows checkbox.");
    }

    @Override
    public boolean isChecked() {
        return checked;
    }

    @Override
    public void toggle() {
        checked = !checked;
        System.out.println("Windows checkbox toggled to: " + (checked ? "Checked" : "Unchecked"));
    }
}