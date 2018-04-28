package alumni;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import com.jfoenix.controls.JFXToolbar;
import com.jfoenix.validation.*;
import com.jfoenix.effects.JFXDepthManager;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.animation.FillTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * This is the main FXML-controller class that initializes, controls and specifies
 * behavior of the elements in the FXMLDocument.fxml file.
 * @author Spongebob
 */
public class FXMLDocumentController implements Initializable {

/**********************************************************************MainFrame*******/
    
    @FXML
    private JFXTabPane mainTabpane, subTabPane;
    @FXML
    private Rectangle rect1, rect2, rect3, rect4;
    @FXML
    private Tab homeTab, recordsTab, personalTab, academicTab, professionalTab, contactTab;
    @FXML
    private JFXToolbar mainToolbar, closeToolbar;
    @FXML
    private JFXListView<HBox> recordsList;
    @FXML
    private AnchorPane rootPane, anc;
    @FXML
    private ScrollPane scrpane;
    @FXML
    private Label closelabel, overflowlabel, searchlabel, profilelabel, coverlabel, backlabel, aboutUs;
    @FXML
    private HBox toolbarHbox;
 
    @FXML
    private TextField batchFilter;
    @FXML
    private ChoiceBox<String> genderFilter, placedFilter, branchFilter;
    @FXML
    private JFXButton filterbtn;
    @FXML
    private Label removeFilter;
    
/*******************************************************************************Personal tab*******/
    
    @FXML
    private JFXTextField CustFileChooser, searchBar;
    @FXML
    private JFXTextField pFirstName, pLastName, pNation, pAddress, pCity, pState, pPincode;
    @FXML
    private JFXDatePicker pDob;
    @FXML
    private JFXRadioButton pGenderM, pGenderF;

/*******************************************************************************Academic tab*******/ 
    
    @FXML
    private JFXTextField aCollegeUG, aBatchUG, aGradeUG;
    @FXML 
    private ChoiceBox<String> aBranchUG, aCourseUG, aCoursePG, aBranchPG;
    @FXML
    private JFXTextField aCollegePG, aBatchPG, aGradePG;
    
    @FXML
    private JFXToggleButton courseToggle;
    
/*******************************************************************************Professional tab*******/
    
    @FXML
    private JFXListView<String> pList;
    @FXML
    private JFXTextField pCompany, pDesignation, pPackage, pLocation, pRemark;
    @FXML
    private JFXDatePicker pDOJ, pDOL;
    @FXML
    private JFXButton pAddBtn;
    @FXML
    private JFXToggleButton pPlaced;

    
/*******************************************************************************Contacts tab*******/
    
    @FXML
    private Label mobile, landline, instagram, email, facebook, linkedin;
    @FXML
    private JFXTextField cMobile, cLandline, cEmail, cFacebook, cLinkedin, cInstagram;
    
/*******************************************************************************Profile Details*******/
    @FXML
    private Label mobpro, emailpro, facebookpro, landpro, linkedinpro, instapro;
    @FXML
    private JFXButton btnEditBasic, btnEditEducation, btnEditContact, btnEditJob;
    @FXML
    private Label scrName, scrPassingU, scrAge, scrAddress, scrState, scrCity;
    @FXML
    private Label scrPincode, scrCollegeU, scrBranchU, scrBatchU, scrCollegeP;
    @FXML
    private Label scrBranchP, scrBatchP, scrPassingP, scrMobile, scrEmail, scrFacebook;
    @FXML
    private Label scrLandline, scrLinkedin, scrInstagram, scrPosition, scrCompanyName, scrCourseU, scrCourseP;
    @FXML
    private JFXListView<HBox> scrJobList;
    
/*******************************************************************************Global Variables**********/   
    
    private DataBase db;
    private ArrayList<AlumniModel> mod = new ArrayList<AlumniModel>();
    private ArrayList<AlumniModel> filteredList = new ArrayList<AlumniModel>();
    private ArrayList<JobModel> jobmod = new ArrayList<JobModel>();
    private AlumniModel insertMod = new AlumniModel();
    private AlumniModel EditModel = new AlumniModel();
    //private HashSet<Integer> deleteId = new HashSet<Integer>();
    private int deleteId =-1, errorFlag = -1;
    private String gender = "u";
    private int educationLevel = 0;         //UG =0 ; PG = 1;
    private boolean is_in_search_mode = false, isPlaced = true;
    
/*****************************************************************************/    
    
/**
 * Applies filters to the List and refreshes the ListView with filtered results.
 * @param event 
 */    
    public void handleFilterSet(ActionEvent event){
        if(is_in_search_mode){
            closeSearchBar();
            is_in_search_mode = false;
        }
        
        String gender=null, placed = null, branch = null;
        int batch=-1;
        
        if(genderFilter.getSelectionModel().getSelectedIndex()==0)
            gender = null;
        else if(genderFilter.getSelectionModel().getSelectedIndex()==1)
            gender = "m";
        else
            gender = "f";
        System.out.println("Gender: "+gender);
        
        
        if(branchFilter.getSelectionModel().getSelectedIndex()==0)
            branch = null;
        else
            branch = branchFilter.getSelectionModel().getSelectedItem();
        System.out.println("Branch: "+branch);
        
        
        if(placedFilter.getSelectionModel().getSelectedIndex()==0)
            placed = null;
        else if(placedFilter.getSelectionModel().getSelectedIndex()==1)
            placed = "Active";
        else
            placed = "Inactive";
        System.out.println("Placed: "+placed);
        
        
        if(batchFilter.getText().isEmpty())
            batch = -1;
        else
            batch = Integer.parseInt(batchFilter.getText());
        System.out.println("Batch: "+batch);
        
        
        
        if(batch<0){
            if(gender==null && branch==null && placed==null){
                populateListView();
            }else if(gender!=null && branch==null && placed==null){
                filteredList.clear();
                recordsList.getItems().clear();
        
                for(int i=0; i<mod.size(); i++){
                    if(mod.get(i).getGender().contains(gender))
                        filteredList.add(mod.get(i));
                }
        
                for(int i=0; i<filteredList.size(); i++){
                    recordsList.getItems().add(setCustomRow(filteredList.get(i)));
                }
            }else if(gender==null && branch!=null && placed==null){
                filteredList.clear();
                recordsList.getItems().clear();
        
                for(int i=0; i<mod.size(); i++){
                    if(mod.get(i).getBranchUG().contains(branch))
                        filteredList.add(mod.get(i));
                }
        
                for(int i=0; i<filteredList.size(); i++){
                    recordsList.getItems().add(setCustomRow(filteredList.get(i)));
                }
            }else if(gender==null && branch==null && placed!=null){
                filteredList.clear();
                recordsList.getItems().clear();
        
                for(int i=0; i<mod.size(); i++){
                    if(placed.equalsIgnoreCase("Active") && mod.get(i).getJobmod().get(i).getCompanyName()!=null)
                        filteredList.add(mod.get(i));
                    else if(placed.equalsIgnoreCase("Inactive") && mod.get(i).getJobmod().get(i).getCompanyName()==null)
                        filteredList.add(mod.get(i));
                }
        
                for(int i=0; i<filteredList.size(); i++){
                    recordsList.getItems().add(setCustomRow(filteredList.get(i)));
                }
            }else if(gender!=null && branch!=null && placed==null){
                filteredList.clear();
                recordsList.getItems().clear();
        
                for(int i=0; i<mod.size(); i++){
                    if((mod.get(i).getGender().contains(gender)) && (mod.get(i).getBranchUG().contains(branch)))
                        filteredList.add(mod.get(i));
                }
        
                for(int i=0; i<filteredList.size(); i++){
                    recordsList.getItems().add(setCustomRow(filteredList.get(i)));
                }
            }else if(gender!=null && branch==null && placed!=null){
                filteredList.clear();
                recordsList.getItems().clear();
        
                for(int i=0; i<mod.size(); i++){
                    if(mod.get(i).getGender().contains(gender)){
                        if(placed.equalsIgnoreCase("Active") && mod.get(i).getJobmod().get(i).getCompanyName()!=null)
                            filteredList.add(mod.get(i));
                        else if(placed.equalsIgnoreCase("Inactive") && mod.get(i).getJobmod().get(i).getCompanyName()==null)
                            filteredList.add(mod.get(i));
                    }
                }
        
                for(int i=0; i<filteredList.size(); i++){
                    recordsList.getItems().add(setCustomRow(filteredList.get(i)));
                }
            }else if(gender==null && branch!=null && placed!=null){
                filteredList.clear();
                recordsList.getItems().clear();
        
                for(int i=0; i<mod.size(); i++){
                    if(mod.get(i).getBranchUG().contains(branch)){
                        if(placed.equalsIgnoreCase("Active") && mod.get(i).getJobmod().get(i).getCompanyName()!=null)
                            filteredList.add(mod.get(i));
                        else if(placed.equalsIgnoreCase("Inactive") && mod.get(i).getJobmod().get(i).getCompanyName()==null)
                            filteredList.add(mod.get(i));
                    }
                }
            }else if(gender!=null && branch!=null && placed!=null){
                filteredList.clear();
                recordsList.getItems().clear();
        
                for(int i=0; i<mod.size(); i++){
                    if(mod.get(i).getBranchUG().contains(branch) && mod.get(i).getGender().contains(gender)){
                        if(placed.equalsIgnoreCase("Active") && mod.get(i).getJobmod().get(i).getCompanyName()!=null)
                            filteredList.add(mod.get(i));
                        else if(placed.equalsIgnoreCase("Inactive") && mod.get(i).getJobmod().get(i).getCompanyName()==null)
                            filteredList.add(mod.get(i));
                    }
                }
            }
        }else{
            if(batch<0 && gender==null && branch==null && placed==null){
                populateListView();
            }else if(batch>0 && gender==null && branch==null && placed==null){
                filteredList.clear();
                recordsList.getItems().clear();
        
                for(int i=0; i<mod.size(); i++){
                    if(mod.get(i).getBatchUG()==batch)
                        filteredList.add(mod.get(i));
                }
        
                for(int i=0; i<filteredList.size(); i++){
                    recordsList.getItems().add(setCustomRow(filteredList.get(i)));
                }
            }else if(batch>0 && gender!=null && branch==null && placed==null){
                filteredList.clear();
                recordsList.getItems().clear();
        
                for(int i=0; i<mod.size(); i++){
                    if(mod.get(i).getGender().contains(gender) && mod.get(i).getBatchUG()==batch)
                        filteredList.add(mod.get(i));
                }
        
                for(int i=0; i<filteredList.size(); i++){
                    recordsList.getItems().add(setCustomRow(filteredList.get(i)));
                }
            }else if(batch>0 && gender==null && branch!=null && placed==null){
                filteredList.clear();
                recordsList.getItems().clear();
        
                for(int i=0; i<mod.size(); i++){
                    if(mod.get(i).getBranchUG().contains(branch) && mod.get(i).getBatchUG()==batch)
                        filteredList.add(mod.get(i));
                }
        
                for(int i=0; i<filteredList.size(); i++){
                    recordsList.getItems().add(setCustomRow(filteredList.get(i)));
                }
            }else if(batch>0 && gender==null && branch==null && placed!=null){
                filteredList.clear();
                recordsList.getItems().clear();
        
                for(int i=0; i<mod.size(); i++){
                    if(placed.equalsIgnoreCase("Active") && mod.get(i).getJobmod().get(i).getCompanyName()!=null && mod.get(i).getBatchUG()==batch)
                        filteredList.add(mod.get(i));
                    else if(placed.equalsIgnoreCase("Inactive") && mod.get(i).getJobmod().get(i).getCompanyName()==null && mod.get(i).getBatchUG()==batch)
                        filteredList.add(mod.get(i));
                }
        
                for(int i=0; i<filteredList.size(); i++){
                    recordsList.getItems().add(setCustomRow(filteredList.get(i)));
                }
            }else if(batch>0 && gender!=null && branch!=null && placed==null){
                filteredList.clear();
                recordsList.getItems().clear();
        
                for(int i=0; i<mod.size(); i++){
                    if((mod.get(i).getGender().contains(gender)) && (mod.get(i).getBranchUG().contains(branch)) && mod.get(i).getBatchUG()==batch)
                        filteredList.add(mod.get(i));
                }
        
                for(int i=0; i<filteredList.size(); i++){
                    recordsList.getItems().add(setCustomRow(filteredList.get(i)));
                }
            }else if(batch>0 && gender!=null && branch==null && placed!=null){
                filteredList.clear();
                recordsList.getItems().clear();
        
                for(int i=0; i<mod.size(); i++){
                    if(mod.get(i).getGender().contains(gender) && mod.get(i).getBatchUG()==batch){
                        if(placed.equalsIgnoreCase("Active") && mod.get(i).getJobmod().get(i).getCompanyName()!=null)
                            filteredList.add(mod.get(i));
                        else if(placed.equalsIgnoreCase("Inactive") && mod.get(i).getJobmod().get(i).getCompanyName()==null)
                            filteredList.add(mod.get(i));
                    }
                }
        
                for(int i=0; i<filteredList.size(); i++){
                    recordsList.getItems().add(setCustomRow(filteredList.get(i)));
                }
            }else if(batch>0 && gender==null && branch!=null && placed!=null){
                filteredList.clear(); 
                recordsList.getItems().clear();
        
                for(int i=0; i<mod.size(); i++){
                    if(mod.get(i).getBranchUG().contains(branch) && mod.get(i).getBatchUG()==batch){
                        if(placed.equalsIgnoreCase("Active") && mod.get(i).getJobmod().get(i).getCompanyName()!=null)
                            filteredList.add(mod.get(i));
                        else if(placed.equalsIgnoreCase("Inactive") && mod.get(i).getJobmod().get(i).getCompanyName()==null)
                            filteredList.add(mod.get(i));
                    }
                }
            }else if(batch>0 && gender!=null && branch!=null && placed!=null){
                filteredList.clear();
                recordsList.getItems().clear();
        
                for(int i=0; i<mod.size(); i++){
                    if(mod.get(i).getBranchUG().contains(branch) && mod.get(i).getGender().contains(gender) && mod.get(i).getBatchUG()==batch){
                        if(placed.equalsIgnoreCase("Active") && mod.get(i).getJobmod().get(i).getCompanyName()!=null)
                            filteredList.add(mod.get(i));
                        else if(placed.equalsIgnoreCase("Inactive") && mod.get(i).getJobmod().get(i).getCompanyName()==null)
                            filteredList.add(mod.get(i));
                    }
                }
            }
        }
    }
    
