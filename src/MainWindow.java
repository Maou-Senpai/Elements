import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MainWindow {
    public VBox mainLayout;
    public StackPane stackLayout;
    public GridPane gridLayout;
    public Menu options;
    public Menu help;
    private final ElementsInfo elementsInfo = new ElementsInfo();

    // Adds a Block to a Spot in the Grid
    private void addBlock(int atomicNumber, int column, int row) {
        ElementBox elementBox = new ElementBox(elementsInfo.getElement(atomicNumber));
        elementBox.setOnMousePressed(event -> showPopupPage(atomicNumber));
        gridLayout.add(elementBox, column - 1, row - 1);
    }

    // Responsible for Showing the PopupPage
    private void showPopupPage(int atomicNumber) {
        PopupPage popupPage = new PopupPage(elementsInfo.getElement(atomicNumber));
        popupPage.createPage();
        StackPane.setMargin(popupPage, new Insets(50, 200, 50, 200));
        stackLayout.getChildren().add(popupPage);
    }

    // Responsible for Clearing the StackPane
    public void clearFront(MouseEvent event) {
        Node node = (Node) event.getTarget();
        ObservableList<Node> observableList = stackLayout.getChildren();

        int clickedLayer = observableList.indexOf(node);
        if (clickedLayer != -1) {
            stackLayout.getChildren().remove(clickedLayer + 1, observableList.size());
            return;
        }
        else if (event.getTarget().equals(stackLayout)) {
            stackLayout.getChildren().remove(1, observableList.size());
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (node instanceof ElementBox) return;
            node = node.getParent();
            if (observableList.contains(node)) {
                clickedLayer = observableList.indexOf(node);
                stackLayout.getChildren().remove(clickedLayer + 1, observableList.size());
                return;
            }
        }
    }

    // Prepares Menu Items
    private void prepareMenuItems() {
        // Prepares "Background Color Meanings"
        MenuItem colorMeanings = new MenuItem("Background Color Meanings");
        colorMeanings.setOnAction(actionEvent -> {
            ColorCodings colorCodings = new ColorCodings();
            colorCodings.createPage();
            GridPane.setMargin(colorCodings, new Insets(5, 35, 5, 35));
            gridLayout.add(colorCodings, 2, 1, 10, 1);
        });
        help.getItems().add(colorMeanings);

        // Prepares "Find/Search"
        MenuItem findSearch = new MenuItem("Find/Search");
        findSearch.setOnAction(actionEvent -> {
            SearchPage searchPage = new SearchPage();
            searchPage.createPage();
            StackPane.setMargin(searchPage, new Insets(200, 100, 200, 100));
            stackLayout.getChildren().add(searchPage);
        });
        options.getItems().add(findSearch);

        // Prepares Mini Quiz
        MenuItem miniQuizItem = new MenuItem("Mini Quiz");
        miniQuizItem.setOnAction(actionEvent -> {
            MiniQuiz miniQuiz = new MiniQuiz();
            miniQuiz.createPage();
            StackPane.setMargin(miniQuiz, new Insets(5, 5, 5, 5));
            stackLayout.getChildren().add(miniQuiz);
        });
        options.getItems().add(miniQuizItem);

        // Prepares Mass Calculator
        MenuItem massCalculator = new MenuItem("Mass Calculator");
        massCalculator.setOnAction(actionEvent -> {
            CompoundMassCalculator miniQuiz = new CompoundMassCalculator();
            miniQuiz.createPage();
            StackPane.setMargin(miniQuiz, new Insets(15, 15, 15, 15));
            stackLayout.getChildren().add(miniQuiz);
        });
        options.getItems().add(massCalculator);

        // Prepares Composition Calculator
        MenuItem compCalculator = new MenuItem("Composition Calculator");
        compCalculator.setOnAction(actionEvent -> {
            CompoundCompositionCalculator calculator = new CompoundCompositionCalculator();
            calculator.createPage();
            StackPane.setMargin(calculator, new Insets(15, 15, 15, 15));
            stackLayout.getChildren().add(calculator);
        });
        options.getItems().add(compCalculator);
    }

    // Initializer
    public void initialize() {
        // Adds Title on spaceInTop
        Label title = new Label("Welcome to Ira's Periodic Table");
        title.setFont(Font.font("Courier-New", FontWeight.BOLD, 36));
        title.setWrapText(true);
        gridLayout.add(title, 2, 1, 10, 1);

        prepareMenuItems();

        // Puts First Row
        addBlock(1, 1, 1);
        addBlock(2, 18, 1);

        // Puts Second Row
        addBlock(3, 1, 2);
        addBlock(4, 2, 2);
        for (int i = 0; i < 6; i++) {
            addBlock(5 + i, 13 + i, 2);
        }

        // Puts Third Row
        addBlock(11, 1, 3);
        addBlock(12, 2, 3);
        for (int i = 0; i < 6; i++) {
            addBlock(13 + i, 13 + i, 3);
        }

        // Puts 4th and 5th Row
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 18; j++) {
                addBlock(19 + j + (i * 18) , 1 + j, 4 + i);
            }
        }

        // Puts 6th Row
        addBlock(55, 1, 6);
        addBlock(56, 2, 6);
        for (int i = 0; i < 15; i ++) {
            addBlock(72 + i, 4 + i, 6);
        }

        // Puts 7th Row
        addBlock(87, 1, 7);
        addBlock(88, 2, 7);
        for (int i = 0; i < 15; i ++) {
            addBlock(104 + i, 4 + i, 7);
        }

        // Puts 8th Row
        for (int i = 0; i < 15; i ++) {
            addBlock(57 + i, 3 + i, 9);
        }

        // Puts 9th Row
        for (int i = 0; i < 15; i ++) {
            addBlock(89 + i, 3 + i, 10);
        }
    }
}