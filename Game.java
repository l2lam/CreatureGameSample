class Game {
  Creature player1, player2;
  Environment environment;
  
  void startGame() {
    // TODO: Show intro/instructions
    
    // Select a creature (player 1)
    this.player1 = this.selectPlayer("Player 1");
    // Configure the creature
 
    // Select an opopnent (player 2)
    this.player2 = this.selectPlayer("Player 2");
    // Configure the opponent

    // Select an environment
    this.environment = this.selectEnvironment();

    // Start the battle rounds, continue until one creture is defeated
    int round = 1;
    boolean gameOver = false;
    while(!gameOver) {
      // Display game status
      this.updateGameStatus(round);

      // Decide who gets to attack in this round
      // Attack
      this.show(String.format("%s is attacking %s", this.player1.getName(), this.player2.getName()));
      this.player1.inflictDamageTo(this.player2);
      
      // Decide if the environment inflicts damage to the players
      // Inflict damage
      this.show(String.format("The %s is damaging players", this.environment.name()));
      this.environment.inflictDamageTo(this.player1);
      this.environment.inflictDamageTo(this.player2);
      
      // Determine if the game is over
      if (this.player1.isDefeated()) {
        this.show(String.format("%s is defeated!", this.player1.getName()));
        break;
      }
      else if (this.player2.isDefeated()) {
        this.show(String.format("%s is defeated!", this.player2.getName()));
        break;
      }
      
      round++;
    }
  }

  Creature selectPlayer(String name) {
    // TODO let user pick from a selection!
    return new Dragon(name);
  }

  Environment selectEnvironment() {
    // TODO random or let the user pick from a selection!
    return new Desert();
  }

  void updateGameStatus(int round) {
    this.show(String.format("Player 1: %s - %d | Player 2: %s - %d",
                           this.player1.creatureType(), this.player1.getHealthLevel(),
                           this.player2.creatureType(), this.player2.getHealthLevel()));
    this.show(String.format("Environment: %s", this.environment.name()));
    this.show(String.format("Round %d", round));
  }

  void show(String text) {
    System.out.println(text);
  }
}