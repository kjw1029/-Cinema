import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

public class StoreJPanel extends JPanel {
	private JPanel contentPane;
	public StoreJPanel() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
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
	}
	

}
