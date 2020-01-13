/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.*;
import controller.*;
import Model.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Matthew
 */
public class Frontend extends javax.swing.JFrame {

    User currentUser;
    
    /**
     * Creates new form Frontend
     */
    public Frontend() {
        initComponents();
    }
    
    private void switchPanelDoctor()
    {
        populateMedicineCombobox();
        populateUserComboboxGeneric(cmbPrescriptionCreatePatient, 'P');
        
        CardLayout card = (CardLayout)mainPanel.getLayout();
        card.show(mainPanel, "DoctorView");
    }
    private void switchPanelAdmin()
    {
        populateUserComboboxGeneric(cmbAdminAccountSelector, 'D');
        
        CardLayout card = (CardLayout)mainPanel.getLayout();
        card.show(mainPanel, "AdminView");
    }
    private void switchPanelSecretary()
    {
        populateUserComboboxGeneric(cmbSecSelectPatient, 'P');
        
        CardLayout card = (CardLayout)mainPanel.getLayout();
        card.show(mainPanel, "SecretaryView");
    }
    private void switchPanelPatient()
    {
        updatePatientDisplay();
        populateUserComboboxGeneric(cbmPatientSelectDoctor, 'D');
        CardLayout card = (CardLayout)mainPanel.getLayout();
        card.show(mainPanel, "PatientView");
    }
    private void switchPanelCreateAdmin()
    {
        CardLayout card = (CardLayout)mainPanel.getLayout();
        card.show(mainPanel, "AdminCreate");

    }
    private void switchPanelBlank()
    {
        CardLayout card = (CardLayout)mainPanel.getLayout();
        card.show(mainPanel, "Blank");
    }
    
    private void switchPanelAccountRequest()
    {
        CardLayout card = (CardLayout)mainPanel.getLayout();
        card.show(mainPanel, "AccountRequest");
    }
    
    private void populateComboboxAdminFeedback()
    {
        DataModel data = DataModel.getInstance();
        
        cmbSelectFeedback.removeAllItems();
        
        User user = (User) cmbAdminAccountSelector.getSelectedItem();
        
        if (!(user instanceof User))
            return;
        
        Doctor doctor = (Doctor) user;
        
        for (Feedback f: doctor.getFeedback())
        {
            cmbSelectFeedback.addItem(f);
        }
    }
    
    private void populateUserComboboxGeneric(JComboBox box, char type)
    {
        DataModel data = DataModel.getInstance();
        
        box.removeAllItems();
        //Add the Doctors
        for (User u: data.getTypedUsers(type))
        {
            box.addItem(u);
        }
    }
    
    private void populateMedicineCombobox()
    {
        DataModel data = DataModel.getInstance();
        
        cmbPrescriptionCreate.removeAllItems();
        
        for (Medicine med: data.getMedicine())
        {
            cmbPrescriptionCreate.addItem(med);
        }
    }
    
    private void doLogin(String userid, String password)
    {
        DataModel data = DataModel.getInstance();
        
        CardLayout card = (CardLayout)mainPanel.getLayout();
        
        this.currentUser = data.processLogin(userid, password);
        if(this.currentUser == null)
        {//If login fails blank panel and abort
            switchPanelBlank();
            return;
        }
                
        if (this.currentUser instanceof Administrator)
            switchPanelAdmin();
        else if (this.currentUser instanceof Doctor)
            switchPanelDoctor();
        else if (this.currentUser instanceof Patient)
            switchPanelPatient();
        else if (this.currentUser instanceof Secretary)
            switchPanelSecretary();
        
        btnLogin.setEnabled(false);
        btnLogout.setEnabled(true);
        btnAdminCreateMenu.setEnabled(false);
        btnRequestAccount.setEnabled(false);
        txtUserId.setText("");
        txtPassword.setText("");
        displayUser(this.currentUser);
    }
    
    private void doLogout()
    {
        CardLayout card = (CardLayout)mainPanel.getLayout();
        switchPanelBlank();
        this.currentUser = null;
        btnLogout.setEnabled(false);
        btnLogin.setEnabled(true);
        btnAdminCreateMenu.setEnabled(true);
        btnRequestAccount.setEnabled(true);
        clearUserDisplay();
    }
    
    private void displayUser(User user)
    {
        txtInfoUserId.setText(user.getId());
        txtInfoFirstName.setText(user.getFirstName());
        txtInfoSurname.setText(user.getSurname());
        txtaInfoAddress.setText(user.getAddress());
    }
    
    private void clearUserDisplay()
    {
        txtInfoUserId.setText("");
        txtInfoFirstName.setText("");
        txtInfoSurname.setText("");
        txtaInfoAddress.setText("");
    }

    private void updateRequestDisplay()
    {
        DataModel data = DataModel.getInstance();
        
        PatientBuilder request = data.getRequest();
        if (request == null)
            return;
        
        txtRequestAproval.setText(request.GetName());
    }
    
