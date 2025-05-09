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

public class CronometroDecrescente extends JDialog implements Runnable {

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
    
    public void cinco() {
    	horas = 0;
        minutos = 5;
        segundos = 0;
        atualizarLabel();
    }
    
    public void dez() {
    	horas = 0;
        minutos = 10;
        segundos = 0;
        atualizarLabel();
    }
    
    public void quinze() {
    	horas = 0;
        minutos = 15;
        segundos = 0;
        atualizarLabel();
    }

    @Override
    public void run() {
        while (loop) {
            try {
                Thread.sleep(1000);
                DiminuirTempo();
                atualizarLabel();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void DiminuirTempo() {
        segundos--;
        if (segundos < 0) {
            segundos = 59;
            minutos--;
        }
        if (minutos < 0) {
            minutos = 59;
            horas--;
        }
        if (horas < 0) {
            horas = 0;
            minutos = 0;
            segundos = 0;
        }
    }

    private void atualizarLabel() {
        String tempo = String.format("%02d:%02d:%02d", horas, minutos, segundos);
        lblCronometro.setText(tempo);
    }
    
	/**
	 * Create the dialog.
	 */
	public CronometroDecrescente() {
		setSize(965, 620);
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
		Pause.setBounds(92, 518, 125, 55);
		contentPanel.add(Pause);
		
		JButton Start = new JButton("CLICK");
		Start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start();
			}
		});
		Start.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		Start.setBounds(433, 518, 125, 55);
		contentPanel.add(Start);
		
		JButton Reset = new JButton("CLICK");
		Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		Reset.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		Reset.setBounds(743, 518, 125, 55);
		contentPanel.add(Reset);
		
		JLabel lblStop = new JLabel("PAUSE");
		lblStop.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		lblStop.setBounds(112, 472, 88, 60);
		contentPanel.add(lblStop);
		
		JLabel lblStart = new JLabel("START");
		lblStart.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		lblStart.setBounds(456, 472, 95, 60);
		contentPanel.add(lblStart);
		
		JLabel lblRESET = new JLabel("RESET");
		lblRESET.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		lblRESET.setBounds(764, 474, 88, 60);
		contentPanel.add(lblRESET);
		
		JLabel lbltextCronometro = new JLabel("CRONÔMETRO DECRESCENTE");
		lbltextCronometro.setFont(new Font("Trebuchet MS", Font.PLAIN, 40));
		lbltextCronometro.setBounds(236, 5, 542, 100);
		contentPanel.add(lbltextCronometro);
		
		lblCronometro = new JLabel("");
		lblCronometro.setBackground(new Color(255, 255, 255));
		lblCronometro.setFont(new Font("Trebuchet MS", Font.PLAIN, 65));
		lblCronometro.setBounds(48, 116, 820, 190);
		contentPanel.add(lblCronometro);
		lblCronometro.setOpaque(true);
		lblCronometro.setHorizontalAlignment(JLabel.CENTER);
		lblCronometro.setVerticalAlignment(JLabel.CENTER);
		
		JButton CincoMin = new JButton("CLICK");
		CincoMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cinco();
			}
		});
		CincoMin.setBounds(92, 373, 125, 55);
		CincoMin.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		contentPanel.add(CincoMin);
		
		JButton DezMin = new JButton("CLICK");
		DezMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dez();
			}
		});
		DezMin.setBounds(433, 373, 125, 55);
		DezMin.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		contentPanel.add(DezMin);
		
		JButton QuinzeMin = new JButton("CLICK");
		QuinzeMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quinze();
			}
		});
		QuinzeMin.setBounds(743, 373, 125, 55);
		QuinzeMin.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		contentPanel.add(QuinzeMin);
		
		JLabel lblCinco = new JLabel("5 MINUTOS");
		lblCinco.setBounds(112, 317, 125, 60);
		lblCinco.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		contentPanel.add(lblCinco);
		
		JLabel lblDez = new JLabel("10 MINUTOS");
		lblDez.setBounds(443, 317, 118, 60);
		lblDez.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		contentPanel.add(lblDez);
		
		JLabel lblQuinze = new JLabel("15 MINUTOS");
		lblQuinze.setBounds(743, 317, 112, 60);
		lblQuinze.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		contentPanel.add(lblQuinze);
	}
}
