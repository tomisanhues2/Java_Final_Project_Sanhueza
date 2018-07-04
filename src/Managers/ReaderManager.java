package Managers;

import Objects.Product;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ReaderManager extends JPanel {

    private File selectedFile;

    private Workbook workbook;

    private JButton openFileButton;
    private JFileChooser fileChooser;
    private JTextArea textArea;

    private ArrayList<Product> products = new ArrayList<>();

    public ReaderManager() {
        super(new BorderLayout());
        textArea = new JTextArea("Select a file provided by this program.\n");
        textArea.setMargin(new Insets(30, 30, 30, 30));
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JFrame frame = new JFrame();

        openFileButton = new JButton("Open a file");
        openFileButton.addActionListener(e -> {

            fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                textArea.append("\nProcessing: " + file.getName() + ".\n");
                textArea.append(
                        "File is in a valid format... Verifying contents\n");
                selectedFile = file;
                fileManager();
                frame.setVisible(false);
                frame.dispose();
            } else {
                textArea.append("Action canceled by user.\n");
                textArea.setCaretPosition(textArea.getDocument().getLength());
            }
        });

        add(openFileButton, BorderLayout.PAGE_START);
        add(scrollPane, BorderLayout.CENTER);

        frame.add(this);
        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }


    public File getSelectedFile() {
        System.out.println(selectedFile);
        return selectedFile;
    }


    private void fileManager() {
        try {
            workbook = WorkbookFactory.create(selectedFile);

            String productName = null; //Objects.Store product name
            double productPrice = 0; //Objects.Store product price per bag
            int productAmount = 0;  //Objects.Store product quantity per bag

            for (Sheet s : workbook) {
                if (s.getSheetName().equalsIgnoreCase("Products")) {
                    int records = s.getLastRowNum();
                    Row titleRow = s.getRow(1);
                    System.out.println(records);
                    for (int i = 2; i <= records; i++) {
                        System.out.println(i);
                        if (titleRow.getCell(
                                1).getStringCellValue().equalsIgnoreCase(
                                "ID")) {

                        }

                        if (titleRow.getCell(
                                2).getStringCellValue().equalsIgnoreCase(
                                "Objects.Product Name")) {
                            productName = s.getRow(i).getCell(
                                    2).getStringCellValue();
                        }

                        if (titleRow.getCell(
                                3).getStringCellValue().equalsIgnoreCase(
                                "Objects.Product price per bag")) {
                            productPrice = s.getRow(i).getCell(
                                    3).getNumericCellValue();
                        }

                        if (titleRow.getCell(
                                4).getStringCellValue().equalsIgnoreCase(
                                "Objects.Product quantity per bag")) {
                            productAmount = (int) s.getRow(i).getCell(
                                    4).getNumericCellValue();
                        }

                        products.add(new Product(productName, productPrice,
                                productAmount));
                    }
                }
            }

            for (Product p : products) {
                System.out.println(p);
            }


        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("IOException");
        } catch (InvalidFormatException ex) {
            ex.printStackTrace();
        }
    }

}
