import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Block {
	XY xy;

	public Block(XY xy) {
		super();
		this.xy = xy;
	}

	public XY getXy() {
		return xy;
	}

	public void setXy(XY xy) {
		this.xy = xy;
	}

	@Override
	public String toString() {
		return "Block [x=" + xy.getX() + ", y=" + xy.getY() + "]";
	}

}

class XY {
	int x;
	int y;

	public XY() {
	}

	public XY(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "XY [x=" + x + ", y=" + y + "]";
	}

}

public class TestGame extends JFrame {

	public static TestGame frame;
	private JPanel contentPane;
	public static XY xy = new XY();
	public static List<Block> blocks = new ArrayList<Block>();
	public static JPanel pnl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					frame = new TestGame();
					frame.setVisible(true);

					frame.setFocusable(true); // 패널에 포커스 설정
					frame.requestFocusInWindow();
//					frame.requestFocusInWindow();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setLayout(null);

		pnl = createCharacter();

		MouseListener l = extracted();
		KeyAdapter key = extracted2();

		addKeyListener(key); // 패널에 키 리스너 등록

		addMouseListener(l);

		add(pnl);

		JPanel panel = new JPanel();
		panel.setBounds(16, 505, 760, 50);
		add(panel);

		JButton btnNewButton = new JButton("+");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel pnl2 = createBlock();
				add(pnl2);
				revalidate(); // 레이아웃 재구성
				repaint();
				frame.requestFocusInWindow();
			}

		});
		panel.add(btnNewButton);

	}

	private KeyAdapter extracted2() {
		KeyAdapter l = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int newX = pnl.getX();
				int newY = pnl.getY();
				// 왼쪽
				if (e.getKeyCode() == 37) {
					newX -= 20;
				}
				// 위쪽
				else if (e.getKeyCode() == 38) {
					newY -= 20;
				}
				// 오른쪽
				else if (e.getKeyCode() == 39) {
					newX += 20;
				}
				// 아래쪽
				else if (e.getKeyCode() == 40) {
					newY += 20;
				}
				boolean isValidMove = true;
				for (Block block : blocks) {
					if (block.getXy().getX() == newX && block.getXy().getY() == newY) {
						isValidMove = false;
						return;
					}
				}

				if (isValidMove) {
					pnl.setLocation(newX, newY);
				}
			}
		};
		return l;
	}

	private MouseListener extracted() {
		MouseListener l = new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println(e.getX());

				xy.setX(e.getX());
				xy.setY(e.getY());
				System.out.println("mouse" + xy.getX() + "/" + xy.getY());

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		};
		return l;
	}

	public void round20(XY xy) {
		int remainderX = xy.getX() % 20;
		if (remainderX >= 10) {
			xy.setX((xy.getX() + (20 - remainderX)));
		} else {
			xy.setX((xy.getX() - remainderX));
		}
		int remainderY = (int) (xy.getY() % 20);
		if (remainderY >= 10) {
			xy.setY((xy.getY() + (20 - remainderY)));
		} else {
			xy.setY((xy.getY() - remainderY));
		}
	}

	private JPanel createBlock() {
		JPanel pnl = new JPanel();
		XY blockXY = new XY();

		blockXY.setX(xy.getX());
		blockXY.setY(xy.getY());
		round20(blockXY);

		pnl.setBounds(blockXY.getX(), blockXY.getY(), 20, 20);
		pnl.setBackground(Color.green);

		blocks.add(new Block(blockXY));

		return pnl;
	}

	public JPanel createCharacter() {
		JPanel pnl = new JPanel();
		pnl.setBounds(0, 0, 20, 20);
		pnl.setBackground(Color.ORANGE);
		return pnl;
	}
}
