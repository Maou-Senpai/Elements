import Elements.Subcategory;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ColorCodings extends HBox implements StackPages {
    public ColorCodings() {
        this.setAlignment(Pos.CENTER);
        this.setSpacing(40);
        this.setPadding(new Insets(20, 0, 20, 0));
        this.setStyle("-fx-background-color: darkslategray");
    }

    @Override
    public void createPage() {
        VBox leftSide = new VBox();
        leftSide.setAlignment(Pos.CENTER);

        VBox rightSide = new VBox();
        rightSide.setAlignment(Pos.CENTER);

        for (Subcategory subcategory : Subcategory.values()) {
            Label backgroundMeaning = new Label(subcategory.toString());
            backgroundMeaning.setStyle("-fx-text-fill: " + subcategory.getColor());
            backgroundMeaning.setFont(Font.font("Courier-New", FontWeight.BOLD, 20));
            if (subcategory.ordinal() < 5) leftSide.getChildren().add(backgroundMeaning);
            else rightSide.getChildren().add(backgroundMeaning);
        }

        this.getChildren().addAll(leftSide, rightSide);
    }
}