import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

public class Store extends JFrame {
	private JPanel contentPane;
	private Food food;
	private GiftCard giftCard;
	private Food popcorn = new Food(5000, "고소", "M");
	private Food popcorn2 = new Food(6000, "달콤", "M");
	private Food popcorn3 = new Food(7000, "치즈", "M");
	private Food hotdog = new Food(5000, "핫도그");
	private Food beverage = new Food(3000, "콜라", "M");
	private Food beverage2 = new Food(3000, "커피", "M");
	private Food beverage3 = new Food(3000, "에이드", "M");
	protected static List<Food> menu = new ArrayList<Food>(); // 음식 리스트
	private GiftCard movies = new GiftCard("영화 관람권", 13000, "2024.12.31", "해운대");
	private GiftCard movies2 = new GiftCard("영화 관람권", 40000, "2024.12.31", "해운대");
	private GiftCard movies4D = new GiftCard("4D 관람권", 19000, "2024.12.31", "해운대");
	private GiftCard rechargeableCard = new GiftCard("충전형 영화 관람권", 50000, "2025.12.31", "서면");
	protected static List<GiftCard> giftCardList = new ArrayList(); // 기프트카드리스트
	private static Map<JButton, Integer> count = new HashMap<>(); // 구매목록 장바구니에서 카운트
	private JButton btnSavoryPopcorn;
	private JButton btnSweetPopcorn;
	private JButton btnCheesePopcorn;
	private JButton btnNewButton_3;
	private JButton btncola;
	private JButton btnCoffee;
	private JButton btnAde;
	private static int amount;
	private JLabel lblNewLabel;
	private Map<Integer, JLabel> shoppingBasketJLabel = new HashMap<>();
	private Map<Integer, JButton> shoppingBasketJButton = new HashMap<>();
	private Map<Integer, JPanel> shoppingBasketJPanel = new HashMap<>();
	private Set<String> createdItems = new HashSet<>(); // 테스트
	private int i;
	private JPanel shoppingBasket;

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
		Scanner scan = new Scanner(System.in);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GUI();
		menu.add(popcorn);
		menu.add(popcorn2);
		menu.add(popcorn3);
		menu.add(hotdog);
		menu.add(beverage);
		menu.add(beverage2);
		menu.add(beverage3);

		giftCardList.add(movies);
		giftCardList.add(movies2);
		giftCardList.add(movies4D);
		giftCardList.add(rechargeableCard);

