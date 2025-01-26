package com.company;
import Armors.Armor;
import Armors.Armor_EnergizedPlates;
import Armors.Armor_SteelPlates;
import Weapons.Weapon;
import Weapons.Weapon_AntimatterBlaster;
import Weapons.Weapon_FragmentationCannon;
import Weapons.Weapon_PhotonGun;
import java.util.Random;
import java.util.Scanner;

public class Actions {
    Player player = new Player();
    Scanner scanner = new Scanner(System.in);
    PirateBoss pirateBoss = new PirateBoss();
    Random random = new Random();
    Weapon weapon = new Weapon();
    Armor armor = new Armor();

    public Actions() {
    }
    public void introduction() {
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------Welcome Commander-------------------");
        System.out.println(" Your ship is currently landed on Earth A1 station");
        System.out.println("-----------------------------------------------------");
        playerDefaultSetup();
    }

    public void playerDefaultSetup() {
        player.hp = 100;
        player.credits = 50;
        player.equippedWeapon = null;
        bossDefaultSetup();
    }

    public void bossDefaultSetup() {
        pirateBoss.hp = 120;
        pirateBoss.damage = random.nextInt(15) + 8;
        hangarOptions();
    }

    public void hangarOptions() {
        System.out.println("You are currently at main hangar");
        System.out.println("---------------------------------------------");
        System.out.println("1:Weapon shop");
        System.out.println("2:Armor shop");
        System.out.println("3:Ship details");
        System.out.println("4:Receive mission");
        System.out.println("5:Fly to space");
        System.out.println("---------------------------------------------");
        String selectHangarOption = scanner.nextLine();
        if (selectHangarOption.equals("1")) {
            this.weaponShop();
        }
        else if (selectHangarOption.equals("2")) {
            this.armorShop();
        }
        else if (selectHangarOption.equals("3")) {
            this.shipDetails();
        }
        else if (selectHangarOption.equals("4")) {
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------" + "\n");
            System.out.println("*You walk to the fleet admiral to request orders and salute him*");
            System.out.println("*The fleet admiral salutes back and explains your mission*");
            System.out.print("- We have picked up several distress signals from Fomalhaut and Arcturus systems.");
            System.out.println("Our radars cannot identify the type of the aggressors, neither what they after.");
            System.out.print("Your orders are to initiate hyper jump to this sectors and perform a reconnaissance.");
            System.out.println("Also make sure your ship is well equipped with everything needed.");
            System.out.println("Good luck commander. The fleet counts on you!" + "\n");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Type anything to continue");
            String returnToHangar = scanner.nextLine();
            this.hangarOptions();
        }
        else if (selectHangarOption.equals("5")) {
            if (weapon.weaponCount >= 0)
                solSystem();

        } else if (!selectHangarOption.equals("1") && !selectHangarOption.equals("2") && !selectHangarOption.equals("3") && !selectHangarOption.equals("4") && !selectHangarOption.equals("5")) {
            System.out.println("Wrong input...returning to hangar");
            System.out.println("---------------------------------------------");
            this.hangarOptions();
        }

    }

