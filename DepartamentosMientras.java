/* Para una cantidad desconocida de registros, se lee: nombre, edad, sexo, estado civil (1=soltero, 2=casado, 3= unión libre, 4=viudo), y carrera (1=sistemas, 2=programación, 3=mantenimiento, 4=diseño).
      Elabore un diagrama que encuentre e imprima:
a) 	Nombre de la mujer de sistemas más joven.
b) 	Nombre del hombre más viejo en sistemas.
c) 	Promedio de edad de las personas de programación que son casadas
d) 	Porcentaje que representan los menores de edad que estudian mantenimiento respecto a todas las personas de mantenimiento.
e) 	Cuantas personas de diseño son mujeres mayores de edad.
 */
package departamentosmientras;

import java.util.Scanner;

public class DepartamentosMientras {

    public static void main(String[] args) {
        Scanner objread=new Scanner(System.in);
        String nom,sx,nom_menor="",nom_mayor="";
        float prom_edad,acum_edad=0,por_mant,cont_men_edad=0;
        int est_civil,carrera,ed,men_edad=200,may_edad=0,
        con_prog=0,cont_mant=0,con_muj_dis=0;        
        System.out.print("Digite el nombre de la persona ");
        nom=objread.next();
        while (!nom.equals("***")){
            System.out.print("Digite la edad ");
            ed=objread.nextInt();
            System.out.print("Digite el sexo masculino femenino ");
            sx=objread.next();
            System.out.print("Digite el estado civil 1.Soltero 2.Casado "
                    + "3.Union libre 4.Viudo ");
            est_civil=objread.nextInt();
            System.out.print("Digite la carrera 1.Sistemas"
                    + " 2.Programacion 3.Mantenimiento 4.Diseño ");
            carrera=objread.nextInt();
            switch (carrera){
                case 1:if (sx.equals("Femenino") && ed < men_edad){
                    men_edad=ed;
                    nom_menor=nom;    
                }else{
                    if (sx.equals("Masculino") && ed > may_edad){
                        may_edad=ed;
                        nom_mayor=nom; 
                    }
                }
                break;
                case 2:if (est_civil == 2){
                           acum_edad+=ed;
                           con_prog++;
                       }
                       break;
                case 3:cont_mant++;
                       if (ed < 18)
                           cont_men_edad++;
                       break;
                case 4: if (sx.equals("Femenino") && ed >= 18)
                            con_muj_dis++;
                       break;
                default:System.out.println("\n Opcion de carrera no valida ");
                       break;
            }
           System.out.print("Digite el nombre de la persona ");
           nom=objread.next(); 
        }
        if (cont_mant == 0)
            por_mant=0;
        else
            por_mant=cont_men_edad/cont_mant * 100;
        if(con_prog == 0)
            prom_edad=0;
        else
            prom_edad=acum_edad/con_prog;
        System.out.println("\n La mujer mas joven de sistemas es "+ nom_menor);
        System.out.println(" El nombre mas viejo de sistemas es "+ nom_mayor);
        System.out.println(" El promedio de edad de los programadores es "+ prom_edad);
        System.out.println(" El porcentaje de de los menores de edad en mantenimiento es "+ por_mant);
        System.out.println(" la cantidad de mujeres en diseño es "+ con_muj_dis); 
    }   
}
