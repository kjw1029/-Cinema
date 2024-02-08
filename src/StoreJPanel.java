import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
		table.setBounds(12, 15, 295, 282);

		Store.Store();

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 350, 600);
		panel.setPreferredSize(new Dimension(650, 450));
		panel.setLayout(null);

		cards = new JPanel();
		cards.setBounds(0, 156, 350, 444);
		cards.setPreferredSize(new Dimension(350, 600));
		cardLayout = new CardLayout();
		cards.setLayout(cardLayout);
		panel.add(cards);
		
		JPanel popcorn = new JPanel();
		cards.add(popcorn, "팝콘");
		popcorn.setPreferredSize(new Dimension(556, 443));
		popcorn.setLayout(null);

		JButton btnNewButton_1 = new JButton("고소");
		btnNewButton_1.setBounds(25, 5, 71, 115);
		popcorn.add(btnNewButton_1);
		foodPurchaseList(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("달콤");
		btnNewButton_2.setBounds(108, 20, 57, 85);
		popcorn.add(btnNewButton_2);
		foodPurchaseList(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("치즈");
		btnNewButton_3.setBounds(191, 16, 57, 104);
		popcorn.add(btnNewButton_3);
		foodPurchaseList(btnNewButton_3);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(25, 154, 57, 15);
		popcorn.add(lblNewLabel_1);

		JLabel label_3 = new JLabel("New label");
		label_3.setBounds(191, 154, 57, 15);
		popcorn.add(label_3);

		JLabel label_4 = new JLabel("New label");
		label_4.setBounds(108, 154, 57, 15);
		popcorn.add(label_4);

		JPanel beverage = new JPanel();
		cards.add(beverage, "음료");
		beverage.setPreferredSize(new Dimension(556, 443));
		beverage.setLayout(null);

		JButton btnNewButton_4 = new JButton("콜라");
		btnNewButton_4.setBounds(25, 5, 51, 90);
		beverage.add(btnNewButton_4);
		foodPurchaseList(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("커피");
		btnNewButton_5.setBounds(88, 5, 57, 90);
		beverage.add(btnNewButton_5);
		foodPurchaseList(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("에이드");
		btnNewButton_6.setBounds(161, 5, 51, 95);
		beverage.add(btnNewButton_6);
		foodPurchaseList(btnNewButton_6);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(35, 177, 57, 15);
		beverage.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(150, 171, 57, 15);
		beverage.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(243, 177, 57, 15);
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
		lblNewLabel_5.setBounds(12, 342, 128, 15);
		shoppingBasket.add(lblNewLabel_5);

		JButton btnNewButton_7 = new JButton("삭제");
		btnNewButton_7.setBounds(250, 338, 57, 23);
		shoppingBasket.add(btnNewButton_7);
		btnNewButton_7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
					int delete = Integer.parseInt(table.getValueAt(selectedRow, 1).toString()) - 1;
					table.setValueAt(String.valueOf(delete), selectedRow, 1);
					ShoppingBasket.totalPurchaseCountList.set(selectedRow, String.valueOf(delete));
					for (Food f : StoreMenu.foodmenu) {
						if (table.getValueAt(table.getSelectedRow(), 0).equals(f.getName())) {
							amount -= f.getPrice();
							lblNewLabel_5.setText(String.valueOf(amount));
						}
					}
					for (GiftCard g : StoreMenu.giftCardList) {
						if (table.getValueAt(table.getSelectedRow(), 0).equals(g.getName())) {
							amount -= g.getPrice();
							lblNewLabel_5.setText(String.valueOf(amount));
						}
					}
					// 삭제되는 구매목록에 해당하는 카운트 초기화 필요
					if (delete == 0) {
						ShoppingBasket.totalPurchaseList.remove(selectedRow);
						ShoppingBasket.totalPurchaseCountList.remove(selectedRow);
						String column[] = { "구매목록", "구매개수" };
						table.setModel(new DefaultTableModel(comboList(), column));
						for (Food f : StoreMenu.foodmenu) {
							if (table.getValueAt(table.getSelectedRow(), 0).equals(f.getName())) {
								amount -= f.getPrice();
								lblNewLabel_5.setText(String.valueOf(amount));
							}
						}
						for (GiftCard gift : StoreMenu.giftCardList) {
							if (table.getValueAt(table.getSelectedRow(), 0).equals(gift.getName())) {
								amount -= gift.getPrice();
								lblNewLabel_5.setText(String.valueOf(amount));
							}
						}
						for (Food f : ShoppingBasket.foodCount.keySet()) {
							ShoppingBasket.foodCount.put(f, 0);
						}
						for (GiftCard g : ShoppingBasket.giftCount.keySet()) {
							ShoppingBasket.giftCount.put(g, 0);
						}
					}
				}
			}
		});

		JButton btnNewButton_8 = new JButton("구매");
		btnNewButton_8.setBounds(163, 338, 57, 23);
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShoppingBasket.maketotalLastPurchaseList(); // 구매 목록 리스트
				int length = MovieProgram.lblNewLabel_3.getText().length();
				String cus = MovieProgram.lblNewLabel_3.getText().substring(0, length - 7);
				for(List<String> s: MovieProgram.signUps) {
					if (cus.equals(s.get(0))) {
						List<String> list = new ArrayList<>();
						list.addAll(ShoppingBasket.totalLastPurchaseList);
						ShoppingBasket.signUpPurchaseList.add(s.toString() + ShoppingBasket.totalLastPurchaseList.toString());
						System.out.println(ShoppingBasket.signUpPurchaseList.toString());
					}
				}
				
			}
		});
		shoppingBasket.add(btnNewButton_8);
		setLayout(null);

		JPanel giftCard = new JPanel();
		giftCard.setBounds(0, 111, 584, 450);
		cards.add(giftCard, "기프트카드");
		giftCard.setPreferredSize(new Dimension(556, 443));
		giftCard.setLayout(null);

		JButton btnNewButton = new JButton("영화관람권");
		btnNewButton.setBounds(12, 5, 49, 108);
		giftCard.add(btnNewButton);
		giftCardPurchaseListListener(btnNewButton);

		JButton button = new JButton("영화관람권2");
		button.setBounds(73, 13, 49, 93);
		giftCard.add(button);
		giftCardPurchaseListListener(button);

		JButton button_1 = new JButton("4D관람권");
		button_1.setBounds(131, 10, 49, 99);
		giftCard.add(button_1);
		giftCardPurchaseListListener(button_1);

		JButton button_2 = new JButton("충전형영화관람권");
		button_2.setBounds(192, 10, 77, 93);
		giftCard.add(button_2);
		StoreJPanel.giftCardPurchaseListListener(button_2);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(205, 182, 57, 15);
		giftCard.add(lblNewLabel);

		JLabel label = new JLabel("New label");
		label.setBounds(274, 182, 57, 15);
		giftCard.add(label);

		JLabel label_1 = new JLabel("New label");
		label_1.setBounds(30, 158, 57, 15);
		giftCard.add(label_1);

		JLabel label_2 = new JLabel("New label");
		label_2.setBounds(123, 171, 57, 15);
		giftCard.add(label_2);

		add(panel);
		
				JButton btnGiftCard = new JButton("기프트카드");
				btnGiftCard.setBounds(0, 112, 93, 23);
				panel.add(btnGiftCard);
				showListener(btnGiftCard);
				
						JButton btnPopcorn = new JButton("팝콘");
						btnPopcorn.setBounds(89, 112, 57, 23);
						panel.add(btnPopcorn);
						showListener(btnPopcorn);
						
								JButton btnBeverage = new JButton("음료");
								btnBeverage.setBounds(145, 112, 57, 23);
								panel.add(btnBeverage);
								showListener(btnBeverage);
								
										JButton btnshoppingBasket = new JButton("장바구니");
										btnshoppingBasket.setBounds(200, 112, 81, 23);
										panel.add(btnshoppingBasket);
										
										JButton btnNewButton_9 = new JButton("이전");
										btnNewButton_9.setBounds(281, 112, 57, 23);
										panel.add(btnNewButton_9);
										btnNewButton_9.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												MovieProgram.cardLayout.show(MovieProgram.frame.getContentPane(), "로그인");
											}
										});
										
										// 클릭시 음식, 기프트카드 리스트 하나의 List<string>에 담고 카운트, jtable 생성
										btnshoppingBasket.addActionListener(new ActionListener() {
											@Override
											public void actionPerformed(ActionEvent e) {
												cardLayout.show(cards, "장바구니");
												ShoppingBasket.makeTotalPurchaseList();
												ShoppingBasket.foodPurchaseList.clear();
												ShoppingBasket.GiftCardPurchaseList.clear();

												String column[] = { "구매목록", "구매개수" };
												table.setModel(new DefaultTableModel(comboList(), column));

												
												lblNewLabel_5.setText(String.valueOf(amount));
											}
										});

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
