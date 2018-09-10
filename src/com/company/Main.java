package com.company;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        int value = 1, valueX, valueY, answer, N5, N4, N3;
        double answerAll = 0, errors = 0, rating;

        String line = new String();
        Scanner in = new Scanner(System.in);
        Random rnd = new Random(System.currentTimeMillis());

        System.out.println("Введите для оценки 5:");
        N5 = in.nextInt();
        System.out.println("Введите для оценки 4:");
        N4 = in.nextInt();
        System.out.println("Введите для оценки 3:");
        N3 = in.nextInt();

        try
        {
            File file = new File("text.txt");
            if (file.exists())      //создаем файл, если его не существует
                file.createNewFile();
            PrintStream ps = new PrintStream(file);

            while (value != 0)
            {
                valueX = 1 + rnd.nextInt(8);
                valueY = 1 + rnd.nextInt(8);
                System.out.print(valueX + "*" + valueY + "=");      //генерируем случайные числа
                answer = in.nextInt();      //считываем ответ пользователя

                if (answer != 0)        //проверка на выход из теста
                {
                    answerAll++;

                    if (answer != valueX * valueY)       //если значение не верное, то запишем пример в файл
                    {
                        ps.println(valueX + "*" + valueY + "=" + valueX * valueY + " (" + answer + ") ");
                        errors++;
                    }
                }
                else
                {
                    value = 0;      //для выхода из цикла
                    ps.close();     //если тест закончен, то закрываем поток записи
                }
            }
        }

        catch (IOException e)
        {
            System.out.println("Ошибка: " + e);
        }

        if (answerAll != errors)        //подсчет рейтинга
            rating = (((answerAll-errors)/answerAll) * 100);
        else

            rating = 0;


        try
        {
            BufferedReader br = new BufferedReader(new FileReader("text.txt"));
            for (int i = 0; i < AddClass.error(rating, errors); i++ )      //выводим ошибки
            {
                line = br.readLine();
                System.out.println(line);
            }
        }

        catch (IOException e )
        {
            System.out.println("Ошибка: " + e);
        }

        if (rating > N5)        //подсчитывание оценки
        {
            System.out.println("Ваша оценка: 5");
            System.out.println("Процент правильных ответов: " + rating);
        }

        else

            if (rating > N4)
            {
                System.out.println("Ваша оценка: 4");
                System.out.println("Процент правильных ответов: " + rating);
            }

            else

                if (rating > N3)
                {
                    System.out.println("Ваша оценка: 3");
                    System.out.println("Процент правильных ответов: " + rating);
                }

                else
                    {
                        System.out.println("Ваша оценка: 2");
                        System.out.println("Процент правильных ответов: " + rating);
                    }
    }
}

