import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.Scanner;

public class Restaurant {
    private final double tax = .0875;
    private double profit;
    private String name;
    private int serve;
    private ArrayList<Restaurant> restaurantsArrayList;


    public Restaurant(String name,int serve){
        this.name = name;
        this.serve = serve;
        restaurantsArrayList = new ArrayList<Restaurant>();
    }
    public Restaurant(){
        restaurantsArrayList = new ArrayList<Restaurant>();
    }



    public void runDay() {
        Scanner scanner = new Scanner(System.in);
        String choice = "";
        while (!(choice.equals("x"))) {
            System.out.println("(x) if you want to close the restaurant");
            System.out.println("(a) to add a new restaurant");
            System.out.println("(p) to print all previous restaurants");
            System.out.println("(s) to serve a table");

            choice = scanner.nextLine();
            runChoice(choice);
        }
        System.out.println("Day ended\nprofit: " + profit);
    }
    public void runChoice(String choice){
        if(choice.equals("x")){
            try {
                File f = new File("src/restaurants.data");
                f.createNewFile(); // this method will create the file if it does not exist, if it does exist, it does nothing
                FileWriter fw = new FileWriter("src/restaurants.data");
                fw.write(name + "\n");
                fw.write(profit+"\n");
                fw.close();
                int p = Integer.parseInt("0");
            }
            catch (IOException e) {
                System.out.println("Unable to add restaurant");
                e.printStackTrace();
            }
        }
        if(choice.equals("a")){

        }
        if(choice.equals("o")){
            Scanner scanner = new Scanner(System.in);
            System.out.println("What is the name of your restaurant");
            String name = scanner.nextLine();
            System.out.println("How many people can your restaurant serve?");
            int serve = scanner.nextInt();
            Restaurant r = new Restaurant(name,serve);
            openRestaurant(name);
            restaurantsArrayList.add(r);
        }
        if(choice.equals("p")) {
            try {
                File f = new File("src/restaurants.data");
                Scanner s = new Scanner(f);
                int line = 1;
                while (s.hasNextLine()) {
                    String data = s.nextLine();
                   System.out.println(data);
                }
                s.close();
            }
            catch(IOException e){
                System.out.println("Unable to print restaurant");
                e.printStackTrace();
            }
        }
        if(choice.equals("s")){
            Scanner scanner = new Scanner(System.in);
            System.out.println("What is the name of the restaurant you want to serve?");
            String name = scanner.nextLine();
            for(int i = 0;i<restaurantsArrayList.size();i++){
                if(restaurantsArrayList.get(i).getName().equals(name)){

                }
            }
            System.out.println("How many people are in this group?");
            int people = scanner.nextInt();
            System.out.println("Table served");
            if(serve-people>=0){
                serve = serve-people;
                profit = profit + people*10;
            }
            else{
                System.out.println("Cannot serve, limit reached");
            }
            runDay();
        }
    }
    public void openRestaurant(String name){
        try {
            File f = new File("src/restaurants.data");
            f.createNewFile(); // this method will create the file if it does not exist, if it does exist, it does nothing
            FileWriter fw = new FileWriter("src/restaurants.data");
            fw.write(name + "\n");
            fw.close();
            int p = Integer.parseInt("0");
            restaurantsArrayList.add(new Restaurant(name,serve));
        }
        catch (IOException e) {
            System.out.println("Unable to add restaurant");
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }
}
