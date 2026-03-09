package com.tuusuario.app;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // 1. Instanciamos la ventana donde se verán los cambios
        DisplayWindow ventanaVisualizacion = new DisplayWindow();
        
        // 2. Instanciamos la ventana de control pasándole la de visualización
        ControlWindow ventanaControl = new ControlWindow(primaryStage, ventanaVisualizacion);
        
        // 3. Mostramos ambas ventanas al mismo tiempo
        ventanaVisualizacion.show();
        ventanaControl.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
