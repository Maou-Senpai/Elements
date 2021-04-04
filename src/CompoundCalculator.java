import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;

public abstract class CompoundCalculator extends GridPane implements StackPages {
    public static final ElementsInfo elementsInfo = new ElementsInfo();
    public final ScrollPane log = new ScrollPane();
    public final Label logContent = new Label("Log Here");
    public final ArrayList<Integer> orderOfClick = new ArrayList<>();

    @Override
    public void createPage() {
        this.setStyle("-fx-background-color: inherit; -fx-border-color: black; -fx-border-width: 3");

        VBox container = new VBox();
        logContent.setFont(Font.font("Courier-New", FontWeight.BOLD, 20));
        logContent.setWrapText(true);
        logContent.setTextAlignment(TextAlignment.CENTER);
        container.getChildren().add(logContent);
        container.setAlignment(Pos.CENTER);
        container.setPadding(new Insets(15, 0, 0, 0));
        log.setFitToWidth(true);
        log.setContent(container);
        GridPane.setMargin(log, new Insets(10, 10, 10, 10));
        this.add(log, 2, 0, 10, 3);

        for (int i = 0; i < 18; i++) {
            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setHalignment(HPos.CENTER);
            columnConstraints.setHgrow(Priority.SOMETIMES);
            columnConstraints.setPercentWidth(50 / 9.0);
            this.getColumnConstraints().add(columnConstraints);
        }
        for (int i = 0; i < 10; i++) {
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setVgrow(Priority.SOMETIMES);
            rowConstraints.setPercentHeight(10);
            this.getRowConstraints().add(rowConstraints);
        }
    }
}