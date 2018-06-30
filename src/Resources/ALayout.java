package Resources;

import Objects.Employee;
import ResourceObjects.ClickableMenu;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.IOException;


public abstract class ALayout extends Application implements WindowSize, Constants{


    final private int SEPARATE_DISTANCE = 80;

    public final Insets SEPARATE_ELEMENT_LEFT = new Insets(0,0,SEPARATE_DISTANCE,MARGIN_BORDER);
    public final Insets SEPARATE_ELEMENT_CENTER = new Insets(0,0,SEPARATE_DISTANCE,0);
    public final Insets SEPARATE_ELEMENT_RIGHT = new Insets(0,MARGIN_BORDER,SEPARATE_DISTANCE,0);

    public final String INVALID_INPUT = "-fx-background-color: rgb(255, 0, 0)";
    public final String VALID_INPUT = "-fx-background-color: rgb(0, 255, 0)";
    public final String NEW_INPUT = "-fx-background-color: rgb(217, 217, 217)";


    protected String storeValidName(String s) {
        if (!s.isEmpty() && s.matches("^[a-zA-Z ]+$"))
            return s;
        return null;
    }

    protected String storeValidPhone(String s) {
        if (!s.isEmpty() && s.matches("^[0-9]{10}?")) {
            String[] test = s.split("(?<=\\G...)");
            String phone = String.format("%s-%s-%s",test[0],test[1],test[2] + "" + test[3]);
            return phone;
        }
        return null;
    }

    protected String storeValidAddress(String s) {
        if (!s.isEmpty() && s.matches("\\d{2,5}[a-zA-Z ]+"))
            return s;
        return null;
    }

    protected Employee storeValidManager(String s) {
        if (!s.isEmpty()) {
            switch (s) {

            }
        }
        return null;
    }

    protected String employeeValidName(String s) {
        if (!s.isEmpty() && s.matches("^[a-zA-Z ]+$"))
            return s;
        return null;
    }



    protected String employeeValidEmail(String s) {
        if (!s.isEmpty() && s.matches("^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z]+?"))
            return s;
        return null;
    }


    protected String employeeValidPhone(String s) {
        if (!s.isEmpty() && s.matches("^[0-9]{10}?")) {
            String[] test = s.split("(?<=\\G...)");
            String phone = String.format("%s-%s-%s",test[0],test[1],test[2] + "" + test[3]);
            return phone;
        }
        return null;
    }


    protected String productValidName(String s) {
        if (!s.isEmpty() && s.matches("^[a-zA-Z ]+$"))
            return s;
        return null;
    }

    protected double productValidPrice(String s) {
        if (!s.isEmpty() && s.matches("^[0-9]+(\\.[0-9]{1,2})?$"))
            return Double.parseDouble(s);
        return -1;
    }

    protected int productValidAmount(String s) {
        if (!s.isEmpty() && s.matches("^[0-9]+$"))
            return Integer.parseInt(s);
        return -1;
    }


    protected final void TITLE_ALIGN_CENTER(Node child) {
        StackPane.setAlignment(child,Pos.TOP_CENTER);
        StackPane.setMargin(child, new Insets(MARGIN_BORDER/2.6,0,0,0));
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
