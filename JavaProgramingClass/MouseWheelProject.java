import java.awt.event.*;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MouseWheelProject extends JFrame {
	public MouseWheelProject() {
		super("���콺 ���� ���� ��Ʈ ũ�� ����"); // Ÿ��Ʋ. JFrame(String title)�� �ҷ��� ��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �̰� ������ �޸� �ݳ��� ����
		
		setContentPane(new ProjectPanel()); // ProjectPanel�� ����Ʈ������ ����Ѵ�
		
		setSize(500, 200);
		setVisible(true);
		
		// ��Ŀ�� ����, ����x
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
				if(n<0) { // up direction. ��Ʈ 5�ȼ� �۰�
					fontSize += 5;
					text.setFont(new Font("BOLD", 0, fontSize));
				}
				else { // down direction. ��Ʈ 5�ȼ� �۰�
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
