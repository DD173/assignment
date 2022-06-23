package q10;

public class DictionaryApp {

	public static void main(String[] args) {
		Dictionary dic = new Dictionary(10);
		dic.put("황기태", "자바");
		dic.put("이재문", "파이선");
		dic.put("이재문", "C++");  // 이재문의 값을 c++로 수정
		System.out.println("이재문의 값은 " + dic.get("이재문")); // 이재문 아이템 출력
		System.out.println("황기태의 값은 " + dic.get("황기태")); // 황기태 아이템 출력
		dic.delete("황기태"); // 황기태 아이템 삭제
		System.out.println("황기태의 값은 " + dic.get("황기태")); // 삭제된 아이템 접근
	}

}
