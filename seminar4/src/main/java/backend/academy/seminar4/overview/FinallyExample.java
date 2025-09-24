package backend.academy.seminar4.overview;

public class FinallyExample {

    public static void main(String[] args) throws Exception {
        try {
            System.out.println("this is try");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("this is catch");
        } finally {
            System.out.println("this is finally");
        }
    }

}
