import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("notepad.exe");
        Process p = null;
        Scanner sc = new Scanner(System.in);

        System.out.print("Número de ventanas: ");

        int numeroVentanas = sc.nextInt();

        ArrayList<Process> lista = new ArrayList<>();
        sc.nextLine();
        for (int i = 0; i < numeroVentanas; i++) {
            p = pb.start();
            lista.add(p);
            System.out.println("El porceso " + (i +1) + " se inició a : " + LocalTime.now().toString().substring(0,12));
        }
        lista.get(0).waitFor(500, TimeUnit.MILLISECONDS);
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).destroyForcibly();
            System.out.println("El porceso " + (i +1) + " se terminó a : " + LocalTime.now().toString().substring(0,12));
        }
    }
}