package com.gildedrose;

public class UpdateConjured{
	public void updateConj(Item item){
		minusQuality(item);
		minusQuality(item); // Les éléments "Conjured" voient leur qualité se dégrader de deux fois plus vite que les objets normaux.

	}

	private void minusQuality(Item item) {
		if (item.quality > 0) {
				addQuality(item, item.sellIn <= 0 ? -2 : -1); // Une fois que la date de péremption est passée, la qualité se dégrade deux fois plus rapidement.
		}
	}

	private void addQuality(Item item, int count) {
			item.quality = Math.max(0, Math.min(Math.max(50, item.quality), item.quality + count)); //La qualité d'un article n'est jamais supérieure à 50
	}

}