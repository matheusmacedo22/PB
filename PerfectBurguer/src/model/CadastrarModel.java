package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CadastrarModel {

    public boolean cadastrarUsuario(String nome, String email, String senha, String caminhoFoto) {
        try {
            Connection conexao = MySQLConnectorModel.conectar();
            String sql = "INSERT INTO `db_teste`.`tbl_teste` (`nome`, `email`, `senha`, `foto`) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, email);
            ps.setString(3, senha);

           
            System.out.println("Caminho da foto: " + caminhoFoto);

            if (caminhoFoto != null) {
                byte[] fotoBytes = Files.readAllBytes(Paths.get(caminhoFoto));

            
                System.out.println("Tamanho da foto (bytes): " + fotoBytes.length);

                ps.setBytes(4, fotoBytes);
            } else {
                ps.setNull(4, java.sql.Types.BLOB);
            }

            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace(); 
            return false;
        }
    }
}
