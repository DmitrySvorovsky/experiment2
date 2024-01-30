import org.w3c.dom.ls.LSOutput;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Класс содержащий обьект открывающий поток дял записи в файл
 */
public class Writing {

    private BufferedWriter bufferedWriter;
    private String address;

    public Writing(String adress)  {
        this.address = adress;
        try {
            this.bufferedWriter = new BufferedWriter( new FileWriter( adress ) );
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода. Файл " + address);
            System.out.println("Выполнение программы невозможно");
        }
    }

    public void write(Text text)  {
        if (text instanceof DigitText) {
            try {
                bufferedWriter.write((int) text.getValue() + "\n" );
            } catch (IOException e) {
                System.out.println("Ошибка при записи в файл " + address );
            }
        }
        if (text instanceof LetterText) {
            try {
                bufferedWriter.write( (String) text.getValue() + "\n" );
            } catch (IOException e) {
                System.out.println("Ошибка при записи в файл " + address );;
            }
        }
    }

    public void closeFlow() {
        try {
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException( e );
        }
    }


}
