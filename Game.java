import java.util.Random;

class Game {
  Creature player1, player2;
  Environment environment;

  void startGame() {
    // TODO: Show intro/instructions

    // Select a creature (player 1)
    this.player1 = this.selectPlayer("Gregory");
    // Configure the creature

    // Select an opopnent (player 2)
    this.player2 = this.selectPlayer("Samantha");
    // Configure the opponent

    // Select an environment
    this.environment = this.selectEnvironment();

    // Start the battle rounds, continue until one creture is defeated
    int round = 1;
    while (!this.isGameOver()) {
      // Display game status
      this.updateGameStatus(round);
      this.pause();

      // Do a round of combat
      this.engageCombat();

      // Move to the next round of combat
      round++;
    }
  }

  void engageCombat() {
    // Randomly decide who gets to attack in this round and perform the attack
    if (new Random().nextInt(10) < 5)
      this.performAttack(this.player1, this.player2);
    else
      this.performAttack(this.player2, this.player1);
    this.pause();

    // TODO Decide if the environment inflicts damage to the players
    // Inflict damage by the environment
    this.show(String.format("The %s is damaging players", this.environment.name()));
    this.environment.inflictDamageTo(this.player1);
    this.environment.inflictDamageTo(this.player2);
    this.pause();
  }

  // Perform an attack of p1 on p2
  void performAttack(Creature p1, Creature p2) {
    this.show(String.format("%s is attacking %s", p1.getName(), p2.getName()));
    p1.inflictDamageTo(p2);
    int random = new Random().nextInt(3);
    switch (random) {
      case 0:
        this.show(String.format("%s says take that! %s says ahhh!", p1.getName(), p2.getName()));
        break;
      case 1:
        this.show(String.format("%s takes damage and its health is down to %d!", p2.getName(), p2.getHealthLevel()));
        break;
      default:
        this.show(String.format("%s says \"Darn you %s!\"", p2.getName(), p1.getName()));
        break;
    }
  }

  // Determine if the game is over
  boolean isGameOver() {
    if (this.player1.isDefeated()) {
      this.show(String.format("%s is defeated!", this.player1.getName()));
      return true;
    } else if (this.player2.isDefeated()) {
      this.show(String.format("%s is defeated!", this.player2.getName()));
      return true;
    }
    return false;
  }

  Creature selectPlayer(String name) {
    // TODO let user pick from a selection!
    if (new Random().nextInt(10) < 5)
      return new Dragon(name);
    return new Troll(name);
  }

  Environment selectEnvironment() {
    // TODO random or let the user pick from a selection!
    if (new Random().nextInt(10) < 5)
      return new Desert();
    return new Ocean();
  }

  void updateGameStatus(int round) {
    this.show(String.format("%s: %s - %d | %s: %s - %d",
        this.player1.getName(), this.player1.creatureType(), this.player1.getHealthLevel(),     
        this.player2.getName(), this.player2.creatureType(), this.player2.getHealthLevel()));
    this.show("--------------");
    this.show(String.format("Environment: %s", this.environment.name()));
    this.show(String.format("Round %d", round));
  }

  void show(String text) {
    System.out.println(text);
  }

  void pause() {
    this.pause(1000);
  }

  void pause(int milliseconds) {
    try {
      Thread.sleep(milliseconds);
    } catch (Exception e) {
      this.show(e.toString());
    }
  }
}