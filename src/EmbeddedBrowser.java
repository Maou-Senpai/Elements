import Elements.Element;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class EmbeddedBrowser extends VBox {
    private final WebEngine engine;

    public EmbeddedBrowser() {
        final WebView browser = new WebView();
        VBox.setVgrow(browser, Priority.SOMETIMES);
        engine = browser.getEngine();
        engine.setJavaScriptEnabled(true);

        MenuBar menuBar = new MenuBar();

        Menu navigate = new Menu("Navigate");
        menuBar.getMenus().add(navigate);

        MenuItem back = new MenuItem("Back");
        back.setOnAction(e -> { if (engine.getHistory().getCurrentIndex() > 0) engine.getHistory().go(-1); });
        MenuItem forward = new MenuItem("Forward");
        forward.setOnAction(e -> {
            if (engine.getHistory().getCurrentIndex() < engine.getHistory().getEntries().size() - 1) {
                engine.getHistory().go(1);
            }
        });
        MenuItem refresh = new MenuItem("Refresh");
        refresh.setOnAction(e -> engine.reload());
        MenuItem close = new MenuItem("Close");
        close.setOnAction(e -> {
            ObservableList<Node> observableList = ((Pane) this.getParent()).getChildren();
            observableList.remove(this);
        });
        navigate.getItems().addAll(back, forward, refresh, close);

        this.getChildren().add(menuBar);
        this.getChildren().add(browser);
    }

    public VBox getEmbeddedBrowser(Element element) {
        engine.load("http://www.google.com/search?q=" + element.getName() + "+element");
        return this;
    }

    public VBox getEmbeddedBrowser(String searchString) {
        engine.load("http://www.google.com/search?q=periodic+table+" + searchString);
        return this;
    }
}