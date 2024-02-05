import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.AbstractLayoutCache;
import java.awt.Rectangle;
import java.awt.BorderLayout;

public class StoreJPanel extends JPanel {
	private CardLayout cardLayout;
	private JPanel cards;
	protected static JTable table;
	private String columns[];
	protected static String[][] jTabledatas;
	private static int amount = 0;

	public StoreJPanel() {
		columns = new String[] { "구매목록", "구매개수" };
		JTable table = new JTable(comboList(), columns);
		table.setBounds(12, 15, 128, 186);

		Store.Store();

		JPanel panel = new JPanel();
		panel.setBounds(10, 75, 566, 443);
		panel.setPreferredSize(new Dimension(600, 600));
		panel.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 10, 584, 60);
		menuBar.setPreferredSize(new Dimension(0, 60));
		menuBar.setBackground(Color.LIGHT_GRAY);
		panel.add(menuBar);

		cards = new JPanel();
		cards.setBounds(0, 80, 584, 450);
		cards.setPreferredSize(new Dimension(500, 450));
		cardLayout = new CardLayout();
		cards.setLayout(cardLayout);
		panel.add(cards);

		JPanel popcorn = new JPanel();
		cards.add(popcorn, "팝콘");
		popcorn.setPreferredSize(new Dimension(556, 443));
		popcorn.setLayout(null);

		JButton btnNewButton_1 = new JButton("고소");
		btnNewButton_1.setBounds(25, 5, 126, 178);
		popcorn.add(btnNewButton_1);
		foodPurchaseList(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("달콤");
		btnNewButton_2.setBounds(156, 5, 116, 178);
		popcorn.add(btnNewButton_2);
		foodPurchaseList(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("치즈");
		btnNewButton_3.setBounds(275, 5, 117, 178);
		popcorn.add(btnNewButton_3);
		foodPurchaseList(btnNewButton_3);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(25, 193, 57, 15);
		popcorn.add(lblNewLabel_1);

		JLabel label_3 = new JLabel("New label");
		label_3.setBounds(156, 193, 57, 15);
		popcorn.add(label_3);

		JLabel label_4 = new JLabel("New label");
		label_4.setBounds(275, 193, 57, 15);
		popcorn.add(label_4);

		JPanel beverage = new JPanel();
		cards.add(beverage, "음료");
		beverage.setPreferredSize(new Dimension(556, 443));
		beverage.setLayout(null);

		JButton btnNewButton_4 = new JButton("콜라");
		btnNewButton_4.setBounds(25, 5, 83, 156);
		beverage.add(btnNewButton_4);
		foodPurchaseList(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("커피");
		btnNewButton_5.setBounds(150, 5, 69, 156);
		beverage.add(btnNewButton_5);
		foodPurchaseList(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("에이드");
		btnNewButton_6.setBounds(228, 34, 143, 127);
		beverage.add(btnNewButton_6);
		foodPurchaseList(btnNewButton_6);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(286, 9, 57, 15);
		beverage.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(348, 9, 57, 15);
		beverage.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(410, 9, 57, 15);
		beverage.add(lblNewLabel_4);

		JPanel shoppingBasket = new JPanel();
		cards.add(shoppingBasket, "장바구니");
		shoppingBasket.setPreferredSize(new Dimension(556, 443));
		shoppingBasket.setLayout(null);
		shoppingBasket.add(table);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(194, 15, 2, 2);
		shoppingBasket.add(scrollPane);

		JLabel lblNewLabel_5 = new JLabel("총금액");
		lblNewLabel_5.setBounds(12, 227, 36, 15);
		shoppingBasket.add(lblNewLabel_5);

		JButton btnNewButton_7 = new JButton("삭제");
		btnNewButton_7.setBounds(242, 175, 57, 23);
		shoppingBasket.add(btnNewButton_7);
		btnNewButton_7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
					int delete = Integer.parseInt(table.getValueAt(selectedRow, 1).toString()) - 1;
					table.setValueAt(String.valueOf(delete), selectedRow, 1);
					ShoppingBasket.totalPurchaseCountList.set(selectedRow, String.valueOf(delete));
					for(String s : ShoppingBasket.totalPurchaseList) {
						for(Food f : StoreMenu.foodmenu) {
							if(f.getName().equals(s)) {
								amount -= f.getPrice(); 
							}
						}
						for(GiftCard g : StoreMenu.giftCardList) {
							if(g.getName().equals(s)) {
								amount -= g.getPrice();
							}
						}
					}
						
					
					if (delete == 0) {
						ShoppingBasket.totalPurchaseList.remove(selectedRow);
						ShoppingBasket.totalPurchaseCountList.remove(selectedRow);
						String column[] = { "구매목록", "구매개수" };
						table.setModel(new DefaultTableModel(comboList(), column));
						for(String s : ShoppingBasket.totalPurchaseList) {
							for(Food f : StoreMenu.foodmenu) {
								if(f.getName().equals(s)) {
									amount -= f.getPrice(); 
								}
							}
							for(GiftCard g : StoreMenu.giftCardList) {
								if(g.getName().equals(s)) {
									amount -= g.getPrice();
								}
							}
						}
					}
				}
				lblNewLabel_5.setText(String.valueOf(amount));
			}
		});

