/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaSetOperations;

import javax.swing.*;

/**
 *
 * @author User
 */
public class JavaSetOperations {
    private static SetList universalList = new SetList();
    private static SetList a = new SetList();
    private static SetList b = new SetList();
    private static SetArray universalArray = new SetArray(10);
    private static SetArray c = new SetArray(5);
    private static SetArray d = new SetArray(5);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int option = 0;
        String menu = "MENU\n1.Union de a y b en listas\n2.Intersección de a y b en listas\n3.Igualdad de a y b en listas\n4.Complemento de a en listas"
            + "\n5.Diferencia de a con b en listas\n6.Diferencia de b con a en listas\n7. Diferencia simetrica de a y b en listas"
            + "n8.Union de a y b en vectores\n9.Intersección de a y b en vectores\n10.Igualdad de a y b en vectores\n12.Complemento de a en vectores"
            + "\n13.Complemento de b en vectores\n14.Diferencia de a con b en vectores\n15.Diferencia de b con a en vectores\n16. Diferencia simetrica de a y b en vectores"
            + " \n0.salir\nDigite la opcion";
        
        universalList.add("Cartagena");
        universalList.add("Bogotá");
        universalList.add("Medellín");
        universalList.add("Cali");
        universalList.add("Barranquilla");
        universalList.add("Bucaramanga");
        universalList.add("Santa Marta");
        universalList.add("Cúcuta");
        universalList.add("Manizales");
        universalList.add("Pereira");
        
        int countRandom = 5;
        int countRandomSuccessfull = 0;
        while(countRandom != countRandomSuccessfull) {
            int index = (int)(Math.random() * 10);
            String data = universalList.getData(index);
            if(!a.belongs(data)){
                a.add(data);
                countRandomSuccessfull++;
            }
        }
        
        System.out.println("El conjunto a es: ");
        showResultList(a);
        
        countRandomSuccessfull = 0;
        while(countRandom != countRandomSuccessfull) {
            int index = (int)(Math.random() * 10);
            String data = universalList.getData(index);
            if(!b.belongs(data)){
                b.add(data);
                countRandomSuccessfull++;
            }
        }
        
        System.out.println("El conjunto b es: ");
        showResultList(b);
        
        universalArray.add("Pasto");
        universalArray.add("Ibagué");
        universalArray.add("Villavicencio");
        universalArray.add("Armenia");
        universalArray.add("Montería");
        universalArray.add("Valledupar");
        universalArray.add("Buenaventura");
        universalArray.add("Popayán");
        universalArray.add("Neiva");
        universalArray.add("Tunja");
        
        countRandomSuccessfull = 0;
        while(countRandom != countRandomSuccessfull) {
            int index = (int)(Math.random() * 10);
            String data = universalArray.getData(index);
            if(!c.belongs(data)){
                c.add(data);
                countRandomSuccessfull++;
            }
        }
        
        System.out.println("El conjunto c es: ");
        showResultArray(c);
        
        countRandomSuccessfull = 0;
        while(countRandom != countRandomSuccessfull) {
            int index = (int)(Math.random() * 10);
            String data = universalArray.getData(index);
            if(!d.belongs(data)){
                d.add(data);
                countRandomSuccessfull++;
            }
        }
        
        System.out.println("El conjunto d es: ");
        showResultArray(d);

        do{
            try{
                option = Integer.parseInt(JOptionPane.showInputDialog(menu));
                switch(option){
                    case 1:
                        System.out.println("La unión entre a y b es:");
                        showResultList(a.union(b));
                        break;
                    case 2:
                        System.out.println("La intersección entre a y b es:");
                        showResultList(a.intersection(b));
                        break;
                    case 3:
                        if(a.equality(b)){
                            System.out.println("Los conjuntos a y b son iguales. \n");
                        }else {
                            System.out.println("Los conjuntos a y b no son iguales. \n");
                        }
                        break;
                    case 4:
                        System.out.println("El complemento de a es:");
                        showResultList(a.complement(universalList));
                        break;
                    case 5:
                        System.out.println("La diferencia de a con b es:");
                        showResultList(a.difference(b));
                        break;
                    case 6:
                        System.out.println("La diferencia de b con a es:");
                        showResultList(b.difference(a));
                        break;
                    case 7:
                        System.out.println("La diferencia simétrica entre a y b es:");
                        showResultList(a.symmetricDifference(b));
                        break;
                    case 8:
                        System.out.println("La unión de c con d es:");
                        showResultArray(c.union(d));
                        break;
                    case 9:
                        System.out.println("La intersección entre c y d es:");
                        showResultArray(c.intersection(d));
                        break;
                    case 10:
                        if(c.equality(d)) {
                            System.out.println("Los conjuntos c y d son iguales. \n");
                        }else {
                            System.out.println("Los conjuntos c y d no son iguales. \n");
                        }
                        break;
                    case 11:
                        System.out.println("El complemento de c es:");
                        showResultArray(c.complement(universalArray));
                        break;
                    case 12:
                        System.out.println("La diferencia de c con d es:");
                        showResultArray(c.difference(d));
                        break;
                    case 13:
                        System.out.println("La diferencia de d con c es:");
                        showResultArray(d.difference(c));
                        break;
                    case 14:
                        System.out.println("La diferencia simétrica entre c y d es:");
                        showResultArray(c.symmetricDifference(d));
                        break;
                    case 0:
                        break;
                }
            }catch(Exception e) {
                break;
            }
        }while(option != 0);
    }
    
    /**
     * 
     * @param paramSet 
     */
    public static void showResultList(SetList paramSet) {
        String result = "";
        if(!paramSet.isEmpty()){
            result += "{ ";
            Node aux;
            aux = paramSet.getHead();
            while(aux != null) {
                result += aux.getData() + ", ";
                aux = aux.getNextNode();
            }
            result = result.substring(0, result.length()-2);
            result += " }";
        }else {
            result = "{}";
        }
        result += "\n";
        System.out.println(result);
    }
    
    /**
     * 
     * @param paramSet 
     */
    public static void showResultArray(SetArray paramSet) {
        String result = "";
        if(!paramSet.isEmpty()) {
            result += "{ ";
            for(int i = 0; i < paramSet.getVector().length; i++) {
                result += paramSet.getData(i) + ", ";
            }
            result = result.substring(0, result.length()-2);
            result += " }";
        }else {
            result = "{}";
        }
        result += "\n";
        System.out.println(result);
    }
    
}
