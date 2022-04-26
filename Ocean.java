class Ocean extends Environment{
  public String name() {
    return "Ocean";
  }

  @Override
  public void inflictDamageTo(IDamagable target) {
    int targetHealth = target.getHealthLevel();
    int spirit = target.getSpiritLevel();
    target.setHealthLevel(targetHealth - 100 + spirit);
  }
}