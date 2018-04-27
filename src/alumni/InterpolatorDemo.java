
package alumni;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class InterpolatorDemo extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();

        Animation linear = createAnimation(root, 100.0, Interpolator.SPLINE(0.0, 0.0, 0.2, 1));
        Animation easein = createAnimation(root, 200.0, Interpolator.SPLINE(0.4, 0.0, 0.2, 1));
        Animation easeout = createAnimation(root, 300.0, Interpolator.SPLINE(0,.49,.15,.99));
        Animation easeboth = createAnimation(root, 400.0, Interpolator.EASE_BOTH);
        
        Animation discrete = createAnimation(root, 500.0, Interpolator.DISCRETE);

        Button button = new Button("Start");
        root.getChildren().add(button);
        button.setTranslateX(20.0);
        button.setTranslateY(20.0);
        button.setOnAction(e -> {
            if (linear.getStatus() == Animation.Status.RUNNING) {
                linear.stop();
                easein.stop();
                easeout.stop();
                easeboth.stop();
                discrete.stop();
                button.setText("Start");
            } else {
                linear.play();
                easein.play();
                easeout.play();
                easeboth.play();
                discrete.play();
                button.setText("Stop");
            }
        });
        linear.setOnFinished(e -> button.setText("Start"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setWidth(1_000);
        stage.setHeight(650);
        stage.show();
    }

    private Animation createAnimation(Group pane, double initY, Interpolator interpolator) {
        ImageView duke = new ImageView(new Image(getClass().getResourceAsStream("res/pic1.jpg")));
        duke.setFitWidth(22); duke.setFitHeight(22);
        pane.getChildren().add(duke);
        duke.setTranslateX(20.0);
        duke.setTranslateY(initY);

        Label label = new Label(interpolator.toString());
        pane.getChildren().add(label);
        label.setTranslateX(20.0);
        label.setTranslateY(initY + 80.0);
        
        TranslateTransition animation = new TranslateTransition(Duration.millis(2_000), duke);
        animation.setFromX(20.0);
        animation.setToX(890.0);
        animation.setInterpolator(interpolator);
        
        return animation;
    }
    
    public static void main(String... args) {
        launch(args);
    }
}
