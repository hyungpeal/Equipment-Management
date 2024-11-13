import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RentalReturnPage extends JFrame {
    public RentalReturnPage() {
        final int FRAME_WIDTH = 800, FRAME_HEIGHT = 700;
        final Color MANU_BACKGROUND_COLOR = new Color(50, 100, 150);
        final Color TIMER_BACKGROUND_COLOR = new Color(255, 255, 100);

        setTitle("대여 & 반납 페이지");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //왼쪽 패널
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(MANU_BACKGROUND_COLOR);
        leftPanel.setPreferredSize(new Dimension(150, 0));
        leftPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 5));

        String menus[] = {"", "기자재 리스트", " 수동대여 & 반납", " 대여자 리스트"};
        String imgPath[] = {"./img.png", "./img.png", "./img.png", "./img.png"};
        // 메뉴 항목 추가
        for(int i = 0; i < menus.length; i++) {
            ImageIcon imageIcon = new ImageIcon(imgPath[i]);
            Image image = imageIcon.getImage();
            Image newimg = image.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(newimg);
            JButton button = new JButton(menus[i], imageIcon);
            
            button.setHorizontalTextPosition(JButton.RIGHT);
            button.setBorderPainted(false);
            button.setFocusPainted(false);
            button.setBackground(MANU_BACKGROUND_COLOR);
            button.setForeground(Color.WHITE);
            leftPanel.add(button);
        }

        //오른쪽 패널
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new FlowLayout(FlowLayout.CENTER, FRAME_WIDTH, 10));

        //시간
        JPanel timePanel = new JPanel();
        timePanel.setBackground(TIMER_BACKGROUND_COLOR);
        JLabel time = new JLabel("현재시각: .... ");
        time.setFont(new Font(null, Font.BOLD, 23));
        timePanel.add(time);
        rightPanel.add(timePanel);

        //여백
        JPanel gap = new JPanel();
        gap.setPreferredSize(new Dimension(FRAME_WIDTH, 200));
        //gap.setBackground(Color.GREEN);
        rightPanel.add(gap);

        //메인
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, FRAME_WIDTH*10, 10));
        mainPanel.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        JTextField barCode = new JTextField(30);
        barCode.setForeground(Color.GRAY);
        //placeholder
        String guideText = "기자재 바코드 번호";
        barCode.setText(guideText);
        barCode.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(barCode.getText().equals(guideText)) {
                    barCode.setText("");
                    barCode.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(barCode.getText().isEmpty()) {
                    barCode.setForeground(Color.GRAY);
                    barCode.setText(guideText);
                }
            }
        });
        mainPanel.add(barCode);
        String buttons[] = {"대여페이지로 이동", "반납페이지로 이동"};
        for(int i = 0; i < buttons.length; i++) {
            JButton button = new JButton(buttons[i]);
            button.setBackground(Color.LIGHT_GRAY);
            button.setBorderPainted(false);
            button.setFocusPainted(false);
            mainPanel.add(button);
        }
        
        /*
        JLabel infor = new JLabel("바코드 스캐너 고장 시..");
        infor.setFont(new Font(null, Font.PLAIN, 15));
        mainPanel.add(infor);
        */
        rightPanel.add(mainPanel);

        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new RentalReturnPage().setVisible(true);
    }
}
