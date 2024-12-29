package component.button;

public class LinuxButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a Linux button.");
    }

    @Override
    public void onClick() {
        System.out.println("Linux button clicked.");
    }
}