package br.com.bytebank.banco.test.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class Teste {

	public static void main(String[] args) {
		Conta cc1 = new ContaCorrente(22, 33);
		Cliente clienteCC1 = new Cliente();
		clienteCC1.setNome("Samuel");
		cc1.setTitular(clienteCC1);
		cc1.deposita(Math.random() * 1000);

		Conta cc2 = new ContaPoupanca(22, 44);
		Cliente clienteCC2 = new Cliente();
		clienteCC2.setNome("Daniela");
		cc2.setTitular(clienteCC2);
		cc2.deposita(Math.random() * 1000);

		Conta cc3 = new ContaCorrente(22, 11);
		Cliente clienteCC3 = new Cliente();
		clienteCC3.setNome("Paulo");
		cc3.setTitular(clienteCC3);
		cc3.deposita(Math.random() * 1000);

		Conta cc4 = new ContaPoupanca(22, 22);
		Cliente clienteCC4 = new Cliente();
		clienteCC4.setNome("Alencar");
		cc4.setTitular(clienteCC4);
		cc4.deposita(Math.random() * 1000);

		List<Conta> lista = new ArrayList<>();
		lista.add(cc1);
		lista.add(cc2);
		lista.add(cc3);
		lista.add(cc4);

		System.out.println("Na ordem em que foi cadastrado;");

		for (Conta conta : lista) {
			System.out.println(conta);
		}

		System.out.println("\nOrdenado por Nome");

		lista.forEach(System.out::println);

		lista.sort(null);
		System.out.println("\nOrdenado pelo Saldo Crescente");

		lista.forEach(System.out::println);

		Collections.reverse(lista);
		System.out.println("\nOrdenado pelo Saldo Decrescente");

		lista.forEach(System.out::println);

		int[] nums = new int[] { 43, 15, 64, 22, 89 };
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));

		lista.sort((c1, c2) -> Integer.compare(c1.getNumero(), c2.getNumero()));

		System.out.println("\nOrdenado por Número");

		for (Conta conta : lista) {
			System.out.println(conta);
		}

		Comparator<Conta> comp = (Conta c1, Conta c2) -> {
			String nomeC1 = c1.getTitular().getNome();
			String nomeC2 = c2.getTitular().getNome();
			return nomeC1.compareTo(nomeC2);
		};

		lista.sort(comp);
		System.out.println("\nlistando com Consumer");

		lista.forEach((t) -> System.out.println(t.getTitular().getNome() + ", " + t));

	}
}
