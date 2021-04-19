package bai16_io_text_file.bai_tap.copy_file_text;

import java.io.*;

public class CopyFileText {
    public void readFileText() throws IOException {
        File fileRead= new File("src/bai16_io_text_file/bai_tap/copy_file_text/file_read/read.txt");
        FileReader fileReader=new FileReader(fileRead);
        BufferedReader br = new BufferedReader(fileReader);

        File fileWrite = new File("src/bai16_io_text_file/bai_tap/copy_file_text/file_write/write.txt");
        FileWriter fileWriter = new FileWriter(fileWrite);
        BufferedWriter bw = new BufferedWriter(fileWriter);

        if (!fileRead.exists()) {
            throw new FileNotFoundException();
        }

        String line = null;
        while ((line=br.readLine()) !=null){
            System.out.println(line);
            bw.write(line);
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        CopyFileText copyFileText = new CopyFileText();
        copyFileText.readFileText();
    }

}
