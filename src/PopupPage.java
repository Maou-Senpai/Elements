import Elements.Element;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

public class PopupPage extends VBox implements StackPages {
    private final EmbeddedBrowser browser = new EmbeddedBrowser();
    private final Button searchButton = new Button("Search the Web");
    private final Element element;

    public PopupPage(Element element) {
        this.setAlignment(Pos.CENTER);
        this.element = element;
        this.setStyle("-fx-border-color: black; -fx-border-width: 3; -fx-background-color: papayawhip");
    }

    public void showBrowser(Element element) {
        ((Pane) this.getParent()).getChildren().add(browser.getEmbeddedBrowser(element));
    }

    // -1 for default font size, which is 24
    private void formatAndAddLabel(Label label, int fontSize) {
        if (fontSize == -1) fontSize = 24;
        label.setWrapText(true);
        label.setFont(Font.font("Courier-New", FontWeight.BOLD, fontSize));
        this.getChildren().add(label);
    }

    @Override
    public void createPage() {
        // Creates Header (Name and Symbol)
        Label tempLabel = new Label(element.getName() + " (" + element.getSymbol() + ")");
        tempLabel.setPadding(new Insets(0, 0, 30, 0));
        formatAndAddLabel(tempLabel, 36);

        // Creates Atomic Number
        tempLabel = new Label("Atomic Number: " + element.getAtomicNumber());
        formatAndAddLabel(tempLabel, -1);

        // Creates Atomic Weight
        tempLabel = new Label("Atomic Mass: " + element.getAtomicWeight());
        formatAndAddLabel(tempLabel, -1);

        // Creates State of Matter
        tempLabel = new Label("State of Matter: " + element.getStateOfMatter().toString());
        formatAndAddLabel(tempLabel, -1);

        // Creates Subcategory
        tempLabel = new Label("Subcategory: " + element.getSubcategory());
        formatAndAddLabel(tempLabel, -1);

        // Creates Description
        tempLabel = new Label("Brief Description: " + element.getDescription());
        tempLabel.setTextAlignment(TextAlignment.JUSTIFY);
        tempLabel.setPadding(new Insets(30, 20, 30, 20));
        formatAndAddLabel(tempLabel, 24);

        // Add Search Button
        searchButton.setFont(Font.font("Courier-New", FontWeight.BOLD, 24));
        searchButton.setOnMouseClicked(event -> showBrowser(element));
        this.getChildren().add(searchButton);
    }
}