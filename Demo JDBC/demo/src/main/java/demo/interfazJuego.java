package demo; 

import java.io.FileInputStream;
import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class interfazJuego extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // Configuración de los botones
        Button superviviente = new Button("Superviviente");
        Button asesino = new Button("Asesino");
        Button salir = new Button("Salir");

        // estilo de los botones
        String buttonStyle = "-fx-text-fill: white; " +
                             "-fx-font-size: 35px; " +  
                             "-fx-font-family: 'Arial Black'; " +   
                             "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 4, 0.5, 0, 1); " + 
                             "-fx-background-color: transparent;";  

        String hoverStyle = "-fx-text-fill: red; " + 
                            "-fx-font-size: 35px; " +
                            "-fx-font-family: 'Arial Black'; " +
                            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75), 4, 0.5, 0, 1); " +
                            "-fx-background-color: transparent;";

        superviviente.setStyle(buttonStyle);
        asesino.setStyle(buttonStyle);
        salir.setStyle(buttonStyle);

        // Añadir eventos de ratón para cambiar el estilo al pasar sobre los botones
        superviviente.setOnMouseEntered(e -> superviviente.setStyle(hoverStyle));
        superviviente.setOnMouseExited(e -> superviviente.setStyle(buttonStyle));

        asesino.setOnMouseEntered(e -> asesino.setStyle(hoverStyle));
        asesino.setOnMouseExited(e -> asesino.setStyle(buttonStyle));

        salir.setOnMouseEntered(e -> salir.setStyle(hoverStyle));
        salir.setOnMouseExited(e -> salir.setStyle(buttonStyle));

        // Cargar la imagen desde el archivo local
        Image backgroundImage = new Image(new FileInputStream("C:/Interfaces/java2DAM/Demo JDBC/demo/src/main/java/demo/dbd5.jpg"));

        // Crear el VBox para los botones y configurarlos verticalmente
        VBox buttonBox = new VBox(10); // 10px de separación entre botones
        buttonBox.setPadding(new Insets(20)); // Añadir un padding de 20px
        buttonBox.setAlignment(Pos.TOP_LEFT); // Alinear a la izquierda y arriba
        buttonBox.getChildren().addAll(superviviente, asesino, salir); // Añadir los botones al VBox

        // Crear un GridPane para agregar los elementos
        GridPane root = new GridPane();
        root.setPadding(new Insets(10));

        // Crear una escena y añadir el GridPane
        Scene scene = new Scene(root, 800, 600);

        // Establecer el fondo del GridPane
        setBackgroundImage(root, backgroundImage, scene.getWidth(), scene.getHeight());

        // Añadir los botones al GridPane
        root.add(buttonBox, 0, 0);

        // Listener para cambiar el fondo cuando cambie el tamaño de la ventana
        scene.widthProperty().addListener((obs, oldVal, newVal) -> {
            setBackgroundImage(root, backgroundImage, scene.getWidth(), scene.getHeight());
        });

        scene.heightProperty().addListener((obs, oldVal, newVal) -> {
            setBackgroundImage(root, backgroundImage, scene.getWidth(), scene.getHeight());
        });

        // Acción para salir
        salir.setOnAction(e -> {
            stage.close(); // Cerrar la aplicación
        });

        // Crear una nueva escena para cuando se elige "Superviviente"
        StackPane supervivienteLayout = new StackPane();
        VBox volverBox = new VBox();
        volverBox.setPadding(new Insets(10));  // Espacio alrededor del botón
        volverBox.setAlignment(Pos.TOP_LEFT);  // Alinear a la parte superior izquierda

        Button volver = new Button("Volver");
        volver.setStyle(buttonStyle);  // Aplicar el mismo estilo
        volver.setOnMouseEntered(e -> volver.setStyle(hoverStyle));
        volver.setOnMouseExited(e -> volver.setStyle(buttonStyle));

        // Volver a la escena principal
        volver.setOnAction(e -> {
            stage.setScene(scene);
            stage.setFullScreen(true); // Mantener pantalla completa al volver
        });

        volverBox.getChildren().add(volver); // Agregar el botón "Volver" al VBox
        supervivienteLayout.getChildren().add(volverBox); // Añadir el VBox al StackPane
        Scene scene2 = new Scene(supervivienteLayout, 800, 600);

        // Crear la escena del "Asesino"
        StackPane asesinoLayout = new StackPane();
        VBox volverBox2 = new VBox();
        volverBox2.setPadding(new Insets(10));
        volverBox2.setAlignment(Pos.TOP_LEFT);

        Button volver2 = new Button("Volver");
        volver2.setStyle(buttonStyle);
        volver2.setOnMouseEntered(e -> volver2.setStyle(hoverStyle));
        volver2.setOnMouseExited(e -> volver2.setStyle(buttonStyle));

        volver2.setOnAction(e -> {
            stage.setScene(scene);
            stage.setFullScreen(true);
        });

        volverBox2.getChildren().add(volver2);
        asesinoLayout.getChildren().add(volverBox2);

        //imagen killer
        ImageView killerImage = new ImageView(new Image(new FileInputStream("C:/Interfaces/java2DAM/Demo JDBC/demo/src/main/java/demo/killer.png")));
        killerImage.setFitHeight(150);  // Ajustar la altura de la imagen
        killerImage.setPreserveRatio(true);  // Mantener la proporción de la imagen
        killerImage.setTranslateY(200);  // Posicionar la imagen en la parte inferior

        asesinoLayout.getChildren().add(killerImage);

        Scene scene3 = new Scene(asesinoLayout, 800, 600);

        // Listener para controlar el movimiento con las flechas
        scene3.setOnKeyPressed((KeyEvent e) -> {
            switch (e.getCode()) {
                case LEFT:
                    // Mover a la izquierda
                    killerImage.setTranslateX(killerImage.getTranslateX() - 10);
                    break;
                case RIGHT:
                    // Mover a la derecha
                    killerImage.setTranslateX(killerImage.getTranslateX() + 10);
                    break;
                default:
                    break;
            }
        });

        // Acción del botón "Asesino"
        asesino.setOnAction(e -> {
            stage.setScene(scene3);
            stage.setFullScreen(true);
            // Solicitar el foco para detectar eventos de teclado
            asesinoLayout.requestFocus();
        });

        // Acción del botón "Superviviente"
        superviviente.setOnAction(e -> {
            stage.setScene(scene2);
            stage.setFullScreen(true);
        });

        // Configuración de la ventana principal (Stage)
        stage.setTitle("Dead by Daylight");
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }

    // Imagen de fondo
    private void setBackgroundImage(GridPane root, Image backgroundImage, double width, double height) {
        BackgroundSize backgroundSize = new BackgroundSize(width, height, false, false, false, false);
        BackgroundImage bgImage = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                backgroundSize
        ); 
        root.setBackground(new Background(bgImage));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
