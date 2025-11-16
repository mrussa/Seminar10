package backend.academy.seminar10.examples;

public class ManyArguments {
}


// метод с большим количеством аргументов
class OrderService {
    public void createOrder(String customerName, String customerEmail, String productName,
        int quantity, double price, String deliveryAddress, String deliveryDate) {
        // Логика создания заказа
        System.out.println("Order created for " + customerName);
    }
}

