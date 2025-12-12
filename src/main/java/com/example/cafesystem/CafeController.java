package com.example.cafesystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;

public class CafeController {
    @FXML
    private Label label;
    @FXML
    final static ObservableList<Order> completed_orders = FXCollections.observableArrayList();
    @FXML
    private ListView<String> listView;
    @FXML
    private ListView<String> menuView;
    @FXML
    private ListView<String> baristaView;
    @FXML
    private static int listcount = -1;
    @FXML
    final static ObservableList<Order> list = FXCollections.observableArrayList();
    @FXML
    private Label lblStatus;
    @FXML
    private TextField txtPassword;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtOrderName;
    @FXML
    private TextField txtMenuItem1;
    @FXML
    private TextField txtMenuItem2;
    @FXML
    private TextField txtMenuItem3;
    @FXML
    private TextField txtMenuItem4;
    @FXML
    private TextField txtMenuItem5;
    @FXML
    private TextField txtMenuItem6;
    @FXML
    private TextField txtMenuItem7;
    @FXML
    private TextField txtMenuItem8;
    @FXML
    private TextField txtMenuItem9;
    @FXML
    private TextField txtMenuItem10;
//    @FXML
//    private ComboBox<String> CoffeeCombo = new ComboBox<>();
    @FXML
    final static ObservableList<String> CoffeeItems = FXCollections.observableArrayList("Latte", "Cappuccino", "Espresso");
    @FXML
    private ComboBox<String> comb1 = new ComboBox<String>();
    @FXML
    final static ObservableList<String> TeaItems = FXCollections.observableArrayList("Green Tea", "Black Tea", "Herbal Tea");
    @FXML
    private ComboBox<String> comb2 = new ComboBox<String>();
    @FXML
    public ObservableList<String> CupSizes = FXCollections.observableArrayList("Small", "Medium", "Large");
    @FXML
    private ComboBox<String> comb3 = new ComboBox<String>();
    @FXML
    public ObservableList<String> Customizations = FXCollections.observableArrayList("Extra Shot", "Decaf", "Oat Milk", "Almond Milk", "Sugar Free Syrup");
    @FXML
    private ComboBox<String> comb4 = new ComboBox<String>();
    @FXML
    final static ObservableList<String> Croissants = FXCollections.observableArrayList("Butter", "Chocolate");
    @FXML
    private ComboBox<String> comb5 = new ComboBox<String>();
    @FXML
    final static ObservableList<String> Muffins = FXCollections.observableArrayList("Blueberry", "Chocolate Chip");
    @FXML
    private ComboBox<String> comb6 = new ComboBox<String>();
    @FXML
    final static ObservableList<String> Cookies = FXCollections.observableArrayList("Chocolate Chip", "Oatmeal Raisin");
    @FXML
    private ComboBox<String> comb7 = new ComboBox<String>();

    public void initialize() {
        comb1.setValue("Select Coffee");
        comb1.setItems(CoffeeItems);

        comb2.setValue("Select Tea");
        comb2.setItems(TeaItems);

        comb3.setValue("Select Size");
        comb3.setItems(CupSizes);

        comb4.setValue("Select Customization");
        comb4.setItems(Customizations);

        comb5.setValue("Select Croissant");
        comb5.setItems(Croissants);

        comb6.setValue("Select Muffin");
        comb6.setItems(Muffins);

        comb7.setValue("Select Cookie");
        comb7.setItems(Cookies);
    }

    @FXML
    public void setLabel(ActionEvent event) throws IOException {
        Order order = list.get(listcount);
        String view = order.getOrderName();
        listView.getItems().add("Name on Order: " + order.getOrderName());
        List<Coffee> coffees = order.getCoffees();
        List<Tea> teas = order.getTeas();
        List<Croissant> croissants = order.getCroissants();
        List<Muffin> muffins = order.getMuffins();
        List<Cookie> cookies = order.getCookies();
        if(coffees.size() > 0){
            listView.getItems().add("coffees (" + order.getCoffees().size() + "): ");
            for(int i = 0; i < coffees.size(); i++){
                listView.getItems().add(coffees.get(i).getType());
            }
        }
        if(teas.size() > 0){
            listView.getItems().add("Teas (" + order.getTeas().size() + "): ");
            for(int j = 0; j < teas.size(); j++) {
                listView.getItems().add(teas.get(j).getType());
            }
        }
        if(croissants.size() > 0){
            listView.getItems().add("Croissants (" + order.getCroissants().size() + "): ");
            for(int k = 0; k < croissants.size(); k++){
                listView.getItems().add(croissants.get(k).getType());
            }
        }
        if(muffins.size() > 0){
            listView.getItems().add("Muffins (" + order.getMuffins().size() + "): ");
            for(int l = 0; l < muffins.size(); l++){
                listView.getItems().add(muffins.get(l).getType());
            }
        }
        if(cookies.size() > 0){
            listView.getItems().add("Cookies (" + order.getCookies().size() + "): ");
            for(int m = 0; m < cookies.size(); m++){
                listView.getItems().add(cookies.get(m).getType());
            }
        }
        listView.getItems().add("Total: " + order.getTotal());
    }

