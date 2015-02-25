package org.oruji.peyk;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

public class PeykFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public PeykFrame(int port) {
		setTitle("Peyk Messenger");
		JPanel panel = new JPanel();
		final JList<PeykUser> userJList = new JList<PeykUser>();

		userJList.setListData(new OnlineUser(port).getOnlineUsers());

		userJList.setSelectedIndex(0);

		userJList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int index = userJList.locationToIndex(e.getPoint());
					ListModel<PeykUser> userListModel = userJList.getModel();
					Object item = userListModel.getElementAt(index);

					final PeykUser peykUser = (PeykUser) item;

					userJList.ensureIndexIsVisible(index);

					ChatFrame.getChatFrame(peykUser);
				}
			}
		});

		panel.add(new JScrollPane(userJList));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(panel, "Center");
		setSize(300, 650);
		setResizable(false);
		setVisible(true);
	}
}
