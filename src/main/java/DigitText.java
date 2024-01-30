import java.io.IOException;

/**
 * Производный класс от класса Text параметризованный
 * типом данных Integer
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
            System.out.println("Ошибка при чтении из файла " + getAddress());
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
                System.out.println("Строка файла " + getAddress() + " не является числом" ) ;
                return false;
            }
        }
    }


}
