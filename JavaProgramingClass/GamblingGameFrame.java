import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamblingGameFrame extends JFrame{
	public GamblingGameFrame() {
		super("김지우가 만든 게임"); // 타이틀. JFrame(String title)을 불러온 것
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 이거 없으면 메모리 반납을 못함
		
		setContentPane(new GamePanel()); // GamePanel을 컨텐트팬으로 등록한다
		
		setSize(500, 200);
		setVisible(true);
		
		// GamePanel이 키 이벤트를 받을 수 있도록 포커스를 설정한다.
		getContentPane().setFocusable(true);
		getContentPane().requestFocus();
	}

	
	class GamePanel extends JPanel {
		private JLabel [] label = new JLabel [5];
		private JLabel result = new JLabel("시작합니다.");
		
		public GamePanel() {
			setLayout(null); // 배치관리자 사용x
			
			for(int i=0; i<label.length; i++) {
				label[i] = new JLabel("0"); // 레이블 생성
				label[i].setSize(60,30); // 레이블 크기
				label[i].setLocation(30+80*i, 50); // 레이블 위치
				label[i].setHorizontalAlignment(JLabel.CENTER);
				label[i].setOpaque(true);
				label[i].setBackground(Color.MAGENTA);
				label[i].setForeground(Color.YELLOW);
				label[i].setFont(new Font("Tahoma", Font.ITALIC, 30));
				add(label[i]); // 레이블을 부착한다.
			}
			
			// 결과를 출력할 레이블을 생성하고 컨테이너에 부착한다.
			result.setSize(200, 30);
			result.setFont(new Font("굴림체", 0, 30));
			result.setLocation(100, 120);
			add(result);
			
			// 키 리스너를 구현한다.
			addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyChar() == '\n') {
						int x1 = (int)(Math.random()*5);
						label[0].setText(Integer.toString(x1));
						int x2 = (int)(Math.random()*5);
						label[1].setText(Integer.toString(x2));
						int x3 = (int)(Math.random()*5);
						label[2].setText(Integer.toString(x3));
						int x4 = (int)(Math.random()*5);
						label[3].setText(Integer.toString(x4));
						int x5 = (int)(Math.random()*5);
						label[4].setText(Integer.toString(x5));
						
						if(x1==x2 && x2==x3 && x3 == x4 && x4 == x5)
							result.setText("축하합니다!!");
						else
							result.setText("아쉽군요");
					}
				}	
			});
			
			
			// 마우스로 게임패널을 클릭하면 포커스를 강제로 가지고 오도록 하기 위한
			addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Component c = (Component)e.getSource();
					c.requestFocus();
				}
			});
		}
	}
	
	static public void main(String[] args) {
		new GamblingGameFrame();
	}
}

