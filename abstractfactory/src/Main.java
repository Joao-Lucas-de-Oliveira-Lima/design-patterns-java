import app.App;
import factory.LinuxGUIFactory;
import factory.MacGUIFactory;
import factory.WindowsGUIFactory;

public class Main {
    public static void main(String[] args) {
        App app = new App(new LinuxGUIFactory());

        app.renderUI();
        System.out.print(System.lineSeparator());
        
        app.setFactory(new MacGUIFactory());

        app.renderUI();
        System.out.print(System.lineSeparator());

        app.setFactory(new WindowsGUIFactory());

        app.renderUI();
        System.out.print(System.lineSeparator());
    }
}
