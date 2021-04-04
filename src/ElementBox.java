import Elements.Element;
import Elements.Subcategory;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ElementBox extends VBox {
    public ElementBox(Element element) {
        // Fixes Alignment
        this.setAlignment(Pos.CENTER);

        // Adds Atomic Number
        Label tempLabel = new Label(Integer.toString(element.getAtomicNumber()));
        tempLabel.setFont(Font.font("Courier-New", FontWeight.BOLD, 16));
        this.getChildren().add(tempLabel);

        // Adds Symbol
        tempLabel = new Label(element.getSymbol());
        tempLabel.setFont(Font.font("Courier-New", FontWeight.BOLD, 20));
        this.getChildren().add(tempLabel);

        // Adjust Background Color
        Subcategory subcategory = element.getSubcategory();
        this.setStyle("-fx-background-color: " + subcategory.getColor());

        this.setStyle(this.getStyle() + "; -fx-border-color: black; -fx-border-width: 1");
    }
}