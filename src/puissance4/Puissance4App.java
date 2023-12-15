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
        // Configurer le style et la taille des boutons selon vos besoins
        button.setMinSize(50, 50);
        button.setOnAction(e -> handleButtonClick(row, col));
        return button;
    }

    private void handleButtonClick(int row, int col) {
        System.out.println("Button clicked at row: " + row + ", col: " + col);

        // Ajouter ici la logique pour gérer le clic sur un bouton de la grille

        // Pour les boutons
        Button clickedButton = gridButtons[row][col]; // Supposons que gridButtons est une matrice de boutons représentant la grille
        String currentPlayer = isRedTurn ? "Rouge" : "Jaune"; // Supposons une variable isRedTurn pour suivre le tour actuel

        if (isValidMove(row, col)) {
            // Vérifier si le mouvement est valide. Par exemple, si la colonne n'est pas pleine

            // Mettre à jour le bouton avec la couleur du joueur actuel
            clickedButton.setStyle("-fx-background-color: " + (isRedTurn ? "red" : "yellow"));

            // Mettre à jour la matrice de jeu. Par exemple, avec une valeur pour représenter le joueur actuel
            gameBoard[row][col] = isRedTurn ? "R" : "J";

            // Vérifiez s'il y a un gagnant
            if (checkForWinner(row, col)) {
                System.out.println(currentPlayer + " a gagné !");
                // Ajouter ici la logique pour traiter la fin du jeu
            } else {
                // Passer au tour suivant
                isRedTurn = !isRedTurn;
            }
        } else {
            System.out.println("Mouvement invalide. La colonne est pleine.");
            /* Ajouter ici la logique pour traiter un mouvement invalide.
            Par exemple, affichez un message à l'utilisateur ou désactivez le bouton */
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Mouvement invalide");
            alert.setHeaderText(null);
            alert.setContentText("La colonne est pleine. Choisissez une autre colonne.");
            alert.showAndWait();
        }
    }

}
