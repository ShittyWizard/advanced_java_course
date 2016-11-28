package PokemonWorld.Pokemons;

public abstract class Pokemon {
    private String name;
    private String type;
    private int health;
    private int baseDamage;
    private int stamina;

    Pokemon() {
    }

    public int baseAttack() {
        int damage = 0;
        System.out.println(this.getName() + " ударяет противника");
        this.increaseStamina(5);
        return damage;
    }

    public void relax(){
        this.increaseStamina(20);
    }

    public abstract int specialAttack1();
    public abstract int specialAttack2();
    public abstract void specialSpell();

    public void reduceStamina(int number){
        if (this.stamina > number) {
            this.stamina -= number;
        } else {
            this.stamina = 0;
            System.out.println("Ваша выносливость на нуле! " +
                    "Теперь вы можете использовать лишь обычные удары (1) или отдохнуть(5) и накопить выносливость");
        }
    }

    public void reduceHealth(int number) {
        if (this.getHealth() > number){
            this.health -= number;
        } else {
            setHealth(0);
            System.out.println("Здоровье " + this.getName() + " на нуле.");
        }
    }

    void increaseStamina(int number){
        this.stamina+= number;
    }

    void setStamina(int stamina) {
        this.stamina = stamina;
    }

    void setName(String name) {
        this.name = name;
    }

    void setType(String type) {
        this.type = type;
    }

    void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public int getHealth() {
        return this.health;
    }

    int getBaseDamage() {
        return this.baseDamage;
    }

    public int getStamina() {
        return this.stamina;
    }
}
