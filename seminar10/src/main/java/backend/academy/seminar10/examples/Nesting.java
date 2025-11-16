package backend.academy.seminar10.examples;

import java.util.List;
import lombok.Data;

public class Nesting {
}

// Глубокая вложенность
class DiscountCalculator {
    public double calculateDiscount(User user, List<Item> items) {
        if (user != null) {
            if (user.isActive()) {
                if (!items.isEmpty()) {
                    double total = 0;
                    for (Item item : items) {
                        if (item.isEligibleForDiscount()) {
                            if (item.getPrice() > 100) {
                                total += item.getPrice() * 0.1;
                            } else {
                                total += item.getPrice() * 0.05;
                            }
                        }
                    }
                    return total;
                } else {
                    System.out.println("Корзина пуста");
                }
            } else {
                System.out.println("Пользователь не активен");
            }
        } else {
            System.out.println("Пользователь не найден");
        }
        return 0;
    }
}

// Вспомогательные POJO

@Data
class User {
    private boolean active;
}

@Data
class Item {
    private boolean eligibleForDiscount;
    private double price;

}
