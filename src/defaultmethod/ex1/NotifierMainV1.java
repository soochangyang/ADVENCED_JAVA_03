package defaultmethod.ex1;

import java.util.List;

public class NotifierMainV1 {

    static void main(String[] args) {
        List<Notifier> notifiers = List.of(new EmailNotifier(),
                new SMSNotifier(),
                new AppPushNotifier());

        notifiers.forEach( n -> {n.notify(" 축하햇");});



    }
}
