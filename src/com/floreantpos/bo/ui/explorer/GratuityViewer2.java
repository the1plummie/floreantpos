package com.floreantpos.bo.ui.explorer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;

import com.floreantpos.POSConstants;
import com.floreantpos.PosException;
import com.floreantpos.main.Application;
import com.floreantpos.model.ActionHistory;
import com.floreantpos.model.Gratuity;
import com.floreantpos.model.User;
import com.floreantpos.model.dao.ActionHistoryDAO;
import com.floreantpos.model.dao.GratuityDAO;
import com.floreantpos.model.dao.UserDAO;
import com.floreantpos.swing.ListComboBoxModel;
import com.floreantpos.swing.TransparentPanel;
import com.floreantpos.ui.dialog.POSMessageDialog;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

/**
 * Created by IntelliJ IDEA.
 * User: mshahriar
 * Date: Feb 19, 2007
 * Time: 12:06:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class GratuityViewer2 extends TransparentPanel implements ActionListener {
    private JComboBox cbUsers;
    private JButton btnGo;
    private JLabel lblUserId;
    private JLabel lblUserName;
    private JLabel lblTotalGratuity;
    private JTable tableGratuityViewer;
    private JButton btnPay;
    private JPanel contentPane;

    private GratuityTableModel gratuityTableModel;

    /**
     * Creates new form GratuityViewer
     */
    public GratuityViewer2() {
        UserDAO userDAO = new UserDAO();
        List<User> users = userDAO.findAll();

        cbUsers.setModel(new ListComboBoxModel(users));
        tableGratuityViewer.setModel(gratuityTableModel = new GratuityTableModel(null));

        btnGo.addActionListener(this);
        btnPay.setEnabled(false);
        btnPay.addActionListener(this);

        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setLayout(new BorderLayout());
        add(contentPane);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        contentPane = new JPanel();
        contentPane.setLayout(new GridLayoutManager(9, 3, new Insets(0, 0, 0, 0), -1, -1));
        final JLabel label1 = new JLabel();
        label1.setText(com.floreantpos.POSConstants.SELECT_USER + POSConstants.COLON);
        contentPane.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        cbUsers = new JComboBox();
        contentPane.add(cbUsers, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(406, 22), null, 0, false));
        btnGo = new JButton();
        btnGo.setText(com.floreantpos.POSConstants.GO);
        contentPane.add(btnGo, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JSeparator separator1 = new JSeparator();
        contentPane.add(separator1, new GridConstraints(1, 0, 1, 3, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText(com.floreantpos.POSConstants.USER_ID + POSConstants.COLON);
        contentPane.add(label2, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lblUserId = new JLabel();
        contentPane.add(lblUserId, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(406, 14), null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText(com.floreantpos.POSConstants.USER_NAME + POSConstants.COLON);
        contentPane.add(label3, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lblUserName = new JLabel();
        contentPane.add(lblUserName, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(406, 14), null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText(com.floreantpos.POSConstants.TOTAL_GRATUITY + POSConstants.COLON);
        contentPane.add(label4, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lblTotalGratuity = new JLabel();
        contentPane.add(lblTotalGratuity, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(406, 14), null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText(com.floreantpos.POSConstants.DETAILS);
        contentPane.add(label5, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JSeparator separator2 = new JSeparator();
        contentPane.add(separator2, new GridConstraints(5, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        contentPane.add(scrollPane1, new GridConstraints(6, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        tableGratuityViewer = new JTable();
        scrollPane1.setViewportView(tableGratuityViewer);
        final JSeparator separator3 = new JSeparator();
        contentPane.add(separator3, new GridConstraints(7, 0, 1, 3, GridConstraints.ANCHOR_SOUTH, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnPay = new JButton();
        btnPay.setText(com.floreantpos.POSConstants.PAY);
        contentPane.add(btnPay, new GridConstraints(8, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }

    private class GratuityTableModel extends ListTableModel {

        public GratuityTableModel(List<Gratuity> gratuities) {
            super(new String[]{com.floreantpos.POSConstants.FIRST_NAME, com.floreantpos.POSConstants.LAST_NAME, com.floreantpos.POSConstants.TICKET_ID, com.floreantpos.POSConstants.AMOUNT}, gratuities);
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            Gratuity gratuity = (Gratuity) rows.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return gratuity.getOwner().getFirstName();

                case 1:
                    return gratuity.getOwner().getLastName();

                case 2:
                    return gratuity.getTicket().getId();

                case 3:
                    return Application.formatNumber(gratuity.getAmount());
            }
            return null;
        }

    }

    public void showGratuity(User user) {
        GratuityDAO dao = new GratuityDAO();
        List<Gratuity> gratuities = dao.findByUser(user);

        double totalGratuity = 0;
        for (Gratuity gratuity : gratuities) {
            totalGratuity += gratuity.getAmount();
        }
        lblUserId.setText(String.valueOf(user.getUserId()));
        lblUserName.setText(user.getFirstName() + " " + user.getLastName()); //$NON-NLS-1$
        lblTotalGratuity.setText(Application.formatNumber(totalGratuity));
        gratuityTableModel.setRows(gratuities);

        if (gratuities.size() > 0) {
            btnPay.setEnabled(true);
        } else {
            btnPay.setEnabled(false);
        }
    }

    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if (com.floreantpos.POSConstants.GO.equalsIgnoreCase(actionCommand)) {
            User user = (User) cbUsers.getSelectedItem();
            if (user != null) {
                showGratuity(user);
            }
        }

        if (com.floreantpos.POSConstants.PAY.equalsIgnoreCase(actionCommand)) {
            try {
                List rows = gratuityTableModel.getRows();
                if (rows != null) {
                    new GratuityDAO().payGratuities(rows);
                }
                btnPay.setEnabled(false);

//				PAY TIPS ACTION
                String actionMessage = com.floreantpos.POSConstants.PAY_TIPS;
                ActionHistoryDAO.getInstance().saveHistory(Application.getCurrentUser(), ActionHistory.PAY_TIPS, actionMessage);

            } catch (PosException ex) {
                POSMessageDialog.showError(contentPane, ex.getMessage(), ex);
            }
        }
    }

}
