import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SocialDistancingChecker {


    public  String fileName;

    public SocialDistancingChecker(String fileName){
        this.fileName = fileName;
    }
    public boolean check() throws SocialDistancingViolation{
        try{

            String socialDistance = "x x x x x";
            Path path = Paths.get(fileName);
            String read = Files.readAllLines(path).get(0);
            
            if(read.equals(socialDistance)){
                System.out.println("Social Distancing is good!");
            }else {
                throw new SocialDistancingViolation();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("No social distancing");

        }
    return true;
    }

    public static void main(String[] args) throws IOException{
        SocialDistancingChecker socialDistancingChecker= new SocialDistancingChecker("/home/sivu/SocialDistancing/Bookings.txt");
        try{
            socialDistancingChecker.check();
        }finally {
            System.out.println("Social Distancing!");
        }
    }
}
class SocialDistancingViolation extends IOException{}
