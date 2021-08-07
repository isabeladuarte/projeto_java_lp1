package br.com.isabela.guilherme.projeto;

import java.util.ArrayList;
import java.util.Optional;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Principal {
	
	static ArrayList<Voo> voos = new ArrayList<Voo>(); // static vai ter a mesma instância
	static ArrayList<Aviao> avioes = new ArrayList<Aviao>();

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
	
	public static void parametroSistema() {
		String menu = new String("1 - Cadastrar Aeronave\n2 - Cadastrar Voo\n3 - Voltar");
		
		String op = JOptionPane.showInputDialog(menu.toString());
		
		switch (op) {
		case "1":
			Aeronave av = new Aeronave(JOptionPane.showInputDialog("Digite o modelo da aeronave: "));
			System.out.println(av.toString());
			
			int numeroTotalfileiras = Integer.parseInt(JOptionPane.showInputDialog("Digite o número total de fileiras no avião: "));
			int totalAssentoPorFileira = Integer.parseInt(JOptionPane.showInputDialog("Digite o número total de assento por fileira: "));
			
			Aviao aviao = new Aviao(av.getModelo(), numeroTotalfileiras, totalAssentoPorFileira);
			aviao.setIdAviao(avioes.size() + 1); // Setando id para cada avião
			avioes.add(aviao);
			System.out.println(aviao.toString());
			
			parametroSistema();
			
			break;
		case "2":
			int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do avião: "));
						
			Aviao aviaoEncontrado = BuscarAviaoPorId(id);
			
			if (aviaoEncontrado == null) {
				JOptionPane.showMessageDialog(null, "Por favor, cadastre uma aeronave!");
			} else {
				int nro = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do voo: "));
				String data = JOptionPane.showInputDialog("Digite a data: ");
				String hora = JOptionPane.showInputDialog("Digite a hora: ");	
				
				Voo voo = new Voo(aviaoEncontrado, nro, data, hora);
				voos.add(voo);
				System.out.println(voo.toString());	
			}
			
			parametroSistema();

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
			String nome = JOptionPane.showInputDialog("Digite o nome: ");
			String cpf = JOptionPane.showInputDialog("Digite o cpf: ");
			
			Passageiro p1 = new Passageiro(nome, cpf);
			System.out.println(p1.toString());
			
			int idAviao = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do avião: "));
			
			Aviao aviaoEncontrado = BuscarAviaoPorId(idAviao);
			
			if (aviaoEncontrado == null) {
				JOptionPane.showMessageDialog(null, "Por favor, cadastre um avião!");
			} else {
				boolean lugarOcupado = false;
				do {
					int fileira = Integer.parseInt(JOptionPane.showInputDialog("Digite a fileira: "));
					int assento = Integer.parseInt(JOptionPane.showInputDialog("Digite o assento: "));
					
					lugarOcupado = aviaoEncontrado.verificaLugarOcupado(fileira, assento);
					
					if (lugarOcupado) { 
						JOptionPane.showMessageDialog(null, "Este lugar está ocupado!");
					} else {
						try {
							aviaoEncontrado.setPassageiro(fileira, assento, p1);
							aviaoEncontrado.getPassageiro(fileira, assento);	
							JOptionPane.showMessageDialog(null, "Lugar reservado com sucesso!");
						} catch (Exception error){
							JOptionPane.showMessageDialog(null, "Lugar não existe!");
						}
					}
					
					System.out.println(aviaoEncontrado.getPassageiro(fileira, assento).toString());
					
				} while (lugarOcupado);
			}
			
			reservaPassagens();
			
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
	
	private static Aviao BuscarAviaoPorId(int id) {
		return avioes.stream().filter(a -> a.getIdAviao() == id).findFirst().orElse(null); //filter(predicate), stream() - É uma API para facilitar o trabalho com arraylist
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
