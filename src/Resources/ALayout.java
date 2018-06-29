package Resources;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

public abstract class ALayout extends Application {
    
    public final void ALIGN_CENTER_LEFT(Node... child) {
        for (Node n : child) {
            StackPane.setAlignment(n, Pos.CENTER_LEFT);
        }
    }
    public final void ALIGN_CENTER_CENTER(Node... child) {
        for (Node n : child) {
            StackPane.setAlignment(n, Pos.CENTER);
        }
    }
    public final void ALIGN_CENTER_RIGHT(Node... child) {
        for (Node n : child) {
            StackPane.setAlignment(n, Pos.CENTER_RIGHT);
        }
    }
}
