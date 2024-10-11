package controller;

import javax.swing.JOptionPane;
import model.AtualizarModel;
import view.AtualizarView;

public class AtualizarController {

    public void buscarUsuario(String email, AtualizarView view) {
        AtualizarModel model = new AtualizarModel();
        String[] dadosUsuario = model.buscarUsuarioPorEmail(email);

        if (dadosUsuario != null) {
            String nome = dadosUsuario[0];
            String senha = dadosUsuario[1];
            String caminhoFoto = dadosUsuario[2];
            view.mostrarPainelAtualizacao(nome, email, senha, caminhoFoto);
        } else {
            JOptionPane.showMessageDialog(null, "Usuário não encontrado.");
        }
    }

    public void atualizarUsuario(String email, String nome, String senha, String caminhoFoto) {
        AtualizarModel model = new AtualizarModel();
        if (model.atualizarUsuario(email, nome, senha, caminhoFoto)) {
            JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar usuário.");
        }
    }
}
