package presentacio;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import domini.Ascensor;

public class PantallaAscensor extends JFrame {

	private JPanel contentPane;
	private JTextField pes;
	private JRadioButton premerBotoPis0;
	private JRadioButton premerBotoPis1;
	private Ascensor ascensor;
	private JLabel pis;
	private JLabel moviment;
	private ButtonGroup buttonGroupPis;
	private JRadioButton premerBotoPis2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaAscensor frame = new PantallaAscensor();
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
	public PantallaAscensor() {
		this.ascensor = new Ascensor(300);
		setTitle("Prova Ascensor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		buttonGroupPis = new javax.swing.ButtonGroup();

		premerBotoPis0 = new JRadioButton("Pis 0");
		premerBotoPis0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ferMoviment(0);
			}
		});
		premerBotoPis0.setBounds(64, 136, 109, 23);
		contentPane.add(premerBotoPis0);
		buttonGroupPis.add(premerBotoPis0);

		premerBotoPis1 = new JRadioButton("Pis 1");
		premerBotoPis1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ferMoviment(1);
			}
		});
		premerBotoPis1.setBounds(64, 110, 109, 23);
		contentPane.add(premerBotoPis1);
		buttonGroupPis.add(premerBotoPis1);

		premerBotoPis2 = new JRadioButton("Pis 2");
		premerBotoPis2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ferMoviment(2);
			}
		});
		premerBotoPis2.setBounds(64, 84, 109, 23);
		contentPane.add(premerBotoPis2);
		buttonGroupPis.add(premerBotoPis2);

		pes = new JTextField();
		pes.setBounds(294, 132, 45, 20);
		contentPane.add(pes);
		pes.setColumns(10);

		JLabel lblNewLabel = new JLabel("Carrega actual");
		lblNewLabel.setBounds(272, 106, 85, 14);
		contentPane.add(lblNewLabel);

		moviment = new JLabel("");
		moviment.setBounds(23, 236, 401, 14);
		contentPane.add(moviment);

		JLabel lblNewLabel_1 = new JLabel("Pis actual");
		lblNewLabel_1.setBounds(142, 42, 67, 14);
		contentPane.add(lblNewLabel_1);

		pis = new JLabel("");
		pis.setBounds(219, 42, 28, 14);
		contentPane.add(pis);

		JLabel lblNewLabel_2 = new JLabel("Pes m\u00E1xim");
		lblNewLabel_2.setBounds(272, 164, 67, 14);
		contentPane.add(lblNewLabel_2);

		JLabel maxim = new JLabel("");
		maxim.setText(String.valueOf(ascensor.getPES_MAXIM()));
		maxim.setBounds(349, 164, 46, 14);
		contentPane.add(maxim);

		JLabel lblNewLabel_3 = new JLabel("\u00DAltim moviment");
		lblNewLabel_3.setBounds(167, 206, 109, 14);
		contentPane.add(lblNewLabel_3);
		actualitzarPantalla("Encara no s'ha fet cap moviment");
	}	
	
	protected void ferMoviment(int pis) {
		String mov = "sense moviemnt";
		try {
			int carrega = Integer.parseInt(pes.getText());
			switch (pis) {
			case 0:
				mov = ascensor.premerBotoPis0(carrega);
				break;
			case 1:
				mov = ascensor.premerBotoPis1(carrega);
				break;
			case 2:
				mov = ascensor.premerBotoPis2(carrega);
				break;
			}
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(this, "Error: cal entrar un enter amb la càrrega actual de l'ascensor");
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "Error: " + e2.getMessage());
		}
		actualitzarPantalla(mov);
	}

	protected void actualitzarPantalla(String moviment) {
		this.pis.setText(String.valueOf(ascensor.getPis()));
		this.moviment.setText(moviment);
		this.pes.setText("");
		switch(ascensor.getPis()) {
			case 0: premerBotoPis0.setSelected(true); break;
			case 1: premerBotoPis1.setSelected(true); break;
			case 2: premerBotoPis2.setSelected(true); break;
		}
	}
}