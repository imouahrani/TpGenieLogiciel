package com.gildedrose;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;




public class GildedRoseTest {
    private Item[] arrayWith(Item item) {
        return new Item[]{item};
    }

    @Test
    public void testThatSellInValueIsDecreased() {
        Item whateverItem = new Item("whatever", 10, 0);

        GildedRose gildedRose = new GildedRose(arrayWith(whateverItem));
        gildedRose.updateQuality();

        assertEquals(whateverItem.sellIn, 9);
    }

    @Test
    public void testThatQualityValueIsDecreased() {
        Item whateverItem = new Item("whatever", 1, 10);

        GildedRose gildedRose = new GildedRose(arrayWith(whateverItem));
        gildedRose.updateQuality();

        assertEquals(whateverItem.quality, 9);
    }

    @Test
    public void testThatQualityDecreasesTwiceAsMuchWhenSellByIsPassed() {
        Item whateverItem = new Item("whatever", 0, 10);

        GildedRose gildedRose = new GildedRose(arrayWith(whateverItem));
        gildedRose.updateQuality();

        assertEquals(whateverItem.quality, 8);
    }

    @Test
    public void testThatQualityIsNeverNegative() {
        Item whateverItem = new Item("whatever", 0, 0);

        GildedRose gildedRose = new GildedRose(arrayWith(whateverItem));
        gildedRose.updateQuality();

        assertEquals(whateverItem.quality, 0);
    }

    @Test
    public void testAgedBrieIncreasesQualityWithAge() {
        Item agedBrie = new Item("Aged Brie", 5, 1);

        GildedRose gildedRose = new GildedRose(arrayWith(agedBrie));
        gildedRose.updateQuality();

        assertEquals(agedBrie.quality, 2);
    }

    @Test
    public void testQualityNeverIncreasesPastFifty() {
        Item agedBrie = new Item("Aged Brie", 5, 50);

        GildedRose gildedRose = new GildedRose(arrayWith(agedBrie));
        gildedRose.updateQuality();

        assertEquals(agedBrie.quality, 50);
    }

    @Test
    public void testSulfurasNeverChanges() {
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 25);

        GildedRose gildedRose = new GildedRose(arrayWith(sulfuras));
        gildedRose.updateQuality();