		count.put(btnSavoryPopcorn, 0);
		count.put(btnSweetPopcorn, 0);
		count.put(btnCheesePopcorn, 0);
		count.put(btnNewButton_3, 0);
		count.put(btncola, 0);
		count.put(btnCoffee, 0);
		count.put(btnAde, 0);

	}

	public void GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		// 카드레이아웃 패널
		JPanel cards = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, cards, 59, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, cards, 39, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, cards, -42, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, cards, -122, SpringLayout.EAST, contentPane);
		CardLayout cardLayout = new CardLayout();
		cards.setLayout(cardLayout);
		contentPane.add(cards);

		// 기프트카드 패널
		JPanel giftCard = new JPanel();
		cards.add(giftCard, "카드");
		SpringLayout sl_giftCard = new SpringLayout();
		giftCard.setLayout(sl_giftCard);

		// 팝콘 패널
		JPanel popcorn = new JPanel();
		cards.add(popcorn, "팝콘");
		SpringLayout sl_popcon = new SpringLayout();
		popcorn.setLayout(sl_popcon);

		// 고소팝콘 구매버튼
		btnSavoryPopcorn = new JButton("고소", new ImageIcon("이미지/고소.png"));
		sl_popcon.putConstraint(SpringLayout.NORTH, btnSavoryPopcorn, 21, SpringLayout.NORTH, popcorn);
		popcorn.add(btnSavoryPopcorn);
		listener(btnSavoryPopcorn); // 액션리스너 메소드

		// 달콤팝콘 구매버튼
		btnSweetPopcorn = new JButton("달콤", new ImageIcon("이미지/달콤.png"));
		sl_popcon.putConstraint(SpringLayout.NORTH, btnSweetPopcorn, 21, SpringLayout.NORTH, popcorn);
		sl_popcon.putConstraint(SpringLayout.WEST, btnSweetPopcorn, 3, SpringLayout.EAST, btnSavoryPopcorn);
		sl_popcon.putConstraint(SpringLayout.SOUTH, btnSweetPopcorn, 0, SpringLayout.SOUTH, btnSavoryPopcorn);
		popcorn.add(btnSweetPopcorn);
		listener(btnSweetPopcorn);// 액션리스너 메소드

		// 치즈팝콘 구매 버튼
		btnCheesePopcorn = new JButton("치즈", new ImageIcon("이미지/치즈.png"));
		sl_popcon.putConstraint(SpringLayout.EAST, btnSweetPopcorn, -6, SpringLayout.WEST, btnCheesePopcorn);
		sl_popcon.putConstraint(SpringLayout.SOUTH, btnCheesePopcorn, 0, SpringLayout.SOUTH, btnSavoryPopcorn);
		sl_popcon.putConstraint(SpringLayout.NORTH, btnCheesePopcorn, 21, SpringLayout.NORTH, popcorn);
		popcorn.add(btnCheesePopcorn);
		listener(btnCheesePopcorn);// 액션리스너 메소드

		// 핫도그 추가예정??
		btnNewButton_3 = new JButton("New button");
		sl_popcon.putConstraint(SpringLayout.WEST, btnSavoryPopcorn, 0, SpringLayout.WEST, btnNewButton_3);
		sl_popcon.putConstraint(SpringLayout.EAST, btnSavoryPopcorn, 0, SpringLayout.EAST, btnNewButton_3);
		sl_popcon.putConstraint(SpringLayout.WEST, btnNewButton_3, 10, SpringLayout.WEST, popcorn);
		popcorn.add(btnNewButton_3);

		// 고소팝콘라벨
		JLabel lblSavoryPopcorn = new JLabel("고소");
		sl_popcon.putConstraint(SpringLayout.SOUTH, btnSavoryPopcorn, -1, SpringLayout.NORTH, lblSavoryPopcorn);
		sl_popcon.putConstraint(SpringLayout.NORTH, lblSavoryPopcorn, 151, SpringLayout.NORTH, popcorn);
		sl_popcon.putConstraint(SpringLayout.NORTH, btnNewButton_3, 65, SpringLayout.SOUTH, lblSavoryPopcorn);
		sl_popcon.putConstraint(SpringLayout.WEST, lblSavoryPopcorn, 29, SpringLayout.WEST, popcorn);
		popcorn.add(lblSavoryPopcorn);

		// 달콜팝콘 라벨
		JLabel lblSweetPopcorn = new JLabel("달콤");
		sl_popcon.putConstraint(SpringLayout.NORTH, lblSweetPopcorn, 151, SpringLayout.NORTH, popcorn);
		sl_popcon.putConstraint(SpringLayout.WEST, lblSweetPopcorn, 65, SpringLayout.EAST, lblSavoryPopcorn);
		popcorn.add(lblSweetPopcorn);

		// 치즈팝콘 라벨
		JLabel lblCheesePopcorn = new JLabel("치즈");
		sl_popcon.putConstraint(SpringLayout.WEST, btnCheesePopcorn, -19, SpringLayout.WEST, lblCheesePopcorn);
		sl_popcon.putConstraint(SpringLayout.EAST, btnCheesePopcorn, 37, SpringLayout.EAST, lblCheesePopcorn);
		sl_popcon.putConstraint(SpringLayout.NORTH, lblCheesePopcorn, 0, SpringLayout.NORTH, lblSavoryPopcorn);
		sl_popcon.putConstraint(SpringLayout.WEST, lblCheesePopcorn, 77, SpringLayout.EAST, lblSweetPopcorn);
		popcorn.add(lblCheesePopcorn);

		JLabel lblNewLabel_3 = new JLabel("New label");
		sl_popcon.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 362, SpringLayout.NORTH, popcorn);
		sl_popcon.putConstraint(SpringLayout.SOUTH, btnNewButton_3, -36, SpringLayout.NORTH, lblNewLabel_3);
		sl_popcon.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblSavoryPopcorn);
		popcorn.add(lblNewLabel_3);

		// 음료 패널
		JPanel beverage = new JPanel();
		cards.add(beverage, "음료");
		SpringLayout sl_beverage = new SpringLayout();
		beverage.setLayout(sl_beverage);

		// 콜라 구매 버튼
		btncola = new JButton("콜라", new ImageIcon("이미지/콜라.png"));
		sl_beverage.putConstraint(SpringLayout.NORTH, btncola, 20, SpringLayout.NORTH, beverage);
		sl_beverage.putConstraint(SpringLayout.WEST, btncola, 35, SpringLayout.WEST, beverage);
		sl_beverage.putConstraint(SpringLayout.SOUTH, btncola, 157, SpringLayout.NORTH, beverage);
		sl_beverage.putConstraint(SpringLayout.EAST, btncola, 130, SpringLayout.WEST, beverage);
		beverage.add(btncola);
		listener(btncola);// 액션리스너 메소드

		// 커피 구매 버튼
		btnCoffee = new JButton("커피", new ImageIcon("이미지/커피.png"));
		sl_beverage.putConstraint(SpringLayout.NORTH, btnCoffee, 0, SpringLayout.NORTH, btncola);
		sl_beverage.putConstraint(SpringLayout.WEST, btnCoffee, 24, SpringLayout.EAST, btncola);
		sl_beverage.putConstraint(SpringLayout.SOUTH, btnCoffee, 0, SpringLayout.SOUTH, btncola);
		beverage.add(btnCoffee);
		listener(btnCoffee);// 액션리스너 메소드

		// 에이드 구매 버튼
		btnAde = new JButton("에이드", new ImageIcon("이미지/에이드.png"));
		sl_beverage.putConstraint(SpringLayout.NORTH, btnAde, 0, SpringLayout.NORTH, btncola);
		sl_beverage.putConstraint(SpringLayout.WEST, btnAde, 155, SpringLayout.EAST, btncola);
		sl_beverage.putConstraint(SpringLayout.SOUTH, btnAde, 0, SpringLayout.SOUTH, btncola);
		sl_beverage.putConstraint(SpringLayout.EAST, btnAde, -35, SpringLayout.EAST, beverage);
		beverage.add(btnAde);
		listener(btnAde);// 액션리스너 메소드

		// 콜라 라벨
		JLabel lblCola = new JLabel("콜라");
		sl_beverage.putConstraint(SpringLayout.NORTH, lblCola, 33, SpringLayout.SOUTH, btncola);
		sl_beverage.putConstraint(SpringLayout.WEST, lblCola, 56, SpringLayout.WEST, beverage);
		beverage.add(lblCola);

		// 커피 라벨
		JLabel lblCoffee = new JLabel("커피");
		sl_beverage.putConstraint(SpringLayout.EAST, btnCoffee, 74, SpringLayout.EAST, lblCoffee);
		sl_beverage.putConstraint(SpringLayout.NORTH, lblCoffee, 0, SpringLayout.NORTH, lblCola);
		sl_beverage.putConstraint(SpringLayout.WEST, lblCoffee, 71, SpringLayout.EAST, lblCola);
		beverage.add(lblCoffee);

		// 에이드 라벨
		JLabel lblAde = new JLabel("에이드");
		sl_beverage.putConstraint(SpringLayout.SOUTH, lblAde, 0, SpringLayout.SOUTH, lblCola);
		sl_beverage.putConstraint(SpringLayout.EAST, lblAde, -59, SpringLayout.EAST, beverage);
		beverage.add(lblAde);

		// 기프트카드로 가는 버튼
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

		// 팝콘 패널로가는 버튼
		JButton btnPopcorn = new JButton("팝콘");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnPopcorn, 8, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnPopcorn, 39, SpringLayout.EAST, btncard);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnPopcorn, -6, SpringLayout.NORTH, cards);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnPopcorn, -330, SpringLayout.EAST, contentPane);
		contentPane.add(btnPopcorn);
		btnPopcorn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cards, "팝콘");
			}
		});

		// 음료 패널로 가는 버튼
		JButton btnbeverage = new JButton("음료");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnbeverage, 1, SpringLayout.NORTH, btncard);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnbeverage, 36, SpringLayout.EAST, btnPopcorn);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnbeverage, -10, SpringLayout.NORTH, cards);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnbeverage, -199, SpringLayout.EAST, contentPane);
		contentPane.add(btnbeverage);
		btnbeverage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cards, "음료");
			}
		});

		// 장바구니 버튼
		JButton btnshoppingBasket = new JButton("장바구니");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnshoppingBasket, 1, SpringLayout.NORTH, btncard);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnshoppingBasket, -127, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnshoppingBasket, -10, SpringLayout.NORTH, cards);
		contentPane.add(btnshoppingBasket);
		btnshoppingBasket.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cards, "장바구니");
				addJLableMap(shoppingBasket);
			}
		});
		// 장바구니 패널
		shoppingBasket = new JPanel();
		cards.add(shoppingBasket, "장바구니");
		SpringLayout sl_panel = new SpringLayout();
		shoppingBasket.setLayout(new FlowLayout());
