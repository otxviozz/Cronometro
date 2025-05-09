package archives;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CronometroCrescente extends JDialog implements Runnable {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private int segundos=0;
	private int minutos=0;
	private int horas=0;
	private boolean loop= false;
	private JLabel lblCronometro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CronometroCrescente dialog = new CronometroCrescente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void start() {
        loop = true;
        new Thread(this).start();
    }

    public void pause() {
        loop = false;
    }

    public void reset() {
        loop = false;
        horas = 0;
        minutos = 0;
        segundos = 0;
        atualizarLabel();
    }

    @Override
    public void run() {
        while (loop) {
            try {
                Thread.sleep(1000);
                incrementarTempo();
                atualizarLabel();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void incrementarTempo() {
        segundos++;
        if (segundos == 60) {
            segundos = 0;
            minutos++;
        }
        if (minutos == 60) {
            minutos = 0;
            horas++;
        }
    }

    private void atualizarLabel() {
        String tempo = String.format("%02d:%02d:%02d", horas, minutos, segundos);
        lblCronometro.setText(tempo);
    }
    
	/**
	 * Create the dialog.
	 */
	public CronometroCrescente() {
		setSize(967, 540);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblExit = new JLabel("FECHAR");
		lblExit.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		lblExit.setBounds(433, 758, 118, 60);
		contentPanel.add(lblExit);
		
		JButton Exit = new JButton("CLICK");
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		Exit.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		Exit.setBounds(339, 829, 305, 121);
		contentPanel.add(Exit);
		
		JButton Pause = new JButton("CLICK");
		Pause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pause();
			}
		});
		Pause.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		Pause.setBounds(91, 424, 125, 55);
		contentPanel.add(Pause);
		
		JButton Start = new JButton("CLICK");
		Start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start();
			}
		});
		Start.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		Start.setBounds(433, 424, 125, 55);
		contentPanel.add(Start);
		
		JButton Reset = new JButton("CLICK");
		Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		Reset.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		Reset.setBounds(798, 424, 125, 55);
		contentPanel.add(Reset);
		
		JLabel lblStop = new JLabel("PAUSE");
		lblStop.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		lblStop.setBounds(102, 353, 88, 60);
		contentPanel.add(lblStop);
		
		JLabel lblStart = new JLabel("START");
		lblStart.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		lblStart.setBounds(456, 353, 95, 60);
		contentPanel.add(lblStart);
		
		JLabel lblRESET = new JLabel("RESET");
		lblRESET.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		lblRESET.setBounds(833, 355, 88, 60);
		contentPanel.add(lblRESET);
		
		JLabel lbltextCronometro = new JLabel("CRONÔMETRO CRESCENTE");
		lbltextCronometro.setFont(new Font("Trebuchet MS", Font.PLAIN, 40));
		lbltextCronometro.setBounds(251, 10, 523, 100);
		contentPanel.add(lbltextCronometro);
		
		lblCronometro = new JLabel("");
		lblCronometro.setBackground(new Color(255, 255, 255));
		lblCronometro.setFont(new Font("Trebuchet MS", Font.PLAIN, 65));
		lblCronometro.setBounds(102, 116, 820, 190);
		contentPanel.add(lblCronometro);
		lblCronometro.setOpaque(true);
		lblCronometro.setHorizontalAlignment(JLabel.CENTER);
		lblCronometro.setVerticalAlignment(JLabel.CENTER);
	}
}
