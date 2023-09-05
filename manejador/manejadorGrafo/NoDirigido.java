package manejador.manejadorGrafo;


import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import manejador.ArbolBinario;
import modelo.Nodo;


public class NoDirigido extends Grafo {

    //protected int comparar[];
    
    public NoDirigido llenarGrafo(NoDirigido grafo){
        
        Scanner entrada = new Scanner(System.in);
        Scanner entradaLinea = new Scanner(System.in);
        int random2,band=0,peso=0;
        Nodo auxiliar;
        String info,informacion,auxili;
        
        for(int i=0; i<grafo.getNumeroVertices(); i++){
            //char letra = (char)(i + 65);
        	if(i==numeroVertices-1)
        	{
        		info="CENTRAL";
        		Nodo nodo = new Nodo(info);
                grafo.getListaAdyacencia(i).setNodoRaiz(nodo);
        	}
        	else
        	{
	            System.out.println("Dame el nombre de la sucursal");
	            info=entrada.nextLine();
	            /*info = " " + letra;
	            info = info.trim();*/
	            Nodo nodo = new Nodo(info);
	            grafo.getListaAdyacencia(i).setNodoRaiz(nodo);
        	}
        }
        
        for(int i=0; i<grafo.getNumeroVertices(); i++){
            String aux;
            int opc = 0;
            
            if(i!=numeroVertices-1)
            {
	            System.out.println("\nEl vertice " + grafo.getListaAdyacencia(i).getNodoRaiz().getInfo() + " se enlaza con otro?");
	            System.out.println("1. Si");
	            System.out.println("2. No");
	            System.out.print("Opcion: ");
            
            opc = entrada.nextInt();
            }
            else
            {
            	opc=1;
            }
            if(opc == 1){
         
            		if(i==numeroVertices-1)
            		{
	            			auxili=grafo.getListaAdyacencia(i-1).getNodoRaiz().getInfo();
	            			if(grafo.getListaAdyacencia(i).getNodoRaiz().getInfo().compareTo(auxili)==0)
	                    	{
	                    		System.out.println("No se puede agregar ese nodo\n");
	                    		i=i-1;
	                    	}
	            			else
	            			{
	            				
	            			int k = 0;
	                        while(!grafo.getListaAdyacencia(k).getNodoRaiz().getInfo().equalsIgnoreCase(auxili) && (k+1)<grafo.getNumeroVertices()){
	                            k++;
	                        }
	                        
	                        if(grafo.getMatrizAdyacencia()[i][k]==0 || grafo.getMatrizAdyacencia()[i][k]==1000)
	                        {
	                        	if(grafo.getMatrizAdyacencia()[k][i]==0 || grafo.getMatrizAdyacencia()[k][i]==1000)
	                        	{
			                        if(grafo.getListaAdyacencia(k).getNodoRaiz().getInfo().equalsIgnoreCase(auxili)){
			                            Nodo nodo = new Nodo(auxili);
			                            Nodo otro = new Nodo(grafo.getListaAdyacencia(i).getNodoRaiz().getInfo());
			                            grafo.getListaAdyacencia(i).insertarFinal(nodo);
			                            grafo.getListaAdyacencia(k).insertarFinal(otro);
			                            
			                            
			                            band=0;
			                            while(band==0)
			                            {
				                            random2 = ThreadLocalRandom.current().nextInt(1, grafo.getNumeroVertices()*grafo.getNumeroVertices());
				                            Nodo nodito=new Nodo(random2);
				                            //System.out.println(this.arbol.getRaiz().getValor());
				                            auxiliar=this.arbol.buscar2(nodito, this.arbol.getRaiz());
				                            
				                            if(auxiliar!=null)
				                            {
					                            if(auxiliar.getValor()==random2)
					                            {
					                            	band=1;
					                            	peso=random2;
					                            	this.arbol.borrar2(nodito, this.arbol.getRaiz());
					                            }
				                            }
			                            }
			                            //ArbolBinario v=this.arbol;
			                            
			                            
			                            
			                            grafo.getMatrizAdyacencia()[i][k] = peso;
			                            grafo.getMatrizAdyacencia()[k][i] = peso;
			                            
			                            
			                        }
			                        }
	                        	else
	                        	{
	                        		//System.out.println("No se puede agregar un valor en la conexion, debido a que, ya tiene un peso el enlace");
	                        	}
	            			}else{
	                            System.out.println("Este nodo no existe, por lo tanto, no es posible ligarlo");
	                        }
	            		}
            		}
            		else
            		{
            	
	                do{
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
	                    System.out.println("Ingrese el vertice con el que se une, ingrese -1 para salir");
	                    aux = entradaLinea.nextLine();
	                    if(!(aux).equals("-1")){
	                    	if(grafo.getListaAdyacencia(i).getNodoRaiz().getInfo().compareTo(aux)==0)
	                    	{
	                    		System.out.println("No se puede agregar ese nodo\n");
	                    		
	                    	}
	                    	else
	                    	{
	                    		
	                        int k = 0;
	                        while(!grafo.getListaAdyacencia(k).getNodoRaiz().getInfo().equalsIgnoreCase(aux) && (k+1)<grafo.getNumeroVertices()){
	                            k++;
	                        }
	                        if(grafo.getMatrizAdyacencia()[i][k]==0 || grafo.getMatrizAdyacencia()[i][k]==1000)
	                        {
	                        	if(grafo.getMatrizAdyacencia()[k][i]==0 || grafo.getMatrizAdyacencia()[k][i]==1000)
	                        	{
			                        if(grafo.getListaAdyacencia(k).getNodoRaiz().getInfo().equalsIgnoreCase(aux)){
			                            Nodo nodo = new Nodo(aux);
			                            Nodo otro = new Nodo(grafo.getListaAdyacencia(i).getNodoRaiz().getInfo());
			                            grafo.getListaAdyacencia(i).insertarFinal(nodo);
			                            grafo.getListaAdyacencia(k).insertarFinal(otro);
			                            
			                            
			                            band=0;
			                            while(band==0)
			                            {
				                            random2 = ThreadLocalRandom.current().nextInt(1, grafo.getNumeroVertices()*grafo.getNumeroVertices());
				                            Nodo nodito=new Nodo(random2);
				           
				                            auxiliar=this.arbol.buscar2(nodito, this.arbol.getRaiz());
				                            
				                            if(auxiliar!=null)
				                            {
					                            if(auxiliar.getValor()==random2)
					                            {
					                            	band=1;
					                            	peso=random2;
					                            	this.arbol.borrar2(nodito, this.arbol.getRaiz());
					                            }
				                            }
			                            }
			                            //ArbolBinario v=this.arbol;
			                            
			                            
			                            grafo.getMatrizAdyacencia()[i][k] = peso;
			                            grafo.getMatrizAdyacencia()[k][i] = peso;
			                            
			                            
			                      
			                        } else{
			                            System.out.println("Este nodo no existe, por lo tanto, no es posible ligarlo");
			                        }
	                        	}
	                        	else
	                        	{
	                        		System.out.println("No se puede agregar un valor en la conexion, debido a que, ya tiene un peso el enlace");
	                        	}
	                    }
	                        else
	                        {
	                        	System.out.println("No se puede agregar un valor en la conexion, debido a que, ya tiene un peso el enlace");
	                        }
	                    	}
	                }
	                }while(!(aux).equals("-1"));
            }
            
            }
            
        }
        for(int r=0;r<this.numeroVertices;r++)
        {
        	for(int c=0;c<this.numeroVertices;c++)
        	{
        		if(this.matrizAdyacencia[r][c]==1000 || this.matrizAdyacencia[r][c]==0)
        		{
        			if(r==c)
        			{
        				this.matrizAdyacencia[r][c]=0;
        			}
        			else
        			{
        				this.matrizAdyacencia[r][c]=1001;
        			}
        		}
        	}
        }
        return grafo;
    }

    
}