    public void onClickAboutUs(MouseEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("about_us.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
            stage.show();
        } catch (Exception ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void animateTransition2(){
        KeyValue keyxStart1 = new KeyValue(profilelabel.translateYProperty(), 0, Interpolator.EASE_BOTH);
        KeyFrame keyFrameStart1  = new KeyFrame(Duration.ZERO, keyxStart1);
        
        KeyValue keyxFinal1 = new KeyValue(profilelabel.translateYProperty(), 230f, Interpolator.EASE_BOTH);
        KeyFrame keyFrameFinal1  = new KeyFrame(Duration.millis(375), keyxFinal1);
        
        Timeline timeline  = new Timeline();
        timeline.setCycleCount(1);
        timeline.setAutoReverse(true); 
        timeline.getKeyFrames().addAll(keyFrameStart1, keyFrameFinal1); 

        KeyValue keyxStart2 = new KeyValue(coverlabel.translateYProperty(), 0, Interpolator.EASE_BOTH);
        KeyFrame keyFrameStart2  = new KeyFrame(Duration.ZERO, keyxStart2);
        
        KeyValue keyxFinal2 = new KeyValue(coverlabel.translateYProperty(), 230f, Interpolator.EASE_BOTH);
        KeyFrame keyFrameFinal2  = new KeyFrame(Duration.millis(450), keyxFinal2);
        
        Timeline timeline2  = new Timeline();
        timeline2.setCycleCount(1);
        timeline2.setAutoReverse(true); 
        timeline2.getKeyFrames().addAll(keyFrameStart2, keyFrameFinal2); 
 
        ParallelTransition ptt = new ParallelTransition(timeline, timeline2);
        ptt.play();
    }
    
    public void configureMainTab(){
    /*****MainTabs**************/    
        VBox vcontent = new VBox();
        vcontent.setAlignment(Pos.CENTER);
        vcontent.setSpacing(5);
        
        Label label = new Label("Home");
        label.setAlignment(Pos.BOTTOM_CENTER);
        label.setTextFill(Color.web("#ffffff"));
        label.setFont(Font.font ("Arial", FontWeight.BOLD, 20));
        ImageView icon = new ImageView(new Image(getClass().getResourceAsStream("res/home.png")));
        //icon.setFitWidth(25); icon.setFitHeight(25);
        vcontent.getChildren().addAll(icon, label);
        homeTab.setGraphic(vcontent);
        
        
        VBox vcontent1 = new VBox();
        vcontent1.setAlignment(Pos.CENTER);
        vcontent1.setSpacing(5);
        label = new Label("Records"); 
        label.setAlignment(Pos.BOTTOM_CENTER);
        label.setTextFill(Color.web("#ffffff"));
        label.setFont(Font.font ("Arial", FontWeight.BOLD, 20));
        icon = new ImageView(new Image(getClass().getResourceAsStream("res/list_white.png")));
        //icon.setFitWidth(25); icon.setFitHeight(25);
        vcontent1.getChildren().addAll(icon, label);
        recordsTab.setGraphic(vcontent1);
        
    /*****SubTabs**************/     
        icon = new ImageView(new Image(getClass().getResourceAsStream("res/person_white.png")));
        icon.setFitWidth(22); icon.setFitHeight(22);
        personalTab.setGraphic(icon);
        
        icon = new ImageView(new Image(getClass().getResourceAsStream("res/school_white.png")));
        icon.setFitWidth(22); icon.setFitHeight(22);
        academicTab.setGraphic(icon);
        
        icon = new ImageView(new Image(getClass().getResourceAsStream("res/work_white.png")));
        icon.setFitWidth(21); icon.setFitHeight(21);
        professionalTab.setGraphic(icon);
        
        icon = new ImageView(new Image(getClass().getResourceAsStream("res/contacts_white.png")));
        icon.setFitWidth(21); icon.setFitHeight(21);
        contactTab.setGraphic(icon);
        
        
    /****ContactsTab**************/    
        icon = new ImageView(new Image(getClass().getResourceAsStream("res/call_black.png")));
        icon.setFitWidth(25); icon.setFitHeight(25);
        mobile.setGraphic(icon);
        
        icon = new ImageView(new Image(getClass().getResourceAsStream("res/telephone_black.png")));
        icon.setFitWidth(25); icon.setFitHeight(25);
        landline.setGraphic(icon);
        
        icon = new ImageView(new Image(getClass().getResourceAsStream("res/email_black.png")));
        icon.setFitWidth(25); icon.setFitHeight(25);
        email.setGraphic(icon);
        
        icon = new ImageView(new Image(getClass().getResourceAsStream("res/facebook.png")));
        icon.setFitWidth(22); icon.setFitHeight(22);
        facebook.setGraphic(icon);
        
        icon = new ImageView(new Image(getClass().getResourceAsStream("res/linkedin.png")));
        icon.setFitWidth(25); icon.setFitHeight(25);
        linkedin.setGraphic(icon);
        
        icon = new ImageView(new Image(getClass().getResourceAsStream("res/instagram_icon.png")));
        icon.setFitWidth(25); icon.setFitHeight(25);
        instagram.setGraphic(icon);
    
        
    /****Miscellaneous**************/     
        icon = new ImageView(new Image(getClass().getResourceAsStream("res/cover1.jpg")));
        icon.setFitWidth(865); icon.setFitHeight(180);
        coverlabel.setGraphic(icon);
        
        icon = new ImageView(new Image(getClass().getResourceAsStream("res/pic1.jpg")));
        icon.setFitWidth(145); icon.setFitHeight(155);
        profilelabel.setGraphic(icon);
        
        icon = new ImageView(new Image(getClass().getResourceAsStream("res/back.png")));
        icon.setFitWidth(50); icon.setFitHeight(35);
        backlabel.setGraphic(icon);
        
        aCourseUG.setItems(FXCollections.observableArrayList("Select Course", "BE"));
        aCourseUG.getSelectionModel().selectFirst();
        aBranchUG.setItems(FXCollections.observableArrayList("Select Branch"));
        aBranchUG.getSelectionModel().selectFirst();
        
        aCoursePG.setItems(FXCollections.observableArrayList("Select Course", "M.Tech"));
        aCoursePG.getSelectionModel().selectFirst();
        aBranchPG.setItems(FXCollections.observableArrayList("Select Branch"));
        aBranchPG.getSelectionModel().selectFirst();
        
    }
    
/**
 * Exits the application when the user clicks on the close button on the top right corner.
 */
    public void onCloseButtonClick(){
        System.exit(0);
    }
    
/**
 * Used to provide a depth or elevation effect to any node desired.
 * Currently it is used to provide depth to the 4 rectangles in the
 * sub tabs and the mainToolbar. Depth can be of the order of 0, 1,
 * 2, 3, or 4. A depth of 0 means no depth while an increment by 1
 * means more elevation than the previous value.
 * <p>
 * Class used to provide the depth effect is called JFXDepthManager
 * and is available in the JFoenix.effects. package. The setDepth
 * method is used to provide the required depth. The setDepth method
 * takes 2 arguments: 1st is the node to which depth is to be provided
 * while the 2nd is the amount of depth (from 0 to 4).
 *
 */  
    public void depthSettings(){
        JFXDepthManager depth = new JFXDepthManager();
        depth.setDepth(rect1, 1);
        depth.setDepth(rect2, 1);
        depth.setDepth(rect3, 1);
        depth.setDepth(rect4, 1);
        depth.setDepth(mainToolbar, 2);
        depth.setDepth(profilelabel, 3);
        depth.setDepth(coverlabel, 2);
    }
    
    public void configureToolbars(){
        ImageView icon = new ImageView(new Image(getClass().getResourceAsStream("res/close 2x.png")));
        icon.setFitWidth(23); icon.setFitHeight(23);
        closelabel.setGraphic(icon);
        
        toolbarHbox.setSpacing(10);

        icon = new ImageView(new Image(getClass().getResourceAsStream("res/delete_white.png")));
        icon.setFitWidth(20); icon.setFitHeight(20);
        overflowlabel.setGraphic(icon);
        
        icon = new ImageView(new Image(getClass().getResourceAsStream("res/search 2x.png")));
        icon.setFitWidth(23); icon.setFitHeight(23);
        searchlabel.setGraphic(icon);
        
    }
 
/**
  * Applies a ScaleTransition (along with TranslateTrasition to balance x-axis
  * movement) to the JFXTextField named searchBar. 
  * <p>
  * when the variable named is_in_search_mode equals true this method first sets 
  * the contents of the searchBar to null value and then closes it.
  */     
    public void closeSearchBar(){
        searchBar.setText(null);
        
        ScaleTransition sc = new ScaleTransition(Duration.millis(250), searchBar);
        sc.setByX(-1.0f);
        sc.setCycleCount(1);
        
        TranslateTransition ta = new TranslateTransition(Duration.millis(250), searchBar);
        ta.setByX(175);
        ta.setCycleCount(1);
        
        ParallelTransition pt = new ParallelTransition(sc, ta);
        pt.play();
    }
 
 /**
  * Applies a ScaleTransition (along with TranslateTrasition to balance x-axis
  * movement) to the JFXTextField named searchBar. 
  * <p>
  * This method opens it when the
  * variable named is_in_search_mode equals false.
  */   
    public void initSearchBar(){
        
        searchBar.requestFocus();
        
        ScaleTransition sc = new ScaleTransition(Duration.millis(250), searchBar);
        sc.setByX(1.0f);
        sc.setCycleCount(1);
        
        TranslateTransition ta = new TranslateTransition(Duration.millis(250), searchBar);
        ta.setByX(-175);
        ta.setCycleCount(1);
        
        ParallelTransition pt = new ParallelTransition(sc, ta);
        pt.play();
    }
    
    public void handleFileChooserBtn(MouseEvent event){
        CustFileChooser.setText(null);
        CustFileChooser.setEditable(false);
        
        File file;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        Stage stage = new Stage();
        file = fileChooser.showOpenDialog(stage);
        String fileName = null;
        if(file.getName().toString()!=null)
            fileName = file.getName();
        else
            fileName = null;
        
        if(fileName!=null && (fileName.contains("png") || fileName.contains("jpg") || fileName.contains("jpeg")))
            CustFileChooser.setText(file.getAbsolutePath());
        else{
            CustFileChooser.setText(null);
            Alert al = new Alert(Alert.AlertType.WARNING);
            al.setTitle("Invalid Image!");
            al.setContentText("Please choose a .jpg or .png file format only!");
            al.setHeaderText(null);
            al.show();
        }
        
    }
    
    public void configureProfileDetailsPage(){
        
    
    
    /********************Contacts Section*********/    
        ImageView icon = new ImageView(new Image(getClass().getResourceAsStream("res/call_black.png")));
        icon.setFitHeight(25);  icon.setFitWidth(22);
        mobpro.setGraphic(icon);
        
        icon = new ImageView(new Image(getClass().getResourceAsStream("res/email_black.png")));
        icon.setFitHeight(25); icon.setFitWidth(25);
        emailpro.setGraphic(icon);
        
        icon = new ImageView(new Image(getClass().getResourceAsStream("res/facebook.png")));
        icon.setFitHeight(22); icon.setFitWidth(22);
        facebookpro.setGraphic(icon);
        
        icon = new ImageView(new Image(getClass().getResourceAsStream("res/telephone_black.png")));
        icon.setFitHeight(25); icon.setFitWidth(25);
        landpro.setGraphic(icon);
        
        icon = new ImageView(new Image(getClass().getResourceAsStream("res/linkedin.png")));
        icon.setFitHeight(25); icon.setFitWidth(25);
        linkedinpro.setGraphic(icon);
        
        icon = new ImageView(new Image(getClass().getResourceAsStream("res/instagram_icon.png")));
        icon.setFitHeight(25); icon.setFitWidth(25);
        instapro.setGraphic(icon);
        
    /********************Edit Buttons*********/
        icon = new ImageView(new Image(getClass().getResourceAsStream("res/edit.png")));
        icon.setFitHeight(25); icon.setFitWidth(25);
        btnEditBasic.setGraphic(icon);
        
        icon = new ImageView(new Image(getClass().getResourceAsStream("res/edit.png")));
        icon.setFitHeight(25); icon.setFitWidth(25);
        btnEditContact.setGraphic(icon);
        
        icon = new ImageView(new Image(getClass().getResourceAsStream("res/edit.png")));
        icon.setFitHeight(25); icon.setFitWidth(25);
        btnEditJob.setGraphic(icon);
        
        icon = new ImageView(new Image(getClass().getResourceAsStream("res/edit.png")));
        icon.setFitHeight(25); icon.setFitWidth(25);
        btnEditEducation.setGraphic(icon);
    
    }
    
    public void onBasicEditClick(MouseEvent event){
        try {
            AlumniModel.setEditModel(EditModel);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BasicEdit.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setTitle("ERROR!");
            al.setContentText("Cannot open BasicEdit.fxml");
            al.setHeaderText(null);
            al.show();
        }
    }
    
    public void onContactEditClick(MouseEvent event){
        try{
            AlumniModel.setEditModel(EditModel);
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("ContactsEdit.fxml"));
            Parent root1 = (Parent) fxmlloader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        }catch(Exception ex){
            ex.printStackTrace();
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setTitle("Error");
            al.setContentText("Cannot open ContactsEdit.fxml");
            al.setHeaderText(null);
            al.show();
        }
    }
    
    public void onEducationEditClick(MouseEvent event){
        try{
            AlumniModel.setEditModel(EditModel);
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("EducationEdit.fxml"));
            Parent root1 = (Parent) fxmlloader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
        }catch(Exception ex){
            ex.printStackTrace();
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setTitle("Error");
            al.setContentText("Cannot open EducationEdit.fxml");
            al.setHeaderText(null);
            al.show();
        }
    }
    