    public void weaponShop() {
        System.out.println("1:Photon gun (+10 damage) - 20 Credits");
        System.out.println("2:Fragmentation Cannon (+13 damage) - 35 Credits");
        System.out.println("3:Antimatter Blaster (+17 damage) - 50 Credits");
        System.out.println("4:Return to hangar");
        System.out.println("Note:You can equip only one cannon at a time");
        String weaponChoice = scanner.nextLine();

        if (weaponChoice.equals("1") && player.credits >= 20) {
            player.equippedWeapon = new Weapon_PhotonGun();
            player.credits -= player.equippedWeapon.price;
            weapon.weaponCount++;
            System.out.println("---------------------------------------------");
            System.out.println("Cannon Equipped");
            System.out.println("---------------------------------------------");
            System.out.println("Type anything to return to Hangar");
            System.out.println("---------------------------------------------");
            String returnToHangar = scanner.nextLine();
            this.hangarOptions();
        }
        else if (weaponChoice.equals("2") && player.credits >= 35) {
            player.equippedWeapon = new Weapon_FragmentationCannon();
            player.credits -= player.equippedWeapon.price;
            weapon.weaponCount++;
            System.out.println("---------------------------------------------");
            System.out.println("Cannon Equipped");
            System.out.println("---------------------------------------------");
            System.out.println("Type anything to return to Hangar");
            System.out.println("---------------------------------------------");
            String returnToHangar = scanner.nextLine();
            this.hangarOptions();
        }
        else if (weaponChoice.equals("3") && player.credits >= 50) {
            player.equippedWeapon = new Weapon_AntimatterBlaster();
            player.credits -= player.equippedWeapon.price;
            weapon.weaponCount++;
            System.out.println("---------------------------------------------");
            System.out.println("Cannon Equipped");
            System.out.println("---------------------------------------------");
            System.out.println("Type anything to return to Hangar");
            System.out.println("---------------------------------------------");
            String returnToHangar = scanner.nextLine();
            this.hangarOptions();
        }
        else if (weaponChoice.equals("4")) {
            this.hangarOptions();
        }
        else if (!weaponChoice.equals("1") && !weaponChoice.equals("2") && !weaponChoice.equals("3") && !weaponChoice.equals("4")){
            System.out.println("---------------------------------------------");
            System.out.println("Error...returning to Weapon shop");
            System.out.println("---------------------------------------------");
            this.weaponShop();
        }
        else if(weaponChoice.equals("1") && player.credits <20) {
            System.out.println("---------------------------------------------");
            System.out.println("Insufficient credits");
            System.out.println("---------------------------------------------");
            weaponShop();
        }
        else if(weaponChoice.equals("2") && player.credits <35) {
            System.out.println("---------------------------------------------");
            System.out.println("Insufficient credits");
            System.out.println("---------------------------------------------");
            weaponShop();
        }
        else if(weaponChoice.equals("3") && player.credits <50) {
            System.out.println("---------------------------------------------");
            System.out.println("Insufficient credits");
            System.out.println("---------------------------------------------");
            weaponShop();
        }
    }

    public void armorShop() {
        System.out.println("1:Steel Plates Reinforcement (+20 HP) - 15 Credits");
        System.out.println("2:Energized Plates Reinforcement (+50 HP) - 25 credits ");
        System.out.println("3:Return to hangar");
        System.out.println("Note:Armor of same type can stack");
        String armorChoice = scanner.nextLine();

        if (armorChoice.equals("1") && player.credits >= 15) {
            player.equippedArmor = new Armor_SteelPlates();
            player.credits -= player.equippedArmor.price;
            armor.armorCount++;
            player.ArmorToHealth();
            System.out.println("---------------------------------------------");
            System.out.println("Armor Equipped");
            System.out.println("---------------------------------------------");
            System.out.println("Type anything to return to Hangar");
            System.out.println("---------------------------------------------");
            String returnToHangar2 = scanner.nextLine();
            this.hangarOptions();

        }
        else if (armorChoice.equals("2") && player.credits >= 25) {
            player.equippedArmor = new Armor_EnergizedPlates();
            player.credits -= player.equippedArmor.price;
            armor.armorCount++;
            player.ArmorToHealth();
            System.out.println("---------------------------------------------");
            System.out.println("Armor Equipped");
            System.out.println("---------------------------------------------");
            System.out.println("Type anything to return to Hangar");
            System.out.println("---------------------------------------------");
            String returnToHangar = scanner.nextLine();
            this.hangarOptions();
        }
        else if (armorChoice.equals("3")) {
            this.hangarOptions();
        }
        else if (!armorChoice.equals("1") && !armorChoice.equals("2") && !armorChoice.equals("3"))  {
            System.out.println("---------------------------------------------");
            System.out.println("Error...returning to Armor Shop");
            System.out.println("---------------------------------------------");
            this.armorShop();
        }
        else if(armorChoice.equals("1") && player.credits <15) {
            System.out.println("---------------------------------------------");
            System.out.println("Insufficient credits");
            System.out.println("---------------------------------------------");
            armorShop();
        }
        else if(armorChoice.equals("2") && player.credits <25) {
            System.out.println("---------------------------------------------");
            System.out.println("Insufficient credits");
            System.out.println("---------------------------------------------");
            armorShop();
        }
    }

