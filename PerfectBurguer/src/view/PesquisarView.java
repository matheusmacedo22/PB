package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.PesquisarController;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PesquisarView extends JFrame {

    private JTextField emailField;
    private JButton pesquisarButton;

    public PesquisarView() {
        super("Pesquisar Usuário");


        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel emailLabel = new JLabel("Email do usuário:");
        emailField = new JTextField(20);
        pesquisarButton = new JButton("Pesquisar");


        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(emailLabel, gbc);

        gbc.gridx = 1;
        add(emailField, gbc);


        gbc.gridy = 1;
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(pesquisarButton, gbc);


        pesquisarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                new PesquisarController().pesquisarUsuario(email);
            }
        });

        setSize(400, 200);
        setVisible(true);
    }
}
