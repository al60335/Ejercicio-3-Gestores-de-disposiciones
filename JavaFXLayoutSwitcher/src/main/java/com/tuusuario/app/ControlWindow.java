package com.tuusuario.app;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ControlWindow {
    private Stage stage;
    private DisplayWindow displayWindow;

    public ControlWindow(Stage primaryWindow, DisplayWindow displayWindow) {
        this.stage = primaryWindow;
        this.displayWindow = displayWindow;
        
        stage.setTitle("Panel de Control");

        // Elementos de la interfaz
        Label instruccion = new Label("Selecciona un Gestor de Disposición:");
        ComboBox<String> selectorLayout = new ComboBox<>();
        
        // Opciones del ComboBox
        selectorLayout.getItems().addAll(
                "VBox (Vertical)",
                "HBox (Horizontal)",
                "FlowPane (Fluido)",
                "TilePane (Cuadrícula)",
                "StackPane (Apilado)"
        );
        selectorLayout.setValue("VBox (Vertical)"); // Valor por defecto

        // Evento: Qué pasa cuando cambia el valor del ComboBox
        selectorLayout.setOnAction(e -> {
            String seleccion = selectorLayout.getValue();
            displayWindow.cambiarLayout(seleccion);
        });

        // Contenedor de esta ventana
        VBox root = new VBox(15);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(instruccion, selectorLayout);

        Scene scene = new Scene(root, 300, 150);
        stage.setScene(scene);
        
        // Si cierras esta ventana, se cierra todo el programa
        stage.setOnCloseRequest(e -> System.exit(0));
    }

    public void show() {
        stage.show();
    }
}
