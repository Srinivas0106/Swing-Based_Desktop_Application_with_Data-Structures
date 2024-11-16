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

public class Queue extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField sizeField;
	private JTextField element;
	private JTextField resField;
	private int q[];
	private int size;
	private int r = -1;
	private int f = -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Queue frame = new Queue();
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
	public Queue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblQueue = new JLabel("QUEUE DATA STRUCTURE");
		lblQueue.setBounds(117, 11, 199, 17);
		lblQueue.setFont(new Font("Perpetua", Font.BOLD, 16));
		lblQueue.setForeground(new Color(0, 255, 64));
		contentPane.add(lblQueue);

		JLabel lblsize = new JLabel("Enter Queue Size  : ");
		lblsize.setForeground(new Color(0, 255, 64));
		lblsize.setFont(new Font("Perpetua", Font.BOLD, 15));
		lblsize.setBounds(10, 62, 131, 17);
		contentPane.add(lblsize);

		sizeField = new JTextField();
		sizeField.setBounds(135, 60, 84, 20);
		contentPane.add(sizeField);
		sizeField.setColumns(10);

		JButton create = new JButton("CREATE");
		create.setForeground(new Color(255, 128, 0));
		create.setFont(new Font("Tahoma", Font.BOLD, 13));
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Create an element code here
				size = Integer.valueOf(sizeField.getText());
				q = new int[size];
				String message = "Stack of Size " + size + " Created";
				JOptionPane.showConfirmDialog(contentPane, message);
				sizeField.setText("");
			}
		});
		create.setBounds(285, 59, 89, 23);
		contentPane.add(create);

		JLabel lblelement = new JLabel("Enter an Element  :  ");
		lblelement.setForeground(new Color(0, 255, 64));
		lblelement.setFont(new Font("Perpetua", Font.BOLD, 15));
		lblelement.setBounds(10, 118, 131, 17);
		contentPane.add(lblelement);

		element = new JTextField();
		element.setColumns(10);
		element.setBounds(135, 116, 84, 20);
		contentPane.add(element);

		JButton insert = new JButton("INSERT");
		insert.setForeground(new Color(0, 0, 255));
		insert.setBackground(new Color(255, 128, 0));
		insert.setFont(new Font("Tahoma", Font.BOLD, 13));
		insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Insert an Element code here
				int elem;
				if (r == size - 1) {
					JOptionPane.showConfirmDialog(contentPane, "Insertion not  Possible");
				} else {
					elem = Integer.valueOf(element.getText());
					r++;
					q[r] = elem;
					JOptionPane.showConfirmDialog(contentPane, "Insertion Succcessful");
				}
				element.setText("");
			}
		});
		insert.setBounds(285, 115, 89, 23);
		contentPane.add(insert);

		JButton delete = new JButton("DELETE");
		delete.setForeground(new Color(0, 0, 128));
		delete.setBackground(new Color(192, 192, 192));
		delete.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((f == -1 && r == -1) || (f == size - 1)) {
					String message = "Queue is empty Element Cant be deleted";
					JOptionPane.showConfirmDialog(contentPane, message);
				} else {
					f++;
					String message = "Element deleted is " + q[f];
					JOptionPane.showConfirmDialog(contentPane, message);
					q[f] = 0;
				}
			}
		});
		delete.setBounds(244, 162, 117, 23);
		contentPane.add(delete);

		JButton display = new JButton("DISPLAY");
		display.setFont(new Font("Arial Black", Font.BOLD, 13));
		display.setForeground(new Color(0, 0, 255));
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Display the content code here
				if ((f == -1 && r == -1) || (f == size - 1)) {
					display.setText("");
					String message = "Queue is empty Element Display Not Pissible";
					JOptionPane.showConfirmDialog(contentPane, message);
				} else {
					String msg = "";
					for(int i=f+1;i<=r;i++) {
						msg = msg+" "+ q[i];
					}
					resField.setText(msg);
				}
				
			}
		});
		display.setBounds(74, 161, 111, 23);
		contentPane.add(display);

		resField = new JTextField();
		resField.setColumns(10);
		resField.setBounds(43, 213, 346, 20);
		contentPane.add(resField);
	}

}
