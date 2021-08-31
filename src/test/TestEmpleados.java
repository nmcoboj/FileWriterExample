package test;

import dominio.Empleados;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestEmpleados {
    
    static Scanner datos = new Scanner(System.in);
    static private PrintWriter salida;
    static private FileWriter archivo_txt;
    
    public static void main(String[] args) {

           int entrada = 0;
            Menu menu = new Menu();
            Archivo archivo = new Archivo();
            entrada = menu.MenuPrincipal();
 
            while (entrada != 5) {
                switch (entrada) {
                    case 1:
                        System.out.println(" ");
                        System.out.println("Opción 1: Crear archivo.");
                        archivo.CrearArchivo();
                        entrada = menu.MenuPrincipal();
                        break;

                    case 2:
                        System.out.println(" ");
                        System.out.println("Opción 2: Insertar datos.");
                    {
                        try {
                            archivo_txt = new FileWriter(archivo.nombre_archivo);
                            ingresarDatos(archivo_txt);
                        } catch (IOException ex) {
                            Logger.getLogger(TestEmpleados.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                        entrada = menu.MenuPrincipal();
                        break;


                    case 3:
                        System.out.println(" ");
                        System.out.println("Opción 3: Leer datos.");
                        System.out.println(" ");
                        archivo.LeerArchivo();
                        entrada = menu.MenuPrincipal();
                        break;

                    case 4:
                        System.out.println(" ");
                        System.out.println("Opción 4: Cerrar archivo.");
                        //Do something for case 4
                        entrada = menu.MenuPrincipal();
                        break;
                }
            }
    }
        
      public static void ingresarDatos(FileWriter archivo){      
            salida = new PrintWriter(archivo);
            int edad = 0;
            System.out.println("Cuantos empleados  desea registrar");
            int n = datos.nextInt();
            salida.println("Número de empleados igresados: "+ n);
            Empleados emp[] = new Empleados[n];
            llenaEmpresa(emp);
            for (int i = 0; i < emp.length; i++) {
                edad = calcularEdad(emp[i].getDia(), emp[i].getMes(), emp[i].getAnio());
                salida.println("Empleado No." + (i + 1));
                salida.println("Nombre de empleado: " + emp[i].getNombre());
                salida.println("Fecha de nacimiento: " + emp[i].getDia() + "/" + emp[i].getMes()
                        + "/" + emp[i].getAnio());
                salida.println("Edad: " + edad + " años.");
                System.out.println("");
                salida.println();
                salida.flush();
            }

    }

    public static void llenaEmpresa(Empleados emp[]) {
        String nombre;
        int dia, mes, anio;
        for (int i = 0; i < emp.length; i++) {
            datos.nextLine();
            System.out.println("Empleado No." + (i + 1));
            System.out.print("Nombre: ");
            nombre = datos.nextLine();
            System.out.println("Fecha de nacimiento:");
            System.out.println("Ingrese año:");
            anio = datos.nextInt();
            System.out.println("Ingrese mes:");
            mes = datos.nextInt();
            System.out.println("Ingrese dia:");
            dia = datos.nextInt();
            emp[i] = new Empleados(nombre, dia, mes, anio);
        }
    }


    public static int calcularEdad(int dia, int mes, int anio) {
        LocalDate fechaHoy = LocalDate.now();
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
        Period periodo = Period.between(fechaNacimiento, fechaHoy);
        return periodo.getYears();
    }
}
