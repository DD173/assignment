import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamblingGameFrame extends JFrame{
	public GamblingGameFrame() {
		super("�����찡 ���� ����"); // Ÿ��Ʋ. JFrame(String title)�� �ҷ��� ��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �̰� ������ �޸� �ݳ��� ����
		
		setContentPane(new GamePanel()); // GamePanel�� ����Ʈ������ ����Ѵ�
		
		setSize(500, 200);
		setVisible(true);
		
		// GamePanel�� Ű �̺�Ʈ�� ���� �� �ֵ��� ��Ŀ���� �����Ѵ�.
		getContentPane().setFocusable(true);
		getContentPane().requestFocus();
	}

	
	class GamePanel extends JPanel {
		private JLabel [] label = new JLabel [5];
		private JLabel result = new JLabel("�����մϴ�.");
		
		public GamePanel() {
			setLayout(null); // ��ġ������ ���x
			
			for(int i=0; i<label.length; i++) {
				label[i] = new JLabel("0"); // ���̺� ����
				label[i].setSize(60,30); // ���̺� ũ��
				label[i].setLocation(30+80*i, 50); // ���̺� ��ġ
				label[i].setHorizontalAlignment(JLabel.CENTER);
				label[i].setOpaque(true);
				label[i].setBackground(Color.MAGENTA);
				label[i].setForeground(Color.YELLOW);
				label[i].setFont(new Font("Tahoma", Font.ITALIC, 30));
				add(label[i]); // ���̺��� �����Ѵ�.
			}
			
			// ����� ����� ���̺��� �����ϰ� �����̳ʿ� �����Ѵ�.
			result.setSize(200, 30);
			result.setFont(new Font("����ü", 0, 30));
			result.setLocation(100, 120);
			add(result);
			
			// Ű �����ʸ� �����Ѵ�.
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
							result.setText("�����մϴ�!!");
						else
							result.setText("�ƽ�����");
					}
				}	
			});
			
			
			// ���콺�� �����г��� Ŭ���ϸ� ��Ŀ���� ������ ������ ������ �ϱ� ����
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

