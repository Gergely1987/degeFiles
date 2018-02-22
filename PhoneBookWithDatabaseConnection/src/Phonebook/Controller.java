package Phonebook;

import com.itextpdf.text.*;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;


import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    TableView table;

    @FXML
    TextField inputLastName, inputFirstName, inputEmail, inputExport;

    @FXML
    Button addNewContactButton, exportButton, alertOk;

    @FXML
    StackPane menuPane;

    @FXML
    Pane contactPane, exportPane, alertPane;

    @FXML
    AnchorPane anchor;

    @FXML
    SplitPane mainSplit;

    DB db = new DB();

    private final String MENU_CONTACTS = "Kontaktok";
    private final String MENU_LIST = "Lista";
    private final String MENU_EXPORT = "Exportálás";
    private final String MENU_EXIT = "Kilépés";

    private final ObservableList<Person> data = FXCollections.observableArrayList();
//            new Person("Szabó", "Gyula", "szabo@freemail.hu"),
//            new Person("Kis", "Gabi", "gabika@hotmail.hu"),
//            new Person("Rózi", "Ódonell", "rózikaódonel@gmail.hu"));

    @FXML
    public void addNewContactButton(ActionEvent event) {


        String email = inputEmail.getText();
        if (email.length() > 3 && email.contains("@") && email.contains(".")) {
            Person newPerson = new Person(inputLastName.getText(), inputFirstName.getText(), inputEmail.getText());
            data.add(newPerson);
            db.addContact(newPerson);
            inputFirstName.clear();//ne maradjon a beírt szöveg a textfieldben
            inputLastName.clear();
            inputEmail.clear();
        } else {
            System.out.println("hiba a felvételnél");
            alert("hibásan töltötted ki az emailt");
        }
        setTableData();

    }

    public void alert(String txt){
        mainSplit.setDisable(true);
        mainSplit.setOpacity(0.4);

        Label label=new Label(txt);
        Button alertButton=new Button("Ok");
        VBox vbox=new VBox(label,alertButton);
        vbox.setAlignment(Pos.CENTER);
        anchor.getChildren().add(vbox);
        anchor.setTopAnchor(vbox,300.0);
        anchor.setLeftAnchor(vbox,300.0);

        alertButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainSplit.setDisable(false);
                mainSplit.setOpacity(1);
                vbox.setVisible(false);
            }
        });
    }


//
//    }


    //TÁBLA LÉTREHOZÁSA
    private void setTableData() {



        TableColumn idCol = new TableColumn("ID");
        idCol.setMinWidth(20);
        idCol.setCellFactory(TextFieldTableCell.forTableColumn());
        idCol.setCellValueFactory(new PropertyValueFactory<Person, String>("id"));

        TableColumn lastNameCol = new TableColumn("Vezetéknév"); //inicailizáljuk az oszlopot
        lastNameCol.setMinWidth(130); //ennél szűkebb nem lehet az oszlop
        lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn()); //beállítjuk hogy textfield típusúak legyenek a collumok
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName")); //person-ből a lastName string típusát fogja keresni(így kötöm össze)

        lastNameCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Person, String> t) {
                        Person actualPerson = ((Person) t.getTableView().getItems().get(
                                t.getTablePosition().getRow()));
                        //melyik sorben akarom végrehajtani a módosítást
                        actualPerson.setLastName(t.getNewValue()); //az előbb kiválasztott tábla pozíciónál csináljuk meg a módosítást a Setteren keresztül
                        db.updateContact(actualPerson);
                        System.out.println("vezetéknév");
                    }
                }
        );


        TableColumn firstNameCol = new TableColumn("Keresztnév");
        firstNameCol.setMinWidth(130);
        firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));

        firstNameCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Person, String> t) {
                        Person actualPerson = ((Person) t.getTableView().getItems().get(
                                t.getTablePosition().getRow()));
                        //melyik sorben akarom végrehajtani a módosítást
                        actualPerson.setFirstName(t.getNewValue()); //az előbb kiválasztott tábla pozíciónál csináljuk meg a módosítást a Setteren keresztül
                        db.updateContact(actualPerson);
                        System.out.println("keresztnév");
                    }
                }
        );

        TableColumn emailCol = new TableColumn("Email cím");
        emailCol.setMinWidth(220);
        emailCol.setCellFactory(TextFieldTableCell.forTableColumn());
        emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));

        emailCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Person, String> t) {
                        Person actualPerson = ((Person) t.getTableView().getItems().get(
                                t.getTablePosition().getRow()));
                        //melyik sorben akarom végrehajtani a módosítást
                        actualPerson.setEmail(t.getNewValue()); //az előbb kiválasztott tábla pozíciónál csináljuk meg a módosítást a Setteren keresztül
                        db.updateContact(actualPerson);
                    }
                }
        );
