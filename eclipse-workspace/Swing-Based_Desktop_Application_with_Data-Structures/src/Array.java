import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
//import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Array extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int arr[];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Array frame = new Array();
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
	public Array() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 0, 0));
		contentPane.setBackground(new Color(200, 208, 174));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel arrayi = new JLabel("ARRAY DATA STRUCTURE");
		arrayi.setForeground(new Color(255, 0, 0));
		arrayi.setBackground(new Color(192, 192, 192));
		arrayi.setFont(new Font("Arial", Font.BOLD, 15));
		arrayi.setBounds(107, 11, 235, 17);
		contentPane.add(arrayi);

		JLabel arrayLength = new JLabel("ENTER ARRAY LENGTH");
		arrayLength.setFont(new Font("Arial", Font.BOLD, 12));
		arrayLength.setForeground(new Color(255, 0, 0));
		arrayLength.setBounds(39, 55, 137, 14);
		contentPane.add(arrayLength);

		JTextArea length = new JTextArea();
		length.setBounds(200, 50, 142, 22);
		contentPane.add(length);

		JButton cArray = new JButton("CREATE ARRAY");
		cArray.setForeground(new Color(255, 0, 0));
		cArray.setBackground(new Color(192, 192, 192));
		cArray.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// code for creating array
				int len = Integer.valueOf(length.getText());
				arr = new int[len];
				String message = "Array of length " + len + " Created.";
				JOptionPane.showConfirmDialog(contentPane, message);

			}

		});
		cArray.setFont(new Font("Arial", Font.BOLD, 12));
		cArray.setBounds(130, 80, 184, 23);
		contentPane.add(cArray);

		JLabel element = new JLabel("ENTER INTEGER ELEMNENT");
		element.setForeground(new Color(255, 0, 255));
		element.setFont(new Font("Arial", Font.BOLD, 11));
		element.setBounds(10, 119, 153, 13);
		contentPane.add(element);
		JTextArea InsertElement = new JTextArea();
		InsertElement.setBounds(163, 113, 53, 22);
		contentPane.add(InsertElement);

		JLabel position = new JLabel("POSITION");
		position.setForeground(Color.MAGENTA);
		position.setFont(new Font("Arial", Font.BOLD, 11));
		position.setBounds(226, 119, 53, 13);
		contentPane.add(position);

		JTextArea insertPos = new JTextArea();
		insertPos.setBounds(289, 113, 53, 22);
		contentPane.add(insertPos);

		JButton btnInsert = new JButton("INSERT");
		btnInsert.setForeground(new Color(0, 0, 255));
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Code for insertion
				int ele = Integer.valueOf(InsertElement.getText());
				int pos = Integer.valueOf(insertPos.getText());
				arr[pos] = ele;
				String message = "Element " + ele + " Inserted @ position " + pos;
				JOptionPane.showConfirmDialog(contentPane, message);
				InsertElement.setText("");
				insertPos.setText("");

			}
		});
		btnInsert.setFont(new Font("Arial", Font.BOLD, 12));
		btnInsert.setBounds(351, 114, 85, 23);
		contentPane.add(btnInsert);

		JLabel enterposition = new JLabel("ENTER THE POSITION");
		enterposition.setForeground(Color.MAGENTA);
		enterposition.setFont(new Font("Arial", Font.BOLD, 12));
		enterposition.setBounds(13, 163, 137, 14);
		contentPane.add(enterposition);

		JTextArea deletePos = new JTextArea();
		deletePos.setBounds(153, 158, 56, 22);
		contentPane.add(deletePos);

		JButton btnDelete = new JButton("DELETE");
		btnDelete.setForeground(new Color(255, 0, 0));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int pos = Integer.valueOf(deletePos.getText());
				arr[pos] = 0;
				String message = "Element Deleted @ the position " + pos;
				JOptionPane.showConfirmDialog(contentPane, message);
				deletePos.setText("");
			}
		});
		btnDelete.setFont(new Font("Arial", Font.BOLD, 12));
		btnDelete.setBounds(239, 159, 103, 23);
		contentPane.add(btnDelete);

		JTextArea tadisplay = new JTextArea();
		tadisplay.setBounds(39, 230, 317, 22);
		contentPane.add(tadisplay);
		
		JButton display = new JButton("DISPLAY");
		display.setForeground(new Color(64, 0, 128));
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Code for display
				String msg = "";
				for(int i=0;i<=arr.length-1;i++) {
					msg = msg+" "+ arr[i];
				}
				tadisplay.setText(msg);
			}
		});
		display.setFont(new Font("Arial", Font.BOLD, 12));
		display.setBounds(166, 191, 122, 23);
		contentPane.add(display);
	}
}
