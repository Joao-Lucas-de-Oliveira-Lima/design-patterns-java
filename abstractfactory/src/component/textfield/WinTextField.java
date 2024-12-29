package component.textfield;
public class WinTextField implements TextField {
    private String text = "";

    @Override
    public void render() {
        System.out.println("Rendering a Windows text field.");
    }

    @Override
    public void setText(String text) {
        this.text = text;
        System.out.println("Windows text field updated: " + text);
    }

    @Override
    public String getText() {
        return text;
    }
}