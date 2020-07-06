/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.ShopItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Pavle
 */
public class ShopItemServiceTest {
    
    public ShopItemServiceTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    //Testiranje metode postItem
    
    @Test
    public void testPostItem() {
        System.out.println("postItem");
        String name = "";
        float price = 5F;
        int amount = 10;
        ShopItemService instance = new ShopItemService();
        boolean expResult = false;
        boolean result = instance.postItem(name, price, amount);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testPostItem2() {
        System.out.println("postItem");
        String name = "mleko";
        float price = -2F;
        int amount = 10;
        ShopItemService instance = new ShopItemService();
        boolean expResult = false;
        boolean result = instance.postItem(name, price, amount);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testPostItem3() {
        System.out.println("postItem");
        String name = "mleko";
        float price = 5F;
        int amount = -2;
        ShopItemService instance = new ShopItemService();
        boolean expResult = false;
        boolean result = instance.postItem(name, price, amount);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testPostItem4() {
        System.out.println("postItem");
        String name = "mleko";
        float price = 50F;
        int amount = 20;
        ShopItemService instance = new ShopItemService();
        boolean expResult = true;
        boolean result = instance.postItem(name, price, amount);
        assertEquals(expResult, result);
    }
    
    //Kraj testiranja metode postItem

    
    
    //Testiranje metode removeItem
    @Test
    public void testRemoveItem() {
        System.out.println("removeItem");
        ShopItem s = new ShopItem(1, "mleko", 0, 10);
        ShopItemService instance = new ShopItemService();
        boolean expResult = true;
        boolean result = instance.removeItem(s);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRemoveItem2() {
        System.out.println("removeItem");
        ShopItem s = new ShopItem(12, "mleko", 0, 10);;
        ShopItemService instance = new ShopItemService();
        boolean expResult = true;
        boolean result = instance.removeItem(s);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRemoveItem3() {
        System.out.println("removeItem");
        ShopItem s = new ShopItem(null, "mleko", 0, 10);;
        ShopItemService instance = new ShopItemService();
        boolean expResult = false;
        boolean result = instance.removeItem(s);
        assertEquals(expResult, result);
    }
    
    //Kraj testiranja metode removeItem
    
    //Testiranje metode buy
    @Test
    public void testBuy() {
        System.out.println("buy");
        ShopItem s = new ShopItem(3, "mleko", 50, 20);
        int amount = 5;
        ShopItemService instance = new ShopItemService();
        instance.buy(s, amount);
    }
    
    //Kraj testiranja metode buy
    
    //Testiranje metode stockUp
    @Test
    public void testStockUp() {
        System.out.println("stockUp");
        ShopItem s = new ShopItem(3, "mleko", 50, 20);
        int amount = 5;
        ShopItemService instance = new ShopItemService();
        instance.stockUp(s, amount);
    }
    
    
    //Bug
    @Test
    public void testStockUp2() {
        System.out.println("stockUp");
        ShopItem s = new ShopItem(3, "mleko", 50, 20);
        int amount = -5;
        ShopItemService instance = new ShopItemService();
        instance.stockUp(s, amount);
    }
    
    //Kraj testiranja metode stockUp
    
    

    
    
    
    //Testiranje metode checkIfPopular
    @Test
    public void testCheckIfPopular() {
        System.out.println("checkIfPopular");
        ShopItem s = new ShopItem(3, "mleko", 320, 10);
        ShopItemService instance = new ShopItemService();
        boolean expResult = true;
        boolean result = instance.checkIfPopular(s);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCheckIfPopular2() {
        System.out.println("checkIfPopular");
        ShopItem s = new ShopItem(3, "mleko", 280, 60);
        ShopItemService instance = new ShopItemService();
        boolean expResult = false;
        boolean result = instance.checkIfPopular(s);
        assertEquals(expResult, result);
    }
    //Kraj testiranja metode checkIfPopular
    
    
    //Testiranje metode testGetTrending index
    @Test(expected=java.lang.IllegalArgumentException.class)
    public void testGetTrendingIndex() {
        System.out.println("getTrendingIndex");
        ShopItem s = new ShopItem(null, "mleko", 280, 60);
        ShopItemService instance = new ShopItemService();
        
        float expResult = 0.0F;
        float result = instance.getTrendingIndex(s);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testGetTrendingIndex2() {
        System.out.println("getTrendingIndex");
        ShopItem s = new ShopItem(1, "mleko", 280, 60);
        ShopItemService instance = new ShopItemService();
        
        float expResult = 0.0F;
        float result = instance.getTrendingIndex(s);
        assertEquals(expResult, result, 0.0);
        
    }
    
    @Test
    public void testGetTrendingIndex3() {
        System.out.println("getTrendingIndex");
        ShopItem s = new ShopItem(3, "mleko", 280, 60);
        ShopItemService instance = new ShopItemService();
        
        float expResult = 0.0F;
        float result = instance.getTrendingIndex(s);
        assertEquals(expResult, result, 0.0);
        
    }
    
}

//93.3/6.7
