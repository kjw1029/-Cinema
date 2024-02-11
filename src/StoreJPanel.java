import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
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
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;

public class StoreJPanel extends JPanel {
	private CardLayout cardLayout;
	private JPanel cards;
	private static int amount = 0;
	private static JLabel lblNewLabel_5;
	private static JPanel panel_2;

	public StoreJPanel() {

		Store.Store();

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 800, 599);
		panel.setPreferredSize(new Dimension(800, 600));
		panel.setLayout(null);

		cards = new JPanel();
		cards.setBackground(Color.WHITE);
		cards.setBounds(0, 40, 800, 560);
		cards.setPreferredSize(new Dimension(350, 600));
		cardLayout = new CardLayout();
		cards.setLayout(cardLayout);
		panel.add(cards);

		JPanel popcorn = new JPanel();
		popcorn.setBackground(Color.WHITE);
		cards.add(popcorn, "팝콘");
		popcorn.setPreferredSize(new Dimension(556, 443));
		popcorn.setLayout(null);

		JButton btnNewButton_2 = new JButton("달콤");
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setIcon(new ImageIcon("이미지\\달콤.PNG"));
		btnNewButton_2.setBounds(214, 89, 185, 249);
		popcorn.add(btnNewButton_2);
		foodPurchaseList(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("치즈");
		btnNewButton_3.setOpaque(false);
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setIcon(new ImageIcon("이미지\\치즈.PNG"));
		btnNewButton_3.setBounds(431, 89, 185, 249);
		popcorn.add(btnNewButton_3);
		foodPurchaseList(btnNewButton_3);

		JLabel lblNewLabel_1 = new JLabel("고소 팝콘");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1.setBounds(12, 346, 185, 52);
		popcorn.add(lblNewLabel_1);

		JLabel label_3 = new JLabel("New label");
		label_3.setBounds(431, 348, 185, 52);
		popcorn.add(label_3);

		JLabel label_4 = new JLabel("New label");
		label_4.setBounds(214, 348, 185, 52);
		popcorn.add(label_4);

		JButton btnNewButton_1 = new JButton("고소");
		btnNewButton_1.setMargin(new Insets(2, 17, 2, 14));
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setIcon(new ImageIcon("이미지\\고소.PNG"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(12, 87, 190, 249);
		popcorn.add(btnNewButton_1);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setOpaque(false);
		foodPurchaseList(btnNewButton_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(12, 10, 760, 52);
		popcorn.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("팝콘");
		lblNewLabel_6.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_6.setBounds(12, 5, 52, 42);
		panel_3.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("고소, 달콤부터 고메까지 안 먹으면 서운해요");
		lblNewLabel_7.setBounds(62, 14, 393, 28);
		panel_3.add(lblNewLabel_7);

		JPanel beverage = new JPanel();
		beverage.setBackground(Color.WHITE);
		cards.add(beverage, "음료");
		beverage.setPreferredSize(new Dimension(556, 443));
		beverage.setLayout(null);

		JButton btnNewButton_4 = new JButton("콜라");
		btnNewButton_4.setIcon(new ImageIcon("이미지\\콜라.PNG"));
		btnNewButton_4.setOpaque(false);
		btnNewButton_4.setContentAreaFilled(false);
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setBounds(25, 77, 215, 279);
		beverage.add(btnNewButton_4);
		foodPurchaseList(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("커피");
		btnNewButton_5.setIcon(new ImageIcon("이미지\\커피.PNG"));
		btnNewButton_5.setOpaque(false);
		btnNewButton_5.setContentAreaFilled(false);
		btnNewButton_5.setBorderPainted(false);
		btnNewButton_5.setBounds(252, 77, 215, 279);
		beverage.add(btnNewButton_5);
		foodPurchaseList(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("에이드");
		btnNewButton_6.setOpaque(false);
		btnNewButton_6.setBorderPainted(false);
		btnNewButton_6.setContentAreaFilled(false);
		btnNewButton_6.setIcon(new ImageIcon("이미지\\에이드.PNG"));
		btnNewButton_6.setBounds(479, 77, 254, 279);
		beverage.add(btnNewButton_6);
		foodPurchaseList(btnNewButton_6);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(25, 366, 215, 76);
		beverage.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(239, 366, 215, 76);
		beverage.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(480, 366, 215, 76);
		beverage.add(lblNewLabel_4);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(25, 10, 751, 56);
		beverage.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("음료");
		lblNewLabel_8.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_8.setBounds(12, 10, 52, 36);
		panel_4.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("탄산음료부터 에이드까지, 마시는 즐거움!");
		lblNewLabel_9.setBackground(Color.WHITE);
		lblNewLabel_9.setBounds(66, 19, 392, 23);
		panel_4.add(lblNewLabel_9);

		JPanel shoppingBasket = new JPanel();
		shoppingBasket.setBackground(Color.WHITE);
		cards.add(shoppingBasket, "장바구니");
		shoppingBasket.setPreferredSize(new Dimension(556, 443));
		shoppingBasket.setLayout(null);

		lblNewLabel_5 = new JLabel("총금액");
		lblNewLabel_5.setBounds(12, 342, 128, 15);
		shoppingBasket.add(lblNewLabel_5);

		JButton btnNewButton_8 = new JButton("구매");
		btnNewButton_8.setBounds(163, 338, 57, 23);
		btnNewButton_8.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ShoppingBasket.maketotalLastPurchaseList(); // 구매 목록 리스트
				int length = MovieProgram.lblNewLabel_3.getText().length();
				String cus = MovieProgram.lblNewLabel_3.getText().substring(0, length - 7);
				for (List<String> s : MovieProgram.signUps) {
					if (cus.equals(s.get(0))) {
						List<String> list = new ArrayList<>();
						list.addAll(ShoppingBasket.totalLastPurchaseList);
						ShoppingBasket.signUpPurchaseList
								.add(s.toString() + ShoppingBasket.totalLastPurchaseList.toString());
						System.out.println(ShoppingBasket.signUpPurchaseList.toString());
					}
				}

			}
		});
		shoppingBasket.add(btnNewButton_8);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(12, 26, 757, 277);
		shoppingBasket.add(scrollPane);
		// 패널 버튼 같이 추가 예정

		panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_2.setBackground(Color.WHITE);
		scrollPane.setViewportView(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		setLayout(null);

		JPanel giftCard = new JPanel();
		giftCard.setBackground(Color.WHITE);
		giftCard.setBounds(0, 111, 584, 450);
		cards.add(giftCard, "기프트카드");
		giftCard.setPreferredSize(new Dimension(556, 443));
		giftCard.setLayout(null);

		JButton btnNewButton = new JButton("영화관람권");
		btnNewButton.setBounds(12, 5, 185, 257);
		giftCard.add(btnNewButton);

		giftCardPurchaseListListener(btnNewButton);

		JButton button = new JButton("영화관람권2");
		button.setBounds(218, 5, 185, 257);
		giftCard.add(button);
		giftCardPurchaseListListener(button);

		JButton button_1 = new JButton("4D관람권");
		button_1.setBounds(415, 5, 185, 257);
		giftCard.add(button_1);
		giftCardPurchaseListListener(button_1);

		JButton button_2 = new JButton("충전형영화관람권");
		button_2.setBounds(612, 5, 176, 257);
		giftCard.add(button_2);
		StoreJPanel.giftCardPurchaseListListener(button_2);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(424, 283, 176, 68);
		giftCard.add(lblNewLabel);

		JLabel label = new JLabel("New label");
		label.setBounds(612, 283, 176, 68);
		giftCard.add(label);

		JLabel label_1 = new JLabel("New label");
		label_1.setBounds(22, 272, 130, 68);
		giftCard.add(label_1);

		JLabel label_2 = new JLabel("New label");
		label_2.setBounds(225, 283, 130, 68);
		giftCard.add(label_2);

		add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 788, 33);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 4, 0, 0));

		JButton btnGiftCard = new JButton("기프트카드");
		btnGiftCard.setBorder(new MatteBorder(2, 0, 1, 0, (Color) Color.BLACK));
		btnGiftCard.setBackground(Color.WHITE);
		btnGiftCard.setOpaque(false);
		btnGiftCard.setFocusable(false);
		panel_1.add(btnGiftCard);
		showListener(btnGiftCard);

		JButton btnPopcorn = new JButton("팝콘");
		btnPopcorn.setBackground(Color.WHITE);
		btnPopcorn.setOpaque(false);
		btnPopcorn.setFocusable(false);
		btnPopcorn.setBorder(new MatteBorder(2, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_1.add(btnPopcorn);
		showListener(btnPopcorn);

		JButton btnBeverage = new JButton("음료");
		btnBeverage.setOpaque(false);
		btnBeverage.setFocusable(false);
		btnBeverage.setBorder(new MatteBorder(2, 0, 1, 0, (Color) new Color(0, 0, 0)));
		btnBeverage.setBackground(Color.WHITE);
		panel_1.add(btnBeverage);
		showListener(btnBeverage);

		JButton btnshoppingBasket = new JButton("장바구니");
		btnshoppingBasket.setBackground(Color.WHITE);
		btnshoppingBasket.setBorder(new MatteBorder(2, 0, 1, 0, (Color) new Color(0, 0, 0)));
		btnshoppingBasket.setFocusable(false);
		btnshoppingBasket.setOpaque(false);
		panel_1.add(btnshoppingBasket);

		btnshoppingBasket.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cards, "장바구니");
				ShoppingBasket.makeTotalPurchaseList();
				panel_2.removeAll();
				panel_2.revalidate();
				panel_2.repaint();
				for (int i = 0; i < ShoppingBasket.totalPurchaseList.size(); i++) {
					if (!ShoppingBasket.totalPurchaseCountList.get(i).equals("0")) {
						JPanel pnl = new JPanel();
						pnl.setBackground(Color.WHITE);
						pnl.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
						pnl.setName(ShoppingBasket.totalPurchaseList.get(i));
						pnl.setLayout(new BorderLayout());
						
						JLabel lblImage = new JLabel();
						ImageIcon icon = new ImageIcon("이미지/" + ShoppingBasket.totalPurchaseList.get(i) + ".PNG");
						// 이미지 아이콘에서 이미지를 가져와서 크기 조정
						Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
						// 크기가 조정된 이미지를 다시 ImageIcon으로 변환
						ImageIcon newIcon = new ImageIcon(image);
						
						lblImage.setIcon(newIcon);
						JLabel lbl = new JLabel(ShoppingBasket.totalPurchaseList.get(i));
						JLabel lblCount = new JLabel(ShoppingBasket.totalPurchaseCountList.get(i));
						JButton btn = new JButton("삭제");
						deletePurchaseList(btn, i, pnl, lblCount);
						
						JPanel centerPanel = new JPanel();
			            centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // 중앙 정렬을 위한 FlowLayout 사용
			            centerPanel.add(lbl);
			            centerPanel.add(lblCount);
			            
						pnl.add(lblImage, BorderLayout.WEST);
						pnl.add(centerPanel, BorderLayout.CENTER);
						pnl.add(btn, BorderLayout.EAST);
						
//						pnl.add(lbl);
//						pnl.add(lblCount);
//						pnl.add(btn);
						panel_2.add(pnl);
						panel_2.add(Box.createRigidArea(new Dimension(0, 0)));
					}
				}
				ShoppingBasket.foodPurchaseList.clear();
				ShoppingBasket.GiftCardPurchaseList.clear();

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

	public static void deletePurchaseList(JButton btn, int index, JPanel pnl, JLabel lbl) {
		int i = index;
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!ShoppingBasket.totalPurchaseCountList.get(i).equals("0")) {
					int purchase = Integer.valueOf(ShoppingBasket.totalPurchaseCountList.get(i)) - 1;
					lbl.setText(String.valueOf(purchase));
					ShoppingBasket.totalPurchaseCountList.set(i, String.valueOf(purchase));
					for (Food f : StoreMenu.foodmenu) {
						if (ShoppingBasket.totalPurchaseList.get(i).equals(f.getName())) {
							amount -= f.getPrice();
							lblNewLabel_5.setText(String.valueOf(amount));
						}
					}

					for (GiftCard gift : StoreMenu.giftCardList) {
						if (ShoppingBasket.totalPurchaseList.get(i).equals(gift.getName())) {
							amount -= gift.getPrice();
							lblNewLabel_5.setText(String.valueOf(amount));
						}
					}
				}
				if (ShoppingBasket.totalPurchaseCountList.get(i).equals("0")) {
					System.out.println(ShoppingBasket.totalPurchaseCountList.get(i));
					panel_2.remove(pnl);
					panel_2.revalidate();
					panel_2.repaint();
					ShoppingBasket.foodCount.clear();
					ShoppingBasket.giftCount.clear();
				}
				ShoppingBasket.makeTotalPurchaseList();
				ShoppingBasket.foodPurchaseList.clear();
				ShoppingBasket.GiftCardPurchaseList.clear();
			}
		});
	}

	public static void main(String[] args) {
		new StoreJPanel();
	}
}
