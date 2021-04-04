import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SearchPage extends VBox implements StackPages {
    private final EmbeddedBrowser browser = new EmbeddedBrowser();
    private final ElementsInfo elementsInfo = new ElementsInfo();
    private final TextField searchBar = new TextField();
    private final ComboBox<String> filter = new ComboBox<>();
    private VBox searchResults;
    private String itemToSearch;

    public Pane getParentLayout() {
        return (Pane) this.getParent();
    }

    public SearchPage() {
        this.setAlignment(Pos.CENTER);
        this.setSpacing(30);
        this.setStyle("-fx-border-color: black; -fx-border-width: 3; -fx-background-color: lightslategrey");
        this.setPadding(new Insets(0, 20, 0, 20));
        this.setFillWidth(false);
    }

    private void showBrowser(String string) {
        this.getParentLayout().getChildren().add(browser.getEmbeddedBrowser(string));
    }

    private void searchDatabase() {
        searchResults = new VBox();
        searchResults.setAlignment(Pos.CENTER);
        searchResults.setPadding(new Insets(20, 20, 20, 20));
        searchResults.setSpacing(10);
        Label resultsHeader = new Label("Search Results (Items are Clickable)");
        resultsHeader.setFont(Font.font("Courier-New", 36));
        VBox.setMargin(resultsHeader, new Insets(0, 0, 20, 0));
        searchResults.getChildren().add(resultsHeader);
        itemToSearch = searchBar.getText().toLowerCase().replaceAll("\\s+", "");

        String filterChoice = filter.getSelectionModel().getSelectedItem().trim();
        if (filterChoice.equalsIgnoreCase(SearchFilter.ALL.toString())) {
            searchAtomicNumber();
            searchSymbol();
            searchName();
            searchAtomicWeight();
            searchDescription();
        }
        else if (filterChoice.equalsIgnoreCase(SearchFilter.ATOMIC_NUMBER.toString())) searchAtomicNumber();
        else if (filterChoice.equalsIgnoreCase(SearchFilter.SYMBOL.toString())) searchSymbol();
        else if (filterChoice.equalsIgnoreCase(SearchFilter.NAME.toString())) searchName();
        else if (filterChoice.equalsIgnoreCase(SearchFilter.ATOMIC_WEIGHT.toString())) searchAtomicWeight();
        else if (filterChoice.equalsIgnoreCase(SearchFilter.DESCRIPTION.toString())) searchDescription();

        ScrollPane searchResultsPage = new ScrollPane();
        searchResultsPage.setFitToWidth(true);
        if (searchResults.getChildren().size() == 1) {
            searchResults.getChildren().clear();
            Label noResults = new Label("No Results Were Found (Press Me to Search the Web)");
            noResults.setOnMousePressed(event -> showBrowser(itemToSearch));
            noResults.setOnMouseEntered(event -> noResults.setStyle("-fx-text-fill: royalblue"));
            noResults.setOnMouseExited(event -> noResults.setStyle(""));
            noResults.setFont(Font.font("Courier-New", 36));
            searchResults.getChildren().add(noResults);
            searchResultsPage.setFitToHeight(true);
        }
        searchResultsPage.setContent(searchResults);
        StackPane.setMargin(searchResultsPage, new Insets(100, 150, 100, 150));
        this.getParentLayout().getChildren().add(searchResultsPage);
    }

    private void pageRedirect(SearchFilter searchFilter, int atomicNumber) {
        Label label = new Label(searchFilter.toString() + " of " + elementsInfo.getName(atomicNumber));
        label.setOnMousePressed(event -> {
            PopupPage popupPage = new PopupPage(elementsInfo.getElement(atomicNumber));
            popupPage.createPage();
            StackPane.setMargin(popupPage, new Insets(50, 200, 50, 200));
            this.getParentLayout().getChildren().add(popupPage);
        });
        label.setOnMouseEntered(event -> label.setStyle("-fx-text-fill: royalblue"));
        label.setOnMouseExited(event -> label.setStyle(""));
        label.setFont(Font.font("Courier-New", 24));
        searchResults.getChildren().add(label);
    }

    private void searchDescription() {
        for (int i = 1; i <= elementsInfo.getElementsCount(); i++) {
            if (elementsInfo.getDescription(i).toLowerCase().replaceAll("\\s+", "").contains(itemToSearch)) {
                pageRedirect(SearchFilter.DESCRIPTION, i);
            }
        }
    }

    private void searchAtomicWeight() {
        for (int i = 1; i <= elementsInfo.getElementsCount(); i++) {
            if (Double.toString(elementsInfo.getAtomicWeight(i)).contains(itemToSearch)) {
                pageRedirect(SearchFilter.ATOMIC_WEIGHT, i);
            }
        }
    }

    private void searchName() {
        for (int i = 1; i <= elementsInfo.getElementsCount(); i++) {
            if (elementsInfo.getName(i).toLowerCase().contains(itemToSearch)) {
                pageRedirect(SearchFilter.NAME, i);
            }
        }
    }

    private void searchSymbol() {
        for (int i = 1; i <= elementsInfo.getElementsCount(); i++) {
            if (elementsInfo.getSymbol(i).equalsIgnoreCase(itemToSearch)) {
                pageRedirect(SearchFilter.SYMBOL, i);
            }
        }
    }

    private void searchAtomicNumber() {
        for (int i = 1; i <= elementsInfo.getElementsCount(); i++) {
            if (Integer.toString(i).equalsIgnoreCase(itemToSearch)) {
                pageRedirect(SearchFilter.ATOMIC_NUMBER, i);
            }
        }
    }

    @Override
    public void createPage() {
        // Creates Search Bar and Filter
        HBox barAndFilter = new HBox();
        barAndFilter.setAlignment(Pos.CENTER);
        barAndFilter.setSpacing(20);

        searchBar.setPromptText("Enter Keyword, Value, etc...");
        searchBar.setPrefWidth(200);
        searchBar.setOnKeyPressed(keyEvent -> { if (keyEvent.getCode() == KeyCode.ENTER) searchDatabase(); } );

        for (SearchFilter searchFilter : SearchFilter.values()) {
            filter.getItems().add(searchFilter.toString());
        }
        filter.getSelectionModel().select(0);

        barAndFilter.getChildren().addAll(searchBar, filter);
        this.getChildren().addAll(barAndFilter);

        // Add Search Button
        Button searchButton = new Button("Search Through App's Data");
        searchButton.setFont(Font.font("Courier-New", FontWeight.BOLD, 24));
        searchButton.setOnMouseClicked(event -> searchDatabase());
        this.getChildren().add(searchButton);
    }
}