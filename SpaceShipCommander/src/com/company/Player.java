package com.company;
import Weapons.Weapon;
import Armors.Armor;

public class Player {
   public int hp;
   public int credits ;
   public Weapon equippedWeapon;
   public Armor equippedArmor;

   public Player(){
   }
   public void ArmorToHealth (){
      hp += equippedArmor.hpBonus;
   }
}
