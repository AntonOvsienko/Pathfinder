package com.anton;

public class PlayerInitialized {
    public static int[] character(){
        int[] temp=new int[]{10,10,10,10,10,10};
        System.out.println("У вас есть лишних 15 очков, по умолчанию все характеристики равны" +
                "10 вы вольны изменить их согласно таблице, но не меньше 7 и не больше 18");
        System.out.print("Сила: \n Ловкость");
        "\nЛов: " + getDexterity() +
                "\nВын: " + getCostitution() +
                "\nИнт: " + getIntellegence() +
                "\nМуд: " + getWisdom() +
                "\nХар: ");

    }
}
