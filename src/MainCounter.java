import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class MainCounter extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        String name = file.toAbsolutePath().toString();

        if( name.endsWith(".txt") ) {
            Thread contador = new Thread( new ContadorLineas(name) );
            contador.start();
        }
        return visitFile(file, attrs);
    }


    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.printf("No se puede procesar:%30s%n", file.toString()) ;
        return super.visitFileFailed(file, exc);
    }

    public static void main(String[] args) throws IOException {


        if (args.length == 0){
            System.exit(0);
        }


        //inicar en este directorio
        Path startingDir = Paths.get(args[0]);

        // clase para procesar los archivos
        MainCounter contadorLineas = new MainCounter();

        // iniciar el recorrido de los archivos
        Files.walkFileTree(startingDir, contadorLineas);


    }
}
