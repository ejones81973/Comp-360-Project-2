java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PaymentSystemGUI extends JFrame {
    private final JTextField tfFirst = new JTextField(12);
    private final JTextField tfLast = new JTextField(12);
    private final JTextField tfSsn = new JTextField(12);
    private final JComboBox<String> cbType = new JComboBox<>(new String[] {
            "New Developer", "Junior Developer", "Senior Developer"});
    private final JCheckBox chProfit = new JCheckBox("Good product profit?");
    private final JTextArea taOutput = new JTextArea(10, 30);

    public PaymentSystemGUI() {
        super("Hua Dong Payment System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel p = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(4,4,4,4);
        c.gridx = 0; c.gridy = 0; p.add(new JLabel("First Name:"), c);
        c.gridx = 1; p.add(tfFirst, c);
        c.gridx = 0; c.gridy = 1; p.add(new JLabel("Last Name:"), c);
        c.gridx = 1; p.add(tfLast, c);
        c.gridx = 0; c.gridy = 2; p.add(new JLabel("SSN:"), c);
        c.gridx = 1; p.add(tfSsn, c);
        c.gridx = 0; c.gridy = 3; p.add(new JLabel("Type:"), c);
        c.gridx = 1; p.add(cbType, c);
        c.gridx = 0; c.gridy = 4; p.add(chProfit, c);
        JButton btnCalc = new JButton("Calculate Annual Payment");
        btnCalc.addActionListener(this::onCalculate);
        c.gridx = 0; c.gridy = 5; c.gridwidth = 2; p.add(btnCalc, c);
        c.gridx = 0; c.gridy = 6; c.gridwidth = 2; p.add(new JScrollPane(taOutput), c);

        taOutput.setEditable(false);
        setContentPane(p);
        pack();
        setLocationRelativeTo(null);
    }

    private void onCalculate(ActionEvent e) {
        String first = tfFirst.getText().trim();
        String last = tfLast.getText().trim();
        String ssn = tfSsn.getText().trim();
        if (first.isEmpty() || last.isEmpty() || ssn.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return;
        }

        String type = (String) cbType.getSelectedItem();
        boolean profit = chProfit.isSelected();

        Developer dev;
        switch (type) {
            case "Junior Developer":
                dev = new JuniorDeveloper(first, last, ssn);
                // overloaded call example (double) already used in constructor
                break;
            case "Senior Developer":
                dev = new SeniorDeveloper(first, last, ssn);
                break;
            default:
                dev = new NewDeveloper(first, last, ssn);
        }

        // static polymorphism demonstration: compile-time overload selection
        // (we call int overload here to show difference where applicable)
        dev.setMonthlySalary((int) dev.getMonthlySalary());

        // dynamic polymorphism: runtime method selection
        String details = dev.getDetails(profit);
        taOutput.setText(details);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PaymentSystemGUI().setVisible(true));
    }
}
