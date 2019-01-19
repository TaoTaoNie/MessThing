package polymorphism.shape;

public class E16_Start {
    public static void main(String[] args) {
        Startship eprise = new Startship();
        System.out.println(eprise);
        eprise.setStatus(new YellowAlertStatus());
        System.out.println(eprise);
        eprise.setStatus(new RedAlertStatus());
        System.out.println(eprise);
    }
}
