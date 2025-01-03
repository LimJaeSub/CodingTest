import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = reader.readLine();
        String[] parts = input.split(" ");
        int hour = Integer.parseInt(parts[0]);
        int min = Integer.parseInt(parts[1]);
        int timer = Integer.parseInt(reader.readLine());

        if((min+timer)>=60){
            hour = hour+((min+timer)/60);
            if(hour>=24){
                hour = hour-24;
            }
            min = ((min+timer)%60);
        }
        else{
            min=min+timer;
        }

        writer.write(hour+" "+min);
        writer.flush();
        writer.close();


    }
}