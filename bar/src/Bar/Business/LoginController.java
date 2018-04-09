package Bar.Business;


import Bar.Main;
import Bar.Persistence.Customer;
import Bar.Persistence.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;


public class LoginController {
    @FXML private TextField cpf;
    @FXML private TextField name;
    @FXML private TextField age;
    @FXML private TextField memberId;
    @FXML private ToggleGroup gender;
    @FXML private RadioButton male;
    @FXML private RadioButton female;
    @FXML private Button checkin;

    public void checkin(ActionEvent event) {
        char genderSelected = male.isSelected() ? 'M' : 'F';

        if(memberId.getText().length() > 0 && !memberId.getText().isEmpty()) {
            Member m = new Member(cpf.getText(), name.getText(), Integer.parseInt(age.getText()), genderSelected, Integer.parseInt(memberId.getText()));
            Main.bar.addCustomer(m);
        } else {
            Customer c = new Customer(cpf.getText(), name.getText(), Integer.parseInt(age.getText()), genderSelected);
            Main.bar.addCustomer(c);
        }

        System.out.println(Main.bar.getCustomers());
    }
}
