
package Principal;
import DAO.DAOestudiante;
import Curso.Estudiante;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class admi {

    public static void main(String[] args) {
        
        
        
        DAOestudiante nuevo = new DAOestudiante();
        Scanner var=new Scanner(System.in);
        int opc, rut;     
        do{
        System.out.println("1.-Ingresar a estudiante a base de datos");
        System.out.println("2.-Modificar estudiante de la base de datos");
        System.out.println("3.-Eliminar estudiante de la base de datos");
        System.out.println("4.-Mostrar todos los estudiantes");
        System.out.println("5.-Indicar promedio del curso");
        System.out.println("6.-mostrar los datos del mejor y peor estudiante");
        System.out.println("7.-Salir");
        opc=var.nextInt();
        switch(opc){
                 case 1:       
                    System.out.println("ingrese nombre de rut de estudiante");
                    rut=var.nextInt();
                    System.out.println("ingrese nombre de nombre de estudiante");
                    String nombre=var.next();
                    System.out.println("ingrese nombre de promedio de estudiante");
                    float promedio=var.nextFloat();
                    Estudiante estudiante= new Estudiante(rut,nombre,promedio);
                    nuevo.Crear(estudiante);
                     System.out.println("El registro del alumno fue hecho con exito");
                    break;
                 case 2:
                    System.out.println("ingrese nombre de rut de estudiante");
                    int rut1=var.nextInt();
                    System.out.println("ingrese nombre de nombre de estudiante");
                    String nombre1=var.next();
                    System.out.println("ingrese nombre de promedio de estudiante");
                    float promedio1=var.nextFloat();
                    Estudiante estudiante1= new Estudiante(rut1,nombre1,promedio1);
                    nuevo.modificar(estudiante1);
                    System.out.println("Se han actulizados los datos del alumno con exito");
                    break;
                 case 3:
                    System.out.println("Ingresa el RUT del estudiante que vas a elmininar");
                    rut = var.nextInt();
                    Estudiante estudiante2= new Estudiante();
                    nuevo.eliminar(estudiante2);
                    break;
                 case 4:
                     ArrayList <Estudiante> te = nuevo.todosEstudiantes();
                     System.out.println("Los siguientes son los datos de todas las personas que están en la base de datos ");
                     for(Estudiante e : te){
                        System.out.println(e.toString());
                     }

                     break;
                 case 5:
                 case 6:          
                     
                
          
        }
        }while(opc!=7);
        
    
        
    }
    
}
