public class Leader {
private String firstName;
private String lastName;
private String groupName;

public Leader(String firstName, String lastName, String groupName) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.groupName = groupName;
}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

// метод для вывода информации о старосте
public void printLeader() {
    System.out.println("Староста группы " + groupName + ": " + firstName + " " + lastName);
}
}