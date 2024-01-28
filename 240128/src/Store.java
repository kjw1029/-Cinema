import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
