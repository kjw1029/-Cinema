import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

public class Store extends JFrame {
	private JPanel contentPane;
	private Food food;
	private GifrCard giftCard;
	private static Food popcon = new Food(5000, "팝콘", "M");
	private static Food popcon2 = new Food(6000, "카라멜팝콘", "M");
	private static Food popcon3 = new Food(7000, "치즈팝콘", "M");
	private static Food hotdog = new Food(5000, "핫도그");
	private static Food beverage = new Food(3000, "콜라", "M");
	private static Food beverage2 = new Food(3000, "사이다", "M");
	private static Food beverage3 = new Food(3000, "환타", "M");
	protected static List<Food> menu = new ArrayList<Food>(); // 음식 리스트
	private static GifrCard movies = new GifrCard("영화 관람권", 13000, "2024.12.31", "해운대");
	private static GifrCard movies2 = new GifrCard("영화 관람권", 40000, "2024.12.31", "해운대");
	private static GifrCard movies4D = new GifrCard("4D 관람권", 19000, "2024.12.31", "해운대");
	private static GifrCard rechargeableCard = new GifrCard("충전형 영화 관람권", 50000, "2025.12.31", "서면");
	protected static List<GifrCard> giftCardList = new ArrayList(); // 기프트카드리스트

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Store frame = new Store();
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
	public Store() {
		GUI();
		Scanner scan = new Scanner(System.in);
		menu.add(popcon);
		menu.add(popcon2);
		menu.add(popcon3);
		menu.add(hotdog);
		menu.add(beverage);
		menu.add(beverage2);
		menu.add(beverage3);

		giftCardList.add(movies);
		giftCardList.add(movies2);
		giftCardList.add(movies4D);
		giftCardList.add(rechargeableCard);
	}

	public void GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		JPanel cards = new JPanel(new CardLayout());

		JPanel panel = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 56, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, -36, SpringLayout.EAST, contentPane);
		contentPane.add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		JButton giftcard = new JButton("기프트카드");
		giftcard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) cards.getLayout();
				cardLayout.show(cards, "기프트카드");
			}
		});
		sl_panel.putConstraint(SpringLayout.NORTH, giftcard, 0, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, giftcard, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, giftcard, -9, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, giftcard, 160, SpringLayout.WEST, panel);
		panel.add(giftcard);

		JButton popcon = new JButton("팝콘");
		popcon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) cards.getLayout();
				cardLayout.show(cards, "팝콘");
			}
		});
		sl_panel.putConstraint(SpringLayout.NORTH, popcon, 0, SpringLayout.NORTH, giftcard);
		sl_panel.putConstraint(SpringLayout.WEST, popcon, 5, SpringLayout.EAST, giftcard);
		sl_panel.putConstraint(SpringLayout.SOUTH, popcon, 0, SpringLayout.SOUTH, giftcard);
		sl_panel.putConstraint(SpringLayout.EAST, popcon, 164, SpringLayout.EAST, giftcard);
		panel.add(popcon);

		JButton beverage = new JButton("음료");
		beverage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) cards.getLayout();
				cardLayout.show(cards, "음료");
			}
		});
		sl_panel.putConstraint(SpringLayout.NORTH, beverage, 0, SpringLayout.NORTH, giftcard);
		sl_panel.putConstraint(SpringLayout.WEST, beverage, 6, SpringLayout.EAST, popcon);
		sl_panel.putConstraint(SpringLayout.SOUTH, beverage, -1, SpringLayout.SOUTH, giftcard);
		sl_panel.putConstraint(SpringLayout.EAST, beverage, -33, SpringLayout.EAST, panel);
		panel.add(beverage);

		cards.add(giftcard, "기프트카드");
		cards.add(popcon, "팝콘");
		cards.add(beverage, "음료");
		
		contentPane.add(cards);
	}
}
