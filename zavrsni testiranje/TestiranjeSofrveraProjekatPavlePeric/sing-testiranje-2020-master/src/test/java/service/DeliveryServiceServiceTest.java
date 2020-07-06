/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.DeliveryService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Pavle
 */
public class DeliveryServiceServiceTest {
    
    public DeliveryServiceServiceTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    
    //Testiranje metode register
    @Test
    public void testRegister() {
        System.out.println("register");
        String name = "";
        float pricePerKilometer = 5F;
        float startingPrice = 5F;
        DeliveryServiceService instance = new DeliveryServiceService();
        boolean expResult = false;
        boolean result = instance.register(name, pricePerKilometer, startingPrice);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRegister2() {
        System.out.println("register");
        String name = "peraMotors";
        float pricePerKilometer = 0.0F;
        float startingPrice = 5F;
        DeliveryServiceService instance = new DeliveryServiceService();
        boolean expResult = false;
        boolean result = instance.register(name, pricePerKilometer, startingPrice);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRegister3() {
        System.out.println("register");
        String name = "peraMotors";
        float pricePerKilometer = 5F;
        float startingPrice = 0.0F;
        DeliveryServiceService instance = new DeliveryServiceService();
        boolean expResult = false;
        boolean result = instance.register(name, pricePerKilometer, startingPrice);
        assertEquals(expResult, result);
    }
    
    //Bug
    @Test
    public void testRegister4() {
        System.out.println("register");
        String name = "peraMotors";
        float pricePerKilometer = 5F;
        float startingPrice = 10F;
        DeliveryServiceService instance = new DeliveryServiceService();
        boolean expResult = true;
        boolean result = instance.register(name, pricePerKilometer, startingPrice);
        assertEquals(expResult, result);
    }
    
    //Kraj testiranja metode register
    
    
    //Testiranje metode DeleteDeliveryService
    @Test
    public void testDeleteDeliveryService() {
        System.out.println("deleteDeliveryService");
        DeliveryService d = new DeliveryService(1, "peraMotors", 5, 10);
        
        DeliveryServiceService instance = new DeliveryServiceService();
        boolean expResult = true;
        boolean result = instance.deleteDeliveryService(d);
        assertEquals(expResult, result);
    }
    
    //Bug
    @Test
    public void testDeleteDeliveryService2() {
        System.out.println("deleteDeliveryService");
        DeliveryService d = new DeliveryService(3, "peraMotorss", 5, 10);
        
        DeliveryServiceService instance = new DeliveryServiceService();
        boolean expResult = false;
        boolean result = instance.deleteDeliveryService(d);
        assertEquals(expResult, result);
    }
    
    //Kraj testiranja metode deleteDeliveryService
    
    
    //Testiranje metode updateInfo
    @Test
    public void testUpdateInfo() {
        System.out.println("updateInfo");
        DeliveryService d = new DeliveryService(2, "peraMotors", 5, 10);
        String name = "pMotors";
        float startingPrice =10F;
        float pricePerKilometer = 15F;
        DeliveryServiceService instance = new DeliveryServiceService();
        boolean expResult = true;
        boolean result = instance.updateInfo(d, name, startingPrice, pricePerKilometer);
        assertEquals(expResult, result);
    }
    
    
    //Bug
    @Test
    public void testUpdateInfo2() {
        System.out.println("updateInfo");
        DeliveryService d = new DeliveryService(5, "peraMotors", 5, 10);
        String name = "pMotors";
        float startingPrice =10F;
        float pricePerKilometer = 15F;
        DeliveryServiceService instance = new DeliveryServiceService();
        boolean expResult = true;
        boolean result = instance.updateInfo(d, name, startingPrice, pricePerKilometer);
        assertEquals(expResult, result);
    }


    @Test
    public void testUpdateInfo3() {
        System.out.println("updateInfo");
        DeliveryService d = new DeliveryService(null, "peraMotors", 5, 10);
        String name = "pMotors";
        float startingPrice =10F;
        float pricePerKilometer = 15F;
        DeliveryServiceService instance = new DeliveryServiceService();
        boolean expResult = false;
        boolean result = instance.updateInfo(d, name, startingPrice, pricePerKilometer);
        assertEquals(expResult, result);
    }
    
    //Kraj testiranja metode updateInfo
}


//89/11