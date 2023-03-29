package Levels;

import java.util.Random;
import java.util.Scanner;

public class Introduction {
    public void level0(Wizard wizard) {
        int money = wizard.getMoney();

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String Name_Text = "Greetings young wizard, what is your name ?";
        System.out.print(Name_Text);

        String name = scanner.nextLine();

        System.out.print("Pleased to meet you, " + name + "." + "\n Welcome to Hogwarts and may your adventure there go smoothly :)");

        String Wand_Text = "We'll start by creating a wand for you.";
        System.out.print(Wand_Text);

        Wand wand1 = new Wand();
        Core core1 = wand1.getCore();

        Core core;
        Wand wand;
        do {
            wand = new Wand();
            core = wand.getCore();
        } while (core == core1);

        int size = wand.getSize();


        wizard.setName(name);
        wizard.setPet(petChosen);
        wizard.setWand(wand);
        wizard.setHouse(characterHouse);
    }
}
