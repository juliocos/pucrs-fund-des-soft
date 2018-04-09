package Bar;

import Bar.Persistence.Customer;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Bar.Persistence.Bar;

public class Main extends Application {

    public static Bar bar;

    @Override
    public void start(Stage loginStage) throws Exception{
        bar = new Bar();

        Stage adminStage = new Stage();
        Parent rootAdmin = FXMLLoader.load(getClass().getResource("Interface/Admin.fxml"));
        adminStage.setTitle("Gerenciador do Bar");
        adminStage.setScene(new Scene(rootAdmin, 500, 455));
        adminStage.show();

        Parent rootLogin = FXMLLoader.load(getClass().getResource("Interface/Login.fxml"));
        loginStage.setTitle("Entrar no Bar");
        loginStage.setScene(new Scene(rootLogin, 400, 275));
        loginStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
