package com.gildedrose;

public class UpdateAgedBrie{
	public void updateBrie(Item item){
		addQuality(item, item.sellIn <= 0 ? 2 : 1); 	
		//Le brie vieilli, augmente en qualité à mesure que la valeur de "SellIn" approche 
	}


	private void addQuality(Item item, int count) {
		item.quality = Math.max(0, Math.min(Math.max(50, item.quality), item.quality + count)); //La qualité d'un article n'est jamais supérieure à 50
	}
}