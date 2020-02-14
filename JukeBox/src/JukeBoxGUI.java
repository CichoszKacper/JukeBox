import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JTextField;

import java.awt.FlowLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.AbstractListModel;

import java.awt.List;


public class JukeBoxGUI extends JFrame {
	
	private JukeBox jb = new JukeBox();

	private JPanel contentPane;
	private JTextField addSong;
	private JButton btnNewButton;
	private JTextArea playlist;
	private JTextField playSong;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JukeBoxGUI frame = new JukeBoxGUI();
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
	
	private void updatePlaylist(){
		playlist.setText(jb.printPlayList());
	}
	
	public JukeBoxGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 513);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJukebox = new JLabel("JukeBox");
		lblJukebox.setBounds(280, 10, 154, 81);
		lblJukebox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		lblJukebox.setHorizontalAlignment(SwingConstants.CENTER);
		lblJukebox.setBackground(new Color(51, 204, 204));
		contentPane.add(lblJukebox);
		contentPane.add(getAddSong());
		contentPane.add(getBtnNewButton());
		contentPane.add(getPlaylist());
		contentPane.add(getPlaySong());
		contentPane.add(getBtnNewButton_1());
		contentPane.add(getBtnNewButton_2());
	}
	private JTextField getAddSong() {
		if (addSong == null) {
			addSong = new JTextField();
			addSong.setText("Enter a new song...");
			addSong.setToolTipText("Enter a new song...");
			addSong.setBounds(52, 101, 172, 29);
			addSong.setColumns(10);
			
		}
		return addSong;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Add ");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Song song = new Song(addSong.getText());
					jb.add(song);
					updatePlaylist();
					
				}
			});
			btnNewButton.setBounds(223, 102, 89, 28);
		}
		return btnNewButton;
	}
	private JTextArea getPlaylist() {
		if (playlist == null) {
			playlist = new JTextArea();
			playlist.setText(jb.printPlayList());
			playlist.setBounds(440, 156, 233, 271);
			
			
		}
		
		return playlist;
	}
	private JTextField getPlaySong() {
		if (playSong == null) {
			playSong = new JTextField();
			playSong.setText("Enter song to play...");
			playSong.setBounds(52, 141, 172, 29);
			playSong.setColumns(10);
		}
		return playSong;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Play song");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Song song = new Song(playSong.getText());
					jb.playSong(song);
					updatePlaylist();
				}
			});
			btnNewButton_1.setBounds(223, 141, 89, 29);
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("Play first song");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jb.playFirstSong();
					updatePlaylist();
				}
			});
			btnNewButton_2.setBounds(440, 120, 122, 23);
		}
		return btnNewButton_2;
	}
}
