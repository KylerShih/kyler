import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.Scanner;

public class Restaurant{
    private double profit;
    private String name;



    public Restaurant(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getProfit() {
        return profit;
    }


    public void setProfit(double profit) {
        this.profit = profit;
    }
}
