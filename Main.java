import java.util.Scanner;
public class Main{
    public static void main(String[] args){
    BanList test = new BanList();
    test.banning("potato");
    System.out.println(test.current());
    test.banning("potato");
    System.out.println(test.current());
  //  System.out.println(test);
    test.banning("abbles");
    System.out.println(test.current());
    test.banning("potato");
    System.out.println(test.current());
    
    String close="";
    while (!(close.equals("close")))
    {
    Boolean ban=true;
    Scanner testing = new Scanner(System.in);
    System.out.println("Enter word");
    if (testing.hasNext())
    {
    close = testing.nextLine(); 
    System.out.println("Word is: " + close);
     if (close.equals("close")) testing.close();
    }
    if (close.equals("checkCurrentList")) {
        System.out.println(test.current());
        ban=false;
    }

    if (close.equals("checkAllList")){
         System.out.println(test.ever());
   ban=false;
    }
    if (ban){
        test.banning(close);
    }
    


    }

    }
}
