/*!
 * Games Report
 *
 * Generates a table of gamers from a provided .csv file and prints total scores for
 * each gamer. Finally, notes the number of gamers and who holds the top score.
 * Includes ability to add new data to the file.
 *
 * @author Elli
 * @version 1.0.0
 */

// Import Java utilities

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.StringBuilder;

public class GamesReport
{

  /**
   * The main method contains variable declarations and console output.
   *
   * @param args  The command line arguments.
   */
  public static void main(String[] args) throws IOException
  {
    String filePath = "GameScores.csv";

    String newGamer = "Jimmy";
    int[] newScores = {189, 190, 197, 199, 198, 193, 199, 199, 188, 196};

    printReport(filePath, newScores.length);
    addGamer(filePath, newGamer, newScores);
    printReport(filePath, newScores.length);
  }

  /**
   * Simply prints the formatted data table.
   *
   * @param path  The path of the csv file to read from
   * @param cols  The number of score columns
   */
  public static void printReport(String path, int cols) throws IOException
  {
    System.out.println(repeatChars((16 + (8 * cols)), '-'));
    System.out.println("Games Report");
    System.out.println(repeatChars((16 + (8 * cols)), '-'));
    System.out.printf("%-8s", "Gamer");

    // Print X number of score columns
    for (int i = 1; i <= cols; i++)
    {
      System.out.printf("%-8d", i);
    }

    System.out.printf("%-8s%n", "Total");
    System.out.println(repeatChars((16 + (8 * cols)), '-'));

    // Print all the gamers
    ArrayList<ArrayList<String>> gamers = getGamers(path);

    for (ArrayList<String> thisGamer : gamers)
    {
      int gamerTotal = 0;

      for (int j = 0; j < thisGamer.size(); j++)
      {
        System.out.printf("%-8s", thisGamer.get(j));

        // Skip the first index, which we know is the gamer's name
        if (j != 0)
        {
          gamerTotal += Integer.parseInt(thisGamer.get(j).trim());
        }
      }

      System.out.printf("%-8d%n", gamerTotal);
    }

    System.out.println(repeatChars((16 + (8 * cols)), '-'));
    System.out.printf("%-16s%-8d%n", "# of Gamers: ", gamers.size());
    System.out.printf("%-16s%-8s%n", "Top Gamer: ", getTopGamer(path));
    System.out.println(repeatChars((16 + (8 * cols)), '-'));
  }

  /**
   * Returns a specified number of characters as a StringBuilder.
   *
   * @param num  The total number of characters to generate
   * @param sym  The symbol to be repeated
   * @return     A StringBuilder object with the specified number of
   *             repeated characters
   */
  public static StringBuilder repeatChars(int num, char sym)
  {
    StringBuilder symbols = new StringBuilder();

    symbols.append(String.valueOf(sym).repeat(Math.max(0, num)));

    return symbols;
  }

  /**
   * Adds a new gamer to the specified file
   *
   * @param path    The path of the csv file to write to
   * @param name    Name of the new gamer
   * @param scores  An array of the gamer's scores
   */
  public static void addGamer(String path, String name, int[] scores) throws IOException
  {
    File filePath = new File(path);

    // Verify that the file exists and is writable
    if (filePath.exists() && filePath.canWrite())
    {
      FileWriter fw = new FileWriter(filePath, true);
      fw.write(name);

      // Write each round score to the file
      for (int score : scores)
      {
        fw.write("," + score);
      }

      fw.write("\r\n");
      fw.close();

      System.out.printf("%nGamer %s added.%n%n", name);
    }
  }

  /**
   * Gets the name of the top-scoring gamer.
   *
   * @param path  The path of the csv file to read from
   * @return      A String as the name of the top gamer
   */
  public static String getTopGamer(String path) throws IOException
  {
    int highScore = 0;
    String topGamer = "";

    ArrayList<ArrayList<String>> gamers = getGamers(path);

    // Iterating over the indices of rows in the csv...
    for (ArrayList<String> gamer : gamers)
    {
      int tempScore = 0;

      /*
       * Iterating over the indices of columns in the current row...
       * Skip the first column/index, which we know is the gamer's name
       */
      for (int j = 1; j < gamer.size(); ++j) {
        int roundScore = Integer.parseInt(gamer.get(j).trim());
        tempScore += roundScore;
      }

      if (tempScore > highScore) {
        highScore = tempScore;
        topGamer = gamer.get(0);
      }
    }

    return topGamer;
  }

  /**
   * Returns all gamers from the specified csv file.
   *
   * @param path  The path of the csv file to read from
   * @return      An ArrayList of an ArrayList of Strings from the provided file
   */
  public static ArrayList<ArrayList<String>> getGamers(String path) throws IOException
  {
    File filePath = new File(path);
    ArrayList<ArrayList<String>> gamers = null;

    // Verify that the file exists and is readable
    if (filePath.exists() && filePath.canRead())
    {
      gamers = new ArrayList<>();
      BufferedReader br = new BufferedReader(new FileReader(filePath));
      String row;

      while ((row = br.readLine()) != null)
      {
        String[] currentRow = row.split(",");
        ArrayList<String> newGamer = new ArrayList<>();

        for (String col : currentRow)
        {
          newGamer.add(col);
        }

        gamers.add(newGamer);
      }

      br.close();
    }

    return gamers;
  }

}
