import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ContadorLineas implements Runnable {
    private FileReader fl = null;
    private BufferedReader in = null;
    private String name;

    public ContadorLineas(String name) {
        this.name = name;
        try {
            fl = new FileReader(name);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        in = new BufferedReader(fl);
    }


    @Override
    public void run() {
        int contadorLineas = 0;
        int contadorCaracteres = 0;
        String linea = null;
        long t1 = System.currentTimeMillis();
        while (true) {
            try {
                if (!((linea = in.readLine()) != null))
                    break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            contadorLineas++;
            contadorCaracteres = contadorCaracteres + linea.length();
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("%s: %-50s %,7d %,7d (%d ms)%n",
                Thread.currentThread().getName(), name,
                contadorLineas, contadorCaracteres, System.currentTimeMillis() - t1 );
    }
}
