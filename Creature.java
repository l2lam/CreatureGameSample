abstract class Creature implements IDamagable, IAttackable {
  String name;
  public String getName() {
    return this.name;
  }

  Creature(String name) {
    this.name = name;
  }

  abstract public String creatureType();

  int health = 100;
  public int getHealthLevel() {
    return this.health;
  }
  public void setHealthLevel(int level) {
    this.health = level;
  }
 
  int spirit = 100;
  public int getSpiritLevel() {
    return this.spirit;
  }
  public void setSpiritLevel(int level) {
    this.spirit = level;
  }

  int elusivity = 100;
  public int getElusivityLevel() {
    return this.elusivity;
  }
  public void setElusivityLevel(int level) {
    this.elusivity = level;
  }

  public boolean isDefeated() {
    return this.health < 10;
  }

  public void inflictDamageTo(IDamagable target){
    int targetHealth = target.getHealthLevel();
    int elusivityDifference = this.elusivity - target.getElusivityLevel();
    int spiritDifference = this.spirit - target.getSpiritLevel();
    target.setHealthLevel(targetHealth - 10 + elusivityDifference + spiritDifference);
  }
}