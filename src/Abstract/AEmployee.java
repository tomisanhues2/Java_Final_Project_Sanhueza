package Abstract;

public abstract class AEmployee {

    private static int Id = 0;

    public AEmployee() {
        Id++;
    }

    public int getId() {
        return Id;
    }
}
