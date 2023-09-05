import java.util.Scanner;

import java.util.concurrent.ThreadLocalRandom;

import manejador.ArbolBinario;
import manejador.ListaSimple;
import manejador.manejadorGrafo.NoDirigido;
import modelo.Nodo;

public class Test {

	public static void main(String[] args) {
		
		
		
		int opc = 0,band=0,i,band2,poss,poss2,j,band3=0,z;
		String escoger;
		
        NoDirigido grafoN = new NoDirigido();
        
        do{
        	Scanner entrada=null;
        	entrada=new Scanner(System.in);
			if(band==0)
        	{
	            System.out.println("1. Iniciar programa con nodos no dirigidos");
	            System.out.println("3. Salir");
	            System.out.print("Opcion: ");
	            opc = entrada.nextInt();
	            
	            switch(opc){
	           
	                case 1: 
	                    grafoN.crearGrafo();
	                    grafoN = grafoN.llenarGrafo(grafoN);
	                    grafoN.imprimirListaAdyacencia();
	                    System.out.println();
	                    grafoN.imprimirMatrizAdyacente();
	                    System.out.println();
	                    band=1;
	                  break;
	                case 3: System.out.println("Hasta luego.");
	                  break;
	                default: System.out.println("Opcion invalida");
	                  break;
	            }
        	}
        	else
        	{
        		System.out.print("\n");
        		System.out.println("1. Grafo");
	            System.out.println("2. Dijkstra");
	            System.out.println("3. Salir");
	            System.out.print("Opcion: ");
	            opc = entrada.nextInt();
	            
	            switch(opc)
	            {
	                case 1: 
	                    grafoN.crearGrafo();
	                    grafoN = grafoN.llenarGrafo(grafoN);
	                    grafoN.imprimirListaAdyacencia();
	                    System.out.println();
	                    grafoN.imprimirMatrizAdyacente();
	                    System.out.println();
	                    band=1;
	                  break;
	                case 2:
	                	grafoN.imprimirMatrizAdyacente();
	                	System.out.println("\n");
	                	System.out.println("Que nodo quieres escoger para Dijkstra??");
	                	escoger=entrada.next();
	                	i=0; band2=0;
	                	while(band2==0)
	                	{
	                		if(escoger.compareTo(grafoN.getListaAdyacencia(i).getNodoRaiz().getInfo())==0)
	                		{
	                			band2=1;
	                		}
	                		else
	                		{
	                			i++;
	                		}
	                	}
	                	
	                	poss=0; poss2=0; band2=0;
	                	if(band3!=0)
	                	{
		                	for(j=0;j<grafoN.getNumeroVertices();j++)
		                	{
		                		grafoN.setVector(0,j);
		                		grafoN.setVector2(0, j);
		                	}
		                	
		                	for(j=0;j<grafoN.getNumeroVertices();j++)
		                	{
		                		for(int k=0;k<grafoN.getNumeroVertices();k++)
		                		{
		                			grafoN.setMatriznueva(0,j,k);
		                		}
		                	}
	                	}
	                	grafoN.setDijkstra(poss, i, band2, poss2);
	                	
	                	for(i=0;i<grafoN.getNumeroVertices();i++)
	                	{
	                		
	                		//if(i!=0)
	                		if(grafoN.getVector(i)!=0)
	                		{
	                			//if(grafoN.getVector(i)!=grafoN.getVector(i-1))
	                			//
	                			if(i+1==grafoN.getNumeroVertices())
	                			{
	                				System.out.print("["+grafoN.getListaAdyacencia(grafoN.getVector(i)).getNodoRaiz().getInfo()+"]");
	                			}
	                			else
	                			{
	                				System.out.print("["+grafoN.getListaAdyacencia(grafoN.getVector(i)).getNodoRaiz().getInfo()+"]"+"-->");
	                			}
	                			//}
	                		}
	                		else
	                		{
	                			if(i!=grafoN.getNumeroVertices()-1)
	                			{
	                				System.out.print("["+grafoN.getListaAdyacencia(grafoN.getVector(i)).getNodoRaiz().getInfo()+"]"+"-->");
	                			}
	                			else
	                			{
	                				//System.out.print("["+grafoN.getListaAdyacencia(grafoN.getVector(i)).getNodoRaiz().getInfo()+"]");
	                			}
	                			
	                		}
	                		/*else
	                		{
	                			if(i+1!=grafoN.getNumeroVertices())
	                			{
	                				System.out.print("["+grafoN.getListaAdyacencia(grafoN.getVector(i)).getNodoRaiz().getInfo()+"]"+"\t");
	                			}
	                		}*/
	                		
	                	}
	                	band3++;
	              
	                	break;
	                case 3: System.out.println("Hasta luego.");
	                  break;
	                default: System.out.println("Opcion invalida");
	                  break;
	            }
        	}
	        
        }while(opc != 3);
     }
        
	
}

    
	


