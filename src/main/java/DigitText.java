import java.io.IOException;

/**
 * ����������� ����� �� ������ Text �����������������
 * ����� ������ Integer
 */
public class DigitText extends Text<Integer>{
    public DigitText(String address){
        super( address );
    }

    @Override
    public boolean setMean(){
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

        else {
            try {
                setValue( Integer.parseInt( s ) );
                return true;
            } catch (NumberFormatException e) {
                System.out.println("������ ����� " + getAddress() + " �� �������� ������" ) ;
                return false;
            }
        }
    }


}
