package page246;

public class Dictionary {
		
		private static String [] kor = {"���", "�Ʊ�", "��", "�̷�", "���"};
		private static String [] eng = {"love", "baby", "money", "future", "hope"};
		static int j;
		
		public static String kor2Eng(String word) {
			return eng[j];
		}
		
		/* �Է¹��� �ܾ ������ �ִ� �� Ȯ���ϴ� �޼ҵ� */
		public static boolean findWord (String word) {
			for(int i=0;i<kor.length;i++) {
				if(word.equals(kor[i])) {
					j = i;
					return true;
				}
			}
			return false;
		}
		
}
