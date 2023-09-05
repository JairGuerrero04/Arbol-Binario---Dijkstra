package manejador.manejadorGrafo;

import java.util.Random;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import manejador.ArbolBinario;
import manejador.ListaSimple;
import modelo.Nodo;


public class Grafo {
    protected int[][] matrizAdyacencia;
    protected int numeroVertices;
    protected ListaSimple[] listaAdyacencia;
    protected ArbolBinario arbol;
    protected int [][] matriznueva;
    protected int [] vector;
    protected int [] vector2;
    
   

    public void setNumeroVertices(int numeroVertices) {
        this.numeroVertices = numeroVertices;
    }
    public int getNumeroVertices() {
        return numeroVertices;
    }

    public void crearMatriz(int numeroVerices){
        this.matrizAdyacencia = new int[numeroVertices][numeroVertices];
        this.matriznueva= new int[numeroVertices][numeroVertices];
        this.vector=new int[numeroVertices];
        this.vector2=new int[numeroVertices];
        for(int i=0; i<numeroVertices; i++){
            for(int j=0; j<numeroVertices; j++){
                matrizAdyacencia[i][j] = 1000;
            }
        }
    }
    public void crearLista(int numeroVertices){
        listaAdyacencia = new ListaSimple[numeroVertices];
        for(int i=0; i<numeroVertices; i++){
            listaAdyacencia[i] =  new ListaSimple();
        }
    }
    public void crearGrafo(){
        Scanner entrada = new Scanner(System.in);
        int conteo,random,random2;
        int numVertices;
        System.out.println("\nCuantos vertices va a tener tu grafo?");
        numVertices = entrada.nextInt();
        numVertices=numVertices+1;
        
        Random aleatorio = new Random(System.currentTimeMillis());
        Nodo auxiliar=new Nodo();
        conteo=0;
        this.arbol=new ArbolBinario();
		//random = aleatorio.nextInt(numVertices+10);
       // random=ThreadLocalRandom.current().nextInt(numVertices,numVertices*numVertices);
        random=numVertices*numVertices;
		while(conteo<=random)
		{
			if(conteo!=0)
			{
				do
				{
					//random2 = aleatorio.nextInt(7-21);
					random2 = ThreadLocalRandom.current().nextInt(1, numVertices*numVertices);
					Nodo nodos=new Nodo(random2);
					auxiliar=this.arbol.buscar(nodos, this.arbol.getRaiz());
				}while(auxiliar!=null);
				Nodo nodos=new Nodo(random2);
				this.arbol.agregar(nodos, this.arbol.getRaiz());
			}
			else
			{
				random2 = ThreadLocalRandom.current().nextInt(numVertices, numVertices*numVertices);
				Nodo nodos=new Nodo(random2);
				this.arbol.agregar(nodos, this.arbol.getRaiz());
			}
			conteo++;
		}
		
	     System.out.print("PreOrden: ");
			this.arbol.preOrden2(this.arbol.getRaiz());
			System.out.print("\n");
			System.out.print("InOrden:");
			this.arbol.inOrden2(this.arbol.getRaiz());
			System.out.print("\n");
			System.out.print("PostOrden: ");
			this.arbol.postOrden2(this.arbol.getRaiz());
			System.out.print("\n");
			System.out.print("\n");
        
        setNumeroVertices(numVertices);
        crearMatriz(numVertices);
        crearLista(numVertices);
    }

    public int[][] getMatrizAdyacencia() {
        return matrizAdyacencia;
    }
    public ListaSimple getListaAdyacencia(int i) {
        return listaAdyacencia[i];
    }
    
    public void imprimirListaAdyacencia(){
        int i;
        System.out.println("\nLista de adyacencia: ");
        for(i=0; i<numeroVertices; i++){
            listaAdyacencia[i].imprimirNodosAdyacentes();
        }
    }
    public void imprimirMatrizAdyacente(){
       
        
        
        //System.out.println("\n");
        for(int i=0;i<numeroVertices;i++)
        {
        	System.out.print("\t\t"+listaAdyacencia[i].getNodoRaiz().getInfo());
        	
        }
        System.out.println("\n");
        //System.out.println("\tLunes\t\t Martes\t\t Miercoles\tJueves\t\tViernes\t\tSabado");
		for(int c=0;c<numeroVertices;c++)
		{
			
			System.out.print(listaAdyacencia[c].getNodoRaiz().getInfo()+"\t\t");
			
			
			for(int r=0;r<numeroVertices;r++)
			{
				if(matrizAdyacencia[c][r]!=1000){
					System.out.print("["+matrizAdyacencia[c][r]+"]\t\t");
					
                } else{
                    System.out.print("[ 0 ]\t\t");
                    
                }
                //System.out.print(" ");
			}
			System.out.print("\n");
		
		}
		
        
        
        
        
        
        
    }
	
