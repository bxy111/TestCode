
public class StringTest {
	public static void main(String[] args) {
		Work1 w=new Work1();
		String str="   fdfds fdhjvgjh jd jds hfds fes    ";
		//1.charAt(index) ����index�ϵ��ַ�
		System.out.println(str.charAt(2));
		//2.concat(s) �ڵ�ǰ�ַ�������ƴ���ַ���
		System.out.println(str.concat("ss"));
		//3.contains(s)�ж��ַ����Ƿ����s
		System.out.println(str.contains(""));
		//4.indexOf(s)�����ַ���s��һ�γ��ֵ�λ��     lastIndexOf(s)�����ַ���s���һ�γ��ֵ�λ��  
		//str.indexOf("fdfdffdddd");
		System.out.println(str.indexOf("fd", 1));
		//5.endsWith(s)�ж��ַ����Ƿ���s��β   startsWith(s) �ж��ַ����Ƿ���s��ͷ
		System.out.println(str.endsWith("es"));
		//6.equals(s) �ж��Ƿ���s����һ��
		System.out.println(str.equals("fd fd s fdhjvgjh jd jds hfd fes"));
		//7.isEmpty()�жϵ�ǰ�ַ����Ƿ�Ϊ�մ�
		System.out.println(str.isEmpty());
		//8.length()�����ַ����ĳ���, ע��: �ַ����ĳ����Ƿ���, ����ĳ���������
		System.out.println(str.length());
		//9.substring(1,2) �ڵ�ǰ�ַ����Ͻ�ȡָ����Χ���Ӵ�
		System.out.println(str.substring(2, 4));
		//10.toCharArray()����ǰ�ַ���ת��������
		char [] ch=str.toCharArray();
		for(int i=0;i<ch.length;i++) {
			System.out.println(ch[i]);
		}
		//11.toUpperCase()ת���ɴ�д  toLowerCase()ת����Сд
		System.out.println(str.toUpperCase());
		//12.trim()ȥ���ַ������ߵĿո�
		System.out.println(str.trim());
		//13.valueOf()���κ�����ת�����ַ���
		System.out.println(String.valueOf(w));
		System.out.println(w.toString());
		
	}	
}
