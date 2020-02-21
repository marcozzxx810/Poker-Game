# Poker Game

This is a Java designed Poker Game game which mainly use AWT GUI design for design. 

# Game Rule
Rules to determine who has better cards:
1. J, Q, K are regarded as special cards.
1. Rule 1: The one with more special cards wins.
1. Rule 2: If both have the same number of special cards, add the face values of the other card(s) and take the remainder after dividing the sum by 10. The one with a bigger remainder wins. (Note: Ace = 1).
1. Rule 3: The dealer wins if both rule 1 and rule 2 cannot distinguish the winner.

**Restart the game to replay it **

**However this version of the game only allow to play within the same computer, but the server side already support two computer situation, I will release that soon** 

# Requirement

Java 1.8.0+ ( only tested on mac with Java 1.8.0)


# How to run the program

## Setting up the server:

1. javac *.java

1. java MyGui.java
