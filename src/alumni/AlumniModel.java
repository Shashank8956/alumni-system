package alumni;

import java.util.ArrayList;
import java.util.List;

/**
 * This method is used to create a holder object for all the input fields created
 * in the home tab of the UI. It contains a set of variables to hold the data of 
 * each field.
 * <p>
 * Each variable has its own set of getter and setter methods. Other than the getter
 * and setter methods, this class also has two methods for checking whether all the 
 * required fields have been filled or not and if not then which of the tab contains 
 * the unfilled field?
 * @author Spongebob
 */
public class AlumniModel {
/********personal tab*************************/    
    private String firstname, lastname, pic, dob, nationality, address, city, state, pincode;
    private String gender = "x";
    private int id=-1;
    private static int editId =0;

/********Academic tab*************************/
    private String collegeNameUG, branchUG, courseUG, collegeNamePG, branchPG, passUG, passPG, coursePG;
    private int batchUG, batchPG;
    private int educationLevel =0;
/********Professional tab*************************/
    private String companyName, designation, location, doj, remark;
    private double annualPackage = -1;
    private int placed = 0;     // Placed = 1; Not Placed = 0;
/********Contacts tab*************************/  
    private String email, facebook, linkedin, instagram;
    private String mobile, landline;
    private static AlumniModel editModel = new AlumniModel();
    private List<JobModel> jobmod = new ArrayList<JobModel>();
    private JobModel insertJobmod = new JobModel();

    
    public AlumniModel(){
        
    }
    
