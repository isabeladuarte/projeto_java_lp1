package br.com.isabela.guilherme.projeto;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Principal {

	public static void menuPrincipal() {
		String menu = new String("1 - Parâmetro do Sistema\n2 - Reserva de Passagens\n3 - Sair");
		
		String op = JOptionPane.showInputDialog(menu.toString());
		
		switch (op) {
		case "1":
			parametroSistema();
			break;
		case "2":
			reservaPassagens();		
			break;
		case "3":
			System.exit(0);
			break;
		default:
			JOptionPane.showMessageDialog(null, "Opção Inválida!");
			break;
		}
	
	}
	
	public static void cadastrarAeronave() {
		String aeronave1 = JOptionPane.showInputDialog("Digite o modelo da aeronave: ");
		Aeronave av = new Aeronave(aeronave1);
		System.out.println(av.toString());
	}
	
	public static void parametroSistema() {
		String menu = new String("1 - Cadastrar Aeronave\n2 - Cadastrar Voo\n3 - Voltar");
		
		String op = JOptionPane.showInputDialog(menu.toString());
		
		switch (op) {
		case "1":
			cadastrarAeronave();
			break;
		case "2":
			cadastrarAeronave();
			
			int numeroTotalfileiras = Integer.parseInt(JOptionPane.showInputDialog("Digite o número total de fileiras no avião: "));
			int totalAssentoPorFileira = Integer.parseInt(JOptionPane.showInputDialog("Digite o número total de assento por fileira: "));
			String nro = JOptionPane.showInputDialog("Digite o número do avião: ");
			String data = JOptionPane.showInputDialog("Digite a data: ");
			String hora = JOptionPane.showInputDialog("Digite a hora: ");	
			Aviao aviao1 = new Aviao(av.getModelo(), numeroTotalfileiras, totalAssentoPorFileira);
			break;
		case "3":
			menuPrincipal();
			break;
		default:
			JOptionPane.showMessageDialog(null, "Opção Inválida!");
			break;
		}
	}
	
	public static void reservaPassagens() {
		String menu = new String("1 - Fazer reserva\n2 - Consultar lugares vazios\n3 - Consultar reservas realizadas\n4 - Voltar");
		
		String op = JOptionPane.showInputDialog(menu.toString());
		
		switch (op) {
		case "1":
			
			break;
		case "2":
					
			break;
		case "3":
			
			break;
		case "4":
			menuPrincipal();
			break;
		default:
			JOptionPane.showMessageDialog(null, "Opção Inválida!");
			break;
		}
	}

	public static void main(String[] args) {
		Passageiro p1 = new Passageiro("Isabela", "345.564.897-90");
		Aviao v1 = new Aviao("Gol", 5, 5);
		v1.setPassageiro(0, 0, p1);
		v1.getPassageiro(0, 0);
		
		v1.verificaLugarOcupado(0, 0);
		
		menuPrincipal();	
	}

}
