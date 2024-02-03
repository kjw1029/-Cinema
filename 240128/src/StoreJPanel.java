import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class StoreJPanel extends JPanel {
	private JFrame test;
	private CardLayout cardLayout;
	private JPanel cards;

	public StoreJPanel() {
		test = new JFrame();
		Store.Store();

		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setBounds(100, 100, 600, 600);
		SpringLayout springLayout = new SpringLayout();
		test.getContentPane().setLayout(springLayout);

		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, -453, SpringLayout.SOUTH, test.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -10, SpringLayout.SOUTH, test.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 576, SpringLayout.WEST, test.getContentPane());
		test.getContentPane().add(panel);

		JMenuBar menuBar = new JMenuBar();
		springLayout.putConstraint(SpringLayout.NORTH, menuBar, 30, SpringLayout.NORTH, test.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, menuBar, 10, SpringLayout.WEST, test.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, menuBar, -23, SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.EAST, menuBar, -31, SpringLayout.EAST, test.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, menuBar);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		cards = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, cards, 0, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, cards, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, cards, 443, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, cards, 566, SpringLayout.WEST, panel);
		cardLayout = new CardLayout();
		cards.setLayout(cardLayout);
		panel.add(cards);

		JPanel giftCard = new JPanel();
		cards.add(giftCard, "기프트카드");
		giftCard.setPreferredSize(new Dimension(556, 443));
		SpringLayout sl_giftCard = new SpringLayout();
		giftCard.setLayout(sl_giftCard);

		JPanel popcorn = new JPanel();
		cards.add(popcorn, "팝콘");
		popcorn.setPreferredSize(new Dimension(556, 443));
		SpringLayout sl_popcorn = new SpringLayout();
		popcorn.setLayout(sl_popcorn);

		JButton btnNewButton_1 = new JButton("고소");
		sl_popcorn.putConstraint(SpringLayout.NORTH, btnNewButton_1, 10, SpringLayout.NORTH, popcorn);
		sl_popcorn.putConstraint(SpringLayout.WEST, btnNewButton_1, 10, SpringLayout.WEST, popcorn);
		sl_popcorn.putConstraint(SpringLayout.EAST, btnNewButton_1, 156, SpringLayout.WEST, popcorn);
		popcorn.add(btnNewButton_1);
		foodPurchaseList(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("달콤");
		sl_popcorn.putConstraint(SpringLayout.NORTH, btnNewButton_2, 10, SpringLayout.NORTH, popcorn);
		sl_popcorn.putConstraint(SpringLayout.WEST, btnNewButton_2, 46, SpringLayout.EAST, btnNewButton_1);
		sl_popcorn.putConstraint(SpringLayout.EAST, btnNewButton_2, -218, SpringLayout.EAST, popcorn);
		popcorn.add(btnNewButton_2);
		foodPurchaseList(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("치즈");
		sl_popcorn.putConstraint(SpringLayout.WEST, btnNewButton_3, 378, SpringLayout.WEST, popcorn);
		sl_popcorn.putConstraint(SpringLayout.NORTH, btnNewButton_3, 10, SpringLayout.NORTH, popcorn);
		sl_popcorn.putConstraint(SpringLayout.SOUTH, btnNewButton_3, 179, SpringLayout.NORTH, popcorn);
		sl_popcorn.putConstraint(SpringLayout.EAST, btnNewButton_3, 186, SpringLayout.EAST, btnNewButton_2);
		popcorn.add(btnNewButton_3);
		foodPurchaseList(btnNewButton_3);

		JLabel lblNewLabel_1 = new JLabel("New label");
		sl_popcorn.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 185, SpringLayout.NORTH, popcorn);
		sl_popcorn.putConstraint(SpringLayout.WEST, lblNewLabel_1, 20, SpringLayout.WEST, popcorn);
		sl_popcorn.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -237, SpringLayout.SOUTH, popcorn);
		sl_popcorn.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -6, SpringLayout.NORTH, lblNewLabel_1);
		popcorn.add(lblNewLabel_1);

		JLabel label_3 = new JLabel("New label");
		sl_popcorn.putConstraint(SpringLayout.NORTH, label_3, 185, SpringLayout.NORTH, popcorn);
		sl_popcorn.putConstraint(SpringLayout.WEST, label_3, 212, SpringLayout.WEST, popcorn);
		sl_popcorn.putConstraint(SpringLayout.EAST, lblNewLabel_1, -74, SpringLayout.WEST, label_3);
		sl_popcorn.putConstraint(SpringLayout.SOUTH, btnNewButton_2, -6, SpringLayout.NORTH, label_3);
		sl_popcorn.putConstraint(SpringLayout.SOUTH, label_3, 0, SpringLayout.SOUTH, lblNewLabel_1);
		sl_popcorn.putConstraint(SpringLayout.EAST, label_3, 0, SpringLayout.EAST, btnNewButton_2);
		popcorn.add(label_3);

		JLabel label_4 = new JLabel("New label");
		sl_popcorn.putConstraint(SpringLayout.NORTH, label_4, 6, SpringLayout.SOUTH, btnNewButton_3);
		sl_popcorn.putConstraint(SpringLayout.WEST, label_4, -178, SpringLayout.EAST, popcorn);
		sl_popcorn.putConstraint(SpringLayout.SOUTH, label_4, 0, SpringLayout.SOUTH, lblNewLabel_1);
		sl_popcorn.putConstraint(SpringLayout.EAST, label_4, -32, SpringLayout.EAST, popcorn);
		popcorn.add(label_4);

		JPanel beverage = new JPanel();
		cards.add(beverage, "음료");
		beverage.setPreferredSize(new Dimension(556, 443));
		SpringLayout sl_beverage = new SpringLayout();
		beverage.setLayout(sl_beverage);

		JButton btnNewButton_4 = new JButton("콜라");
		sl_beverage.putConstraint(SpringLayout.NORTH, btnNewButton_4, 10, SpringLayout.NORTH, beverage);
		sl_beverage.putConstraint(SpringLayout.WEST, btnNewButton_4, 10, SpringLayout.WEST, beverage);
		sl_beverage.putConstraint(SpringLayout.SOUTH, btnNewButton_4, 198, SpringLayout.NORTH, beverage);
		sl_beverage.putConstraint(SpringLayout.EAST, btnNewButton_4, 176, SpringLayout.WEST, beverage);
		beverage.add(btnNewButton_4);
		foodPurchaseList(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("커피");
		sl_beverage.putConstraint(SpringLayout.NORTH, btnNewButton_5, 0, SpringLayout.NORTH, btnNewButton_4);
		sl_beverage.putConstraint(SpringLayout.WEST, btnNewButton_5, 17, SpringLayout.EAST, btnNewButton_4);
		sl_beverage.putConstraint(SpringLayout.SOUTH, btnNewButton_5, 188, SpringLayout.NORTH, btnNewButton_4);
		sl_beverage.putConstraint(SpringLayout.EAST, btnNewButton_5, 193, SpringLayout.EAST, btnNewButton_4);
		beverage.add(btnNewButton_5);
		foodPurchaseList(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("에이드");
		sl_beverage.putConstraint(SpringLayout.NORTH, btnNewButton_6, 0, SpringLayout.NORTH, btnNewButton_4);
		sl_beverage.putConstraint(SpringLayout.WEST, btnNewButton_6, -176, SpringLayout.EAST, beverage);
		sl_beverage.putConstraint(SpringLayout.SOUTH, btnNewButton_6, 0, SpringLayout.SOUTH, btnNewButton_4);
		sl_beverage.putConstraint(SpringLayout.EAST, btnNewButton_6, -10, SpringLayout.EAST, beverage);
		beverage.add(btnNewButton_6);
		foodPurchaseList(btnNewButton_6);

		JLabel lblNewLabel_2 = new JLabel("New label");
		sl_beverage.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 1, SpringLayout.SOUTH, btnNewButton_4);
		sl_beverage.putConstraint(SpringLayout.WEST, lblNewLabel_2, 10, SpringLayout.WEST, btnNewButton_4);
		sl_beverage.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, 29, SpringLayout.SOUTH, btnNewButton_4);
		sl_beverage.putConstraint(SpringLayout.EAST, lblNewLabel_2, 0, SpringLayout.EAST, btnNewButton_4);
		beverage.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("New label");
		sl_beverage.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 6, SpringLayout.SOUTH, btnNewButton_5);
		sl_beverage.putConstraint(SpringLayout.WEST, lblNewLabel_3, 27, SpringLayout.EAST, lblNewLabel_2);
		sl_beverage.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, 5, SpringLayout.SOUTH, lblNewLabel_2);
		sl_beverage.putConstraint(SpringLayout.EAST, lblNewLabel_3, 0, SpringLayout.EAST, btnNewButton_5);
		beverage.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("New label");
		sl_beverage.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 6, SpringLayout.SOUTH, btnNewButton_6);
		sl_beverage.putConstraint(SpringLayout.WEST, lblNewLabel_4, 10, SpringLayout.WEST, btnNewButton_6);
		sl_beverage.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, 0, SpringLayout.SOUTH, lblNewLabel_2);
		sl_beverage.putConstraint(SpringLayout.EAST, lblNewLabel_4, -10, SpringLayout.EAST, beverage);
		beverage.add(lblNewLabel_4);

		JPanel shoppingBasket = new JPanel();
		cards.add(shoppingBasket, "장바구니");
		shoppingBasket.setPreferredSize(new Dimension(556, 443));
		SpringLayout sl_shoppingBasket = new SpringLayout();
		shoppingBasket.setLayout(sl_shoppingBasket);

		JScrollPane scrollPane = new JScrollPane();
		sl_shoppingBasket.putConstraint(SpringLayout.NORTH, scrollPane, 10, SpringLayout.NORTH, shoppingBasket);
		sl_shoppingBasket.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, shoppingBasket);
		sl_shoppingBasket.putConstraint(SpringLayout.SOUTH, scrollPane, 245, SpringLayout.NORTH, shoppingBasket);
		sl_shoppingBasket.putConstraint(SpringLayout.EAST, scrollPane, 274, SpringLayout.WEST, shoppingBasket);
		shoppingBasket.add(scrollPane);

		JList<String> list = new JList<>();
