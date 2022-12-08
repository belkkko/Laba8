import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> listElements = new ArrayList<>();
        listElements.add("one");
        listElements.add("two");
        listElements.add("three");
        listElements.add("four");

        int choice;

        Scanner scan = new Scanner(System.in);
        System.out.println("Меню");

        System.out.println("1 Добавить");
        System.out.println("2 Удалить");
        System.out.println("3 Поиск одинаковых элементов");
        System.out.println("4 Реверс всех строк");
        System.out.println("5 Статистика по символам");
        System.out.println("6 Поиск подстроки в строках");
        System.out.println("7 Считать текстовый файл");
        System.out.println("8 Длины строк");
        System.out.println("9 Выгрузка в xml");

        do {
            System.out.println("Введите ваш выбор:");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Введите новый элемент");
                    Scanner sc = new Scanner(System.in);
                    String addElement = sc.nextLine();
                    listElements.add(addElement);
                    System.out.println(listElements);
                    break;

                case 2:
                    System.out.println("Введите индекс элемента , который хотите удалить");
                    Scanner del = new Scanner(System.in);
                    int del1 = del.nextInt();
                    listElements.remove(del1);
                    System.out.println(listElements);
                    break;

                case 3:
                    HashMap<String, Integer> hashMap = new HashMap<>();
                    Integer number;
                    for (String obj : listElements) {
                        number = hashMap.get(obj);
                        hashMap.put(obj, number == null ? 1 : number + 1);
                    }
                    System.out.println(hashMap);
                    break;

                case 4:
                    Collections.reverse(listElements);
                    System.out.println(listElements);
                    break;

                case 5:
                    String listElementstr = listElements.toString();
                    Map<Character, Integer> map = new TreeMap<Character, Integer>();
                    for (char c : listElementstr.toCharArray())
                        map.put(c, (map.containsKey(c)) ? map.get(c) + 1 : 1);

                    StringBuilder sb = new StringBuilder();
                    for (char c : map.keySet())
                        sb.append(c);
                    System.out.println("Имеются символы \"" + sb + "\"");

                    for (char c : map.keySet())
                        System.out.printf("Количество '%c'=%d \n", c, map.get(c));
                    break;

                case 6:
                    System.out.println("Введите подстроку");
                    Scanner scanner = new Scanner(System.in);
                    String podstr = scanner.nextLine();

                    if (listElements.get(0).contains(podstr))
                        System.out.println("Подстрока найдена в строке " + listElements.get(0));

                    if (listElements.get(1).contains(podstr))
                        System.out.println("Подстрока найдена в строке " + listElements.get(1));

                    if (listElements.get(2).contains(podstr))
                        System.out.println("Подстрока найдена в строке " + listElements.get(2));
                    break;

                case 7:
                    Scanner s = new Scanner(new File("C:\\Users\\belkkko\\Desktop\\LastOne\\LastOne\\output.txt"));
                    String output = s.nextLine();
                    listElements.add(output);
                    System.out.println(listElements);
                    break;

                case 8:
                    System.out.println("Длина первой строки = " + listElements.get(0).length());
                    System.out.println("Длина второй строки = " + listElements.get(1).length());
                    System.out.println("Длина третьей строки = " + listElements.get(2).length());
                    System.out.println("Длина четвертой строки = " + listElements.get(3).length());
                    break;

                case 9:
                    XmlCreator xmlFile = new XmlCreator(listElements.get(0), listElements.get(1), listElements.get(2), listElements.get(3));
                    try {
                        FileOutputStream fos = new FileOutputStream("listElementslist.xml");
                        XMLEncoder encoder = new XMLEncoder(fos);
                        encoder.writeObject(xmlFile);
                        encoder.close();
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Данные успешно выгружены");
                    break;

                default:
                    System.out.println("Неверный ввод");
            }
        } while (choice != 15);
    }
}
