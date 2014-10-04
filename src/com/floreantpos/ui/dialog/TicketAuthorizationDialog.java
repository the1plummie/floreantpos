package com.floreantpos.ui.dialog;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jdesktop.swingx.JXTable;

import com.floreantpos.actions.AuthorizeTicketAction;
import com.floreantpos.actions.CloseDialogAction;
import com.floreantpos.model.Ticket;
import com.floreantpos.model.dao.TicketDAO;
import com.floreantpos.swing.PosButton;
import com.floreantpos.ui.TicketListView;
import com.floreantpos.ui.TitlePanel;
import com.floreantpos.util.TicketAuthorizer;

public class TicketAuthorizationDialog extends POSDialog implements TicketAuthorizer {
	private TicketListView ticketListView = new TicketListView();
	
	public TicketAuthorizationDialog(JFrame parent) {
		super(parent, true);
		
		TitlePanel titlePanel = new TitlePanel();
		titlePanel.setTitle("Authorize tickets");
		add(titlePanel, BorderLayout.NORTH);
		
		JXTable table = ticketListView.getTable();
		table.getColumnExt(1).setVisible(false);
		table.getColumnExt(2).setVisible(false);
		table.getColumnExt(3).setVisible(false);
		
		ticketListView.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(ticketListView);
		
		JPanel buttonPanel = new JPanel();
		PosButton authorizeButton = new PosButton(new AuthorizeTicketAction(this));
		buttonPanel.add(authorizeButton);
		
		PosButton closeButton = new PosButton(new CloseDialogAction(this));
		buttonPanel.add(closeButton);
		
		add(buttonPanel, BorderLayout.SOUTH);
		
		updateTicketList();
	}

	public void updateTicketList() {
		TicketDAO dao = TicketDAO.getInstance();
		List<Ticket> openTickets = dao.findHoldTickets();

		ticketListView.setTickets(openTickets);
	}
	
	@Override
	public TicketListView getTicketListView() {
		return ticketListView;
	}
}