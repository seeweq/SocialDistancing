import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SocialDistancingChecker {


    public  String fileName;

    public SocialDistancingChecker(String fileName){
        this.fileName = fileName;
    }
    public boolean check() throws SocialDistancingViolation {

        try {

            String socialDistance = "x x x x x";
            Path path = Paths.get("/home/sivu/SocialDistancing/" + fileName);
            String read = Files.readAllLines(path).get(0);

            if (read.equals(socialDistance)) {

                System.out.println(true);

            } else {
                throw new SocialDistancingViolation();
            }
        } catch (SocialDistancingViolation sdEx) {
            sdEx.printStackTrace();
            System.out.println("No Social Distance");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("fileName not found");

        }
        return true;
    }

    public static void main(String[] args) throws IOException{
        SocialDistancingChecker socialDistancingChecker= new SocialDistancingChecker("Bookings.txt");
        try{
            socialDistancingChecker.check();
        }finally {
            System.out.println("Social Distancing!");
        }
    }
}
class SocialDistancingViolation extends IOException{}