    @FXML
    public void SetMenuView(ActionEvent event) throws IOException {
        menuView.getItems().clear();
        menuView.getItems().addAll(CoffeeItems);
        menuView.getItems().addAll(TeaItems);
        menuView.getItems().addAll(CupSizes);
        menuView.getItems().addAll(Croissants);
        menuView.getItems().addAll(Muffins);
        menuView.getItems().addAll(Cookies);
        menuView.getItems().toString();
    }

    @FXML
    public void createMenu(ActionEvent event) throws IOException {
        Stage stage_new = new Stage();
        FXMLLoader fxmlLoader_new = new FXMLLoader(CafeApplication.class.getResource("add_remove_menu_items.fxml"));
        //Disregard the previous stage when clicking Menu Catalog, reuse most previous window.
        //Stage stage_new = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene_new = new Scene(fxmlLoader_new.load(), 327, 393);
        stage_new.setTitle("Add Remove Items");
        stage_new.setScene(scene_new);
        stage_new.show();
    }

    @FXML
    public void changePrices(ActionEvent event) throws IOException {
        Stage stage_new = new Stage();
        FXMLLoader fxmlLoader_new = new FXMLLoader(CafeApplication.class.getResource("set_prices.fxml"));
        //Disregard the previous stage when clicking Menu Catalog, reuse most previous window.
        //Stage stage_new = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene_new = new Scene(fxmlLoader_new.load(), 327, 393);
        stage_new.setTitle("Set Prices");
        stage_new.setScene(scene_new);
        stage_new.show();
    }

    public void setNewPrices(ActionEvent event) throws IOException {
        int coffee_price = Integer.parseInt(txtMenuItem6.getText());
        System.out.println("new coffee_price: " + coffee_price);
    }

    @FXML
    public void removeCoffeeItems(ActionEvent event) throws IOException {
        String combo1_result = comb1.getSelectionModel().getSelectedItem().toString();
        CoffeeItems.removeAll(combo1_result);
    }

    @FXML
    public void addCoffeeItems(ActionEvent event) throws IOException {
        String new_coffee = txtMenuItem1.getText();
        CoffeeItems.add(new_coffee);
        CoffeeItems.toString();
    }

    @FXML
    public void removeTeaItems(ActionEvent event) throws IOException {
        String combo2_result = comb2.getSelectionModel().getSelectedItem().toString();
        TeaItems.removeAll(combo2_result);
    }

    @FXML
    public void addTeaItems(ActionEvent event) throws IOException {
        String new_tea = txtMenuItem2.getText();
        TeaItems.add(new_tea);
        TeaItems.toString();
    }

    @FXML
    public void removeCroissantItems(ActionEvent event) throws IOException {
        String combo5_result = comb5.getSelectionModel().getSelectedItem().toString();
        Croissants.removeAll(combo5_result);
    }
    @FXML
    public void addCroissantItems(ActionEvent event) throws IOException {
        String new_croissant = txtMenuItem3.getText();
        Croissants.add(new_croissant);
        Croissants.toString();
    }

    @FXML
    public void removeMuffinItems(ActionEvent event) throws IOException {
        String combo6_result = comb6.getSelectionModel().getSelectedItem().toString();
        Muffins.removeAll(combo6_result);
    }

    @FXML
    public void addMuffinItems(ActionEvent event) throws IOException {
        String new_muffin = txtMenuItem4.getText();
        Muffins.add(new_muffin);
        Muffins.toString();
    }

    @FXML
    public void removeCookiesItems(ActionEvent event) throws IOException {
        String combo7_result = comb7.getSelectionModel().getSelectedItem().toString();
        Cookies.removeAll(combo7_result);
    }

