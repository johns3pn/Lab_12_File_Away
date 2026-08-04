import java.util.Scanner;

public class SafeInput
{
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";

        do
        {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        }
        while(retString.length() == 0);

        return retString;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String response;

        do
        {
            System.out.print("\n" + prompt + " [Y/N]: ");
            response = pipe.nextLine().trim().toUpperCase();
        }
        while(!(response.equals("Y") || response.equals("N")));

        return response.equals("Y");
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int value;

        while(true)
        {
            System.out.print("\n" + prompt + ": ");

            if(pipe.hasNextInt())
            {
                value = pipe.nextInt();
                pipe.nextLine();

                if(value >= low && value <= high)
                {
                    return value;
                }
                else
                {
                    System.out.println("Value must be between " + low + " and " + high + ".");
                }
            }
            else
            {
                System.out.println("Invalid integer.");
                pipe.nextLine();
            }
        }
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String value;

        while(true)
        {
            System.out.print("\n" + prompt + ": ");
            value = pipe.nextLine();

            if(value.matches(regEx))
            {
                return value;
            }
            else
            {
                System.out.println("Input does not match the required format.");

            }
        }
    }
}
