import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements IReceive{

    private JButton button;
    public JTextArea output;
    public JTextField input;
    Server server = new Server();
    public GUI(String user) {
        super();
        //Setting Components up
        button = new JButton("Send");
        output = new JTextArea();
        input = new JTextField("Enter message here");
        JScrollPane pane = new JScrollPane(output);
        Panel top = new Panel();
        Panel bottom = new Panel();
        output.setEditable(false);


        //Initializing settings for output area and top pane
        output.setLineWrap(true);
        output.setSize(new Dimension(400,250));
        pane.setPreferredSize(new Dimension(400, 250));
        top.add(pane);
        top.setPreferredSize(new Dimension(300,250));

        //Sets up bottom pane and positions its components. Also creates listener for button.
        bottom.setLayout(new GridLayout(1,2));
        bottom.add(input);
        bottom.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.send(output.getText(), user, input.getText());
                input.setText("Enter message here");
            }
        });

        //Adds both panes to the frame
        add(top, BorderLayout.NORTH);
        add(bottom, BorderLayout.CENTER);

        //Finalizes view options for window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(user);
        setSize(400, 300);
        setVisible(true);
    }

    @Override
    public void receive(String message) {
        output.setText(message);
    }
}