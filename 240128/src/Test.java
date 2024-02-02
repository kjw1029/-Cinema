import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuItem;

public class Test extends JFrame {

	private JPanel contentPane;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(contentPane, popupMenu);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(68, 108, 187, 143);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("메뉴");
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mnNewMenu_1.setVisible(true);
			}
		});
		mnNewMenu.setBounds(26, 54, 107, 22);
		contentPane.add(mnNewMenu);
		
		mnNewMenu_1 = new JMenu("안녕하세요");
		mnNewMenu.add(mnNewMenu_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		mnNewMenu_1.add(lblNewLabel);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(267, 151, 99, 21);
		contentPane.add(menuBar_1);
		
		JMenuBar menuBar_2 = new JMenuBar();
		menuBar_2.setBounds(156, 54, 99, 21);
		contentPane.add(menuBar_2);
		
		JMenu mnNewMenu_2 = new JMenu("New menu");
		mnNewMenu_2.setBounds(212, 22, 107, 22);
		contentPane.add(mnNewMenu_2);
		
		JPopupMenu popupMenu_1 = new JPopupMenu();
		addPopup(mnNewMenu_2, popupMenu_1);
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem = new JRadioButtonMenuItem("New radio item");
		rdbtnmntmNewRadioItem.setBounds(12, 151, 127, 22);
		contentPane.add(rdbtnmntmNewRadioItem);
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem_1 = new JRadioButtonMenuItem("New radio item");
		rdbtnmntmNewRadioItem_1.setBounds(12, 183, 127, 22);
		contentPane.add(rdbtnmntmNewRadioItem_1);
		JMenuBar jMenuBar = new JMenuBar();
		setJMenuBar(jMenuBar);
		JMenu mnNewMenu_3 = new JMenu("New menu");
//		mnNewMenu_3.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent e) {
//			}
//		});
		jMenuBar.add(mnNewMenu_3);
		mnNewMenu_3.setBounds(0, 0, 107, 22);
//		contentPane.add(mnNewMenu_3);
		
		mntmNewMenuItem = new JMenuItem("ㅇㅇ");
		mntmNewMenuItem.setRolloverEnabled(true);
		mnNewMenu_3.add(mntmNewMenuItem);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
