/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumni;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.effects.JFXDepthManager;
import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class BasicEditController implements Initializable {

    private DataBase db = null;
    
/***********************************************Basic Edit*******/
    @FXML
    private JFXTextField firstNameEdit, lastNameEdit, nationalityEdit, addressEdit, cityEdit, stateEdit, pincodeEdit;

    @FXML
    private JFXTextField CustFileChooser;
    
    @FXML
    private RadioButton femaleEdit, maleEdit;

    @FXML
    private JFXDatePicker dobEdit;
    
    @FXML
    JFXButton cancelBtn, saveBtn;
    
    private char gender = 'x';
    private AlumniModel editModel = new AlumniModel();
/***********************************************Education Edit*******/
    
    @FXML
    private JFXTextField UGInstituteEdit, UGBranchEdit, UGPassEdit, UGBatchEdit, UGCourseEdit;
    
    @FXML
    private JFXTextField PGInstituteEdit, PGBranchEdit, PGPassEdit, PGBatchEdit, PGCourseEdit;

    @FXML
    private JFXButton saveEditBtn, cancelEducationBtn;
    
/***********************************************Job Edit*******/
    @FXML
    private JFXListView<HBox> jobList;

    @FXML
    private JFXButton saveJobBtn, updateJobBtn, cancelJobBtn;

    @FXML
    private JFXTextField companyEdit, positionEdit, packageEdit, locationEdit;

    @FXML
    private JFXDatePicker dojEdit, dolEdit;

    
/***********************************************Contacts Edit*******/
    @FXML
    private JFXTextField mobEdit, landEdit, emailEdit, linkedinEdit, facebookEdit, instagramEdit;
    
    @FXML
    JFXButton cancelContactbtn, saveContactbtn;
/******************************************************************/
    
    
    public void onBasicCancelBtn(MouseEvent event){
        Stage stage;
        stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }
    
    public void onContactCancelBtn(MouseEvent event){
        Stage stage;
        stage = (Stage) cancelContactbtn.getScene().getWindow();
        stage.close();
    }
    
    public void onJobCancelBtn(ActionEvent event){
        Stage stage;
        stage = (Stage) cancelJobBtn.getScene().getWindow();
        stage.close();
    }
    
    public void onEducationCancelBtn(MouseEvent event){
        Stage stage;
        stage = (Stage) cancelEducationBtn.getScene().getWindow();
        stage.close();
    }  
    
    
    
    public void onBasicSaveBtn(ActionEvent event){
        String pic = CustFileChooser.getText();
        StringBuilder str = new StringBuilder();
        
        for(int i=0; i<pic.length(); i++){
            if(pic.charAt(i)=='\\'){
                str.append(pic.charAt(i));
                str.append('\\');
            }else{
                str.append(pic.charAt(i));
            }
        }
        pic = str.toString();
        
        System.out.println("Pic: "+ pic);
        String updateQuery = "UPDATE Personal "+
                             "SET Name = '"+firstNameEdit.getText()+"', "+
                             "Pic = '"+pic+"', "+
                             "Dob = '"+dobEdit.getValue().toString()+"', "+
                             "Nationality = '"+nationalityEdit.getText()+"', "+
                             "Gender = '"+gender+"', "+
                             "Address = '"+addressEdit.getText()+"', "+
                             "City = '"+cityEdit.getText()+"', "+
                             "State = '"+stateEdit.getText()+"', "+
                             "Pincode = '"+pincodeEdit.getText()+"' "+
                             "WHERE _ID = '"+editModel.getId()+"';";
        
        System.out.println("Update query is: \n" + updateQuery);
        db.updateRow(updateQuery);
        Stage stage;
        stage = (Stage) saveBtn.getScene().getWindow();
        stage.close();
    }
    
    public void onEducationSaveBtn(ActionEvent event){
        
        String updateQuery = "UPDATE Academic "+
                             "SET Ucollege = '"+UGInstituteEdit.getText()+"', "+
                             "UBranch = '"+UGBranchEdit.getText()+"', "+
                             "Umarks = '"+UGPassEdit.getText()+"', "+
                             "UBatch = '"+UGBatchEdit.getText()+"', "+
                             "UCourse = '"+UGCourseEdit.getText()+"' "+
                             "Pcollege = '"+PGInstituteEdit.getText()+"', "+
                             "PBranch = '"+PGBranchEdit.getText()+"', "+
                             "Pmarks = '"+PGPassEdit.getText()+"', "+
                             "PBatch = '"+PGBatchEdit.getText()+"', "+                             
                             "PCourse = '"+PGCourseEdit.getText()+"' "+                             
                             "WHERE _ID = '"+editModel.getId()+"';";
        
        System.out.println("Update query is: \n" + updateQuery);
        //db.updateRow(updateQuery);
        Stage stage;
        stage = (Stage) saveEditBtn.getScene().getWindow();
        stage.close();
    }
    
    public void onContactSaveBtn(ActionEvent event){
        
        String updateQuery = "UPDATE Contact "+
                             "SET Mobile = '"+mobEdit.getText()+"', "+
                             "landline = '"+landEdit.getText()+"', "+
                             "email = '"+emailEdit.getText()+"', "+
                             "facebook = '"+facebookEdit.getText()+"', "+
                             "linkedin = '"+linkedinEdit.getText()+"', "+
                             "instagram = '"+instagramEdit.getText()+"' "+                           
                             "WHERE _ID = '"+editModel.getId()+"';";
        
        System.out.println("Update query is: \n" + updateQuery);
        db.updateRow(updateQuery);
        Stage stage;
        stage = (Stage) cancelJobBtn.getScene().getWindow();
        stage.close();
    }
    
    public void onJobSaveBtn(ActionEvent event){
        
        Stage stage;
        stage = (Stage) saveJobBtn.getScene().getWindow();
        stage.close();
    }
    
    public void onJobUpdateBtn(ActionEvent event){
        
        Stage stage;
        stage = (Stage) updateJobBtn.getScene().getWindow();
        stage.close();
    }
    
    
    
    public void handleFileChooserBtn(MouseEvent event){
        CustFileChooser.setText(null);
        CustFileChooser.setEditable(false);
        
        File file;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        Stage stage = new Stage();
        file = fileChooser.showOpenDialog(stage);
        String fileName = file.getName();
        if(fileName.contains(".png") || fileName.contains(".jpg") || fileName.contains(".jpeg"))
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
    
    public void handleGenderSelection(MouseEvent event){
        if(femaleEdit.isSelected()){
            gender = 'f';
            maleEdit.setSelected(false);
        }else if(maleEdit.isSelected()){
            gender = 'm';
            femaleEdit.setSelected(false);
        }else{
            gender = editModel.getGender().charAt(0);
            femaleEdit.setSelected(false);
            maleEdit.setSelected(false);
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
    
    public void populateScrJobList(AlumniModel tempMod){
        jobList.getItems().clear();
        
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
                jobList.getItems().add(setProfessionDetailsRow(tempMod.getJobmod().get(i)));
            }
        }
    }
    
    
    
    public void setUpBasic(){
        editModel = AlumniModel.getEditModel();
        System.out.println("College: " + editModel.getCollegeNameUG());
        
        firstNameEdit.setText(editModel.getFirstname());
        CustFileChooser.setText(editModel.getPic());
        nationalityEdit.setText(editModel.getNationality());
        addressEdit.setText(editModel.getAddress());
        cityEdit.setText(editModel.getCity());        
        stateEdit.setText(editModel.getState());
        pincodeEdit.setText(editModel.getPincode());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formatter = formatter.withLocale( Locale.ENGLISH );  
        LocalDate date = LocalDate.parse(editModel.getDob(), formatter);
        
        dobEdit.setValue(date);
        
        
        if(editModel.getGender().equalsIgnoreCase("f")){
            femaleEdit.setSelected(true);
            maleEdit.setSelected(false);
            gender = 'f';
        }else{
            maleEdit.setSelected(true);
            femaleEdit.setSelected(false);
            gender = 'm';
        }
    }
    
    public void setUpAcademic(){
        //editModel = null;
        //editModel = AlumniModel.getEditModel();
        
        System.out.println("College: " + editModel.getCollegeNameUG());
        
        UGInstituteEdit.setText(editModel.getCollegeNameUG());
        UGBranchEdit.setText(editModel.getBranchUG());
        UGPassEdit.setText(editModel.getPassUG());
        UGBatchEdit.setText(String.valueOf(editModel.getBatchUG())); 
        UGCourseEdit.setText(editModel.getCourseUG());
        if(editModel.getCollegeNamePG()!=null)
            PGInstituteEdit.setText(editModel.getCollegeNamePG());
        if(editModel.getBranchPG()!=null)
            PGBranchEdit.setText(editModel.getBranchPG());
        if(editModel.getPassPG()!=null)
            PGPassEdit.setText(editModel.getPassPG());
        if(editModel.getCoursePG()!=null)
            PGPassEdit.setText(editModel.getCoursePG());
        if(String.valueOf(editModel.getBatchPG()).length()>0)
            PGBatchEdit.setText(String.valueOf(editModel.getBatchPG()));
    }
    
    public void setUpContacts(){
        editModel = AlumniModel.getEditModel();
        
        mobEdit.setText(editModel.getMobile());
        landEdit.setText(editModel.getLandline());
        emailEdit.setText(editModel.getEmail());
        linkedinEdit.setText(editModel.getLinkedin()); 
        facebookEdit.setText(editModel.getFacebook());
        instagramEdit.setText(editModel.getInstagram()); 
    }
    
    public void setUpProfession(){
        editModel = AlumniModel.getEditModel();
        populateScrJobList(editModel);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        editModel = AlumniModel.getEditModel();
        db = new DataBase();
        if(firstNameEdit!=null){
            setUpBasic();
        }else if(UGInstituteEdit!=null){
            setUpAcademic();
        }else if(mobEdit!=null){
            setUpContacts();
        }else
            setUpProfession();
    }    
    
}
