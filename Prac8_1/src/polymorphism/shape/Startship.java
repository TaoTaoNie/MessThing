package polymorphism.shape;

public class Startship {
    private AlertStatus alertStatus = new GreenAlertStatus();

    public void setStatus(AlertStatus status) {
        alertStatus = status;
    }

    public String toString() {return alertStatus.getStatus();}
}
