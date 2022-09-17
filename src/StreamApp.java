import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApp {

/*
Создать пару коллекций различных типов, пару массивов различного типа. Сделать из коллекций и массивов стримы.
Для каждого стрима применить по одной промежуточной операции и одной терминальной.
Результат работы вывести в консоль.

 */

    public static void main(String[] args) {

        List <Integer> listOfInts = new ArrayList<>(List.of(3,5,10,54,132,7,2,10));
        Set <String> setOfString = new HashSet<>(Set.of("one","two","three","four","five"));
        String [] stringArr = {"first","second","third","fourth"};
        int [] intsArr = {4,6,9,2,33,54,21,8,9,6,9,4,33};

        Stream<Integer> listStream = listOfInts.stream();
        Stream<String> setStream = setOfString.stream();
        IntStream intStream = Arrays.stream(intsArr);
        Stream<String> stringStream = Arrays.stream(stringArr);

        List<Integer> editedList = listStream
                .distinct()
                .toList();
        System.out.println(editedList);

        Set <String> editedSet = setStream
                .filter(s -> s.contains("o"))
                .collect(Collectors.toSet());
        System.out.println(editedSet);

        int numbersOfArrWithoutDouble = (int) intStream
                .distinct()
                .count();
        System.out.println(numbersOfArrWithoutDouble);

        List <String> listWithTletterOnly = stringStream
                .filter(s -> s.contains("t"))
                .toList();
        System.out.println(listWithTletterOnly);


        /*
        2.Дан массив :
Integer[] array = {4, 1, 4, 6, 8, 9, 0, 3, 1, 5, 4, 6, 2, 3};

И вот такой метод:

private List getIntegerList(Integer[] array, int value) {
        List integerList = new ArrayList<>();
        for ( int i : array ) {
            if (i < value) {
                integerList.add(i);
            }
        }
        return integerList;
    }
Задача 1. Понять что делает этот метод.
Задача 2. Написать второй метод, в котором заменить код этого метода на стрим.
Результат работы обоих методов вывести в консоль.
         */
        Integer[] array = {4, 1, 4, 6, 8, 9, 0, 3, 1, 5, 4, 6, 2, 3};

        StreamApp streamApp = new StreamApp();
        List firstIntList = streamApp.getIntegerList(array,7);
        System.out.println(firstIntList);

        List <Integer> secondIntList = streamApp.getIntListWithLimit(array,7);
        System.out.println(secondIntList);


        /*
        Second level: Можно взять класс Event. Создать несколько объектов это класса.
Для у половины объектов сделать задать одно из полей одинаковым,
у второй половины - любое значение. Поле выбрать самостоятельно.
Создать коллекцию из этих объектов.
Создать стрим , который отбросит все дубли этих объектов и соберет их в список.
Список вывести в консоль.
         */

        Event eventOne = new Event("127.0.0.0", "21.04.2022", "google.com", Action.REQUEST, ActionState.OK);
        Event eventTwo = new Event("127.0.0.0", "22.04.2022", "yahoo.com", Action.DOWNLOAD, ActionState.FAIL);
        Event eventThree = new Event("127.2.0.1", "23.04.2022", "amazon.com", Action.RESPONSE, ActionState.PAUSE);
        Event eventFour = new Event("127.2.0.1", "24.04.2022", "shopping.com", Action.UPLOAD, ActionState.FAIL);

        List<Event> eventList = new ArrayList<>();
        eventList.add(eventOne);
        eventList.add(eventTwo);
        eventList.add(eventThree);
        eventList.add(eventFour);


        Stream <Event> eventStream = eventList.stream();
        List<Event> events = eventStream.distinct().toList();// удаление дубликатов за счет переопределения метода equals в классе Event
        System.out.println(events);



    }

    private List getIntegerList(Integer[] array, int value) {
        List integerList = new ArrayList<>();
        for ( int i : array ) {
            if (i < value) {
                integerList.add(i);
            }
        }
        return integerList;
    }

    private List <Integer> getIntListWithLimit (Integer[] array, int limit) {
        return Arrays.stream(array).filter(x -> x<limit).toList();
    }
}


