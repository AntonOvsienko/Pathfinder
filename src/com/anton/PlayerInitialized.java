package com.anton;

import com.anton.ClassPlayer.Warior;

import java.io.*;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class PlayerInitialized {
    static Scanner scanner=new Scanner(System.in);
    static int bonuspoint=15;
    static int number=0;
    static int[] temp=new int[]{10,10,10,10,10,10};

    public static Player initialized() throws IOException, ClassNotFoundException {
        Player men;
        boolean exit;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Введите имя персонажа");
        String name=scanner.nextLine();
        do{
            exit=true;

            System.out.println("Выбрать созданного персонажа (1), с выбранными характеристиками (2) или сохранённого (3)");
            int start=scanner.nextInt();

            switch (start){
                case 1:
                    men=createdCharacters();
                    return men;
                case 2:
                    System.out.println("Выберите класс, на данный момент доступен только (Воин)");
                    String classname=scanner.nextLine();
                    if (!classname.equals("Воин")){
                        System.out.println("Неверный класс");

                    }else{
                    if (classname.equals("Воин")){
                    int[] character=character();
                    men=new Warior(name,"Воин",character[0],character[1],character[2],character[3],character[4],
                            character[5]);
                    return men;
                    }
                    break;
                    }
                case 3:
                    ObjectInputStream ois=new ObjectInputStream(new FileInputStream("PersonCharact.bin"));
                    int[] character2=(int[]) ois.readObject();
                    men=new Warior(name,"Воин",character2[0],character2[1],character2[2],character2[3],character2[4],
                            character2[5]);
                    ois.close();
                    return men;
                default:
                    System.out.println("Неверное значение введите ещё раз");

            }
        }while(exit);
        return null;
    }

    private static int[] character() throws IOException{
        boolean end;
        System.out.println("У вас есть лишних " + bonuspoint + " очков, по умолчанию все характеристики равны " +
                "10 вы вольны изменить их согласно таблице, но не меньше 7 и не больше 18");
        tablCharacter();
        //tempVizual(temp);
        start:
        do{
            int number2=0;
            System.out.println("Выберите характеристику для изменения:" +"\nБонусных очков для изменения:"+ bonuspoint +
                  "\n1.Сила-"+temp[0]+"\n2.Ловкость-"+temp[1]+"\n3.Выносливость-"+temp[2]+
                  "\n4.Интеллект-"+temp[3]+"\n5.Мудрость-"+temp[4]+"\n6.Харизма-"+temp[5]+
                  "\n7.Таблица изменения характеристик" + "\n8.Сохранить" + "\n9.Выход");
            end=true;
            number=scanner.nextInt();
            if (number==7){
                tablCharacter();
                continue;
            }
            if (number==8){
                ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("PersonCharact.bin"));
                oos.writeObject(temp);
                oos.close();
                continue;
            }
            if (number==9){
                break;
            }
            if ((number<1)||(number>8)) {
              System.out.println("Число не в диапазоне 1-8");
              continue;
            }
            System.out.println("Введите новое значение");
            number2=scanner.nextInt();
           if (number2<7||number2>18){
             System.out.println("Неверное значение. Введённое число должно быть в диапазоне 7-18");
             continue;
          }

          changeCharacter(number,number2,temp);

        }while(end);

       return temp;
    }


    private static void tempVizual(int[] temp){
        System.out.printf("1.Сила:          %-2d\n" +
                         "2.Ловкость:      %-2d\n" +
                         "3.Выносливость:  %-2d\n" +
                         "4.Интеллект:     %-2d\n" +
                         "5.Мудрость:      %-2d\n" +
                         "6.Харизма:       %-2d\n",temp[0],temp[1],temp[2],temp[3],temp[4],temp[5]);
    }


    private static void tablCharacter(){
        System.out.println("   Значение     |    Стоимость   ||   Значение     |    Стоимость   ");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("       7        |        -4      ||       13       |         3      ");
        System.out.println("       8        |        -2      ||       14       |         5      ");
        System.out.println("       9        |        -1      ||       15       |         7      ");
        System.out.println("       10       |         0      ||       16       |        10      ");
        System.out.println("       11       |         1      ||       17       |        13      ");
        System.out.println("       12       |         2      ||       18       |        17      ");
    }


    private static void changeCharacter(int number1,int number2,int[] temp){
        int tempchange=0;
        Map<Integer,Integer> keyValue=new HashMap<>();
        keyValue.put(7,-4);
        keyValue.put(8,-2);
        keyValue.put(9,-1);
        keyValue.put(10,0);
        keyValue.put(11,1);
        keyValue.put(12,2);
        keyValue.put(13,3);
        keyValue.put(14,5);
        keyValue.put(15,7);
        keyValue.put(16,10);
        keyValue.put(17,13);
        keyValue.put(18,17);
        tempchange=keyValue.get(temp[number1-1]) - keyValue.get(number2);
        if (Math.abs(tempchange)>bonuspoint){
            System.out.println("Число выходит за пределы границ попробуйте снова");
        }else{
            bonuspoint+=tempchange;
            temp[number1-1]=number2;
        }
    }
    private static Player createdCharacters(){
        return null;
    }

}
