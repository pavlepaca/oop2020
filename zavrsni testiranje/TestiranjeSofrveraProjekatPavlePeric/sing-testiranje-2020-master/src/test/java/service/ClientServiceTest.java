/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.Client;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Pavle
 */
public class ClientServiceTest {
        
    
    
    public ClientServiceTest() {
    }
    
    @Before
    public void setUp() {
       
    }
    
    @After
    public void tearDown() {
    }

    
    //Test metode login
    
    @Test
    public void testLogin() {
        System.out.println("login");
        String username = "paca98";
        String password = "paca98";
        ClientService instance = new ClientService();
        Class<Client> c1 = Client.class;
        Client result = instance.login(username, password);
        System.out.println(result.getName());
        assertEquals(c1, result.getClass());
    }
    
    //Bug
    @Test(expected = java.lang.NullPointerException.class)
    public void testLogin2() {
        System.out.println("login");
        String username = "paca988";
        String password = "paca98";
        ClientService instance = new ClientService();
        Class<Client> c1 = Client.class;
        Client result = instance.login(username, password);
        System.out.println(result.getName());
        assertEquals(c1, result.getClass());
    }
    
    //Bug
    @Test(expected = java.lang.NullPointerException.class)
    public void testLogin3() {
        System.out.println("login");
        String username = "paca98";
        String password = "paca988";
        ClientService instance = new ClientService();
        Class<Client> c1 = Client.class;
        Client result = instance.login(username, password);
        System.out.println(result.getName());
        assertEquals(c1, result.getClass());
    }
    
    @Test(expected = java.lang.NullPointerException.class)
    public void testLogin4() {
        System.out.println("login");
        String username = "paca988";
        String password = "paca988";
        ClientService instance = new ClientService();
        Class<Client> c1 = Client.class;
        Client result = instance.login(username, password);
        System.out.println(result.getName());
        assertEquals(c1, result.getClass());
    }
    
    
    //Kraj testiranja metode login
    
    
    
    //Test metode register
    @Test
    public void testRegister() {
        System.out.println("register");
        String name = "paca98";
        String username = "paca98";
        String password = "paca98";
        ClientService instance = new ClientService();
        boolean expResult = true;
        boolean result = instance.register(name, username, password);
        assertEquals(expResult, result);  
    }
    
    
    //Bug
    @Test
    public void testRegister2() {
        System.out.println("register");
        String name = "";
        String username = "paca988";
        String password = "paca988";
        ClientService instance = new ClientService();
        boolean expResult = false;
        boolean result = instance.register(name, username, password);
        assertEquals(expResult, result);  
    }
    
   
    //Kraj testiranja metode register
    
    
    //Testiranje metode deleteUser
    @Test
    public void testDeleteUser() {
        System.out.println("deleteUser");
        Client c = new Client(4, "", "paca988", "paca988");
        ClientService instance = new ClientService();
        boolean expResult = true;
        boolean result = instance.deleteUser(c);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDeleteUser2() {
        System.out.println("deleteUser");
        Client c = new Client(3, "asdasd", "paca988", "paca988");
        ClientService instance = new ClientService();
        boolean expResult = false;
        boolean result = instance.deleteUser(c);
        assertEquals(expResult, result);
    }
    
    
    //Kraj testiranja metode deleteUser
    
    
    //Bug
    //Testiranje metode updateInfo
    @Test
    public void testUpdateInfo() {
        System.out.println("updateInfo");
        Client c = new Client(3, "paca98", "paca98", "paca98");
        
        String name = "paca";
        String oldPassword = "paca98";
        String password = "b";
        ClientService instance = new ClientService();
        instance.updateInfo(c, name, oldPassword, password);
    }
    
    @Test
    public void testUpdateInfo2() {
        System.out.println("updateInfo");
        Client c = new Client(39, "basdasda", "paca99", "b");
        
        String name = "paca";
        String oldPassword = "b";
        String password = "ba";
        ClientService instance = new ClientService();
        instance.updateInfo(c, name, oldPassword, password);
    }
    
}

//60/40
