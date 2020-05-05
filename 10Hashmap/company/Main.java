package com.company;
import com.company.classes.User;


public class Main {

    public static void main(String[] args) {

//        ArrayList<Car> cars = new ArrayList<>();
//        cars.add(new Car(1,"Toyota", 2001,180));
//        cars.add(new Car(2,"Honda", 1990,250));
//        cars.add(new Car(3,"Mitsubishi", 2015,230));
//        cars.add(new Car(4,"Mercedes", 2020,300));
//        cars.add(new Car(5,"Audi", 2011,290));
//        cars.add(new Car(6,"BMW", 2015,200));
//        cars.add(new Car(8,"Ferrari", 1990,280));
//        cars.add(new Car(9,"Bugatti", 2020,210));
//        cars.add(new Car(10,"Ford", 2001,180));
//        cars.add(new Car(11,"Lexus", 2011,160));
//        cars.add(new Car(12,"KIA", 2001,180));
//        cars.add(new Car(13,"Hyundai", 2011,240));
//        cars.add(new Car(14,"Jeep", 2020,250));
//        cars.add(new Car(15,"Dodge", 1990,200));
//        cars.add(new Car(16,"Lada", 2015,220));
//        cars.add(new Car(17,"Ferrari", 2001,210));
//        cars.add(new Car(18,"Toyota", 2011,200));
//        cars.add(new Car(19,"Mercedes", 2020,190));
//        cars.add(new Car(20,"Toyota", 1990,150));
//        cars.add(new Car(21,"Honda", 2015,210));

        HashMap<String, User> hmap = new HashMap<>();
        hmap.put("Aqzhol", new User("Aqzhol", 19, "pas"));
        hmap.put("Nurdan", new User("Nurdan", 19, "pas"));
        hmap.put("Bota", new User("Bota", 19, "pas"));
        hmap.put("Diana", new User("Diana", 19, "pas"));
        hmap.put("Zama", new User("Zama", 19, "pas"));
        hmap.put("Talshin", new User("Talshin", 19, "pas"));
        hmap.put("Talshin", new User("qqq", 19, "pas"));

//        hmap.rehash();
//        System.out.println("\n\n");
//        hmap.print();
//        System.out.println(hmap.get("Bota"));
////        System.out.println(hmap.size);
//        hmap.remove("Zama");
//        hmap.remove("Bota");
//        hmap.remove("Nurdan");
        hmap.print();

//        System.out.println(3%3);

    }
}