    @FXML
    public void addCookiesItems(ActionEvent event) throws IOException {
        String new_cookies = txtMenuItem5.getText();
        Cookies.add(new_cookies);
    }

    @FXML
    public void setBaristaView(ActionEvent event) throws IOException {
        baristaView.getItems().clear();
        for(int i = 0; i < list.size(); i++){
            baristaView.getItems().add("ID Name: " + list.get(i).getOrderName() + "; Type: " + list.get(i).toString() + "; Status: " + list.get(i).getStatus());
            System.out.println(list.get(i).toString());
        }
    }

    @FXML
    public void addInProgress(ActionEvent event) throws IOException {
        baristaView.getItems().clear();
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getStatus().equals("Pending")) {
                list.get(i).setStatus("In Progress");
                break;
            }
        }
        for(int j = 0; j < list.size(); j++){
            baristaView.getItems().add("ID Name: " + list.get(j).getOrderName() + "; Type: " + list.get(j).toString() + "; Status: " + list.get(j).getStatus());
            System.out.println(list.get(j).toString());
        }
    }
    @FXML
    public void setToReady(ActionEvent event) throws IOException {
        baristaView.getItems().clear();
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getStatus().equals("In Progress")) {
                list.get(i).setStatus("Ready");
                break;
            }
        }
        for(int j = 0; j < list.size(); j++){
            baristaView.getItems().add("ID Name: " + list.get(j).getOrderName() + "; Type: " + list.get(j).toString() + "; Status: " + list.get(j).getStatus());
            System.out.println(list.get(j).toString());
        }
    }
    @FXML
    public void sendOrder(ActionEvent event) throws IOException {
        baristaView.getItems().clear();
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getStatus().equals("Ready")) {
                list.get(i).setStatus("Fulfilled");
                completed_orders.add(list.get(i));
                list.remove(i);
                listcount--;
                break;
            }
        }
        for(int j = 0; j < list.size(); j++){
            baristaView.getItems().add("ID Name: " + list.get(j).getOrderName() + "; Type: " + list.get(j).toString() + "; Status: " + list.get(j).getStatus());
            System.out.println(list.get(j).toString());
        }
    }

