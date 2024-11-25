import java.io.FileInputStream;
import Menus.StartMenu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args) throws Exception {
        launch(args);
    }
    @Override
    public void start(Stage PrimaryStage) throws Exception {
        
        Scene mainMenu = StartMenu.mainMenuConst();
        PrimaryStage.setTitle("Swarm Keeper");
        PrimaryStage.setScene(mainMenu);
        
        try {
            PrimaryStage.getIcons().add(new Image(new FileInputStream("src\\Images\\Icon.png")));
        } catch (Exception e) {
            System.out.println("Warning: Program Icon Missing");
        }

        PrimaryStage.show();
        
    }
}
