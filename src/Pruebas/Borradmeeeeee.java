import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

JPanel panel1b =  new JPanel(){
																					public void paintComponent(Graphics g) {
																				        Image bufferImage = this.createImage(this.getSize().width, this.getSize().height);
																				        Graphics bufferGraphics = bufferImage.getGraphics();
																				        bufferGraphics.drawImage(imagenInicio.getImage(), 0, 0, 1080, 720, null);
																				        g.drawImage(bufferImage, 0, 0, this);
																				       
																				    }
																		       };
																				CrearPanel(panel1b);
																				
																				
																				panelesbebida.add(panel1b);
																				frame.getContentPane().add(panel1b);
																				panelesbebida.get(0).updateUI();
																				
																				
																				
																				
																				
																				
																				
																				int sb= 40;
																				
																				int pb = 185;
																				CambiarPanel(panelespostre.get(enQuePanel), panelesbebida.get(0));
																				for (int x = 0; x <40 ; x++) { //creamos 40 paneles (eso tiene que cambiar con la bd)
																					JPanel panelesMultbeb = new JPanel();  //creamos mas paneles
																					JLabel lbebida = new JLabel();
																					lbebida.setBounds(400, 50, 1000, 40);
																					
																				       lbebida.setFont(titulos);
																				       lbebida.setForeground(Color.WHITE);
																				       lbebida.setSize(500, 50);
																				       lbebida.setText("Bebida");
																					panelesMultbeb.setName("panelesMult" + x); //le ponemos un nombre
																					CrearPanel(panelesMultbeb);  //Le damoslos datos basicos
																					frame.getContentPane().add(panelesMultbeb); //lo añadimos al frame
																					panelesbebida.add(panelesMultbeb);  //Lo metemos en el array de paneles
																					panelesbebida.get(x).add(lbebida);
																					JButton botonSiguientePanelbebida = new JButton("siguiente panel"); //Creamos el boton para pasar al siguiente panel
																					botonSiguientePanelbebida.setBounds(390, 550, 300, 75); //La posicion del boton
																					
																					botonSiguientePanelbebida.setName("bSiguiente"+x);  //Ponemos nombre al boton
																					cambiobebida.add(botonSiguientePanelbebida);  //Lo añadimos al array de botones
																					panelesbebida.get(x).add(botonSiguientePanelbebida); //añadimos el boton para cambiar de panel a cada panel
																					panelesbebida.get(x).updateUI(); //Actualizamos el panel para que se visualize el boton para cambiar de panel
																					
																					botonSiguientePanelbebida.addActionListener(new ActionListener() {
																				
																						@Override
																						public void actionPerformed(ActionEvent arg0) {
																							// TODO Auto-generated method stub
																							
																							CambiarPanel(panelesbebida.get(pruebab), panelesbebida.get(pruebab+1)); //Cambiamos de paneles prueba elige el numero de panel
																							
																							pruebab++; //Incrementamos prueba para que se pueda pasar de panel
																							enQuePanel = pruebab;
																							panelesbebida.get(pruebab).add(botonSiguientePanelbebida); //Añadimos el boton al panel es necesario repetir??(mirar arriba)
																							panelesbebida.get(pruebab).updateUI(); //Actualizamos el panel para que aparezca el boton, es realmente necesario repetirlo??
																							
																						}
																						
																					});
																					if (x==0) {  //si es el primer panel se añade un boton a panel1 para pasar al panel siguiente
																						panel1b.add(cambiobebida.get(0)); 
																					} else if (x>0) {//si no es el primer panel ponemos un boton al panel el cual sirva para pasar al siguiente panel
																						//he quitadp panelesMult.getName();
																						panelesMultbeb.add(cambiobebida.get(x));
																					}
																					for (int i = 0; i < 3; i++) {//son filas columnas de botones por panel
																						
																			
																						for (int o = 0; o < 3; o++) {//son tres columnas de botones por panel
																							
																							JButton pp2b = new JButton(); //Creamos el boton del plato
																							//CrearBoton(pp2);
																							pp2b.setBounds(sb, pb,300, 75); // con s y p vamos cambiando la posicion del siguiente boton
																							pp2b.setText("prueba"+x+i+o); // Nombramos los botones para diferenciarlos (Aqui hay que ponerlo con la bd
																							botonesbebida.add(pp2b); //añadimos el boton al arraylist de botones
																							sb=320+sb; //Incrementamos s para que el boton siguiente este a la izquierda
																							panelesbebida.get(x).add(pp2b); //añadimos el boton al panel correspondiente
																							panelesbebida.get(x).updateUI(); //actualizamos el panel para que muestre los botones
																							pp2b.setName("prueba"+x+i+o);	//nombramos el boton para saber cual es (sacar de la bd)
																							panel1b.updateUI(); //actualizamos el panel1 a parte creo que esto sobra pero soy gilipollas y no tengo tiempo para mirarlo
																							pp2b.addActionListener(new ActionListener () {

																						
																								@Override
																								public void actionPerformed(ActionEvent arg0) {
																									// TODO Auto-generated method stub
																									//me cago en dioooooooooooooooooooooososososoossos
																									CambiarPanel(panelesbebida.get(enQuePanel), panelFactura);
																									
																								}
																								
																							});
																							//pp2.setActionCommand(pp2.getText());	//Aqui hay que coger de la base de datos el nombre
																							
																							//he borrado borrarbo++;
																							
																				    	}
																					
																						pb=pb+100;//aumentamos la y de los botones
																						sb=40;//iniciamos la columna de nuevo
																						//he borrado borrarbi++;
																					}
																					sb=40;//iniciamos la columna de nuevo
																					pb=185; //iniciamos
																				}
																				for (int i = 0; i < botonesbebida.size(); i++) {//imprimimos los datos de los botones que hemos creado
																					System.out.println(botonesbebida.get(i));
																					
																				}
																				
																				
																				
																				
																				
																				
																				
																				
																				
																				
																				
																				
																				
																				
																				
																				
																		
																			}
																			
																		});