    private void updatePatientDisplay()
    {
        Patient patient = (Patient) currentUser;
        Prescription prescription = patient.getPrescription();
        Appointment appointment = patient.getAppointment();
        if (prescription != null)
        {
            Medicine meds = prescription.getMedicine();
            txtPatientDisplayPrescription.setText(meds.getName() + " Dosage: " + prescription.getDosage());
        }
        
        if (appointment != null)
            txtPatientDisplayAppointment.setText(appointment.getDoctor().getSurname() + " At " + appointment.getDateTime());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngrpAdminCreating = new javax.swing.ButtonGroup();
        btnAdminCreateMenu = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        Blank = new javax.swing.JPanel();
        AdminView = new javax.swing.JPanel();
        AdminCreatorInputs = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtaAdminCreatorAddress = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtAdminCreatorPassword = new javax.swing.JPasswordField();
        txtAdminCreatorSname = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtAdminCreatorFname = new javax.swing.JTextField();
        btnAdminCreator = new javax.swing.JButton();
        rdoSecretary = new javax.swing.JRadioButton();
        rdoDoctor = new javax.swing.JRadioButton();
        lblAdminCreateUser = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        AdminAccountViewer = new javax.swing.JPanel();
        cmbAdminAccountSelector = new javax.swing.JComboBox<User>();
        btnRefreshAdminCmb = new javax.swing.JButton();
        AdminMakeFeedback = new javax.swing.JPanel();
        txtAdminFeedbackInRating = new javax.swing.JFormattedTextField();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtaAdminFeedbackInComment = new javax.swing.JTextArea();
        jLabel22 = new javax.swing.JLabel();
        btnAdminFeedbackAdd = new javax.swing.JButton();
        AdminViewFeedback = new javax.swing.JPanel();
        txtAdminRatingOut = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtaAdminFeedbackOutComment = new javax.swing.JTextArea();
        jLabel24 = new javax.swing.JLabel();
        cmbSelectFeedback = new javax.swing.JComboBox<Feedback>();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        DoctorView = new javax.swing.JPanel();
        PrescribeMeds = new javax.swing.JPanel();
        cmbPrescriptionCreate = new javax.swing.JComboBox<Medicine>();
        cmbPrescriptionCreatePatient = new javax.swing.JComboBox<User>();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txtDosageInput = new javax.swing.JTextField();
        btnAddPrescription = new javax.swing.JButton();
        CreateMeds = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtMedicineName = new javax.swing.JTextField();
        btnCreateMedicine = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        SecretaryView = new javax.swing.JPanel();
        PatientAccountAproval = new javax.swing.JPanel();
        btnFetchRequest = new javax.swing.JButton();
        txtRequestAproval = new javax.swing.JTextField();
        btnAproveRequest = new javax.swing.JButton();
        btnRejectRequest = new javax.swing.JButton();
        txtPatientIdOutput = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cmbSecSelectPatient = new javax.swing.JComboBox<>();
        txtAppointmentDateTimeDispaly = new javax.swing.JTextField();
        btnAproveAppointment = new javax.swing.JButton();
        txtAppointmentAproveStatus = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        PatientView = new javax.swing.JPanel();
        PatientCreateAppointment = new javax.swing.JPanel();
        txtAppointmentDateTime = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbmPatientSelectDoctor = new javax.swing.JComboBox<User>();
        jButton1 = new javax.swing.JButton();
        txtAppointmentSetStatus = new javax.swing.JTextField();
        PatientDisplay = new javax.swing.JPanel();
        txtPatientDisplayAppointment = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txtPatientDisplayPrescription = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        AdminCreate = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtAdminAccountIdOutput = new javax.swing.JTextField();
        newAdminInputs = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaAdminAddress = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtAdminPassword = new javax.swing.JPasswordField();
        txtAdminSurname = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtAdminFirstName = new javax.swing.JTextField();
        btnCreateAdminAccount = new javax.swing.JButton();
        AccountRequest = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtRequestFirstName = new javax.swing.JTextField();
        txtRequestAddress = new javax.swing.JTextField();
        btnMakeAccountRequest = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        txtRequestSurname = new javax.swing.JTextField();
        cmbRequestGender = new javax.swing.JComboBox<>();
        txtRequestAge = new javax.swing.JFormattedTextField();
        jLabel28 = new javax.swing.JLabel();
        txtRequestPassword = new javax.swing.JPasswordField();
        jLabel29 = new javax.swing.JLabel();
        UserInfo = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtInfoFirstName = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtInfoSurname = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtaInfoAddress = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        txtInfoUserId = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        LoginInputs = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUserId = new javax.swing.JFormattedTextField();
        txtPassword = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnRequestAccount = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Patient Management System");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnAdminCreateMenu.setText("Create Admin");
        btnAdminCreateMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminCreateMenuActionPerformed(evt);
            }
        });

        mainPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mainPanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout BlankLayout = new javax.swing.GroupLayout(Blank);
        Blank.setLayout(BlankLayout);
        BlankLayout.setHorizontalGroup(
            BlankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 645, Short.MAX_VALUE)
        );
        BlankLayout.setVerticalGroup(
            BlankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 536, Short.MAX_VALUE)
        );

        mainPanel.add(Blank, "Blank");

        AdminCreatorInputs.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtaAdminCreatorAddress.setColumns(20);
        txtaAdminCreatorAddress.setRows(5);
        jScrollPane2.setViewportView(txtaAdminCreatorAddress);

        jLabel12.setText("Address:");

        jLabel13.setText("Password:");

        jLabel14.setText("Surname:");

        jLabel15.setText("First Name:");

        btnAdminCreator.setText("Create New Account");
        btnAdminCreator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminCreatorActionPerformed(evt);
            }
        });

        btngrpAdminCreating.add(rdoSecretary);
        rdoSecretary.setText("Secretary");

        btngrpAdminCreating.add(rdoDoctor);
        rdoDoctor.setText("Doctor");

        lblAdminCreateUser.setText("Userid");

        jLabel20.setText("New User Id:");

        javax.swing.GroupLayout AdminCreatorInputsLayout = new javax.swing.GroupLayout(AdminCreatorInputs);
        AdminCreatorInputs.setLayout(AdminCreatorInputsLayout);
        AdminCreatorInputsLayout.setHorizontalGroup(
            AdminCreatorInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminCreatorInputsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AdminCreatorInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AdminCreatorInputsLayout.createSequentialGroup()
                        .addGroup(AdminCreatorInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AdminCreatorInputsLayout.createSequentialGroup()
                                .addGroup(AdminCreatorInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(AdminCreatorInputsLayout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(jLabel12))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AdminCreatorInputsLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(AdminCreatorInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblAdminCreateUser)
                                            .addGroup(AdminCreatorInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel14)
                                                .addComponent(jLabel13)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(AdminCreatorInputsLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(11, 11, 11)))
                        .addGroup(AdminCreatorInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtAdminCreatorFname)
                            .addComponent(txtAdminCreatorSname)
                            .addComponent(jScrollPane2)
                            .addComponent(txtAdminCreatorPassword))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AdminCreatorInputsLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAdminCreator))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AdminCreatorInputsLayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdoDoctor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdoSecretary)))
                .addContainerGap())
        );
        AdminCreatorInputsLayout.setVerticalGroup(
            AdminCreatorInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminCreatorInputsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AdminCreatorInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtAdminCreatorFname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AdminCreatorInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtAdminCreatorSname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AdminCreatorInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtAdminCreatorPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(AdminCreatorInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(AdminCreatorInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoSecretary)
                    .addComponent(rdoDoctor)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AdminCreatorInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdminCreator)
                    .addComponent(lblAdminCreateUser))
                .addContainerGap())
        );

        AdminAccountViewer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cmbAdminAccountSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAdminAccountSelectorActionPerformed(evt);
            }
        });

        btnRefreshAdminCmb.setText("Refresh");
        btnRefreshAdminCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshAdminCmbActionPerformed(evt);
            }
        });

        AdminMakeFeedback.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        try {
            txtAdminFeedbackInRating.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel21.setText("Rating: ");

        txtaAdminFeedbackInComment.setColumns(20);
        txtaAdminFeedbackInComment.setRows(5);
        jScrollPane4.setViewportView(txtaAdminFeedbackInComment);

        jLabel22.setText("Comment:");

        btnAdminFeedbackAdd.setText("Add Feedback");
        btnAdminFeedbackAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminFeedbackAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AdminMakeFeedbackLayout = new javax.swing.GroupLayout(AdminMakeFeedback);
        AdminMakeFeedback.setLayout(AdminMakeFeedbackLayout);
        AdminMakeFeedbackLayout.setHorizontalGroup(
            AdminMakeFeedbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminMakeFeedbackLayout.createSequentialGroup()
                .addGroup(AdminMakeFeedbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AdminMakeFeedbackLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAdminFeedbackInRating))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AdminMakeFeedbackLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AdminMakeFeedbackLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel22)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnAdminFeedbackAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        AdminMakeFeedbackLayout.setVerticalGroup(
            AdminMakeFeedbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminMakeFeedbackLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AdminMakeFeedbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAdminFeedbackInRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdminFeedbackAdd)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        AdminViewFeedback.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtAdminRatingOut.setEditable(false);

        jLabel23.setText("Rating: ");

        txtaAdminFeedbackOutComment.setEditable(false);
        txtaAdminFeedbackOutComment.setColumns(20);
        txtaAdminFeedbackOutComment.setRows(5);
        jScrollPane5.setViewportView(txtaAdminFeedbackOutComment);

        jLabel24.setText("Comment:");

        cmbSelectFeedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSelectFeedbackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AdminViewFeedbackLayout = new javax.swing.GroupLayout(AdminViewFeedback);
        AdminViewFeedback.setLayout(AdminViewFeedbackLayout);
        AdminViewFeedbackLayout.setHorizontalGroup(
            AdminViewFeedbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminViewFeedbackLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AdminViewFeedbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AdminViewFeedbackLayout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAdminRatingOut))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AdminViewFeedbackLayout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AdminViewFeedbackLayout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cmbSelectFeedback, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        AdminViewFeedbackLayout.setVerticalGroup(
            AdminViewFeedbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminViewFeedbackLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AdminViewFeedbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAdminRatingOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbSelectFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout AdminAccountViewerLayout = new javax.swing.GroupLayout(AdminAccountViewer);
        AdminAccountViewer.setLayout(AdminAccountViewerLayout);
        AdminAccountViewerLayout.setHorizontalGroup(
            AdminAccountViewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminAccountViewerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AdminAccountViewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AdminAccountViewerLayout.createSequentialGroup()
                        .addComponent(AdminMakeFeedback, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AdminViewFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmbAdminAccountSelector, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRefreshAdminCmb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        AdminAccountViewerLayout.setVerticalGroup(
            AdminAccountViewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminAccountViewerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRefreshAdminCmb)
                .addGap(3, 3, 3)
                .addComponent(cmbAdminAccountSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AdminAccountViewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AdminMakeFeedback, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AdminViewFeedback, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel35.setText("Create Users:");

        jLabel36.setText("View/Add Feedback:");

        javax.swing.GroupLayout AdminViewLayout = new javax.swing.GroupLayout(AdminView);
        AdminView.setLayout(AdminViewLayout);
        AdminViewLayout.setHorizontalGroup(
            AdminViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminViewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AdminViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AdminCreatorInputs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AdminViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AdminViewLayout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(AdminAccountViewer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        AdminViewLayout.setVerticalGroup(
            AdminViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminViewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AdminViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AdminViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AdminViewLayout.createSequentialGroup()
                        .addComponent(AdminCreatorInputs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(235, Short.MAX_VALUE))
                    .addComponent(AdminAccountViewer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        mainPanel.add(AdminView, "AdminView");

        PrescribeMeds.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel30.setText("Medicine: ");

        jLabel31.setText("Patient: ");

        jLabel32.setText("Dosage (Floating point number) : ");

        btnAddPrescription.setText("Add Prescription");
        btnAddPrescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPrescriptionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PrescribeMedsLayout = new javax.swing.GroupLayout(PrescribeMeds);
        PrescribeMeds.setLayout(PrescribeMedsLayout);
        PrescribeMedsLayout.setHorizontalGroup(
            PrescribeMedsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PrescribeMedsLayout.createSequentialGroup()
                .addGroup(PrescribeMedsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PrescribeMedsLayout.createSequentialGroup()
                        .addGroup(PrescribeMedsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PrescribeMedsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(PrescribeMedsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(PrescribeMedsLayout.createSequentialGroup()
                                        .addComponent(jLabel31)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbPrescriptionCreatePatient, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(PrescribeMedsLayout.createSequentialGroup()
                                        .addComponent(jLabel30)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbPrescriptionCreate, 0, 178, Short.MAX_VALUE))))
                            .addGroup(PrescribeMedsLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDosageInput, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addComponent(btnAddPrescription, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PrescribeMedsLayout.setVerticalGroup(
            PrescribeMedsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PrescribeMedsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PrescribeMedsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(cmbPrescriptionCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PrescribeMedsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(cmbPrescriptionCreatePatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PrescribeMedsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(txtDosageInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAddPrescription)
                .addContainerGap(176, Short.MAX_VALUE))
        );

        CreateMeds.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setText("Medicine Name: ");

        btnCreateMedicine.setText("Create Medicine");
        btnCreateMedicine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateMedicineActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CreateMedsLayout = new javax.swing.GroupLayout(CreateMeds);
        CreateMeds.setLayout(CreateMedsLayout);
        CreateMedsLayout.setHorizontalGroup(
            CreateMedsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreateMedsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CreateMedsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCreateMedicine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(CreateMedsLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMedicineName)))
                .addContainerGap())
        );
        CreateMedsLayout.setVerticalGroup(
            CreateMedsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreateMedsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(CreateMedsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMedicineName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCreateMedicine))
        );

        jLabel37.setText("Create Prescription:");

        javax.swing.GroupLayout DoctorViewLayout = new javax.swing.GroupLayout(DoctorView);
        DoctorView.setLayout(DoctorViewLayout);
        DoctorViewLayout.setHorizontalGroup(
            DoctorViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DoctorViewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DoctorViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DoctorViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(CreateMeds, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PrescribeMeds, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel37))
                .addContainerGap(380, Short.MAX_VALUE))
        );
        DoctorViewLayout.setVerticalGroup(
            DoctorViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DoctorViewLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PrescribeMeds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CreateMeds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );

        mainPanel.add(DoctorView, "DoctorView");

        PatientAccountAproval.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnFetchRequest.setText("Get Request");
        btnFetchRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFetchRequestActionPerformed(evt);
            }
        });

        txtRequestAproval.setEditable(false);

        btnAproveRequest.setText("Aprove");
        btnAproveRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAproveRequestActionPerformed(evt);
            }
        });

        btnRejectRequest.setText("Reject");
        btnRejectRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRejectRequestActionPerformed(evt);
            }
        });

        txtPatientIdOutput.setEditable(false);

        jLabel5.setText("Added as: ");

        javax.swing.GroupLayout PatientAccountAprovalLayout = new javax.swing.GroupLayout(PatientAccountAproval);
        PatientAccountAproval.setLayout(PatientAccountAprovalLayout);
        PatientAccountAprovalLayout.setHorizontalGroup(
            PatientAccountAprovalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientAccountAprovalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PatientAccountAprovalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRequestAproval, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnFetchRequest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PatientAccountAprovalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRejectRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAproveRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PatientAccountAprovalLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPatientIdOutput)))
                .addContainerGap())
        );
        PatientAccountAprovalLayout.setVerticalGroup(
            PatientAccountAprovalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientAccountAprovalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnFetchRequest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtRequestAproval, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PatientAccountAprovalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAproveRequest)
                    .addComponent(btnRejectRequest))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PatientAccountAprovalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPatientIdOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cmbSecSelectPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSecSelectPatientActionPerformed(evt);
            }
        });

        txtAppointmentDateTimeDispaly.setEditable(false);

        btnAproveAppointment.setText("Approve");
        btnAproveAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAproveAppointmentActionPerformed(evt);
            }
        });

        txtAppointmentAproveStatus.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbSecSelectPatient, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAppointmentDateTimeDispaly)
                    .addComponent(btnAproveAppointment, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(txtAppointmentAproveStatus))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmbSecSelectPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtAppointmentDateTimeDispaly, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAproveAppointment)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAppointmentAproveStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jLabel38.setText("Process patient account requests:");

        jLabel39.setText("Aprove Appointment Requests:");

        javax.swing.GroupLayout SecretaryViewLayout = new javax.swing.GroupLayout(SecretaryView);
        SecretaryView.setLayout(SecretaryViewLayout);
        SecretaryViewLayout.setHorizontalGroup(
            SecretaryViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SecretaryViewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SecretaryViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PatientAccountAproval, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SecretaryViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(232, Short.MAX_VALUE))
        );
        SecretaryViewLayout.setVerticalGroup(
            SecretaryViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SecretaryViewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SecretaryViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(SecretaryViewLayout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SecretaryViewLayout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PatientAccountAproval, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(365, Short.MAX_VALUE))
        );

        mainPanel.add(SecretaryView, "SecretaryView");

        PatientCreateAppointment.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setText("Data & Time: ");

        jButton1.setText("Create Appointment");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtAppointmentSetStatus.setEditable(false);

        javax.swing.GroupLayout PatientCreateAppointmentLayout = new javax.swing.GroupLayout(PatientCreateAppointment);
        PatientCreateAppointment.setLayout(PatientCreateAppointmentLayout);
        PatientCreateAppointmentLayout.setHorizontalGroup(
            PatientCreateAppointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientCreateAppointmentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PatientCreateAppointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAppointmentSetStatus)
                    .addGroup(PatientCreateAppointmentLayout.createSequentialGroup()
                        .addGroup(PatientCreateAppointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbmPatientSelectDoctor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(PatientCreateAppointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PatientCreateAppointmentLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PatientCreateAppointmentLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(txtAppointmentDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PatientCreateAppointmentLayout.setVerticalGroup(
            PatientCreateAppointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientCreateAppointmentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PatientCreateAppointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAppointmentDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PatientCreateAppointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbmPatientSelectDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAppointmentSetStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PatientDisplay.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtPatientDisplayAppointment.setEditable(false);

        jLabel33.setText("Appointment with doctor:");

        jLabel34.setText("Prescription: ");

        txtPatientDisplayPrescription.setEditable(false);

        javax.swing.GroupLayout PatientDisplayLayout = new javax.swing.GroupLayout(PatientDisplay);
        PatientDisplay.setLayout(PatientDisplayLayout);
        PatientDisplayLayout.setHorizontalGroup(
            PatientDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientDisplayLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PatientDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPatientDisplayAppointment)
                    .addGroup(PatientDisplayLayout.createSequentialGroup()
                        .addGroup(PatientDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33)
                            .addComponent(jLabel34))
                        .addGap(0, 90, Short.MAX_VALUE))
                    .addComponent(txtPatientDisplayPrescription))
                .addContainerGap())
        );
        PatientDisplayLayout.setVerticalGroup(
            PatientDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientDisplayLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPatientDisplayAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPatientDisplayPrescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel40.setText("Request Appointment:");

        jLabel41.setText("View Appointment:");

        javax.swing.GroupLayout PatientViewLayout = new javax.swing.GroupLayout(PatientView);
        PatientView.setLayout(PatientViewLayout);
        PatientViewLayout.setHorizontalGroup(
            PatientViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientViewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PatientViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PatientDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PatientCreateAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40)
                    .addComponent(jLabel41))
                .addContainerGap(399, Short.MAX_VALUE))
        );
        PatientViewLayout.setVerticalGroup(
            PatientViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40)
                .addGap(7, 7, 7)
                .addComponent(PatientCreateAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PatientDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(257, Short.MAX_VALUE))
        );

        mainPanel.add(PatientView, "PatientView");

        jLabel9.setText("Account Id:");

        txtAdminAccountIdOutput.setEditable(false);

        newAdminInputs.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtaAdminAddress.setColumns(20);
        txtaAdminAddress.setRows(5);
        jScrollPane1.setViewportView(txtaAdminAddress);

        jLabel8.setText("Address:");

        jLabel11.setText("Password:");

        jLabel10.setText("Surname:");

        jLabel7.setText("First Name:");

        btnCreateAdminAccount.setText("Create Admin Account");
        btnCreateAdminAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateAdminAccountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout newAdminInputsLayout = new javax.swing.GroupLayout(newAdminInputs);
        newAdminInputs.setLayout(newAdminInputsLayout);
        newAdminInputsLayout.setHorizontalGroup(
            newAdminInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newAdminInputsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newAdminInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newAdminInputsLayout.createSequentialGroup()
                        .addGroup(newAdminInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(newAdminInputsLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newAdminInputsLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(newAdminInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(newAdminInputsLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(11, 11, 11)))
                .addGroup(newAdminInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtAdminFirstName)
                    .addComponent(txtAdminSurname)
                    .addComponent(jScrollPane1)
                    .addComponent(txtAdminPassword))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newAdminInputsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCreateAdminAccount)
                .addContainerGap())
        );
        newAdminInputsLayout.setVerticalGroup(
            newAdminInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newAdminInputsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newAdminInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtAdminFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newAdminInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtAdminSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newAdminInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtAdminPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(newAdminInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCreateAdminAccount)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout AdminCreateLayout = new javax.swing.GroupLayout(AdminCreate);
        AdminCreate.setLayout(AdminCreateLayout);
        AdminCreateLayout.setHorizontalGroup(
            AdminCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminCreateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newAdminInputs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAdminAccountIdOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(236, Short.MAX_VALUE))
        );
        AdminCreateLayout.setVerticalGroup(
            AdminCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminCreateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AdminCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AdminCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txtAdminAccountIdOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(newAdminInputs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(284, Short.MAX_VALUE))
        );

        mainPanel.add(AdminCreate, "AdminCreate");

        jLabel25.setText("first Name: ");

        jLabel26.setText("Address: ");

        btnMakeAccountRequest.setText("Request");
        btnMakeAccountRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMakeAccountRequestActionPerformed(evt);
            }
        });

        jLabel27.setText("Surname: ");

        cmbRequestGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        try {
            txtRequestAge.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel28.setText("Age: ");

        jLabel29.setText("Password:");

        javax.swing.GroupLayout AccountRequestLayout = new javax.swing.GroupLayout(AccountRequest);
        AccountRequest.setLayout(AccountRequestLayout);
        AccountRequestLayout.setHorizontalGroup(
            AccountRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AccountRequestLayout.createSequentialGroup()
                .addGroup(AccountRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AccountRequestLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(AccountRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel26)))
                    .addGroup(AccountRequestLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AccountRequestLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(AccountRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AccountRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbRequestGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(AccountRequestLayout.createSequentialGroup()
                        .addGroup(AccountRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtRequestPassword, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRequestAge, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                            .addComponent(txtRequestAddress, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRequestFirstName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRequestSurname, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMakeAccountRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(404, Short.MAX_VALUE))
        );
        AccountRequestLayout.setVerticalGroup(
            AccountRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AccountRequestLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AccountRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnMakeAccountRequest, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AccountRequestLayout.createSequentialGroup()
                        .addGroup(AccountRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(txtRequestFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AccountRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRequestSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AccountRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRequestAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbRequestGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AccountRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRequestAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AccountRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRequestPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addContainerGap(367, Short.MAX_VALUE))
        );

        mainPanel.add(AccountRequest, "AccountRequest");

        UserInfo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setText("Your Information:");

        txtInfoFirstName.setEditable(false);

        jLabel16.setText("First Name:");

        jLabel17.setText("Surname:");

        txtInfoSurname.setEditable(false);

        txtaInfoAddress.setEditable(false);
        txtaInfoAddress.setColumns(20);
        txtaInfoAddress.setRows(5);
        jScrollPane3.setViewportView(txtaInfoAddress);

        jLabel18.setText("Address:");

        txtInfoUserId.setEditable(false);

        jLabel19.setText("User ID:");

        javax.swing.GroupLayout UserInfoLayout = new javax.swing.GroupLayout(UserInfo);
        UserInfo.setLayout(UserInfoLayout);
        UserInfoLayout.setHorizontalGroup(
            UserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(UserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UserInfoLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UserInfoLayout.createSequentialGroup()
                        .addGroup(UserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addGroup(UserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtInfoUserId)
                            .addComponent(txtInfoFirstName)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtInfoSurname, javax.swing.GroupLayout.Alignment.TRAILING)))))
        );
        UserInfoLayout.setVerticalGroup(
            UserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(UserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInfoUserId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(11, 11, 11)
                .addGroup(UserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInfoFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(UserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtInfoSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(UserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        LoginInputs.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("User ID:");

        jLabel2.setText("Password:");

        try {
            txtUserId.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("U####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnLogout.setText("Logout");
        btnLogout.setEnabled(false);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LoginInputsLayout = new javax.swing.GroupLayout(LoginInputs);
        LoginInputs.setLayout(LoginInputsLayout);
        LoginInputsLayout.setHorizontalGroup(
            LoginInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginInputsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LoginInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(LoginInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPassword)
                    .addComponent(txtUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(LoginInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LoginInputsLayout.setVerticalGroup(
            LoginInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginInputsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LoginInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtUserId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LoginInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(LoginInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPassword)
                        .addComponent(btnLogout)))
                .addContainerGap())
        );

        btnRequestAccount.setText("Request Account");
        btnRequestAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestAccountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LoginInputs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRequestAccount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdminCreateMenu))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UserInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LoginInputs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAdminCreateMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRequestAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(UserInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        this.doLogin(txtUserId.getText(), txtPassword.getText());
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnAdminCreateMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminCreateMenuActionPerformed
        switchPanelCreateAdmin();
    }//GEN-LAST:event_btnAdminCreateMenuActionPerformed

    private void btnCreateAdminAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateAdminAccountActionPerformed
        DataModel data = DataModel.getInstance();
        
        AdminBuilder builder = new AdminBuilder();
        
        builder.setUserNum(data.getHighestUserNum('A')+1);
        
        builder.setFirstName(txtAdminFirstName.getText());
        builder.setSurname(txtAdminSurname.getText());
        builder.setAddress(txtaAdminAddress.getText());
        builder.setPassword(new String(txtAdminPassword.getPassword()));
        
        Administrator admin = builder.build();
        
        if(data.addUser(admin))
        {
            txtAdminAccountIdOutput.setText(admin.getId());
            for (Component C: newAdminInputs.getComponents())
            {
                if (C instanceof JTextField || C instanceof JTextArea || C instanceof JPasswordField){
                    ((JTextComponent) C).setText("");
                }
            }
            txtaAdminAddress.setText("");//for some reason the above code misses the text area.
        }
    }//GEN-LAST:event_btnCreateAdminAccountActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        this.doLogout();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnAdminCreatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminCreatorActionPerformed
        DataModel data = DataModel.getInstance();
        
        IBuilder builder;
        
        if (rdoDoctor.isSelected())
        {
            builder = new DoctorBuilder();
        }
        else if (rdoSecretary.isSelected())
        {
            builder = new SecretaryBuilder();
        }
        else
            //if we get here no account type was selected. Exit for safty
            return;
        
        builder.setUserNum(data.getHighestUserNum(builder.getType())+1);
        
        builder.setFirstName(txtAdminCreatorFname.getText());
        builder.setSurname(txtAdminCreatorSname.getText());
        builder.setAddress(txtaAdminCreatorAddress.getText());
        builder.setPassword(new String(txtAdminCreatorPassword.getPassword()));

        User user = builder.build();
        
        if(data.addUser(user))
        {
            lblAdminCreateUser.setText(user.getId());
            for (Component C: AdminCreatorInputs.getComponents())
            {
                if (C instanceof JTextField || C instanceof JTextArea || C instanceof JPasswordField){
                    ((JTextComponent) C).setText("");
                }
            }
            txtaAdminCreatorAddress.setText("");//for some reason the above code misses the text area.
        }
    }//GEN-LAST:event_btnAdminCreatorActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        DataModel data = DataModel.getInstance();
        data.saveData();
    }//GEN-LAST:event_formWindowClosing

    private void btnRefreshAdminCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshAdminCmbActionPerformed
        populateUserComboboxGeneric(cmbAdminAccountSelector, 'D');
    }//GEN-LAST:event_btnRefreshAdminCmbActionPerformed

    private void btnAdminFeedbackAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminFeedbackAddActionPerformed
        User user = (User)cmbAdminAccountSelector.getSelectedItem();
        
        if (!(user instanceof Doctor))
            return;//Only Doctors can have feedback
        
        //we can now cast user to Doctor in safty
        Doctor doctor = (Doctor)user;
        
        Integer rating = Integer.parseInt(txtAdminFeedbackInRating.getText());
        String comment = txtaAdminFeedbackInComment.getText();
        
        Feedback feedback = new Feedback(rating, comment);
        
        doctor.addFeedback(feedback);
    }//GEN-LAST:event_btnAdminFeedbackAddActionPerformed

    private void cmbAdminAccountSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAdminAccountSelectorActionPerformed
        populateComboboxAdminFeedback();
    }//GEN-LAST:event_cmbAdminAccountSelectorActionPerformed

    private void cmbSelectFeedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSelectFeedbackActionPerformed
        Feedback feedback = (Feedback) cmbSelectFeedback.getSelectedItem();
        
        txtAdminRatingOut.setText(feedback.getRating().toString());
        txtaAdminFeedbackOutComment.setText(feedback.getComment());
    }//GEN-LAST:event_cmbSelectFeedbackActionPerformed

    private void btnRequestAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestAccountActionPerformed
        switchPanelAccountRequest();
    }//GEN-LAST:event_btnRequestAccountActionPerformed

    private void btnMakeAccountRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMakeAccountRequestActionPerformed
        PatientBuilder request = new PatientBuilder();
        
        request.setFirstName(txtRequestFirstName.getText());
        request.setSurname(txtRequestSurname.getText());
        request.setAddress(txtRequestAddress.getText());
        request.setGender((String)cmbRequestGender.getSelectedItem());
        request.setAge(Integer.parseInt(txtRequestAge.getText()));//Its safe for us to do this beucause txtrequestAge is restricted to a single number character
        request.setPassword(new String(txtRequestPassword.getPassword()));
        
        DataModel data = DataModel.getInstance();
        data.addAccountRequest(request);
    }//GEN-LAST:event_btnMakeAccountRequestActionPerformed

    private void btnFetchRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFetchRequestActionPerformed
        updateRequestDisplay();
    }//GEN-LAST:event_btnFetchRequestActionPerformed

    private void btnAproveRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAproveRequestActionPerformed
        DataModel data = DataModel.getInstance();
        
        PatientBuilder request = data.popRequest();
        if (request == null)
            return;
        
        request.setUserNum(data.getHighestUserNum('P')+1);
        
        Patient patient = request.build();
        
        data.addUser(patient);
        
        txtPatientIdOutput.setText(patient.getId());
        
        //Now that we have added the new user. update the display
        updateRequestDisplay();
    }//GEN-LAST:event_btnAproveRequestActionPerformed

    private void btnRejectRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRejectRequestActionPerformed
        DataModel data = DataModel.getInstance();
        
        if(data.popRequest() == null)
            return;
        
        //Now that we have removed the offending request. update the display
        updateRequestDisplay();
    }//GEN-LAST:event_btnRejectRequestActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Patient patient = (Patient)this.currentUser;
        
        Appointment appointment = new Appointment((Doctor)cbmPatientSelectDoctor.getSelectedItem(), txtAppointmentDateTime.getText());
        
        patient.setAppointment(appointment);
        txtAppointmentSetStatus.setText("Appointment Set!");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmbSecSelectPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSecSelectPatientActionPerformed
        Patient patient = (Patient)cmbSecSelectPatient.getSelectedItem();
        Appointment appointment = patient.getAppointment();
        if (appointment == null)
            return;
        
        txtAppointmentDateTimeDispaly.setText(appointment.getDateTime());
    }//GEN-LAST:event_cmbSecSelectPatientActionPerformed

    private void btnAproveAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAproveAppointmentActionPerformed
        Patient patient = (Patient)cmbSecSelectPatient.getSelectedItem();
        Appointment appointment = patient.getAppointment();
        appointment.setAccepted(true);
        txtAppointmentAproveStatus.setText("Approved!");
    }//GEN-LAST:event_btnAproveAppointmentActionPerformed

    private void btnCreateMedicineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateMedicineActionPerformed
        Medicine med = new Medicine(txtMedicineName.getText());
        
        DataModel data = DataModel.getInstance();
        
        data.addMedicine(med);
        populateMedicineCombobox();
    }//GEN-LAST:event_btnCreateMedicineActionPerformed

    private void btnAddPrescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPrescriptionActionPerformed
        Medicine meds = (Medicine)cmbPrescriptionCreate.getSelectedItem();
        if (meds == null)
            return;//No valid Medicine. Abort.
        Float dosage;
        try{
            dosage = Float.parseFloat(txtDosageInput.getText());
        }catch (NumberFormatException e)
        {
            return;//dosage was invalid. Abort.
        }
        
        Prescription prescription = new Prescription(meds, dosage);
        
        Patient patient = (Patient) cmbPrescriptionCreatePatient.getSelectedItem();
        
        patient.setPrescription(prescription);
    }//GEN-LAST:event_btnAddPrescriptionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frontend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frontend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frontend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frontend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //Always load data on startup.
        DataModel data = DataModel.getInstance();
        data.loadData();
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frontend().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AccountRequest;
    private javax.swing.JPanel AdminAccountViewer;
    private javax.swing.JPanel AdminCreate;
    private javax.swing.JPanel AdminCreatorInputs;
    private javax.swing.JPanel AdminMakeFeedback;
    private javax.swing.JPanel AdminView;
    private javax.swing.JPanel AdminViewFeedback;
    private javax.swing.JPanel Blank;
    private javax.swing.JPanel CreateMeds;
    private javax.swing.JPanel DoctorView;
    private javax.swing.JPanel LoginInputs;
    private javax.swing.JPanel PatientAccountAproval;
    private javax.swing.JPanel PatientCreateAppointment;
    private javax.swing.JPanel PatientDisplay;
    private javax.swing.JPanel PatientView;
    private javax.swing.JPanel PrescribeMeds;
    private javax.swing.JPanel SecretaryView;
    private javax.swing.JPanel UserInfo;
    private javax.swing.JButton btnAddPrescription;
    private javax.swing.JButton btnAdminCreateMenu;
    private javax.swing.JButton btnAdminCreator;
    private javax.swing.JButton btnAdminFeedbackAdd;
    private javax.swing.JButton btnAproveAppointment;
    private javax.swing.JButton btnAproveRequest;
    private javax.swing.JButton btnCreateAdminAccount;
    private javax.swing.JButton btnCreateMedicine;
    private javax.swing.JButton btnFetchRequest;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMakeAccountRequest;
    private javax.swing.JButton btnRefreshAdminCmb;
    private javax.swing.JButton btnRejectRequest;
    private javax.swing.JButton btnRequestAccount;
    private javax.swing.ButtonGroup btngrpAdminCreating;
    /*
    private javax.swing.JComboBox<String> cbmPatientSelectDoctor;
    */
    private javax.swing.JComboBox<User> cbmPatientSelectDoctor;
    /*
    private javax.swing.JComboBox<String> cmbAdminAccountSelector;
    Since we are currently in a comment I'd like to take the
    oppertunity to say sorry for what I'm doing here. I know
    that this is a stupid hack but netbeans litteraly wont let
    me edit the declaration.
    */
    private javax.swing.JComboBox<User> cmbAdminAccountSelector;
    /*
    private javax.swing.JComboBox<String> cmbPrescriptionCreate;
    */
    private javax.swing.JComboBox<Medicine> cmbPrescriptionCreate;
    /*
    private javax.swing.JComboBox<String> cmbPrescriptionCreatePatient;
    */
    private javax.swing.JComboBox<User> cmbPrescriptionCreatePatient;
    private javax.swing.JComboBox<String> cmbRequestGender;
    private javax.swing.JComboBox<String> cmbSecSelectPatient;
    /*
    private javax.swing.JComboBox<String> cmbSelectFeedback;
    */
    private javax.swing.JComboBox<Feedback> cmbSelectFeedback;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblAdminCreateUser;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel newAdminInputs;
    private javax.swing.JRadioButton rdoDoctor;
    private javax.swing.JRadioButton rdoSecretary;
    private javax.swing.JTextField txtAdminAccountIdOutput;
    private javax.swing.JTextField txtAdminCreatorFname;
    private javax.swing.JPasswordField txtAdminCreatorPassword;
    private javax.swing.JTextField txtAdminCreatorSname;
    private javax.swing.JFormattedTextField txtAdminFeedbackInRating;
    private javax.swing.JTextField txtAdminFirstName;
    private javax.swing.JPasswordField txtAdminPassword;
    private javax.swing.JTextField txtAdminRatingOut;
    private javax.swing.JTextField txtAdminSurname;
    private javax.swing.JTextField txtAppointmentAproveStatus;
    private javax.swing.JTextField txtAppointmentDateTime;
    private javax.swing.JTextField txtAppointmentDateTimeDispaly;
    private javax.swing.JTextField txtAppointmentSetStatus;
    private javax.swing.JTextField txtDosageInput;
    private javax.swing.JTextField txtInfoFirstName;
    private javax.swing.JTextField txtInfoSurname;
    private javax.swing.JTextField txtInfoUserId;
    private javax.swing.JTextField txtMedicineName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPatientDisplayAppointment;
    private javax.swing.JTextField txtPatientDisplayPrescription;
    private javax.swing.JTextField txtPatientIdOutput;
    private javax.swing.JTextField txtRequestAddress;
    private javax.swing.JFormattedTextField txtRequestAge;
    private javax.swing.JTextField txtRequestAproval;
    private javax.swing.JTextField txtRequestFirstName;
    private javax.swing.JPasswordField txtRequestPassword;
    private javax.swing.JTextField txtRequestSurname;
    private javax.swing.JFormattedTextField txtUserId;
    private javax.swing.JTextArea txtaAdminAddress;
    private javax.swing.JTextArea txtaAdminCreatorAddress;
    private javax.swing.JTextArea txtaAdminFeedbackInComment;
    private javax.swing.JTextArea txtaAdminFeedbackOutComment;
    private javax.swing.JTextArea txtaInfoAddress;
    // End of variables declaration//GEN-END:variables
}
