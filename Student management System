import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
 class Student{
    String name ;
    int age;
    int id;
    String Address;
    public Student(String name , int age , int id , String Address)
    {
        this.name = name ;
        this.age = age;
        this.id = id ;
        this.Address = Address;
    }
    public int getId() // getter method
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age ;
    }
    public String getAddress()
    {
        return Address ;
    }
   
}
class Manager{
    List<Student> studentList = new ArrayList<>(); // dynamic list declaration
    public  void addStudent(Student student)
    {
         studentList.add(student); // adding student to the list

    }
    public  void viewstudent( ) // method to view student details
    {
        if (studentList.isEmpty()) // checking if list is empty
        {
            System.out.println("No student found");
            return;
            
        }
        else{
            for (Student student : studentList)
             {
                System.out.println("Name: " + student.getName());
                System.out.println("Age: " + student.getAge());
                System.out.println("ID: " + student.getId());
                System.out.println("Address: " + student.getAddress());
                System.out.println(" ");

            }
        }
    }
    public  void searchbyname(String name)
    {
            boolean found = false;
            for ( Student student : studentList) // loop to search student by id
            {
                if (student.getName().equalsIgnoreCase(name)) // name is found // string compare
                 {
                    System.out.println("Id: " + student.getId());
                    System.out.println("Age: " + student.getAge());
                    System.out.println("Address: " + student.getAddress());
                    System.out.println(" ");
                    found = true;
                    break;
                 }
            }
            if (!found)
             {
                System.out.println("Student with name " + name + " not found");
            }
    }
    public  void searchbyid(int id)
    {
            boolean found = false;
            for ( Student student : studentList) // loop to search student by name
            {
                if (student.getId()== id) // id is found
                 {
                    System.out.println("Name: " + student.getName());
                    System.out.println("Age: " + student.getAge());
                    System.out.println("Address: " + student.getAddress());
                    System.out.println(" ");
                    found = true;
                    break;
                 }
            }
            if (!found)
             {
                System.out.println("Student with id " + id + " not found");
            }
    }
}

public class StudentManager {
 
    public static void main(String arg [] ) 
    {
        Scanner sc = new Scanner (System.in);
        
          
          Manager manager = new Manager();
          boolean ok = true;
          while (ok)
          {
            System.out.println("Please select an option");

            System.out.println("1. Add Student");
            System.out.println("2. view Student list");
            System.out.println("3. Search Student by Id");
            System.out.println("4. Search Student by Name");
            System.out.println("5. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch(choice){
            case 1:// add

                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter age: ");
                    int age = sc.nextInt();
                    sc.nextLine(); // Consume the newline character

                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // Consume the newline character after a number input

                    System.out.print("Enter address: ");
                    String address = sc.nextLine();

                    manager.addStudent(new Student(name, age, id, address));
                    break;
            case 2: // display information of students
                  manager.viewstudent();
                  break;
            case 3: //search with id
                  System.out.println("Enter ID to search: ");
                   int search_id = sc.nextInt();
                   manager.searchbyid(search_id);
                   break;
            case 4://search by name
                  System.out.println("Enter name to search: ");
                  String search_name = sc.nextLine();
                  manager.searchbyname(search_name);
                  break;
            case 5: // exit
                  ok = false;

          }

            
          }
    }
}
