

package IServices.ExtraScolaire;

import Entities.ExtraScolaire.Club;
import Services.ExtraScolaire.ServiceClub;
//import gestionEducation.Matieres;


        public interface IServiceClub {
        public void AjouterClub(Club e );
	public void modifierClub(Club m);
	public void supprimerClub(Club m);
	public void afficherListClub();
}