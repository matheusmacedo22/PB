package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Blob;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.io.InputStream;

public class PesquisarModel {

    public Object[] pesquisarUsuario(String email) {
        try {
            Connection conexao = MySQLConnectorModel.conectar();
            String sql = "SELECT `nome`, `email`, `foto` FROM `db_teste`.`tbl_teste` WHERE `email` = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String nome = rs.getString("nome");
                String emailRetornado = rs.getString("email");
                Blob fotoBlob = rs.getBlob("foto");

                ImageIcon fotoIcon = null;
                if (fotoBlob != null) {
                    InputStream is = fotoBlob.getBinaryStream();
                    Image foto = new ImageIcon(is.readAllBytes()).getImage();
                    fotoIcon = new ImageIcon(foto.getScaledInstance(100, 100, Image.SCALE_SMOOTH)); // 
                }

                return new Object[]{nome, emailRetornado, fotoIcon}; 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
