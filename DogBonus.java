package bonus;

import java.util.*;

public class DogBonus {

    static final int num_reported_breeds = 5;
    static final int num_generations = 2;

    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        System.out.print("What is your dog's name? ");
        String name = inputReader.nextLine();

        System.out.printf("Well then, I have this highly reliable report on %s's prestigious background right here.\n", name);
        System.out.printf("%s is: \n\n", name);

        //new code
        Random rand = new Random();

        //array of dog breeds
        String[] dog_array = {"St. Bernard", "Chihuahua", "Pug", "Poodle", "King Doberman", "Spaniel", "Hound", "Beagle", "Husky", "Boxer"};

        //create family tree leaves, assuming no inbreeding...
        String[] ancestors = new String[2 << (num_generations - 1)];

        //randomly populate ancestor tree leaves (with dog being tested as the root)
        for(int i = 0; i < ancestors.length; i++) {
            ancestors[i] = dog_array[rand.nextInt(dog_array.length)];
        }

        //keep track of how many ancestors of each breed
        int[] ancestor_count = new int[dog_array.length];
        for(String ancestor : ancestors) {
            for(int i = 0; i < dog_array.length; i++) {
                if(ancestor.equals(dog_array[i])) {
                    ancestor_count[i]++;
                    break;
                }
            }
        }
        //makeshift sort
        while(true) {
            boolean flag = false;
            for (int i = 0; i < dog_array.length - 1; i++) {
                if (ancestor_count[i] < ancestor_count[i + 1]) {
                    int temp = ancestor_count[i + 1];
                    ancestor_count[i + 1] = ancestor_count[i];
                    ancestor_count[i] = temp;
                    flag = true;
                }
            }
            if(flag) {
                continue;
            }
            break;
        }
        //print the first num reported breeds from the sorted list. skip any that have no blood
        for(int i = 0; i < num_reported_breeds; i++) {
            if(ancestor_count[i] == 0) {
                break;
            }
            System.out.printf("%.0f%% %s\n", ancestor_count[i] * 100.0 / ancestors.length, dog_array[i]);
        }
        System.out.print("\nWow, that's QUITE the dog!");
    }
}
