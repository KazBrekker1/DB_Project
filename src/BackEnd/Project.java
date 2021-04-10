package BackEnd;

public class Project {
    private String pName;
    private String description;
    private String dName;

    public Project() {

    }

    public Project(String pName, String description, String dName) {
        this.pName = pName;
        this.description = description;
        this.dName = dName;
    }

    public String getPName() {
        return pName;
    }

    public void setPName(String pName) {
        this.pName = pName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDName() {
        return dName;
    }

    public void setDName(String dName) {
        this.dName = dName;
    }
}
