abstract class Environment implements IAttackable {
  abstract public String name();
  
  public void inflictDamageTo(IDamagable target){
    int targetHealth = target.getHealthLevel();
    target.setHealthLevel(targetHealth - 1);
  }
}