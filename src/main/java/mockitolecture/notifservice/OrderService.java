package mockitolecture.notifservice;

public class OrderService {

    private NotificationService notificationService;

    //Depencency Injection via Constructor
    OrderService(NotificationService notificationService){
        this.notificationService = notificationService;
    }

    void placeOrder(String product){
        System.out.println("Order placed for: "+ product);
        notificationService.sendNotification("Order placed for: "+product);
    }
}
