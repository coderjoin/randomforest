import java.io.*;
import java.util.ArrayList;

/**
 * @author qiaoying
 * @date 2019/3/11 15:58
 */
public class Test {

    public static void deal (String name) throws Exception {
        // 使用ArrayList来存储每行读取到的字符串
        ArrayList<String> arrayList = new ArrayList<String>();
        try {
            FileReader fr = new FileReader(name);
            BufferedReader bf = new BufferedReader(fr);
            String str;
            // 按行读取字符串
            while ((str = bf.readLine()) != null) {
                arrayList.add(str);
            }
            bf.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对ArrayList中存储的字符串进行处理

//        File fout = new File("out.txt");
//        FileOutputStream fos = new FileOutputStream(fout);
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
////        for (int i = 0; i < 10; i++) {
////            bw.write("something");
////            bw.newLine();
////        }
////        bw.close();
        int length = arrayList.size();
        //System.out.println(length);
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < length; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            String s = arrayList.get(i);
            String[] line = s.split(" ");
            for (int j = 0; j < line.length; j++) {
                if (line[j].contains("e")) {
                    //System.out.println(line[j]);
                    String a = line[j].substring(0,line[j].indexOf("e"));
                    double tmp = Double.parseDouble(a);
                    int result = (int)(tmp * 10000000);
                    //System.out.println(result);
                    list.add(result);
                } else {
                    double tmp = Double.parseDouble(line[j]);
                    int result = (int)(tmp * 10000000);
                    //System.out.println(result);
                    list.add(result);
                }
            }
            System.out.println(list);
            resultList.add(list);
            //array[i] = Integer.parseInt(s);
        }

    }


    public static void main(String[] args) throws Exception{
        String url = System.getProperty("user.dir") + "/src/main/java/test1.txt";

        deal(url);

    }
}
