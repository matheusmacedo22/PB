package controller;
import javax.swing.*;

import model.MySQLConnectorModel;

import java.sql.*;

public class RemoverController extends JFrame {

    public RemoverController() {
        super("Remover Usuário");
        
        String email = JOptionPane.showInputDialog("Digite o email do usuário a ser removido:");
        try {
            Connection conexao = MySQLConnectorModel.conectar();
            String strSql = "DELETE FROM `db_teste`.`tbl_teste` WHERE `email` = '" + email + "';";
            Statement stm = conexao.createStatement();
            int rowsAffected = stm.executeUpdate(strSql);
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Usuário removido com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover usuário: " + e.getMessage());
        }
    }
}
