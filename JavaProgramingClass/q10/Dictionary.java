package q10;

public class Dictionary extends PairMap {

	int i;
	int j=0; 
	
	public Dictionary(int i) { // �迭 �ε��� �Ҵ�
		keyArray = new String[i];
		valueArray = new String[i];
	}

	@Override
	String get(String key) { // key ���� ���� value ����, ������ null ����
		for(i=0;i<=j+1;i++) { // key�� keyArray �迭�� �����ϸ� �����ϴ� valueArray �� ����, �������� ������ null ����
			if(key == keyArray[i])
				return valueArray[i];
		}
		return null;
	}

	@Override
	void put(String key, String value) { // key�� value�� ������ ����, ������ key�� ������, ���� value�� ����
		for(i=0;i<j+1;i++) {
			if(key == keyArray[i]) { // key�� ������ ���� value�� ����
				valueArray[i] = value;
				break;
			}
		}
		if(i==j+1) { // key�� ������ ������ ����
		keyArray[j] = key;
		valueArray[j] = value;
		j++;
		}
		
	}
	
	@Override
	String delete(String key) { // key ���� ���� ������(value�� �Բ�) ����, ������ value �� ����
		for(i=0;i<j+1;i++) {
			if(key == keyArray[i]) { // key�� �迭�� ����
				String deletedValue = valueArray[i]; // ������ �� ������
				for(;i<j;i++) { // key�� value ���� (�迭 �� ĭ�� �ű��)
					keyArray[i] = keyArray[i+1];
					valueArray[i] = valueArray[i+1];
					break;
				}
				valueArray[j] = null; keyArray[j] = null; // ������ �� ����
				j--;
				return deletedValue; // ������ value �� ����
			}
		}
		return "key�� �������� �ʽ��ϴ�.";
	}

	@Override
	int length() { // ���� ����� �������� ���� ����
		return j;
	}

}
