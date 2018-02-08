package sample;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Alert;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Pair;


import java.net.URL;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Controller implements Initializable {

    private int totalIncome;
    private int calculatedIncome;

    private final String MENU_INVOICE = "Számlázás";
    private final String MENU_LIST = "Országos lista";
    private final String MENU_ADD_PARTNER = "Partner felvétele";
    private final String MENU_MODIFY_PARTNER = "Partner módosítása";
    private final String MENU_TRANSFER = "Készlet átadása";
    private final String MENU_MODIFY_WINEDATA = "Készletszint módosítás";
    private final String MENU_COLLAEGUE = "Munkatársak";
    private final String MENU_SHOPS = "Üzletek";
    private final String MENU_EXIT = "Kilépés";

    private LocalDateTime todayDate = LocalDateTime.now();
    DateTimeFormatter formatedDate = DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm:ss");
    String formatedDateTime = todayDate.format(formatedDate);


    private LocalDate dateNow = null;
    @FXML
    AnchorPane anchorPane;
    @FXML
    SplitPane mainSplitPane;

    @FXML
    Pane invoicePane, newInvoicePane, wineDataChangePane, wineDataChangePaneModifiers, stockPane, stockPaneByCountry, addPartnerPane, modifyPartnerPane, transferPane, employeePane, shopPane;

    @FXML
    StackPane menuPane;

    @FXML
    TextField invoiceWine, invoiceDateTF, invoiceNumTF, invoiceQuantityTF, invoiceDiscountTF, invoiceFinalPriceTF, sellerID;

    @FXML
    TextField nameTFSet, typeTFSet, yearTFSet, pieceTFSet, priceTFSet;


    @FXML
    TextField nameTFPartner, taxNumberTFPartner, cityTFPartner, areaCodeTFPartner, streetTFPartner, streetNumTFPartner, contactTFPartner, phoneNumberTFPartner, emailTFPartner, discountTFPartner;

    @FXML
    TextField nameMTFPartner, taxNumberMTFPartner, cityMTFPartner, areaCodeMTFPartner, streetMTFPartner, streetNumMTFPartner, contactMTFPartner, phoneNumberMTFPartner, emailMTFPartner, discountMTFPartner;

    @FXML
    TextField nameTFEmployee, levelTFEmployee, birthDateTFEmployee, birthPlaceTFEmployee, IDCardTFEmployee, addressTFEmployee, phoneNumberTFEmployee;

    @FXML
    TextField shopNameTFShop, areaCodeTFShop, cityTFShop, streetTFShop, streetNumTFShop;

    @FXML
    Button addNewWineToInvoice, openNewInvoice, closeInvoice, addNewWine, deleteWine, addNewPartner, modifyPartner, removePartner, adNewEmployee, modifyEmployee, removeEmployee, addNewShop, modifyShop, removeShop;

    @FXML
    TableView invoiceTable, stockTable, stockTableByCountry, wineDataChangeTable, addPartnerTable, modifyPartnerTable, employeeTable, shopTable;

    @FXML
    ChoiceBox shopIDChoiceBox, shopIDChoiceBoxEmployee, invoicePartnerCB, invoiceTypeCB;


    private static DBEmployee dbEmployee = new DBEmployee();
    private static DBPartner dbPartner = new DBPartner();
    private static DBWine dbWine = new DBWine();
    private static DBShop dbShop = new DBShop();
    private static DBEmployeePassword dbEmployeePassword = new DBEmployeePassword();
    private static DBInvoice dbInvoice=new DBInvoice();
    private static DBWineStock dbWineStock=new DBWineStock();

    private pdfGeneration pdfGeneration=new pdfGeneration();

    private final ObservableList<Wine> wineData = FXCollections.observableArrayList();
    private ObservableList<Invoice> invoiceData = FXCollections.observableArrayList();
    private final ObservableList<Wine> stockWineDataCountry = FXCollections.observableArrayList();
    private final ObservableList<Wine> stockInvoiceData = FXCollections.observableArrayList();
    private final ObservableList<Partner> partnerData = FXCollections.observableArrayList();
    private final ObservableList<Employee> employeeData = FXCollections.observableArrayList();
    private final ObservableList<Shop> shopData = FXCollections.observableArrayList();

    private static List<Employee> totalUsers = dbEmployee.getAllEmployee();
    private String newId;
    private String validID = null;
    private TreeItem<String> treeItemRoot = new TreeItem<>("Menü");
    private String level = null;

    private Employee loggedEmploy = null;

    //menü felépítése:
    private void setMenuData(String level) {
//        TreeItem<String> treeItemRoot = new TreeItem<>("Menü");
        TreeView<String> treeView = new TreeView<>(treeItemRoot);
        treeView.setShowRoot(false);

        Node invoicePict = new ImageView(new Image(getClass().getResourceAsStream("/invoice.png")));
        Node wineByCountryList = new ImageView(new Image(getClass().getResourceAsStream("/wineByCountryList.png")));
        Node addPartnerPict = new ImageView(new Image(getClass().getResourceAsStream("/addPartner.png")));
        Node modifyPartnerPict = new ImageView(new Image(getClass().getResourceAsStream("/modifyPartner.png")));
        Node transferPict = new ImageView(new Image(getClass().getResourceAsStream("/transfer.png")));
        Node colleagueNode = new ImageView(new Image(getClass().getResourceAsStream("/collegaue.png")));
        Node shopsNode = new ImageView(new Image(getClass().getResourceAsStream("/shop.png")));
        Node modifyWineDataPict = new ImageView(new Image(getClass().getResourceAsStream("/modifyPartner.png")));
        Node exitPict = new ImageView(new Image(getClass().getResourceAsStream("/exit.png")));

        TreeItem<String> nodeItem1 = new TreeItem<>(MENU_INVOICE, invoicePict);
        TreeItem<String> nodeItem2 = new TreeItem<>(MENU_LIST, wineByCountryList);
        TreeItem<String> nodeItem3 = new TreeItem<>(MENU_ADD_PARTNER, addPartnerPict);
        TreeItem<String> nodeItem4 = new TreeItem<>(MENU_MODIFY_PARTNER, modifyPartnerPict);
        TreeItem<String> nodeItem5 = new TreeItem<>(MENU_TRANSFER, transferPict);
        TreeItem<String> nodeItem6 = new TreeItem<>(MENU_COLLAEGUE, colleagueNode);
        TreeItem<String> nodeItem7 = new TreeItem<>(MENU_SHOPS, shopsNode);
        TreeItem<String> nodeItem8 = new TreeItem<>(MENU_MODIFY_WINEDATA, modifyWineDataPict);
        TreeItem<String> nodeItem9 = new TreeItem<>(MENU_EXIT, exitPict);


        if (level.equals("1")) {
            treeItemRoot.getChildren().addAll(nodeItem1, nodeItem2, nodeItem3, nodeItem9);
        } else if (level.equals("2")) {
            treeItemRoot.getChildren().addAll(nodeItem1, nodeItem2, nodeItem3, nodeItem4, nodeItem5, nodeItem9);
        } else if (level.equals("3")) {
            treeItemRoot.getChildren().addAll(nodeItem1, nodeItem2, nodeItem3, nodeItem4, nodeItem5, nodeItem6, nodeItem7, nodeItem8, nodeItem9);
        }

        menuPane.setVisible(true);
        menuPane.getChildren().add(treeView);

        treeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {   //treeView-hoz hozzáadunk egy új Listener-t
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {     //létrehozunk egy metódust a Listenerben, mely fogadja a megfigyelt objektumot ->ObservableValue
                TreeItem<String> selectedItem = (TreeItem<String>) newValue;  //erre kattint a felhasználó
                String selectedMenu;
                selectedMenu = selectedItem.getValue();


                if (null != selectedMenu) {
                    switch (selectedMenu) {
                        case MENU_INVOICE:
                            paneVisibleTrue(invoicePane, stockPane);
                            paneVisibleFalse(addPartnerPane, modifyPartnerPane, transferPane, wineDataChangePane, stockPaneByCountry, employeePane, shopPane, newInvoicePane);
                            setInvoiceTableData();
                            setStockTableData();
                            break;
                        case MENU_LIST:
                            paneVisibleTrue(stockPaneByCountry);
                            paneVisibleFalse(invoicePane, stockPane, transferPane, addPartnerPane, modifyPartnerPane, employeePane, shopPane, newInvoicePane);
                            // wineDataChangePaneModifiers.setVisible(false);
                            setStockTableDataByCountry();
                            break;
                        case MENU_ADD_PARTNER:
                            paneVisibleTrue(addPartnerPane);
                            paneVisibleFalse(invoicePane, stockPane, modifyPartnerPane, transferPane, wineDataChangePane, stockPaneByCountry, employeePane, shopPane, newInvoicePane);
                            setPartnerAddTableData(addPartnerTable);
                            break;
                        case MENU_MODIFY_PARTNER:
                            paneVisibleFalse(invoicePane, stockPane, transferPane, wineDataChangePane, addPartnerPane, stockPaneByCountry, employeePane, shopPane, newInvoicePane);
                            paneVisibleTrue(modifyPartnerPane);
                            setPartnerModifyTableData();
                            break;
                        case MENU_TRANSFER:
                            paneVisibleTrue(transferPane);
                            paneVisibleFalse(invoicePane, modifyPartnerPane, stockPane, wineDataChangePane, addPartnerPane, stockPaneByCountry, employeePane, shopPane, newInvoicePane);
                            break;
                        case MENU_COLLAEGUE:
                            paneVisibleTrue(employeePane);
                            paneVisibleFalse(invoicePane, stockPane, transferPane, addPartnerPane, modifyPartnerPane, stockPaneByCountry, wineDataChangePane, shopPane, newInvoicePane);
                            setEmployeeAddTableData();
                            break;
                        case MENU_SHOPS:
                            paneVisibleTrue(shopPane);
                            paneVisibleFalse(invoicePane, stockPane, transferPane, addPartnerPane, modifyPartnerPane, stockPaneByCountry, wineDataChangePane, employeePane, newInvoicePane);
                            setShopAddTableData();
                            break;
                        case MENU_MODIFY_WINEDATA:
                            paneVisibleTrue(wineDataChangePane);
                            paneVisibleFalse(invoicePane, stockPane, transferPane, addPartnerPane, modifyPartnerPane, stockPaneByCountry, employeePane, shopPane, newInvoicePane);
                            wineDataChangePaneModifiers.setVisible(true);
                            setWineDataChangeTable();
                            break;
                        case MENU_EXIT:
                            System.exit(0);
                            break;
                    }
                }
            }
        });
    }

    private void setPromptText(TextField input, String output) {
        if (input.getText().isEmpty() || input.getText() == null) {
            input.setPromptText(output);
        }
    }

    //minden TextFildbe töltök fel PromptTextet
    private void setPromptTextes() {
        //munkatársak
        setPromptText(nameTFEmployee, "Nicsak Kilincs");
        setPromptText(levelTFEmployee, "1");
        setPromptText(birthDateTFEmployee, "1987-02-23");
        setPromptText(birthPlaceTFEmployee, "Keszthely");
        setPromptText(IDCardTFEmployee, "494288JA");
        setPromptText(addressTFEmployee, "8373 Rezi, Hársfa sor 10");
        setPromptText(phoneNumberTFEmployee, "+3630/251-2560");

        //új partner
        setPromptText(nameTFPartner, "decsics kft.");
        setPromptText(taxNumberTFPartner, "40400400487");
        setPromptText(cityTFPartner, "Rezi");
        setPromptText(areaCodeTFPartner, "8000");
        setPromptText(streetTFPartner, "Hársfa sor");
        setPromptText(streetNumTFPartner, "10");
        setPromptText(contactTFPartner, "Decsics Gergely");
        setPromptText(phoneNumberTFPartner, "+3630/251-2560");
        setPromptText(emailTFPartner, "decsicsgergely@gmail.com");
        setPromptText(discountTFPartner, "10-30");

        //üzletek
        setPromptText(shopNameTFShop, "Harangszó borozó");
        setPromptText(areaCodeTFShop, "8000");
        setPromptText(cityTFShop, "Székesfehérvár");
        setPromptText(streetTFShop, "Bakony utca");
        setPromptText(streetNumTFShop, "8");

        //bor hozzáadás
        setPromptText(nameTFSet, "Cserszegi fűszeres");
        setPromptText(typeTFSet, "száraz");
        setPromptText(yearTFSet, "2015");
        setPromptText(pieceTFSet, "2");
        setPromptText(priceTFSet, "1520");

    }

    private void paneVisibleTrue(Pane... panes) {
        for (int i = 0; i < panes.length; i++) {
            panes[i].setVisible(true);
        }
    }

    private void paneVisibleFalse(Pane... panes) {
        for (int i = 0; i < panes.length; i++) {
            panes[i].setVisible(false);
        }
    }

    public boolean isEmpty(String... args) {
        for (String a : args) {
            if (a.trim().isEmpty() || a.trim() == null) {
                return true;
            }
        }
        return false;
    }

    public boolean isNumeric(String... args) {
        String data = null;
        try {
            for (int i = 0; i < args.length; i++) {
                data = args[i].trim();
                int num = Integer.parseInt(args[i]);
                return true;
            }
        } catch (Exception e) {
            alert("\"" + data + "\"" + " nem szám formátum.");
        }
        return false;
    }

    //+3630/251-2560 formátumot engedélyezek csak mobil vagy vezetékes megadást
    public boolean isValidPhoneNumber(String str) {
        if (str.matches("[+][0-9]{1,2}[0-9]{1,2}[/][0-9]{3}[-][0-9]{3,4}")) {
            return true;
        }
        alert("Nem megfelelő a telefonszám formátuma!");
        return false;

    }

    //1987-02-23 formátumban adhatóak meg a születési idő
    public boolean isValidBirthDate(String str) {
        if (str.matches("(([1][9][5-9][0-9])|([2][0][0][0-9]))[-](([0][1-9])|([1][0-2]))[-](([0][1-9])|([1][0-9])|([2][0-9])|([3][0-1]))")) {
            return true;
        }
        alert("Nem megfelelő a születési év!");
        return false;
    }

    public boolean isValidEmail(String str) {
        if (str.toLowerCase().trim().matches("[\\w][\\w,-,_,$]{0,}[@][\\w]{1,}[.][\\w]{0,}")) {
            return true;
        }
        alert("Valós email címet adjon meg!");
        return false;
    }

    public void emptyTextField(TextField... txtField) {
        for (TextField a : txtField) {
            a.clear();
        }
    }

    public void setTextToTextFields(List<TextField> txt, List<String> toTextField) {
        if (txt.size() == toTextField.size()) {
            for (int i = 0; i < txt.size(); i++) {
                txt.get(i).setText(toTextField.get(i));
            }
        } else {
            System.out.println("nem egyezik a TextFieldek mérete és a Stringek mérete");
        }

    }

    //figyelmeztető ablak
    public void alert(String txt) {
//        mainSplitPane.setOpacity(0.3);
//        mainSplitPane.setDisable(true);

//        Label label = new Label(txt);
//        Button alertButton = new Button("Ok");

//        VBox vBox = new VBox(label, alertButton);
//        vBox.setAlignment(Pos.CENTER);
//        anchorPane.getChildren().add(vBox);
//        anchorPane.setTopAnchor(vBox, 400.0);
//        anchorPane.setLeftAnchor(vBox, 500.0);
//
//        alertButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                mainSplitPane.setDisable(false);
//                mainSplitPane.setOpacity(1);
//                vBox.setVisible(false);
//            }
//        });

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Hiba!");
        alert.setHeaderText(null);
        alert.setContentText(txt);
        alert.showAndWait();
    }


    //felugró panel a - a törléseknél- használom
    public boolean areYouSure(String txtHead, String txt) {
        ButtonType yes = new ButtonType("Igen", ButtonBar.ButtonData.YES);
        ButtonType no = new ButtonType("Mégse", ButtonBar.ButtonData.NO);
        Alert alert = new Alert(Alert.AlertType.WARNING, txt, yes, no);
        alert.setTitle(txtHead);
        alert.setHeaderText(null);
        alert.setContentText(txt);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == yes) {
            return true;
        } else {
            alert.close();
            return false;
        }

    }


    Wine selectedWine = null;
    List<Invoice> invoiceList = new ArrayList<>();
   // ObservableList invoiceData = null;
    double finalPrice = 0;
    Partner selectedPartner=null;

    public void addNewWineToInvoice() {
        if (checkWineAndPiece()) {
            invoiceList.add(new Invoice(selectedWine.getName().toString(), selectedWine.getType().toString(), selectedWine.getYear().toString(), invoiceQuantityTF.getText().toString(), selectedWine.getPrice().toString(), selectedWine.getShopID().toString()));
            invoiceData = FXCollections.observableList(invoiceList);
            invoiceTable.setItems(invoiceData);


            setStockTableData();
        }

    }

    public void closeInvoice() {
        if(invoiceTable.getItems().isEmpty()){
            alert("Nem szerepel tétel a számlán");
            return;
        }

        if (invoiceTypeCB.getSelectionModel().getSelectedItem() == null || invoiceTypeCB.getSelectionModel().isEmpty()) {
            alert("nem választott fizetési módot");
            return;
        }

        for (Invoice i : invoiceList) {
            int thisPrice = Integer.parseInt(i.getPrice().replace(" Ft", ""));
            finalPrice += Integer.parseInt(i.getPiece()) * thisPrice;
        }

        if (!invoicePartnerCB.getItems().isEmpty() && invoicePartnerCB.getItems() != null) {
            List<Partner> partners = dbPartner.getAllPartners();
            for (Partner p : partners) {
                if (p.getName().equals(invoicePartnerCB.getSelectionModel().getSelectedItem())) {
                    invoiceDiscountTF.setText(p.getDiscountPercent());
                    selectedPartner=p;
                    break;
                } else {
                    invoiceDiscountTF.setText(String.valueOf(0));
                }
            }
        }

        invoiceDateTF.setText(formatedDateTime);
        if (invoiceDiscountTF.getText().equals("0")) {
            invoiceFinalPriceTF.setText(String.valueOf(finalPrice));
        } else {
            finalPrice = (finalPrice * (1 - (Double.parseDouble(invoiceDiscountTF.getText()) / 100)));
            invoiceFinalPriceTF.setText(String.valueOf(finalPrice));
        }
//a táblát végül 1 INVOICE objektumban küldöm el az INVOICE adatbázisba
        List<String>totalWineName=new ArrayList<>();
        List<String>totalWineType=new ArrayList<>();
        List<String>totalWineYear=new ArrayList<>();
        List<String>totalWinePiece=new ArrayList<>();
        List<String>totalWinePrice=new ArrayList<>();
        String partnerID=selectedPartner==null? "nincs partner":selectedPartner.getId();

        for (Invoice i:invoiceList) {
            totalWineName.add(i.getName());
            totalWineType.add(i.getType());
            totalWineYear.add(i.getYear());
            totalWinePiece.add(i.getPiece());
            totalWinePrice.add(i.getPrice());
        }


        if(areYouSure("Véglegesítés","Biztosan lezárja a számlát?")){
            invoicePane.setDisable(true);
            newInvoicePane.setVisible(true);
            dbInvoice.addInvoice(new Invoice(totalWineName.toString(),totalWineType.toString(),totalWineYear.toString(),totalWinePiece.toString(),totalWinePrice.toString(),loggedEmploy.getIdShop(),String.valueOf(finalPrice),partnerID));

            pdfGeneration.generatePDF("szamla",invoiceData,"számlaszám helye");

        }else{
            finalPrice=0;
            return;
        }
    }


    public String oldCharToNew(String whatToConvert, String old, String old2){
        return whatToConvert.replace(old,"").replace(old2,"");
    }

   public void openNewInvoice() {
        newInvoicePane.setVisible(false);
        invoicePane.setDisable(false);
        invoiceList.clear();
        invoicePartnerCB.getSelectionModel().clearSelection();
        invoiceTypeCB.getSelectionModel().clearSelection();
        if (invoiceData != null) {
            invoiceData.clear();
        }
        finalPrice = 0;
        invoiceTable.getItems().clear();
        emptyTextField(invoiceDateTF, invoiceDiscountTF, invoiceFinalPriceTF);
        setInvoiceTableData();
   }

    //WINE oszlopok hozzáadása: nem sikerült multi oszlopgenerálót csinálnom, csak a WINE generikusra
    private void addNewColumn(TableColumn name, int width, String attributeFromClass) {
        name.setMinWidth(width);
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        name.setCellValueFactory(new PropertyValueFactory<Wine, String>(attributeFromClass));
    }
    public void setInvoiceTableData() {
        invoiceTable.getColumns().clear();

        TableColumn name = new TableColumn("Fajta");
        TableColumn type = new TableColumn("Típus");
        TableColumn year = new TableColumn("Évjárat");
        TableColumn piece = new TableColumn("Darabszám");
        TableColumn price = new TableColumn("Ár");
        TableColumn shopID = new TableColumn("Üzlet ID-je");

        addNewColumn(name, 200, "name");
        addNewColumn(type, 50, "type");
        addNewColumn(year, 50, "year");
        addNewColumn(piece, 50, "piece");
        addNewColumn(price, 50, "price");
        addNewColumn(shopID, 50, "shopID");
        invoiceTable.getColumns().addAll(name, type, year, piece, price, shopID);
    }


    //invoicePane felépítése
    public void setStockTableData() {
        invoiceDateTF.setDisable(true);
        invoiceDiscountTF.setDisable(true);
        invoiceFinalPriceTF.setDisable(true);
        sellerID.setDisable(true);
        invoiceNumTF.setDisable(true);
        invoiceWine.setDisable(true);

        sellerID.setText(loggedEmploy.getId());
        invoiceFinalPriceTF.setText(String.valueOf(finalPrice));

        stockTable.getColumns().clear();
        stockTable.getItems().clear();

        TableColumn name = new TableColumn("Fajta");
        TableColumn type = new TableColumn("Típus");
        TableColumn year = new TableColumn("Évjárat");
        TableColumn piece = new TableColumn("Darabszám");
        TableColumn price = new TableColumn("Ár");
        TableColumn shopID = new TableColumn("Üzlet ID-je");

        addNewColumn(name, 200, "name");
        addNewColumn(type, 50, "type");
        addNewColumn(year, 50, "year");
        addNewColumn(piece, 50, "piece");
        addNewColumn(price, 50, "price");
        addNewColumn(shopID, 50, "shopID");

        stockTable.getColumns().addAll(name, type, year, piece, price, shopID);
        stockInvoiceData.addAll(dbWine.getAllWineByNameShopIDPrice_PerShop(loggedEmploy.getId()));
        stockTable.setItems(stockInvoiceData);

        invoicePartnerCB.getItems().clear();
        for (Partner p : dbPartner.getAllPartners()) {
            invoicePartnerCB.getItems().add(p.getName());
        }
        invoiceTypeCB.setItems(FXCollections.observableArrayList(Arrays.asList("készpénz", "bankkártya")));

        emptyTextField( invoiceQuantityTF, invoiceWine, invoiceFinalPriceTF, invoiceDateTF);

    }

    public boolean isClickedStockTable() {
        if (stockTable.getSelectionModel().getSelectedItem() != null) {
            selectedWine = (Wine) stockTable.getSelectionModel().getSelectedItem();
            invoiceWine.setText(selectedWine.getName());
            return true;
        }
        alert("Nincs kiválasztva tétel!");
        return false;
    }


    public boolean checkWineAndPiece() {
        if (isClickedStockTable()) {
            if (invoiceQuantityTF.getText() != null && !invoiceQuantityTF.getText().trim().equals("") && isNumeric(invoiceQuantityTF.getText())) {
                return true;
            } else {
                alert("Nincs kitöltve a darabszám!");
            }
        }
        return false;
    }

    public void setStockTableDataByCountry() {
        stockTableByCountry.getColumns().clear();
        stockTableByCountry.getItems().clear();

        TableColumn name = new TableColumn("Fajta");
        TableColumn type = new TableColumn("Típus");
        TableColumn year = new TableColumn("Évjárat");
        TableColumn piece = new TableColumn("Darabszám");
        TableColumn price = new TableColumn("Ár");
        TableColumn shopID = new TableColumn("Üzlet ID-je");

        addNewColumn(name, 200, "name");
        addNewColumn(type, 50, "type");
        addNewColumn(year, 50, "year");
        addNewColumn(piece, 50, "piece");
        addNewColumn(price, 50, "price");
        addNewColumn(shopID, 50, "shopID");

        stockTableByCountry.getColumns().addAll(name, type, year, piece, price, shopID);
        stockWineDataCountry.addAll(dbWine.getAllWineByNameShopIDPrice());
        stockTableByCountry.setItems(stockWineDataCountry);
    }


    //WINE MODIFIER PART WineDataChangePane teljes adatbázis betöltése

    public void setWineDataChangeTable() {
        wineDataChangeTable.getColumns().clear();
        wineDataChangeTable.getItems().clear();

        TableColumn name = new TableColumn("Fajta");
        TableColumn type = new TableColumn("Típus");
        TableColumn year = new TableColumn("Évjárat");
        TableColumn piece = new TableColumn("Darabszám");
        TableColumn price = new TableColumn("Ár");
        TableColumn shopID = new TableColumn("Üzlet ID-je");
        // TableColumn shopName = new TableColumn("Üzlet");
        TableColumn recordDate = new TableColumn("Rögzítés dátuma");

        addNewColumn(name, 200, "name");
        addNewColumn(type, 80, "type");
        addNewColumn(year, 50, "year");
        addNewColumn(piece, 50, "piece");
        addNewColumn(price, 50, "price");
        addNewColumn(shopID, 50, "shopID");
        addNewColumn(recordDate, 130, "date");

        List<Shop> shopss = dbShop.getAllShops();
        List<String> shopssID = new ArrayList<>();
        for (Shop s : shopss) {
            shopssID.add(s.getId());
        }
        shopIDChoiceBox.setItems(FXCollections.observableArrayList(shopssID));
        wineDataChangeTable.getColumns().addAll(name, type, year, piece, price, shopID, recordDate);
        wineData.addAll(dbWine.getAllWine());
        wineDataChangeTable.setItems(wineData);//ráküldöm a táblára az adatokat

    }

    public void setWineDataByCountry() {
        paneVisibleFalse(addPartnerPane, modifyPartnerPane, transferPane, wineDataChangePane, stockPaneByCountry, employeePane, invoicePane, stockPane);
        paneVisibleTrue(wineDataChangePane);
        wineDataChangePaneModifiers.setVisible(false);
    }


    public void addNewWine() {
        if (isEmpty(nameTFSet.getText(), typeTFSet.getText(), yearTFSet.getText(), pieceTFSet.getText(), priceTFSet.getText())) {
            alert("Nincs minden szükséges adat kitöltve!");
            return;
        }
        if (!isNumeric(yearTFSet.getText(), pieceTFSet.getText(), priceTFSet.getText())) {
            return;
        }
        if (shopIDChoiceBox != null) {
            Wine wine = new Wine(nameTFSet.getText(), typeTFSet.getText(), yearTFSet.getText(), pieceTFSet.getText(), priceTFSet.getText() + " Ft", shopIDChoiceBox.getSelectionModel().getSelectedItem().toString(), formatedDateTime);

            wineData.add(wine);
            dbWine.addNewWine(wine);


            dbWineStock.addNewWine_OR_Insert(wine);

            setWineDataChangeTable();
            nameTFSet.clear();
            typeTFSet.clear();
            yearTFSet.clear();
            pieceTFSet.clear();
            priceTFSet.clear();
        }
    }

    public boolean isItClickedWine() {
        if (!isSelectedEmpty(wineDataChangeTable)) {
            return false;
        }
        itIsClickedWine();
        return true;
    }

    Wine actualWine = null;

    public void itIsClickedWine() {
        actualWine = (Wine) wineDataChangeTable.getSelectionModel().getSelectedItem();
        List<TextField> txt = Arrays.asList(nameTFSet, typeTFSet, yearTFSet, pieceTFSet, priceTFSet);
        List<String> stringToTextField = Arrays.asList(actualWine.getName(), actualWine.getType(), actualWine.getYear(), actualWine.getPiece().replace(" db", ""), actualWine.getPrice().replace(" Ft", ""));
        setTextToTextFields(txt, stringToTextField);
        shopIDChoiceBox.setValue(actualWine.getShopID().toString());
    }

    public void removeWine() {
        if (isItClickedWine()) {
            if (areYouSure("Bor eltávolátas", "Biztosan el akarod távolítani az adatbázisból?")) {
                dbWine.removeWine(actualWine);
                wineData.clear();
                wineData.addAll(dbWine.getAllWine());
                setWineDataChangeTable();
                emptyTextField(nameTFSet, typeTFSet, yearTFSet, pieceTFSet, priceTFSet);
            } else {
                return;
            }
        } else {
            alert("Nem jelölt ki Bort!");
            return;
        }
    }


    //PARTNER TÁBLA feltöltése

    private void addNewCollumPartner(TableColumn name, int width, String attributeFromClass) {
        name.setMinWidth(width);
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        name.setCellValueFactory(new PropertyValueFactory<Partner, String>(attributeFromClass));
    }

    public void setPartnerAddTableData(TableView tableView) {
        tableView.getColumns().clear();
        tableView.getItems().clear();
        partnerData.clear();

        TableColumn name = new TableColumn("Név");
        TableColumn taxNumber = new TableColumn("Adószám");
        TableColumn contact = new TableColumn("Kontakt személy");
        TableColumn areaCode = new TableColumn("Irányítószám");
        TableColumn city = new TableColumn("Város");
        TableColumn street = new TableColumn("Utca");
        TableColumn streetNum = new TableColumn("Házszám");
        TableColumn phoneNumber = new TableColumn("Telefonszám");
        TableColumn email = new TableColumn("Email");
        TableColumn discount = new TableColumn("Kedvezmény");

        addNewCollumPartner(name, 100, "name");
        addNewCollumPartner(taxNumber, 70, "taxNumber");
        addNewCollumPartner(contact, 100, "contact");
        addNewCollumPartner(areaCode, 70, "areaCode");
        addNewCollumPartner(city, 80, "city");
        addNewCollumPartner(street, 80, "street");
        addNewCollumPartner(streetNum, 40, "streetNum");
        addNewCollumPartner(phoneNumber, 80, "phoneNumber");
        addNewCollumPartner(email, 100, "email");
        addNewCollumPartner(discount, 70, "discountPercent");

        tableView.getColumns().addAll(name, taxNumber, contact, areaCode, city, street, streetNum, phoneNumber, email, discount);
        partnerData.addAll(dbPartner.getAllPartners());
        tableView.setItems(partnerData);

    }

    public void addNewPartner() {
        if (isEmpty(nameTFPartner.getText(), taxNumberTFPartner.getText(), contactTFPartner.getText(), areaCodeTFPartner.getText(), cityTFPartner.getText(), streetTFPartner.getText(), streetNumTFPartner.getText(), phoneNumberTFPartner.getText(), emailTFPartner.getText(), discountTFPartner.getText())) {
            alert("Nincs minden szükséges adat kitöltve" + "\n" + "az új partner felvételéhez!");
            return;
        } else if (!isValidPhoneNumber(phoneNumberTFPartner.getText())) {
            return;
        } else if (!isValidEmail(emailTFPartner.getText())) {
            return;
        }

        Partner newPartner = new Partner(nameTFPartner.getText(), taxNumberTFPartner.getText(), contactTFPartner.getText(), areaCodeTFPartner.getText(), cityTFPartner.getText(), streetTFPartner.getText(), streetNumTFPartner.getText(), phoneNumberTFPartner.getText(), emailTFPartner.getText(), discountTFPartner.getText());
        partnerData.add(newPartner);
        dbPartner.addPartner(newPartner);
        emptyTextField(nameTFPartner, taxNumberTFPartner, contactTFPartner, areaCodeTFPartner, cityTFPartner, streetTFPartner, streetNumTFPartner, phoneNumberTFPartner, emailTFPartner, discountTFPartner);
    }


    //vizsgálom, hogy a táblába kattintott elem üres-e
    public boolean isSelectedEmpty(TableView table) {
        if (table.getSelectionModel().getSelectedItem() == null) {
            return false;
        }
        return true;

    }

    Partner actualPartner = null;

    //vizsgálom, hogy belekattintottak-e a táblába
    public boolean isItClickedPartner() {
        if (!isSelectedEmpty(modifyPartnerTable)) {
            return false;
        }
        itIsClickedPartner();
        return true;

    }

    public void itIsClickedPartner() {
        actualPartner = (Partner) modifyPartnerTable.getSelectionModel().getSelectedItem();
        List<TextField> txt = Arrays.asList(nameMTFPartner, taxNumberMTFPartner, areaCodeMTFPartner, cityMTFPartner, streetMTFPartner, streetNumMTFPartner, contactMTFPartner, phoneNumberMTFPartner, emailMTFPartner, discountMTFPartner);
        List<String> stringToTextField = Arrays.asList(actualPartner.getName(), actualPartner.getTaxNumber(), actualPartner.getAreaCode(), actualPartner.getCity(), actualPartner.getStreet(), actualPartner.getStreetNum(), actualPartner.getContact(), actualPartner.getPhoneNumber(), actualPartner.getEmail(), actualPartner.getDiscountPercent());
        setTextToTextFields(txt, stringToTextField);
    }

    //a partner módosító táblába csak betöltöm az alap táblát
    public void setPartnerModifyTableData() {
        setPartnerAddTableData(modifyPartnerTable);
        isItClickedPartner();

    }

    public void modifyPartner() {
        if (isEmpty(nameMTFPartner.getText(), taxNumberMTFPartner.getText(), contactMTFPartner.getText(), areaCodeMTFPartner.getText(), cityMTFPartner.getText(), streetMTFPartner.getText(), streetNumMTFPartner.getText(), phoneNumberMTFPartner.getText(), emailMTFPartner.getText(), discountMTFPartner.getText())) {
            alert("Nincs minden szükséges adat kitöltve" + "\n" + "a partner módosításához!");
            return;
        } else if (!isValidPhoneNumber(phoneNumberMTFPartner.getText()) && isValidEmail(emailMTFPartner.getText())) {
            return;
        }
        dbPartner.updatePartner(new Partner(Integer.parseInt(actualPartner.getId()), nameMTFPartner.getText(), taxNumberMTFPartner.getText(), contactMTFPartner.getText(), areaCodeMTFPartner.getText(), cityMTFPartner.getText(), streetMTFPartner.getText(), streetNumMTFPartner.getText(), phoneNumberMTFPartner.getText(), emailMTFPartner.getText(), discountMTFPartner.getText()));
        setPartnerModifyTableData();
        emptyTextField(nameMTFPartner, taxNumberMTFPartner, areaCodeMTFPartner, cityMTFPartner, streetMTFPartner, streetNumMTFPartner, contactMTFPartner, phoneNumberMTFPartner, emailMTFPartner, discountMTFPartner);

    }

    public void removePartner() {
        if (isItClickedPartner()) {
            if (areYouSure("Partner eltávolátas", "Biztosan el akarod távolítani az adatbázisból?")) {
                dbPartner.removePartner(actualPartner);
                partnerData.clear();
                partnerData.addAll(dbPartner.getAllPartners());
                setPartnerAddTableData(addPartnerTable);
                setPartnerAddTableData(modifyPartnerTable);
                emptyTextField(nameMTFPartner, taxNumberMTFPartner, areaCodeMTFPartner, cityMTFPartner, streetMTFPartner, streetNumMTFPartner, contactMTFPartner, phoneNumberMTFPartner, emailMTFPartner, discountMTFPartner);
            } else {
                return;
            }
        } else {
            alert("Nem jelölt ki partnert!");
            return;
        }
    }


    //EMPLOYEE TÁBLA feltöltése

    private void addNewCollumEmployee(TableColumn name, int width, String attributeFromClass) {
        name.setMinWidth(width);
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        name.setCellValueFactory(new PropertyValueFactory<Employee, String>(attributeFromClass));
    }

    public void setEmployeeAddTableData() {
        employeeTable.getColumns().clear();
        employeeTable.getItems().clear();

        //fejléceket csinálok az táblába
        TableColumn name = new TableColumn("Név");
        TableColumn level = new TableColumn("Szint");
        TableColumn birthDate = new TableColumn("Szül.év");
        TableColumn birthPlace = new TableColumn("Szül.hely");
        TableColumn IDCard = new TableColumn("Személyi ig.");
        TableColumn address = new TableColumn("Cím");
        TableColumn phoneNumber = new TableColumn("Telefonszám");
        TableColumn idShop = new TableColumn("Üzlet ID");
        TableColumn id = new TableColumn("Munkatárs ID");

        //a cellákkal feltöltöm az adattáblát
        addNewCollumEmployee(name, 100, "name");
        addNewCollumEmployee(level, 30, "level");
        addNewCollumEmployee(birthDate, 70, "birthDate");
        addNewCollumEmployee(birthPlace, 80, "birthPlace");
        addNewCollumEmployee(IDCard, 70, "IDCard");
        addNewCollumEmployee(address, 100, "address");
        addNewCollumEmployee(phoneNumber, 80, "phoneNumber");
        addNewCollumEmployee(idShop, 30, "idShop");
        addNewCollumEmployee(id, 30, "id");

        List<Shop> shopss = dbShop.getAllShops();
        List<String> shopssID = new ArrayList<>();
        for (Shop s : shopss) {
            shopssID.add(s.getId());
        }
        shopIDChoiceBoxEmployee.setItems(FXCollections.observableArrayList(shopssID));

        employeeTable.getColumns().addAll(name, level, birthDate, birthPlace, IDCard, address, phoneNumber, idShop, id);
        employeeData.addAll(dbEmployee.getAllEmployee());
        employeeTable.setItems(employeeData);

    }

    public void adNewEmployee() {

        if (isEmpty(nameTFEmployee.getText(), levelTFEmployee.getText(), birthDateTFEmployee.getText(), birthPlaceTFEmployee.getText(), IDCardTFEmployee.getText(), addressTFEmployee.getText(), phoneNumberTFEmployee.getText())) {
            alert("Nincs minden adat kitöltve az új Munkatárs rögzítéséhez!");
            return;
        } else if (!isValidBirthDate(birthDateTFEmployee.getText()) || !isValidPhoneNumber(phoneNumberTFEmployee.getText())) {
            return;
        } else if (shopIDChoiceBoxEmployee.getSelectionModel().isEmpty()) {
            alert("nem választott boltot");
        } else {
            Employee newEmployee = new Employee(nameTFEmployee.getText(), levelTFEmployee.getText(), birthDateTFEmployee.getText(), birthPlaceTFEmployee.getText(), IDCardTFEmployee.getText(), addressTFEmployee.getText(), phoneNumberTFEmployee.getText(), shopIDChoiceBoxEmployee.getSelectionModel().getSelectedItem().toString());

            employeeData.add(newEmployee);
            dbEmployee.addNewEmployee(newEmployee);
            newId = dbEmployee.checkEmployeeIdValid(newEmployee.getName()).getId();
            String passw = "A";
            dbEmployeePassword.addEmployeePassword(newId, passw);
            System.out.println("az alkalmazott ID-je: " + newId);
            setEmployeeAddTableData();
            emptyTextField(nameTFEmployee, levelTFEmployee, birthDateTFEmployee, birthPlaceTFEmployee, IDCardTFEmployee, addressTFEmployee, phoneNumberTFEmployee);
        }
    }


    Employee actualEmployee = null;

    //vizsgálom, hogy belekattintottak-e a táblába
    public boolean isItClickedEmployee() {
        if (!isSelectedEmpty(employeeTable)) {
            return false;
        }
        itIsClickedEmployee();
        return true;

    }

    public void itIsClickedEmployee() {
        actualEmployee = (Employee) employeeTable.getSelectionModel().getSelectedItem();
        List<TextField> txt = Arrays.asList(nameTFEmployee, levelTFEmployee, birthDateTFEmployee, birthPlaceTFEmployee, IDCardTFEmployee, addressTFEmployee, phoneNumberTFEmployee);
        List<String> stringToTextField = Arrays.asList(actualEmployee.getName(), actualEmployee.getLevel(), actualEmployee.getBirthDate(), actualEmployee.getBirthPlace(), actualEmployee.getIDCard(), actualEmployee.getAddress(), actualEmployee.getPhoneNumber());
        setTextToTextFields(txt, stringToTextField);
        shopIDChoiceBoxEmployee.setValue(actualEmployee.getIdShop().toString());
    }

    public void modifyEmployee() {
        if (isEmpty(nameTFEmployee.getText(), levelTFEmployee.getText(), birthDateTFEmployee.getText(), birthPlaceTFEmployee.getText(), IDCardTFEmployee.getText(), addressTFEmployee.getText(), phoneNumberTFEmployee.getText())) {
            alert("Nincs minden szükséges adat kitöltve" + "\n" + "az alkalmazott módosításához!");
            return;
        } else if (!isValidPhoneNumber(phoneNumberTFEmployee.getText())) {
            return;
        }
        dbEmployee.updateEmployee(new Employee(Integer.parseInt(actualEmployee.getId()), nameTFEmployee.getText(), levelTFEmployee.getText(), birthDateTFEmployee.getText(), birthPlaceTFEmployee.getText(), IDCardTFEmployee.getText(), addressTFEmployee.getText(), phoneNumberTFEmployee.getText(), shopIDChoiceBoxEmployee.getSelectionModel().getSelectedItem().toString()));
        emptyTextField(nameTFEmployee, levelTFEmployee, birthDateTFEmployee, birthPlaceTFEmployee, IDCardTFEmployee, addressTFEmployee, phoneNumberTFEmployee);

        setEmployeeAddTableData();
    }

    public void removeEmployee() {
        if (isItClickedEmployee()) {
            if (areYouSure("Alkalmazott eltávolátas", "Biztosan el akarod távolítani az adatbázisból?")) {
                dbEmployee.removeEmployee(actualEmployee);
                employeeData.clear();
                employeeData.addAll(dbEmployee.getAllEmployee());
                setEmployeeAddTableData();
                emptyTextField(nameTFEmployee, levelTFEmployee, birthDateTFEmployee, birthPlaceTFEmployee, IDCardTFEmployee, addressTFEmployee, phoneNumberTFEmployee);
            } else {
                return;
            }
        } else {
            alert("Nem jelölt ki alkalmazottat!");
            return;
        }

    }


    //SHOP TÁBLA
    private void addNewCollumShop(TableColumn name, int width, String attributeFromClass) {
        name.setMinWidth(width);
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        name.setCellValueFactory(new PropertyValueFactory<Shop, String>(attributeFromClass));
    }

    public void setShopAddTableData() {
        shopTable.getColumns().clear();
        shopTable.getItems().clear();
        TableColumn name = new TableColumn("Üzlet neve");
        TableColumn areaCode = new TableColumn("Irányítószám:");
        TableColumn city = new TableColumn("Város");
        TableColumn street = new TableColumn("Utca");
        TableColumn streetNum = new TableColumn("Házszám");
        TableColumn shopID = new TableColumn("Üzlet ID-je");

        addNewCollumShop(name, 100, "shopName");
        addNewCollumShop(areaCode, 100, "areaCode");
        addNewCollumShop(city, 100, "city");
        addNewCollumShop(street, 100, "street");
        addNewCollumShop(streetNum, 100, "streetNum");
        addNewCollumShop(shopID, 100, "id");

        shopTable.getColumns().addAll(name, areaCode, city, street, streetNum, shopID);
        shopData.addAll(dbShop.getAllShops());
        shopTable.setItems(shopData);
    }

    public void addNewShop() {
        Shop newShop = new Shop(shopNameTFShop.getText(), areaCodeTFShop.getText(), cityTFShop.getText(), streetTFShop.getText(), streetNumTFShop.getText());
        if (isEmpty(shopNameTFShop.getText(), areaCodeTFShop.getText(), cityTFShop.getText(), streetTFShop.getText(), streetNumTFShop.getText())) {
            alert("Nincs minden adat kitöltve az új Üzlet rögzítéshez!");
            return;
        } else if (!isNumeric(areaCodeTFShop.getText(), streetNumTFShop.getText())) {
            return;
        }

        shopData.add(newShop);
        dbShop.addNewShop(newShop);
        emptyTextField(shopNameTFShop, areaCodeTFShop, cityTFShop, streetTFShop, streetNumTFShop);
        setShopAddTableData();
    }

    Shop actualShop = null;

    //vizsgálom, hogy belekattintottak-e a táblába
    public boolean isItClickedShop() {
        if (!isSelectedEmpty(shopTable)) {
            return false;
        }
        itIsClickedShop();
        return true;

    }

    public void itIsClickedShop() {
        actualShop = (Shop) shopTable.getSelectionModel().getSelectedItem();

        List<TextField> txt = Arrays.asList(shopNameTFShop, areaCodeTFShop, cityTFShop, streetTFShop, streetNumTFShop);
        List<String> stringToTextField = Arrays.asList(actualShop.getShopName(), actualShop.getAreaCode(), actualShop.getCity(), actualShop.getStreet(), actualShop.getStreetNum());
        setTextToTextFields(txt, stringToTextField);
    }


    public void modifyShop() {
        if (isEmpty(shopNameTFShop.getText(), areaCodeTFShop.getText(), cityTFShop.getText(), streetTFShop.getText(), streetNumTFShop.getText())) {
            alert("Nincs minden szükséges adat kitöltve" + "\n" + "az Üzlet módosításához!");
            return;
        }
        dbShop.updateShop(new Shop(Integer.parseInt(actualShop.getId()), shopNameTFShop.getText(), areaCodeTFShop.getText(), cityTFShop.getText(), streetTFShop.getText(), streetNumTFShop.getText()));
        emptyTextField(shopNameTFShop, areaCodeTFShop, cityTFShop, streetTFShop, streetNumTFShop);
        shopData.clear();
        shopData.addAll(dbShop.getAllShops());
        setShopAddTableData();
    }

    public void removeShop() {
        if (isItClickedShop()) {
            if (areYouSure("Üzlet eltávolátas", "Biztosan el akarod távolítani az adatbázisból?")) {
                dbShop.removeShop(actualShop);
                shopData.clear();
                shopData.addAll(dbShop.getAllShops());
                setShopAddTableData();
                emptyTextField(shopNameTFShop, areaCodeTFShop, cityTFShop, streetTFShop, streetNumTFShop);
            } else {
                return;
            }
        } else {
            alert("Nem jelölt ki üzletet!");
            return;
        }

    }

    public boolean checkEmployee(String id) {
        if (dbEmployee.checkEmployeeIdValid(id) != null) {
            return true;
        }
        alert("Hibás felhasználónév!");
        return false;
    }


    public boolean logInDialog() {

        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Login Dialog");
        dialog.setHeaderText("Look, a Custom Login Dialog");

// Set the icon (must be included in the project).
        //  dialog.setGraphic(new ImageView(this.getClass().getResource("login.png").toString()));

// Set the button types.
        ButtonType loginButtonType = new ButtonType("Login", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

// Create the username and password labels and fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField username = new TextField();
        username.setPromptText("Username");
        PasswordField password = new PasswordField();
        password.setPromptText("Password");

        grid.add(new Label("Username:"), 0, 0);
        grid.add(username, 1, 0);
        grid.add(new Label("Password:"), 0, 1);
        grid.add(password, 1, 1);

// Enable/Disable login button depending on whether a username was entered.
        Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
        loginButton.setDisable(true);

// Do some validation (using the Java 8 lambda syntax).
        username.textProperty().addListener((observable, oldValue, newValue) -> {
            loginButton.setDisable(newValue.trim().isEmpty());
        });

        dialog.getDialogPane().setContent(grid);

// Request focus on the username field by default.
        Platform.runLater(() -> username.requestFocus());

// Convert the result to a username-password-pair when the login button is clicked.
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType) {
                return new Pair<>(username.getText(), password.getText());
            }
            System.exit(0);
            return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();


        for (Employee e : totalUsers) {
            if (e.getId().equals(username.getText())) {
                validID = e.getId();
            }
        }

        if (username.getText().equals("admin") && password.getText().equals("admin")) {
            level = "3";
            return true;
        }
        if (validID == null) {
            alert("hibás felhasználónév");
        }
       // System.out.println("az id: " + validID);

        if (dbEmployeePassword.checkEmployeePassword(validID) != null && !dbEmployeePassword.checkEmployeePassword(validID).equals("")) {
            if (dbEmployeePassword.checkEmployeePassword(validID).equals(password.getText())) {
                level = dbEmployee.loggedInEmployee(validID).getLevel();
                loggedEmploy = dbEmployee.loggedInEmployee(validID);
                //System.out.println("név" + loggedEmploy.getName() + "szint" + loggedEmploy.getLevel() + "id" + loggedEmploy.getId());
                return true;
            } else {
                alert("hibás jelszó");
                return false;
            }
        }
        return false;
    }

    public void startTheProgram() {
        setMenuData(level);
        setPromptTextes();
    }

    @Override
    public void initialize(URL location, ResourceBundle resource2s) {
        while (logInDialog() == false) {
            logInDialog();
        }
        startTheProgram();
    }
}
