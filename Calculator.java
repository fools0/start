import java.util.Stack;
import java.math.BigDecimal;
import java.util.Scanner;

public class Calculator {
    /**
     * 优先级比较
     */
    public static int priority(String s)
    {
        if(s.equals("("))
            return 1;
        else if(s.equals(")"))
            return 1;
        else if(s.equals("+"))
            return 2;
        else if(s.equals("-"))
            return 2;
        else if(s.equals("*"))
            return 3;
        else if(s.equals("/"))
            return 3;
        else
            return 0;
    }
    /**
     * 中缀表达式转换为后缀表达式, 各单位间用空格间隔
     */
    public static String change(String str) {
        String result = "";
        int k = 0;//保证第一个运算符入栈
        Stack<String> stack = new Stack<String>();
        String x="";
        for (int j=0;j<str.length();j++)
        {
            if(str.charAt(j)>='0'&&str.charAt(j)<='9'||str.charAt(j)=='.')
            {
                x=x+str.charAt(j);
            }
            else if(str.charAt(j)=='+'||str.charAt(j)=='-'||str.charAt(j)=='*'||str.charAt(j)=='/')
            {
                x=x+" "+str.charAt(j)+" ";
            }
            else if (str.charAt(j)=='(')
            {
                x=x+str.charAt(j)+" ";
            }
            else if(str.charAt(j)==')')
            {
                x=x+" "+str.charAt(j);
            }
        }
        String[] s = x.split(" ");
        for(int i=0; i<s.length; i++) {
            if(isNumber(s[i])) {
                result += s[i] +" ";
            }else {//如果是运算符
                if(!stack.isEmpty())
                {
                    k = priority(stack.peek());
                }
                if(priority(s[i]) > k || s[i].equals("("))
                {
                    stack.push(s[i]);
                }
                else
                {
                    while(!stack.isEmpty())
                    {
                        if(stack.peek().equals("("))
                        {
                            stack.pop();
                            break;
                        }
                        result += stack.pop() + " ";
                    }
                    if(!s[i].equals(")"))//如果不是")"， 压栈,右括号不需要压栈
                    {
                        stack.push(s[i]);
                    }
                }
            }
        }
        while(!stack.isEmpty()) //最后取出栈里的运算符
        {
            result += stack.pop() + " ";
        }
        return result;
    }
    //判断字符是不是数字
    public static boolean isNumber(String str)
    {
        if(str.equals("+") || str.equals("-") || str.equals("*") ||
                str.equals("/") || str.equals("(") || str.equals(")"))
        {
            return false;
        }
        return true;
    }
    /**
     * 进行数值计算
     */
    public static BigDecimal calculation(BigDecimal n1, BigDecimal n2, String c) //利用加减乘除进行运算
    {
        if(c.equals("+"))
            return n1.add(n2);
        else if(c.equals("-"))
            return n1.subtract(n2);
        else if(c.equals("*"))
            return n1.multiply(n2);
        else
            return n1.divide(n2,2,BigDecimal.ROUND_HALF_UP);//保留2位小数并四舍五入

    }

    /**
     * 计算后缀表达式得出结果, 中间以空格为间隔, 使用BigDecimal保证精度
     */
    public static BigDecimal Result(String str) {
        BigDecimal result;
        Stack<BigDecimal> stack = new Stack<BigDecimal>();
        String[] s = str.split(" ");

        for(int i=0; i<s.length; i++)
        {
            if(isNumber(s[i]))
            {
                stack.push(new BigDecimal(s[i]));
            }
            else
            {
                BigDecimal n2 = stack.pop();
                BigDecimal n1 = stack.pop();
                BigDecimal temp = calculation(n1, n2, s[i]);
                stack.push(temp);
            }
        }
        System.out.println("result:" + stack.peek());
        result = stack.pop();
        return result;
    }
    /**
     * 检查输入字符串的合法性
     */
    public  static boolean check(String a) {
        int num1 = 0, num2 = 0;
        for (int i = 0; i < a.length(); i++) {
            if ((a.charAt(i) >= '0' && a.charAt(i) <= '9') || a.charAt(i) == '.' || a.charAt(i) == '+' || a.charAt(i) == '-' || a.charAt(i) == '*' || a.charAt(i) == '/' || a.charAt(i) == '(' || a.charAt(i) == ')')
            {
                if (a.charAt(i) == '(')
                {
                    num1++;
                } else if (a.charAt(i) == ')')
                {
                    num2++;
                }

                if (i == a.length() - 1 && (num1 == num2)) {
                    return true;
                }
            }
                else
                    break;
        }
        return false;
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(true)
        {
            String ss = scanner.nextLine();
           if(check(ss))
           {
               Result(change(ss));
               break;
           }
           else
           {
               System.out.println("您输入的表达式有问题请重新输入\n");
           }
        }
    }
}
