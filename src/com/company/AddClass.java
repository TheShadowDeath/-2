package com.company;

public class AddClass
{
    public static double error(double rating, double errors)
    {
        double counter;

        if (rating < 41)
        {
            if (errors > 5)     //кол-во выводимых ошибок
                counter = 5;
            else
                counter = errors;
        }

        else
            counter = errors;

        return counter;
    }
}
