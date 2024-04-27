package 力扣练习;

import java.util.Arrays;

/**
 * 动态口令
 * 某公司门禁密码使用动态口令技术。初始密码为字符串 password，密码更新均遵循以下步骤：
 * 设定一个正整数目标值 target
 * 将 password 前 target 个字符按原顺序移动至字符串末尾
 * 请返回更新后的密码字符串。
 * <p>
 * 示例 1：
 * 输入: password = "s3cur1tyC0d3", target = 4
 * 输出: "r1tyC0d3s3cu"
 * <p>
 * 示例 2：
 * 输入: password = "lrloseumgh", target = 6
 * 输出:"umghlrlose"
 */
public class pro15 {

    public static void main(String[] args) {
        String  password = "lrloseumgh";
        int target = 6;
        System.out.println(dynamicPassword(password, target));
    }
    public static String dynamicPassword(String password, int target) {
        //------方法三:列表遍历拼接---------
        //若面试规定不允许使用 切片函数 ，则使用此方法。
//        StringBuilder sb = new StringBuilder();
//        //先添加target之后的字符。
//        for (int i = target; i < password.length(); i++) {
//            sb.append(password.charAt(i));
//        }
//        //再添加target及target之前的字符。
//        for (int i = 0; i < target; i++) {
//            sb.append(password.charAt(i));
//        }
//        return sb.toString();


        //------方法二:字符串切片----------
        //1.先切target之后的字符串出来
//        String preStr = password.substring(target, password.length());
//        //2.再切target之前的字符串出来
//        String sufstring = password.substring(0, target);
//        return preStr + sufstring;


        //-----方法三:字符串拼接
        //若规定 Java 只能用 String ，则使用此方法。
        String res = "";
        for (int i = target; i < password.length(); i++){
            res = res + password.charAt(i);
        }
        for (int i = 0; i < target; i++){
            res = res + password.charAt(i);
        }
        return res;
    }
}