//    @FXML
//    public void BarristaScene(ActionEvent event) throws IOException {
//        Stage stage1 = new Stage();
//        FXMLLoader fxmlLoader = new FXMLLoader(CafeApplication.class.getResource("barista_login.fxml"));
//        //Stage stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
//        Scene scene = new Scene(fxmlLoader.load(), 300, 300);
//        stage1.setTitle("Barista Login");
//        stage1.setScene(scene);
//        stage1.show();
//    }
//
//    @FXML
//    public void ManagerScene(ActionEvent event) throws IOException {
//        Stage stage1 = new Stage();
//        FXMLLoader fxmlLoader = new FXMLLoader(CafeApplication.class.getResource("manager_login.fxml"));
//        //Stage stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
//        Scene scene = new Scene(fxmlLoader.load(), 300, 300);
//        stage1.setTitle("Manager Login");
//        stage1.setScene(scene);
//        stage1.show();
//    }
//
//    @FXML
//    public void CustomerScene(ActionEvent event) throws IOException {
//        Stage stage1 = new Stage();
//        FXMLLoader fxmlLoader = new FXMLLoader(CafeApplication.class.getResource("SetName.fxml"));
//        //Stage stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
//        Scene scene = new Scene(fxmlLoader.load(), 300, 300);
//        stage1.setTitle("Set Name");
//        stage1.setScene(scene);
//        stage1.show();
//    }

    @FXML
    public void BaristaLogin(ActionEvent event) throws IOException {
        if(txtUsername.getText().equals("user") && txtPassword.getText().equals("pass")){
            lblStatus.setText("Login Success");
            FXMLLoader fxmlLoader_new = new FXMLLoader(CafeApplication.class.getResource("ProceedToBaristaMain.fxml"));
            Stage stage_new = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene_new = new Scene(fxmlLoader_new.load(), 300, 300);
            stage_new.setTitle("Barista Main");
            stage_new.setScene(scene_new);
            stage_new.show();
        }else{
            lblStatus.setText("Login Failed");
        }
    }
    @FXML
    public void ManagerLogin(ActionEvent event) throws IOException {

        if(txtUsername.getText().equals("user") && txtPassword.getText().equals("pass")){
            lblStatus.setText("Login Success");
            FXMLLoader fxmlLoader_new = new FXMLLoader(CafeApplication.class.getResource("ProceedToManagerInterface.fxml"));
            Stage stage_new = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene_new = new Scene(fxmlLoader_new.load(), 300, 300);
            stage_new.setTitle("Manager Main");
            stage_new.setScene(scene_new);
            stage_new.show();
        }else{
            lblStatus.setText("Login Failed");
        }
    }

    @FXML
    public void setName(ActionEvent event) throws IOException {
        //Create initial order as first item in list
        String name = txtOrderName.getText();
        listcount++;
        list.add(new Order(name));
        System.out.println("Initiate size is " + list.get(listcount).getOrderCount());
        System.out.println("Initiate name is " + list.get(listcount).getOrderName());
        FXMLLoader fxmlLoader_new = new FXMLLoader(CafeApplication.class.getResource("ProceedToOrder.fxml"));
        //Disregard the previous stage when clicking Menu Catalog, reuse most previous window.
        Stage stage_new = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene_new = new Scene(fxmlLoader_new.load(), 300 , 300);
        stage_new.setTitle("Customer Main");
        stage_new.setScene(scene_new);
        stage_new.show();
    }
    /***Consider changing to controller.Application****/
    @FXML
    public void showMenuCatalog(ActionEvent event) throws IOException {
        //label.setText("Menu Catalog");
        Stage stage_new = new Stage();
        FXMLLoader fxmlLoader_new = new FXMLLoader(CafeApplication.class.getResource("MenuCatalog.fxml"));
        //Stage stage_new = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene_new = new Scene(fxmlLoader_new.load(), 345, 645);
        stage_new.setTitle("Menu Catalog");
        stage_new.setScene(scene_new);
        stage_new.show();
    }
    @FXML
    public void addCoffee(ActionEvent event) throws IOException {
        Stage stage_new = new Stage();
        FXMLLoader fxmlLoader_new = new FXMLLoader(CafeApplication.class.getResource("addCoffee.fxml"));
        //Stage stage_new = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene_new = new Scene(fxmlLoader_new.load(), 300, 375);
        stage_new.setTitle("Add Coffee");
        stage_new.setScene(scene_new);
        stage_new.show();
    }

    @FXML
    public void addCoffeeToOrder(ActionEvent event) throws IOException {
        String comb1_item = comb1.getSelectionModel().getSelectedItem().toString();
        String comb3_item = comb3.getSelectionModel().getSelectedItem().toString();
        String comb4_item = comb4.getSelectionModel().getSelectedItem().toString();
        Coffee coffee = new Coffee(comb1_item, comb3_item, comb4_item);
        PricingData data = new PricingData();
        System.out.println(comb1_item + "\t" + comb3_item + "\t" + comb4_item);
        list.get(listcount).addCoffee(coffee);
        //Alternative to switch case scenario using interfaces?
        switch (comb1_item) {
            case "Latte":
                list.get(listcount).setTotal(data.getLatte());
                break;
            case "Cappuccino":
                list.get(listcount).setTotal(data.getCappuccino());
                break;
            case "Espresso":
                list.get(listcount).setTotal(data.getEspresso());
                break;
            default:
                System.out.println("Ask Attendant for Pricing");
        }
        switch (comb3_item) {
            case "Small":
                list.get(listcount).setTotal(data.getSmall());
                break;
            case "Medium":
                list.get(listcount).setTotal(data.getMed());
                break;
            case "Large":
                list.get(listcount).setTotal(data.getLarge());
                break;
            default:
                System.out.println("Invalid item");
        }
        //Add .25 for each customization
        list.get(listcount).setTotal(data.getCustomization());
    }

    @FXML
    public void addTea(ActionEvent event) throws IOException {
        Stage stage_new = new Stage();
        FXMLLoader fxmlLoader_new = new FXMLLoader(CafeApplication.class.getResource("addTea.fxml"));
        //Stage stage_new = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene_new = new Scene(fxmlLoader_new.load(), 300, 300);
        stage_new.setTitle("Add Tea");
        stage_new.setScene(scene_new);
        stage_new.show();
    }

    @FXML
    public void addTeaToOrder(ActionEvent event) throws IOException {
        String comb2_item = comb2.getSelectionModel().getSelectedItem().toString();
        String comb3_item = comb3.getSelectionModel().getSelectedItem().toString();
        String comb4_item = comb4.getSelectionModel().getSelectedItem().toString();
        Tea tea = new Tea(comb2_item, comb3_item, comb4_item);
        System.out.println(comb2_item + "\t" + comb3_item + "\t" + comb4_item);
        list.get(listcount).addTea(tea);
        switch (comb2_item) {
            case "Green Tea":
                list.get(listcount).setTotal(2.5);
                break;
            case "Black Tea":
                list.get(listcount).setTotal(3);
                break;
            case "Herbal Tea":
                list.get(listcount).setTotal(3.5);
                break;
            default:
                System.out.println("Invalid item");
        }
        switch (comb3_item) {
            case "Small":
                list.get(listcount).setTotal(.25);
                break;
            case "Medium":
                list.get(listcount).setTotal(.5);
                break;
            case "Large":
                list.get(listcount).setTotal(.75);
                break;
            default:
                System.out.println("Invalid item");
        }
        //Add .25 for each customization
        list.get(listcount).setTotal(.25);
    }

    @FXML
    public void addCroissant(ActionEvent event) throws IOException {
        Stage stage_new = new Stage();
        FXMLLoader fxmlLoader_new = new FXMLLoader(CafeApplication.class.getResource("addCroissant.fxml"));
        //Stage stage_new = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene_new = new Scene(fxmlLoader_new.load(), 300, 300);
        stage_new.setTitle("Add Croissant");
        stage_new.setScene(scene_new);
        stage_new.show();
    }

    @FXML
    public void addCroissantToOrder(ActionEvent event) throws IOException {
        String comb5_item = comb5.getSelectionModel().getSelectedItem().toString();
        Croissant croissant = new Croissant(comb5_item);
        System.out.println(comb5_item);
        list.get(listcount).addCroissant(croissant);
        switch (comb5_item) {
            case "Butter":
                list.get(listcount).setTotal(3.5);
                break;
            case "Chocolate":
                list.get(listcount).setTotal(4);
                break;
            default:
                System.out.println("Invalid item");
        }
    }

    @FXML
    public void addMuffin(ActionEvent event) throws IOException {
        Stage stage_new = new Stage();
        FXMLLoader fxmlLoader_new = new FXMLLoader(CafeApplication.class.getResource("addMuffin.fxml"));
        Scene scene_new = new Scene(fxmlLoader_new.load(), 300, 300);
        stage_new.setTitle("Add Muffin");
        stage_new.setScene(scene_new);
        stage_new.show();
    }

    @FXML
    public void addMuffinToOrder(ActionEvent event) throws IOException {
        String comb6_item = comb6.getSelectionModel().getSelectedItem().toString();
        Muffin  muffin = new Muffin(comb6_item);
        System.out.println(comb6_item);
        list.get(listcount).addMuffin(muffin);
        switch (comb6_item) {
            case "Blueberry":
                list.get(listcount).setTotal(3.5);
                break;
            case "Chocolate Chip":
                list.get(listcount).setTotal(4);
                break;
            default:
                System.out.println("Invalid item");
        }
    }

    @FXML
    public void addCookie(ActionEvent event) throws IOException {
        Stage stage_new = new Stage();
        FXMLLoader fxmlLoader_new = new FXMLLoader(CafeApplication.class.getResource("addCookie.fxml"));
        Scene scene_new = new Scene(fxmlLoader_new.load(), 300, 300);
        stage_new.setTitle("Add Cookie");
        stage_new.setScene(scene_new);
        stage_new.show();
    }

    @FXML
    public void addCookieToOrder(ActionEvent event) throws IOException {
        String comb7_item = comb7.getSelectionModel().getSelectedItem().toString();
        Cookie cookie = new Cookie(comb7_item);
        System.out.println(comb7_item);
        //new_order.addCookie(cookie);
        list.get(listcount).addCookie(cookie);
        switch (comb7_item) {
            case "Chocolate Chip":
                list.get(listcount).setTotal(3.5);
                break;
            case "Oatmeal Raisin":
                list.get(listcount).setTotal(4);
                break;
            default:
                System.out.println("Invalid item");
        }
    }

    public void completeOrder(ActionEvent event) throws IOException {
        System.out.println("list count is: " + listcount);
        for(int i  = 0; i < list.size(); i++) {
            System.out.println("name in list at " + i + "\n" + list.get(i).getOrderName());
            System.out.println("items in list at " + i + "\n" + list.get(i).toString());
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void clearOrder(ActionEvent event) throws IOException {
        list.remove(listcount);
        listcount--;
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void placeOrder(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void close(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}