    public AlumniModel(int id, String firstname, String lastname, String pic, String Nationality, String address, String city,
                       String state, String gender, String dob, String pincode, String collegeNameUG, String courseUG,
                       String branchUG, String passUG, int batchUG, String collegeNamePG, String coursePG, String branchPG,
                       String passPG, int batchPG, int placed, String remark, String mobile, String landline, String email, 
                       String linkedin, String facebook, String instagram, List<JobModel> jobmob, int educationLevel){
        
        this.setId(id);
        this.setFirstname(firstname);
        this.setLastname(lastname);
        this.setPic(pic);
        this.setNationality(Nationality);
        this.setAddress(address);
        this.setCity(city);
        this.setState(state);
        this.setGender(gender);
        this.setDob(dob);
        this.setPincode(pincode);
        
        this.setCollegeNameUG(collegeNameUG);
        this.setCourseUG(courseUG);
        this.setBranchUG(branchUG);
        this.setPassUG(passUG);
        this.setBatchUG(batchUG);
        this.setCollegeNamePG(collegeNamePG);
        this.setCoursePG(coursePG);
        this.setBranchPG(branchPG);
        this.setPassPG(passPG);
        this.setBatchPG(batchPG);
        this.setEducationLevel(educationLevel);
        
        this.setPlaced(placed);
        this.setRemark(remark);
        this.setJobmod(jobmob);
        
        this.setMobile(mobile);
        this.setLandline(landline);
        this.setEmail(email);
        this.setLinkedin(linkedin);
        this.setFacebook(facebook);
        this.setInstagram(instagram);
    }
    
/**************************    
*  This method checks if all the required fields are filled. If not it returns 
*  true, else it returns false. As an argument, it takes a boolean value specifying
*  whether the student has been placed or not. If true, the student has been placed
*  and the remark field becomes disabled. If false, the remark field becomes enable
*  disabling the company related fields.
*  
*  @param placed
*  @return boolean
*/
    public boolean isEmpty(boolean placed, int educationLevel){
        System.out.println("Jobmod = " + jobmod.size());
        if(educationLevel==0){
            if (placed) {
                setPlaced(1);
                remark = null;
                if(firstname.isEmpty() || lastname.isEmpty() || dob.isEmpty() || nationality.isEmpty() || address.isEmpty() || city.isEmpty() || state.isEmpty() || pincode.isEmpty())
                    return true;
                else if(collegeNameUG.isEmpty() || branchUG.contains("Select") || courseUG.contains("Select") || passUG.isEmpty())
                    return true;
                else if(jobmod.isEmpty() || jobmod.get(0).getCompanyName().isEmpty() || jobmod.get(0).getDesignation().isEmpty()|| jobmod.get(0).getDoj().isEmpty())
                    return true;
                else if(mobile.isEmpty() || email.isEmpty())
                    return true;
                else
                    return false;
            } else {
                setPlaced(0);
                companyName = null; 
                designation = null;
                annualPackage = 0.0;
                doj = null;
                location = null;

                if(firstname.isEmpty() || lastname.isEmpty() || dob.isEmpty() || nationality.isEmpty() || address.isEmpty() || city.isEmpty() || state.isEmpty() || pincode.isEmpty())
                    return true;
                else if(collegeNameUG.isEmpty() || branchUG.contains("Select") || courseUG.contains("Select") || passUG.isEmpty())
                    return true;
                else if(remark.isEmpty())
                    return true;
                else if(mobile.isEmpty() || email.isEmpty())
                    return true;
                else
                    return false;
            }
        }else{
            if (placed) {
                setPlaced(1);
                remark = null;
                if(firstname.isEmpty() || lastname.isEmpty() || dob.isEmpty() || nationality.isEmpty() || address.isEmpty() || city.isEmpty() || state.isEmpty() || pincode.isEmpty())
                    return true;
                else if(collegeNamePG.isEmpty() || branchPG.isEmpty() || coursePG.isEmpty() || passPG.isEmpty())
                    return true;
                else if(jobmod.isEmpty() || jobmod.get(0).getCompanyName().isEmpty() || jobmod.get(0).getDesignation().isEmpty()|| jobmod.get(0).getDoj().isEmpty())
                    return true;
                else if(mobile.isEmpty() || email.isEmpty())
                    return true;
                else
                    return false;
            } else {
                setPlaced(0);
                companyName = null; 
                designation = null;
                annualPackage = 0.0;
                doj = null;
                location = null;

                if(firstname.isEmpty() || lastname.isEmpty() || dob.isEmpty() || nationality.isEmpty() || address.isEmpty() || city.isEmpty() || state.isEmpty() || pincode.isEmpty())
                    return true;
                else if(collegeNamePG.isEmpty() || branchPG.isEmpty() || coursePG.isEmpty() || passPG.isEmpty())
                    return true;
                else if(remark.isEmpty())
                    return true;
                else if(mobile.isEmpty() || email.isEmpty())
                    return true;
                else
                    return false;
            }
        }
}

/**
 * Returns the name of the tab that contains the fields that are left unfilled.
 * 
 * @param placed Tells whether the student has been placed or not.
 * @return String name of the tab which contains unfilled fields.
 */  
    public String emptyTabName(boolean placed){
        if(educationLevel==0){
            if (placed) {
                setPlaced(1);
                remark = null;
                if(firstname.isEmpty() || lastname.isEmpty() || dob.isEmpty() || nationality.isEmpty() || address.isEmpty() || city.isEmpty() || state.isEmpty() || pincode.isEmpty())
                    return "personal";
                else if(collegeNameUG.isEmpty() || branchUG.contains("Select") || courseUG.isEmpty() || passUG.isEmpty())
                    return "academic";
                else if(jobmod.isEmpty() || jobmod.get(0).getCompanyName().isEmpty() || jobmod.get(0).getDesignation().isEmpty()|| jobmod.get(0).getDoj().isEmpty())
                    return "profession";
                else if(mobile.isEmpty() || email.isEmpty())
                    return "contact";
                else
                    return null;
            } else {
                setPlaced(0);
                companyName = null; 
                designation = null;
                annualPackage = 0.0;
                doj = null;
                location = null;

                if(firstname.isEmpty() || lastname.isEmpty() || dob.isEmpty() || nationality.isEmpty() || address.isEmpty() || city.isEmpty() || state.isEmpty() || pincode.isEmpty())
                    return "personal";
                else if(collegeNameUG.isEmpty() || branchUG.isEmpty() || courseUG.isEmpty() || passUG.isEmpty())
                    return "academic";
                else if(remark.isEmpty())
                    return "profession";
                else if(mobile.isEmpty() || email.isEmpty())
                    return "contact";
                else
                    return null;
            }
        }else{
            if (placed) {
                setPlaced(1);
                remark = null;
                if(firstname.isEmpty() || lastname.isEmpty() || dob.isEmpty() || nationality.isEmpty() || address.isEmpty() || city.isEmpty() || state.isEmpty() || pincode.isEmpty())
                    return "personal";
                else if(collegeNamePG.isEmpty() || branchPG.isEmpty() || coursePG.isEmpty() || passPG.isEmpty())
                    return "academic";
                else if(jobmod.isEmpty() || jobmod.get(0).getCompanyName().isEmpty() || jobmod.get(0).getDesignation().isEmpty()|| jobmod.get(0).getDoj().isEmpty())
                    return "profession";
                else if(mobile.isEmpty() || email.isEmpty())
                    return "contact";
                else
                    return null;
            } else {
                setPlaced(0);
                companyName = null; 
                designation = null;
                annualPackage = 0.0;
                doj = null;
                location = null;

                if(firstname.isEmpty() || lastname.isEmpty() || dob.isEmpty() || nationality.isEmpty() || address.isEmpty() || city.isEmpty() || state.isEmpty() || pincode.isEmpty())
                    return "personal";
                else if(collegeNamePG.isEmpty() || branchPG.isEmpty() || coursePG.isEmpty() || passPG.isEmpty())
                    return "academic";
                else if(remark.isEmpty())
                    return "profession";
                else if(mobile.isEmpty() || email.isEmpty())
                    return "contact";
                else
                    return null;
            }
        }
    }
    
    
//<editor-fold defaultstate="collapsed" desc="Getters and setters">  