		JButton btnNewButton_8 = new JButton("구매");
		btnNewButton_8.setBounds(179, 175, 57, 23);
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(ShoppingBasket.totalPurchaseCountList);
			}
		});
		shoppingBasket.add(btnNewButton_8);

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
		// 클릭시 음식, 기프트카드 리스트 하나의 List<string>에 담고 카운트, jtable 생성
		btnshoppingBasket.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cards, "장바구니");
				ShoppingBasket.makeTotalPurchaseList();
				for (Food f : ShoppingBasket.foodCount.keySet()) {
					ShoppingBasket.foodCount.put(f, 0);
				}
				for (GiftCard g : ShoppingBasket.giftCount.keySet()) {
					ShoppingBasket.giftCount.put(g, 0);
				}

				if (ShoppingBasket.totalPurchaseList.isEmpty()) {
					String column[] = { "구매목록", "구매개수" };
					table.setModel(new DefaultTableModel(comboList(), column));
				} else if (!(ShoppingBasket.totalPurchaseList.isEmpty())) {
					ShoppingBasket.foodPurchaseList.clear();
					ShoppingBasket.GiftCardPurchaseList.clear();
					ShoppingBasket.makeTotalPurchaseList();
					String column[] = { "구매목록", "구매개수" };
					table.setModel(new DefaultTableModel(comboList(), column));
				}
				lblNewLabel_5.setText(String.valueOf(amount));
			}
		});

		JPanel giftCard = new JPanel();
		giftCard.setBounds(0, 111, 584, 450);
		cards.add(giftCard, "기프트카드");
		giftCard.setPreferredSize(new Dimension(556, 443));
		giftCard.setLayout(null);

		JButton btnNewButton = new JButton("영화관람권");
		btnNewButton.setBounds(12, 5, 93, 163);
		giftCard.add(btnNewButton);
		giftCardPurchaseListListener(btnNewButton);

		JButton button = new JButton("영화관람권2");
		button.setBounds(104, 5, 99, 145);
		giftCard.add(button);
		giftCardPurchaseListListener(button);

		JButton button_1 = new JButton("4D관람권");
		button_1.setBounds(208, 5, 83, 145);
		giftCard.add(button_1);
		giftCardPurchaseListListener(button_1);

		JButton button_2 = new JButton("충전형영화관람권");
		button_2.setBounds(296, 5, 129, 145);
		giftCard.add(button_2);
		StoreJPanel.giftCardPurchaseListListener(button_2);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(328, 231, 57, 15);
		giftCard.add(lblNewLabel);

		JLabel label = new JLabel("New label");
		label.setBounds(464, 231, 57, 15);
		giftCard.add(label);

		JLabel label_1 = new JLabel("New label");
		label_1.setBounds(90, 215, 57, 15);
		giftCard.add(label_1);

		JLabel label_2 = new JLabel("New label");
		label_2.setBounds(192, 231, 57, 15);
		giftCard.add(label_2);

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
						amount += f.getPrice();

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
						amount += g.getPrice();
					}
				}

			}
		});
	}

	// 구매목록 2차원 배열로 나타냄
	public static String[][] comboList() {
		int size = ShoppingBasket.totalPurchaseList.size();
		jTabledatas = new String[size][2];

		for (int i = 0; i < size; i++) {
			jTabledatas[i][0] = ShoppingBasket.totalPurchaseList.get(i);
			jTabledatas[i][1] = ShoppingBasket.totalPurchaseCountList.get(i);
		}
		return jTabledatas;

	}

	public static void main(String[] args) {
		new StoreJPanel();
	}
}
