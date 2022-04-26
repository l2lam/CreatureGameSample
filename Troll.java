class Troll extends Creature {
  Troll(String name) {
    super(name);
  }

  public String creatureType() {
    return "Troll";
  }

  @Override
  public boolean isDefeated() {
      return this.getHealthLevel() < 25;
  }
}