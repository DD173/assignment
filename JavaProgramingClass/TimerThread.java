package ex;
import javax.swing.*;

class TimerThread extends Thread {
	private JLabel timerLabel;
	
	public TimerThread(JLabel timerLabel) {
		this.timerLabel = timerLabel;
	}
	
	@Override
	public void run() {
		int n = 0;
		while(true) {
			timerLabel.setText(Integer.toString(n)); // n 표시
			n++;
			try {
				Thread.sleep(1000); // 1초 가만히
			} catch(InterruptedException e) {
				return;
			}
		}
	}
}



