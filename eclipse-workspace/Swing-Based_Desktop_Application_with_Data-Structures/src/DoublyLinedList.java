import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DoublyLinedList extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblDLL;
	private JTextField elementR;
	private JTextField elementF;
	private JTextField resField;

	class Node {
		Node prelink;
		int data;
		Node nextlink;
	}

	private Node first;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoublyLinedList frame = new DoublyLinedList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DoublyLinedList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 0, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblDLL = new JLabel("DOUBLY LINEKD LIST");
		lblDLL.setBackground(new Color(128, 128, 128));
		lblDLL.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lblDLL.setForeground(new Color(255, 128, 0));
		lblDLL.setBounds(134, 11, 211, 17);
		contentPane.add(lblDLL);

		JLabel lblElement = new JLabel("ENTER THE R-ELEMENT");
		lblElement.setForeground(new Color(255, 128, 128));
		lblElement.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblElement.setBounds(10, 71, 182, 19);
		contentPane.add(lblElement);

		elementR = new JTextField();
		elementR.setBounds(202, 72, 67, 20);
		contentPane.add(elementR);
		elementR.setColumns(10);

		JButton insertRear = new JButton("INSERT REAR");
		insertRear.setFont(new Font("SansSerif", Font.BOLD, 13));
		insertRear.setForeground(new Color(0, 0, 255));
		insertRear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int data = Integer.valueOf(elementR.getText());
				Node newnode = new Node();
				Node temp;
				newnode.data = data;
				newnode.prelink = null;
				newnode.nextlink = null;

				if (first == null) {
					first = newnode;
				} else {
					temp = first;
					while (temp.nextlink != null) {
						temp = temp.nextlink;
					}

					temp.nextlink = newnode;
					newnode.prelink = temp;
				}
				elementR.setText("");
			}
		});
		insertRear.setBounds(292, 71, 134, 23);
		contentPane.add(insertRear);

		JLabel lblElement_1 = new JLabel("ENTER THE F-ELEMENT");
		lblElement_1.setForeground(new Color(255, 128, 128));
		lblElement_1.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblElement_1.setBounds(10, 114, 182, 19);
		contentPane.add(lblElement_1);

		elementF = new JTextField();
		elementF.setColumns(10);
		elementF.setBounds(202, 115, 67, 20);
		contentPane.add(elementF);

		JButton InsertFront = new JButton("INSERT FRONT");
		InsertFront.setForeground(new Color(0, 0, 255));
		InsertFront.setFont(new Font("Georgia", Font.BOLD, 12));
		InsertFront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int elem = Integer.valueOf(elementF.getText());
				Node newnode = new Node();
				newnode.data = elem;
				newnode.prelink = null;
				newnode.nextlink = null;

				if (first == null) {
					first = newnode;
				} else {
					newnode.nextlink = first;
					first.prelink = newnode;
					first = newnode;
				}
				elementF.setText("");
			}
		});
		InsertFront.setBounds(292, 114, 134, 23);
		contentPane.add(InsertFront);

		JButton deleteR = new JButton("DELETE REAR");
		deleteR.setFont(new Font("Tahoma", Font.BOLD, 12));
		deleteR.setForeground(new Color(255, 0, 0));
		deleteR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Node temp;
				if (first == null) {
					JOptionPane.showConfirmDialog(contentPane, "Deletion Not Possible.");
					return;
				}

				if (first.nextlink == null) {
					JOptionPane.showMessageDialog(contentPane, "First Element deleted is " + first.data);
					first = null;
				} else {
					temp = first;

					while (temp.nextlink.nextlink != null) {
						temp = temp.nextlink;
					}

					String message = "Element deleted is " + temp.nextlink.data;
					JOptionPane.showConfirmDialog(contentPane, message);
					temp.nextlink = null;
				}
				
				
			}
		});
		deleteR.setBounds(46, 158, 122, 23);
		contentPane.add(deleteR);

		JButton deleteF = new JButton("DELETE FRONT");
		deleteF.setFont(new Font("Tahoma", Font.BOLD, 12));
		deleteF.setForeground(new Color(255, 0, 0));
		deleteF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (first == null) {
					JOptionPane.showConfirmDialog(contentPane, "Deletion Not Possible.");
				}

				if (first.nextlink == null) {
					String message = "Deleted first element " + first.data;
					JOptionPane.showConfirmDialog(contentPane, message);
					first = null;
				}
				else {
					first = first.nextlink;
					first.prelink = null;
				}
				
				
			}
		});
		deleteF.setBounds(242, 158, 128, 23);
		contentPane.add(deleteF);

		resField = new JTextField();
		resField.setColumns(10);
		resField.setBounds(72, 232, 273, 20);
		contentPane.add(resField);

		JButton display = new JButton("DISPLAY");
		display.setBackground(new Color(192, 192, 192));
		display.setFont(new Font("Tahoma", Font.BOLD, 12));
		display.setForeground(new Color(255, 0, 255));
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (first == null) {
			            resField.setText("List is empty.");
			            return;
			        }

			        StringBuilder listData = new StringBuilder();
			        Node temp = first;
			        while (temp != null) {
			            listData.append(temp.data).append(" ");
			            temp = temp.nextlink;
			        }
			        resField.setText(listData.toString().trim());
			}
		});
		display.setBounds(147, 198, 122, 23);
		contentPane.add(display);
	}

}
