/*
 *Main.java
*This is the main section
*Author: Christian Mukuna Mbuyi (221478302)
*02/08/2022
 */
package za.ac.cput.userregis;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author FARAI SKOOL
 */
public class UserRegistrationGUI extends JFrame implements ActionListener {

    private JLabel lblTitle;
    private JComboBox comboTitle;
    private JLabel lblErrorTitle;

    private JLabel lblFirstName;
    private JTextField txtFirstName;
    private JLabel lblErrorFirstName;

    private JLabel lblLastName;
    private JTextField txtLastName;
    private JLabel lblErrorLastName;

    private JLabel lblGender;
    private JPanel panelGender;
    private JRadioButton radMale;
    private JRadioButton radFemale;
    private JLabel lblErrorGender;
    private ButtonGroup genderButtonGroup;

    private JLabel lblEmail;
    private JTextField txtEmail;
    private JLabel lblErrorEmail;

    //added this 
    private JLabel lblPassword;
    private JPasswordField txtPassword;
    private JLabel lblErrorPassword;

    private JLabel lblConfirmPassword;
    private JPasswordField txtConfirmPassword;
    private JLabel lblErrorConfirmPassword;

    private JLabel lblTerms;
    private JCheckBox chkTerms;
    private JLabel lblErrorTerms;

    private JButton btnSave;
    private JButton btnClear;
    private JButton btnExit;

    private Font fnt;

    //contructer
    public UserRegistrationGUI() {
        super("User Registration Form");

        lblTitle = new JLabel("Title :");
        String comboTitles[] = {"Dr", "Mrs", "Miss", "Mr", "Prof "};
        comboTitle = new JComboBox(comboTitles);

        lblErrorTitle = new JLabel("");
        lblErrorTitle.setForeground(Color.red);
        lblErrorTitle.setVisible(false);

        lblFirstName = new JLabel("First Name: ");
        txtFirstName = new JTextField(20);
        lblErrorFirstName = new JLabel("*required* please fill in");
        lblErrorFirstName.setForeground(Color.red);
        lblErrorFirstName.setVisible(false);

        lblLastName = new JLabel("Last Name: ");
        txtLastName = new JTextField(20);
        lblErrorLastName = new JLabel("*required* please fill in");
        lblErrorLastName.setForeground(Color.red);
        lblErrorLastName.setVisible(false);

        lblGender = new JLabel("Gender: ");
        panelGender = new JPanel();
        radFemale = new JRadioButton("Female");
        radMale = new JRadioButton("Male");
        genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(radFemale);
        genderButtonGroup.add(radMale);
        panelGender.setLayout(new GridLayout(1, 2));
        //radMale.setSelected(true);
        panelGender.add(radMale);
        panelGender.add(radFemale);
        lblErrorGender = new JLabel("*required* please fill in");
        lblErrorGender.setForeground(Color.red);
        lblErrorGender.setVisible(false);

        lblEmail = new JLabel("Email: ");
        txtEmail = new JTextField(15);
        lblErrorEmail = new JLabel("*Please enter valid email");
        lblErrorEmail.setForeground(Color.red);
        lblErrorEmail.setVisible(false);

        lblPassword = new JLabel("Password");
        txtPassword = new JPasswordField();
        lblErrorPassword = new JLabel("minimum of 8 characters required");
        lblErrorPassword.setForeground(Color.red);
        lblErrorPassword.setVisible(false);

        lblConfirmPassword = new JLabel("Cormfirm Password: ");
        txtConfirmPassword = new JPasswordField();
        lblErrorConfirmPassword = new JLabel("Password do not match");
        lblErrorConfirmPassword.setForeground(Color.red);
        lblErrorConfirmPassword.setVisible(false);

        lblTerms = new JLabel("Terms and Conditions: ");
        chkTerms = new JCheckBox("I agree to T&Cs to proceed");
        lblErrorTerms = new JLabel(" ");
        lblErrorTerms.setForeground(Color.red);
        lblErrorTerms.setVisible(false);

        btnSave = new JButton("Save");
        btnExit = new JButton("Exit");

        fnt = new Font("Arial", Font.BOLD, 15);
        btnClear = new JButton("Clear");
        btnSave.setEnabled(true);

    }

