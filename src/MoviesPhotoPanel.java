import javax.swing.*;
import java.awt.*;

public class MoviesPhotoPanel extends JPanel {

    private int radius;

    public MoviesPhotoPanel(int radius, String title) {
        super();
        this.radius = radius;
        setOpaque(false); // 투명한 패널 설정
        setPanel(this);
        setPhoto(this, title);
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
    
    // 패널 꾸미기
    public static void setPanel(MoviesPhotoPanel pnl) {
    	pnl.setBackground(Color.WHITE);
//        pnl.setLayout(new BorderLayout());
//        pnl.setPreferredSize(new Dimension(x, y)); // 패널의 크기 설정
    }
    
    // 사진 추가
    public static void setPhoto(MoviesPhotoPanel pnl, String str) {
    	JLabel label = new JLabel(str);
//        label.setHorizontalAlignment(SwingConstants.CENTER);
        pnl.add(label);
    }
}
