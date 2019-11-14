public class Practice3 {
    public static void main(String[] args) {
        String str="   fdsa fdsasf fsdafsdafsadf asfsadfsa fsaf dfsdad    ";
        System.out.println(str.charAt(5));
        System.out.println(str.concat("ss"));
        System.out.println(str.contains(""));
        System.out.println(str.indexOf("fd", 1));
        System.out.println(str.endsWith("es"));
        System.out.println(str.equals("fsadf sdfas fs afas "));
        System.out.println(str.isEmpty());
        System.out.println(str.length());
        System.out.println(str.substring(2, 4));
        char [] ch=str.toCharArray();
        for(int i=0;i<ch.length;i++) {
            System.out.print(ch[i] + " ");
        }
        System.out.println();
        System.out.println(str.toUpperCase());
        System.out.println(str.trim());
        int w = 1233123;
        System.out.println(String.valueOf(w));
    }
}
