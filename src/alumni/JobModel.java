package alumni;

/**
 *
 * @author Spongebob
 */
public class JobModel {
    private String companyName = null, designation = null, location = null, doj = null, dol = null;
    private double annualPackage = -1;
    private int id =-1;

    JobModel(){
        companyName = null;
        designation = null;
        location = null;
        doj = null;
    }
    
    JobModel(int id, String companyName, String designation, String location, String doj, String dol, double annualPackage){
        this.setId(id);
        this.setCompanyName(companyName);
        this.setDesignation(designation);
        this.setDoj(doj);
        this.setDol(dol);
        this.setLocation(location);
        this.setAnnualPackage(annualPackage);
    }
    
    

//<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public void setDol(String dol) {
        this.dol = dol;    
    }
    
    public String getDol() {    
        return dol;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    public double getAnnualPackage() {
        return annualPackage;
    }

    public void setAnnualPackage(double annualPackage) {
        this.annualPackage = annualPackage;
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
    
       
//</editor-fold>
    
}
