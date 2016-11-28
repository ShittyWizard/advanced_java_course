package PokemonWorld.Pokemons;

public class Squirtle extends Pokemon {
    boolean isShielded = false;

    public Squirtle() {
        this.setHealth(120);
        this.setName("Squirtle");
        this.setType("Water");
        this.setBaseDamage(8);
        this.setStamina(50);
    }

    @Override
    public int specialAttack1() {
        int damage;
        damage = this.getBaseDamage()*2;
        System.out.println("Ого! " + this.getName() + " стреляет из своих пушек мощные потоками воды по противнику.");
        System.out.println("Нанесено " + damage + " урона.");
        System.out.println();
        this.reduceStamina(15);
        return damage;
    }

    @Override
    public int specialAttack2() {
        int damage;
        damage = this.getBaseDamage()*3;
        System.out.println(this.getName() + " вкладывает всю мощь океана в этот удар. Не повезло тому, кому он адресован.");
        System.out.println("Нанесено " + damage + " урона.");
        System.out.println();
        reduceStamina(20);
        return damage;
    }

    @Override
    public void specialSpell() {
        isShielded = true;
        System.out.println(this.getName() + " только что поставил щит.");
        reduceStamina(10);
    }

    @Override
    public void reduceHealth(int number){
        if (isShielded){
            number = number/2;
        }
        if (this.getHealth() > number){
            this.setHealth(this.getHealth()-number);
        } else {
            setHealth(0);
            System.out.println("Здоровье " + this.getName() + " на нуле.");
        }
    }
}
