import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import java.util.Random;

public class MiniQuiz extends VBox implements StackPages {
    private final ElementsInfo elementsInfo = new ElementsInfo();
    private final Label streak = new Label();
    private final Label question = new Label();
    private final int buttonCount = 4;
    private final Label[] choice = new Label[buttonCount];
    private final Random random = new Random();
    private int correctButton;
    private final GridPane choicesLayout = new GridPane();
    private int streakCount = 0;

    @Override
    public void createPage() {
        this.setStyle("-fx-background-color: inherit; -fx-border-color: black; -fx-border-width: 3");
        this.setAlignment(Pos.TOP_CENTER);
        this.setSpacing(50);
        this.setPadding(new Insets(20, 0, 0, 0));

        // Adds Streak Label
        streak.setFont(Font.font("Courier-New", 24));
        streak.setText("Streak: 0");
        this.getChildren().add(streak);

        // Adds Question Label
        question.setFont(Font.font("Courier-New", 30));
        question.setTextAlignment(TextAlignment.JUSTIFY);
        question.setPadding(new Insets(0, 20, 0, 20));
        question.setWrapText(true);
        question.setMinHeight(200);
        this.getChildren().add(question);

        // Adds GridPane for Choices
        VBox.setVgrow(choicesLayout, Priority.SOMETIMES);
        for (int i = 0; i < 2; i++) {
            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setHalignment(HPos.CENTER);
            columnConstraints.setHgrow(Priority.SOMETIMES);
            columnConstraints.setPercentWidth(50);
            choicesLayout.getColumnConstraints().add(columnConstraints);
        }
        for (int i = 0; i < 2; i++) {
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setVgrow(Priority.SOMETIMES);
            choicesLayout.getRowConstraints().add(rowConstraints);
        }

        for (int i = 0; i < buttonCount; i++) {
            choice[i] = new Label();
        }
        choicesLayout.setGridLinesVisible(true);
        formatAndAddChoices(choice[0], 0, 0, 0);
        formatAndAddChoices(choice[1], 1, 0, 1);
        formatAndAddChoices(choice[2], 0, 1, 2);
        formatAndAddChoices(choice[3], 1, 1, 3);

        this.getChildren().add(choicesLayout);
        generateQuiz();
    }

    private void formatAndAddChoices(Label label, int column, int row, int returnValue) {
        HBox labelContainer = new HBox();
        labelContainer.setAlignment(Pos.CENTER);
        labelContainer.setOnMouseEntered(event -> labelContainer.setStyle("-fx-background-color: lightskyblue"));
        labelContainer.setOnMouseExited(event -> labelContainer.setStyle(""));
        labelContainer.setOnMousePressed(event -> checkAnswer(returnValue));
        label.setAlignment(Pos.CENTER);
        label.setFont(Font.font("Courier-New", 36));
        label.setWrapText(true);
        labelContainer.getChildren().add(label);
        choicesLayout.add(labelContainer, column, row);
    }

    private void checkAnswer(int clickedButton) {
        if (clickedButton == correctButton) {
            streakCount++;
            streak.setText("Streak: " + streakCount);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Correct");
            alert.showAndWait();
        } else {
            streakCount = 0;
            streak.setText("Streak: " + streakCount);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Wrong");
            alert.showAndWait();
        }
        generateQuiz();
    }

    private void generateQuiz() {
        // Fill Button with 4 Different Elements
        int[] buttonContents = new int[4];
        for (int i = 0; i < buttonCount; i++) {
            boolean repeated;
            do {
                buttonContents[i] = random.nextInt(118) + 1;
                repeated = false;
                for (int j = 0; j < i; j++) {
                    if (buttonContents[i] == buttonContents[j]) {
                        repeated = true;
                        break;
                    }
                }
            } while (repeated);
        }

        // Choose Random Correct Button and Random Question Type
        correctButton = random.nextInt(4);
        int questionType = random.nextInt(5);

        // Question Setter
        if (questionType == 0) {
            question.setText("Which Element Has Atomic Number: " + buttonContents[correctButton]);
        }
        else if (questionType == 1) {
            question.setText("Which Element Has The Symbol: " + elementsInfo.getSymbol(buttonContents[correctButton]));
        }
        else if (questionType == 2) {
            question.setText("Which Element Has Atomic Weight: " + elementsInfo.getAtomicWeight(buttonContents[correctButton]));
        }
        else {
            question.setText("Which Element Is Being Described: " + elementsInfo.getDescription(buttonContents[correctButton]));
        }

        // Button Setter
        for (int i = 0; i < buttonCount; i++) {
            choice[i].setText(elementsInfo.getName(buttonContents[i]));
        }
    }
}