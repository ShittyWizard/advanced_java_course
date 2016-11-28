package PokemonWorld.Pokemons;

public class Pikachu extends Pokemon{
    private boolean isCharged = false;

    public Pikachu() {
        this.setHealth(100);
        this.setName("Pikachu");
        this.setType("Electric");
        this.setBaseDamage(10);
        this.setStamina(50);
    }

    @Override
    public int specialAttack1() {
        int damage;
        if (isCharged){
            damage = this.getBaseDamage()*3*2;
        } else {
            damage = this.getBaseDamage()*3;
        }
        System.out.println("Вау! " + this.getName() + " только что ударил хвостом и молнией своего противника.");
        System.out.println("Нанесено " + damage + " урона.");
        System.out.println();
        this.reduceStamina(15);
        return damage;
    }

    @Override
    public int specialAttack2() {
        int damage;
        if (isCharged){
            damage = this.getBaseDamage()*4*2;
        } else {
            damage = this.getBaseDamage()*4;
        }
        System.out.println("Вот это приём! " + this.getName() +
                " направил всю свою электрическую энергию в этот удар! Фантастика!" +
                " Можно лишь посочувствовать сопернику");
        System.out.println("Нанесено " + damage + " урона.");
        System.out.println();
        this.reduceStamina(20);
       return damage;
    }

    @Override
    public void specialSpell(){
        this.isCharged = true;
        System.out.println(this.getName() + " зарядился силой молний и готов");
        this.reduceStamina(10);
    }

}