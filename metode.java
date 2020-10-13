package aplicatiePachet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class metode implements InterfataApl {

    public static void getlist() {

        File cale = new File("C:\\");

        String[] elements = cale.list();
        for (String element : elements) {
            System.out.println(element);

        }

    }

    public static void getinfo() throws IOException {
        Scanner infisier = new Scanner(System.in);
        System.out.println("Introduceti numele fisierului: ");
        File fisier = new File(infisier.nextLine());
        Path path = fisier.toPath();

        if (fisier.exists() && fisier.isFile()) {

            Instant instant = Instant.ofEpochMilli(fisier.lastModified());
            LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MMMM.YYYY.HH:mm:ss");
            BasicFileAttributes fatr = Files.readAttributes(path,
                    BasicFileAttributes.class);

            System.out.println(fisier.getName() + "se gaseste in: " + fisier.getPath() + "\n fisierul ocupa: " + fisier.length() + "B "
                    + "\n fisierul a fost creat: " + fatr.creationTime() + "\n data ultimei modifcari este: " + dateTime.format(dateTimeFormatter));
        } else {
            System.out.println("Fisierul nu exista.");
        }
    }

    public static void createdir() {
        Scanner infisier = new Scanner(System.in);
        System.out.println("Introduceti numele fisierului: ");
        File fisier = new File(infisier.nextLine());
        try {
            if (!fisier.exists()) {
                fisier.mkdir();
                System.out.println("A fost creat fisierul: " + fisier.getName());

            } else {
                System.out.println("fisierul " + fisier.getName() + " deja exista!");
            }
        } catch (Exception e) {
            System.out.println("Fisierul nu a putut fi creat!");
        }
    }

    public static void rename() {
        Scanner infisier = new Scanner(System.in);
        System.out.println("Introduceti numele fisierului: ");
        File fisier = new File(infisier.nextLine());
        if (fisier.exists()) {
            Scanner infisiermodificat = new Scanner(System.in);
            System.out.println("Introduceti noul nume al fisierului : ");
            File fisiermodificat = new File(infisiermodificat.next());

            fisier.renameTo(fisiermodificat);
            System.out.println("Denumirea fisierului a fost modificata cu succes.");
        } else {
            System.out.println("Fisierul cu acest nume nu exista");
        }
    }

    public static void copy() {

        Scanner infisier = new Scanner(System.in);
        System.out.println("Introduceti numele fisierului: ");
        File fisier = new File(infisier.nextLine());
        if (fisier.exists()) {
            Scanner incopiere = new Scanner(System.in);
            System.out.println(" Introduceti numele folderului in care doriti sa copiati fisierul: ");
            File copie = new File(incopiere.next());

            try ( FileInputStream inStream = new FileInputStream(fisier.getAbsolutePath());  FileOutputStream outStream = new FileOutputStream(copie.getAbsolutePath());) {

                byte[] buffer = new byte[1024];
                int length;
                while ((length = inStream.read(buffer)) > 0) {
                    outStream.write(buffer, 0, length);
                }
                System.out.println("Fisierul a fost copiat.");
            } catch (IOException exc) {
                System.out.println(exc);
            }
        } else {
            System.out.println("Fisierul nu poate fi copiat deoarece nu exista!");
        }

    }

    public static void move() {
        Scanner infisier = new Scanner(System.in);
        System.out.println("Introduceti numele fisierului: ");
        File fisier = new File(infisier.nextLine());

        if (fisier.exists()) {
            Scanner inmutare = new Scanner(System.in);
            System.out.println("Introduceti numele folderului unde doriti sa mutati fisierul: ");
            File mutare = new File(inmutare.next());

            try ( FileInputStream inStream = new FileInputStream(fisier.getAbsolutePath());  FileOutputStream outStream = new FileOutputStream(mutare.getAbsolutePath());) {

                byte[] buffer = new byte[1024];
                int length;
                while ((length = inStream.read(buffer)) > 0) {
                    outStream.write(buffer, 0, length);
                }
                System.out.println("Fisierul a fost mutat cu succes.");
                inStream.close();
                outStream.close();
                fisier.delete();
            } catch (IOException exc) {
                System.out.println(exc);
            }
        } else {
            System.out.println("Fisierul nu poate fi mutat deoarece nu exista!");
        }

    }

    public static void delete() {

        Scanner infisier = new Scanner(System.in);
        System.out.println("Introduceti numele fisierului: ");
        File fisier = new File(infisier.nextLine());

        if (fisier.exists()) {

            fisier.delete();
            System.out.println("Fisierul a fost sters.");
        } else {
            System.out.println("Fisierul pe care doriti sa il stergeti nu exista.");
        }

    }

}
