import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class MovieProgram extends JFrame {
	private static JPanel contentPane;
	private Menu_Movie movie = new Menu_Movie();
	private Menu_Theater theater = new Menu_Theater();
	private Menu_Ticketing ticketing = new Menu_Ticketing();
	private static Store store = new Store();
	private MyMenu myMenu = new MyMenu();
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		MovieProgram frame = new MovieProgram();
		extracted(frame);
		
	}

	private static void extracted(MovieProgram frame) {
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(22, 72, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(151, 72, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(280, 72, 117, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(425, 72, 117, 29);
		contentPane.add(btnNewButton_3);
		frame.add(contentPane);
		frame.setVisible(true);
	}
}
