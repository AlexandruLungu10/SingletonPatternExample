public class Room {
    private String roomType;
    private boolean available;
    private int price;
    private int maxPeople;

    public Room(String roomType, boolean available, int price, int maxPeople) {
        this.roomType = roomType;
        this.available = available;
        this.price = price;
        this.maxPeople = maxPeople;
    }

    public String getRoomType() {
        return roomType;
    }

    public boolean isAvailable() {
        return available;
    }

    public int getPrice() {
        return price;
    }
    public void setAvailable(boolean available){
        this.available=available;
    }
    public int getMaxPeople(){
        return maxPeople;
    }

    @Override
    public String toString() {
        return roomType;
    }
}