    public int getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(int educationLevel) {
        this.educationLevel = educationLevel;
    }
    
    public static void setEditId(int editId){
        AlumniModel.editId = editId;
    }
    
    public static int getEditId(int editId){
        return editId;
    }
    
    public static AlumniModel getEditModel() {
        return editModel;
    }

    public static void setEditModel(AlumniModel editModel) {
        AlumniModel.editModel = editModel;
    }
    
    public List<JobModel> getJobmod() {
        return jobmod;
    }

    public void setJobmod(List<JobModel> jobmod) {
        this.jobmod = jobmod;
    }

    public JobModel getInsertJobmod() {
        return insertJobmod;
    }

    public void setInsertJobmod(JobModel insertJobmod) {
        this.insertJobmod = insertJobmod;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getCollegeNameUG() {
        return collegeNameUG;
    }

    public void setCollegeNameUG(String collegeNameUG) {
        this.collegeNameUG = collegeNameUG;
    }

    public String getBranchUG() {
        return branchUG;
    }

    public void setBranchUG(String branchUG) {
        this.branchUG = branchUG;
    }

    public String getCollegeNamePG() {
        return collegeNamePG;
    }

    public void setCollegeNamePG(String collegeNamePG) {
        this.collegeNamePG = collegeNamePG;
    }

    public String getBranchPG() {
        return branchPG;
    }

    public void setBranchPG(String branchPG) {
        this.branchPG = branchPG;
    }

    public String getPassUG() {
        return passUG;
    }

    public void setPassUG(String passUG) {
        this.passUG = passUG;
    }

    public String getPassPG() {
        return passPG;
    }

    public void setPassPG(String passPG) {
        this.passPG = passPG;
    }

    public int getBatchUG() {
        return batchUG;
    }

    public void setBatchUG(int batchUG) {
        this.batchUG = batchUG;
    }

    public int getBatchPG() {
        return batchPG;
    }

    public void setBatchPG(int batchPG) {
        this.batchPG = batchPG;
    }

    public String getCourseUG() {
        return courseUG;
    }

    public void setCourseUG(String courseUG) {
        this.courseUG = courseUG;
    }
    
    public String getCoursePG(){
        return coursePG;
    }
    
    public void setCoursePG(String coursePG){
        this.coursePG = coursePG;
    }
    
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public double getAnnualPackage() {
        return annualPackage;
    }

    public void setAnnualPackage(double annualPackage) {
        this.annualPackage = annualPackage;
    }

    public String getRemark(){
        return remark;
    }
    
    public void setRemark(String remark){
        this.remark = remark;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline;
    }
    
    public int getPlaced(){
        return placed;
    }
    
    public void setPlaced(int placed){
        this.placed = placed;
    }
 //</editor-fold>
}