        assertEquals(sulfuras.quality, 25);
        assertEquals(sulfuras.sellIn, 0);
    }

    @Test
    public void testBackstagePassIncreasesQualityByOneIfSellByGreaterThenTen() {
        Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20);

        GildedRose gildedRose = new GildedRose(arrayWith(backstagePasses));
        gildedRose.updateQuality();

        assertEquals(backstagePasses.quality, 21);
    }

    @Test
    public void testBackstagePassIncreasesQualityByTwoIfSellBySmallerThanTen() {
        Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 20);

        GildedRose gildedRose = new GildedRose(arrayWith(backstagePasses));
        gildedRose.updateQuality();

        assertEquals(backstagePasses.quality, 22);
    }

    @Test
    public void testBackstagePassIncreasesQualityByThreeIfSellBySmallerThanFive() {
        Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20);

        GildedRose gildedRose = new GildedRose(arrayWith(backstagePasses));
        gildedRose.updateQuality();

        assertEquals(backstagePasses.quality, 23);
    }

    @Test
    public void testBackstagePassLosesValueAfterSellByPasses() {
        Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);

        GildedRose gildedRose = new GildedRose(arrayWith(backstagePasses));
        gildedRose.updateQuality();

        assertEquals(backstagePasses.quality, 0);
    }
    
    //SEANCE 2
    @Test
    void nameStaysTheSameWhenUpdatingQuality() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void qualityOf0Stays0whenSellinPassed() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void qualityOf0Stays0whileSellin() {
        Item[] items = new Item[] { new Item("foo", 0, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void qualityOf50Becomes48whenSellinPassed() {
        Item[] items = new Item[] { new Item("foo", -1, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(48, app.items[0].quality);
    }

    @Test
    void qualityOf50Becomes49whileInSellin() {
        Item[] items = new Item[] { new Item("foo", 1, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(49, app.items[0].quality);
    }

    @Test
    void sellinLowersEachDay() {
        Item[] items = new Item[] { new Item("foo", 10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void qualityOf51Becomes50whileInSellin() {
        Item[] items = new Item[] { new Item("foo", 1, 51) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void qualityAndSellinOfSulfurasNeverDescrease() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
    }

    @Test
    void agedBrieIncreasesQualityWhenOlder() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void agedBrieIncreasesQualityTwiceAfterSellin() {
        Item[] items = new Item[] { new Item("Aged Brie", -1, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void qualityIsNeverOver50() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 50), new Item("Backstage passes to a TAFKAL80ETC concert", 2, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(50, app.items[1].quality);
    }

    @Test
    void backstagePassesIncreasesQualityBy2When10daysFromSellin() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void backstagePassesIncreasesQualityBy2When10daysFromSellinUnless50() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void backstagePassesIncreasesQualityBy3When5daysFromSellin() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
    }

    @Test
    void backstagePassesIncreasesQualityBy3When5daysFromSellinUnless50() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 48) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void backstagePassesDromsQualityTo0AfterConcert() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void conjuredItemsDegradeTwiceAsFastBeforeSellin() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 10, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(49, app.items[0].quality);
    }


    @Test
    void conjuredItemsDegradeTwiceAsFastAfterSellin() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", -1, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(48, app.items[0].quality);
    }

    @Test
    void conjuredItemsDegradeTwiceAsFastAfterSellinUntilZero() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", -1, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }
    //seance 3
    @Test
    public void sellInDateDecreases_butQualityCannotBeNegative() {
       
        
        Item whateverItem = new Item("whatever", 0, 0);

        GildedRose gildedRose = new GildedRose(arrayWith(whateverItem));
        gildedRose.updateQuality();

        assertEquals(whateverItem.sellIn, -1);
        assertEquals(whateverItem.quality, 0);
    }
    @Test
    public void qualityDecreases() {
       
        
        Item whateverItem = new Item("whatever", 10, 10);

        GildedRose gildedRose = new GildedRose(arrayWith(whateverItem));
        gildedRose.updateQuality();

        assertEquals(whateverItem.sellIn, 9);
        assertEquals(whateverItem.quality, 9);
    }
    @Test
    public void qualityDecreasesFasterAfterSellInDateExpired() {
       
        
        Item whateverItem = new Item("whatever", 0, 10);

        GildedRose gildedRose = new GildedRose(arrayWith(whateverItem));
        gildedRose.updateQuality();

        assertEquals(whateverItem.sellIn, -1);
        assertEquals(whateverItem.quality, 8);
    }
    

    @Test
    public void updateQuality_withDexterity_should_sellInMinusOne_and_qualityMinusOne() {
       
        
        Item whateverItem = new Item("whatever", 10, 20);

        GildedRose gildedRose = new GildedRose(arrayWith(whateverItem));
        gildedRose.updateQuality();

        assertEquals(whateverItem.sellIn, 9);
        assertEquals(whateverItem.quality, 19);
    }
    @Test
    public void updateQuality_withSulfuras_should_sellIn_Same_and_quality_80() {
       
        
        Item whateverItem = new Item("whatever", -1, 80);

        GildedRose gildedRose = new GildedRose(arrayWith(whateverItem));
        gildedRose.updateQuality();

        assertEquals(whateverItem.sellIn, -2);
        assertEquals(whateverItem.quality, 78);
    }
    @Test
    public void updateQuality_withElixir_should_sellInMinusOne_and_qualityMinusOne() {
       
        
        Item whateverItem = new Item("whatever", 5, 7);

        GildedRose gildedRose = new GildedRose(arrayWith(whateverItem));
        gildedRose.updateQuality();

        assertEquals(whateverItem.sellIn, 4);
        assertEquals(whateverItem.quality, 6);
    }
    
    @Test
    public void updateQuality_withElixir_outOfTheDate_should_sellIn_Minus1_and_quality_Minus2() {
       
        
        Item whateverItem = new Item("whatever", 0, 5);

        GildedRose gildedRose = new GildedRose(arrayWith(whateverItem));
        gildedRose.updateQuality();

        assertEquals(whateverItem.sellIn, -1);
        assertEquals(whateverItem.quality, 3);
    }
    @Test
    public void updateQuality_withAgedBrie_should_sellInMinusOne_and_qualityPlusOne() {
       
        
        Item whateverItem = new Item("whatever", 2, 1);

        GildedRose gildedRose = new GildedRose(arrayWith(whateverItem));
        gildedRose.updateQuality();

        assertEquals(whateverItem.sellIn, 1);
        assertEquals(whateverItem.quality, 0);
    }
    @Test
    public void updateQuality_withElixir_outOfTheDate_should_sellIn_Minus1_and_quality_Zero() {
       
        
        Item whateverItem = new Item("whatever", 0, 5);

        GildedRose gildedRose = new GildedRose(arrayWith(whateverItem));
        gildedRose.updateQuality();

        assertEquals(whateverItem.sellIn, -1);
        assertEquals(whateverItem.quality, 3);
    }
    @Test
    public void updateQuality_withBackstageConcert_withSellIn5_should_sellIn_Minus1_and_quality_Max50() {
       
        
        Item whateverItem = new Item("whatever", 5, 49);

        GildedRose gildedRose = new GildedRose(arrayWith(whateverItem));
        gildedRose.updateQuality();

        assertEquals(whateverItem.sellIn, 4);
        assertEquals(whateverItem.quality, 48);
    }
    @Test
    public void updateQuality_withAgedBrie_outOfTheDate_should_sellIn_Minus1_and_quality_Plus2() {
       
        
        Item whateverItem = new Item("whatever", -1, 48);

        GildedRose gildedRose = new GildedRose(arrayWith(whateverItem));
        gildedRose.updateQuality();

        assertEquals(whateverItem.sellIn, -2);
        assertEquals(whateverItem.quality, 46);
    }
    @Test
    public void updateQuality_withBackstageConcert_outOfTheDate_should_sellIn_Minus1_and_quality_0() {
       
        
        Item whateverItem = new Item("whatever", -1, 80);

        GildedRose gildedRose = new GildedRose(arrayWith(whateverItem));
        gildedRose.updateQuality();

        assertEquals(whateverItem.sellIn, -2);
        assertEquals(whateverItem.quality, 78);
        
    }
    @Test
    public void updateQuality_withBackstageConcert_should_sellIn_Minus1_and_quality_Plus1() {
       
        
        Item whateverItem = new Item("whatever", 15, 20);

        GildedRose gildedRose = new GildedRose(arrayWith(whateverItem));
        gildedRose.updateQuality();

        assertEquals(whateverItem.sellIn, 14);
        assertEquals(whateverItem.quality, 19);
        
    }
     @Test
    public void updateQuality_withBackstageConcert_withSellIn10_should_sellIn_Minus1_and_quality_Max50() {
       
        
        Item whateverItem = new Item("whatever", 10, 49);

        GildedRose gildedRose = new GildedRose(arrayWith(whateverItem));
        gildedRose.updateQuality();

        assertEquals(whateverItem.sellIn, 9);
        assertEquals(whateverItem.quality, 48);
        
    }
      @Test
    public void updateQuality_withBackstageConcert_withSellIn10_should_sellIn_Minus1_and_quality_Plus2() {
       
        
        Item whateverItem = new Item("whatever", 10, 40);

        GildedRose gildedRose = new GildedRose(arrayWith(whateverItem));
        gildedRose.updateQuality();

        assertEquals(whateverItem.sellIn, 9);
        assertEquals(whateverItem.quality, 39);
        
    }
      @Test
    public void updateQuality_withBackstageConcert_withSellIn5_should_sellIn_Minus1_and_quality_Plus3() {
       
        
        Item whateverItem = new Item("whatever", 5, 40);

        GildedRose gildedRose = new GildedRose(arrayWith(whateverItem));
        gildedRose.updateQuality();

        assertEquals(whateverItem.sellIn, 4);
        assertEquals(whateverItem.quality, 39);
        
    }
     @Test
    public void updateQuality_withBackstageConcert_withSellIn1_should_sellIn_Minus1_and_quality_Plus3() {
       
        
        Item whateverItem = new Item("whatever", 1, 40);

        GildedRose gildedRose = new GildedRose(arrayWith(whateverItem));
        gildedRose.updateQuality();

        assertEquals(whateverItem.sellIn, 0);
        assertEquals(whateverItem.quality, 39);
        
    }
     @Test
    public void updateQuality_withConjured_should_sellIn_Minus1_and_quality_Minus4() {
       
        
        Item whateverItem = new Item("whatever", 0, 6);

        GildedRose gildedRose = new GildedRose(arrayWith(whateverItem));
        gildedRose.updateQuality();

        assertEquals(whateverItem.sellIn, -1);
        assertEquals(whateverItem.quality, 4);
        
    }

}
