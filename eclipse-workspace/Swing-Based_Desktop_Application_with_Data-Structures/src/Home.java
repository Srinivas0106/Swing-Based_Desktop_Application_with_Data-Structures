import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("CHOOSE A DATA STRUCTURE");
		lblNewLabel.setForeground(new Color(255, 0, 255));
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		lblNewLabel.setBounds(108, 11, 246, 17);
		contentPane.add(lblNewLabel);

		JButton array = new JButton("ARRAY");
		array.setBackground(new Color(192, 192, 192));
		array.setFont(new Font("Wide Latin", Font.BOLD, 13));
		array.setForeground(new Color(0, 0, 255));
		array.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// PLACE ARRAY WINDOW OPENING CODE HERE
//				Array a = new Array();
//				a.setVisible(true);
				// Anonymous object
				new Array().setVisible(true);

			}
		});
		array.setBounds(140, 55, 158, 31);
		contentPane.add(array);

		JButton stack = new JButton("STACK");
		stack.setFont(new Font("Wide Latin", Font.BOLD, 13));
		stack.setForeground(new Color(255, 128, 0));
		stack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// PLACE STACK WINDOW OPENING CODE HERE
//				Stack s = new Stack();
//				a.setVisible(true);
				// Anonymous object
				new Stack().setVisible(true);

			}
		});
		stack.setBounds(45, 97, 131, 27);
		contentPane.add(stack);

		JButton queue = new JButton("QUEUE");
		queue.setFont(new Font("Arial Black", Font.BOLD, 13));
		queue.setForeground(new Color(255, 0, 128));
		queue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// PLACE QUEUE WINDOW OPENING CODE HERE
				new Queue().setVisible(true);
			}
		});
		queue.setBounds(254, 95, 121, 27);
		contentPane.add(queue);

		JButton circularqueue = new JButton("CIRCULAR QUEUE");
		circularqueue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// PLACE CIRCULAR QUEUE WINDOW OPENING CODE HERE
				new CircularQueue().setVisible(true);
			}
		});
		circularqueue.setFont(new Font("Arial Black", Font.BOLD, 14));
		circularqueue.setForeground(new Color(64, 0, 128));
		circularqueue.setBounds(10, 154, 214, 29);
		contentPane.add(circularqueue);

		JButton singlylinkedlist = new JButton("SINGLY LINKED LIST");
		singlylinkedlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// PLACE SINGLY LINKED LIST WINDOW OPENING CODE HERE
				new SinglyLinkedList().setVisible(true);
			}
		});
		singlylinkedlist.setFont(new Font("Arial", Font.BOLD, 14));
		singlylinkedlist.setForeground(new Color(64, 0, 64));
		singlylinkedlist.setBounds(234, 157, 192, 25);
		contentPane.add(singlylinkedlist);

		JButton doubllyLinkedList = new JButton("DOUBLY LINKED LIST");
		doubllyLinkedList.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		doubllyLinkedList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// PLACE DOUBLY LINKED LIST WINDOW OPENING CODE HERE
				new DoublyLinedList().setVisible(true);
			}
		});
		doubllyLinkedList.setForeground(new Color(128, 128, 0));
		doubllyLinkedList.setBounds(109, 207, 214, 25);
		contentPane.add(doubllyLinkedList);
	}
}
