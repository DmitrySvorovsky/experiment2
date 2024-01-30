import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс который выполняет функции идентификации исходных файлов,
 * поиска минимального значения и запись в новый файл
 */
public class Merger {
    public Writing writing;
    public List<Text> list;

    public Merger(String[] args)  {
        this.writing = new Writing(args[1]);
        this.list  = typeFile( args );

    }

    public List<Text> typeFile(String [] args) {
        List<Text> list = new ArrayList<>();
        if (args[0].equals( "-i" )) {
            for (int i = 2; i < args.length; i++) {
                DigitText digitText = new DigitText( args[i] );
                if(digitText.createObject && digitText.setMean()){
                    list.add(digitText);
                }
            }
        }
        if (args[0].equals( "-s" )) {
            for (int i = 2; i < args.length; i++) {
                LetterText letterText = new LetterText( args[i] );
                if(letterText.createObject && letterText.setMean()) {
                    list.add( letterText );
                }
            }
        }
        return list;
    }

    private int  indexMin() {
        int min = 0;
        for(int i = 1; i < list.size(); i++) {
            if(list.get( min ).compareTo( list.get( i ) )> 0) {
                min = i;
            }
        }
        return min;
    }

    private void writeText(int min) {
        writing.write( list.get( min ) );
    }


    public void writeFile() {
        int c = indexMin();
        writeText( c );
        if(list.get( c ).setMean()) {
            writeFile();
        }
        else {
            list.get( c ).closeFlow();
            list.remove( c );
        }
        if(!list.isEmpty()) {
            writeFile();
        }
        else {
            writing.closeFlow();
        }
    }
}
