import java.util.Scanner;

public class Main
{
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args)
    {
        boolean flag = true;
        while (flag)
        {
            System.out.println("Введите номер задачи или 0, чтобы выйти");
            int num = in.nextInt();
            switch (num)
            {
                case 1:
                    task1();
                    break;
                case 2:
                    task2();
                    break;
                case 3:
                    task3();
                    break;
                case 4:
                    task4();
                    break;
                case 5:
                    task5();
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Такой задачи не найдено");
            }
        }
    }

    static void task1()
    {
        System.out.println("Введите натуральное число:");
        int n = in.nextInt();
        int step = 0;
        while (n > 1)
        {
            if (n % 2 == 0)
            {
                n = n / 2;
            }
            else
            {
                n = (3 * n) + 1;
            }
            step++;
        }
        System.out.printf("Количество шагов: %d\n", step);
    }

    static void task2()
    {
        System.out.println("Введите натуральное число:");
        int n = in.nextInt();
        int res = 0;

        for (int i = 0; i < n; i++)
        {
            int iNum = in.nextInt();
            if (i % 2 == 0)
            {
                res += iNum;
            }
            else
            {
                res -= iNum;
            }
        }
        System.out.printf("Сумма ряда: %d\n ", res);
    }

    static void task3()
    {

        System.out.println("Введите координаты клада: ");
        int endX = in.nextInt();
        int endY = in.nextInt();
        in.nextLine();
        int x_0 = 0;
        int y_0 = 0;
        int count = 0;
        int minCommand = Integer.MAX_VALUE;

        System.out.println("Введите команды и кол-во шагов: ");
        while (true)
        {
            String command = in.nextLine();
            if (command.equals("стоп"))
            {
                break;
            }
            int steps = in.nextInt();
            in.nextLine();
            switch (command)
            {
                case "север":
                    y_0 += steps;
                    break;
                case "юг":
                    y_0 -= steps;
                    break;
                case "восток":
                    x_0 += steps;
                    break;
                case "запад":
                    x_0 -= steps;
                    break;
                default:
                    System.out.println("Неверное направление: " + command);
                    continue;
            }
            count++;
            if (x_0 == endX && y_0 == endY)
            {
                minCommand = Math.min(minCommand, count);
            }
        }

        if (minCommand == Integer.MAX_VALUE)
        {
            System.out.printf("Клад не найден, карта не верна. Текущие координаты: (%d,%d)\n",x_0,y_0);
        }
        else
        {
            System.out.printf("Мин кол-во шагов: %d\n",minCommand);
        }
    }

    static void task4()
    {
        System.out.println("Введите кол-во дорог");
        int numRoad = in.nextInt();
        int maxHeight = 0;
        int finalRoad = 0;

        for (int i = 1; i <= numRoad; i++)
        {
            System.out.printf("Введите кол-во туннелей для %d дороги\n", i);
            int numSub = in.nextInt();
            System.out.println("Введите высоты");
            int minHeight = Integer.MAX_VALUE;
            for (int j = 0; j < numSub; j++)
            {
                int subHeight = in.nextInt();
                if (subHeight < minHeight)
                {
                    minHeight = subHeight;
                }
            }
            if (minHeight > maxHeight)
            {
                maxHeight = minHeight;
                finalRoad = i;
            }
        }
        System.out.printf("%d %d\n", finalRoad, maxHeight);
    }

    static void task5()
    {
        System.out.println("Введите целое трехзначное число");
        int num = in.nextInt();
        int digit1 = num / 100;
        int digit2 = (num / 10) % 10;
        int digit3 = num % 10;

        if (num > 99 && num < 1000)
        {
            int sum = digit1 + digit2 + digit3;
            int mult = digit1 * digit2 * digit3;

            if ((sum % 2 == 0) && (mult % 2 == 0))
            {
                System.out.println("Число является дважды четным");
                System.out.printf("Сумма цифр %d\n", sum);
                System.out.printf("Произведение цифр %d\n", mult);
            }
            else
            {
                System.out.println("Число не является дважды четным");
            }
        }
        else
        {
            System.out.println("Некорректно введенное число");
        }
    }
}