import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

public class CompoundMassCalculator extends CompoundCalculator implements StackPages {
    private final int[] multiplier = new int[118];

    // Adds a Block to a Spot in the Grid
    private void fillTableForMass(int atomicNumber, int column, int row) {
        ElementBox elementBox = new ElementBox(elementsInfo.getElement(atomicNumber));
        Label multiplierLabel = new Label("0");
        elementBox.getChildren().add(multiplierLabel);
        elementBox.setOnMousePressed(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                multiplier[atomicNumber - 1]++;
                if (!orderOfClick.contains(atomicNumber)) orderOfClick.add(atomicNumber);
            }
            else if (event.getButton() == MouseButton.SECONDARY && multiplier[atomicNumber - 1] > 0) {
                multiplier[atomicNumber - 1]--;
                if (multiplier[atomicNumber - 1] == 0) orderOfClick.remove((Object) atomicNumber);
            }
            multiplierLabel.setText(Integer.toString(multiplier[atomicNumber - 1]));
            if (multiplier[atomicNumber - 1] != 0) elementBox.setStyle("-fx-border-color: black");
            else {
                String style = "-fx-border-color: black; -fx-background-color: ";
                style += elementsInfo.getSubcategory(atomicNumber).getColor();
                elementBox.setStyle(style);
            }
            updateLog();
        });
        this.add(elementBox, column - 1, row - 1);
    }

    private void updateLog() {
        double compoundMass = 0;
        StringBuilder compoundName = new StringBuilder();
        StringBuilder stringBuilder = new StringBuilder();

        for (int atomicNumber : orderOfClick) {
            stringBuilder.append(multiplier[atomicNumber - 1]);
            if (multiplier[atomicNumber - 1] == 1) stringBuilder.append(" Item Of ");
            else stringBuilder.append(" Items Of ");
            stringBuilder.append(elementsInfo.getName(atomicNumber)).append('\n');
            compoundMass += elementsInfo.getAtomicWeight(atomicNumber) * multiplier[atomicNumber - 1];
            compoundName.append(elementsInfo.getSymbol(atomicNumber));
            if (multiplier[atomicNumber - 1] > 1) compoundName.append(multiplier[atomicNumber - 1]);
        }

        if (compoundMass != 0) {
            stringBuilder.append("----------\n").append("Mass of ").append(compoundName);
            stringBuilder.append(": ").append(String.format("%.2f", compoundMass));
        }
        logContent.setText(stringBuilder.toString());
    }

    @Override
    public void createPage() {
        super.createPage();

        for (int i = 0; i < 118; i++) {
            multiplier[i] = 0;
        }

        // Puts First Row
        fillTableForMass(1, 1, 1);
        fillTableForMass(2, 18, 1);

        // Puts Second Row
        fillTableForMass(3, 1, 2);
        fillTableForMass(4, 2, 2);
        for (int i = 0; i < 6; i++) {
            fillTableForMass(5 + i, 13 + i, 2);
        }

        // Puts Third Row
        fillTableForMass(11, 1, 3);
        fillTableForMass(12, 2, 3);
        for (int i = 0; i < 6; i++) {
            fillTableForMass(13 + i, 13 + i, 3);
        }

        // Puts 4th and 5th Row
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 18; j++) {
                fillTableForMass(19 + j + (i * 18) , 1 + j, 4 + i);
            }
        }

        // Puts 6th Row
        fillTableForMass(55, 1, 6);
        fillTableForMass(56, 2, 6);
        for (int i = 0; i < 15; i ++) {
            fillTableForMass(72 + i, 4 + i, 6);
        }

        // Puts 7th Row
        fillTableForMass(87, 1, 7);
        fillTableForMass(88, 2, 7);
        for (int i = 0; i < 15; i ++) {
            fillTableForMass(104 + i, 4 + i, 7);
        }

        // Puts 8th Row
        for (int i = 0; i < 15; i ++) {
            fillTableForMass(57 + i, 3 + i, 9);
        }

        // Puts 9th Row
        for (int i = 0; i < 15; i ++) {
            fillTableForMass(89 + i, 3 + i, 10);
        }
    }
}