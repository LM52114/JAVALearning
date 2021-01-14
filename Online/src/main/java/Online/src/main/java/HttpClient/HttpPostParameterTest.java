package Online.src.main.java.HttpClient;

import java.util.regex.Pattern;

/**
 * @Author Li Hao
 * @Date 2020/12/26 23:20
 * @Version 1.0
 */
public class HttpPostParameterTest {

    public static void main(String[] args) {
        boolean result = false;
        String s1 = "2*2";

        if (isNumber(s1)) {
            Integer integer = Integer.valueOf(s1);
            if(integer>1&&integer<10){

            }else if(integer==1||integer==0){

            }else{

            }
        } else {
            String[] split = s1.split("\\*");
            if (!s1.endsWith("*") && !s1.startsWith("*") && split.length == 2 && split[0].equals(split[1]) && isNumber(split[0]) && isNumber(split[1]) && Integer.valueOf(split[0]) > 1) {
                result = true;
            } else {
                result = false;
            }
        }
        System.out.println("result = " + result);
    }

    private static boolean isNumber(String s) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(s).matches();
    }
}
