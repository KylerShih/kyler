import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.Scanner;
public class RestaurantData {
    private ArrayList<Restaurant> restaurantsArrayList;
    public RestaurantData() {
        restaurantsArrayList = new ArrayList<Restaurant>();
        loadRestaurants();
    }

    public void runDay() {
        Scanner scanner = new Scanner(System.in);
        String choice = "";
        while (!(choice.equals("x"))) {
            System.out.println("(x) if you want to end the simulation");
            System.out.println("(p) to print all previous restaurants");
            System.out.println("(s) to serve a table");
            System.out.println("(o) to open a restaurant");
            Scanner s = new Scanner(System.in);
            String c = "";
            c = s.nextLine();
            runChoice(c);
        }
    }

    private void runChoice(String choice) {
        if (choice.equals("x")) {
            try {
                File f = new File("src/restaurants.data");
                f.createNewFile();
                FileWriter fw = new FileWriter("src/restaurants.data");
                String data = "";
                for (int i = 0; i < restaurantsArrayList.size(); i++) {
                    data = restaurantsArrayList.get(i).getName() + "|" + restaurantsArrayList.get(i).getProfit();
                    fw.write(data + "\n");
                }
                fw.close();
            } catch (IOException e) {
                System.out.println("Unable to create file");
                e.printStackTrace();
            }
            double p = 0;
            for(int i = 0;i<restaurantsArrayList.size();i++){
               p = p + restaurantsArrayList.get(i).getProfit();
            }
            System.out.println("Total Profit: " + p);
            System.out.println("simulation finished");
           System.exit(0);
        }
        if (choice.equals("o")) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What is the name of your restaurant?");
            String name = scanner.nextLine();
            Restaurant r = new Restaurant(name);
            restaurantsArrayList.add(r);
            try {
                File f = new File("src/restaurants.data");
                f.createNewFile(); // this method will create the file if it does not exist, if it does exist, it does nothing
                FileWriter fw = new FileWriter("src/restaurants.data");
                String data = "";
                for (int i = 0; i < restaurantsArrayList.size(); i++) {
                    data = restaurantsArrayList.get(i).getName() + "|" + restaurantsArrayList.get(i).getProfit();
                    fw.write(data + "\n");
                }
                fw.close();
            }
            catch (IOException e) {
                System.out.println("Unable to add restaurant");
                e.printStackTrace();
            }
        }
        if (choice.equals("p")) {
            try {
                File f = new File("src/restaurants.data");
                Scanner s = new Scanner(f);
                int line = 1;
                while (s.hasNextLine()) {
                    String data = s.nextLine();
                    System.out.println(data);
                }
                s.close();
            } catch (IOException e) {
                System.out.println("Unable to print restaurant");
                e.printStackTrace();
            }
        }
        if (choice.equals("s")) {
            Scanner scanner = new Scanner(System.in);
            for(int i = 0;i<restaurantsArrayList.size();i++){
                System.out.println(i + ": " + restaurantsArrayList.get(i).getName());
            }
            System.out.println(("What number restaurant do you want to increment?"));
            int num = scanner.nextInt();

            restaurantsArrayList.get(num).setProfit(restaurantsArrayList.get(num).getProfit() + 10);
            System.out.println("Table Served");
            try {
                File f = new File("src/restaurants.data");
                f.createNewFile();
                FileWriter fw = new FileWriter("src/restaurants.data");
                String data = "";
                for (int i = 0; i < restaurantsArrayList.size(); i++) {
                    data = restaurantsArrayList.get(i).getName() + "|" + restaurantsArrayList.get(i).getProfit();
                    fw.write(data + "\n");
                }
                fw.close();
            } catch (IOException e) {
                System.out.println("Unable to create file");
                e.printStackTrace();
            }

        }
    }
    public void loadRestaurants(){
        try {
            restaurantsArrayList = new ArrayList<Restaurant>();
            File f = new File("/Users/dasru/IdeaProjects/SlotMachine/src/players.data");
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String data = s.nextLine();
                String[] restaurantInfo = data.split("\\|");
                Restaurant p = new Restaurant(restaurantInfo[0]);
                restaurantsArrayList.add(p);
            }
            s.close();
        } catch (FileNotFoundException fnf) {
            restaurantsArrayList = new ArrayList<Restaurant>();
        }
    }




}
