package q10;

public class DictionaryApp {

	public static void main(String[] args) {
		Dictionary dic = new Dictionary(10);
		dic.put("Ȳ����", "�ڹ�");
		dic.put("���繮", "���̼�");
		dic.put("���繮", "C++");  // ���繮�� ���� c++�� ����
		System.out.println("���繮�� ���� " + dic.get("���繮")); // ���繮 ������ ���
		System.out.println("Ȳ������ ���� " + dic.get("Ȳ����")); // Ȳ���� ������ ���
		dic.delete("Ȳ����"); // Ȳ���� ������ ����
		System.out.println("Ȳ������ ���� " + dic.get("Ȳ����")); // ������ ������ ����
	}

}