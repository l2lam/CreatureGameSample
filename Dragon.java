class Dragon extends Creature {
  String name;
  Dragon(String name) {
    this.name = name;
  }
  public String getName() {
    return this.name;
  }
  public String creatureType() {
    return "Dragon";
  }
  
  public void inflictDamageTo(IDamagable target){
    int targetHealth = target.getHealthLevel();
    target.setHealthLevel(targetHealth - 20);
  }
}