package PokemonWorld.Battle;

import PokemonWorld.Pokemons.Pikachu;
import PokemonWorld.Pokemons.Pokemon;
import PokemonWorld.Pokemons.Squirtle;

class Player {
    private String name;
    private Pokemon pokemon;

    Pokemon getPokemon() {
        return pokemon;
    }

    Player(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void pickPikachu(){
        System.out.println("༼ つ ◕_◕ ༽つ Вы выбрали Пикачу! Удачи Вам, пикапика ༼ つ ◕_◕ ༽つ!");
        System.out.println("Список доступных команд для Пикачу: 1 - attack, 2 -  smashTail, 3 - electricTouch, " +
                "4 - charge, 5  - relax");
        System.out.println();
        this.pokemon = new Pikachu();
    }

    void pickSquirtle(){
        System.out.println("༼ つ ◕_◕ ༽つ Вы выбрали Сквиртла! Удачи Вам, бульбульбуль ༼ つ ◕_◕ ༽つ");
        System.out.println("Список доступных команд для Сквиртла:1 - attack, 2 - waterGun, 3 - powerOfOcean, " +
                "4 - shieldOfSea, 5 - relax");
        System.out.println();
        this.pokemon = new Squirtle();
    }
}
