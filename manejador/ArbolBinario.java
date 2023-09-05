package manejador;

import modelo.Nodo;



public class ArbolBinario {
	public Nodo raiz;
	
	
	public ArbolBinario() {
		this.raiz=null;
	}
		
		

		public Nodo getRaiz() {
			return this.raiz;
		}

		public void setRaiz(Nodo raiz) {
			this.raiz = raiz;
		}
		
		public boolean agregar(Nodo nodo,Nodo raiz)
		{
			if(raiz==null)
			{
				this.raiz= nodo;
				return true;
			}
			else
			{
				if(nodo.getValor()<raiz.getValor() && raiz.getIzq()==null)
				{
					raiz.setIzq(nodo);
					return true;
				}
				
				if(nodo.getValor()>raiz.getValor() && raiz.getDer()==null)
				{
					raiz.setDer(nodo);
					return true;
				}
				
				if(nodo.getValor()<raiz.getValor() && raiz.getIzq()!=null)
				{
					raiz= raiz.getIzq();
					return (agregar(nodo,raiz));
				}
				
				if(nodo.getValor()>raiz.getValor() && raiz.getDer()!=null)
				{
					raiz=raiz.getDer();
					return (agregar(nodo,raiz));
				}
				
				
			}
			return false;
			
		}

		
		
		public void preOrden2(Nodo nodo) {
			if(nodo != null)
			{
				System.out.print("\t"+nodo.getValor());
				preOrden2(nodo.getIzq());
				preOrden2( nodo.getDer());
			}
			
			
		}
		
		public void inOrden2(Nodo nodo) {
			
			if(nodo!=null)
			{
				inOrden2(nodo.getIzq());
				System.out.print("\t"+nodo.getValor());
				inOrden2(nodo.getDer());
			}
			
		}
		
		public void postOrden2(Nodo nodo) {
		
			if(nodo!=null) 
			{
				postOrden2(nodo.getIzq());
				postOrden2(nodo.getDer());
				System.out.print("\t"+nodo.getValor());
			}
			
		}
		
		public Nodo buscar2(Nodo nodo,Nodo raiz)
		{
			
				if( nodo.getValor()==raiz.getValor())
				{
					//System.out.println("Se elimino el nodo "+nodo.getValor());
					return null;
				}
				else
				{
					
					if( raiz.getDer()!=null &&  raiz.getDer().getValor()== nodo.getValor() )
					{
						
						System.out.println("Su padre es: "+raiz.getValor()+" y el nodo se encuentra en la parte derecha"+", se elimino el nodo "+raiz.getDer().getValor()+"\n");
						return raiz.getDer();
					}
					
					if( raiz.getIzq()!=null &&  raiz.getIzq().getValor()==nodo.getValor())
					{
						
						System.out.println("Su padre es: "+raiz.getValor()+" y el nodo se encuentra en la parte izquierda"+", se elimino el nodo "+raiz.getIzq().getValor()+"\n");
						return raiz.getIzq();
					}
					if( raiz.getDer()!=null && nodo.getValor()>=raiz.getValor())
					{
						raiz= raiz.getDer();
						return (buscar2(nodo,raiz));
					}
					if(raiz.getIzq()!=null && nodo.getValor()<=raiz.getValor())
					{
						raiz=raiz.getIzq();
						return (buscar2(nodo,raiz));
					}	
				}
				return null;
			
		}
		public Nodo buscar(Nodo nodo,Nodo raiz) {
			if( nodo.getValor()==raiz.getValor())
			{
				//System.out.println("Se elimino el nodo "+nodo.getValor());
				return null;
			}
			else
			{
				
				if( raiz.getDer()!=null &&  raiz.getDer().getValor()== nodo.getValor() )
				{
					
					
					return raiz.getDer();
				}
				
				if( raiz.getIzq()!=null &&  raiz.getIzq().getValor()==nodo.getValor())
				{
					
					
					return raiz.getIzq();
				}
				if( raiz.getDer()!=null && nodo.getValor()>=raiz.getValor())
				{
					raiz= raiz.getDer();
					return (buscar(nodo,raiz));
				}
				if(raiz.getIzq()!=null && nodo.getValor()<=raiz.getValor())
				{
					raiz=raiz.getIzq();
					return (buscar(nodo,raiz));
				}	
			}
			return null;
			
		}
		
