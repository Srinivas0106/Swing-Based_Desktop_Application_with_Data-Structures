import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SinglyLinkedList extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField insertRelement;
	private JTextField insertFelement;
	private JTextField displayField;

	class Node {
		int data;
		Node link;
	}

	Node temp;
	private Node first;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SinglyLinkedList frame = new SinglyLinkedList();
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
	public SinglyLinkedList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(155, 147, 100));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel sll = new JLabel("SINGLY  LINKED LIST");
		sll.setBackground(new Color(0, 128, 0));
		sll.setFont(new Font("Arial Black", Font.BOLD, 14));
		sll.setBounds(129, 11, 218, 21);
		sll.setForeground(new Color(128, 64, 64));
		contentPane.add(sll);

		JLabel entrEleR = new JLabel("ENTER THE ELEMENT : ");
		entrEleR.setBounds(26, 72, 142, 14);
		contentPane.add(entrEleR);

		insertRelement = new JTextField();
		insertRelement.setBackground(new Color(192, 192, 192));
		insertRelement.setBounds(163, 69, 79, 20);
		contentPane.add(insertRelement);
		insertRelement.setColumns(10);

		JButton insertRear = new JButton("INSERT REAR");
		insertRear.setForeground(new Color(217, 91, 38));
		insertRear.setFont(new Font("Tahoma", Font.BOLD, 12));
		insertRear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Insert RareEnd Code here
				Node newnode = new Node();
				int elem = Integer.valueOf(insertRelement.getText());
				newnode.data = elem;
				newnode.link = null;
				if (first == null) {
					first = newnode;
				} else {
					temp = first;
					while (temp.link != null) {
						temp = temp.link;
					}
					temp.link = newnode;
				}
				JOptionPane.showMessageDialog(contentPane, "Element " + elem + " inserted at rear.");
				insertRelement.setText("");
			}
		});
		insertRear.setBounds(252, 68, 135, 23);
		contentPane.add(insertRear);

		JLabel entrEleF = new JLabel("ENTER THE ELEMENT : ");
		entrEleF.setBounds(26, 111, 142, 14);
		contentPane.add(entrEleF);

		insertFelement = new JTextField();
		insertFelement.setBackground(new Color(192, 192, 192));
		insertFelement.setColumns(10);
		insertFelement.setBounds(163, 108, 79, 20);
		contentPane.add(insertFelement);

		JButton insertFront = new JButton("INSERT FRONT");
		insertFront.setForeground(new Color(217, 91, 38));
		insertFront.setFont(new Font("Tahoma", Font.BOLD, 12));
		insertFront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int elem = Integer.valueOf(insertFelement.getText());
				Node newnode = new Node();
				newnode.data = elem;
				newnode.link = null;
				if (first == null) {
					first = newnode;
				} else {
					newnode.link = first;
					first = newnode;
				}

				JOptionPane.showMessageDialog(contentPane, "Element " + elem + " inserted at front.");
				insertFelement.setText("");

			}
		});
		insertFront.setBounds(252, 107, 135, 23);
		contentPane.add(insertFront);

		JButton deleteFront = new JButton("DELETE FRONT");
		deleteFront.setForeground(new Color(14, 207, 241));
		deleteFront.setFont(new Font("Tahoma", Font.BOLD, 12));
		deleteFront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (first == null) {
					displayField.setText("");
					JOptionPane.showConfirmDialog(contentPane, "Deletion  not  Possible");
				} else {
					String message = "Deleted Element is " + first.data;
					first = first.link;
					JOptionPane.showMessageDialog(contentPane, message);
					if (first == null) {
						displayField.setText(""); // Clear display if the list is empty
					} else {
						StringBuilder displayText = new StringBuilder();
						Node temp = first;
						while (temp != null) {
							displayText.append(temp.data).append(" ");
							temp = temp.link;
						}
						displayField.setText(displayText.toString()); // Update with current list elements
					}
				}
			}
		});
		deleteFront.setBounds(55, 150, 138, 23);
		contentPane.add(deleteFront);

		JButton resDisply = new JButton("DISPLAY");
		resDisply.setFont(new Font("Tahoma", Font.BOLD, 12));
		resDisply.setForeground(new Color(0, 128, 0));
		resDisply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Node temp;
				if (first == null) {
					displayField.setText("");
					JOptionPane.showMessageDialog(contentPane, "Display not possible. The list is empty.");
				} else {
					StringBuilder displayText = new StringBuilder();
					temp = first;
					while (temp != null) {
						displayText.append(temp.data).append(" ");
						temp = temp.link;
					}
					displayField.setText(displayText.toString());
				}
			}
		});
		resDisply.setBounds(165, 184, 87, 23);
		contentPane.add(resDisply);

		displayField = new JTextField();
		displayField.setForeground(new Color(0, 0, 0));
		displayField.setBackground(new Color(192, 192, 192));
		displayField.setColumns(10);
		displayField.setBounds(68, 218, 290, 20);
		contentPane.add(displayField);

		JButton deleteRear = new JButton("DELETE REAR");
		deleteRear.setForeground(new Color(141, 81, 174));
		deleteRear.setFont(new Font("Tahoma", Font.BOLD, 12));
		deleteRear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (first == null) {
					JOptionPane.showMessageDialog(contentPane, "Deletion not possible - List is empty.");
				} else if (first.link == null) {
					String message = "Deleted element: " + first.data;
					first = null; // List becomes empty
					JOptionPane.showMessageDialog(contentPane, message);
				} else {
					Node temp = first;
					while (temp.link.link != null) {
						temp = temp.link;
					}
					String message = "Deleted element: " + temp.link.data;
					temp.link = null; // Remove last node
					JOptionPane.showMessageDialog(contentPane, message);
					StringBuilder displayText = new StringBuilder();
					temp = first;
					while (temp != null) {
						displayText.append(temp.data).append(" ");
						temp = temp.link;
					}
					displayField.setText(displayText.toString());
				}
			}
		});
		deleteRear.setBounds(227, 150, 149, 23);
		contentPane.add(deleteRear);
	}

}
