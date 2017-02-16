package fr.insarouen.asi.prog.asiaventure;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.objets.PiedDeBiche;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;
import fr.insarouen.asi.prog.asiaventure.EtatDuJeu;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ElementStructurel;

public class ClassMainTest{

  public static void main(String[] args){
    Monde md = new Monde("Hoth");
    Objet balle = new Objet("Balle", md){};
    PiedDeBiche p = new PiedDeBiche("p",md);
    Entite test = new Entite("test", md){};
    Entite test1 = new Entite("test", md){};
    Entite test2 = new Entite("test1",md){};
    Entite test3 = new Entite(){};
    md.ajouter(test);
    test3 = md.getEntite(test.getNom());
    md.ajouter(test1);
    md.ajouter(test2);

    if(test.equals(test1)){
      System.out.println("Egaux");
    }
    if(!(test.equals(test2))){
      System.out.println("Pas égaux");
    }
    System.out.println(test);
    System.out.println(test1);
    System.out.println(test3);
    System.out.println(md);
    System.out.println(balle);

  }
}

