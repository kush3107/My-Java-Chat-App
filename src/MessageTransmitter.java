import java.io.IOException;
import java.net.Socket;

/**
 * Created by Kushagra on 10/10/2015.
 */
public class MessageTransmitter extends Thread {
    String message, hostname;
    int port;

    public MessageTransmitter() {

    }

    public MessageTransmitter(String message, String hostname, int port) {
        this.message = message;
        this.hostname = hostname;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            Socket s = new Socket(hostname, port);
            s.getOutputStream().write(message.getBytes());
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
