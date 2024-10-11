package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.AtualizarController;
import java.io.File;

public class AtualizarView extends JFrame {

    private JTextField emailField;
    private JTextField nomeField;
    private JTextField senhaField;
    private JButton buscarButton;
    private JButton atualizarButton;
    private JButton escolherFotoButton;
    private JButton excluirFotoButton; 
    private JLabel fotoLabel;
    private File fotoFile;

    public AtualizarView() {
        super("Atualizar Usuário");

        emailField = new JTextField(20);
        buscarButton = new JButton("Buscar");

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new JLabel("Digite o e-mail do usuário que deseja atualizar:"));
        add(emailField);
        add(buscarButton);

        buscarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                new AtualizarController().buscarUsuario(email, AtualizarView.this);
            }
        });

        setSize(300, 110);
        setVisible(true);
    }

    public void mostrarPainelAtualizacao(String nome, String email, String senha, String caminhoFoto) {
        getContentPane().removeAll();

        nomeField = new JTextField(nome, 20);
        emailField = new JTextField(email, 20); 
        senhaField = new JTextField(senha, 20);
        atualizarButton = new JButton("Atualizar");
        escolherFotoButton = new JButton("Escolher Foto");
        excluirFotoButton = new JButton("Excluir Foto"); 
        fotoLabel = new JLabel((caminhoFoto != null) ? "Foto atual: " + caminhoFoto : "Nenhuma foto selecionada");

        add(new JLabel("Nome:"));
        add(nomeField);
        add(new JLabel("E-mail:")); 
        add(emailField);
        add(new JLabel("Senha:"));
        add(senhaField);
        add(escolherFotoButton);
        add(fotoLabel);
        add(excluirFotoButton); 
        add(atualizarButton);

        escolherFotoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int option = fileChooser.showOpenDialog(AtualizarView.this);
                if (option == JFileChooser.APPROVE_OPTION) {
                    fotoFile = fileChooser.getSelectedFile();
                    fotoLabel.setText(fotoFile.getName());
                }
            }
        });

        excluirFotoButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                fotoFile = null; 
                fotoLabel.setText("Nenhuma foto selecionada");
            }
        });

        atualizarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String senha = senhaField.getText();
                String caminhoFoto = (fotoFile != null) ? fotoFile.getAbsolutePath() : null;
                new AtualizarController().atualizarUsuario(emailField.getText(), nome, senha, caminhoFoto); 
            }
        });

        revalidate();
        repaint();
        setSize(300, 300);
    }
}
