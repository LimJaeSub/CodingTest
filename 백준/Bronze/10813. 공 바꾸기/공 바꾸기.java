import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = bf.readLine();
        String[] parts = input.split(" ");

        int basketcount = Integer.parseInt(parts[0]);
        int count = Integer.parseInt(parts[1]);

        int[] arr = IntStream.rangeClosed(1,basketcount).toArray();

        for(int i=0;i<count;i++){
            String howchange = bf.readLine();
            String[] howchangeparts = howchange.split(" ");

            int firstnum = Integer.parseInt(howchangeparts[0])-1;
            int secoundnum = Integer.parseInt(howchangeparts[1])-1;

            int temp=arr[firstnum];
            arr[firstnum]=arr[secoundnum];
            arr[secoundnum]=temp;
        }
        String result = Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(" "));

        bw.write(result);
        bw.flush();
        bw.close();



    }
}