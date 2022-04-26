class Dragon extends Creature {
  Dragon(String name) {
    super(name);
  }

  public String creatureType() {
    return "Dragon";
  }
  
  @Override
  public void inflictDamageTo(IDamagable target){
    int targetHealth = target.getHealthLevel();
    target.setHealthLevel(targetHealth - 20);
  }
}