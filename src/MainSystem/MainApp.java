package MainSystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(final Stage stage) throws Exception {
        TabPane root = FXMLLoader.load(getClass().getResource("./MainPage.fxml"));
        stage.setScene(new Scene(root, 600, 400));
        stage.setTitle("Monster INC Hub");
        stage.show();
    }
}