import javax.swing.*;
import java.awt.*;

public class MoviesPhotoPanel extends JPanel {

    private int radius;

    public MoviesPhotoPanel(int radius) {
        super();
        this.radius = radius;
        setOpaque(false); // 투명한 패널 설정
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension arcs = new Dimension(radius, radius); // 패널의 꼭지점 둥글기 설정
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 배경 그리기
        graphics.setColor(getBackground());
        graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height); // 둥근 모서리의 사각형 그리기
        graphics.setColor(getForeground());
        graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height); // 둥근 모서리의 사각형 테두리 그리기
    }

    // 테스트를 위한 메인 메소드
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // 패널 생성
        MoviesPhotoPanel roundedPanel = new MoviesPhotoPanel(50);
        roundedPanel.setBackground(Color.WHITE);
        roundedPanel.setLayout(new BorderLayout());
        roundedPanel.setBounds(10, 10, 120, 160);
        
        // 레이블 추가
        JLabel label = new JLabel("Rounded Panel Test");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        roundedPanel.add(label, BorderLayout.CENTER);

        frame.add(roundedPanel);
        frame.setVisible(true);
        
    }
}