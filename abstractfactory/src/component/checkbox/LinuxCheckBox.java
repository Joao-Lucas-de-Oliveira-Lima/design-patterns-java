package component.checkbox;
public class LinuxCheckBox implements CheckBox {
    private boolean checked = false;

    @Override
    public void render() {
        System.out.println("Rendering a Linux checkbox.");
    }

    @Override
    public boolean isChecked() {
        return checked;
    }

    @Override
    public void toggle() {
        checked = !checked;
        System.out.println("Linux checkbox toggled to: " + (checked ? "Checked" : "Unchecked"));
    }
}