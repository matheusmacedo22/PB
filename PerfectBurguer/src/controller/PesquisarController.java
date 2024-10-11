package controller;

import javax.swing.*;
import model.PesquisarModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PesquisarController {

    public void pesquisarUsuario(String email) {
        PesquisarModel model = new PesquisarModel();
        Object[] resultado = model.pesquisarUsuario(email); 

        if (resultado != null) {
            String nome = (String) resultado[0];
            String emailRetornado = (String) resultado[1];
            ImageIcon fotoIcon = (ImageIcon) resultado[2];

            JPanel painelResultado = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10);

        
            JLabel nomeLabel = new JLabel("Nome: " + nome);
            gbc.gridx = 0;
            gbc.gridy = 0;
            painelResultado.add(nomeLabel, gbc);

            JLabel emailLabel = new JLabel("Email: " + emailRetornado);
            gbc.gridy = 1;
            painelResultado.add(emailLabel, gbc);

            if (fotoIcon != null) {
                JLabel fotoLabel = new JLabel(fotoIcon);
                gbc.gridy = 2;
                painelResultado.add(fotoLabel, gbc);
            } else {
                JLabel fotoLabel = new JLabel("Foto: Não disponível");
                gbc.gridy = 2;
                painelResultado.add(fotoLabel, gbc);
            }

           
            JOptionPane.showMessageDialog(null, painelResultado, "Informações do Usuário", JOptionPane.PLAIN_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "Usuário não encontrado.");
        }
    }
}
