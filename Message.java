import java.util.List;

interface Notifier {
    String name();

    void send(Message m);
}

abstract class BaseNotifier implements Notifier {
    protected void log(Message m) {
        System.out.println("[Log] " + name() + " --> " + m.to() + " (" + m.length() + " chars)");
    }
}

class SmsNotifier extends BaseNotifier {
    @Override
    public String name() {
        return "SMS";
    }

    @Override
    public void send(Message m) {
        if (m.length() > 150) {
            System.out.println("Too long for SMS, Not Sent");
            return;
        }
        log(m);
        System.out.println("Message:[" + m.text() + "] Sent to: " + m.to());
    }
}

class EmailNotifier extends BaseNotifier {
    @Override
    public String name() {
        return "EMAIL";
    }

    @Override
    public void send(Message m) {
        log(m);
        System.out.println("Message:[" + m.text() + "] Sent to: " + m.to());
    }
}

class NotificationService {
    void sendAll(List<Notifier> channels, Message m) {
        for (Notifier n : channels) {
            try {
                n.send(m);
            } catch (Exception e) {
                System.out.println(n.name() + " failed: " + e.getMessage());
            }
        }
    }
}

public class Message {
    private final String to;
    private final String text;

    public Message(String to, String text) {
        if (to == null || to.isBlank())
            throw new IllegalArgumentException("Recipient cannot be blank");
        if (text == null || text.isBlank())
            throw new IllegalArgumentException("Message cannot be blank");
        this.to = to;
        this.text = text;
    }

    String to() {
        return to;
    }

    String text() {
        return text;
    }

    int length() {
        return text.length();
    }

    public static void main(String[] args) {
        Message m = new Message("prathameshsawantsaegd@gmail.com", "Hello World!");

        List<Notifier> channels = List.of(
                new SmsNotifier(),
                new EmailNotifier());

        new NotificationService().sendAll(channels, m);
    }
}