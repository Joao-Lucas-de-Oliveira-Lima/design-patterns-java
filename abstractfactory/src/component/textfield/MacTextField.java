package component.textfield;
public class MacTextField implements TextField {
    private String text = "";

    @Override
    public void render() {
        System.out.println("Rendering a Mac text field.");
    }

    @Override
    public void setText(String text) {
        this.text = text;
        System.out.println("Mac text field updated: " + text);
    }

    @Override
    public String getText() {
        return text;
    }
}
