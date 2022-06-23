package page246;

public class Dictionary {
		
		private static String [] kor = {"사랑", "아기", "돈", "미래", "희망"};
		private static String [] eng = {"love", "baby", "money", "future", "hope"};
		static int j;
		
		public static String kor2Eng(String word) {
			return eng[j];
		}
		
		/* 입력받은 단어가 사전에 있는 지 확인하는 메소드 */
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