    public void shipDetails() {
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("---------------------------------------------");
        System.out.println("Ship health is: " + player.hp);
        System.out.println("Your credits are: " + player.credits);
        System.out.println("---------------------------------------------");
        System.out.println("Ship Scanner is online");
        System.out.println("---------------------------------------------");
        System.out.println("Ship cannon equipped:");
        if (weapon.weaponCount > 0) {
            System.out.println(player.equippedWeapon.name);
        }
        System.out.println("---------------------------------------------");
        System.out.println("Ship Armor Reinforcement equipped:");
        if (armor.armorCount > 0) {
            System.out.println(player.equippedArmor.name);
        }
        System.out.println("---------------------------------------------");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("Type anything to return to Hangar");
        String returnToHangar = scanner.nextLine();
        this.hangarOptions();
    }

    public void solSystem() {
        System.out.println("---------------------------------------------");
        System.out.println("You are currently in sol system");
        System.out.println("---------------------------------------------");
        System.out.println("1:Land at station");
        System.out.println("2:Initiate hyperspace jump to 'Procyon system'");
        System.out.println("3:Initiate hyperspace jump to 'Fomalhaut system'");
        System.out.println("4:Initiate hyperspace jump to 'Altair system'");
        System.out.println("5:Initiate hyperspace jump to 'Arcturus system'");
        String chooseOption = scanner.nextLine();
        if (chooseOption.equals("1")) {
            hangarOptions();
        }
        else if (chooseOption.equals("2")) {
            System.out.println("---------------------------------------------");
            System.out.println("Initiating hyper jump");
            procyonSystem();
        }
        else if (chooseOption.equals("3")) {
            System.out.println("---------------------------------------------");
            System.out.println("Initiating hyper jump");
            fomalhautSystem();
        }
        else if (chooseOption.equals("4")) {
            System.out.println("---------------------------------------------");
            System.out.println("Initiating hyper jump");
            altairSystem();
        }
        else if (chooseOption.equals("5")) {
            System.out.println("---------------------------------------------");
            System.out.println("Initiating hyper jump");
            arcturusSystem();
        }
        else if (!chooseOption.equals("1") && !chooseOption.equals("2") && !chooseOption.equals("3") && !chooseOption.equals("4") && !chooseOption.equals("5")) {
            System.out.println("Wrong input");
            solSystem();
        }
    }

    public void procyonSystem() {
        System.out.println("---------------------------------------------");
        System.out.println("You are currently in Procyon system");
        System.out.println("---------------------------------------------");
        System.out.println("1:Scan system");
        System.out.println("2:Initiate hyper jump to 'Sol system'");
        System.out.println("3:Initiate hyper jump to 'Fomalhaut system'");
        System.out.println("4:Initiate hyper jump to 'Altair system'");
        System.out.println("5:Initiate hyper jump to 'Arcturus system'");
        String chooseOption = scanner.nextLine();

        if (chooseOption.equals("1")) {
            System.out.println("*You order for complete scan of the system but your ship doesn't detect anything unusual" + "\n" + "*Your crew is awaiting orders*");
            System.out.println("Type any key to proceed");
            String returnToSystem = scanner.nextLine();
            procyonSystem();
        }
        else if (chooseOption.equals("2")) {
            System.out.println("---------------------------------------------");
            System.out.println("Initiating hyper jump");
            solSystem();
        }
        else if (chooseOption.equals("3")) {
            System.out.println("---------------------------------------------");
            System.out.println("Initiating hyper jump");
            fomalhautSystem();
        }
        else if (chooseOption.equals("4")) {
            System.out.println("---------------------------------------------");
            System.out.println("Initiating hyper jump");
            altairSystem();
        }
        else if (chooseOption.equals("5")) {
            System.out.println("---------------------------------------------");
            System.out.println("Initiating hyper jump");
            arcturusSystem();
        }
        else if (!chooseOption.equals("1") && !chooseOption.equals("2") && !chooseOption.equals("3") &&! chooseOption.equals("4") &&! chooseOption.equals("5")) {
            System.out.println("Wrong input");
            procyonSystem();
        }
    }

