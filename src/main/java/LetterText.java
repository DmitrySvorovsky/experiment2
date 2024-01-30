import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * ����������� ����� �� ������ Text �����������������
 * ����� ������ String
 */
public class LetterText extends Text<String>{

    public LetterText(String address){
        super( address );
    }

    @Override
    public boolean setMean() {
        String s;
        try {
            s = getReader().readLine();
        } catch (IOException e) {
            System.out.println("������ ��� ������ �� ����� " + getAddress());
            return false;
        }
        if(!examination( s )){
            return false;
        }
        if(isDigit( s )) {
            return  false;
        }
        else {
            setValue( s );
            return true;
        }
    }

    public boolean isDigit(String s) {
        try {
            Integer.parseInt( s );
            System.out.println("������ �������� ������ � �����" + getAddress());
            return true;
        } catch (NumberFormatException e) {
            return  false;
        }
    }
}
