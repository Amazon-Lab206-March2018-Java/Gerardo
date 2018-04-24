public class ProjectTest {

    public static void main (String[] args) {
        Project project1 = new Project ();
        Project project2 = new Project ("Project2");
        Project project3 = new Project ("Project3", "This is the 3rd project");

        System.out.println ("First project name: " + project1.getName());
        project1.setName ("Project1");
        project1.setDescription ("Project2's description");
        System.out.println ("Project1 name and desc: " + project1.elevatorPitch() );
        System.out.println ("Project2 name and desc: " + project2.elevatorPitch() );
    }
}