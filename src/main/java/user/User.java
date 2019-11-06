package user;

public  abstract class User {
    private int id;
    private String firstname;
    private String name;
    private int age;
    private String mail;
    private String adress;
    private int countCookie;

    public User(int id, String firstname, String name, int age, String mail, String adress, int countCookie) {
        this.id = id;
        this.firstname = firstname;
        this.name = name;
        this.age = age;
        this.mail = mail;
        this.adress = adress;
        this.countCookie = countCookie;
    }

    public int getId() {return id; }
    public String getFirstname() { return firstname; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getMail() { return mail; }
    public void setMail(String mail) { this.mail = mail; }
    public String getAdress() { return adress; }
    public void setAdress(String adress) { this.adress = adress; }
    public int getCountCookie() { return countCookie; }
    public void setCountCookie(int countCookie) { this.countCookie = countCookie; }

}
