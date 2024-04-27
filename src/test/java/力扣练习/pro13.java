package 力扣练习;

import java.util.Arrays;

/**
 * 路径加密
 * 假定一段路径记作字符串 path，其中以 "." 作为分隔符。现需将路径加密，加密方法为将 path 中的分隔符替换为空格 " "，请返回加密后的字符串。
 * <p>
 * 示例 1：
 * 输入：path = "a.aef.qerf.bb"
 * 输出："a aef qerf bb"
 */
public class pro13 {

    public static void main(String[] args) {
        String path = "a.aef.qerf.bb";
        System.out.println(pathEncryption(path));
    }

    public static String pathEncryption(String path) {
        char[] charArray = path.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (char c : charArray) {
            if (c == '.') {
                sb.append(' ');
            } else {
               sb.append(c);
            }
            i++;
        }
        return new String(sb);
    }
}
