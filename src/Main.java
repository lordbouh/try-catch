import java.io.*;
import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) {
            if (copyFileUsingStream("src/utf8.txt", "utf-8", "src/win1251.txt", "windows-1251")) {
                    System.out.println("Перекодировка прошла успешно!");
            }
    }
private static boolean copyFileUsingStream(String source, String sourceEnc, String dest, String destEnc) {
         try (Reader fis = new InputStreamReader(new FileInputStream(source), Charset.forName(sourceEnc));
             Writer fos = new OutputStreamWriter(new FileOutputStream(dest), Charset.forName(destEnc))) {
                /* все открылось, можно копировать */

                char[] buffer = new char[1024];
                int length;
                while ((length = fis.read(buffer)) > 0) {
                        fos.write(buffer, 0, length);
                }
        }
        catch (FileNotFoundException e){
        System.out.println("Проблема с файлами: " + e.getMessage());
        return false;
        }
        catch (UnsupportedEncodingException e) {
        System.out.println("Проблема с кодировкой: " + e.getMessage());
        return false;
        }
        catch (IOException e){
        System.out.println("Проблема при копировании");
        return false;
        }
        return true;
        }
        }