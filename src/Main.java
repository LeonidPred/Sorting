import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList() {
        };
        list1.add(1);
        list1.add(5);
        list1.add(10);
        list1.add(12);
        list1.add(15);
        list1.add(20);

        List<Integer> list2 = new ArrayList() {
        };
        list2.add(-5);
        list2.add(-1);
        list2.add(9);
        list2.add(15);
        list2.add(100);

        System.out.println(list1);
        System.out.println(list2);
        System.out.println(sorting(list1,list2));


        //проверочные неотсортированные массивы
        List<Integer> list3 = new ArrayList();
        List<Integer> list4 = new ArrayList();
        for(int i=0;i<3;i++){
            list3.add((int)(Math.random()*3));
            list4.add((int)(Math.random()*3));
        }
        System.out.println(list3);
        System.out.println(list4);
        System.out.println(sorting(list3,list4));

    }
    //на написание ушло 30 минут,
    // принимаемые функцией коллекции никак не изменяются,
    // а так же не обязаны быть отсортированными,
    // реализована проверка на одинаковые значения
    public static List<Integer> sorting(List<Integer> a, List<Integer> b) {
        List<Integer> c = new ArrayList();
        boolean isEnd; // тумблер для выхода из цикла
        Integer min;//минимальное значение для коллекций
        int count;//счетчик элементов с одинаковым значением
        Integer result = Integer.MIN_VALUE;
        do {
            isEnd = true;
            min = Integer.MAX_VALUE;
            count=0;
            for(Integer i:a){
                if(i>result&&i<=min){
                    if(i==min) count++;
                    else{
                        count=0;
                        min=i;
                        isEnd=false;
                    }
                }
            }
            //дублирую код, т.к. для сортировки у нас статическая функция, а не полноценный класс
            for(Integer i:b){
                if(i>result&&i<=min){
                    if(i==min) count++;
                    else{
                        count=0;
                        min=i;
                        isEnd=false;
                    }
                }
            }
            if(!isEnd){
                result=min;
                for(int i=0;i<=count;i++) c.add(result);
            }
        }while(isEnd == false);
        return c;
    }
}

