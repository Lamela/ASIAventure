package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.Simulateur;
import java.io.*;
import java.util.Scanner;

/**
  *Class main.
  *
  *@author Luchenxin
  */
public class Main{

	public static void main(String[] args) throws Throwable{
		Simulateur sm = null;
		int choix;
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println("\t--- Menu ---\n1/ jouer\n2/ charger un fichier de description\n3/ sauver la partie actuelle\n4/ charger une partie\n5/ quitter\n");
			choix = sc.nextInt();
			switch(choix){
				case 1:
					sm.executerUnTour();
					System.out.println("Est-ce que vous voulez rejouer? YES or NO");
					String reponse = sc.next();
					while(reponse.toUpperCase().equals("YES")){
						sm.executerUnTour();
						System.out.println("Est-ce que vous voulez rejouer? YES or NO");
						reponse = sc.next();
					}
					break;
				case 2:
					System.out.println("Entrez le chemin d'un fichier de description, svp.");
					try{
						if(sc.hasNext()){
							String str = sc.next();
							File file = new File(str);
							sm = new Simulateur(new FileReader(file));
						}
					}catch(IOException e){
						System.out.print("Exception.\n");
					}
					break;
				case 3:
					System.out.println("Entrez le chemin d'un fichier de description, svp.");
						if(sc.hasNext()){
							String str = sc.next();
							ObjectOutputStream  oos = new ObjectOutputStream(new FileOutputStream(str));
							sm.enregistrer(oos);
						}
					break;
				case 4:
					System.out.println("Entrez le chemin d'un fichier de description, svp.");
					try{
						if(sc.hasNext()){
							String str = sc.next();
							ObjectInputStream ois = new ObjectInputStream(new FileInputStream(str));
							sm = new Simulateur(ois);
						}
					}catch(IOException e){
						System.out.print("Exception.\n");
					}
					break;
				case 5:
					return ;
			}
		}while(choix!=5);
	}
}
