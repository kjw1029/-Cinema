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

class Block extends JPanel {
	XY xy;
	boolean interacting;
	Color c;

	public Block(XY xy, Color c) {
		super();
		this.xy = xy;
		this.c = c;
	}

	public Block(XY xy) {
		super();
		this.xy = xy;
		this.interacting = false; // 초기값은 false로 설정

	}

	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}

	public XY getXy() {
		return xy;
	}

	public void setXy(XY xy) {
		this.xy = xy;
	}

	public void setBlue() {
		this.setBackground(Color.BLUE);
	}

	public boolean isInteracting() {
		return interacting;
	}

	public void setInteracting(boolean interacting) {
		this.interacting = interacting;
	}

	// 배경색 변경 메서드 추가
	public void setBackgroundColor(Color color) {
		this.setBackground(color);
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
					frame.requestFocusInWindow();
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
				Block pnl2 = createBlock();
				pnl2.setBackground(Color.green);
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
				boolean hit = false;
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
				// 상호작용 E
				else if (e.getKeyCode() == 69) {
					interact();

				}
				// 삭제 D
				else if (e.getKeyCode() == 68) {
					delete();
				}
				if (isValidMove(newX, newY)) {
					pnl.setLocation(newX, newY);
				}
				revalidate(); // 레이아웃 재구성
				repaint();
			}
		};
		return l;
	}
	
	public boolean isValidMove(int newX, int newY) {
		if (newX == getWidth() || newX < 0 || newY == getHeight() -100 || newY < 0) {
			System.out.println();
			return false;
		}
		
		for (Block block : blocks) {
			if (block.getXy().getX() == newX && block.getXy().getY() == newY) {
				block.setBackgroundColor(Color.blue);
				return false;
			}
		}
		return true;
	}

	// 캐릭터와 가까운 블록을 찾는 메서드
	private Block findNearestBlock() {
		Block nearestBlock = null;
		double minDistance = Double.MAX_VALUE;

		// 캐릭터 위치
		int charX = pnl.getX() + 10; // 캐릭터의 중심 X 좌표
		int charY = pnl.getY() + 10; // 캐릭터의 중심 Y 좌표

		// 모든 블록에 대해 순회하면서 가장 가까운 블록을 찾음
		for (Block block : blocks) {
			int blockX = block.getXy().getX() + 10; // 블록의 중심 X 좌표
			int blockY = block.getXy().getY() + 10; // 블록의 중심 Y 좌표

			// 캐릭터와 블록 사이의 거리 계산 (피타고라스의 정리 사용)
			double distance = Math.sqrt(Math.pow(blockX - charX, 2) + Math.pow(blockY - charY, 2));

			// 현재까지 찾은 최소 거리보다 더 가까운 블록이면 업데이트
			if (distance < minDistance) {
				minDistance = distance;
				nearestBlock = block;
			}
		}

		return nearestBlock;
	}

	public void delete() {
		Block nearestBlock = findNearestBlock();
		nearestBlock.setInteracting(false);

		if (nearestBlock != null) {
			nearestBlock.setInteracting(true);
			blocks.remove(nearestBlock);
			remove(nearestBlock);
		}
		System.out.println(nearestBlock.toString());
		System.out.println(blocks.toString());
	}

	// 가장 가까운 블록이 존재하고 상호작용 상태를 변경
	private void interact() {
		// 캐릭터와 가장 가까운 블록을 찾음
		Block nearestBlock = findNearestBlock();
		nearestBlock.setInteracting(false);

		if (nearestBlock != null) {
			nearestBlock.setInteracting(true);
			nearestBlock.setBackground(Color.RED);
		}
		System.out.println(nearestBlock.toString());
		System.out.println(blocks.toString());
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
		int remainderY = xy.getY() % 20;
		if (remainderY >= 10) {
			xy.setY((xy.getY() + (20 - remainderY)));
		} else {
			xy.setY((xy.getY() - remainderY));
		}
	}

	private Block createBlock() {
		XY blockXY = new XY(xy.getX()-10, xy.getY()-30);
		round20(blockXY);

		Block block = new Block(blockXY); // Block 객체 생성
		block.setBounds(blockXY.getX(), blockXY.getY(), 20, 20); // 위치 설정

		blocks.add(block); // 리스트에 추가
		return block; // 생성된 Block 객체 반환
	}

	public JPanel createCharacter() {
		JPanel pnl = new JPanel();
		pnl.setBounds(0, 0, 20, 20);
		pnl.setBackground(Color.ORANGE);
		return pnl;
	}
}
