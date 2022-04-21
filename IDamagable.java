// Something that is damagable
interface IDamagable {
  // current health
  int getHealthLevel();
  void setHealthLevel(int level);

  // current spirit (whatever that is)
  int getSpiritLevel();
  void setSpiritLevel(int level);

   // current elusivityLevel (whatever that is)
  int getElusivityLevel();
  void setElusivityLevel(int level);
  
  // whether or not the thing is damaged to a defeated state
  boolean isDefeated();
}