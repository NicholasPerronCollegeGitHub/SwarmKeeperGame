import Menus.StartMenu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args) throws Exception {
        launch(args);
    }
    @Override
    public void start(Stage PrimaryStage) throws Exception {
        
        Scene mainMenu = StartMenu.mainMenuConst();
        PrimaryStage.setScene(mainMenu);
        PrimaryStage.show();
        
    }
}