		public boolean borrar2(Nodo nodo,Nodo raiz)
		{
			int band=0;
			Nodo aux=null,auxx=null,valor=null,valor2=null,resultado=null,resultado2=null;
			Nodo copia=null;
			if(nodo.getValor()==raiz.getValor())
			{
				//checar las tres opciones
				if(raiz.getDer()==null && raiz.getIzq()==null)
				{
					//this.raiz=null;
					raiz=null;
					System.out.println("Eliminacion exitosa");
					return true;
					
				}
				if((raiz.getDer()!=null && raiz.getIzq()==null) || (raiz.getIzq()!=null && raiz.getDer()==null))
				{
					if(raiz.getDer()!=null && raiz.getIzq()==null)
					{
						raiz.setValor(raiz.getDer().getValor());
						raiz.setDer(null);
						System.out.println("Eliminacion exitosa");
						return true;
					}
					if(raiz.getIzq()!=null && raiz.getDer()==null)
					{
						raiz.setValor(raiz.getIzq().getValor());
						raiz.setIzq(null);
						System.out.println("Eliminacion exitosa");
						return true;
					}
				}
				if(raiz.getDer()!=null && raiz.getIzq()!=null)
				{
					valor2=raiz.getDer();
					resultado=recorrerIzq(valor2);
					resultado2=resultado;
					
					borrar2(resultado2,raiz);
					raiz.setValor(resultado.getValor());
					
				}
				
			}
			else
			{
				if(raiz.getIzq()!=null && nodo.getValor()!=raiz.getIzq().getValor() && nodo.getValor()<=raiz.getValor())
				{
					raiz=raiz.getIzq();
					return borrar2(nodo,raiz);
				}
				if(raiz.getDer()!=null && nodo.getValor()!=raiz.getDer().getValor() && nodo.getValor()>=raiz.getValor())
				{
					raiz=raiz.getDer();
					return borrar2(nodo,raiz);
				}
				//ESTAMOS EN LA IZQUIERDA
				if(raiz.getIzq()!=null && nodo.getValor()==raiz.getIzq().getValor() && nodo.getValor()<=raiz.getValor())
				{
					aux=raiz.getIzq();
					if(aux.getDer()==null && aux.getIzq()==null)
					{
						raiz.setIzq(null);
						System.out.println("Eliminacion exitosa");
						return true;
					}
					if((aux.getDer()!=null && aux.getIzq()==null) || (aux.getIzq()!=null && aux.getDer()==null))
					{
						if(aux.getDer()!=null && aux.getIzq()==null)
						{
							auxx=aux.getDer();
							raiz.setIzq(null);
							raiz.setIzq(auxx);
							System.out.println("Eliminacion exitosa");
							return true;
						}
						if(aux.getIzq()!=null && aux.getDer()==null)
						{
							valor=aux.getIzq();
							raiz.setIzq(null);
							raiz.setIzq(valor);
							System.out.println("Eliminacion exitosa");
							return true;
						}
					}
					if(aux.getDer()!=null && aux.getIzq()!=null)
					{
						valor2=aux.getDer();
						//resultado es el mas de la izquierda
						resultado=recorrerIzq(valor2);
						resultado2=resultado;
						//aux.setInfo(resultado.getInfo());
						//pero ahora tengo que checar si resultado tiene dos hijos o uno
						//podria llamar a la funcion borrar
						copia=aux;
						
						borrar2(resultado2,aux);
						copia.setValor(resultado.getValor());	
						
					}
					//checar los tres casos, pero raiz esta en el padre
				}
				//ESTAMOS EN LA DERECHA
				if(raiz.getDer()!=null && nodo.getValor()==raiz.getDer().getValor() && nodo.getValor()>=raiz.getValor())
				{
					aux=raiz.getDer();
					if(aux.getDer()==null && aux.getIzq()==null)
					{
						raiz.setDer(null);
						System.out.println("Eliminacion exitosa");
						return true;
					}
					if((aux.getDer()!=null && aux.getIzq()==null) || (aux.getIzq()!=null && aux.getDer()==null))
					{
						if(aux.getDer()!=null && aux.getIzq()==null)
						{
							auxx=aux.getDer();
							raiz.setDer(null);
							raiz.setDer(auxx);
							System.out.println("Eliminacion exitosa");
							return true;
						}
						if(aux.getIzq()!=null && aux.getDer()==null)
						{
							valor=aux.getIzq();
							raiz.setDer(null);
							raiz.setDer(valor);
							System.out.println("Eliminacion exitosa");
							return true;
						
						}
					}
					if(aux.getDer()!=null && aux.getIzq()!=null)
					{
						valor2=aux.getDer();
						resultado=recorrerIzq(valor2);
						resultado2=resultado;
						copia=aux;
						
						borrar2(resultado2,aux);
						copia.setValor(resultado.getValor());	
						
					}
				}
				
			}
			return false;
			}
			
		
		
		
		public Nodo recorrerIzq2(Nodo nodo,Nodo raiz) {
			
			if (nodo.getIzq().getValor()==raiz.getValor()) {
				return nodo;
		        
		    }
			 if (nodo.getIzq() != null)
			 {
				 nodo=nodo.getIzq();
				 return recorrerIzq2(nodo,raiz);
			 }
		    return null;
		}
		public Nodo recorrerIzq(Nodo nodo) {
		    if (nodo.getIzq() != null) {
		    	nodo=nodo.getIzq();
		        return recorrerIzq(nodo);
		    }
		    return nodo;
		}
	
	
	

}

