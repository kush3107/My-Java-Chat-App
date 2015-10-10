import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Kushagra on 10/10/2015.
 */
public class MessageListener extends Thread {

    ServerSocket server;
    int port = 8877;
    WritableGUI gui;
    public MessageListener(WritableGUI gui, int port) {
        this.port = port;
        this.gui = gui;
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public MessageListener() {
        try {
            server = new ServerSocket(port);
            this.gui = gui;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        Socket clientSocket;
        try {
            while((clientSocket = server.accept()) != null) {
                InputStream is = clientSocket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String s = br.readLine();
                if( s != null) {
                    gui.write(s);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
