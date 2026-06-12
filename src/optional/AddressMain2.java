package optional;

import optional.model.Address;
import optional.model.User;

import java.util.Optional;

public class AddressMain2 {
    static void main(String[] args) {
        User user1 = new User("user1", null);
        User user2 = new User("user2", new Address("hello street"));

        printStreet(user1);
        printStreet(user2);
    }

    private static void printStreet(User user) {
        Optional<String> userStreet = getUserStreet(user);
        userStreet.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("No user street found")
        );
    }

    static Optional<String> getUserStreet(User user) {
        return Optional.ofNullable(user) // user 가 null일 수 있으므로
                .map(User::getAddress)   // user.getAddress()
                .map(Address::getStreet); // address.getStreet()
        //여기서 map 체이닝 중간에 null이면 Optional.empty()를 반환
    }

}
