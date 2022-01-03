package adventureGame;

import java.util.Random;
import java.util.Scanner;

public class Game {

    int healthPotionHealAmount = 30;
    int healthPotionDropChance = 50; // percentage
    Scanner scan = new Scanner(System.in);

    public void start() {
        boolean running = true;
        Random random = new Random();

        System.out.println("Welcome to the Dungeon, Sinbad!!");

        GAME: // continue label
        while (running) {
            System.out.println("-----------------------------------------");

            String enemy = Enemy.enemies[random.nextInt(Enemy.enemies.length)];
            int enemyHealth = random.nextInt(Enemy.maxEnemyHealth);
            System.out.println("\t# " + enemy + " has appeared! #\n");  // # VIRUZ has appeared! #

            while (enemyHealth > 0) {
                System.out.println("\tYour HP: " + Player.health);
                System.out.println("\tYou have " + Player.numHealthPotions + " health potions.");
                System.out.println("\tScore: " + Player.score);
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\tWhat would you like to do, Sinbad?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink health potion");
                System.out.println("\t3. Run!");

                int input = scan.nextInt();

                if (input == 1) {
                    int damageDealt = random.nextInt(Player.attackDamage);
                    int damageTaken = random.nextInt(Enemy.enemyAttackDamage);

                    enemyHealth -= damageDealt;
                    Player.health -= damageTaken;

                    System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage.");
                    System.out.println("\t> You receive " + damageTaken + " in retaliation!");

                    if (Player.health < 1) {
                        System.out.println("\t> You have taken too much damage, you are too weak to go on!");
                        break;
                    }
                }

                else if (input == 2) {
                    
                    if (Player.numHealthPotions > 0) {
                        Player.health += healthPotionHealAmount;
                        Player.numHealthPotions--;
                        System.out.println("\t> You drank a health potion, healing yourself for " + healthPotionHealAmount
                                + "\n\t> You now have " + Player.health + " HP."
                                + "\n\t> You have " + Player.numHealthPotions + " health potions left.\n");
                    }

                    else {
                        System.out.println("\t> You have no health potions left! Defeat enemies for a chance to get one!");
                    }
                }

                else if (input == 3) {
                    System.out.println("\tYou ran away from the " + enemy + "!");
                    continue GAME;
                }

                else {
                    System.out.println("\tInvalid command!");
                }
            }

            if (Player.health < 1) {
                System.out.println("You limp out of the dungeon, weak from battle.");
                break;
            }

            Player.score++;

            System.out.println("-----------------------------------------");
            System.out.println(" # " + enemy + " was defeated! #");
            System.out.println(" # You have " + Player.health + " HP left. #");
            System.out.println(" # Your score is: " + Player.score + " #");

            if (random.nextInt(100) < healthPotionDropChance) { //   random.nextInt(100)  Returns a number between 0-99
                Player.numHealthPotions++;
                System.out.println(" # The " + enemy + " dropped a health potion! # ");
                System.out.println(" # You now have " + Player.numHealthPotions + " health potion(s). # ");
            }

            System.out.println("-----------------------------------------");
            System.out.println("What would you like to do now, Sinbad?");
            System.out.println("1. Continue ");
            System.out.println("2. Leave the dungeon");
            System.out.println("Your score: " + Player.score);

            String input = "0";

            while (!input.equals("1") && !input.equals("2")) {
                input = scan.nextLine();
            }


            if (input.equals("1")) {
                System.out.println("You continue on your adventure, Sinbad!");
            }

            else {
                System.out.println("You left the dungeon, successful for your adventures, Sinbad!");
                break;
            }
        }
    }
    // --------------------------------------------------------------------

    public void endOfGame() {

        System.out.println("##################");
        System.out.println("# Score: " + Player.score + " #");
        System.out.println("# THANKS FOR PLAYING! #");
        System.out.println("##################");
    }
    }

