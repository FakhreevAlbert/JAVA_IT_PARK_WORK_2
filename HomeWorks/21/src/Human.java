/**
 * Created by Admin on 15.05.17.
 */
public class Human {
    private String name;
    private String sex;
    private int age;
    private int growth;
    private int weight;






    public Human(String name, String sex, int age, int growth, int weight) {
        this.setName(name);
        this.setSex(sex);
        this.setAge(age);
        this.setGrowth(growth);
        this.setWeight(weight);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        if (age >= 18){
            this.age = age;
        }else
            System.err.println("Ваш возраст не подходит");

    }

    public void setGrowth(int growth) {
        if (growth >= 150){
            this.growth = growth;
        } else
            System.err.println("Вы карлик");

    }

    public void setWeight(int weight) {
        if (weight >= 50) {
            this.weight = weight;
        } else
            System.err.println("Вы дрыщь");

    }


    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public int getGrowth() {
        return growth;
    }

    public int getWeight() {
        return weight;
    }
}
