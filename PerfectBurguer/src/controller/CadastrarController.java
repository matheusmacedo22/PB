package controller;

import javax.swing.JOptionPane;
import model.CadastrarModel;

public class CadastrarController {

    public void cadastrarUsuario(String nome, String email, String senha, String caminhoFoto) {
        CadastrarModel model = new CadastrarModel();
        if (model.cadastrarUsuario(nome, email, senha, caminhoFoto)) {
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário.");
        }
    }
}
