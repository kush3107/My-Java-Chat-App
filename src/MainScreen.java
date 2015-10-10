import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kushagra on 10/10/2015.
 */
public class MainScreen extends JFrame implements WritableGUI, ActionListener {
    private JButton listenButton;
    private JTextField targetPort;
    private JTextField receivePort;
    private JTextField ipTextField;
    private JTextArea chat;
    private JTextField message;
    private JButton sendButton;
    MessageListener listener;
    private JPanel panel1;

    public MainScreen() {
        super();
        setContentPane(panel1);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        this.listenButton.addActionListener(this);
        this.sendButton.addActionListener(this);

    }


    @Override
    public void write(String s) {
        chat.append(s + System.lineSeparator());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == listenButton) {
            listener = new MessageListener(this, Integer.parseInt(receivePort.getText()));
            listener.start();
        }

        if (e.getSource() == sendButton) {
            MessageTransmitter transmitter = new MessageTransmitter(message.getText(), ipTextField.getText(), Integer.parseInt(targetPort.getText()));
            transmitter.start();
        }

    }
}
