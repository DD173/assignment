package q10;

public class Dictionary extends PairMap {

	int i;
	int j=0; 
	
	public Dictionary(int i) { // 배열 인덱스 할당
		keyArray = new String[i];
		valueArray = new String[i];
	}

	@Override
	String get(String key) { // key 값을 가진 value 리턴, 없으면 null 리턴
		for(i=0;i<=j+1;i++) { // key가 keyArray 배열에 존재하면 대응하는 valueArray 값 리턴, 존재하지 않으면 null 리턴
			if(key == keyArray[i])
				return valueArray[i];
		}
		return null;
	}

	@Override
	void put(String key, String value) { // key와 value를 쌍으로 저장, 기존에 key가 있으면, 값을 value로 수정
		for(i=0;i<j+1;i++) {
			if(key == keyArray[i]) { // key가 있으면 값을 value로 수정
				valueArray[i] = value;
				break;
			}
		}
		if(i==j+1) { // key가 없으면 쌍으로 저장
		keyArray[j] = key;
		valueArray[j] = value;
		j++;
		}
		
	}
	
	@Override
	String delete(String key) { // key 값을 가진 아이템(value와 함께) 삭제, 삭제된 value 값 리턴
		for(i=0;i<j+1;i++) {
			if(key == keyArray[i]) { // key가 배열에 존재
				String deletedValue = valueArray[i]; // 삭제될 값 빼놓기
				for(;i<j;i++) { // key와 value 삭제 (배열 한 칸씩 옮기기)
					keyArray[i] = keyArray[i+1];
					valueArray[i] = valueArray[i+1];
					break;
				}
				valueArray[j] = null; keyArray[j] = null; // 마지막 값 삭제
				j--;
				return deletedValue; // 삭제된 value 값 리턴
			}
		}
		return "key가 존재하지 않습니다.";
	}

	@Override
	int length() { // 현재 저장된 아이템의 개수 리턴
		return j;
	}

}
