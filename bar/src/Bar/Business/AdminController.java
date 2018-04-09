package Bar.Business;

import Bar.Main;
import Bar.Persistence.Customer;
import Bar.Persistence.Member;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Callback;
import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.List;

/**
 * Created by vinimtex on 15/09/2017.
 */
public class AdminController {
    @FXML private AnchorPane container;
    @FXML private TableView<Customer> customerTable;
    @FXML private TextField search;
    @FXML private Text totalCustomers;
    @FXML private Text totalMembers;
    @FXML private Text totalMaleCustomers;
    @FXML private Text totalFemaleCustomers;

    private FilteredList<Customer> dataTableFiltered;

    @FXML
    public void initialize() {
        dataTableFiltered = new FilteredList<>(Main.bar.getCustomers(), p -> true);

        buildTable();
        addBarListeners();

        customerTable.setItems(dataTableFiltered);
    }

    private void addBarListeners() {

        Main.bar.getCustomers().addListener((ListChangeListener<Customer>) c -> {
            totalCustomers.setText(String.valueOf(Main.bar.getCustomers().size()));
            totalMembers.setText(String.valueOf(Main.bar.countMembers()) + " (" + Main.bar.percentMembers() +" %)");
            totalFemaleCustomers.setText(String.valueOf(Main.bar.countFemaleCustomers()) + " (" + Main.bar.percentFemaleCustomers() +" %)");
            totalMaleCustomers.setText(String.valueOf(Main.bar.countMaleCustomers()) + " (" + Main.bar.percentMaleCustomers() +" %)");
        });

    }

    private void buildTable() {

        TableColumn name = new TableColumn("Nome");
        name.setCellValueFactory(new PropertyValueFactory<Customer, String>("name"));

        TableColumn cpf = new TableColumn("CPF");
        cpf.setCellValueFactory(new PropertyValueFactory<Customer, String>("cpf"));

        TableColumn age = new TableColumn("Idade");
        age.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("age"));

        TableColumn gender = new TableColumn("Gênero");
        gender.setCellValueFactory(new PropertyValueFactory<Customer, Character>("gender"));

        TableColumn member = new TableColumn("ID Sócio");
        member.setCellValueFactory(new PropertyValueFactory<Member, Integer>("memberId"));



        search.textProperty().addListener((observable, oldValue, newValue) -> {
            dataTableFiltered.setPredicate(customer -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String normalizedFilter = newValue.toLowerCase();

                if(customer.getCpf().contains(normalizedFilter)) {
                    return true;
                }

                return false;
            });
        });


        customerTable.getColumns().addAll(name, cpf, age, gender, member);

    }

}
