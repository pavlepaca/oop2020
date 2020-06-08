/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.common.reflect.TypeToken;
import java.lang.reflect.Type;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import model.Client;
import model.DeliveryService;
import model.ShopItem;
import model.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.mockito.*;

/**
 *
 * @author Pavle
 */
public class TransactionServiceTest {
    ClientService cs = new ClientService();
    
    Client c;
    ShopItem si;
    DeliveryService ds;
    ShopItemService sis;
    
    public TransactionServiceTest() {
    }
    
    @Before
    public void setUp() {
       c = cs.login("pavle21", "pavle21");
       si = new ShopItem(3, "mleko", 50, 25);
        ds = new DeliveryService(2, "pMotors", 10, 15);
         sis = new ShopItemService();
       
    }
    
    @After
    public void tearDown() {
    }
    
    
    //Testiranje metode completeTransaction
    @Test
    public void testCompleteTransaction() {
        System.out.println("completeTransaction");
        
        int amount = 5;
        float distance = 1F;
        TransactionService instance = new TransactionService(sis);
        instance.completeTransaction(c, ds, si, amount, distance);
    }
    
    //Bugovi
    @Test(expected = java.lang.IllegalArgumentException.class)
    public void testCompleteTransaction2() {
        System.out.println("completeTransaction");
        
        int amount = 5;
        float distance = 1F;
        c.setId(null);
        TransactionService instance = new TransactionService(sis);
        instance.completeTransaction(c, ds, si, amount, distance);
    }
    
    @Test(expected = java.lang.IllegalArgumentException.class)
    public void testCompleteTransaction3() {
        System.out.println("completeTransaction");
        
        int amount = 5;
        float distance = 1F;
        ds.setId(null);
        TransactionService instance = new TransactionService(sis);
        instance.completeTransaction(c, ds, si, amount, distance);
    }
    
    @Test(expected = java.lang.IllegalArgumentException.class)
    public void testCompleteTransaction4() {
        System.out.println("completeTransaction");
        
        int amount = 5;
        float distance = 1F;
        si.setId(null);
        TransactionService instance = new TransactionService(sis);
        instance.completeTransaction(c, ds, si, amount, distance);
    }
    
    //Kraj testiranja metode completeTransaction
    
    
    //Testiranje metode getRecentTransactions
    //Bug
    @Test
    public void testGetRecentTransactions() {
        System.out.println("getRecentTransactions");
        TransactionService instance = new TransactionService(sis);
        Type t = new TypeToken<ArrayList<Transaction>>(){}.getType();
        ArrayList<String> ar = new ArrayList<String>();
        ar.add("p");
        ar.add("p");
        ar.add("p");
        ar.add("p");
        ar.add("p");
        ArrayList<Transaction> result = instance.getRecentTransactions();
        assertEquals(ar.size(), result.size());
    }
    
    
    //Testiranje metodeCalculatePrice
    @Test
    public void testCalculatePrice() {
        System.out.println("calculatePrice");
       
        float distance = 2F;
        int amount = 1;
        
        
        TransactionService instance = new TransactionService(sis);
        float expResult = 0.0F;
        float result = instance.calculatePrice(si, distance, amount, ds);
        assertEquals(expResult, result, 0.1);
    }
    
    
    
}

//16/84