//		(ShoppingBasket.totalPurchaseList.toArray(new String[0]));
		scrollPane.setViewportView(list);
		list.setListData(ShoppingBasket.totalPurchaseList.toArray(new String[0])); // 데이터 업데이트
		scrollPane.setViewportView(list); // JList를 스크롤 패널에 설정
		scrollPane.revalidate(); // 스크롤 패널 재구성
		scrollPane.repaint(); // 스크롤 패널 다시 그리기

		JLabel lblNewLabel_5 = new JLabel("총금액");
		sl_shoppingBasket.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 18, SpringLayout.SOUTH, scrollPane);
		sl_shoppingBasket.putConstraint(SpringLayout.WEST, lblNewLabel_5, 0, SpringLayout.WEST, scrollPane);
		sl_shoppingBasket.putConstraint(SpringLayout.SOUTH, lblNewLabel_5, 68, SpringLayout.SOUTH, scrollPane);
		sl_shoppingBasket.putConstraint(SpringLayout.EAST, lblNewLabel_5, 0, SpringLayout.EAST, scrollPane);
		shoppingBasket.add(lblNewLabel_5);

		JButton btnNewButton_7 = new JButton("삭제");
		sl_shoppingBasket.putConstraint(SpringLayout.NORTH, btnNewButton_7, -240, SpringLayout.SOUTH, shoppingBasket);
		sl_shoppingBasket.putConstraint(SpringLayout.WEST, btnNewButton_7, 21, SpringLayout.EAST, scrollPane);
		sl_shoppingBasket.putConstraint(SpringLayout.SOUTH, btnNewButton_7, -198, SpringLayout.SOUTH, shoppingBasket);
		sl_shoppingBasket.putConstraint(SpringLayout.EAST, btnNewButton_7, 110, SpringLayout.EAST, scrollPane);
		shoppingBasket.add(btnNewButton_7);
		btnNewButton_7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!(null == list.getSelectedValue())){
				for (Food f : ShoppingBasket.foodPurchaseList) {
					if (list.getSelectedValue().equals(f.getName())) {
						ShoppingBasket.deletefoodPurchaseList(f);
					}
				}
				
				for (GiftCard g : ShoppingBasket.GiftCardPurchaseList) {
					if (list.getSelectedValue().equals(g.getName())) {
						ShoppingBasket.deleteGiftCardPurchaseList(g);
					}
				}
			}
			}
		});

		JButton btnGiftCard = new JButton("기프트카드");
		menuBar.add(btnGiftCard);
		showListener(btnGiftCard);

		JButton btnPopcorn = new JButton("팝콘");
		menuBar.add(btnPopcorn);
		showListener(btnPopcorn);

		JButton btnBeverage = new JButton("음료");
		menuBar.add(btnBeverage);
		showListener(btnBeverage);

		JButton btnshoppingBasket = new JButton("장바구니");
		menuBar.add(btnshoppingBasket);
		btnshoppingBasket.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cards, "장바구니");
				ShoppingBasket.makeTotalPurchaseList();
