import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseButton;

import java.util.Optional;

public class CompoundCompositionCalculator extends CompoundCalculator implements StackPages {
    private final double[] masses = new double[118];

    // Adds a Block to a Spot in the Grid
    private void fillTableForComp(int atomicNumber, int column, int row) {
        ElementBox elementBox = new ElementBox(elementsInfo.getElement(atomicNumber));
        elementBox.setOnMousePressed(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                TextInputDialog massInput = new TextInputDialog();
                double mass;
                massInput.setHeaderText("Input Mass (Numbers Only)");
                Optional<String> result = massInput.showAndWait();
                if (!result.isPresent()) return;
                try {
                    mass = Double.parseDouble(massInput.getEditor().getText());
                } catch (Exception e) {
                    return;
                }
                if (!orderOfClick.contains(atomicNumber)) {
                    orderOfClick.add(atomicNumber);
                    elementBox.setStyle("-fx-border-color: black");
                }
                masses[orderOfClick.indexOf(atomicNumber)] = mass;
            } else if (event.getButton() == MouseButton.SECONDARY) {
                orderOfClick.remove((Object) atomicNumber);
                String style = "-fx-border-color: black; -fx-background-color: ";
                style += elementsInfo.getSubcategory(atomicNumber).getColor();
                elementBox.setStyle(style);
            }

            updateLog();
        });
        this.add(elementBox, column - 1, row - 1);
    }

    private void updateLog() {
        double totalMass = 0;
        StringBuilder compoundName = new StringBuilder();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < orderOfClick.size(); i++) {
            stringBuilder.append(masses[i]).append(" of ");
            stringBuilder.append(elementsInfo.getName(orderOfClick.get(i))).append('\n');
            totalMass += masses[i];
            compoundName.append(" ").append(elementsInfo.getSymbol(orderOfClick.get(i)));
            compoundName.append(String.format("%.2f", masses[i] / elementsInfo.getAtomicWeight(orderOfClick.get(i))));
        }

        if (totalMass != 0) {
            stringBuilder.append("---------------\n").append("Atomic Mass: ").append(totalMass).append('\n');
            stringBuilder.append("Chemical Composition:").append(compoundName);
        }
        logContent.setText(stringBuilder.toString());
    }

    @Override
    public void createPage() {
        super.createPage();

        // Puts First Row
        fillTableForComp(1, 1, 1);
        fillTableForComp(2, 18, 1);

        // Puts Second Row
        fillTableForComp(3, 1, 2);
        fillTableForComp(4, 2, 2);
        for (int i = 0; i < 6; i++) {
            fillTableForComp(5 + i, 13 + i, 2);
        }

        // Puts Third Row
        fillTableForComp(11, 1, 3);
        fillTableForComp(12, 2, 3);
        for (int i = 0; i < 6; i++) {
            fillTableForComp(13 + i, 13 + i, 3);
        }

        // Puts 4th and 5th Row
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 18; j++) {
                fillTableForComp(19 + j + (i * 18) , 1 + j, 4 + i);
            }
        }

        // Puts 6th Row
        fillTableForComp(55, 1, 6);
        fillTableForComp(56, 2, 6);
        for (int i = 0; i < 15; i ++) {
            fillTableForComp(72 + i, 4 + i, 6);
        }

        // Puts 7th Row
        fillTableForComp(87, 1, 7);
        fillTableForComp(88, 2, 7);
        for (int i = 0; i < 15; i ++) {
            fillTableForComp(104 + i, 4 + i, 7);
        }

        // Puts 8th Row
        for (int i = 0; i < 15; i ++) {
            fillTableForComp(57 + i, 3 + i, 9);
        }

        // Puts 9th Row
        for (int i = 0; i < 15; i ++) {
            fillTableForComp(89 + i, 3 + i, 10);
        }
    }
}