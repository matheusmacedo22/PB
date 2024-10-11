package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import controller.CadastrarController;

public class CadastrarView extends JFrame {

    private JTextField nomeField;
    private JTextField emailField;
    private JPasswordField senhaField;
    private JButton cadastrarButton;
    private JButton escolherFotoButton;
    private JLabel fotoLabel;
    private File fotoFile;

    public CadastrarView() {
        super("Cadastrar Usuário");
        
        nomeField = new JTextField(20);
        emailField = new JTextField(20);
        senhaField = new JPasswordField(20);
        cadastrarButton = new JButton("Cadastrar");
        escolherFotoButton = new JButton("Escolher Foto (Opcional)");
        fotoLabel = new JLabel("Nenhuma foto selecionada");

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new JLabel("Nome:"));
        add(nomeField);
        add(new JLabel("Email:"));
        add(emailField);
        add(new JLabel("Senha:"));
        add(senhaField);
        add(escolherFotoButton);
        add(fotoLabel);
        add(cadastrarButton);

        escolherFotoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int option = fileChooser.showOpenDialog(CadastrarView.this);
                if (option == JFileChooser.APPROVE_OPTION) {
                    fotoFile = fileChooser.getSelectedFile();
                    fotoLabel.setText(fotoFile.getName());
                }
            }
        });

        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String email = emailField.getText();
                String senha = new String(senhaField.getPassword());
                String caminhoFoto = (fotoFile != null) ? fotoFile.getAbsolutePath() : null;
                new CadastrarController().cadastrarUsuario(nome, email, senha, caminhoFoto);
            }
        });

        setSize(300, 250);
        setVisible(true);
    }
}