//				ShoppingBasket.addCountTotalPurchaseList();
				list.setListData(ShoppingBasket.totalPurchaseList.toArray(new String[0])); // 데이터 업데이트
				scrollPane.setViewportView(list); // JList를 스크롤 패널에 설정
				scrollPane.revalidate(); // 스크롤 패널 재구성
				scrollPane.repaint(); // 스크롤 패널 다시 그리기
			}
		});

		JButton btnNewButton = new JButton("영화관람권");
		sl_giftCard.putConstraint(SpringLayout.NORTH, btnNewButton, 10, SpringLayout.NORTH, giftCard);
		sl_giftCard.putConstraint(SpringLayout.WEST, btnNewButton, 10, SpringLayout.WEST, giftCard);
		sl_giftCard.putConstraint(SpringLayout.SOUTH, btnNewButton, 178, SpringLayout.NORTH, giftCard);
		sl_giftCard.putConstraint(SpringLayout.EAST, btnNewButton, 150, SpringLayout.WEST, giftCard);
		giftCard.add(btnNewButton);
		giftCardPurchaseListListener(btnNewButton);

		JButton button = new JButton("영화관람권2");
		sl_giftCard.putConstraint(SpringLayout.NORTH, button, 10, SpringLayout.NORTH, giftCard);
		sl_giftCard.putConstraint(SpringLayout.WEST, button, 53, SpringLayout.EAST, btnNewButton);
		sl_giftCard.putConstraint(SpringLayout.SOUTH, button, -265, SpringLayout.SOUTH, giftCard);
		sl_giftCard.putConstraint(SpringLayout.EAST, button, -213, SpringLayout.EAST, giftCard);
		giftCard.add(button);
		giftCardPurchaseListListener(button);

		JButton button_1 = new JButton("4D관람권");
		sl_giftCard.putConstraint(SpringLayout.NORTH, button_1, 0, SpringLayout.NORTH, btnNewButton);
		sl_giftCard.putConstraint(SpringLayout.WEST, button_1, 53, SpringLayout.EAST, button);
		sl_giftCard.putConstraint(SpringLayout.SOUTH, button_1, 0, SpringLayout.SOUTH, btnNewButton);
		sl_giftCard.putConstraint(SpringLayout.EAST, button_1, -10, SpringLayout.EAST, giftCard);
		giftCard.add(button_1);
		giftCardPurchaseListListener(button_1);

		JButton button_2 = new JButton("충전형영화관람권");
		sl_giftCard.putConstraint(SpringLayout.NORTH, button_2, 39, SpringLayout.SOUTH, btnNewButton);
		sl_giftCard.putConstraint(SpringLayout.WEST, button_2, 0, SpringLayout.WEST, btnNewButton);
		sl_giftCard.putConstraint(SpringLayout.SOUTH, button_2, 219, SpringLayout.SOUTH, btnNewButton);
		sl_giftCard.putConstraint(SpringLayout.EAST, button_2, 0, SpringLayout.EAST, btnNewButton);
		giftCard.add(button_2);
		StoreJPanel.giftCardPurchaseListListener(button_2);

		JLabel lblNewLabel = new JLabel("New label");
		sl_giftCard.putConstraint(SpringLayout.NORTH, lblNewLabel, 6, SpringLayout.SOUTH, btnNewButton);
		sl_giftCard.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, btnNewButton);
		sl_giftCard.putConstraint(SpringLayout.SOUTH, lblNewLabel, -6, SpringLayout.NORTH, button_2);
		sl_giftCard.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, btnNewButton);
		giftCard.add(lblNewLabel);

		JLabel label = new JLabel("New label");
		sl_giftCard.putConstraint(SpringLayout.NORTH, label, 6, SpringLayout.SOUTH, button);
		sl_giftCard.putConstraint(SpringLayout.WEST, label, 10, SpringLayout.WEST, button);
		sl_giftCard.putConstraint(SpringLayout.SOUTH, label, -232, SpringLayout.SOUTH, giftCard);
		sl_giftCard.putConstraint(SpringLayout.EAST, label, 0, SpringLayout.EAST, button);
		giftCard.add(label);

		JLabel label_1 = new JLabel("New label");
		sl_giftCard.putConstraint(SpringLayout.NORTH, label_1, 6, SpringLayout.SOUTH, button_1);
		sl_giftCard.putConstraint(SpringLayout.WEST, label_1, 10, SpringLayout.WEST, button_1);
		sl_giftCard.putConstraint(SpringLayout.SOUTH, label_1, 0, SpringLayout.SOUTH, lblNewLabel);
		sl_giftCard.putConstraint(SpringLayout.EAST, label_1, -10, SpringLayout.EAST, button_1);
		giftCard.add(label_1);

		JLabel label_2 = new JLabel("New label");
		sl_giftCard.putConstraint(SpringLayout.NORTH, label_2, 6, SpringLayout.SOUTH, button_2);
		sl_giftCard.putConstraint(SpringLayout.WEST, label_2, 10, SpringLayout.WEST, button_2);
		sl_giftCard.putConstraint(SpringLayout.SOUTH, label_2, -10, SpringLayout.SOUTH, giftCard);
		sl_giftCard.putConstraint(SpringLayout.EAST, label_2, 0, SpringLayout.EAST, btnNewButton);
		giftCard.add(label_2);

		test.getContentPane().add(menuBar);
		test.setVisible(true);

	}

	// 카드레이아웃 보여주는 리스너
	public void showListener(JButton btn) {
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cards, btn.getText());
			}
		});
	}

	// 음식 구매목록 추가
	public static void foodPurchaseList(JButton btn) {
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (Food f : StoreMenu.foodmenu) {
					if (f.getName().equals(btn.getText())) {
						ShoppingBasket.addfoodPurchaseList(new Food(f.getPrice(), f.getName(), f.getSize()));
					}
				}
			}
		});
	}

	// 기프트카드 구매목록 추가
	public static void giftCardPurchaseListListener(JButton btn) {
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (GiftCard g : StoreMenu.giftCardList) {
					if (g.getName().equals(btn.getText())) {
						ShoppingBasket.addGiftCardPurchaseList(new GiftCard(g.getName(), g.getPrice(),
								g.getExpirationPeriod(), g.getAvailableStores()));
					}
				}

			}
		});
	}

	public static void main(String[] args) {
		new StoreJPanel();
	}
}
