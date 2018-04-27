/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumni;

import com.jfoenix.effects.JFXDepthManager;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;


public class AboutUsController implements Initializable {

    @FXML
    private Separator midSeperator;
    
    @FXML
    private Circle aboutCircle1, aboutCircle2, aboutCircle3, aboutCircle4, aboutCircle5;

    @FXML
    private Rectangle aboutRect1, aboutRect2;

    @FXML
    private TextFlow TextInchange1, TextInchange2;


    @FXML
    private TextFlow TextTeam1, TextTeam2, TextTeam3, TextTeam4, TextTeam5;
    
    @FXML
    private Label title;
    
    private void animateThings(){
    /***Level 1*************/
        
        TranslateTransition t1 = new TranslateTransition(Duration.millis(1000), title);
        t1.setFromY(50);
        t1.setByY(-50);
        t1.setAutoReverse(false);
        t1.setInterpolator(Interpolator.SPLINE(0.0, 0.0, 0.2, 1));
        
        FadeTransition ft1 = new FadeTransition(Duration.millis(1000), title);
        ft1.setFromValue(0.0);
        ft1.setToValue(1.0);
        ft1.setAutoReverse(false);
        ft1.setInterpolator(Interpolator.SPLINE(0.0, 0.0, 0.2, 1));
        
        ParallelTransition pt1 = new ParallelTransition(t1, ft1);
        
    /***Level 2*************/    
        
        TranslateTransition t2 = new TranslateTransition(Duration.millis(1000), aboutRect1);
        t2.setFromY(50);
        t2.setByY(-50);
        t2.setAutoReverse(false);
        t2.setInterpolator(Interpolator.SPLINE(0.0, 0.0, 0.2, 1));
        
        TranslateTransition t3 = new TranslateTransition(Duration.millis(1000), aboutRect2);
        t3.setFromY(50);
        t3.setByY(-50);
        t3.setAutoReverse(false);
        t3.setInterpolator(Interpolator.SPLINE(0.0, 0.0, 0.2, 1));
        
        FadeTransition ft2 = new FadeTransition(Duration.millis(1000), aboutRect1);
        ft2.setFromValue(0.0);
        ft2.setToValue(1.0);
        ft2.setAutoReverse(false);
        ft2.setInterpolator(Interpolator.SPLINE(0.0, 0.0, 0.2, 1));
        
        FadeTransition ft3 = new FadeTransition(Duration.millis(1000), aboutRect2);
        ft3.setFromValue(0.0);
        ft3.setToValue(1.0);
        ft3.setAutoReverse(false);
        ft3.setInterpolator(Interpolator.SPLINE(0.0, 0.0, 0.2, 1));
        
        //ParallelTransition pt2 = new ParallelTransition(t2, ft2, t3, ft3);
        
    /***Level 2.5*************/
    
        TranslateTransition t4 = new TranslateTransition(Duration.millis(1000), TextInchange1);
        t4.setFromY(80);
        t4.setByY(-80);
        t4.setAutoReverse(false);
        t4.setInterpolator(Interpolator.SPLINE(0.0, 0.0, 0.2, 1));
        
        TranslateTransition t5 = new TranslateTransition(Duration.millis(1000), TextInchange2);
        t5.setFromY(80);
        t5.setByY(-80);
        t5.setAutoReverse(false);
        t5.setInterpolator(Interpolator.SPLINE(0.0, 0.0, 0.2, 1));
        
        FadeTransition ft4 = new FadeTransition(Duration.millis(1500), TextInchange1);
        ft4.setFromValue(0.0);
        ft4.setToValue(1.0);
        ft4.setAutoReverse(false);
        ft4.setInterpolator(Interpolator.SPLINE(0.0, 0.0, 0.2, 1));
        
        FadeTransition ft5 = new FadeTransition(Duration.millis(1500), TextInchange2);
        ft5.setFromValue(0.0);
        ft5.setToValue(1.0);
        ft5.setAutoReverse(false);
        ft5.setInterpolator(Interpolator.SPLINE(0.0, 0.0, 0.2, 1));
        
        ParallelTransition pt2 = new ParallelTransition(t2,t3, ft2, ft3, t4, ft4, t5, ft5);
        
    /***Level 3*************/    
        TranslateTransition t6 = new TranslateTransition(Duration.millis(1200), aboutCircle1);
        t6.setFromY(35);
        t6.setByY(-35);
        t6.setAutoReverse(false);
        t6.setInterpolator(Interpolator.SPLINE(0.0, 0.0, 0.2, 1));
        
        TranslateTransition t7 = new TranslateTransition(Duration.millis(1200), aboutCircle2);
        t7.setFromY(35);
        t7.setByY(-35);
        t7.setAutoReverse(false);
        t7.setInterpolator(Interpolator.SPLINE(0.0, 0.0, 0.2, 1));
        
        TranslateTransition t8 = new TranslateTransition(Duration.millis(1200), aboutCircle3);
        t8.setFromY(35);
        t8.setByY(-35);
        t8.setAutoReverse(false);
        t8.setInterpolator(Interpolator.SPLINE(0.0, 0.0, 0.2, 1));
        
        TranslateTransition t9 = new TranslateTransition(Duration.millis(1200), aboutCircle4);
        t9.setFromY(35);
        t9.setByY(-35);
        t9.setAutoReverse(false);
        t9.setInterpolator(Interpolator.SPLINE(0.0, 0.0, 0.2, 1));
        
        TranslateTransition t10 = new TranslateTransition(Duration.millis(1200), aboutCircle5);
        t10.setFromY(35);
        t10.setByY(-35);
        t10.setAutoReverse(false);
        t10.setInterpolator(Interpolator.SPLINE(0.0, 0.0, 0.2, 1));
    
        FadeTransition ft6 = new FadeTransition(Duration.millis(1200), aboutCircle1);
        ft6.setFromValue(0.0);
        ft6.setToValue(1.0);
        ft6.setAutoReverse(false);
        ft6.setInterpolator(Interpolator.SPLINE(0.0, 0.0, 0.2, 1));
        
        FadeTransition ft7 = new FadeTransition(Duration.millis(1200), aboutCircle2);
        ft7.setFromValue(0.0);
        ft7.setToValue(1.0);
        ft7.setAutoReverse(false);
        ft7.setInterpolator(Interpolator.SPLINE(0.0, 0.0, 0.2, 1));
        
        FadeTransition ft8 = new FadeTransition(Duration.millis(1200), aboutCircle3);
        ft8.setFromValue(0.0);
        ft8.setToValue(1.0);
        ft8.setAutoReverse(false);
        ft8.setInterpolator(Interpolator.SPLINE(0.0, 0.0, 0.2, 1));
        
        FadeTransition ft9 = new FadeTransition(Duration.millis(1200), aboutCircle4);
        ft9.setFromValue(0.0);
        ft9.setToValue(1.0);
        ft9.setAutoReverse(false);
        ft9.setInterpolator(Interpolator.SPLINE(0.0, 0.0, 0.2, 1));
        
        FadeTransition ft10 = new FadeTransition(Duration.millis(1200), aboutCircle5);
        ft10.setFromValue(0.0);
        ft10.setToValue(1.0);
        ft10.setAutoReverse(false);
        ft10.setInterpolator(Interpolator.SPLINE(0.0, 0.0, 0.2, 1));
        
    /***Level 3.5*************/    
        TranslateTransition t11 = new TranslateTransition(Duration.millis(1200), TextTeam1);
        t11.setFromY(65);
        t11.setByY(-65);
        t11.setAutoReverse(false);
        t11.setInterpolator(Interpolator.SPLINE(0.0, 0.0, 0.2, 1));
        
        TranslateTransition t12 = new TranslateTransition(Duration.millis(1200), TextTeam2);
        t12.setFromY(65);
        t12.setByY(-65);
        t12.setAutoReverse(false);
        t12.setInterpolator(Interpolator.SPLINE(0.0, 0.0, 0.2, 1));
        
        TranslateTransition t13 = new TranslateTransition(Duration.millis(1200), TextTeam3);
        t13.setFromY(65);
        t13.setByY(-65);
        t13.setAutoReverse(false);
        t13.setInterpolator(Interpolator.SPLINE(0.0, 0.0, 0.2, 1));
        
        TranslateTransition t14 = new TranslateTransition(Duration.millis(1200), TextTeam4);
        t14.setFromY(65);
        t14.setByY(-65);
        t14.setInterpolator(Interpolator.SPLINE(0.0, 0.0, 0.2, 1));
        
        TranslateTransition t15 = new TranslateTransition(Duration.millis(1200), TextTeam5);
        t15.setFromY(65);
        t15.setByY(-65);
        t15.setAutoReverse(false);
        t15.setInterpolator(Interpolator.SPLINE(0.0, 0.0, 0.2, 1));
    
        FadeTransition ft11 = new FadeTransition(Duration.millis(1200), TextTeam1);
        ft11.setFromValue(0.0);
        ft11.setToValue(1.0);
        ft11.setInterpolator(Interpolator.SPLINE(0.0, 0.0, 0.2, 1));
        
        FadeTransition ft12 = new FadeTransition(Duration.millis(1200), TextTeam2);
        ft12.setFromValue(0.0);
        ft12.setToValue(1.0);
        ft12.setInterpolator(Interpolator.SPLINE(0.0, 0.0, 0.2, 1));
        
        FadeTransition ft13 = new FadeTransition(Duration.millis(1200), TextTeam3);
        ft13.setFromValue(0.0);
        ft13.setToValue(1.0);
        ft13.setInterpolator(Interpolator.SPLINE(0.0, 0.0, 0.2, 1));
        
        FadeTransition ft14 = new FadeTransition(Duration.millis(1200), TextTeam4);
        ft14.setFromValue(0.0);
        ft14.setToValue(1.0);
        ft14.setInterpolator(Interpolator.SPLINE(0.0, 0.0, 0.2, 1));
        
        FadeTransition ft15 = new FadeTransition(Duration.millis(1200), TextTeam5);
        ft15.setFromValue(0.0);
        ft15.setToValue(1.0);
        ft15.setInterpolator(Interpolator.SPLINE(0.0, 0.0, 0.2, 1));
    
        FadeTransition ftSeperator = new FadeTransition(Duration.millis(1200), midSeperator);
        ftSeperator.setFromValue(0.0);
        ftSeperator.setToValue(1.0);
        ftSeperator.setInterpolator(Interpolator.EASE_OUT);
        
        ParallelTransition pt3 = new ParallelTransition(ftSeperator, t6, ft6, t11, ft11);
        ParallelTransition pt4 = new ParallelTransition(t7, ft7, t12, ft12);
        ParallelTransition pt5 = new ParallelTransition(t8, ft8, t13, ft13);
        ParallelTransition pt6 = new ParallelTransition(t9, ft9, t14, ft14);
        ParallelTransition pt7 = new ParallelTransition(t10, ft10, t15, ft15);

        SequentialTransition sq = new SequentialTransition(pt3, new PauseTransition(Duration.millis(1)), pt4, pt5, pt6, pt7);
    /***Final SequentialTransition**********/    
        SequentialTransition seqT = new SequentialTransition (pt1, pt2, sq);
        seqT.play();
        
    }
    
    
    private void depthSettings(){
        JFXDepthManager depth = new JFXDepthManager();
        depth.setDepth(aboutRect1, 3);
        depth.setDepth(aboutRect2, 3);
        depth.setDepth(aboutCircle1, 3);
        depth.setDepth(aboutCircle2, 3);
        depth.setDepth(aboutCircle3, 3);
        depth.setDepth(aboutCircle4, 3);
        depth.setDepth(aboutCircle5, 3);
    }
    
/**
 * This method is used to set images to the respective components of the about us
 * page. It takes an Image, passes that Image to the ImagePattern class, calls
 * the setFill method of all the shapes and passes the ImagePattern class as a parameter. 
 */    
    private void setPhotos(){
        Image icon = new Image(getClass().getResourceAsStream("res/Sagar1.1.jpeg"));
        aboutCircle1.setFill(new ImagePattern(icon));
        
        icon = new Image(getClass().getResourceAsStream("res/Ankita1.jpeg"));
        aboutCircle2.setFill(new ImagePattern(icon));
        
        icon = new Image(getClass().getResourceAsStream("res/renuaNew.jpg"));
        aboutCircle3.setFill(new ImagePattern(icon));
        
        icon = new Image(getClass().getResourceAsStream("res/Ashutosh.jpeg"));
        aboutCircle4.setFill(new ImagePattern(icon));
        
        icon = new Image(getClass().getResourceAsStream("res/Shashank2.jpeg"));
        aboutCircle5.setFill(new ImagePattern(icon));
        
        icon = new Image(getClass().getResourceAsStream("res/PimpalkarSir.jpg"));
        aboutRect1.setFill(new ImagePattern(icon));
        
        icon = new Image(getClass().getResourceAsStream("res/CholeSir.jpg"));
        aboutRect2.setFill(new ImagePattern(icon));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        depthSettings();
        setPhotos();
        animateThings();
    }    
    
    public void onClickAboutUsBack(MouseEvent event){
        try {
            System.out.println("Pressed");
        } catch (Exception ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