    public void setGUI() {

        this.setLayout(new GridLayout(9, 3));
        this.add(lblTitle);
        this.add(comboTitle);
        this.add(lblErrorTitle);
        lblTitle.setFont(fnt);
        lblErrorTitle.setFont(fnt);

        this.add(lblFirstName);
        this.add(txtFirstName);
        this.add(lblErrorFirstName);
        lblFirstName.setFont(fnt);

        this.add(lblLastName);
        this.add(txtLastName);
        this.add(lblErrorLastName);
        lblLastName.setFont(fnt);

        this.add(lblGender);
        this.add(panelGender);
        this.add(lblErrorGender);
        lblGender.setFont(fnt);

        this.add(lblEmail);
        this.add(txtEmail);
        this.add(lblErrorEmail);
        lblEmail.setFont(fnt);

        this.add(lblPassword);
        this.add(txtPassword);
        this.add(lblErrorPassword);
        lblPassword.setFont(fnt);

        this.add(lblConfirmPassword);
        this.add(txtConfirmPassword);
        this.add(lblErrorConfirmPassword);
        lblConfirmPassword.setFont(fnt);

        this.add(lblTerms);
        this.add(chkTerms);
        this.add(lblErrorTerms);
        lblTerms.setFont(fnt);

        btnSave.setEnabled(false);
         this.add(btnSave);
        this.add(btnExit);
        this.add(btnClear);
        // btnNext.setForeground(Color.green);
        //btnPrev.setForeground(Color.green);
        //btnExit.setForeground(Color.green);

        //btnNext.setBackground(Color.DARK_GRAY);
        //btnPrev.setBackground(Color.DARK_GRAY);
        //btnExit.setBackground(Color.red);
        btnSave.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);
        chkTerms.addActionListener(this);

        this.setTitle("Surve Registration");

        this.setPreferredSize(new Dimension(600, 350));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public void resetForm() {
        comboTitle.setSelectedIndex(0);
        txtFirstName.setText("");
        txtLastName.setText("");
        genderButtonGroup.clearSelection();
        txtEmail.setText("");
        txtPassword.setText("");
        txtConfirmPassword.setText("");
        // chkTerms.setSelected(false);

        lblErrorFirstName.setText("");
        lblErrorLastName.setText("");
        lblErrorEmail.setText("");
        lblErrorPassword.setText("");
        lblErrorConfirmPassword.setText("");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

//        String title = String.valueOf(comboTitle.getSelectedItem());
//        String firstName = txtFirstName.getText();
//        String lastName = txtLastName.getText();
//        String gender = radFemale.isSelected() ? "Feamle" : "Male";
//        String email = txtEmail.getText();
//        String password = txtPassword.getText();
//        String.valueOf(txtPassword.getPassword());
        if (e.getSource() == btnSave) {
            if (isInputValid()) {
                //UserRegistration u = new UserRegistration(title, firstName, lastName, gender, email, password);
                UserRegistration u = new UserRegistration(comboTitle.getSelectedItem().toString(),
                        txtFirstName.getText(),
                        txtLastName.getText(),
                        radFemale.isSelected() ? "Female" : "Male",
                        txtEmail.getText(),
                        String.valueOf(txtPassword.getPassword()));

                u.save();
                resetForm();
            }
        }

        if (e.getSource() == btnExit) {
            System.exit(0);
        } else if (e.getSource() == btnClear) {
            resetForm();

        } else if (e.getSource() == chkTerms) {
            // disable and enable button based on whether checkbox is checked or not

            if (chkTerms.isSelected()) {
                btnSave.setEnabled(true);
            } else {
                btnSave.setEnabled(false);
            }

        }

    }

    public boolean isInputValid() {
        boolean valid = true;
        if (txtFirstName.getText().equals("")) {
            valid = false;
            lblErrorFirstName.setVisible(true);
        } else {
            lblErrorFirstName.setVisible(false);
        }

        if (txtLastName.getText().equals("")) {
            valid = false;
            lblErrorLastName.setVisible(true);

        } else {
            lblErrorLastName.setVisible(false);
        }

        if (txtEmail.getText().equals("")) {
            valid = false;
            lblErrorEmail.setVisible(true);
        } else {
            lblErrorEmail.setVisible(false);
        }
//        if (!Emailvalidator.getInstance().isValid(txtEmail.getText())) {
//            valid = false;
//
//            lblErrorEmail.setVisible(true);
//
//        } else {
//            lblErrorEmail.setVisible(false);

       // }
        if (txtPassword.getText().equals("")) {
            valid = false;

            lblErrorPassword.setVisible(true);
        } else {
            lblErrorPassword.setVisible(false);
        }
        if (txtPassword.getPassword().length < 8) {
            valid = false;
            lblErrorPassword.setVisible(true);
        } else {
            lblErrorPassword.setVisible(false);
        }
        if(!Arrays.equals(txtPassword.getPassword(),txtConfirmPassword.getPassword())){
            valid = false;
            lblErrorConfirmPassword.setVisible(true);
            
        }else{
            lblErrorConfirmPassword.setVisible(false);
        }

        return valid;

    
    }

}
