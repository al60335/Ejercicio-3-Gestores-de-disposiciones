package com.tuusuario.app;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class DisplayWindow {
    private Stage stage;
    private List<Node> componentes;
    private Scene scene;

    public DisplayWindow() {
        stage = new Stage();
        stage.setTitle("Ventana de Visualización");
        
        // 1. Inicializamos los componentes de prueba que se van a re-acomodar
        componentes = new ArrayList<>();
        componentes.add(new Button("Botón 1"));
        componentes.add(new Label("Etiqueta de prueba"));
        componentes.add(new TextField("Texto editable"));
        componentes.add(new CheckBox("Opción 1"));
        componentes.add(new Button("Botón 2"));

        // Layout inicial por defecto
        VBox layoutInicial = new VBox(10);
        layoutInicial.setPadding(new Insets(15));
        layoutInicial.getChildren().addAll(componentes);

        scene = new Scene(layoutInicial, 400, 300);
        stage.setScene(scene);
    }

    public void show() {
        stage.show();
    }

    // 2. Método principal que intercambia el Layout
    public void cambiarLayout(String nombreLayout) {
        Pane nuevoContenedor;

        // Seleccionamos el gestor de disposición según el ComboBox
        switch (nombreLayout) {
            case "HBox (Horizontal)":
                nuevoContenedor = new HBox(10);
                break;
            case "VBox (Vertical)":
                nuevoContenedor = new VBox(10);
                break;
            case "FlowPane (Fluido)":
                nuevoContenedor = new FlowPane(10, 10);
                break;
            case "TilePane (Cuadrícula)":
                nuevoContenedor = new TilePane(10, 10);
                break;
            case "StackPane (Apilado)":
                nuevoContenedor = new StackPane();
                break;
            default:
                nuevoContenedor = new FlowPane();
                break;
        }

        nuevoContenedor.setPadding(new Insets(15));

        // 3. ¡El Trasplante! Añadimos la misma lista de nodos al nuevo contenedor
        nuevoContenedor.getChildren().addAll(componentes);

        // 4. Actualizamos la raíz de la escena
        scene.setRoot(nuevoContenedor);
    }
}
