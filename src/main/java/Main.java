import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Room> rooms = roomInitialiase();
        Scanner scanner = new Scanner(System.in);
        List<String> availableRooms = updateAvailable(rooms);

        UserPreferencesManager manager=null;
        Reservation reservation = new Reservation();
        boolean running = true;
        while(running) {
            System.out.println("Welcome to our Bed and Breakfast facility! Please, select your desired option! \n" +
                    "(type the number of the option you want to use)");
            System.out.println("1. View our available rooms. \n" +
                    "2. Make a new reservation \n" +
                    "3. Manage your reservation \n" +
                    "4. Leave a Review! \n" +
                    "5. Exit");
            int option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1:
                    System.out.println("These are our rooms: ");
                    for (Room room : rooms) {
                        System.out.println("Room " + room.getRoomType() + " can accommodate " + room.getMaxPeople() + " visitors. It costs " + room.getPrice() + " per night.");
                    }
                    break;
                case 2:

                    System.out.println("Checking our available rooms... ");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    availableRooms = updateAvailable(rooms);
                    System.out.println("Available rooms are: " + availableRooms);
                    System.out.println("Type the room you want to reserve: ");
                    String toReserve = scanner.nextLine();
                    for (Room room : rooms) {
                        if (toReserve.equalsIgnoreCase(room.getRoomType())) {
                            System.out.println("How many nights will you be staying?");
                            int duration = Integer.parseInt(scanner.nextLine());
                            reservation.setRoom(room);
                            reservation.setReservationLength(duration);
                            manager = UserPreferencesManager.getInstance(reservation);
                            room.setAvailable(false);
                            System.out.println("Your reservation was successful!");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Checking for your reservation...");

                    if (manager == null) {
                        System.out.println("You do not have a reservation. Do you want to make a new one?");
                    } else {
                        System.out.println("Your reservation is: " + reservation);
                        System.out.println("Please insert your new stay period (number of days you will be with us): ");
                        int duration = Integer.parseInt(scanner.nextLine());
                        reservation.setReservationLength(duration);
                    }
                    break;
                case 4:
                    System.out.println("Please write your review below: ");
                    String review = scanner.nextLine();
                    System.out.println("Your review has be submitted! Thank you for your time!");
                    break;
                case 5:
                    System.out.println("Thank you for using our app!");
                    running = false;
                    System.exit(0);
                    break;
            }
        }
    }
    public static List<Room> roomInitialiase() {
        Room modern = new Room("Single Modern", true, 200, 1);
        Room couple = new Room("Couple Double", true, 350, 2);
        Room rustic = new Room("Rustic Vacation", true, 450, 4);
        Room comic = new Room("Marvel Madness", true, 600, 4);
        Room family = new Room("Family Escapade", true, 750, 5);
        Room agent = new Room("Secret Mission Hideout", true, 300, 1);
        List<Room> rooms = new ArrayList<>();
        rooms.add(modern);
        rooms.add(couple);
        rooms.add(rustic);
        rooms.add(comic);
        rooms.add(family);
        rooms.add(agent);
        return rooms;
    }
    public static List<String> updateAvailable(List<Room>rooms){
        List<String>availableRooms = new ArrayList<>();
        for(Room room:rooms){
            if(room.isAvailable()){
                availableRooms.add(room.getRoomType());
            }
        }
        return availableRooms;
    }
}
