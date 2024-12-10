import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

interface Stack {
    public Object pop();

    public void push(Object obj);

    public int size();

    public Object peek();
}

class ArrayStack implements Stack {
    private Object[] sarr;
    private int size = 0;

    public ArrayStack(int capacity) {
        sarr = new Object[capacity];
    }

    public Object pop() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        size--;
        return sarr[size];
    }

    public void push(Object obj) {
        if (size == sarr.length) {
            Object[] newarr = new Object[sarr.length * 2];
            for (int i = 0; i < sarr.length; i++) {
                newarr[i] = sarr[i];
            }
            sarr = newarr;
        }
        sarr[size] = obj;
        size++;
    }

    public void pushall(pbl obj) {
        if (size == sarr.length) {
            Object[] newarr = new Object[sarr.length * 2];
            for (int i = 0; i < sarr.length; i++) {
                newarr[i] = sarr[i];
            }
            sarr = newarr;
        }
        for (int i = 0; i < obj.length; i++) {
            push(i);
        }

    }

    public Object peek() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return sarr[size - 1];
    }

    public int size() {
        return size;
    }
}
public class pbl {
    public int length;

    class Node {
        Object[] data;
        Node next;

        Node(int size) {
            this.data = new Object[size];
            this.next = null;
        }
    }

    private Node head = null;

    public void insert(Object[] da) {
        if (head == null) {
            head = new Node(da.length);
            for (int i = 0; i < da.length; i++) {
                head.data[i] = da[i];
            }
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            Node newNode = new Node(da.length);
            for (int i = 0; i < da.length; i++) {
                newNode.data[i] = da[i];
            }
            temp.next = newNode;
        }
    }
    public void printlist() {
        Node temp = head;
        while (temp != null) {
            for (int i = 0; i < temp.data.length; i++) {
                System.out.print(temp.data[i] + " ");
            }
            System.out.println();
            temp = temp.next;
        }
    }

    public void sort() {
    Node temp = head;
    while (temp.next != null) {
    if ((Integer) temp.data[1] > (Integer) temp.next.data[1]) {
    Object[] tempArr = temp.data;
    temp.data = temp.next.data;
    temp.next.data = tempArr;
    }
    temp = temp.next;
    }
    }
    public Node getmiddlelinked(Node head){
        if (head == null) return null; 

   Node  temp = head;
  
   int count = 0;
   while(temp != null){
count++;
temp =temp.next;
   }
   int mid = (count -1)/2;
   temp = head;
   for(int i = 0; i < mid; i++){
    temp = temp.next;
    }
   
     return temp;
    }
    public void mergeSort(){
        head = mergeSort(head);
    }
    public Node mergeSort(Node head) {
        if(head== null || head.next == null) return head;
Node mid = getmiddlelinked(head);
Node midnext = mid.next;
mid.next = null;
Node left = mergeSort(head);
Node right = mergeSort(midnext);
return merge(left, right);
    }
public Node merge(Node left,Node right){
    if(right == null){
        return left;
    }
    if(left == null){
        return right;
    }
    Node result;
    if ((Integer) left.data[1] <= (Integer) right.data[1]) {
        result = left;
        result.next = merge(left.next, right);
    } else {
        result = right;
        result.next = merge(left, right.next);
    }
    return result;
}

    // public void sort() {
    //     if (head == null)
    //         return; // Check if the list is empty
    //     Node current = head;
    //     boolean swapped;
    //     do {
    //         swapped = false;
    //         current = head;
    //         while (current.next != null) {
    //             // Compare and swap if necessary
    //             if ((Integer) current.data[1] > (Integer) current.next.data[1]) {
    //                 Object[] tempArr = current.data;
    //                 current.data = current.next.data;
    //                 current.next.data = tempArr;
    //                 swapped = true; // A swap occurred
    //             }
    //             current = current.next; // Move to the next node
    //         }
    //     } while (swapped); // Continue until no swaps are made
    // }

