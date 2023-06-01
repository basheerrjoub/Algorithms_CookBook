
public class Main {
    public static void main(String[] args) {

        String str1 = "listen";
        String str2 = "silent";

        System.out.println(checkPermutaion(str1, str2));

    }

    public static boolean checkPermutaion(String str1, String str2){
        str1 = sortString(str1);
        str2 = sortString(str2);

        if(str1.length() != str2.length())
            return false;

    return str1.equals(str2);

    }
    public static String sortString(String s){
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

}