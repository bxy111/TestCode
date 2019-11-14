
public class StringTest {
	public static void main(String[] args) {
		Work1 w=new Work1();
		String str="   fdfds fdhjvgjh jd jds hfds fes    ";
		//1.charAt(index) 返回index上的字符
		System.out.println(str.charAt(2));
		//2.concat(s) 在当前字符串后面拼接字符串
		System.out.println(str.concat("ss"));
		//3.contains(s)判断字符串是否包含s
		System.out.println(str.contains(""));
		//4.indexOf(s)返回字符串s第一次出现的位置     lastIndexOf(s)返回字符串s最后一次出现的位置  
		//str.indexOf("fdfdffdddd");
		System.out.println(str.indexOf("fd", 1));
		//5.endsWith(s)判断字符串是否以s结尾   startsWith(s) 判断字符串是否以s开头
		System.out.println(str.endsWith("es"));
		//6.equals(s) 判断是否与s长得一样
		System.out.println(str.equals("fd fd s fdhjvgjh jd jds hfd fes"));
		//7.isEmpty()判断当前字符串是否为空串
		System.out.println(str.isEmpty());
		//8.length()返回字符串的长度, 注意: 字符串的长度是方法, 数组的长度是属性
		System.out.println(str.length());
		//9.substring(1,2) 在当前字符串上截取指定范围的子串
		System.out.println(str.substring(2, 4));
		//10.toCharArray()将当前字符串转化成数组
		char [] ch=str.toCharArray();
		for(int i=0;i<ch.length;i++) {
			System.out.println(ch[i]);
		}
		//11.toUpperCase()转化成大写  toLowerCase()转化成小写
		System.out.println(str.toUpperCase());
		//12.trim()去掉字符串两边的空格
		System.out.println(str.trim());
		//13.valueOf()将任何类型转化成字符串
		System.out.println(String.valueOf(w));
		System.out.println(w.toString());
		
	}	
}
