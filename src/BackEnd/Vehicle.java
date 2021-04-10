package BackEnd;

public class Vehicle {
    private String owner;
    private String model;
    private String nextMaint;

    public Vehicle() {
    }

    public Vehicle(String owner, String model, String nextMaint) {
        this.owner = owner;
        this.model = model;
        this.nextMaint = nextMaint;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNextMaint() {
        return nextMaint;
    }

    public void setNextMaint(String nextMaint) {
        this.nextMaint = nextMaint;
    }
}