    public static void addstack(ArrayStack a, pbl Asia) {

        Node temp = Asia.head;
        while (temp != null) {
            for (Object cityData : temp.data) {
                a.push(cityData);
            }
            temp = temp.next;
        }
    }
    public void printicity(Object gr){
   Node temp = head;
   while(temp != null){
    if(gr== temp.data[5-2]){
        System.out.println(temp.data[0]);
        break;
    }
    temp = temp.next;
   }
    }
    public static long sumofpopulation(pbl cont) {
        Node temp = cont.head;
        long sum = 0;
        while (temp != null) {
            sum += (Integer) temp.data[1] + (Integer) temp.data[2];
            temp = temp.next;
        }
        return sum;
    }
    public void sharunk(ArrayStack r) {
        Node temp = head;
        while (temp != null) {
            if ((Integer) temp.data[1] < (Integer) temp.data[2]) {
                r.push(temp.data[0]);
            }
            temp = temp.next;
        }
    }
    public void growthrate() {
        Node temp = head;
        double largest = Integer.MIN_VALUE;
        double smallest = Integer.MAX_VALUE;
        Object lcity = null;
        Object scity = null;

        while (temp != null) {
            try {
                double growthRate = (double) temp.data[3]; // Assuming correct data parsing

                if (largest < growthRate) {
                    largest = growthRate;
                    lcity = temp.data[0];
                }

                if (smallest > growthRate) {
                    smallest = growthRate;
                    scity = temp.data[0];
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid growth rate format for city: " + temp.data[0]);
            }

            temp = temp.next;
        }

        System.out.println("City with the highest growth rate: " + lcity + " (" + largest + ")");
        System.out.println("City with the lowest growth rate: " + scity + " (" + smallest + ")");
    }
public  static Object middlecity(ArrayStack sa){
    ArrayStack dummyst = new ArrayStack(5);
    int count =0;
    int half  = sa.size()/2;
    while (sa.size()>0) {
        if(count==half) {
            dummyst.push(sa.pop());
            }
            else {
                sa.pop();
                }
                count++;
    }
    return  dummyst.peek();
}
    public static void main(String[] args) {
        pbl Asia = new pbl();
        pbl Europe = new pbl();
        pbl Africa = new pbl();
        pbl SouthAmerica = new pbl();
        pbl NorthAmerica = new pbl();
        pbl Oceania = new pbl();

        String filePath = "C:\\Users\\DELL\\Desktop\\Wprld population growth rate by cities 2024.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length >= 6) {
                    String city = data[0].trim();
                    String continent = data[2].trim();
                    Object population2024 = Integer.parseInt(data[3].trim());
                    Object population2023 = Integer.parseInt(data[4].trim());
                    Object growthRate = Double.parseDouble(data[5].trim()); // Assuming it's a double

                    Object[] cityData = new Object[] { city, population2024, population2023, growthRate };

                    switch (continent) {
                        case "Asia":
                            Asia.insert(cityData);
                            break;
                        case "Europe":
                            Europe.insert(cityData);
                            break;
                        case "Africa":
                            Africa.insert(cityData);
                            break;
                        case "South America":
                            SouthAmerica.insert(cityData);
                            break;
                        case "North America":
                            NorthAmerica.insert(cityData);
                            break;
                        case "Oceania":
                            Oceania.insert(cityData);
                            break;
                        default:
                             System.out.println("Unknown continent: " + continent);
                    }
                } else {
                    System.out.println("Invalid line format: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Asia.mergeSort();
        Europe.mergeSort();
        Africa.mergeSort();
        SouthAmerica.mergeSort();
        NorthAmerica.mergeSort();
        Oceania.mergeSort();
        System.out.println("Asia:");
        Asia.printlist();
        System.out.println("\nEurope:");
        Europe.printlist();
        System.out.println("\nAfrica:");
        Africa.printlist();
        System.out.println("\nSouth America:");
        SouthAmerica.printlist();
        // ArrayStack asiastack = new ArrayStack(5);
        // ArrayStack eurStack = new ArrayStack(5);
        // ArrayStack NAstack = new ArrayStack(5);
        // ArrayStack SAstack = new ArrayStack(5);
        // ArrayStack Africastack = new ArrayStack(5);
        // ArrayStack ocstk = new ArrayStack(5);

        // addstack(asiastack, Asia);
        // addstack(eurStack, Europe);
        // addstack(NAstack, NorthAmerica);
        // addstack(SAstack, SouthAmerica);
        // addstack(Africastack, Africa);
        // addstack(ocstk, Oceania);

        // while (asiastack.size() > 0) {
        // System.out.println(asiastack.pop()+" ");
        // }
        // while (eurStack.size() > 0) {
        // System.out.println(eurStack.pop()+" ");
        // }
        // while (NAstack.size() > 0) {
        // System.out.println(NAstack.pop()+" ");
        // }
        // while (SAstack.size() >0) {
        // System.out.println(SAstack.pop()+" ");
        // }
        // while (Africastack.size() >0) {
        // System.out.println(Africastack.pop()+" ");
        // }
        // System.out.println(sumofpopulation(Asia));
        // System.out.println(sumofpopulation(Europe));
        // System.out.println(sumofpopulation(Africa));
        // System.out.println(sumofpopulation(SouthAmerica));
        // System.out.println(sumofpopulation(NorthAmerica));
        // System.out.println(sumofpopulation(Oceania));
        // ArrayStack ns = new ArrayStack(5);
        // String[] arr = { "Asia", "Africa", "SouthAmerica", "NorthAmerica", "Europe", "Oceania" };
        // for (int i = arr.length - 1; i >= 0; i--) {
        //     ns.push(arr[i]);
        // }
        // while (ns.size() > 0) {
        // System.out.println(ns.pop()+" ");
        // }
        // Problem 1: List the cities whose population has shrunk in the year 2024 for all continents (Use step 1 data).
        // System.out.println("Citites Whose polution is got sharunk in 2024");
        // ArrayStack sharunk = new ArrayStack(5);
        // Asia.sharunk(sharunk);
        // while (sharunk.size() > 0) {
        //     System.out.println(sharunk.pop() + " ");
        // }
        // System.out.println("The  Contienent whixh has lowest population in world");
        // while (ns.size() > 1) {
        //     ns.pop();
        // }

        //Problem 2: Which continent has the lowest population (Use step 3).
        // System.out.println("The Contient is " + ns.peek());
//         Problem 3: Which city has the highest growth rate and which city has lowest growth rate regardless of 
// continent (Calculate using the data of step 1).
//         System.out.println(" the growth rate of the Population is ");
//         Asia.growthrate();
//         //Problem 4: List the cities which are at the middle of the stacks of each continent made in step 2.
//         System.out.println("The cities which are at the middle of the stacks of each continent");
// Object e =   Asia.middlecity(SAstack);
//    Asia.printicity(e);
//    ArrayStack asiastack = new ArrayStack(5);
//    ArrayStack eurStack = new ArrayStack(5);
//    ArrayStack NAstack = new ArrayStack(5);
//    ArrayStack SAstack = new ArrayStack(5);
//    ArrayStack Africastack = new ArrayStack(5);
//    ArrayStack ocstk = new ArrayStack(5);
// int half= asiastack.size()/2;
// int helfl = (asiastack.size()-1)/2;
// while(asiastack.size() >half-3){
//     asiastack.pop();
//     }
//         System.out.println(asiastack.pop());
      


}
}