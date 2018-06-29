package Resources;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

public abstract class ALayout extends Application {

    private final int MARGIN_BORDER = 30;
    protected final int MAX_SIZE_ELEMENT = 160;
    final private int SEPARATE_DISTANCE = 60;
    public final Insets SEPARATE_ELEMENT_LEFT = new Insets(0,0,SEPARATE_DISTANCE,MARGIN_BORDER);
    public final Insets SEPARATE_ELEMENT_CENTER = new Insets(0,0,SEPARATE_DISTANCE,0);
    public final Insets SEPARATE_ELEMENT_RIGHT = new Insets(0,MARGIN_BORDER,SEPARATE_DISTANCE,0);

    protected final void ALIGN_CENTER_LEFT(Node... child) {
        for (Node n : child) {
            StackPane.setAlignment(n, Pos.CENTER_LEFT);
            StackPane.setMargin(n,new Insets(0,0,0,MARGIN_BORDER));
        }
    }
    protected final void ALIGN_CENTER_CENTER(Node... child) {
        for (Node n : child) {
            StackPane.setAlignment(n, Pos.CENTER);
        }
    }
    protected final void ALIGN_CENTER_RIGHT(Node... child) {
        for (Node n : child) {
            StackPane.setAlignment(n, Pos.CENTER_RIGHT);
            StackPane.setMargin(n,new Insets(0,MARGIN_BORDER,0,0));
        }
    }
}
