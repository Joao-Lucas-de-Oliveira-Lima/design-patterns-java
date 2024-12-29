package component.button;

public class WinButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a Windows button.");
    }

    @Override
    public void onClick() {
        System.out.println("Windows button clicked.");
    }
}