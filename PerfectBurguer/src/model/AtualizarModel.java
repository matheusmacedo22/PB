package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AtualizarModel {

    public String[] buscarUsuarioPorEmail(String email) {
        try {
            Connection conexao = MySQLConnectorModel.conectar();
            String sql = "SELECT nome, senha, foto FROM `db_teste`.`tbl_teste` WHERE email = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String nome = rs.getString("nome");
                String senha = rs.getString("senha");
                byte[] fotoBytes = rs.getBytes("foto");
                String caminhoFoto = (fotoBytes != null) ? "Foto existente" : null; 
                return new String[]{nome, senha, caminhoFoto};
            } else {
                return null; 
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean atualizarUsuario(String email, String nome, String senha, String caminhoFoto) {
        try {
            Connection conexao = MySQLConnectorModel.conectar();
            String sql = "UPDATE `db_teste`.`tbl_teste` SET nome = ?, senha = ?, email = ?, foto = ? WHERE email = ?"; 
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, senha);
            ps.setString(3, email); 

            if (caminhoFoto != null) {
                byte[] fotoBytes = Files.readAllBytes(Paths.get(caminhoFoto));
                ps.setBytes(4, fotoBytes);
            } else {
                ps.setNull(4, java.sql.Types.BLOB);
            }

            ps.setString(5, email); 
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
