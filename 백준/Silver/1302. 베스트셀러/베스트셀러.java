import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(bf.readLine());

        HashMap<String,Integer> book = new HashMap<>();

        for(int i=0;i<tc;i++){
            String input = bf.readLine();
            if(!book.containsKey(input)){
                // 책 없으면 false
                book.put(input,1);
            }
            else{
                // 책이 있으면
                int count = book.get(input);
                count++;
                book.put(input,count);
            }
        }

        Integer maxValue = Collections.max(book.values());
        List<String> maxbook = new ArrayList<>();

        for(Map.Entry<String,Integer> entry : book.entrySet()){
            if(Objects.equals(entry.getValue(), maxValue)){
                maxbook.add(entry.getKey());
            }
        }

        Collections.sort(maxbook);


        bw.write(maxbook.get(0));
        bw.flush();
        bw.close();

    }
}