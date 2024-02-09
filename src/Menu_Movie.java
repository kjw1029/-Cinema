import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.GridLayout;

public class Menu_Movie extends JPanel {
    public Menu_Movie() {
        setLayout(new BorderLayout()); 

        JButton btnNewButton_2 = new JButton("이전");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MovieProgram.cardLayout.show(MovieProgram.pnlMain, "panel1");
            }
        });
        add(btnNewButton_2, BorderLayout.NORTH); 

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));
        JPanel pnl1 = new JPanel();
        pnl1.setLayout(new BorderLayout());
        panel.add(pnl1);
        MoviesPhotoPanel moviesPhotoPanel = new MoviesPhotoPanel(50, "sp", 120, 160);
        pnl1.add(moviesPhotoPanel, BorderLayout.CENTER);
        
        JLabel label = new JLabel("");
        label.setPreferredSize(new Dimension(100, 30)); 
        pnl1.add(label, BorderLayout.NORTH);
        
        JLabel lblNewLabel = new JLabel("");
        pnl1.add(lblNewLabel, BorderLayout.SOUTH);
        lblNewLabel.setSize(500, 10);
        
        JLabel lblNewLabel_1 = new JLabel("New label3");
        pnl1.add(lblNewLabel_1, BorderLayout.WEST);
       JLabel lbl = new JLabel("dfs");
       lbl.setSize(500, 100);
       pnl1.add(lbl, BorderLayout.EAST);
       
       JLabel lbl2 = new JLabel("dfs");
       lbl2.setSize(500, 10);
       pnl1.add(lbl2, BorderLayout.WEST);
        MoviesPhotoPanel moviesPhotoPanel2 = new MoviesPhotoPanel(50, "sp", 120, 160);
        panel.add(moviesPhotoPanel2);
        MoviesPhotoPanel moviesPhotoPanel3 = new MoviesPhotoPanel(50, "sp", 120, 160);
        panel.add(moviesPhotoPanel3);
        MoviesPhotoPanel moviesPhotoPanel4 = new MoviesPhotoPanel(50, "sp", 120, 160);
        panel.add(moviesPhotoPanel4);
        
        // JPanel을 JScrollPane에 설정합니다.
        JScrollPane scrollPane = new JScrollPane(panel);
        add(scrollPane, BorderLayout.CENTER);

        if (!MovieProgram.pnl.lblNewLabel_3.getText().equals("로그인 해주세요")) {
            int length = MovieProgram.pnl.lblNewLabel_3.getText().length();
            System.out.println(MovieProgram.pnl.lblNewLabel_3.getText().substring(0, length - 7));
        } else {
            System.out.println("비회원");
        }
    }
}
