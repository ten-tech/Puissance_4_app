import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Puissance4App extends Application {

    private static final int ROWS = 6;
    private static final int COLUMNS = 7;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Puissance 4");

        GridPane grid = createGameGrid();

        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private GridPane createGameGrid() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(10);
        grid.setHgap(10);

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                Button button = createGridButton(row, col);
                grid.add(button, col, row);
            }
        }

        return grid;
    }

    private Button createGridButton(int row, int col) {
        Button button = new Button();
        // Configurez le style et la taille des boutons selon vos besoins
        button.setMinSize(50, 50);
        button.setOnAction(e -> handleButtonClick(row, col));
        return button;
    }

    private void handleButtonClick(int row, int col) {
        System.out.println("Button clicked at row: " + row + ", col: " + col);
        // Ajoutez ici la logique pour gérer le clic sur un bouton de la grille
    }
}
