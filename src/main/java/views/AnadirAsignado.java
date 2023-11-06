package views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AnadirAsignado extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel mainPanel;
    private JLabel id_cientif, id_proyec;
    public JTextField id_cientifTextField, id_proyecTextField;
    public JButton guardarButton, cancelarButton;

    public AnadirAsignado() {
        
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

        
        id_cientif = new JLabel("Id cientifico:");
        id_cientifTextField = new JTextField(25);

        id_proyec = new JLabel("Id pyoyecto:");
        id_proyecTextField = new JTextField(25);

        guardarButton = new JButton("Guardar");
        cancelarButton = new JButton("Atras");

        constraints.gridy = 0;
        mainPanel.add(id_cientif, constraints);
        constraints.gridy = 1;
        mainPanel.add(id_proyec, constraints);

        constraints.gridy = 0;
        constraints.gridx = 1;
        constraints.gridwidth = GridBagConstraints.REMAINDER; // Extender por toda la fila
        mainPanel.add(id_cientifTextField, constraints);
        constraints.gridy = 1;
        mainPanel.add(id_proyecTextField, constraints);

        constraints.gridwidth = 1;
        constraints.gridy = 5;
        mainPanel.add(guardarButton, constraints);
        constraints.gridx = 2;
        mainPanel.add(cancelarButton, constraints);

        add(mainPanel);
    }
}
