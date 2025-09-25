//Import di Classi Java necessarie al funzionamento del programma
import java.util.Scanner;

// Classe principale, con metodo main
class Esercizio {

    private static Scanner in = new Scanner(System.in);

    private static void azzeraVettore(int[] V, int N){
        int i = 0;
        while(i < N){
            V[i] = 0;
            ++i;
        }
    }

    private static int leggiOperazione(){
        int opzione;

        do{
            System.out.print("\nMENU: \n-1 Inserisci elemento \n-2 Elimina elemento \n-3 Ricerca elemento \n-4 Elimina duplicati \n-5 Visualizza vettore \n-6 Esci dal programma \nScelta: ");
            opzione = Integer.parseInt(in.nextLine());
            if(opzione < 1 || opzione > 6){
                System.out.println("Inserire un operazione valida!");
            }
        }while(opzione < 1 || opzione > 6);

        System.out.println();
        
        return opzione;
    }

    private static int inserireElemento(int[] V, int N, int e, int ie){

        int i = 0;

        int[] W = new int[N+1];

        while(i < ie){
            W[i] = V[i];
            ++i;
        }

        W[ie] = e;

        while(i < N){
            W[i+1] = V[i];
            ++i;
        }

        i = 0;
        while(i < N+1){
            V[i] = W[i];
            ++i;
        }

        return N+1;
    }

    private static int eliminaElemento(int[] V, int N){
        return N;
    }

    private static int ricercaElemento(int[] V, int N, int e){
        int i = 0;
        boolean trovato = false;
        while(i < N && trovato == false){
            if(e == V[i]){
                trovato = true;
            }else{
                ++i;
            }
        }
        return i;
    }

    private static int eliminaDuplicati(int[] V, int N){
        return N;
    }

    private static void visualizzaVettore(int[] V, int N){
        int i = 0;
        while(i < N){
            System.out.println("Cella N." + i + " - Valore: " + V[i]);
            ++i;
        }
    }
    public static void main(String args[]){
      
        System.out.print("Inserire grandezza vettore: ");
        int N = Integer.parseInt(in.nextLine());
        int[] V = new int[N * 10];
        azzeraVettore(V, N);

        int scelta;
        int valore;
        int posizione;

        do{

           scelta = leggiOperazione();
            if(scelta == 1){
                System.out.print("Inserire valore da inserire nel vettore: ");
                valore = Integer.parseInt(in.nextLine());
                do{
                    System.out.print("Inserire la posizione in cui inserire il valore: ");
                    posizione = Integer.parseInt(in.nextLine());
                    if(posizione < 0 || posizione >= N){
                        System.out.println("Inserire una posizione valida!");
                    }
                }while(posizione < 0 || posizione >= N);

                N = inserireElemento(V,N,valore,posizione);
            }
            if(scelta == 2){
                //N = eliminaElemento(V,N);
            }
            if(scelta == 3){

                posizione = -1;

                System.out.print("Inserire valore da ricercare nel vettore: ");
                valore = Integer.parseInt(in.nextLine());

                posizione = ricercaElemento(V,N,valore);
                if(posizione != -1){
                    System.out.println("Elemento trovato nella posizione: " + posizione);
                }else{
                    System.out.println("Elemento non presente nel vettore!");
                }
            }
            if(scelta == 4){
                //N = eliminaDuplicati(V,n);
            }
            if(scelta == 5){
                visualizzaVettore(V,N);
            }
        }while(scelta != 6);
    }
}