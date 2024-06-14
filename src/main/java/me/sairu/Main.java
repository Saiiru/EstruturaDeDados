package me.sairu;

import me.sairu.vector.HeroesArray;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final int SIZE = 5;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HeroesArray justiceLeague = new HeroesArray(SIZE);
        int op;
        do {
            System.out.println("======== Menu ===========");
            System.out.println("1. Add");
            System.out.println("2. Print");
            System.out.println("3. Remove");
            System.out.println("4. Exit");
            System.out.println("==========================");
            op = scanner.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Digite o heroi a inserir: ");
                    scanner.nextLine();
                    String hero = scanner.nextLine();
                    justiceLeague.add(hero);
                    break;
                case 2:
                    System.out.println("Lista de herois registrados na liga: ");
                    justiceLeague.print();
                    break;
                case 3:
                    System.out.println("Digite o heroi a remover: ");
                    int index = scanner.nextInt();
                    justiceLeague.remove(index);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção errada, tente novamente");
            }
        } while (op != 4);

        scanner.close();
    }
}