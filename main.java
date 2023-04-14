import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        
        triangleNumberAndFacorial();
        SimpleNumbers();
        System.out.println();
        Calculator();
        Equation();
        
    }

// 1.Вычислить n-ое треугольного число (сумма чисел от 1 до n), 
// n! (произведение чисел от 1 до n)
    public static void triangleNumberAndFacorial() {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите число n: ");
        String n = iScanner.nextLine();
        int num = Integer.parseInt(n);
        int triangleNum = 0;
        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            triangleNum+=i;
            factorial*=i;
        }
        System.out.printf("%d-треугольное число = %d",num,triangleNum);
        System.out.println();
        System.out.printf("факториал числа %d = %d",num,factorial);
        System.out.println();
    }
// Вывести все простые числа от 1 до 1000
    public static void SimpleNumbers() {
        System.out.println("Простые числа от 1 до 1000:");
        for (int i = 1; i <= 1000; i++) {
            Boolean isSimple = true;
            for (int j = 2; j < i; j++) if (i%j == 0) isSimple = false;
            if (isSimple) System.out.print(i + ", ");
        }
    }
//    Реализовать простой калькулятор
    public static void Calculator() {
    Scanner iScanner = new Scanner(System.in);
    String isCont = "yes";
    while (!isCont.equals("no")) {
        System.out.print("Введите 1-ое число: ");
        String str1 = iScanner.nextLine();
        Double number1 = Double.parseDouble(str1);
        System.out.print("Введите 2-ое число: ");
        String str2 = iScanner.nextLine();
        Double number2 = Double.parseDouble(str2);
        System.out.print("Введите операцию (+, -, *, /): ");
        String operation = iScanner.nextLine(); 
        if (operation.equals("+")) 
            System.out.printf("%f + %f = %f", number1,number2,number1+number2);  
        else if (operation.equals("-")) 
            System.out.printf("%f - %f = %f", number1,number2,number1-number2); 
        else if (operation.equals("*")) 
            System.out.printf("%f * %f = %f", number1,number2,number1*number2); 
        else if (operation.equals("/")) 
            System.out.printf("%f / %f = %f", number1,number2,number1/number2); 
        else
            System.out.println("Неправильно введена операция");
        System.out.println();
        System.out.print("Вы хотите выполнить еще одну операцию (yes/no): ");
        isCont = iScanner.nextLine();
    }
   
}
//  +Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть 
//заменены знаком вопроса, например, 2? + ?5 = 69. Требуется восстановить выражение 
//до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет.
// !!! Я предполагаю, что на месте всех знаков вопроса находится одна цифра.
    public static void Equation() {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите уравнение q + w = e: ");
        String str = iScanner.nextLine();
        Boolean isEquation = false;
        str = str.replace(" ", "");
        int plus = str.indexOf("+");
        int equal = str.indexOf("=");
        String num1 = str.substring(0, plus);
        String num2 = str.substring(plus+1, equal);
        String num3 = str.substring(equal+1, str.length());
        for (int i = 0; i < 10; i++) {
            String num1_cor = num1.replace("?", Integer.toString(i));
            String num2_cor = num2.replace("?", Integer.toString(i));
            String num3_cor = num3.replace("?", Integer.toString(i));

            if (Integer.parseInt(num1_cor) + Integer.parseInt(num2_cor) == Integer.parseInt(num3_cor)){
                System.out.printf("%d + %d = %d",Integer.parseInt(num1_cor),Integer.parseInt(num2_cor),Integer.parseInt(num3_cor));
                isEquation = true;
            } 
        }       
        if (!isEquation) System.out.println("Это уравнение не имеет решений");
        
        

        iScanner.close();    
    }
    
}