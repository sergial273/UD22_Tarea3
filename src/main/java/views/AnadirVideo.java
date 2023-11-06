package views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AnadirVideo extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel mainPanel;
    private JLabel tituloLabel, directorLabel;
    public JTextField tituloTextField, directorTextField;
    public JButton guardarButton, cancelarButton;

    public AnadirVideo() {
        
        setSize(450, 350);

        
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets.left = 10;
        constraints.insets.right = 10;
        constraints.insets.top = 5;
        constraints.insets.bottom = 5;

        
        tituloLabel = new JLabel("Nombre:");
        tituloTextField = new JTextField(25);

        directorLabel = new JLabel("Horas:");
        directorTextField = new JTextField(25);

        guardarButton = new JButton("Guardar");
        cancelarButton = new JButton("Atras");

        constraints.gridy = 0;
        mainPanel.add(tituloLabel, constraints);
        constraints.gridy = 1;
        mainPanel.add(directorLabel, constraints);

        constraints.gridy = 0;
        constraints.gridx = 1;
        constraints.gridwidth = GridBagConstraints.REMAINDER; // Extender por toda la fila
        mainPanel.add(tituloTextField, constraints);
        constraints.gridy = 1;
        mainPanel.add(directorTextField, constraints);

        constraints.gridwidth = 1;
        constraints.gridy = 5;
        mainPanel.add(guardarButton, constraints);
        constraints.gridx = 2;
        mainPanel.add(cancelarButton, constraints);

        add(mainPanel);
    }
}