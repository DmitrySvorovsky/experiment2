import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * ������� ����� ���������� ������ ����������� ����� ��� ������
 * � ���������� ��������� �� �����
 * @param <T> ��� ����������� ������ - String ���� Integer
 */
public class Text<T extends Comparable> implements Comparable<Text>{
    private BufferedReader reader;
    private T value;
    private String address;
    boolean createObject = true;

    public Text(String address) {
        this.address = address;
        try {
            this.reader = new BufferedReader( new FileReader( address, StandardCharsets.UTF_8 ) );
        } catch (IOException e) {
            System.out.println("������ �����/������. ���� " + address);
            createObject = false;
        }
    }

    public boolean setMean() {
        return false;
    }


    @Override
    public int compareTo(Text text) {
        return this.value.compareTo(text.value);
    }

    public BufferedReader getReader() {
        return reader;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public String getAddress() {
        return address;
    }

    public boolean  examination(String s) {
        if(s == null) {
            System.out.println("� ����� " + address + " ��� ����� ��� ������ ");
            return false;
        }

        if(s.contains( " " ) || s.equals( "" )){
            System.out.println("������  ����� " + address + " ��������");
            return false;
        }
        return true;
    }

    public void closeFlow() {
        try {
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException( e );
        }
    }
}
