package PokemonWorld.Battle;

import java.util.Scanner;

public class battle {
    private static short benefit1 = 1;
    private static short benefit2 = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Добро пожаловать во вселенную Покемон! Сразитесь друг с другом чтобы узнать лучшего тренера!");

        System.out.println("Тренеры, для начала представьтесь. Имя игрока 1 - ");
        Player player1 = new Player(sc.nextLine());
        System.out.println("Приветствую тебя, " + player1.getName());
        System.out.println("Имя игрока 2 - ");
        Player player2 = new Player(sc.nextLine());
        System.out.println("Приветствую тебя, " + player2.getName());

        System.out.println("Игрок 1, выберете себе покемона (Pikachu, Squirtle)");
        switch (sc.nextLine()) {
            case "Pikachu":
                player1.pickPikachu();
                break;
            case "Squirtle":
                player1.pickSquirtle();
                break;
            default:
                System.out.println("Нет такого покемона");
        }

        System.out.println("Игрок 2, выберете себе покемона(Pikachu,Squirtle)");
        switch (sc.nextLine()) {
            case "Pikachu":
                player2.pickPikachu();
                break;
            case "Squirtle":
                player2.pickSquirtle();
                break;
            default:
                System.out.println("Нет такого покемона.");
        }


        if (player1.getPokemon().getType().equals("Water") && player2.getPokemon().getType().equals("Electric")){
            setBenefit1();
        } else if (player1.getPokemon().getType().equals("Electric") && player2.getPokemon().getType().equals("Water")){
            setBenefit2();
        }

        while (player1.getPokemon().getHealth() != 0 && player2.getPokemon().getHealth() != 0) {
            System.out.println("Здоровье " + player1.getPokemon().getName() +
                    " равно " + player1.getPokemon().getHealth());
            System.out.println("Выносливость " + player1.getPokemon().getName() +
                    " равна " + player1.getPokemon().getStamina());
            System.out.println("-------------------------------------------------");
            System.out.println("Здоровье " + player2.getPokemon().getName() +
                    " равно " + player2.getPokemon().getHealth());
            System.out.println("Выносливость " + player2.getPokemon().getName() +
                    " равна " + player2.getPokemon().getStamina());
            System.out.println();

            System.out.println("Ход " + player1.getName());
            switch (sc.nextLine()) {
                case "1":
                    player2.getPokemon().reduceHealth(player1.getPokemon().baseAttack()*benefit1);
                    break;
                case "2":
                    player2.getPokemon().reduceHealth(player1.getPokemon().specialAttack1()*benefit1);
                    break;
                case "3":
                    player2.getPokemon().reduceHealth(player1.getPokemon().specialAttack2()*benefit1);
                    break;
                case "4":
                    player1.getPokemon().specialSpell();
                    break;
                case "5":
                    player1.getPokemon().relax();
                    break;
                default:
                    System.out.println("Ваш покемон не знает что делать. Такой команды нет. Вы пропускаете ход.");
            }
            if (player2.getPokemon().getHealth()==0){
                break;
            }

            System.out.println();

            System.out.println("Ход " + player2.getName());
            switch (sc.nextLine()) {
                case "1":
                    player1.getPokemon().reduceHealth(player2.getPokemon().baseAttack()*benefit2);
                    break;
                case "2":
                    player1.getPokemon().reduceHealth(player2.getPokemon().specialAttack1()*benefit2);
                    break;
                case "3":
                    player1.getPokemon().reduceHealth(player2.getPokemon().specialAttack2()*benefit2);
                    break;
                case "4":
                    player2.getPokemon().specialSpell();
                    break;
                case "5":
                    player2.getPokemon().relax();
                    break;
                default:
                    System.out.println("Ваш покемон не знает что делать. Такой команды нет. Вы пропускаете ход.");
            }
        }

        if (player1.getPokemon().getHealth()==0) {
            System.out.println("Победитель боя - " + player2.getName() + " и его покемон " + player2.getPokemon().getName());
            System.out.println("Можете принимать поздравления в любом виде!");
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            sc.close();
        } else {
            System.out.println("Победитель боя - " + player1.getName() + " и его покемон " + player1.getPokemon().getName());
            System.out.println("Можете принимать поздравления в любом виде!");
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        }
    }
    private static void setBenefit1() {
        battle.benefit1 = 2;
    }

    private static void setBenefit2() {
        battle.benefit2 = 2;
    }
}
