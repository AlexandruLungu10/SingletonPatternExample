public final class UserPreferencesManager {
    private Reservation reservation;
    private static UserPreferencesManager instance;
    private UserPreferencesManager(Reservation reservation){
        this.reservation = reservation;
    }
    public static synchronized UserPreferencesManager getInstance(Reservation reservation){
        if(instance == null){
            instance = new UserPreferencesManager(reservation);
        }
        return instance;
    }
}
