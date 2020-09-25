package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		int opcaoMenu = 1;
		int numNReservaEncontrada;
		int opcaoReserva;

		Scanner scan = new Scanner(System.in);
		Laboratorio laboratorio1 = new Laboratorio(1, 10);
		Laboratorio laboratorio2 = new Laboratorio(2, 20);
		Laboratorio laboratorio3 = new Laboratorio(3, 30);

		Reserva reserva1 = new Reserva("22/10/2020", laboratorio1, true);
		Reserva reserva2 = new Reserva("22/10/2020", laboratorio2, false);
		Reserva reserva3 = new Reserva("22/10/2020", laboratorio3, false);
		Reserva reserva4 = new Reserva("23/10/2020", laboratorio1, true);
		Reserva reserva5 = new Reserva("23/10/2020", laboratorio2, true);
		Reserva reserva6 = new Reserva("23/10/2020", laboratorio3, true);
		Reserva reserva7 = new Reserva("24/10/2020", laboratorio1, false);
		Reserva reserva8 = new Reserva("24/10/2020", laboratorio2, true);
		Reserva reserva9 = new Reserva("24/10/2020", laboratorio3, false);

		List<Reserva> reservas = new ArrayList<Reserva>();
		reservas.add(reserva1);
		reservas.add(reserva2);
		reservas.add(reserva3);
		reservas.add(reserva4);
		reservas.add(reserva5);
		reservas.add(reserva6);
		reservas.add(reserva7);
		reservas.add(reserva8);
		reservas.add(reserva9);

		while (opcaoMenu != 0) {

			System.out.printf("\n\n\n----- Sistema de Reservas de Laboratórios -----\n");
			System.out.printf("1- Reservar Laboratório\n");
			System.out.printf("0- Sair\n");
			System.out.printf("-----------------------------------------\n");
			System.out.printf("Digite a opção desejada: ");
			opcaoMenu = scan.nextInt();

			if (opcaoMenu == 1) {
				numNReservaEncontrada = consultaReserva(reservas);
				if (numNReservaEncontrada != -1) {
					Reserva reservaEncontrada = reservas.get(numNReservaEncontrada);
					System.out.printf("-> Encontramos um laboratório disponível para você! Laboratório número: %d <-\n\n",
							reservaEncontrada.getReservaNumLab());
					System.out.printf("Deseja reservar o laboratório %d para o dia %s ?\n",
							reservaEncontrada.getReservaNumLab(), reservaEncontrada.getDataReserva());
					System.out.printf("1- Reservar\n");
					System.out.printf("0- Sair\n");
					System.out.printf("-----------------------------------------\n");
					System.out.printf("Digite a opção desejada: ");
					opcaoReserva = scan.nextInt();

					if (opcaoReserva != 0) {
						confirmaReserva(reservaEncontrada);
						System.out.println("Laboratório reservado com sucesso!!!");
					}
				} else {
					System.out.printf(
							"Não há laboratórios disponíveis para a data escolhida! Por favor, escolha outra data!\n\n");
				}
			}
		}
		
		System.out.printf("Fim de execução... ");
	}

	public static int consultaReserva(List<Reserva> reservas) {

		String data;
		int qntPessoa;
		Scanner scan = new Scanner(System.in);

		System.out.printf("\n\nInsira a data desejada (ex: 01/01/2001): ");
		data = scan.next();
		System.out.printf("Data informada: %s\n", data);

		System.out.printf("\nInsira a quantidade de pessoas utilizarão o laboratório: ");
		qntPessoa = scan.nextInt();
		System.out.printf("Quantidade de pessoas informada: %s\n\n\n", qntPessoa);

		for (Reserva index : reservas) {
			if (index.getDataReserva().equals(data) && index.getReservaCapacidade() >= qntPessoa
					&& index.getStatusReserva() == false) {
				return reservas.indexOf(index);
			}
		}
		return -1;
	}

	public static void confirmaReserva(Reserva reservaEncontrada) {
		reservaEncontrada.setStatusReserva(true);
	}
}