// törlés létrehozása
        TableColumn removeCol=new TableColumn("Törlés");
        removeCol.setMinWidth(100);

        Callback<TableColumn<Person, String>, TableCell<Person, String>> cellFactory =
                new Callback<TableColumn<Person, String>, TableCell<Person, String>>()
                {
                    @Override
                    public TableCell call( final TableColumn<Person, String> param )
                    {
                        final TableCell<Person, String> cell = new TableCell<Person, String>()
                        {
                            final Button btn = new Button( "Törlés" );

                            @Override
                            public void updateItem( String item, boolean empty )
                            {
                                super.updateItem( item, empty );
                                if ( empty )
                                {
                                    setGraphic( null );
                                    setText( null );
                                }
                                else
                                {
                                    btn.setOnAction( ( ActionEvent event ) ->
                                    {
                                        Person person = getTableView().getItems().get( getIndex() );
                                        data.remove(person);
                                        db.removeContact(person);
                                    } );
                                    setGraphic( btn );
                                    setText( null );
                                }
                            }
                        };
                        return cell;
                    }
                };

        removeCol.setCellFactory(cellFactory);

        table.getColumns().clear();
        table.getItems().clear();

        table.getColumns().addAll(idCol,lastNameCol, firstNameCol, emailCol,removeCol); //táblához hozzá adom az oszlopokat
        data.addAll(db.getAllContacts());
        table.setItems(data);  //ráküldöm az adatokat a táblára

    }

    private void setMenuData() {
        TreeItem<String> treeItemRoot1 = new TreeItem<>("Menü");
        TreeView<String> treeView = new TreeView<>(treeItemRoot1); //létrehozzuk egy főágat, melynek át kell adni már egy TreeItemet
        treeView.setShowRoot(false);

        TreeItem<String> nodeItemA = new TreeItem<>("Kontaktok");     //létrehozunk ágakat
        TreeItem<String> nodeItemB = new TreeItem<>("Kilépés");

        Node contactsNode = new ImageView(new Image(getClass().getResourceAsStream("/contacts.png")));
        Node exportNode = new ImageView(new Image(getClass().getResourceAsStream("/export.png")));

        //  nodeItemA.setExpanded(true); //legyen lenyitva alap esetben

        TreeItem<String> nodeItemA1 = new TreeItem<>(MENU_LIST, contactsNode);
        TreeItem<String> nodeItemA2 = new TreeItem<>(MENU_EXPORT, exportNode);

        nodeItemA.getChildren().addAll(nodeItemA1, nodeItemA2);
        treeItemRoot1.getChildren().addAll(nodeItemA, nodeItemB);

        menuPane.getChildren().add(treeView);


        treeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {   //treeView-hoz hozzáadunk egy új Listener-t
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {     //létrehozunk egy metódust a Listenerben, mely fogadja a megfigyelt objektumot ->ObservableValue
                TreeItem<String> selectedItem = (TreeItem<String>) newValue;  //erre kattint a felhasználó
                String selectedMenu;
                selectedMenu = selectedItem.getValue();


                if (null != selectedMenu) {
                    switch (selectedMenu) {
                        case MENU_CONTACTS:
                            selectedItem.setExpanded(true); //1 kattintás után lenyílik
                            break;
                        case MENU_LIST:
                            contactPane.setVisible(true);
                            exportPane.setVisible(false);
                            break;
                        case MENU_EXPORT:
                            contactPane.setVisible(false);
                            exportPane.setVisible(true);
                            break;
                        case MENU_EXIT:
                            System.exit(0);
                            break;
                    }
                }
            }
        });
    }

    public void addExportButton(ActionEvent event) {
        String filename = inputExport.getText();
        filename = filename.replace("\\s", "");  //whitespaceket kiszedjük
        if (filename != null && !filename.equals("")) {
            pdfGeneration(filename, data);
        }else{
            alert("addj meg file-nevet");
        }

    }

    private void pdfGeneration(String filename, ObservableList<Person> data) {
        Document document = new Document();

        try {
            //Céges logó
            PdfWriter.getInstance(document, new FileOutputStream(filename + ".pdf"));
            document.open();
            com.itextpdf.text.Image image1 = com.itextpdf.text.Image.getInstance(getClass().getResource("/logo.jpg"));
            image1.scaleToFit(200, 120);
            image1.setAbsolutePosition(225f, 715f);
            document.add(image1);

//sortörés
            document.add(new Paragraph("\n\n\n\n\n\n"));
            //táblázat betöltése
            float[] columWidths = {2, 3, 3, 6};
            PdfPTable table = new PdfPTable(columWidths);
            table.setWidthPercentage(100);
            PdfPCell cell = new PdfPCell(new Phrase("Kontaktlista"));
            cell.setBackgroundColor(GrayColor.GRAYWHITE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setColspan(4);
            table.addCell(cell);

            table.getDefaultCell().setBackgroundColor(new GrayColor(0.70f));
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell("Sorszám");
            table.addCell("Vezetéknév");
            table.addCell("Keresztnév");
            table.addCell("email");
            table.setHeaderRows(1);

            table.getDefaultCell().setBackgroundColor(BaseColor.WHITE);

            for (int i = 1; i <= data.size(); i++) {
                Person actualPerson = data.get(i - 1);
                table.addCell("" + i);
                table.addCell(actualPerson.getFirstName());
                table.addCell(actualPerson.getLastName());
                table.addCell(actualPerson.getEmail());
            }

            document.add(table);

            //Aláírás
            Chunk signature = new Chunk("\n\n\n Generálva a Telefonkönyv alkalmazás segítségével");
            Paragraph base = new Paragraph(signature);
            document.add(base);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        document.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setTableData();
        setMenuData();


    }


}
