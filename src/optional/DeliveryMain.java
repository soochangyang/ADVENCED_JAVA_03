package optional;

import optional.model.Address;
import optional.model.Delivery;
import optional.model.Order;
import optional.model.User;
import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class DeliveryMain {

    static Map<Long, Order> orderRepository  =  new HashMap<>();

    static {
        orderRepository.put(1L, new Order(1L, new Delivery("배송완료", false)));
        orderRepository.put(2L, new Order(2L, new Delivery("배송중", false)));
        orderRepository.put(3L, new Order(3L, new Delivery("배송중", true)));
        orderRepository.put(4L, new Order(4L, null));
    }

    static void main(String[] args) {
        System.out.println("1 = " + getDeliveryStatus(1L));
        System.out.println("2 = " + getDeliveryStatus(2L));
        System.out.println("3 = " + getDeliveryStatus(3L));
        System.out.println("4 = " + getDeliveryStatus(4L));

        List<String> lst1 = new ArrayList<>();
        System.out.println("List IS Empty: " + lst1.isEmpty());

        List<String> lst2 = new ArrayList<>();
        lst2.add("둘레");
        System.out.println("List IS Empty: " + lst2.isEmpty());
    }


    private static String getDeliveryStatus(long orderId) {
        Optional<Order> orderOpt = findOrder(orderId);
        return orderOpt.map(Order::getDelivery)
                .filter(delivery -> !delivery.isCanceled())
                .map(Delivery::getStatus)
                .orElse("배송X");
    }

    static Optional<Order> findOrder(Long orderId) {
        return Optional.ofNullable(orderRepository.get(orderId));
    }


}

