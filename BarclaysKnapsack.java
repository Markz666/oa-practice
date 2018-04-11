package oaPractice;
import java.util.*;
class Item {
	int id, price;
	double weight;
	public Item (int id, double weight, int price) {
		this.id = id;
		this.weight = weight;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public int getPrice() {
		return price;
	}
	public double getWeight(){
		return weight;
	}
}
class SortByPrice implements Comparator<Item> {
	public int compare(Item a, Item b) {
		return b.price - a.price;
	}
}
class SortByWeight implements Comparator<Item> {
	public int compare(Item a, Item b) {
		return Double.compare(a.weight, b.weight);
	}
}
public class BarclaysKnapsack {
	public static List<Integer> myKnapsack(String s) {
		String[] parts = s.split(":");
		int bagSize = Integer.valueOf(parts[0].trim());

		String remain = parts[1].trim();
		System.out.println(remain);
		String newremain = remain.replaceAll("[()$]","").replaceAll(",", " ");
		String[] test = newremain.split(" ");
//		for (String t : test) {
//			System.out.print(t + " ");
//		}
		List<Item> list = new ArrayList<Item>();
		for (int i = 0; i < test.length; i += 3) {
			Item item = new Item(Integer.valueOf(test[i]), Double.valueOf(test[i + 1]), Integer.valueOf(test[i + 2]));
			list.add(item);
		}
		Collections.sort(list, new SortByPrice());
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).getId() + " ");
		}
//		Collections.sort(list, new SortByWeight());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getId());
		}
		List<Integer> res = new ArrayList<>();

		int[][] table = new int[list.size() + 1][bagSize + 1];
        for (int i = 1; i <= list.size(); i++) { 
            for (int j = 1; j <= bagSize; j++) {  
                if (list.get(i).weight > j) {        
                       
                    table[i][j] = table[i - 1][j];
                    // System.out.print(table[i][j]+ " ");
                } else { 
                    table[i][j] = Math.max(table[i - 1][j], table[i - 1][j - (int)list.get(i).weight] + list.get(i).price);
                    //System.out.print(table[i][j]+ " ");
                }
            }
            // System.out.println();
        }

		System.out.println();
		
		return res;
	}
	public static void main(String[] args) {
		String s1 = "81 : (1,53.38,$45) (2,88.62,$98) (3,78.48,$3) (4,72.30,$76) (5,30.18,$9) (6,46.34,$48)";
		System.out.println(myKnapsack(s1));
	}
}
