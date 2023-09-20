package ky2lab7;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JTextField;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DropMode;
import java.awt.Color;
import javax.swing.border.EmptyBorder;

public class MainApp extends JFrame {
	
	private JLabel lblOriginalText;
	private JLabel lblEncryptedText;
	private JLabel lblDecryptedText;
	private JButton btnGenerateKeypair;
	private JButton btnEncrypt;
	private JButton btnDecrypt;
	private JTextArea textAreaOriginal;
	private JTextArea textAreaEncrypted;
	private JTextArea textAreaDecrypted;	
	private JPanel panel;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					MainApp frame = new MainApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}
	
	public void encrypt() {
		try {
			String originalText = textAreaOriginal.getText();
			PublicKey publicKey = DemoRSA.getPublicKey();
			
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			
			byte[] byteEncrypted = cipher.doFinal(originalText.getBytes());
			String encrypted = Base64.getEncoder().encodeToString(byteEncrypted);
			textAreaEncrypted.setText(encrypted);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void decrypt() {
		try {
			String encryptText = textAreaEncrypted.getText();
			PrivateKey privateKey = DemoRSA.getPrivateKey();
			
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			
			byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptText));
			textAreaDecrypted.setText(new String(decrypted));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public MainApp() {
		setBounds(0, 0, 911, 274);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	    getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 911, 251);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblOriginalText = new JLabel("Original text:");
		lblOriginalText.setBounds(6, 43, 83, 26);
		panel.add(lblOriginalText);
		
		lblEncryptedText = new JLabel("Encrypted text:");
		lblEncryptedText.setBounds(349, 40, 112, 29);
		panel.add(lblEncryptedText);
		
		lblDecryptedText = new JLabel("Decrypted text:");
		lblDecryptedText.setBounds(695, 40, 112, 29);
		panel.add(lblDecryptedText);
		
		btnGenerateKeypair = new JButton("Generate Keypair");
		btnGenerateKeypair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}	
		});
		btnGenerateKeypair.setBackground(new Color(251, 255, 255));
		btnGenerateKeypair.setBorderPainted(false);
		btnGenerateKeypair.setOpaque(true);
		btnGenerateKeypair.setBounds(6, 6, 210, 26);
		panel.add(btnGenerateKeypair);
		
		btnEncrypt = new JButton("Encrypt >>");
		btnEncrypt.setBackground(new Color(251, 255, 255));
		btnEncrypt.setBorderPainted(false);
		btnEncrypt.setOpaque(true);
		btnEncrypt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				encrypt();
			}	
		});
		btnEncrypt.setBounds(223, 137, 117, 29);
		panel.add(btnEncrypt);
		
		btnDecrypt = new JButton("Decrypt >>");
		btnDecrypt.setBackground(new Color(251, 255, 255));
		btnDecrypt.setBorderPainted(false);
		btnDecrypt.setOpaque(true);
		btnDecrypt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				decrypt();
			}	
		});
		btnDecrypt.setBounds(568, 137, 117, 29);
		panel.add(btnDecrypt);
		
		textAreaOriginal = new JTextArea();
		textAreaOriginal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textAreaOriginal.setText("");
			}
		});
		textAreaOriginal.setBounds(6, 75, 210, 159);
		textAreaOriginal.setLineWrap(true); 
		textAreaOriginal.setWrapStyleWord(true);
		panel.add(textAreaOriginal);
		
		textAreaEncrypted = new JTextArea();
		textAreaEncrypted.setBounds(349, 75, 210, 159);
		textAreaEncrypted.setLineWrap(true); 
		textAreaEncrypted.setWrapStyleWord(true);
		panel.add(textAreaEncrypted);
		
		textAreaDecrypted = new JTextArea();
		textAreaDecrypted.setBounds(695, 75, 210, 159);
		textAreaDecrypted.setLineWrap(true); 
		textAreaDecrypted.setWrapStyleWord(true);
		panel.add(textAreaDecrypted);
		
	}
}
