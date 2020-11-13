package com.gildedrose;

 public class UpdatePass {
 
 public void  addQualityPass(Item item) {
    boolean iSmidLate = item.sellIn < 11; // S'il reste 10 jours au moins
    boolean iSlate = item.sellIn < 6; // S'il reste 5 jours au moins
    boolean iSoutOfTheDate= item.sellIn <= 0; // Si le produit est périmé
        
	int count = iSoutOfTheDate ? -item.quality : iSlate ? 3 : iSmidLate ? 2 : 0;
		/* -La qualité augmente de 3 quand il reste 5 jours ou moins
	    -La qualité augmente de 2 quand il reste 10 jours ou moins 
	    -La qualité tombe à 0 après le concert.
         */
        addQuality(item, count); // augmente sa qualité ('quality') plus le temps passe ('sellIn')
    }
  
		private void addQuality(Item item, int count) {
        item.quality = Math.max(0, Math.min(Math.max(50, item.quality), item.quality + count)); //La qualité d'un article n'est jamais supérieure à 50
    }
 
 
 }
