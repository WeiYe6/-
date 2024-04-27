package 力扣练习;

import java.util.Objects;

/**
 * 字符串中的单词反转
 * 你在和一位习惯从右往左阅读的朋友发消息，他发出的文字顺序都与正常相反但单词内容正确，为了和他顺利交流你决定写一个转换程序，
 * 把他所发的消息 message 转换为正常语序。
 * 注意：输入字符串 message 中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，
 * 单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * <p>
 * 示例 1：
 * 输入: message = "the sky is blue"
 * 输出:"blue is sky the"
 * <p>
 * 示例 2：
 * 输入: message = " hello world! "
 * 输出:"world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * <p>
 * 示例 3：
 * 输入: message = "a good  example"
 * 输出:"example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * 提示：
 * 1 <= message.length <= 10^4
 * message 中包含英文大小写字母、空格和数字
 * message 中至少有一个单词
 */
public class pro14 {
    public static void main(String[] args) {
        String  message = "   the    sky    is    blue   ";
        System.out.println(reverseMessage(message));
    }
    public static String reverseMessage(String message) {
//        String NewMessage = message.trim();
//        String[] strings = NewMessage.split(" ");
//        StringBuilder sb = new StringBuilder();
//        for (int i = strings.length - 1; i >= 0; i--) {
//            if (!Objects.equals(strings[i], "")){
//                if (i == 0){
//                    sb.append(strings[i]);
//                }else {
//                    sb.append(strings[i]).append(" ");
//                }
//            }
//        }
//        return sb.toString();

        //改进版本
        String[] messageArr = message.trim().split(" ");//去除首尾空格，并分割字符串
        StringBuilder sb = new StringBuilder();
        for (int i = messageArr.length - 1; i >= 0 ; i--) { //倒序遍历数组
            if (!messageArr[i].equals("")){                 //遇到空单词跳过
                sb.append(messageArr[i]).append(" ");       //拼接
            }
        }
        return sb.toString().trim();                        //删除尾部空格
    }



}
