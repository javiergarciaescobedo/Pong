package es.javiergarciaescobedo.pong;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * JavaFX App
 */
public class App extends Application {

    int ballCenterX = 0;
    int ballCurrentSpeedX = 10;
    int ballDirectionX = 1;
    int ballCenterY = 0;
    int ballCurrentSpeedY = 10;
    int ballDirectionY = 1;
    
    @Override
    public void start(Stage stage) {
        
//        StackPane root = new StackPane();
        Pane root = new Pane();
        var scene = new Scene(root, 640, 480);
        scene.setFill(Color.BLACK);
        stage.setScene(scene);
        stage.show();
        
        // new Circle() => Crear un objeto de la clase Circle
        Circle circleBall = new Circle();
        // Llamando a métodos del objeto circleBall
        circleBall.setCenterX(10);
        circleBall.setCenterY(30);
        circleBall.setRadius(7);  
        circleBall.setFill(Color.WHITE);
        
        //Circle circleBall = new Circle(10, 30, 7);
        
        root.getChildren().add(circleBall);
        
        Timeline timeline = new Timeline(
            // 0.017 ~= 60 FPS
            new KeyFrame(Duration.seconds(0.017), new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae) {
                    circleBall.setCenterX(ballCenterX);
                    circleBall.setCenterY(ballCenterY);
                    ballCenterX += ballCurrentSpeedX * ballDirectionX;
                    ballCenterY += ballCurrentSpeedY * ballDirectionY;
                    // Control de rebote horizontal
                    if(ballCenterX >= 640) {
                        ballDirectionX = -1;
                    } else if(ballCenterX <= 0){
                        ballDirectionX = 1;
                    }
                    // Control de rebote vertical
                    if(ballCenterY >= 480) {
                        ballDirectionY = -1;
                    } else if(ballCenterY <= 0){
                        ballDirectionY = 1;
                    }
                }
            })                
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();      
    }

    public static void main(String[] args) {
        launch();
    }

}