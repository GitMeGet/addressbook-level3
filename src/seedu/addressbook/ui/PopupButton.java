package seedu.addressbook.ui;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class PopupButton extends Application {

    Label label;
    Button yesButton, noButton;

    @Override
    public void start(Stage primaryStage) {
        try {
            GridPane root = new GridPane();

            label = new Label();
            label.setPrefSize(250, 50);
            label.setText("Do you wish to exit the program?");
            yesButton = new Button("Yes");
            noButton = new Button("No");

            root.add(label, 0, 0, 3, 1);
            root.add(yesButton, 0, 1);
            root.add(noButton, 2, 1);

            Scene scene = new Scene(root, 250, 100);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // overrides e.handle() with btn_click()
        yesButton.setOnAction(e -> btn_click(e));
        noButton.setOnAction(e -> btn_click(e));
    }

    private void btn_click(javafx.event.ActionEvent e) {
        if (e.getSource().equals(yesButton))
            MainWindow.callbackIfExit();
        else
            MainWindow.callbackIfNoExit();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
