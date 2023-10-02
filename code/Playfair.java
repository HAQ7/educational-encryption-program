class Playfair extends Cipher
{  
  private String [][] key = new String[5][5];
  private int numOfElements;
  private boolean overflowed;

  public Playfair(String name)
  {
    super(name);
  }
  public void displayKey() {
    for(int i = 0; i < 5; i++) {
      System.out.println("\n---------------");
      for(int j = 0; j < 5; j++) {
        System.out.print("|" + key[i][j] + "|");
      }
    }
    System.out.println("---------------");
  }

  public void encrypt()
  {
    displayKey();
    System.out.println("\n----------------------------------------------");
    String copyText = encryptedText = "";
    int count = 0;
    int countR = 0;
    int countC = 0;

    for(int i = 0; i < plainText.length(); i+=2)
    {
      if (i+1 < plainText.length())
        if (Character.toUpperCase(plainText.charAt(i)) == Character.toUpperCase(plainText.charAt(i+1)))
          copyText = copyText.concat(plainText.charAt(i) + "x" + plainText.charAt(i+1));
        
        else copyText = copyText.concat("" + plainText.charAt(i) + plainText.charAt(i+1));
    }

    if (plainText.length() % 2 != 0) 
      copyText = copyText.concat("" + plainText.charAt(plainText.length()-1));

    if (copyText.length() % 2 != 0)
      copyText = copyText.concat("z");

    

    for(;count < copyText.length(); count+=2)
    {
      char firstLetter = Character.toUpperCase(copyText.charAt(count));
      int firstR = 0;
      int firstC = 0;

      char secondLetter = Character.toUpperCase(copyText.charAt(count+1));
      int secondR = 0;
      int secondC = 0;

      while (true)
      {
        if (key[countR][countC].length() == 2 && ((key[countR][countC].charAt(0) == firstLetter) || (key[countR][countC].charAt(1) == firstLetter)))
        {
            firstR = countR;
            firstC = countC;
            countR = 0;
            countC = 0;
            break;
        
        }

        else if ((key[countR][countC].charAt(0) == firstLetter))
        {
          firstR = countR;
          firstC = countC;
          countR = 0;
          countC = 0;
          break;
        }

        else if (countC == (key[countR].length - 1))
        {
          countR++;
          countC = 0;
        }

        else countC++;
      }

      while (true)
      {
        if (key[countR][countC].length() == 2)
        {
          if ((key[countR][countC].charAt(0) == secondLetter) || (key[countR][countC].charAt(1) == secondLetter))
          {
            secondR = countR;
            secondC = countC;
            countR = 0;
            countC = 0;
            break;
          }

          else if (countC == (key[countR].length - 1))
        {
          countR++;
          countC = 0;
        }

          else countC++;
        }

        else if ((key[countR][countC].charAt(0) == secondLetter))
        {
          secondR = countR;
          secondC = countC;
          countR = 0;
          countC = 0;
          break;
        }

        else if (countC == (key[countR].length - 1))
        {
          countR++;
          countC = 0;
        }

        else countC++;
      }

      
      if (firstR == secondR)
      {
        int temp1 = firstC;
        int temp2 = secondC;

        if (temp1 == (key[countR].length - 1))
          temp1 = 0;
        else temp1++;

        if (temp2 == (key[countR].length - 1))
          temp2 = 0;
        else temp2++;

        encryptedText = encryptedText.concat("" + key[firstR][temp1].charAt(0) + key[secondR][temp2].charAt(0));
        System.out.println(key[firstR][firstC].charAt(0) + " and " + key[secondR][secondC].charAt(0) + " are on the same row so they become: " + key[firstR][temp1].charAt(0) + " and " + key[secondR][temp2].charAt(0));
      }

      else if (firstC == secondC)
      {
        int temp1 = firstR;
        int temp2 = secondR;

        if (temp1 == (key[countR].length - 1))
          temp1 = 0;
        else temp1++;

        if (temp2 == (key[countR].length - 1))
          temp2 = 0;
        else temp2++;

        encryptedText = encryptedText.concat("" + key[temp1][firstC].charAt(0) + key[temp2][secondC].charAt(0));
        System.out.println(key[firstR][firstC].charAt(0) + " and " + key[secondR][secondC].charAt(0) + " are on the same column so they become: " + key[temp1][firstC].charAt(0) + " and " + key[temp2][secondC].charAt(0));
      }

      else
      {
        encryptedText = encryptedText.concat("" + key[firstR][secondC].charAt(0) + key[secondR][firstC].charAt(0));
        System.out.println(key[firstR][firstC].charAt(0) + " and " + key[secondR][secondC].charAt(0) + " are on diffrent row and column so they become: " + key[firstR][secondC].charAt(0) + " and " + key[secondR][firstC].charAt(0));
      }
    }
    System.out.println("\n----------------------------------------------");
    System.out.println("Final output: " + encryptedText);
  }

  public void decrypt()
  {
    displayKey();
    System.out.println("----------------------------------------------");
    System.out.println("since we are decrypting we will reverse anything we do, (instead of going up go down, and so on....)");
    System.out.println("and remove any x between any two of the same letter and remove any z at the end of sequence");
    String copyText = "";
    int count = 0;
    int countR = 0;
    int countC = 0;

    for(;count < encryptedText.length(); count+=2)
    {
      char firstLetter = Character.toUpperCase(encryptedText.charAt(count));
      int firstR = 0;
      int firstC = 0;

      char secondLetter = Character.toUpperCase(encryptedText.charAt(count+1));
      int secondR = 0;
      int secondC = 0;

      while (true)
      {
        if ((key[countR][countC].charAt(0) == firstLetter))
        {
          firstR = countR;
          firstC = countC;
          countR = 0;
          countC = 0;
          break;
        }

        else if (countC == (key[countR].length - 1))
        {
          countR++;
          countC = 0;
        }

        else countC++;
      }

      while (true)
      {
        if ((key[countR][countC].charAt(0) == secondLetter))
        {
          secondR = countR;
          secondC = countC;
          countR = 0;
          countC = 0;
          break;
        }

        else if (countC == (key[countR].length - 1))
        {
          countR++;
          countC = 0;
        }

        else countC++;
      }

      
      if (firstR == secondR)
      {
        int temp1 = firstC;
        int temp2 = secondC;

        if (temp1 == 0)
          temp1 = 4;
        else temp1--;

        if (temp2 == 0)
          temp2 = 4;
        else temp2--;

        copyText = copyText.concat(key[firstR][temp1] + key[secondR][temp2]);
        System.out.println(key[firstR][firstC].charAt(0) + " and " + key[secondR][secondC].charAt(0) + " are on the same row so they become: " + key[firstR][temp1].charAt(0) + " and " + key[secondR][temp2].charAt(0));
      }

      else if (firstC == secondC)
      {
        int temp1 = firstR;
        int temp2 = secondR;

        if (temp1 == 0)
          temp1 = 4;
        else temp1--;

        if (temp2 == 0)
          temp2 = 4;
        else temp2--;

        copyText = copyText.concat(key[temp1][firstC] + key[temp2][secondC]);
        System.out.println(key[firstR][firstC].charAt(0) + " and " + key[secondR][secondC].charAt(0) + " are on the same column so they become: " + key[temp1][firstC].charAt(0) + " and " + key[temp2][secondC].charAt(0));
      }

      else
      {
        copyText = copyText.concat(key[firstR][secondC] + key[secondR][firstC]);
        System.out.println(key[firstR][firstC].charAt(0) + " and " + key[secondR][secondC].charAt(0) + " are on diffrent row and column so they become: " + key[firstR][secondC].charAt(0) + " and " + key[secondR][firstC].charAt(0));
      }
    }
    plainText = copyText;
    System.out.println("----------------------------------------------");
    System.out.println("Final output: " + plainText);
  }

  private boolean exist(char letter)
  {
    for (int i=0, countR=0, countC=0; i < numOfElements; i++, countC++)
    {
      if (countC == 5)
      {
        countR++;
        countC = 0;
      }

      if (key[countR][countC].length() == 2) {
        if ((key[countR][countC].charAt(0) == Character.toUpperCase(letter)) || (key[countR][countC].charAt(1) == Character.toUpperCase(letter))) return true;
      }
      else if (key[countR][countC].charAt(0) == Character.toUpperCase(letter)) {
        return true;
      } 
    }
    
    return false;
  }

  public boolean add(String letter)
  {
    if (letter.length() == 1 &&exist(letter.charAt(0))) {
      System.out.print("please enter ij or a single letter you have not entered before: ");  
      return false;
    } 
    if (letter.length() == 2 &&exist(letter.charAt(0))){
      System.out.print("please enter ij or a single letter you have not entered before: ");      
      return false;
    } 
    else if (letter.length() == 2 &&exist(letter.charAt(1))){
      System.out.print("please enter ij or a single letter you have not entered before: ");
      return false;
    }

    if (numOfElements<25 &&letter.length() == 1)
    {
      if (letter.equals("i") || letter.equals("j")) {

        System.out.print("please only enter i or j together a single letter you have not entered before:");
        return false;
      }
      else {
        key[(int) numOfElements/5][numOfElements%5] = letter.toUpperCase();
        numOfElements++;
        return true;
      }
    }

    else if (numOfElements<25 &&letter.length() == 2 &&!overflowed && letter.charAt(0) ==  'i')
    {
      key[(int) numOfElements/5][numOfElements%5] = letter.toUpperCase();
      numOfElements++;
      return overflowed = true;
       
    }
    
    else {
      System.out.print("please enter ij or a single letter you have not entered before: ");
      return false;
    } 
  }
}