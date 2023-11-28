package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import java.awt.Color;
import java.awt.Toolkit;

public class Probsd1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	//arreglo puede guardar varios valores	0	           1	 2	   3
	//private String[] arr_codigo= {"Selecciona codigo", "101","102","103"};
	private JComboBox cbocodigo;	//global

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Probsd1 frame = new Probsd1();
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
	public Probsd1() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\diego\\Downloads\\logo-ingelmec.png"));
		setTitle("VENTA DE POLOS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 468);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblcodigo = new JLabel("CODIGO");
		lblcodigo.setHorizontalAlignment(SwingConstants.CENTER);
		lblcodigo.setBounds(65, 53, 100, 39);
		contentPane.add(lblcodigo);
		
		JLabel lblcantidad = new JLabel("CANTIDAD");
		lblcantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblcantidad.setBounds(65, 103, 100, 39);
		contentPane.add(lblcantidad);
		
		cbocodigo = new JComboBox();
		cbocodigo.setBounds(164, 53, 131, 39);
		//cbocodigo.additem("Seleccione codigo");
		//cbocodigo.additem("101");
		//cbocodigo.additem("102");
		//cbocodigo.additem("103");
		//For es Sentencia de repeticion que inicia en 0 y termina en 4 porque el arreglo tiene 4 valores; y aumenta de uno en uno
		//for( int x=0; x<arr_codigo.length;x++)	{
		//	cbocodigo.addItem(arr_codigo[x]);			
		//}		
		llenarArreglo();
		contentPane.add(cbocodigo);
		
		JSpinner spncantidad = new JSpinner();
		spncantidad.setBounds(164, 99, 131, 43);
		contentPane.add(spncantidad);		
		
		JScrollPane spcresultado = new JScrollPane();
		spcresultado.setBounds(75, 153, 364, 171);
		contentPane.add(spcresultado);
		
		JTextArea txtresultado = new JTextArea();
		spcresultado.setViewportView(txtresultado);
		
		JButton btnprocesar = new JButton("Procesar");
		btnprocesar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Declaracion de Variables
				int cantidad, caramelos=0;
				double precio=0, impcom, impdes=0, imppag=0;					
				
				
				//Entrada de datos
				if (cbocodigo.getSelectedItem()=="101")	{
					precio=17.5;
				}
				if (cbocodigo.getSelectedItem()=="102")	{
					precio=25.0;
				}
				if (cbocodigo.getSelectedItem()=="103")	{
					precio=15.5;
				}
				
				
				cantidad=(Integer)(spncantidad.getValue());
								
				//Calcula el importe de la compra
				impcom=precio*cantidad;	
				
				
				//Calculo el importe del descuento
				if (cantidad<11)
					impdes=0.05*impcom;
				if (cantidad>=11 && cantidad<21)
					impdes=0.075*impcom;
				if (cantidad>=21 && cantidad<31)
					impdes=0.10*impcom;
				if (cantidad>=31)
					impdes=0.125*impcom;
				
					
				//Calculo el importe a pagar
				imppag=impcom-impdes;
				
				//Calculo los caramelos
				if (imppag>250)	{
					caramelos=3*cantidad;				
				}else	{
					caramelos=2*cantidad;
				}	
				
				//Salida
				txtresultado.setText("Precio del Producto   :"+precio+"\n");
				txtresultado.append("Importe de compra    :"+impcom+"\n");
				txtresultado.append("Descuento                   :"+impdes+"\n");
				txtresultado.append("Importe de pago         :"+imppag+"\n");
				txtresultado.append("Caramelos                  :"+caramelos);
		
			}
		});
		btnprocesar.setBounds(330, 53, 109, 39);
		contentPane.add(btnprocesar);
		
		JButton btnborrar = new JButton("Borrar");
		btnborrar.setBounds(330, 103, 109, 39);
		contentPane.add(btnborrar);
	}
	
	//Metodo PUBLICO que no haya retorno y el nombreMetodo
	public void llenarArreglo()	{
		String	[] arr_codigos=	{"Seleccione codigo","101","102","103"};
		for (String codigo: arr_codigos) {
			cbocodigo.addItem(codigo);			
		}
	}
}