    public void fomalhautSystem() {
        System.out.println("---------------------------------------------");
        System.out.println("You are currently in Fomalhaut system");
        System.out.println("---------------------------------------------");
        System.out.println("1:Scan system");
        System.out.println("2:Initiate hyper jump to 'Sol system'");
        System.out.println("3:Initiate hyper jump to 'Procyon system'");
        System.out.println("4:Initiate hyper jump to 'Altair system'");
        System.out.println("5:Initiate hyper jump to 'Arcturus system'");
        String chooseOption = scanner.nextLine();
        if (chooseOption.equals("1")) {
            System.out.println("*Initiating complete scan of the system*");
            System.out.print("*You receive signal from a black box from a ship of some origin.");
            System.out.println("Your crew locate the ship and ask if they should approach and investigate the wreckage*");
            System.out.println("-What are you orders Commander *Asks the executive officer*");
            System.out.println("1:Approach the ship");
            System.out.println("2:Avoid the wreckage and leave");
            String investigateWreckage = scanner.nextLine();
            if (investigateWreckage.equals("1")) {
                System.out.println("*You approach the wreckage which seems to be a military ship.*");
                System.out.println("*The destroyed ship transponder matches our fleet frequency* ");
                System.out.println("Type any key to continue");
                String returnToSystem = scanner.nextLine();
                fomalhautSystem();
            }
            else if (investigateWreckage.equals("2")) {
                System.out.println("*You decide to leave the wreckage and carry on*");
                System.out.println("Type any key to continue");
                String returnToSystem = scanner.nextLine();
                fomalhautSystem();
            }
            else if (!investigateWreckage.equals("1") && !investigateWreckage.equals("2")) {
                System.out.println("Wrong input");
                fomalhautSystem();
            }
        }
        if (chooseOption.equals("2")) {
            System.out.println("---------------------------------------------");
            System.out.println("Initiating hyper jump");
            solSystem();
        }
        else if (chooseOption.equals("3")) {
            System.out.println("---------------------------------------------");
            System.out.println("Initiating hyper jump");
            procyonSystem();
        }
        else if (chooseOption.equals("4")) {
            System.out.println("---------------------------------------------");
            System.out.println("Initiating hyper jump");
            altairSystem();
        }
        else if (chooseOption.equals("5")) {
            System.out.println("---------------------------------------------");
            System.out.println("Initiating hyper jump");
            arcturusSystem();
        }
        else if (!chooseOption.equals("1") && !chooseOption.equals("2") && !chooseOption.equals("3") && !chooseOption.equals("4") && !chooseOption.equals("5")) {
            System.out.println("Wrong input");
            fomalhautSystem();
        }
    }

    public void altairSystem() {
        System.out.println("---------------------------------------------");
        System.out.println("You are currently in Altair system");
        System.out.println("---------------------------------------------");
        System.out.println("1:Scan system");
        System.out.println("2:Initiate hyper jump to 'Sol system'");
        System.out.println("3:Initiate hyper jump to 'Procyon system'");
        System.out.println("4:Initiate hyper jump to 'Fomalhaut system'");
        System.out.println("5:Initiate hyper jump to 'Arcturus system'");
        String chooseOption = scanner.nextLine();
        if (chooseOption.equals("1")) {
            System.out.println("*You order for complete scan of the system but your ship doesn't detect anything unusual" + "\n" + "*Your crew is awaiting orders*");
            System.out.println("Type any key to proceed");
            String typeAnyKey = scanner.nextLine();
            altairSystem();
        }
        else if (chooseOption.equals("2")) {
            System.out.println("---------------------------------------------");
            System.out.println("Initiating hyper jump");
            solSystem();
        }
        else if (chooseOption.equals("3")) {
            System.out.println("---------------------------------------------");
            System.out.println("Initiating hyper jump");
            procyonSystem();
        }
        else if (chooseOption.equals("4")) {
            System.out.println("---------------------------------------------");
            System.out.println("Initiating hyper jump");
            fomalhautSystem();
        }
        else if (chooseOption.equals("5")) {
            System.out.println("---------------------------------------------");
            System.out.println("Initiating hyper jump");
            arcturusSystem();
        }
        else if (!chooseOption.equals("1") && !chooseOption.equals("2") && !chooseOption.equals("3") &&! chooseOption.equals("4") &&! chooseOption.equals("5")){
            System.out.println("Wrong input");
            altairSystem();
        }
    }

