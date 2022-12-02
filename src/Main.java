import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTrack = new StepTracker();
        Converter ConverterSteps = new Converter();
        printMenu();
        int userInput = scanner.nextInt();
        double totalSteps = 0;
        double targetAmountSteps = 10000;
        int amountDays = 30;

        while (userInput != 4)
        {
            if (userInput == 1)
            {

                System.out.println("В каком месяце Вы хотите ввести значение: 1-ЯНВ, 2-ФЕВР, 3-МАРТ, 4-АПР, 5-МАЙ, 6-ИЮНЬ, 7-ИЮЛЬ, 8-АВГ, 9-СТБР, 10-ОКТБ, 11-НБР, 12-ДЕК?");
                int month = scanner.nextInt();
                while (month < 1 | month > 12)
                {
                    System.out.println("Введите корректное значение:");
                    month = scanner.nextInt();
                }
                System.out.println("Введите номер дня:");
                int day = scanner.nextInt();
                while (day < 1 | day > amountDays)
                {
                    System.out.println("Введите корректное значение:");
                    day = scanner.nextInt();
                }
                System.out.println("Введите значение:");
                double steps = scanner.nextInt();
                while (steps < 0)
                {
                    System.out.println("Введите корректное значение:");
                    steps = scanner.nextInt();
                }
                stepTrack.SaveTrack(steps,month,day);

            }
            else if (userInput == 2)
            {
                System.out.println("За какой месяц Вы хотите вывести статистику: 1-ЯНВ, 2-ФЕВР, 3-МАРТ, 4-АПР, 5-МАЙ, 6-ИЮНЬ, 7-ИЮЛЬ, 8-АВГ, 9-СТБР, 10-ОКТБ, 11-НБР, 12-ДЕК?");
                int month = scanner.nextInt();
                int amount = 0;
                for (int i = 1; i < amountDays-1; i++)
                {
                    System.out.print(""+i+" день: "+stepTrack.ViewSteps(month,i-1)+", ");
                    totalSteps = totalSteps + stepTrack.ViewSteps(month,i-1);
                    if (stepTrack.ViewSteps(month,i-1) >= targetAmountSteps) {amount = amount+1;};
                }
                System.out.println("Максимальное пройденное количество шагов в месяце: " +totalSteps);
                System.out.println("Среднее пройденное количество шагов в месяце: " +totalSteps/30);
                System.out.println("Пройденная дистанция в км.: " + ConverterSteps.convertStepstoDistance(totalSteps));
                System.out.println("Количество сожжённых килокалорий: "+ConverterSteps.convertStepstoKiloCalories(totalSteps));
                System.out.println("Максимальное количество подряд идущих дней, в течение которых количество шагов за день было равно или выше целевого: "+amount);
                totalSteps = 0;
            }
            else if (userInput == 3)
            {
                System.out.println("Веедите целевое значение");
                targetAmountSteps = scanner.nextInt();
            }
            printMenu();
            userInput = scanner.nextInt();
        }
        System.out.println("Программа завершена");
    }

    public static void printMenu()
    {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день;");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("4 - Выйти из этого приложения");
    }
}
