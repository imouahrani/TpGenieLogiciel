package com.gildedrose;


class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateQuality(item);
            updateDate(item);
        }
    }

    private void updateQuality(Item item) {
        if (item.isBrie()) {
			new UpdateAgedBrie().updateBrie(item);
        } else if (item.isPasses()) {
            new UpdatePass().addQualityPass(item);
        } else if (item.isConjured()) {
            new UpdateConjured().updateConj(item);
        } else if (!item.isSulfuras()) {
			new UpdateNotSulfarus().notSulf(item);
        } else if (item.isSulfuras()) {
			new UpdateSulfarus().legendaryProduct(item);
           
        }
    }

/* - "Sulfuras", étant un objet légendaire, n'a pas de date de péremption;
   - Les autres produits ne sont pas légendaires.
*/
 private void updateDate(Item item) {
        if (!item.isSulfuras()) {
            item.sellIn = item.sellIn - 1;
        }
    }

    
}
 