package library_management.observer;

public class UserNotification implements Observer {

    private String name;

    public UserNotification(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println("Notification for " + name + ": " + message);
    }
}