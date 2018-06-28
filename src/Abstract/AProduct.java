package Abstract;

public abstract class AProduct {

    private static int Id = 0;

    public AProduct() {
        Id++;
    }

    public int getId() {
        return Id;
    }
}
