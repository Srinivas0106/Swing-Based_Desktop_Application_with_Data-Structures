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

public class Stack extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField sizefield;
	private JTextField element;
	private JTextField displayField;
	private int s[];
	private int size;
	private int top = -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stack frame = new Stack();
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
	public Stack() {
		setForeground(new Color(128, 255, 255));
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(115, 104, 151));
		contentPane.setForeground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel stack = new JLabel("STACK DATA STRUCTURE");
		stack.setForeground(new Color(255, 0, 0));
		stack.setFont(new Font("Arial Black", Font.BOLD, 15));
		stack.setBounds(101, 11, 230, 20);
		contentPane.add(stack);

		JLabel lb1 = new JLabel("Enter Queue Size : ");
		lb1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lb1.setBounds(24, 73, 147, 18);
		contentPane.add(lb1);

		sizefield = new JTextField();
		sizefield.setBounds(159, 73, 96, 20);
		contentPane.add(sizefield);
		sizefield.setColumns(10);

		JButton btncreate = new JButton("Create Stack");
		btncreate.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		btncreate.setForeground(new Color(1, 20, 254));
		btncreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// creating stack code here

				size = Integer.valueOf(sizefield.getText());
				s = new int[size];
				String message = "Stack of Size " + size + " Created";
				JOptionPane.showConfirmDialog(contentPane, message);
				sizefield.setText("");
			}
		});
		btncreate.setBounds(288, 72, 138, 23);
		contentPane.add(btncreate);

		JLabel lblEnterAnElement = new JLabel("Enter an Element : ");
		lblEnterAnElement.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblEnterAnElement.setBounds(24, 119, 135, 18);
		contentPane.add(lblEnterAnElement);

		element = new JTextField();
		element.setColumns(10);
		element.setBounds(159, 119, 96, 20);
		contentPane.add(element);

		JButton btnpush = new JButton("PUSH");
		btnpush.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		btnpush.setForeground(new Color(1, 20, 254));
		btnpush.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int elem;
				if (top == size - 1) {
					JOptionPane.showConfirmDialog(contentPane, "Push Not Possible");
				} else {
					elem = Integer.valueOf(element.getText());
					top++;
					s[top] = elem;
					JOptionPane.showConfirmDialog(contentPane, "Push Succcessful");
				}
				element.setText("");
			}
		});
		btnpush.setBounds(288, 118, 99, 23);
		contentPane.add(btnpush);

		JButton btnpop = new JButton("POP");
		btnpop.setForeground(new Color(255, 0, 0));
		btnpop.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		btnpop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (top == -1) {
					JOptionPane.showConfirmDialog(contentPane, "Push Not possible");
				} else {
					String message = "Element Deleted is " + s[top];
					JOptionPane.showConfirmDialog(contentPane, message);
					top--;
				}
			}
		});
		btnpop.setBounds(156, 158, 99, 23);
		contentPane.add(btnpop);

		JButton btndisplay = new JButton("DISPLAY");
		btndisplay.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		btndisplay.setForeground(new Color(64, 128, 128));
		btndisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(top==-1) {
					displayField.setText("");
					JOptionPane.showConfirmDialog(displayField,"Display is not possible satck is empty");
				} else {
					String msg ="";
					for(int i=top;i>=0;i--) {
						msg = msg+" " + s[i];
					}
					displayField.setText(msg);
					
				}
			}
		});
		btndisplay.setBounds(156, 192, 99, 23);
		contentPane.add(btndisplay);

		displayField = new JTextField();
		displayField.setColumns(10);
		displayField.setBounds(50, 226, 337, 20);
		contentPane.add(displayField);
	}
}
