package ec.edu.espe.managamentsystem.controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author PabloEZurita
 */
public class GradesMenu {

    private static List<Integer> gradesOfStudents = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void setGrades() {
        int opcionOfMenu;

        do {
            System.out.println("Menu de Notas");
            System.out.println("1. Anadir una nota");
            System.out.println("2. Eliminar una nota");
            System.out.println("3. Modificar una nota");
            System.out.println("4. Mostrar notas");
            System.out.println("5. Salir");
            System.out.println("Ingrese una opcion: ");

            opcionOfMenu = checkEnteredData();

            switch (opcionOfMenu) {
                case 1:
                    addGrade();
                    break;
                case 2:
                    removeGrade();
                    break;
                case 3:
                    modifyGrade();
                    break;
                case 4:
                    showGrades();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Ingrese una opcion valida, del 1 al 5");
                    break;
            }

            System.out.println();
        } while (opcionOfMenu != 5);
    }

    private static int checkEnteredData() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Ingrese un numero entero valido");
            }
        }
    }

    private static void addGrade() {
        System.out.println("Ingrese la nota a anadir: ");
        int gradeOfStudent = checkEnteredData();
        if (gradeOfStudent <= 10 && gradeOfStudent >= 0) {
            gradesOfStudents.add(gradeOfStudent);
            System.out.println("Nota anadida correctamente");
        } else {
            System.out.println("Ingrese un numero del 0 al 10");
        }
    }

    private static void removeGrade() {
        if (gradesOfStudents.isEmpty()) {
            System.out.println("No hay notas registradas");
        } else {
            System.out.println("Ingrese el indice de la nota a eliminar: ");
            int IdGrades = checkEnteredData() - 1;

            if (IdGrades >= 0 && IdGrades < gradesOfStudents.size()) {
                gradesOfStudents.remove(IdGrades);
                System.out.println("Nota eliminada correctamente");
            } else {
                System.out.println("Indice invalido");
            }
        }

    }

    private static void modifyGrade() {
        if (gradesOfStudents.isEmpty()) {
            System.out.println("No hay notas registradas");
        } else {
            System.out.println("Ingrese el indice de la nota a modificar: ");
            int IdGrades = checkEnteredData() - 1;

            if (IdGrades >= 0 && IdGrades < gradesOfStudents.size()) {
                System.out.println("Ingrese la nueva nota: ");
                int nuevaNota = checkEnteredData();
                gradesOfStudents.set(IdGrades, nuevaNota);
                System.out.println("Nota modificada correctamente");
            } else {
                System.out.println("Indice invalido");
            }
        }

    }

    private static String systemGrades(int gradeToEvaluate) {
        String adjectiveGrades = new String();
        if (gradeToEvaluate == 10) {
            adjectiveGrades = "Excelente";
        }
        if (gradeToEvaluate <= 9 && gradeToEvaluate > 7) {
            adjectiveGrades = "Muy Bien";
        }
        if (gradeToEvaluate <= 7 && gradeToEvaluate > 5) {
            adjectiveGrades = "Bueno";
        }
        if (gradeToEvaluate <= 5) {
            adjectiveGrades = "Mejorable";
        }
        return adjectiveGrades;
    }

    private static void showGrades() {

        if (gradesOfStudents.isEmpty()) {
            System.out.println("No hay notas registradas");
        } else {
            System.out.println("Notas ingresadas:");

            for (int i = 0; i < gradesOfStudents.size(); i++) {
                String evaluatedGrates = systemGrades(gradesOfStudents.get(i));
                System.out.println(i + 1 + ": " + gradesOfStudents.get(i)
                        + " - " + evaluatedGrates);
            }
        }
    }

}
