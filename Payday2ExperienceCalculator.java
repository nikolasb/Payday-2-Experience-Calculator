/**
* This program calculates the amount of experience needed in the video game Payday 2.
*
* @author   Nikolas Beltran
* @version  1.0
* @since    2017-08-05
*/

import java.util.Scanner;

public class Payday2ExperienceCalculator
{
    private static int[] levels = {900, 1250, 1550, 1850, 2200, 2600, 3000, 3500, 4000, 4600, 4601, 4611, 4637, 4687, 4771, 4895, 5068, 5299, 5595, 5965, 6417, 6959, 7600, 8347, 9208, 10193, 11308, 12563, 13965, 15523, 17245, 19139, 21213, 23476, 25935, 28599, 31476, 34574, 37902, 41467, 45278, 49342, 53670, 58267, 63143, 68306, 73763, 79524, 85596, 91988, 98707, 105762, 113161, 120913, 129025, 137506, 146363, 155606, 165242, 175279, 185726, 196591, 207881, 219606, 231774, 244392, 257468, 271012, 285031, 299533, 314527, 330021, 346022, 362540, 379582, 397156, 415271, 433936, 453157, 472943, 493303, 514245, 535776, 557906, 580642, 603992, 627965, 652569, 677811, 703701, 730247, 757456, 785336, 813897, 843146, 873091, 903741, 935104, 967187, 1000000};
    private static int totalExperience = 23336413;

    /**
    * Calculates the amount of experience needed to reach level one hundred from a lower level.
    *
    * @param    level   The current level of the player.
     */
    private static void calculateExperience(int level)
    {
        int requiredExperience = 0;
        for(int i = level; i < levels.length; i++)
        {
            requiredExperience += levels[i];
        }
        System.out.format("Required Experience: %,d%nYou have %.2f%% of the required %,d experience.%n%n", requiredExperience, experiencePercentage(totalExperience - requiredExperience), totalExperience);
    }

    /**
    * Calculates the percent of total experience gained.
    *
    * @param    experience  The current amount of experience obtained so far.
    */
    private static float experiencePercentage(int experience)
    {
        return (((float)experience / totalExperience) * 100);
    }

    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        int end = 0;

        while(end == 0)
        {
            System.out.println("Please enter your current level or type \"exit\" to close the application.");
            if(scanner.hasNextInt())
            {
                int levelHolder = scanner.nextInt();
                if(levelHolder >= 0 && levelHolder <= 100)
                {
                    calculateExperience(levelHolder);
                }
                else
                {
                    System.out.println("Please enter a number from zero to one hundred.");
                }
            }
            else if(scanner.next().equalsIgnoreCase("exit"))
            {
                System.out.println("Good bye.");
                end = 1;
            }
        }
        scanner.close();
    }
}