    public void onProfessionEditClick(MouseEvent event){
        try {
            AlumniModel.setEditModel(EditModel);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("JobEditFxml.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setTitle("ERROR!");
            al.setContentText("Cannot open BasicEdit.fxml");
            al.setHeaderText(null);
            al.show();
        }
    }
    
/**
 * This method deletes an entry from the row that is selected using right click.
 * Using a HashSet<Integer> to store the id of the item to be deleted, 
 * @param event 
 */    
    public void deleteSelectedItem(MouseEvent event){
        if(deleteId==-1){
            System.out.println("Nothing to delete");
            JFXSnackbar bar = new JFXSnackbar(rootPane);
            bar.show("Nothing to delete!", 2500);
        }else{
            System.out.println("Deleted id: "+ deleteId);
            db.deleteRow(deleteId);
            populateListView();
            JFXSnackbar bar = new JFXSnackbar(rootPane);
            bar.show("Record deleted", 2500);
            deleteId=-1;
        }
    }
    
/**
 * This method is used to perform a sequence of animations to open up the ScrollPane
 * containing the details of a user. This method is called from the onListClicked()
 * method, which is the event handling method of the main ListView.
 */    
    public void animateTransition(){
        TranslateTransition t1 = new TranslateTransition(Duration.millis(900), mainTabpane);
        t1.setFromX(0);
        t1.setByX(-300f);
        t1.setAutoReverse(false);
 
        TranslateTransition ta = new TranslateTransition(Duration.millis(900), aboutUs);
        ta.setFromX(0);
        ta.setByX(-600f);
        ta.setAutoReverse(false);
        
        TranslateTransition t2 = new TranslateTransition(Duration.millis(600), anc);
        t2.setFromX(0);
        t2.setByX(1210f);
        t2.setAutoReverse(false);
            
        TranslateTransition t3 = new TranslateTransition(Duration.millis(900), mainToolbar);
        t3.setFromX(0);
        t3.setByY(-200f);
        t3.setAutoReverse(false);
            
        TranslateTransition t4 = new TranslateTransition(Duration.millis(900), closeToolbar);
        t4.setFromX(0);
        t4.setByY(-200f);
        t4.setAutoReverse(false);
            
        ParallelTransition pt = new ParallelTransition(t1, ta, t2, t3, t4);
        pt.play();
            
        TranslateTransition tt1 = new TranslateTransition(Duration.millis(800), profilelabel);  //375
        tt1.setFromX(0);
        tt1.setByY(230f);
        tt1.setAutoReverse(false);
        tt1.setInterpolator(Interpolator.SPLINE(0.0, 0.0, 0.2, 1));
            
        TranslateTransition tt2 = new TranslateTransition(Duration.millis(1250), coverlabel);    //450
        tt2.setFromX(0);
        tt2.setByY(230f);
        tt2.setAutoReverse(false);
        tt2.setInterpolator(Interpolator.SPLINE(0.0, 0.0, 0.2, 1));
            
        TranslateTransition tt3 = new TranslateTransition(Duration.millis(1250), backlabel);     //450
        tt3.setFromX(0);
        tt3.setByY(230f);
        tt3.setAutoReverse(false);
        tt3.setInterpolator(Interpolator.SPLINE(0.0, 0.0, 0.2, 1));
            
        TranslateTransition tt4 = new TranslateTransition(Duration.millis(1250), scrpane);       //450
        tt4.setFromX(0);
        tt4.setByY(-466f);
        tt4.setAutoReverse(false);
        
        ParallelTransition ptt = new ParallelTransition(tt1, tt2, tt3, tt4);
        ptt.setInterpolator(Interpolator.SPLINE(0.0, 0.0, 0.2, 1));
        ptt.play();
        
        //startOnScrollEffect();
    }

/**
 * This method is used to perform a sequence of animations to close up the ScrollPane
 * containing the details of a user. It performs exactly opposite transitions compared to
 * the animateTransition() method to close the Pane. This method is called from the onBackButtonClick()
 * method, which is the event handling method of the Back Button (which is a label) on the
 * ScrollPane.
 */      
    public void reverseTransition() {
        TranslateTransition t1 = new TranslateTransition(Duration.millis(900), mainTabpane);
        t1.setFromX(-300f);
        t1.setByX(300f);
        t1.setAutoReverse(false);
        t1.setInterpolator(Interpolator.SPLINE(0.0, 0.0, 0.2, 1));
 
        TranslateTransition ta = new TranslateTransition(Duration.millis(900), aboutUs);
        ta.setFromX(-600f);
        ta.setByX(600f);
        ta.setAutoReverse(false);
        ta.setInterpolator(Interpolator.SPLINE(0.0, 0.0, 0.2, 1));
        
        TranslateTransition t2 = new TranslateTransition(Duration.millis(900), anc);
        t2.setFromX(1210f);
        t2.setByX(-1210f);
        t2.setAutoReverse(false);
        t2.setInterpolator(Interpolator.SPLINE(0.0, 0.0, 0.2, 1));
            
        TranslateTransition t3 = new TranslateTransition(Duration.millis(900), mainToolbar);
        t3.setFromY(-200f);
        t3.setByY(200f);
        t3.setAutoReverse(false);
        t3.setInterpolator(Interpolator.SPLINE(0.0, 0.0, 0.2, 1));
            
        TranslateTransition t4 = new TranslateTransition(Duration.millis(900), closeToolbar);
        t4.setFromY(-200f);
        t4.setByY(200f);
        t4.setAutoReverse(false);
        t4.setInterpolator(Interpolator.SPLINE(0.0, 0.0, 0.2, 1));
            
        ParallelTransition pt = new ParallelTransition(t1, ta, t2, t3, t4);
        pt.setInterpolator(Interpolator.SPLINE(0.0, 0.0, 0.2, 1));
        pt.play();
        
        //animateTransition2();
        TranslateTransition tt1 = new TranslateTransition(Duration.millis(700), profilelabel);
        tt1.setFromY(230f);
        tt1.setByY(-230f);
        tt1.setAutoReverse(false);
            
        TranslateTransition tt2 = new TranslateTransition(Duration.millis(700), coverlabel);
        tt2.setFromY(230f);
        tt2.setByY(-230f);
        tt2.setAutoReverse(false);
            
        TranslateTransition tt3 = new TranslateTransition(Duration.millis(700), backlabel);
        tt3.setFromY(230f);
        tt3.setByY(-230f);
        tt3.setAutoReverse(false);
            
        TranslateTransition tt4 = new TranslateTransition(Duration.millis(700), scrpane);
        tt4.setFromY(-466f);
        tt4.setByY(466f);
        tt4.setAutoReverse(false);
        
        ParallelTransition ptt = new ParallelTransition(tt1, tt2, tt3, tt4);
        ptt.play();
    }
    
/**
 * This method calls the reverseTransition() method on clicking the back button in the 
 * profile details page i.e. the ScrollPane.
 */    
    public void onBackButtonClick(){
        reverseTransition();
    }
    
    public void setJobList(){
        pList.getItems().clear();
        for(int i=0; i<jobmod.size(); i++){
            pList.getItems().add(jobmod.get(i).getCompanyName());
        }
    }
    
    public HBox setProfessionDetailsRow(JobModel tempJobMod){
        
        Label companyName, designation, location, annualPackage, doj;
        companyName = new Label();
        designation = new Label();
        location = new Label();
        annualPackage = new Label();
        doj = new Label();
        
        HBox row = new HBox();

        System.out.println("CompanyName: " + tempJobMod.getCompanyName());
        companyName.setText(tempJobMod.getCompanyName());
        companyName.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        companyName.setAlignment(Pos.TOP_LEFT);
        companyName.setPrefWidth(190);
        companyName.setMinWidth(190);
        companyName.setMaxWidth(190);
        
        designation.setText(tempJobMod.getDesignation());
        designation.setFont(Font.font("Arial", FontWeight.NORMAL, 15));
        designation.setAlignment(Pos.TOP_LEFT);
        designation.setPrefWidth(100);
        designation.setMinWidth(100);
        designation.setMaxWidth(100);
        
        
        location.setText(tempJobMod.getLocation());
        location.setFont(Font.font("Arial", FontWeight.NORMAL, 15));
        location.setAlignment(Pos.TOP_LEFT);
        location.setPrefWidth(80);
        location.setMinWidth(80);
        location.setMaxWidth(80);
        
        if(tempJobMod.getAnnualPackage()>1)
            annualPackage.setText("Rs: " + String.valueOf(tempJobMod.getAnnualPackage()));
        else
            annualPackage.setText("");
        annualPackage.setFont(Font.font("Arial", FontWeight.NORMAL, 15));
        annualPackage.setAlignment(Pos.TOP_LEFT);
        annualPackage.setPrefWidth(110);
        annualPackage.setMinWidth(110);
        annualPackage.setMaxWidth(110);
        
        doj.setText(tempJobMod.getDoj());
        doj.setFont(Font.font("Arial", FontWeight.NORMAL, 15));
        doj.setAlignment(Pos.TOP_LEFT);
        doj.setPrefWidth(100);
        doj.setMinWidth(100);
        doj.setMaxWidth(100);
        
        
        row.setSpacing(25);
        row.setAlignment(Pos.CENTER_LEFT);
        row.setPadding(new Insets(0, 10, 0, 10));                               //new Insets(Top, Right, Bottom, Left)
        row.getChildren().addAll(companyName, designation, location, annualPackage, doj); 
        
        return row;
    }
    
    public void onAddButtonClick(ActionEvent event){
        //System.out.println("Added new item to job list!");
        if(isPlaced){
            if(pCompany.getText()!=null && pDesignation.getText()!=null && pDOJ.getValue()!=null && pPackage.getText()!=null){
                Date doj = new Date(pDOJ.getValue().toEpochDay());
                Date dol = new Date(pDOL.getValue().toEpochDay());
                
                if(doj.before(dol)){                                            //Comparing DOJ and DOL
                    jobmod.add(new JobModel(0,pCompany.getText(), pDesignation.getText(), pLocation.getText(),
                               pDOJ.getValue().toString(), pDOL.getValue().toString(), Double.valueOf(pPackage.getText())));
                    setJobList();
                }else{
                    Alert al = new Alert(Alert.AlertType.ERROR);
                    al.setTitle("Invalid date input!");
                    al.setContentText("Date of leaving can't be earlier than date of joining!");
                    al.setHeaderText(null);
                    al.show();
                }
            }else{
                Alert al = new Alert(Alert.AlertType.WARNING);
                al.setTitle("Incomplete fields!");
                al.setContentText("Please fill all details in professional tab or disable the fields!");
                al.setHeaderText(null);
                al.show();
            }
        }
    }
    
    public void setEducationLevel(ActionEvent event){
        if(courseToggle.isSelected()){
            aCollegeUG.setDisable(false); 
            aCourseUG.setDisable(false); 
            aBatchUG.setDisable(false); 
            aGradeUG.setDisable(false); 
            aBranchUG.setDisable(false);
            
            aCollegePG.setDisable(true);
            aCoursePG.setDisable(true);
            aBatchPG.setDisable(true);
            aGradePG.setDisable(true);
            aBranchPG.setDisable(true);

            aCollegePG.setText("");
            aCoursePG.getSelectionModel().selectFirst();
            aBranchPG.getSelectionModel().selectFirst();
            aBatchPG.setText("");
            aGradePG.setText("");
            
            educationLevel =0;
        }else{
            aCollegeUG.setDisable(true); 
            aCourseUG.setDisable(true); 
            aBatchUG.setDisable(true); 
            aGradeUG.setDisable(true); 
            aBranchUG.setDisable(true);
            
            aCollegePG.setDisable(false);
            aCoursePG.setDisable(false);
            aBatchPG.setDisable(false);
            aGradePG.setDisable(false);
            aBranchPG.setDisable(false);
            
            aCollegeUG.setText("");
            aCourseUG.getSelectionModel().selectFirst();
            aBranchUG.getSelectionModel().selectFirst();
            aBatchUG.setText("");
            aGradeUG.setText("");
            
            educationLevel = 1;
        }
        System.out.println("Education Level: " + educationLevel);
    }
    
/**
* This is the main method to validate and insert the data into the database. This
* method is the event handling method for the big main "save" button in the home tab.
* <p>
* It saves all the values from the TextViews into their respective member variables
* of the AlumniModel class. The AlumniModel class is referenced using a single object of 
* that class named insertMod. The getter methods of the class are used to input data into
* them.
* @param event 
*/
    public void handleMainSaveButton(ActionEvent event){
        System.out.println("SAVE ME!!!!");
        
    /***Personal**************************************************/
    
        insertMod.setFirstname(pFirstName.getText());
        insertMod.setLastname(pLastName.getText());
        insertMod.setPic(CustFileChooser.getText());
        //System.out.println(pDob.getValue());
        insertMod.setNationality(pNation.getText());
        insertMod.setAddress(pAddress.getText());
        insertMod.setCity(pCity.getText());
        insertMod.setState(pState.getText());
        if(gender!="u"){
            insertMod.setGender(gender);
        }
        if(pDob.getValue()!=null){
            insertMod.setDob(pDob.getValue().toString());
        }else{
            pDob.setValue(null);
            insertMod.setDob("");
        }
        if(pPincode.getText().length()>1)
            insertMod.setPincode(pPincode.getText());
        else{
            insertMod.setPincode("-1");
            pPincode.setText("");
        }
        
    /***Academic**************************************************/
    
        insertMod.setEducationLevel(educationLevel);
        insertMod.setCollegeNameUG(aCollegeUG.getText());
        insertMod.setCourseUG(aCourseUG.getSelectionModel().getSelectedItem());
        insertMod.setBranchUG(aBranchUG.getSelectionModel().getSelectedItem());
        insertMod.setPassUG(aGradeUG.getText());
        if(aBatchUG.getText().length()==4)
            insertMod.setBatchUG(Integer.parseInt(aBatchUG.getText()));
        else{
            aBatchUG.setText("");
            insertMod.setBatchUG(0);
        }
        
        
        insertMod.setCollegeNamePG(aCollegePG.getText());
        insertMod.setCoursePG(aCoursePG.getSelectionModel().getSelectedItem());
        insertMod.setBranchPG(aBranchPG.getSelectionModel().getSelectedItem());
        insertMod.setPassPG(aGradePG.getText());
        if(aBatchPG.getText().length()==4)
            insertMod.setBatchPG(Integer.parseInt(aBatchPG.getText()));
        else{
            aBatchPG.setText("");
            insertMod.setBatchPG(0);
        }
        
    /***Professional**************************************************/
        if(isPlaced)
            insertMod.setPlaced(1);
        else
            insertMod.setPlaced(0);
        
        if(isPlaced){
            if(jobmod.size()>0)
                insertMod.setJobmod(jobmod);    
            else{
                Alert al = new Alert(Alert.AlertType.WARNING);
                al.setTitle("Add professional Details!");
                al.setContentText("Add the entries by clicking on the add button first!");
                al.setHeaderText(null);
                al.show();
            }
        }
        //insertMod.setCompanyName(pCompany.getText());
        //insertMod.setDesignation(pDesignation.getText());

        //insertMod.setLocation(pLocation.getText());
        insertMod.setRemark(pRemark.getText()); 
        //if(pDOJ.getValue()!=null){
            //insertMod.setDoj(pDOJ.getValue().toString());
        //}else
            //insertMod.setDoj("");
        //if(isPlaced==true && !pPackage.getText().isEmpty())
            //insertMod.setAnnualPackage(Double.valueOf(pPackage.getText()));
        //else
            //insertMod.setAnnualPackage(0.0);
    /***Contacts**************************************************/
    
        insertMod.setMobile(cMobile.getText());
        insertMod.setLandline(cLandline.getText());
        insertMod.setEmail(cEmail.getText());
        insertMod.setLinkedin(cLinkedin.getText());
        insertMod.setFacebook(cFacebook.getText());
        insertMod.setInstagram(cInstagram.getText());
        
        for(int i =0 ;i<jobmod.size() ; i++){
            System.out.println("Company: " + jobmod.get(i).getCompanyName());
            System.out.println("Designation: " + jobmod.get(i).getDesignation());
            System.out.println("Location: " + jobmod.get(i).getLocation());
            System.out.println("Doj: " + jobmod.get(i).getDoj());
            System.out.println("********************************");
        }
        
        if(!insertMod.isEmpty(isPlaced, educationLevel) && errorFlag == -1){
            System.out.println("error = " + errorFlag);
            try {
                db.insertData(insertMod);
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            JFXSnackbar bar = new JFXSnackbar(rootPane);
            bar.show("Save Successfull!", 2500);
            
            pFirstName.setText("");
            pLastName.setText("");
            CustFileChooser.setText("");
            pNation.setText("");
            pAddress.setText("");
            pState.setText("");
            pCity.setText("");
            pPincode.setText("");
            pDob.setValue(null);
            
            aCollegeUG.setText("");
            aCourseUG.getSelectionModel().selectFirst();
            aBranchUG.getSelectionModel().selectFirst();
            aBatchUG.setText("");
            aGradeUG.setText("");
            
            aCollegePG.setText("");
            aCoursePG.getSelectionModel().selectFirst();;
            aBranchPG.getSelectionModel().selectFirst();;
            aBatchPG.setText("");
            aGradePG.setText("");
            
            
            pCompany.setText("");
            pLocation.setText("");
            pPackage.setText("");
            pNation.setText("");
            pDOJ.setValue(null);
            pDOL.setValue(null);
            pDesignation.setText("");
            pRemark.setText("");
            
            cEmail.setText("");
            cMobile.setText("");
            cLinkedin.setText("");
            cFacebook.setText("");
            cLandline.setText("");
            cInstagram.setText("");
            
            jobmod.clear();
            
        }else{
            String tabName = insertMod.emptyTabName(isPlaced);
            System.out.println(tabName);
            if(tabName.equalsIgnoreCase("personal")){
                subTabPane.getSelectionModel().select(0);
            }else if(tabName.equalsIgnoreCase("academic")){
                subTabPane.getSelectionModel().select(1);
            }else if(tabName.equalsIgnoreCase("profession")){
                subTabPane.getSelectionModel().select(2);
            }else if(tabName.equalsIgnoreCase("contact")){
                subTabPane.getSelectionModel().select(3);
            }
            JFXSnackbar bar = new JFXSnackbar(rootPane);
            bar.show("Please enter all required details!", 3500);
        }
        populateListView();
    }
    
/**
 * This is the event handling method for the gender selection radiobuttons. Both
 * the male and female buttons have this same event handler. Based on which is selected,
 * a char variable is given a particular value.
 */    
    public void setGender(ActionEvent even){
        if(pGenderF.isSelected()){
            pGenderM.setSelected(false);
            gender = "f";
        }else if(pGenderM.isSelected()){
            pGenderF.setSelected(false);
            gender = "m";
        }
    }
    
/**
 * This method checks the value of the toggle button in the Professional Sub-Tab.
 * When the toggle button is selected, all other components in that sub tab get 
 * enabled except for the remark field, indicating that the student has been placed.
 * 
 * When the toggle button is deselected, all other components in that sub tab get 
 * disabled except for the remark field, indicating that the student has not yet
 * been placed.
 * @param event 
 */    
    public void setPlaced(ActionEvent event){
        if(pPlaced.isSelected()){
            System.out.println("Placed!");
            pCompany.setDisable(false);
            pDesignation.setDisable(false);
            pPackage.setDisable(false);
            pLocation.setDisable(false);
            pDOJ.setDisable(false);
            pDOL.setDisable(false);
            pRemark.setDisable(true);
            pAddBtn.setDisable(false);
            
            pRemark.setText("");
            isPlaced = true;
        }else{
            System.out.println("Not placed!");
            pCompany.setDisable(true);
            pDesignation.setDisable(true);
            pPackage.setDisable(true);
            pLocation.setDisable(true);
            pDOJ.setDisable(true);
            pDOL.setDisable(true);
            pRemark.setDisable(false);
            pAddBtn.setDisable(true);
            
            pCompany.setText("");
            pLocation.setText("");
            pPackage.setText("");
            pNation.setText("");
            pDOJ.setValue(null);
            pDOL.setValue(null);
            jobmod.clear();
            
            pDesignation.setText("");
            isPlaced = false;
        }
    }

/**
 * Initializes all filter boxes to facilitate the selection of the filtered list
 */    
    public void setAllFilters(){
        ObservableList<String> listBranch = FXCollections.observableArrayList();

        genderFilter.setItems(FXCollections.observableArrayList("Select Gender", "Male", "Female"));
        genderFilter.getSelectionModel().selectFirst();
        
        for(int i=0; i<mod.size(); i++){
            if(i==0)
                listBranch.add("Select Branch");
            if(!listBranch.contains(mod.get(i).getBranchUG()))
                listBranch.add(mod.get(i).getBranchUG());
        }
        branchFilter.setItems(listBranch);
        branchFilter.getSelectionModel().selectFirst();
        
        placedFilter.setItems(FXCollections.observableArrayList("Placement status", "Placed", "Not Placed"));
        placedFilter.getSelectionModel().selectFirst();
    }
       
/**
 * Removes all the filters applied (if any) and calls the populateListView() method to
 * refresh the ListView.
 * @param event 
 */    
    public void onRemoveFilters(MouseEvent event){
        filteredList.clear();
        populateListView();
        batchFilter.setText("");
        genderFilter.getSelectionModel().selectFirst();
        branchFilter.getSelectionModel().selectFirst();
        placedFilter.getSelectionModel().selectFirst();
    }
    
    public void getMainTab(){
        int i = mainTabpane.getSelectionModel().getSelectedIndex();
        System.out.println(i);
        if(i==0 && is_in_search_mode){
           is_in_search_mode = false;
           closeSearchBar();
        }else if(i==0){
            deleteId=-1;
        }
    }

/**
 * This method is used to search for matching entries in the main ListView. When text is
 * changed in the searchBar, the text change listener of the later calls this method and
 * passes the changed text input as a string.
 * <p>
 * This method filters the list form an ArrayList of AlumniModel, mod, and stores it into another
 * ArrayList of AlumniModel named filteredList. If the argument string is null, then filteredList
 * is set to null, else matching data from the mod is added to filteredList and then the filteredList
 * is passed to the setCustomRow() method to update the ListView.
 * <p>
 * If the argument string is null, the populateListView() method is called which fills the ListView with
 * all the values in mod.
 * @param filterString is the new String or the changed String in the searchBar
 */    
    public void filterList(String filterString){
        filteredList.clear();
        recordsList.getItems().clear();
        
        if(filterString==null)
            populateListView();
        else{
            for(int i=0; i<mod.size(); i++){
                if(mod.get(i).getFirstname().contains(filterString))
                    filteredList.add(mod.get(i));
            }
        
            for(int i=0; i<filteredList.size(); i++){
                recordsList.getItems().add(setCustomRow(filteredList.get(i)));
            }
        }
    }
    
/**
 * Returns index of selected tab of mainTabpane
 * @return int
 */    
    public int getSelectedMainTab(){
        return mainTabpane.getSelectionModel().getSelectedIndex();
    }
    
/**
 * It's an event handling method attached to the main ListView which listens to the
 * click event on the list and return the index of the item that was clicked.
 * <p>
 * If value of the index returned is greater than zero, the profile page is opened
 * by calling the animateTransition() method and setProfilePage() method. The ith 
 * object of the AlumniModel ArrayList is passed to the setProfilePage() method as
 * a parameter, where i is the index of the item that was clicked.
 * <p>
 * Before setting up the profile page, it checks if the filteredList is empty or not.
 * This is done to ensure that, when the ListView contains the filtered value, then 
 * the setProfilePage must index the correct element. If failed to do so, the profile
 * page will be filled with someone else's data instead of the item that was clicked.
 * <p>
 * This method also checks whether the searchBar is on or off i.e. whether the application
 * is in search mode or not. If found true, the is_in_search_mode variable is set false
 * and the closeSearchBar() method is called to close the search bar.
 */    
    public void onListClicked(MouseEvent event){
        int i = recordsList.getSelectionModel().getSelectedIndex();
        if(event.getButton()==MouseButton.PRIMARY){
            
            scrpane.setVvalue(0);
            if(i>=0){
                if(filteredList.size()!=0)
                    setProfilePage(filteredList.get(i));
                else
                    setProfilePage(mod.get(i));
                animateTransition();
            }else
                return;
            System.out.println("List has been clicked! "+i);
            if(is_in_search_mode == true){
                  closeSearchBar();
                  is_in_search_mode = false;
            }
        }else{
            System.out.println("Right click!");
            if(deleteId==i){
                deleteId=-1;
                //recordsList.getSelectionModel().getSelectedItem().setStyle("-fx-control-inner-background: white;");
            }else{
                deleteId = mod.get(i).getId();
                //recordsList.getSelectionModel().getSelectedItem().setStyle("-fx-control-inner-background: blue;");
            }
        }
    }
    
/**
 * Determines whether the application is in search mode or not and based upon the
 * conclusion, calls the initSearchBar() or the closeSearchBar() method while changing
 * the value of is_in_search_mode.
 */    
    public void beginSearch(){
        if(!is_in_search_mode){
            initSearchBar();
            if(mainTabpane.getSelectionModel().getSelectedIndex() == 0)
                mainTabpane.getSelectionModel().select(1);
            
            filteredList.clear();
            populateListView();
            batchFilter.setText("");
            genderFilter.getSelectionModel().selectFirst();
            branchFilter.getSelectionModel().selectFirst();
            placedFilter.getSelectionModel().selectFirst();
        
            is_in_search_mode = true;
        }else{
            closeSearchBar(); 
            is_in_search_mode = false;
        }
    }  
    
/**
 * Sets all labels in the ScrollPane to their respective values based on the item
 * in the list that was clicked. Takes an object of AlumniModel class representing
 * the profile that was clicked and sets the values to each label accordingly.
 * @param mod1 
 */    
    public void setProfilePage(AlumniModel mod1){
        EditModel = mod1;
        deleteId = -1;
        //setProfessionDetails(mod1);
        populateScrJobList(mod1);
        scrAge.setText("Dob:    "+mod1.getDob());
        
        int rand = ThreadLocalRandom.current().nextInt(1, 6 + 1);
        System.out.println("Random = " + rand);
        
        ImageView icon;
        File file = null;
        if(mod1.getPic()!=null)
            file = new File(mod1.getPic());
            if(file.exists())
                icon = new ImageView(file.toURI().toString());
            else{
                icon = null;
                if(icon==null && mod1.getGender().equalsIgnoreCase("f"))
                    icon = new ImageView(new Image(getClass().getResourceAsStream("res/Avatar Woman.jpg")));
                else if(icon==null && mod1.getGender().equalsIgnoreCase("m"))
                    icon = new ImageView(new Image(getClass().getResourceAsStream("res/Avatar Man.jpg")));
            }
        icon.setFitWidth(145); icon.setFitHeight(155);
        profilelabel.setGraphic(icon);
            
        switch(rand){
            case 1: icon = new ImageView(new Image(getClass().getResourceAsStream("res/cover1.jpg")));
                    icon.setFitWidth(865); icon.setFitHeight(180);
                    coverlabel.setGraphic(icon);
                    break;
                    
            case 2: icon = new ImageView(new Image(getClass().getResourceAsStream("res/cover2.jpg")));
                    icon.setFitWidth(865); icon.setFitHeight(180);
                    coverlabel.setGraphic(icon);
                    break;
                    
            case 3: icon = new ImageView(new Image(getClass().getResourceAsStream("res/cover3.jpg")));
                    icon.setFitWidth(865); icon.setFitHeight(180);
                    coverlabel.setGraphic(icon);
                    break;
                    
            case 4: icon = new ImageView(new Image(getClass().getResourceAsStream("res/cover4.jpg")));
                    icon.setFitWidth(865); icon.setFitHeight(180);
                    coverlabel.setGraphic(icon);
                    break;
                    
            case 5: icon = new ImageView(new Image(getClass().getResourceAsStream("res/cover5.jpg")));
                    icon.setFitWidth(865); icon.setFitHeight(180);
                    coverlabel.setGraphic(icon);
                    break;
                    
            case 6: icon = new ImageView(new Image(getClass().getResourceAsStream("res/cover6.jpg")));
                    icon.setFitWidth(865); icon.setFitHeight(180);
                    coverlabel.setGraphic(icon);
                    break;
        };
        
        scrName.setText(mod1.getFirstname());
        
        if(mod1.getPlaced()==1){
            for(int i=0; i< mod1.getJobmod().size(); i++){
                if(mod1.getId() == mod1.getJobmod().get(i).getId()){
                    scrPosition.setText(mod1.getJobmod().get(i).getDesignation());
                    scrCompanyName.setText(mod1.getJobmod().get(i).getCompanyName());
                    break;
                }
            }
        }else{
            scrPosition.setText("Inactive");
            scrCompanyName.setText(" ");
        }
        /*if(mod1.getJobmod().get(0).getDesignation()==null || mod1.getJobmod().get(0).getDesignation().isEmpty())
            scrPosition.setText("Inactive");
        else
            scrPosition.setText(mod1.getJobmod().get(0).getDesignation());
        
        if(mod1.getJobmod().get(0).getCompanyName()==null || mod1.getJobmod().get(0).getDesignation().isEmpty()){
            scrCompanyName.setText(" ");
        }else{
            scrCompanyName.setText(mod1.getJobmod().get(0).getCompanyName());
        }*/
        scrAddress.setText("Address:  "+mod1.getAddress());
        scrCity.setText("City:  "+mod1.getCity());
        scrState.setText("State:  "+mod1.getState());
        scrPincode.setText("Pin:  "+mod1.getPincode());
        
        if(mod1.getCollegeNameUG()==null || mod1.getCollegeNameUG().isEmpty()){
            scrBatchU.setText("Batch: N/A");
            scrCollegeU.setText("College: N/A");
            scrBranchU.setText("Branch: N/A");
            scrPassingU.setText("Passing %: N/A");
            scrCourseU.setText("Course: N/A");
        }else{
            scrBatchU.setText(String.valueOf(mod1.getBatchUG()));
            scrCollegeU.setText(mod1.getCollegeNameUG());
            scrBranchU.setText(mod1.getBranchUG());
            scrPassingU.setText(mod1.getPassUG());
            scrCourseU.setText(mod1.getCourseUG());
        }
        
        if(mod1.getCollegeNamePG()==null || mod1.getCollegeNamePG().isEmpty()){
            scrBatchP.setText("Batch: N/A");
            scrCollegeP.setText("College: N/A");
            scrBranchP.setText("Branch: N/A");
            scrPassingP.setText("Passing %: N/A");
            scrCourseP.setText("Course: N/A");
        }else{
            scrBatchP.setText(String.valueOf(mod1.getBatchPG()));
            scrCollegeP.setText(mod1.getCollegeNamePG());
            scrBranchP.setText(mod1.getBranchPG());
            scrPassingP.setText(mod1.getPassPG());
            scrCourseP.setText(mod1.getCoursePG());
        }
        
        scrMobile.setText(mod1.getMobile());
        scrEmail.setText(mod1.getEmail());
        if(mod1.getFacebook()==null || mod1.getFacebook().isEmpty())
            scrFacebook.setText("N/A");
        else
            scrFacebook.setText(mod1.getFacebook());
        
        if(mod1.getLinkedin()==null || mod1.getLinkedin().isEmpty())
            scrLinkedin.setText("N/A");
        else
            scrLinkedin.setText(mod1.getLinkedin());
        
        if(mod1.getInstagram()==null || mod1.getInstagram().isEmpty())
            scrInstagram.setText("N/A");
        else
            scrInstagram.setText(mod1.getInstagram());
        
        if(mod1.getLandline()==null || mod1.getLandline().isEmpty())
            scrLandline.setText("N/A");
        else
            scrLandline.setText(mod1.getLandline());
    }
    
    
/**
 * Used to create a customRow for the main ListView. A row is made up of a
 * HBox. Each HBox has a Rectangle (with rounded corner to make it a circle) which 
 * contains the profile pic, a VBox to hold the name and employment status of the
 * alumni followed by 3 labels displaying the course, batch and branch.
     * @param tempMod takes an object of ALumniModel class as input
     * @return An object of HBox representing one complete row
 */    
    public HBox setCustomRow(AlumniModel tempMod){
        
        HBox row = new HBox();
        Label name, batch, course, branch, employed;
        name = new Label();
        batch = new Label();
        course = new Label();
        branch = new Label();
        employed = new Label();
        
        //System.out.println(tempMod.getId());
        name.setText(tempMod.getFirstname());
        name.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        name.setAlignment(Pos.TOP_LEFT);
        
        //System.out.println("Name = " + tempMod.getFirstname() + " PG Batch: "+tempMod.getBatchPG());
        if(tempMod.getBatchPG()>0){
            batch.setText(String.valueOf(tempMod.getBatchPG()));
        }else{
            batch.setText(String.valueOf(tempMod.getBatchUG()));
        }
        batch.setPrefWidth(100);
        batch.setMaxWidth(100);
        batch.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 16));
        batch.setAlignment(Pos.CENTER);
        
        
        if(!tempMod.getBranchPG().isEmpty())
            branch.setText(String.valueOf(tempMod.getBranchPG()));
        else
            branch.setText(String.valueOf(tempMod.getBranchUG()));
        branch.setPrefWidth(100);
        branch.setMaxWidth(100);
        branch.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 16));
        branch.setAlignment(Pos.CENTER);
        
        
        if(!tempMod.getCoursePG().isEmpty()){
            course.setText(tempMod.getCoursePG());
        }else{
            course.setText(tempMod.getCourseUG());
        }
        course.setPrefWidth(100);
        course.setMaxWidth(100);
        course.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 16));
        course.setAlignment(Pos.CENTER);
        
        
        if(tempMod.getPlaced()==1){
            for(int i=0; i< tempMod.getJobmod().size(); i++){
                if(tempMod.getId() == tempMod.getJobmod().get(i).getId()){
                    employed.setText(tempMod.getJobmod().get(i).getCompanyName());
                    break;
                }
            }
        }else{
            employed.setText("Inactive");
        }
        employed.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 14));
        
        VBox col = new VBox();
        col.setSpacing(2);
        col.getChildren().addAll(name, employed);
        col.setPrefWidth(220);
        col.setMaxWidth(220);
        
        Rectangle rect = new Rectangle(0,0,45,45);
        rect.setArcHeight(50);
        rect.setArcWidth(50);
        rect.setStroke(Color.CYAN);
        //System.out.println(tempMod.getPic());
        Image icon = null;
        try{
            File file = new File(tempMod.getPic());
            
            //System.out.println("Path: " + tempMod.getPic());
            if(file.exists())
                icon = new Image(file.toURI().toString());
            else
                icon = null;
        }catch(Exception e){
            //System.out.println("Cannot open image for "+ tempMod.getFirstname());
            if(tempMod.getGender().equalsIgnoreCase("f"))
                icon = new Image(getClass().getResourceAsStream("res/Avatar Woman.jpg"));
            else
                icon = new Image(getClass().getResourceAsStream("res/Avatar Man.jpg"));
            e.printStackTrace();
        }finally{
            if(icon==null && tempMod.getGender().equalsIgnoreCase("f"))
                icon = new Image(getClass().getResourceAsStream("res/Avatar Woman.jpg"));
            else if(icon==null && tempMod.getGender().equalsIgnoreCase("m"))
                icon = new Image(getClass().getResourceAsStream("res/Avatar Man.jpg"));
        }
        rect.setFill(new ImagePattern(icon));
        
        
        row.setSpacing(25);
        row.setAlignment(Pos.CENTER_LEFT);
        row.setPadding(new Insets(0, 10, 0, 10));                               //new Insets(Top, Right, Bottom, Left)
        row.getChildren().addAll(rect, col, course, batch, branch);  
        
        //ImageView icon = new ImageView(new Image(getClass().getResourceAsStream("res/pic1.jpg")));
        
        return row;
        
    }

    
