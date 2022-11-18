import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main
{
    public static void main(String[] args)
    {
        showMenu();
    }

    public static void showMenu()     //Despliega el menu principal de la actividad
    {
        //Arreglos que tienen las palabras, se hicieron para mantener el orden original de la lista
        String[] lista1 = {"calculadora", "golpear", "confidencial", "bordear", "embutido", "salvar", "laringitis", "fusta", "ladrar", "extraterrestre"};
        String[] lista2 = {"wifi", "anticongelante", "tender", "jugo", "derecho", "reflejar", "temblor", "flechazo", "kiwi", "abajo"};
        String[] lista3 = {"oveja", "gong", "fina", "tinto", "conflicto", "salud", "nido", "oscuerecer", "asteroide", "revoluciones"};
        String[] lista4 = {"pariente", "advertencia", "naturaleza", "caliente", "cuello", "paleta", "cerdo", "antepasado", "arruga", "cereal"};
        String[] lista5 = {"lavarropa", "astronauta", "Venus", "tango", "acertar", "terciario", "arquitecto", "conocido", "definicion", "naftalina"};
        String[] lista6 = {"facturas", "brazos", "ficha", "seis", "esposas", "vida", "padres", "avenida", "Ecuador", "fiscal"};

        //Menu de opciones a realizar
        String[] opciones = {
                "A) Ordenar palabras alfabeticamente (Clase anónima)",
                "B) Ordenar palabras alfabeticamente (Expresion Lambda)",
                "C) Ordenar palabras alfabeticamente (Metodo de referencia)",
                "D) Ordenar palabras por longitud (Clase anónima)",
                "E) Ordenar palabras por longitud (Expresion Lambda)",
                "F) Ordenar palabras por longitud (Metodo de referencia)",
                "G) Salir del programa"};

        String eleccionCompleta;        //Captura el valor de la string elegida completa
        int salirProceso;               //La opcion que guarda el int que dicta si salir del programa o no
        boolean accionValida = false;   //Boolean que permite que las opciones puedan repetirse indefinidamente hasta que el usuario desee salir del programa

        do
        {
            accionValida = true;

            //Almacena las opciones elegidas por el usuario, tanto para el atributo que desea calcular como la forma que desea usar
            char eleccionSwit;

            try
            {
                //Panel que despliega el atributo a calcular
                eleccionCompleta = (String) JOptionPane.showInputDialog(null,"Seleccione la opcion que desea ejecutar", "ACTIVIDAD 12 Lista de Contactos", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
                eleccionSwit = eleccionCompleta.charAt(0);

                switch(eleccionSwit) //Dependiendo de la figura elegida, se ejecuta la acción especifica
                {
                    case 'A':
                        ArrayList<Palabra> palabras = crearArrayList(lista1);   //La lista 1 se guarda en un arrayList, por cada método, hay una lista distinta

                        //Se le informa al usuario sobre la lista que se va a ordenar
                        JOptionPane.showMessageDialog(null, imprimirListaOriginal(palabras), "ACTIVIDAD 13: Anonimos, Lambda y referencias", JOptionPane.INFORMATION_MESSAGE);

                        //Se usa el sort del Collections para organizar las palabras de A-Z, en esta versión, se usa con una clase anónima
                        Collections.sort(palabras, new Comparator<Palabra>(){
                            @Override
                            public int compare(Palabra palabra1, Palabra palabra2) {
                                if(palabra1.getPalabra().compareToIgnoreCase(palabra2.getPalabra()) < 0)
                                {
                                    return -1;
                                }

                                else
                                {
                                    if(palabra1.getPalabra().compareToIgnoreCase(palabra2.getPalabra()) == 0)
                                    {
                                        return 0;
                                    }

                                    else
                                    {
                                        return 1;
                                    }
                                }
                            }
                        });

                        //Se imprime el la lista ya ordenada, especificando el orden en el que se hizo y lo que se utilizó (Clase anónma/Lambda/Metodo referencial)
                        JOptionPane.showMessageDialog(null, imprimirListaOrdenada(palabras,1,1), "ACTIVIDAD 13: Anonimos, Lambda y referencias", JOptionPane.INFORMATION_MESSAGE);
                        palabras = null;
                        accionValida = false;

                        break;

                    case 'B':
                        //Ordenar alfabeticamente lista 2 por medio de Lambda
                        palabras = crearArrayList(lista2);
                        JOptionPane.showMessageDialog(null, imprimirListaOriginal(palabras), "ACTIVIDAD 13: Anonimos, Lambda y referencias", JOptionPane.INFORMATION_MESSAGE);
                        Collections.sort(palabras, (Palabra palabra1, Palabra palabra2) ->
                        {   if(palabra1.getPalabra().compareToIgnoreCase(palabra2.getPalabra()) < 0)
                            {
                                return -1;
                            }

                            else
                            {
                                if(palabra1.getPalabra().compareToIgnoreCase(palabra2.getPalabra()) == 0)
                                {
                                    return 0;
                                }

                                else
                                {
                                    return 1;
                                }
                            }
                        });

                        JOptionPane.showMessageDialog(null, imprimirListaOrdenada(palabras,1,2), "ACTIVIDAD 13: Anonimos, Lambda y referencias", JOptionPane.INFORMATION_MESSAGE);
                        palabras = null;
                        accionValida = false;

                        break;

                    case 'C':
                        //Ordenar alfabéticamente lista 3 por métodos referenciales
                        palabras = crearArrayList(lista3);
                        JOptionPane.showMessageDialog(null, imprimirListaOriginal(palabras), "ACTIVIDAD 13: Anonimos, Lambda y referencias", JOptionPane.INFORMATION_MESSAGE);
                        Collections.sort(palabras,Comparator.comparing(Palabra::getPalabra));
                        JOptionPane.showMessageDialog(null, imprimirListaOrdenada(palabras,1,3), "ACTIVIDAD 13: Anonimos, Lambda y referencias", JOptionPane.INFORMATION_MESSAGE);
                        palabras = null;
                        accionValida = false;

                        break;

                    case 'D':
                        //Ordenar por longitud de palabra lista 4 por Clase anónima
                        palabras = crearArrayList(lista4);
                        JOptionPane.showMessageDialog(null, imprimirListaOriginal(palabras), "ACTIVIDAD 13: Anonimos, Lambda y referencias", JOptionPane.INFORMATION_MESSAGE);
                        Collections.sort(palabras, new Comparator<Palabra>(){
                            @Override
                            public int compare(Palabra palabra1, Palabra palabra2) {
                                if(palabra1.getLongitud() < palabra2.getLongitud())
                                {
                                    return -1;
                                }

                                else
                                {
                                    if(palabra1.getLongitud() == palabra2.getLongitud())
                                    {
                                        return 0;
                                    }

                                    else
                                    {
                                        return 1;
                                    }
                                }
                            }
                        });

                        JOptionPane.showMessageDialog(null, imprimirListaOrdenada(palabras,2,1), "ACTIVIDAD 13: Anonimos, Lambda y referencias", JOptionPane.INFORMATION_MESSAGE);
                        palabras = null;
                        accionValida = false;

                        break;

                    case 'E':
                        //Ordenar por longitud de palabra lista 5 por Lambda
                        palabras = crearArrayList(lista5);
                        JOptionPane.showMessageDialog(null, imprimirListaOriginal(palabras), "ACTIVIDAD 13: Anonimos, Lambda y referencias", JOptionPane.INFORMATION_MESSAGE);
                        Collections.sort(palabras, (Palabra palabra1, Palabra palabra2) ->
                        {   if(palabra1.getLongitud() < palabra2.getLongitud())
                            {
                                return -1;
                            }

                            else
                            {
                                if(palabra1.getLongitud() == palabra2.getLongitud())
                                {
                                    return 0;
                                }

                                else
                                {
                                    return 1;
                                }
                            }
                        });

                        JOptionPane.showMessageDialog(null, imprimirListaOrdenada(palabras,2,2), "ACTIVIDAD 13: Anonimos, Lambda y referencias", JOptionPane.INFORMATION_MESSAGE);
                        palabras = null;
                        accionValida = false;

                        break;

                    case 'F':
                        //Ordenar por longitud de palabra lista 6 por metodos referenciales
                        palabras = crearArrayList(lista6);
                        JOptionPane.showMessageDialog(null, imprimirListaOriginal(palabras), "ACTIVIDAD 13: Anonimos, Lambda y referencias", JOptionPane.INFORMATION_MESSAGE);
                        Collections.sort(palabras,Comparator.comparing(Palabra::getLongitud));
                        JOptionPane.showMessageDialog(null, imprimirListaOrdenada(palabras,2,2), "ACTIVIDAD 13: Anonimos, Lambda y referencias", JOptionPane.INFORMATION_MESSAGE);
                        palabras = null;
                        accionValida = false;
                        break;

                    case 'G':
                        //Salir del programa
                        JOptionPane.showMessageDialog(null,"Programa terminado", "ACTIVIDAD 12 Lista de Contactos", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                        break;
                }
            }

            catch(NullPointerException a) //El usuario seleccionó la opcion de cerrar el mensaje o de cancelar
            {
                //Se pregunta si el usuario desea salir del programa usando unicamente la opcion de si o no
                salirProceso = JOptionPane.showConfirmDialog(null,"Quiere salir del programa?", "ACTIVIDAD 12 Lista de Contactos", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                //Si presiona Si
                if(salirProceso == JOptionPane.YES_OPTION)
                {
                    JOptionPane.showMessageDialog(null,"Programa terminado", "ACTIVIDAD 12 Lista de Contactos", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }

                //Si presiona No
                else
                {
                    accionValida = false;
                }
            }

            catch(IndexOutOfBoundsException b) //El usuario no ingresó nada y dió aceptar de todas formas
            {
                JOptionPane.showMessageDialog(null,"Comando no reconocido, vuelva a intentarlo", "ACTIVIDAD 12 Lista de Contactos", JOptionPane.ERROR_MESSAGE);
                accionValida = false;
            }
        }
        while(!accionValida);
    }

    private static ArrayList<Palabra> crearArrayList(String[] arregloPalabras)      //Pasa un arreglo de tipo String a un ArrayList de tipo Palabra
    {
        ArrayList<Palabra> arrayList = new ArrayList<Palabra>();

        for (String palabra:arregloPalabras)
        {
            arrayList.add(new Palabra(palabra));
        }

        return arrayList;
    }

    public static String imprimirListaOrdenada(ArrayList<Palabra> palabras, int orden, int metodo)  //Convierte en mensaje el arraylist de la palabra, especificando el orden en el que se encuentra y el método que se utilizó para ello
    {
        String tipoOrdenamiento = "", tipoMetodo = "";

        switch (orden)
        {
            case 1:
                tipoOrdenamiento = "orden alfabetico";
                break;

            case 2:
                tipoOrdenamiento = "longitud de palabra:";
                break;
        }

        switch (metodo)
        {
            case 1:
                tipoMetodo = " (Clase anonima)";
                break;

            case 2:
                tipoMetodo = " (Expresion Lambda)";
                break;

            case 3:
                tipoMetodo = " (Metodo de referencia)";
                break;
        }

        String lista = "Lista Ordenada por " + tipoOrdenamiento + tipoMetodo + "\n\n";
        int i = 1;

        for (Palabra palabra:palabras)
        {
            lista += i+ ") " + palabra.getPalabra() + " (" + palabra.getLongitud() + ")\n";
            i++;
        }

        return lista;
    }

    private static String imprimirListaOriginal(ArrayList<Palabra> palabras)
    {
        String lista = "Lista Original:\n\n";
        int i = 1;

        for (Palabra palabra:palabras)
        {
            lista += i+ ") " + palabra.getPalabra() + "\n";
            i++;
        }

        return lista;
    }
}

