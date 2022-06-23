import java.awt.event.*;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MouseWheelProject extends JFrame {
	public MouseWheelProject() {
		super("마우스 휠을 굴려 폰트 크기 조정"); // 타이틀. JFrame(String title)을 불러온 것
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 이거 없으면 메모리 반납을 못함
		
		setContentPane(new ProjectPanel()); // ProjectPanel을 컨텐트팬으로 등록한다
		
		setSize(500, 200);
		setVisible(true);
		
		// 포커스 설정, 강제x
		getContentPane().setFocusable(true);
	}
	
	class ProjectPanel extends JPanel {
		private JLabel text = new JLabel("Love Java");
		int fontSize = 20;
		
		public ProjectPanel() {
			
			text.setSize(500, 200);
			text.setLocation(200, 0);
			text.setFont(new Font("BOLD", 0, fontSize));
			add(text);
		
		
		text.addMouseWheelListener(new MouseWheelListener() {

			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				int n = e.getWheelRotation();
				if(n<0) { // up direction. 폰트 5픽셀 작게
					fontSize += 5;
					text.setFont(new Font("BOLD", 0, fontSize));
				}
				else { // down direction. 폰트 5픽셀 작게
					fontSize -= 5;
					text.setFont(new Font("BOLD", 0, fontSize));
				}
			}
		});
		
		}
	}
	
	static public void main(String[] args) {
		new MouseWheelProject();
	}
}
