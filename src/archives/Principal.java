package archives;

import java.awt.BorderLayout;
import java.awt.Dialog.ModalityType;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 1280, 735);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("Escolha um cronômetro:");
		lblTitulo.setBounds(105, 11, 1054, 60); // Centralizado no topo
		lblTitulo.setFont(new Font("Trebuchet MS", Font.PLAIN, 45));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTitulo);

		JLabel lblCrescente = new JLabel("CRONÔMETRO CRESCENTE");
		lblCrescente.setBounds(65, 119, 400, 40);
		lblCrescente.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
		contentPane.add(lblCrescente);

		JLabel lblDecrescente = new JLabel("CRONÔMETRO DECRESCENTE");
		lblDecrescente.setBounds(823, 119, 450, 40);
		lblDecrescente.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
		contentPane.add(lblDecrescente);

		JButton btnCrescente = new JButton("CLICK");
		btnCrescente.setBounds(75, 170, 300, 100);
		btnCrescente.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		btnCrescente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CronometroCrescente tela2 = new CronometroCrescente();
				tela2.setModalityType(ModalityType.APPLICATION_MODAL);
				tela2.setVisible(true);
			}
		});
		contentPane.add(btnCrescente);

		JButton btnDecrescente = new JButton("CLICK");
		btnDecrescente.setBounds(859, 170, 300, 100);
		btnDecrescente.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		btnDecrescente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CronometroDecrescente tela3 = new CronometroDecrescente();
				tela3.setModalityType(ModalityType.APPLICATION_MODAL);
				tela3.setVisible(true);
			}
		});
		contentPane.add(btnDecrescente);

		JLabel lblSair = new JLabel("SAIR");
		lblSair.setBounds(520, 397, 180, 40);
		lblSair.setHorizontalAlignment(SwingConstants.CENTER);
		lblSair.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		contentPane.add(lblSair);

		JButton btnSair = new JButton("CLICK");
		btnSair.setBounds(463, 448, 300, 100);
		btnSair.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane.add(btnSair);
	}
}
