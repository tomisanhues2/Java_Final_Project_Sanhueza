package Abstract;

public abstract class AStore {

    private static int Id = 0;

    public AStore() {
        Id++;
    }

    public int getId() {
        return Id;
    }
}
