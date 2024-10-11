package view;
import javax.swing.*;
import controller.*;

public class MenuFrameView extends JFrame {

    public MenuFrameView() {
        super("Perfect Burguer🍔");


        JMenu usuarioMenu = new JMenu("Usuários");


        JMenuItem cadastrarMenu = new JMenuItem("Cadastrar");
        JMenuItem pesquisarMenu = new JMenuItem("Pesquisar");
        JMenuItem atualizarMenu = new JMenuItem("Atualizar");
        JMenuItem removerMenu = new JMenuItem("Remover");


        usuarioMenu.add(cadastrarMenu);
        usuarioMenu.add(pesquisarMenu);
        usuarioMenu.add(atualizarMenu);
        usuarioMenu.add(removerMenu);


        cadastrarMenu.addActionListener(event -> new CadastrarView());
        pesquisarMenu.addActionListener(event -> new PesquisarView());
        atualizarMenu.addActionListener(event -> new AtualizarView());
        removerMenu.addActionListener(event -> new RemoverController());


        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
        bar.add(usuarioMenu);

        Icon logoPerfectBurguer = new ImageIcon(getClass().getResource("logo-perfect-burguer.jpg"));
        add(new JLabel(logoPerfectBurguer));


        setSize(500, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MenuFrameView().setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
