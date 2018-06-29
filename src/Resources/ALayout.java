package Resources;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public abstract class ALayout extends Application implements WindowSize{

    protected final int MARGIN_BORDER = (int)Math.floor(WINDOW_X * 0.07);
    protected final int MAX_SIZE_ELEMENT = 240;
    final private int SEPARATE_DISTANCE = 80;
    public final Insets SEPARATE_ELEMENT_LEFT = new Insets(0,0,SEPARATE_DISTANCE,MARGIN_BORDER);
    public final Insets SEPARATE_ELEMENT_CENTER = new Insets(0,0,SEPARATE_DISTANCE,0);
    public final Insets SEPARATE_ELEMENT_RIGHT = new Insets(0,MARGIN_BORDER,SEPARATE_DISTANCE,0);

    protected final void TITLE_ALIGN_CENTER(Node child) {
        StackPane.setAlignment(child,Pos.TOP_CENTER);
        StackPane.setMargin(child, new Insets(MARGIN_BORDER/2,0,0,0));
        child.getStyleClass().add("titleText");
    }

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

    protected final void ALIGN_BOTTOM_LEFT(Node... child) {
        for (Node n : child) {
            StackPane.setAlignment(n, Pos.BOTTOM_LEFT);
            StackPane.setMargin(n, new Insets(0,0,MARGIN_BORDER/2,MARGIN_BORDER));
        }

    }
    protected final void ALIGN_BOTTOM_CENTER(Node... child) {
        for (Node n : child) {
            StackPane.setAlignment(n, Pos.BOTTOM_CENTER);
            StackPane.setMargin(n,new Insets(0,0,MARGIN_BORDER/2,0));
        }

    }
    protected final void ALIGN_BOTTOM_RIGHT(Node... child) {
        for (Node n : child) {
            StackPane.setAlignment(n, Pos.BOTTOM_RIGHT);
            StackPane.setMargin(n,new Insets(0,MARGIN_BORDER,MARGIN_BORDER/2,0));
        }

    }
    protected final void ALIGN_TOP_LEFT(Node... child) {
        for (Node n : child) {
            StackPane.setAlignment(n, Pos.TOP_LEFT);
            StackPane.setMargin(n,new Insets(MARGIN_BORDER/2,0,0,MARGIN_BORDER));
        }

    }
    protected final void ALIGN_TOP_CENTER(Node... child) {
        for (Node n : child) {
            StackPane.setAlignment(n, Pos.TOP_CENTER);
            StackPane.setMargin(n,new Insets(MARGIN_BORDER/2,0,0,0));
        }

    }
    protected final void ALIGN_TOP_RIGHT(Node... child) {
        for (Node n : child) {
            StackPane.setAlignment(n, Pos.TOP_RIGHT);
            StackPane.setMargin(n,new Insets(MARGIN_BORDER/2,MARGIN_BORDER,0,0));
        }

    }
}