	public void setMatrizAdyacencia(int[][] matrizAdyacencia) {
		this.matrizAdyacencia = matrizAdyacencia;
	}
	public void setListaAdyacencia(ListaSimple[] listaAdyacencia) {
		this.listaAdyacencia = listaAdyacencia;
	}
	
	
	
	public void setDijkstra(int posicion,int i,int band,int posicion2) {
		int j,menor=999, variable=0,variable2=0,band4=0;
		for(j=0;j<this.numeroVertices;j++)
		{
			if(this.matriznueva[posicion][j]!=-1)
			{
				if(this.matrizAdyacencia[i][j]==1000)
				{
					this.matriznueva[posicion][j]=this.matrizAdyacencia[i][j];
					this.matriznueva[posicion][j]=0;
				}
				else
				{
					this.matriznueva[posicion][j]=this.matrizAdyacencia[i][j];
				}
			}
		}
		
		
			for(j=posicion;j<numeroVertices;j++)
			{
					this.matriznueva[j][i]=-1;
				
			}
		
		
		if(band!=0)
		{
			for(j=0;j<numeroVertices;j++)
			{
				if(this.matriznueva[posicion][j]!=-1)
				{
					if(this.matriznueva[posicion][j]==0)
					{
						this.matriznueva[posicion][j]=this.matriznueva[posicion-1][j];
					}
					else
					{
						variable2=this.matriznueva[posicion][j];
						variable2=variable2+this.vector2[posicion2-1];
						if(this.matriznueva[posicion-1][j]<=variable2 && this.matriznueva[posicion-1][j]!=-1)
						{
							
								this.matriznueva[posicion][j]=this.matriznueva[posicion-1][j];
							
						}
						else
						{
							this.matriznueva[posicion][j]=variable2;
						}
					}
				}
			}
		}
		
		
		j=0;
		menor=999;
		while(j<numeroVertices)
		{
			if(this.matriznueva[posicion][j]!=-1 )
				//&& this.matriznueva[posicion][j]!=0
			{
				if(this.matriznueva[posicion][j]<menor)
				{
					menor=this.matriznueva[posicion][j];
					variable=j;
				}
			}
			j++;
		}
		
		this.vector[posicion]=variable;
		this.vector2[posicion]=this.matriznueva[posicion][variable];
		
		System.out.println("\n");
		for(int r=0;r<numeroVertices;r++)
		{
			System.out.print(listaAdyacencia[r].getNodoRaiz().getInfo()+"\t\t");
		}
		System.out.println("\n");
		for(int r=0;r<numeroVertices;r++)
		{
			
			for(j=0;j<numeroVertices;j++)
			{
                	
                		System.out.print("["+this.matriznueva[r][j]+"]"+"\t\t");
			}
			System.out.print("\n");
		}
		
		
		System.out.print("\n");
		if(posicion!=numeroVertices-1)
		{
			band4=0;
			for(int k=0;k<posicion+1;k++)
			{
				if(this.vector[k]!=0)
				{
					if(k+1==posicion+1)
					{
						System.out.print("["+this.listaAdyacencia[this.vector[k]].getNodoRaiz().getInfo()+"]");
					}
					else
					{
						System.out.print("["+this.listaAdyacencia[this.vector[k]].getNodoRaiz().getInfo()+"]"+"-->");
						band4++;
					}
					
					
				}
				else
				{
					//if(k>0 && k<=numeroVertices-2 && posicion==k)
					//{
					if(k+1==posicion+1)
					{
						System.out.print("["+this.listaAdyacencia[this.vector[k]].getNodoRaiz().getInfo()+"]");
					}
					else
					{
						System.out.print("["+this.listaAdyacencia[this.vector[k]].getNodoRaiz().getInfo()+"]"+"-->");
					}
						
					//}
				}
			}
		}
		
		
	
		if(posicion<numeroVertices-1)
		{
			posicion++; band++; posicion2++;
			setDijkstra(posicion,variable,band,posicion2);
		}
		
		
	}
	public ArbolBinario getArbol() {
		return arbol;
	}
	public void setArbol(ArbolBinario arbol) {
		this.arbol = arbol;
	}
	public int[][] getMatriznueva() {
		return matriznueva;
	}
	public void setMatriznueva(int matriznueva,int valor,int valor2) {
		this.matriznueva[valor][valor2] = matriznueva;
	}
	public int getVector(int valor) {
		return vector[valor];
	}
	public void setVector(int vector,int valor) {
		this.vector[valor] = vector;
	}
	public int getVector2(int valor) {
		return vector2[valor];
	}
	public void setVector2(int vector2,int valor) {
		this.vector2[valor] = vector2;
	}
	public ListaSimple[] getListaAdyacencia() {
		return listaAdyacencia;
	}
	
	
	
	
	
	
	
	
	
	
}