    public void arcturusSystem() {
        System.out.println("---------------------------------------------");
        System.out.println("You are currently in Arcturus system");
        System.out.println("---------------------------------------------");
        System.out.println("1:Scan system");
        System.out.println("2:Initiate hyper jump to 'Sol system'");
        System.out.println("3:Initiate hyper jump to 'Procyon system'");
        System.out.println("4:Initiate hyper jump to 'Fomalhaut system'");
        System.out.println("5:Initiate hyper jump to 'Altair system'");
        String chooseOption = scanner.nextLine();


        if (chooseOption.equals("1")) {
            System.out.println("---------------------------------------------");
            System.out.println("*Initiating complete scan of the system*");
            System.out.println(".........................................");
            System.out.println("* Radars detect a big target thrusting in our direction.It appears to be a ship of unknown origin *");
            System.out.println("* Executive officer sets alert through the whole ship and awaits your orders *");
            System.out.println(".........................................");
            System.out.println("1:Prepare all cannon batteries for fire");
            System.out.println("2:Execute emergency jump back to Sol system");
            String combatOption = scanner.nextLine();

            if (chooseOption.equals("1") && weapon.weaponCount <= 0) {
                System.out.println("-You order your ship in fighting stance while having no active cannons which results in your doom-");
                gameOver();
            }
            else if (combatOption.equals("1") && weapon.weaponCount > 0) {
                System.out.println("---------------------------------------------");
                System.out.println("--Ship is in range--" + "" + "\n" + "--Cannons are ready to fire--");
                System.out.println("---------------------------------------------");
                arcturusCombat();
            }
            else if (combatOption.equals("2")) {
                System.out.println("---------------------------------------------");
                System.out.println("*You commence emergency jump and enter hyper space*");
                System.out.println("Type any key to continue");
                String continue1 = scanner.nextLine();
                solSystem();
            }
            else if (!combatOption.equals("1") && !combatOption.equals("2")) {
                System.out.println("---------------------------------------------");
                System.out.println("Wrong input");
                arcturusSystem();
            }
        }
        else if (chooseOption.equals("2")) {
            System.out.println("---------------------------------------------");
            System.out.println("Initiating hyper jump");
            solSystem();
        }
        else if (chooseOption.equals("3")) {
            System.out.println("---------------------------------------------");
            System.out.println("Initiating hyper jump");
            procyonSystem();
        }
        else if (chooseOption.equals("4")) {
            System.out.println("---------------------------------------------");
            System.out.println("Initiating hyper jump");
            fomalhautSystem();
        }
        else if (chooseOption.equals("5")) {
            System.out.println("---------------------------------------------");
            System.out.println("Initiating hyper jump");
            altairSystem();
        }
        else if(!chooseOption.equals("1") && !chooseOption.equals("2") && !chooseOption.equals("3") && !chooseOption.equals("4") && !chooseOption.equals("5")) {
            arcturusSystem();
        }
    }

    public void arcturusCombat() {
        System.out.println("1:Fire");
        System.out.println("2:Execute emergency jump back to Sol system");
        String combatChoice = scanner.nextLine();
        if (combatChoice.equals("1")) {
            attack();
        }
        else if (combatChoice.equals("2")) {
            System.out.println("---------------------------------------------");
            System.out.println("*You commence emergency jump and enter hyper space*");
            System.out.println("Type any key to continue");
            String continue1 = scanner.nextLine();
            solSystem();
        }
        else if (!combatChoice.equals("1") && !combatChoice.equals("2")){
            arcturusCombat();
        }
    }

    public void attack() {
        pirateBoss.hp = pirateBoss.hp - player.equippedWeapon.damage;
        System.out.println("---------------------------------------------");
        System.out.println("--Our cannons landed successful hits on the target-- " + "\n"  + player.equippedWeapon.damage + " Damage inflicted" +"\n" + "Enemy Hp:" + pirateBoss.hp);
        System.out.println("---------------------------------------------");
        if (pirateBoss.hp <= 0) {
            System.out.println("--You have defeated your target and completed your mission commander!--");
            gameOver();
        }
        else if(pirateBoss.hp > 0){
            receiveDamage();
        }
    }

    public void receiveDamage() {
        player.hp -= pirateBoss.damage;
        System.out.println("---------------------------------------------");
        System.out.println("--Enemy fires at our ship inflicting heavy damage-- " + "\n" + pirateBoss.damage + " Damage inflicted " + "\n" + "Your hp:" + player.hp);
        System.out.println("---------------------------------------------");
        if (player.hp <= 0) {
            System.out.println("--Your ship have been destroyed--");
            gameOver();
        }
        else if (player.hp > 0) {
            arcturusCombat();
        }
    }
    public void gameOver() {
        System.out.println("Game Over");
    }
}