package visualization;

// imports from JavaFX to make a webview
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

// create an example webview to draw a visualization
public class dimpleChart extends Application {
  private Scene scene;
  private int width = 800;
  private int height = 400;

  @Override
  public void start(Stage stage) {
    // create the scene
    stage.setTitle("Dimple Chart Visualization");
    scene = new Scene(new Browser(), width, height, Color.web("#666970"));
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}

// browser class for the screen
class Browser extends Region {

  final WebView browser = new WebView();
  final WebEngine webEngine = browser.getEngine();

  public Browser() {

    // apply the styles
    getStyleClass().add("browser");

    // load the web page
    String path = System.getProperty("user.dir");
    path.replace("\\\\", "/");
    path += "/visualization/index.html";
    webEngine.load("file:///" + path);

    // add the web view to the scene
    getChildren().add(browser);

  }

  @Override
  protected void layoutChildren() {
    double w = getWidth();
    double h = getHeight();
    layoutInArea(browser, 0, 0, w, h, 0, HPos.CENTER, VPos.CENTER);
  }
}
