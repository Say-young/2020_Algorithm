package lab;

import java.util.*;

public class Week10_2_�弼�� {

	public static void main(String[] args) {
		
		System.out.println("=============");
		System.out.println("���� : ��ǻ�Ͱ���");
		System.out.println("�й� : 1871047");
		System.out.println("���� : �弼��");
		System.out.println("=============");
		
		//map ����, key-string, value-string
		Map<String, String> Stmap = new HashMap<String, String>();
		//�Է¹ޱ�
		Scanner scanner = new Scanner(System.in);
		String ID, name;
		ID = null;
		System.out.println("�л��� ID�� �̸��� ���ʷ� �Է��ϼ���. (����� 0 0 �Է�)");
		//�ݺ���
		while(true) {
			ID = scanner.next();
			name = scanner.next();
			if(ID.equals("0")==false) //ID�� 0�� �ƴ� �ٸ� ���� �ԷµǸ�
				Stmap.put(ID, name); //ID�� key, name�� value�� haspmap�� ����
			else //0 0�� �Է¹��� ��� �ݺ��� Ż��
				break;
		}
		
		
		System.out.println("<�л����>");
		System.out.println("[ID]\t\t[NAME]");
		Set s = Stmap.keySet(); //key������ set �����
		Iterator<String> it = s.iterator(); //iterator ����
		String str = null;
		int count = 0;
		
		while(it.hasNext()) { //���� ���Ұ� ������ �ݺ�
			str = it.next(); //���� iterator�� �Է¹��� key�� str�� ����
			System.out.println(str+"\t\t"+Stmap.get(str)); //�ش� key�� value ���
			count++; //count+1
		}
		
		Set a = Stmap.keySet(); //�ִ���� �ּұ��� ���ϱ� ���� �ٽ� key������ ���ο� set ����
		it = a.iterator();
		String longNameID, shortNameID;
		longNameID = shortNameID = it.next(); //���� �� �̸��� id�� ���� ª�� �̸��� id�� ���� ������ ù��° Ű���� �־� �ʱ�ȭ
		String longname, shortname;
		longname = shortname = Stmap.get(it.next()); //���� �� �̸��� ���� ª�� �̸��� ���� ������ ù��° Ű���� �ش��ϴ� value�� �־� �ʱ�ȭ

		while(it.hasNext()) { //���� ���Ұ� ������ �ݺ�
			str = it.next(); //���� iterator�� �Է¹��� key�� str�� ����
			if(Stmap.get(str).length()>longname.length()) { //�ش� key�� value�� ���̰� longname�� ���̺��� ���
				longname = Stmap.get(str); //longname������ �ش� value�� �����ϰ�
				longNameID = str; //longNameID�� �ش� key�� ����
			}
			if(Stmap.get(str).length()<shortname.length()) { //�ش� key�� value�� ���̰� shortname�� ���̺��� ª����
				shortname = Stmap.get(str); //shortname ������ �ش� value�� �����ϰ�
				shortNameID = str; //shortNameID�� �ش� key�� ����
			}
		}
		
		//��� ���
		System.out.println("\n��ü �л���: "+count);
		System.out.println("<���� �� �̸��� ���� �л�>");
		System.out.println("ID:"+longNameID+" Name:"+longname+" ����:"+longname.length());
		System.out.println("<���� ª�� �̸��� ���� �л�>");
		System.out.println("ID:"+shortNameID+" Name:"+shortname+" ����:"+shortname.length());
	}

}
