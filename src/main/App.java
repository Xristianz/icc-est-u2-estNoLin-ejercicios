package main;

import java.util.LinkedList;

import main.Ejercicio_01_insert.InsertBST;
import main.Ejercicio_02_invert.InvertBinaryTree;
import main.Ejercicio_02_invert.InvertBinaryTree.InvertTree;
import main.Ejercicio_03_listLeves.ListLevels;
import main.Ejercicio_04_depth.Depth;
import utils.StudentValidator;

public class App {
    public static void main(String[] args) throws Exception {
        // NO MODIFICAR ESTE CÓDIGO
        var estudiante = StudentValidator.validarDatos();
        System.out.println("👤 Estudiante: " + estudiante.nombre());
        System.out.println("✉️  Correo: " + estudiante.correo());
        // NO MODIFICAR HASTA AQUÍ

        System.out.println("\n=== EJERCICIO 01: INSERTAR EN BST ===");
        ejecutarInsertarEnBST();

        System.out.println("\n=== EJERCICIO 02: INVERTIR ÁRBOL BINARIO ===");
        ejecutarInvertirArbol();

        System.out.println("\n=== EJERCICIO 03: LISTAR NIVELES EN LISTAS ENLAZADAS ===");
        ejecutarListarNiveles();

        System.out.println("\n=== EJERCICIO 04: CALCULAR PROFUNDIDAD MÁXIMA ===");
        ejecutarCalcularProfundidad();
    }

    private static void ejecutarInsertarEnBST() {
        InsertBST.BST bst = new InsertBST.BST();
        int[] valores = {5, 3, 7, 2, 4, 6, 8};
        for (int valor : valores) {
            bst.insert(valor);
        }
        bst.imprimirPorNiveles();
    }

    private static void ejecutarInvertirArbol() {
        InvertTree arbol = new InvertTree();

        InvertBinaryTree.Nodo raiz = new InvertBinaryTree.Nodo(4);
        raiz.izquierda = new InvertBinaryTree.Nodo(2);
        raiz.derecha = new InvertBinaryTree.Nodo(7);
        raiz.izquierda.izquierda = new InvertBinaryTree.Nodo(1);
        raiz.izquierda.derecha = new InvertBinaryTree.Nodo(3);
        raiz.derecha.izquierda = new InvertBinaryTree.Nodo(6);
        raiz.derecha.derecha = new InvertBinaryTree.Nodo(9);

        System.out.println("Árbol original:");
        arbol.imprimirPorNiveles(raiz);

        InvertBinaryTree.Nodo invertido = arbol.invertir(raiz);
        System.out.println("Árbol invertido:");
        arbol.imprimirPorNiveles(invertido);
    }

    private static void ejecutarListarNiveles() {
        ListLevels.Nodo raiz = new ListLevels.Nodo(4);
        raiz.izquierda = new ListLevels.Nodo(2);
        raiz.derecha = new ListLevels.Nodo(7);
        raiz.izquierda.izquierda = new ListLevels.Nodo(1);
        raiz.izquierda.derecha = new ListLevels.Nodo(3);
        raiz.derecha.izquierda = new ListLevels.Nodo(6);
        raiz.derecha.derecha = new ListLevels.Nodo(9);

        var niveles = ListLevels.ListLevels(raiz);
        int nivelActual = 1;

        for (LinkedList<Integer> nivel : niveles) {
            System.out.print("Nivel " + nivelActual++ + ": ");
            for (int i = 0; i < nivel.size(); i++) {
                System.out.print(nivel.get(i));
                if (i < nivel.size() - 1) System.out.print(" -> ");
            }
            System.out.println();
        }
    }

    private static void ejecutarCalcularProfundidad() {
        Depth.Nodo raiz = new Depth.Nodo(4);
        raiz.izquierda = new Depth.Nodo(2);
        raiz.derecha = new Depth.Nodo(7);
        raiz.izquierda.izquierda = new Depth.Nodo(1);
        raiz.izquierda.derecha = new Depth.Nodo(3);
        raiz.izquierda.izquierda.izquierda = new Depth.Nodo(8);

        int profundidad = Depth.maxDepth(raiz);
        System.out.println("Profundidad máxima del árbol: " + profundidad);
    }
}
    


