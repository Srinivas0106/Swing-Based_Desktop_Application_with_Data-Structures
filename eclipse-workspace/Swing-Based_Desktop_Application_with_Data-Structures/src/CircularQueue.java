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

public class CircularQueue extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField sizeField;
	private JTextField element;
	private JTextField resField;
	private int cq[];
	private int size;
	private int r = -1;
	private int f = 0;
	private int count = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CircularQueue frame = new CircularQueue();
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
	public CircularQueue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblheading = new JLabel("CIRCULAR QUEUE DATA STRUCTURE");
		lblheading.setFont(new Font("MS Gothic", Font.BOLD, 14));
		lblheading.setForeground(new Color(0, 255, 0));
		lblheading.setBounds(119, 11, 227, 14);
		contentPane.add(lblheading);

		JLabel lblEnterQueueSize = new JLabel("Enter Queue Size  :   ");
		lblEnterQueueSize.setForeground(Color.GREEN);
		lblEnterQueueSize.setFont(new Font("MS Gothic", Font.BOLD, 14));
		lblEnterQueueSize.setBounds(10, 56, 176, 14);
		contentPane.add(lblEnterQueueSize);

		sizeField = new JTextField();
		sizeField.setBounds(157, 54, 70, 20);
		contentPane.add(sizeField);
		sizeField.setColumns(10);

		JButton create = new JButton("CREATE");
		create.setFont(new Font("Tahoma", Font.BOLD, 13));
		create.setForeground(new Color(255, 0, 255));
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Creating circuler Queue
				size = Integer.valueOf(sizeField.getText());
				cq = new int[size];
				String message = "Circular Queue of Size " + size + " Created";
				JOptionPane.showConfirmDialog(contentPane, message);
				sizeField.setText("");

			}
		});
		create.setBounds(262, 53, 89, 23);
		contentPane.add(create);

		JLabel elementfiled = new JLabel("Enter an Element :   ");
		elementfiled.setForeground(Color.GREEN);
		elementfiled.setFont(new Font("MS Gothic", Font.BOLD, 14));
		elementfiled.setBounds(10, 98, 163, 14);
		contentPane.add(elementfiled);

		element = new JTextField();
		element.setColumns(10);
		element.setBounds(157, 96, 70, 20);
		contentPane.add(element);

		JButton insert = new JButton("INSERT");
		insert.setForeground(new Color(0, 128, 0));
		insert.setFont(new Font("Arial Black", Font.BOLD, 12));
		insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Insertion code is here
				int elem;
				if (count == size) {
					JOptionPane.showConfirmDialog(contentPane, "Insertion not  Possible");
				} else {
					elem = Integer.valueOf(element.getText());
					r = (r + 1) % size;
					cq[r] = elem;
					count++;
					JOptionPane.showConfirmDialog(contentPane, "Insertion Succcessful");
				}
				element.setText("");
			}
		});
		insert.setBounds(262, 95, 89, 23);
		contentPane.add(insert);

		JButton delete = new JButton("DELETE");
		delete.setFont(new Font("Tahoma", Font.BOLD, 12));
		delete.setForeground(new Color(0, 0, 128));
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (count == 0) {
					resField.setText("");
					JOptionPane.showConfirmDialog(contentPane, "Deletion is not Possible");
				} else {
					String message = "Element is deleted" + cq[f];
					JOptionPane.showConfirmDialog(contentPane, message);
					f = (f + 1) % size;
					count--;
				}
			}
		});
		delete.setBounds(159, 138, 89, 23);
		contentPane.add(delete);

		JButton display = new JButton("DISPLAY");
		display.setForeground(new Color(255, 0, 0));
		display.setFont(new Font("Dialog", Font.BOLD, 12));
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Displaying CIRCULAR QUEUE
				int f1 = f;
				if (count == 0) {
					resField.setText("");
					String message = "CQ is empty Element Display Not Pissible";
					JOptionPane.showConfirmDialog(contentPane, message);
				} else {
					String msg = "";
					for (int i = 1; i <= count; i++) 
					{
						msg = msg + " " + cq[f1];
						f1 = (f1 + 1) % size;
					}
					resField.setText(msg);
				}

			}
		});
		display.setBounds(159, 182, 89, 23);
		contentPane.add(display);

		resField = new JTextField();
		resField.setForeground(new Color(255, 0, 0));
		resField.setBackground(new Color(192, 192, 192));
		resField.setColumns(10);
		resField.setBounds(31, 216, 362, 23);
		contentPane.add(resField);
	}

}
