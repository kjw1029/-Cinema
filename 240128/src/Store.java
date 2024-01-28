import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;

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

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
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
	        
	        JPanel cards = new JPanel();
	        sl_contentPane.putConstraint(SpringLayout.NORTH, cards, 59, SpringLayout.NORTH, contentPane);
	        sl_contentPane.putConstraint(SpringLayout.WEST, cards, 39, SpringLayout.WEST, contentPane);
	        sl_contentPane.putConstraint(SpringLayout.SOUTH, cards, -42, SpringLayout.SOUTH, contentPane);
	        sl_contentPane.putConstraint(SpringLayout.EAST, cards, -122, SpringLayout.EAST, contentPane);
	        CardLayout cardLayout = new CardLayout();
	        cards.setLayout(cardLayout);
	        contentPane.add(cards);
	        
	        JPanel giftCard = new JPanel();
	        cards.add(giftCard, "카드");
	        
	        JPanel popcon = new JPanel();
	        cards.add(popcon, "팝콘");
	        SpringLayout sl_popcon = new SpringLayout();
	        popcon.setLayout(sl_popcon);
	        
	        JButton btnNewButton = new JButton(new ImageIcon ("이미지/고소.png"));
	        sl_popcon.putConstraint(SpringLayout.NORTH, btnNewButton, 21, SpringLayout.NORTH, popcon);
	        popcon.add(btnNewButton);
	        
	        JButton btnNewButton_1 = new JButton(new ImageIcon ("이미지/달콤.png"));
	        sl_popcon.putConstraint(SpringLayout.NORTH, btnNewButton_1, 21, SpringLayout.NORTH, popcon);
	        sl_popcon.putConstraint(SpringLayout.WEST, btnNewButton_1, 3, SpringLayout.EAST, btnNewButton);
	        sl_popcon.putConstraint(SpringLayout.SOUTH, btnNewButton_1, 0, SpringLayout.SOUTH, btnNewButton);
	        popcon.add(btnNewButton_1);
	        
	        JButton btnNewButton_2 = new JButton(new ImageIcon ("이미지/치즈.png"));
	        sl_popcon.putConstraint(SpringLayout.EAST, btnNewButton_1, -6, SpringLayout.WEST, btnNewButton_2);
	        sl_popcon.putConstraint(SpringLayout.SOUTH, btnNewButton_2, 0, SpringLayout.SOUTH, btnNewButton);
	        sl_popcon.putConstraint(SpringLayout.NORTH, btnNewButton_2, 21, SpringLayout.NORTH, popcon);
	        popcon.add(btnNewButton_2);
	        
	        JButton btnNewButton_3 = new JButton("New button");
	        sl_popcon.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, btnNewButton_3);
	        sl_popcon.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, btnNewButton_3);
	        sl_popcon.putConstraint(SpringLayout.WEST, btnNewButton_3, 10, SpringLayout.WEST, popcon);
	        popcon.add(btnNewButton_3);
	        
	        JLabel lblNewLabel = new JLabel("고소");
	        sl_popcon.putConstraint(SpringLayout.SOUTH, btnNewButton, -1, SpringLayout.NORTH, lblNewLabel);
	        sl_popcon.putConstraint(SpringLayout.NORTH, lblNewLabel, 151, SpringLayout.NORTH, popcon);
	        sl_popcon.putConstraint(SpringLayout.NORTH, btnNewButton_3, 65, SpringLayout.SOUTH, lblNewLabel);
	        sl_popcon.putConstraint(SpringLayout.WEST, lblNewLabel, 29, SpringLayout.WEST, popcon);
	        popcon.add(lblNewLabel);
	        
	        JLabel lblNewLabel_1 = new JLabel("달콤");
	        sl_popcon.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 151, SpringLayout.NORTH, popcon);
	        sl_popcon.putConstraint(SpringLayout.WEST, lblNewLabel_1, 65, SpringLayout.EAST, lblNewLabel);
	        popcon.add(lblNewLabel_1);
	        
	        JLabel lblNewLabel_2 = new JLabel("치즈");
	        sl_popcon.putConstraint(SpringLayout.WEST, btnNewButton_2, -19, SpringLayout.WEST, lblNewLabel_2);
	        sl_popcon.putConstraint(SpringLayout.EAST, btnNewButton_2, 37, SpringLayout.EAST, lblNewLabel_2);
	        sl_popcon.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 0, SpringLayout.NORTH, lblNewLabel);
	        sl_popcon.putConstraint(SpringLayout.WEST, lblNewLabel_2, 77, SpringLayout.EAST, lblNewLabel_1);
	        popcon.add(lblNewLabel_2);
	        
	        JLabel lblNewLabel_3 = new JLabel("New label");
	        sl_popcon.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 362, SpringLayout.NORTH, popcon);
	        sl_popcon.putConstraint(SpringLayout.SOUTH, btnNewButton_3, -36, SpringLayout.NORTH, lblNewLabel_3);
	        sl_popcon.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblNewLabel);
	        popcon.add(lblNewLabel_3);
	        
	        JPanel beverage = new JPanel();
	        cards.add(beverage, "음료");
	        SpringLayout sl_beverage = new SpringLayout();
	        beverage.setLayout(sl_beverage);
	        
	        JButton btnNewButton_4 = new JButton(new ImageIcon ("이미지/콜라.png"));
	        sl_beverage.putConstraint(SpringLayout.NORTH, btnNewButton_4, 20, SpringLayout.NORTH, beverage);
	        sl_beverage.putConstraint(SpringLayout.WEST, btnNewButton_4, 35, SpringLayout.WEST, beverage);
	        sl_beverage.putConstraint(SpringLayout.SOUTH, btnNewButton_4, 157, SpringLayout.NORTH, beverage);
	        sl_beverage.putConstraint(SpringLayout.EAST, btnNewButton_4, 130, SpringLayout.WEST, beverage);
	        beverage.add(btnNewButton_4);
	        
	        JButton button = new JButton(new ImageIcon ("이미지/커피.png"));
	        sl_beverage.putConstraint(SpringLayout.NORTH, button, 0, SpringLayout.NORTH, btnNewButton_4);
	        sl_beverage.putConstraint(SpringLayout.WEST, button, 24, SpringLayout.EAST, btnNewButton_4);
	        sl_beverage.putConstraint(SpringLayout.SOUTH, button, 0, SpringLayout.SOUTH, btnNewButton_4);
	        beverage.add(button);
	        
	        JButton button_1 = new JButton(new ImageIcon ("이미지/에이드.png"));
	        sl_beverage.putConstraint(SpringLayout.NORTH, button_1, 0, SpringLayout.NORTH, btnNewButton_4);
	        sl_beverage.putConstraint(SpringLayout.WEST, button_1, 155, SpringLayout.EAST, btnNewButton_4);
	        sl_beverage.putConstraint(SpringLayout.SOUTH, button_1, 0, SpringLayout.SOUTH, btnNewButton_4);
	        sl_beverage.putConstraint(SpringLayout.EAST, button_1, -35, SpringLayout.EAST, beverage);
	        beverage.add(button_1);
	        
	        JLabel lblNewLabel_4 = new JLabel("콜라");
	        sl_beverage.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 33, SpringLayout.SOUTH, btnNewButton_4);
	        sl_beverage.putConstraint(SpringLayout.WEST, lblNewLabel_4, 56, SpringLayout.WEST, beverage);
	        beverage.add(lblNewLabel_4);
	        
	        JLabel lblNewLabel_5 = new JLabel("커피");
	        sl_beverage.putConstraint(SpringLayout.EAST, button, 74, SpringLayout.EAST, lblNewLabel_5);
	        sl_beverage.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 0, SpringLayout.NORTH, lblNewLabel_4);
	        sl_beverage.putConstraint(SpringLayout.WEST, lblNewLabel_5, 71, SpringLayout.EAST, lblNewLabel_4);
	        beverage.add(lblNewLabel_5);
	        
	        JLabel lblNewLabel_6 = new JLabel("에이드");
	        sl_beverage.putConstraint(SpringLayout.SOUTH, lblNewLabel_6, 0, SpringLayout.SOUTH, lblNewLabel_4);
	        sl_beverage.putConstraint(SpringLayout.EAST, lblNewLabel_6, -59, SpringLayout.EAST, beverage);
	        beverage.add(lblNewLabel_6);
	        
	        JButton btncard = new JButton("카드");
	        sl_contentPane.putConstraint(SpringLayout.NORTH, btncard, 5, SpringLayout.NORTH, contentPane);
	        sl_contentPane.putConstraint(SpringLayout.WEST, btncard, 22, SpringLayout.WEST, contentPane);
	        sl_contentPane.putConstraint(SpringLayout.SOUTH, btncard, -9, SpringLayout.NORTH, cards);
	        sl_contentPane.putConstraint(SpringLayout.EAST, btncard, 117, SpringLayout.WEST, contentPane);
	        contentPane.add(btncard);
	        btncard.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					cardLayout.show(cards, "카드");
				}
			});
	        
	        JButton btnPopcon = new JButton("팝콘");
	        sl_contentPane.putConstraint(SpringLayout.NORTH, btnPopcon, 8, SpringLayout.NORTH, contentPane);
	        sl_contentPane.putConstraint(SpringLayout.WEST, btnPopcon, 39, SpringLayout.EAST, btncard);
	        sl_contentPane.putConstraint(SpringLayout.SOUTH, btnPopcon, -6, SpringLayout.NORTH, cards);
	        sl_contentPane.putConstraint(SpringLayout.EAST, btnPopcon, -330, SpringLayout.EAST, contentPane);
	        contentPane.add(btnPopcon);
	        btnPopcon.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					cardLayout.show(cards, "팝콘");
				}
			});
	        
	        JButton btnbeverage = new JButton("음료");
	        sl_contentPane.putConstraint(SpringLayout.NORTH, btnbeverage, 1, SpringLayout.NORTH, btncard);
	        sl_contentPane.putConstraint(SpringLayout.WEST, btnbeverage, 36, SpringLayout.EAST, btnPopcon);
	        sl_contentPane.putConstraint(SpringLayout.SOUTH, btnbeverage, -10, SpringLayout.NORTH, cards);
	        sl_contentPane.putConstraint(SpringLayout.EAST, btnbeverage, -199, SpringLayout.EAST, contentPane);
	        contentPane.add(btnbeverage);
	        btnbeverage.addActionListener(new ActionListener() {
	        	@Override
	        	public void actionPerformed(ActionEvent e) {
	        		cardLayout.show(cards, "음료");
	        	}
	        });
	        
	        JButton btnNewButton_5 = new JButton("장바구니");
	        sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_5, 1, SpringLayout.NORTH, btncard);
	        sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_5, -127, SpringLayout.EAST, contentPane);
	        sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton_5, -10, SpringLayout.NORTH, cards);
	        contentPane.add(btnNewButton_5);
	        btnNewButton_5.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					cardLayout.show(cards, "장바구니");
				}
			});

	        JPanel panel = new JPanel();
	        cards.add(panel, "장바구니");
	        sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_5, -32, SpringLayout.EAST, contentPane);
	        
	        
	    }
	}