//		shoppingBasket.setLayout(sl_panel);
//		sl_contentPane.putConstraint(SpringLayout.EAST, btnshoppingBasket, -32, SpringLayout.EAST, contentPane);
		// 총금액
		lblNewLabel = new JLabel("총 금액");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 356, SpringLayout.NORTH, shoppingBasket);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, shoppingBasket);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel, -62, SpringLayout.SOUTH, shoppingBasket);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, -304, SpringLayout.EAST, shoppingBasket);

		shoppingBasket.add(lblNewLabel);

	}

	// 텍스트 재등록하는 메소드
	// 기프트카드 영화티켓 들어올시 상당히 지저분해질 가능성 높음
//	private void updateTextArea() {
//		textArea.setText(""); // 기존 내용을 모두 지우고
//
//		for (Map.Entry<JButton, Integer> entry : Store.count.entrySet()) {
//			JButton button = entry.getKey();
//			Integer count = entry.getValue();
//			if (count > 0) {
//				for (Food f : menu) {
//					if (f.getName().equals(button.getText())) {
//						textArea.append(f.toString() + ": " + count + "개\n"); // 새로운 정보 추가
//					}
//				}
//			}
//		}
//	}

	// 최초 생성
//	private void addJLableMap(JPanel jpanel) {
////		if(장바구니 버튼 클릭시) {
//		// 최초의 라벨 버튼 생성과정 (삭제 고려필요)
//		for (Map.Entry<JButton, Integer> entry : Store.count.entrySet()) {
//			JButton button = entry.getKey();
//			Integer count = entry.getValue();
//			if (count == 1) {
//				shoppingBasketJLabel.put(i, new JLabel());
//				shoppingBasketJButton.put(i, new JButton("-"));
//				shoppingBasketJPanel.put(i, new JPanel());
//				shoppingBasketJPanel.get(i).add(shoppingBasketJLabel.get(i));
//				shoppingBasketJPanel.get(i).add(shoppingBasketJButton.get(i));
//				jpanel.add(shoppingBasketJPanel.get(i));
//				i++;
//			}
//			if (count > 0) {
//				for (Food f : menu) {
//					if (f.getName().equals(button.getText())) {
//						for (int j = 0; j < i; j++) {
//							String foodName = f.getName();
//							if (foodName.contains(shoppingBasketJLabel.get(j).getText())) {
//								shoppingBasketJLabel.get(j).setText((f.toString() + ": " + count + "개\n"));
//							}
//						}
//					}
//				}
//			}
//		}
//	}
	private void addJLableMap(JPanel jpanel) {
	    // 최초의 라벨 버튼 생성과정 (삭제 고려 필요)
	    for (Map.Entry<JButton, Integer> entry : Store.count.entrySet()) {
	        JButton button = entry.getKey();
	        Integer count = entry.getValue();

	        // 품목의 이름 가져오기
	        String itemName = button.getText();

	        // 해당 품목이 아직 생성되지 않았다면 라벨 생성
	        if (!createdItems.contains(itemName) && count > 0) {
	            shoppingBasketJLabel.put(i, new JLabel());
	            shoppingBasketJButton.put(i, new JButton("-"));
	            shoppingBasketJPanel.put(i, new JPanel());
	            shoppingBasketJPanel.get(i).add(shoppingBasketJLabel.get(i));
	            shoppingBasketJPanel.get(i).add(shoppingBasketJButton.get(i));
	            jpanel.add(shoppingBasketJPanel.get(i));
	            i++;

	            // 생성된 품목을 집합에 추가
	            createdItems.add(itemName);
	        }

	        // 품목이 이미 생성된 경우
	        if (count > 0) {
	            for (Food f : menu) {
	                if (f.getName().equals(itemName)) {
	                    for (int j = 0; j < i; j++) {
	                        String foodName = f.getName();
	                        if (foodName.contains(shoppingBasketJLabel.get(j).getText())) {
	                            shoppingBasketJLabel.get(j).setText((f.toString() + ": " + count + "개\n"));
	                        }
	                    }
	                }
	            }
	        }
	    }
	}

	// 구매한 음식 카운트 해주는 메소드
	// 금액 추가
	// 버튼 생성 후 기프트카드 예정
	// 영화티켓 구매시도 생각해봐야함 충돌 가능성 있음
	private void listener(JButton btn) {
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Store.count.put(btn, Store.count.get(btn) + 1); // 클릭수 올려주는 코드
				for (int i = 0; i < menu.size(); i++) {
					if (menu.get(i).getName().equals(btn.getText())) {
						amount += menu.get(i).getPrice();
					}
				}
				lblNewLabel.setText("총금액 " + Integer.toString(amount) + "원");
			}
		});
	}
}