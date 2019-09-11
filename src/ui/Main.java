package ui;

import java.util.Scanner;

import exceptions.RepeatedException;
import exceptions.RepeatedPetException;
import model.*;

public class Main {
	Inversionist inv = new Inversionist();
	Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main = new Main();
		main.showMenu();

	}
	
	public void showMenu() {
		int select = 0;
		
		System.out.println("#########################################################");
		System.out.println("################# B I E N V E N I D O ###################");
		System.out.println("############## MADE BY: SAMUEL SATIZABAL ################");
		System.out.println("#################### CHOZO COMPANY ######################");
		System.out.println("#########################################################\n");
		
		int cent = 0;
		int cent2 = 0;
		int cent3 = 0;
		int cent4 = 0;
		int cent5 = 0;
		int cent6 = 0;
		int cent7 = 0;
		while(cent <1) {
			cent2 = 0;
			System.out.println("\nQUE DESEA HACER?:");
			System.out.println("1.ADMINISTRAR CLUBES");
			System.out.println("2.ANIADIR CLUB");
			System.out.println("3.BORRAR CLUB");
			System.out.println("0.SALIR");
		
			select = sc.nextInt();
			
			if(select == 1) {
				
				while(cent2<1) {
					try {
						System.out.println("SELECCIONE EL CLUB");
						int i;
						for(i = 0; i < inv.getClubs().size();i++) {
							System.out.println(i + ") " + inv.getClubs().get(i).getName());
						}
						
						
						i = sc.nextInt();
						while(cent3<1) {
							try {
								System.out.println("\nCLUB: " + inv.getClubs().get(i).getName());
								System.out.println("QUE DESEA HACER?:");
								System.out.println("1.ADMINISTRAR CLIENTES");
								System.out.println("2.ANIADIR CLIENTE");
								System.out.println("3.ELIMINAR CLIENTE");
								System.out.println("4.VER CLIENTES");
								System.out.println("0.REGRESAR");
								
								select = sc.nextInt();
								while(cent4 < 1) {
									if(select == 1) {
										while(cent5<1) {
											System.out.println("SELECCIONE EL CLIENTE");
											int j;
											for(j = 0; j < inv.getClubs().get(i).getClients().size()-1;j++) {
												System.out.println(j + ") " + inv.getClubs().get(i).getClients().get(j).getName());
											}
											
											j = sc.nextInt();
											while(cent6 < 1) {
												System.out.println("\nCLIENTE: "+ inv.getClubs().get(i).getClients().get(j).getName());
												System.out.println("QUE DESEA HACER: ");
												System.out.println("1.ANIADIR MASCOTA");
												System.out.println("2.ELIMINAR MASCOTA");
												System.out.println("3.VER MASCOTAS");
												System.out.println("4.ORDENAR MASCOTAS");
												System.out.println("0.REGRESAR");
												
												select = sc.nextInt();
												while (cent7 < 1) {
													if(select == 1) {
														System.out.println("INGRESE ID DE LA MASCOTA:");
														int id = sc.nextInt();
														
														System.out.println("INGRESE EL NOMBRE DE LA MASCOTA:");
														sc.nextLine();
														String name = sc.nextLine();
																										
														System.out.println("INGRESE LA FECHA DE NACIMIENTO DE LA MASCOTA:");
														String bDate = sc.nextLine();
														
														System.out.println("INGRESE EL GENERO DE LA MASCOTA");
														String gender = sc.nextLine();
														
														System.out.println("INGRESE EL TIPO DE MASCOTA:");
														String type = sc.nextLine();
														
														Pet auxPet = new Pet(id, name, bDate, gender, type);
																										
														try {
															inv.getClubs().get(i).getClients().get(j).addPet(auxPet);
														} catch (RepeatedPetException e) {
															// TODO Auto-generated catch block
															e.printStackTrace();
														}
													}
												}
		
											}
										}
										
									}else if(select == 2) {
										System.out.println("INGRESE EL ID DEL CLIENTE:");
										int id = sc.nextInt();
										
										System.out.println("INGRESE EL NOMBRE DEL CLIENTE:");
										sc.nextLine();
										String name = sc.nextLine();
										
										System.out.println("INGRESE EL APELLIDO DEL CLIENTE:");
										String lName = sc.nextLine();
										
										System.out.println("INGRESE LA FECHA DE NACIMIENTO DEL CLIENTE:");
										String bDate = sc.nextLine();
										
										System.out.println("INGRESE LA MASCOTA FAVORITA DEL CLIENTE:");
										String pType =sc.nextLine();
										
										Client client = new Client(id, name, lName, bDate, pType);
										inv.getClubs().get(i).addClient(client);
										
										
									}else if (select == 3) {
										
									}else if(select == 4) {
										
									}else if (select == 0) {
										cent3++;
									}
								}
							}catch (NullPointerException e) {
								System.out.println("ERROR: No exixte el usuario ingresado");
							}catch(IndexOutOfBoundsException e) {
								System.out.println("ERROR: No hay usuarios registrados");
							} catch (RepeatedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}catch(IndexOutOfBoundsException e) {
						System.out.println("ERROR: no existen Clubes");
						cent2++;
					}catch(NullPointerException e) {
						System.out.println("ERROR: el Club no existe");
						cent2++;
					}
					
				}
				
			}else if(select == 2) {
				System.out.println("INGRESE LA ID DEL CLUB:");
				int id = sc.nextInt();
				
				System.out.println("INGRESE EL NOMBRE DEL CLUB:");
				sc.nextLine();
				String name = sc.nextLine();
				
				System.out.println("INGRESE LA FECHA DE CREACION DEL CLUB:");
				String cDate = sc.nextLine();
				
				System.out.println("INGRESE LA MASCOTA DEL CLUB:");
				String type = sc.nextLine();
				
				Club club = new Club(id, name, cDate, type);
				
				inv.addClub(club);
				
			}else if(select == 3) {
				
			}else if(select == 4) {
				
			}else if(select == 0){
				System.out.println("\nHasta luego, gracias por usar el programa!");
				cent++;
			}else {
				System.out.println("####  ERROR: opcion invalida  ####");
			}
			
		}
	}

}