/**
 * Used to remove duplicate entries from the ArrayList<AlumniModel>. This method
 * is called from the populateListView() method, just after the database returns
 * all the entries in from the tables.
 */    
    public void removeDuplicates(){
        for(int i=0; i< mod.size(); i++){
            for(int j=i+1; j< mod.size(); j++){
                if(mod.get(i).getFirstname().equals(mod.get(j).getFirstname())){
                    mod.remove(j);
                    j--;
                }
            }
        }
        
        //HashSet<AlumniModel> hashset = new HashSet<AlumniModel>();
        //hashset.addAll(mod.)
    
    }
    
    
/**
 * The following method calls the getRowsData() method of the data base class which
 * returns an ArrayList of AlumniModel objects. The AlumniModel object ArrayList contains
 * all the data of all the fields from the four tables.
 * <p>
 * Once the data has been acquired, with each iteration of the ArrayList a new row is set
 * once all the rows have been added. The method returns its control.
 */    
    public void populateListView(){
        recordsList.getItems().clear();
        mod.clear();
        mod = db.getRowsData();
        removeDuplicates();
        //int oldId = -1;
        for(int i=0; i<mod.size(); i++){
           recordsList.getItems().add(setCustomRow(mod.get(i)));
        }
    }
        
    public void populateScrJobList(AlumniModel tempMod){
        scrJobList.getItems().clear();
        //removeDuplicatesJobs(tempMod.getJobmod());

        /*Set<JobModel> hashset = new HashSet<JobModel>();
        hashset.addAll(tempMod.getJobmod());
        System.out.println("Size = " + tempMod.getJobmod().size());
        tempMod.getJobmod().clear();
        System.out.println("Size = " + tempMod.getJobmod().size());
        tempMod.getJobmod().addAll(hashset);
        System.out.println("Size = " + tempMod.getJobmod().size());*/
        
        for(int i=0; i< tempMod.getJobmod().size(); i++){
            for(int j=i+1; j< tempMod.getJobmod().size(); j++){
                if(tempMod.getJobmod().get(i).getCompanyName()!=null && tempMod.getJobmod().get(i).getCompanyName().equals(tempMod.getJobmod().get(j).getCompanyName())){
                    tempMod.getJobmod().remove(j);
                    j--;
                }
            }
        }
        System.out.println("Size = " + tempMod.getJobmod().size());
        
        for(int i=0; i<tempMod.getJobmod().size(); i++){
            if(tempMod.getId() == tempMod.getJobmod().get(i).getId()){
                System.out.println("Job list: " + tempMod.getJobmod().get(i).getCompanyName());
                scrJobList.getItems().add(setProfessionDetailsRow(tempMod.getJobmod().get(i)));
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        NumberValidator batchValidator, mobValidator, emailValidator;
        mobValidator = new NumberValidator();
        batchValidator = new NumberValidator();
        emailValidator = new NumberValidator();
        mobValidator.setMessage("Invalid Mobile Number!");
        batchValidator.setMessage("Invalid Batch year");
        emailValidator.setMessage("Invalid Email address");
        
        aBatchUG.getValidators().add(batchValidator);
        aBatchPG.getValidators().add(batchValidator);
        cMobile.getValidators().add(mobValidator);
        cEmail.getValidators().add(emailValidator);
        
        db = new DataBase();
        //db.clearAll();
        depthSettings();
        configureToolbars();
        configureMainTab();

        closeSearchBar();
        configureProfileDetailsPage();
        populateListView();
        setAllFilters(); 
        
        double height = rootPane.getPrefHeight() - coverlabel.getPrefHeight();
        scrpane.setPrefHeight(height);
        
        pDob.setValue(LocalDate.of(1995, 01, 01));
        
/***Number validating listeners*********************************************************/    
         
        pPincode.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    pPincode.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        aBatchUG.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    aBatchUG.setText(newValue.replaceAll("[^\\d]", ""));
                }
                if (aBatchUG.getText().length() > 4) {
                    String s = aBatchUG.getText().substring(0, 4);
                    aBatchUG.setText(s);
                }
            }
        });
        
        aBatchUG.focusedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue){
                if (!newPropertyValue){
                    if(aBatchUG!= null && aBatchUG.getText().length()<4){
                        String str = aBatchUG.getText();
                        aBatchUG.setText("");
                        aBatchUG.validate();
                        aBatchUG.setText(str);
                    }else{
                        aBatchUG.resetValidation();
                    }
                }
            }
        });
        
        aBatchPG.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*") ) {
                    aBatchPG.setText(newValue.replaceAll("[^\\d]", ""));
                }
                if (aBatchPG.getText().length() > 4) {
                    String s = aBatchPG.getText().substring(0, 4);
                    aBatchPG.setText(s);
                }
            }
        });

        aBatchPG.focusedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue){
                if (!newPropertyValue){
                    if(aBatchPG!= null && aBatchPG.getText().length()<4){
                        String str = aBatchPG.getText();
                        aBatchPG.setText("");
                        aBatchPG.validate();
                        aBatchPG.setText(str);
                    }else{
                        aBatchPG.resetValidation();
                    }
                }
            }
        });
        
        pPackage.textProperty().addListener(new ChangeListener<String>() {


            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    pPackage.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        
        cMobile.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    cMobile.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        
        cLandline.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    cLandline.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        
        cMobile.focusedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (!newPropertyValue){
                    if(cMobile.getText()!=null && cMobile.getText().length()!=10){
                       String str = cMobile.getText();
                       cMobile.setText("");
                       cMobile.validate();
                       cMobile.setText(str);
                       errorFlag = 1;
                    }else{
                        cMobile.resetValidation();
                        errorFlag = -1;
                    }
                }
            }
        });
        
        searchBar.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("Text Changed to  " + newValue);
                filterList(newValue);
            }
        });
        
        pNation.focusedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue){
                if (pNation.getText().length()>1 && !newPropertyValue){
                    String oldText = pNation.getText();
                    String update = oldText.substring(0, 1).toUpperCase() + oldText.substring(1).toLowerCase();
                    pNation.setText(update);
                }
            }
        });
        
        pCity.focusedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue){
                if (pCity.getText().length()>1 && !newPropertyValue){
                    String oldText = pCity.getText();
                    String update = oldText.substring(0, 1).toUpperCase() + oldText.substring(1).toLowerCase();
                    pCity.setText(update);
                }
            }
        });
        
        pState.focusedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue){
                if (pState.getText().length()>1 && !newPropertyValue){
                    String oldText = pState.getText();
                    String update = oldText.substring(0, 1).toUpperCase() + oldText.substring(1).toLowerCase();
                    pState.setText(update);
                }
            }
        });
        
        pFirstName.focusedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue){
                if (pFirstName.getText().length()>1 && !newPropertyValue){
                    String oldText = pFirstName.getText();
                    String update = oldText.substring(0, 1).toUpperCase() + oldText.substring(1).toLowerCase();
                    pFirstName.setText(update);
                }
            }
        });
        
        pLastName.focusedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue){
                if (pLastName.getText().length()>1 && !newPropertyValue){
                    String oldText = pLastName.getText();
                    String update = oldText.substring(0, 1).toUpperCase() + oldText.substring(1).toLowerCase();
                    pLastName.setText(update);
                }
            }
        });
        
        /*aBranchUG.focusedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue){
                if (aBranchUG.getText()!=null && !newPropertyValue){
                    
                    String oldText = aBranchUG.getText();
                    String update = oldText.toUpperCase();
                    aBranchUG.setText(update);
                }
            }
        });*/
        
        /*aBranchPG.focusedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue){
                if (!newPropertyValue){
                    String oldText = aBranchPG.getText();
                    String update = oldText.toUpperCase();
                    aBranchPG.setText(update);
                }
            }
        });*/
        
        /*aCourseUG.focusedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue){
                if (!newPropertyValue){
                    String oldText = aCourseUG.getText();
                    String update = oldText.toUpperCase();
                    aCourseUG.setText(update);
                }
            }
        });*/
        
        /*aCoursePG.focusedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue){
                if (!newPropertyValue){
                    String oldText = aCoursePG.getText();
                    String update = oldText.toUpperCase();
                    aCoursePG.setText(update);
                }
            }
        });*/
        
        cEmail.focusedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue){
                if(cEmail.getText()!=null && !newPropertyValue){
                    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                    Pattern pat = Pattern.compile(emailRegex);
                    if(cEmail.getText()!=null && !pat.matcher(cEmail.getText()).matches()){
                        cEmail.validate();
                        errorFlag = 1;
                    }else{
                        cEmail.resetValidation();
                        errorFlag = -1;
                    }
                }
            }
        });
        
        aCourseUG.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                System.out.println("Selected index = " + aCourseUG.getSelectionModel().getSelectedIndex());
        
                if(aCourseUG.getSelectionModel().getSelectedIndex()==0){
                    aBranchUG.setItems(FXCollections.observableArrayList("Select Branch"));
                    aBranchUG.getSelectionModel().selectFirst();
                }else if(aCourseUG.getSelectionModel().getSelectedIndex()==1){
                    aBranchUG.setItems(FXCollections.observableArrayList("Select Branch", "CSE", "MECH", "IT", "CIVIL", "ETC"));
                    aBranchUG.getSelectionModel().selectFirst();
        }
            }
        });
        
        aCoursePG.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                System.out.println("Selected index = " + aCoursePG.getSelectionModel().getSelectedIndex());
        
                if(aCoursePG.getSelectionModel().getSelectedIndex()==0){
                    aBranchPG.setItems(FXCollections.observableArrayList("Select Branch"));
                    aBranchPG.getSelectionModel().selectFirst();
                }else if(aCoursePG.getSelectionModel().getSelectedIndex()==1){
                    aBranchPG.setItems(FXCollections.observableArrayList("Select Branch", "CSE", "VLSI", "Stuctural", "Industrial", "CAD/CAM"));
                    aBranchPG.getSelectionModel().selectFirst();
        }
            }
        });
    }    
    
}
